package org.example.XML;

import org.example.deposits.Deposit;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class XMLReadStAX {
    private static Deposit deposit = new Deposit();
    static String thisElement = "";

    private static ArrayList<Deposit> deposits;


    public static ArrayList<Deposit> read(String filename) throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
        deposits = new ArrayList<>();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = factory.createXMLStreamReader(new FileInputStream(filename));

        while (parser.hasNext()) {
            int event = parser.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                thisElement = parser.getLocalName();
                if (thisElement.equals("deposit")) {
                    deposit.setAccountId(parser.getAttributeValue(0));
                    continue;
                }
                if (thisElement.equals("name")) {
                    deposit.setName(parser.getElementText());
                }
                if (thisElement.equals("country")) {
                    deposit.setCountry(parser.getElementText());
                }
                if (thisElement.equals("type")) {
                    deposit.setType(parser.getElementText());
                }
                if (thisElement.equals("depositor")) {
                    deposit.setDepositor(parser.getElementText());
                }
                if (thisElement.equals("accountId")) {
                    deposit.setAccountId(parser.getElementText());
                }
                if (thisElement.equals("amountOnDeposit")) {
                    deposit.setAmountOnDeposit(parser.getElementText());
                }
                if (thisElement.equals("profitability")) {
                    deposit.setProfitability(parser.getElementText());
                }
                if (thisElement.equals("timeConstraints")) {
                    deposit.setTimeConstraints(parser.getElementText());
                    deposits.add(deposit);
                    deposit = new Deposit();
                }
            }
        }


        return deposits;
    }
}
