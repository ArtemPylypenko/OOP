package org.example.XML;

import org.example.deposits.Deposit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLReadDOM {
    public static ArrayList<Deposit> read(String filename) throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Deposit> depositArrayList = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(filename));

        Element element = document.getDocumentElement();
        NodeList list = element.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            if (list.item(i) instanceof Element) {
                if (((Element) list.item(i)).getTagName().equals("deposit")) {
                    NodeList depositFields = list.item(i).getChildNodes();
                    ArrayList<String> fields = new ArrayList<>();
                    for (int j = 0; j < depositFields.getLength(); j++) {
                        if (depositFields.item(j) instanceof Element) {
                            fields.add(((Element) depositFields.item(j)).getTextContent());
                        }
                    }
                    Deposit deposit = new Deposit(fields.get(0),fields.get(1),fields.get(2),fields.get(3),fields.get(4),
                            fields.get(5),fields.get(6),fields.get(7));
                    depositArrayList.add(deposit);
                }
            }
        }
        return depositArrayList;
    }
}
