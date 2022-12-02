package org.example.XML;

import org.example.deposits.Deposit;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLReadSAX {
    private static Deposit deposit = new Deposit();
    static String thisElement = "";

    private static ArrayList<Deposit> deposits ;


    public static ArrayList<Deposit> read(String filename) throws ParserConfigurationException, SAXException, IOException {
        deposits = new ArrayList<>();
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startDocument() {
                System.out.println("Start parse XML...");
            }

            @Override
            public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
                thisElement = qName;
                if(thisElement.equals("deposit")){
                    deposit.setAccountId(atts.getValue("id"));
                }
            }

            @Override
            public void endElement(String namespaceURI, String localName, String qName) {
                thisElement = "";
            }

            @Override
            public void characters(char[] ch, int start, int length) {

                if(thisElement.equals("name")){
                    deposit.setName(new String(ch, start, length));
                }
                if(thisElement.equals("country")){
                    deposit.setCountry(new String(ch, start, length));
                }
                if(thisElement.equals("type")){
                    deposit.setType(new String(ch, start, length));
                }
                if(thisElement.equals("depositor")){
                    deposit.setDepositor(new String(ch, start, length));
                }
                if(thisElement.equals("accountId")){
                    deposit.setAccountId(new String(ch, start, length));
                }
                if(thisElement.equals("amountOnDeposit")){
                    deposit.setAmountOnDeposit(new String(ch, start, length));
                }
                if(thisElement.equals("profitability")){
                    deposit.setProfitability(new String(ch, start, length));
                }
                if(thisElement.equals("timeConstraints")){
                    deposit.setTimeConstraints(new String(ch, start, length));
                    deposits.add(deposit);
                    deposit = new Deposit();
                }
            }

        };
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File(filename), handler);



        return deposits;
    }
}
