package org.example.XML;

import org.example.deposits.Deposit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class XMLCreateDOM {
    public static void create(ArrayList<Deposit> deposits, String filename) throws ParserConfigurationException, TransformerException, FileNotFoundException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.newDocument();
        Element bank = document.createElement("Bank");

        for (Deposit d : deposits) {
            Element deposit = document.createElement("deposit");

            deposit.setAttribute("id", String.valueOf(d.getAccountId()));

            Element name = document.createElement("name");
            Text nameText = document.createTextNode(d.getName());
            name.appendChild(nameText);
            deposit.appendChild(name);

            Element country = document.createElement("country");
            Text countryText = document.createTextNode(d.getCountry());
            country.appendChild(countryText);
            deposit.appendChild(country);

            Element type = document.createElement("type");
            Text typeText = document.createTextNode(d.getType().name());
            type.appendChild(typeText);
            deposit.appendChild(type);

            Element depositor = document.createElement("depositor");
            Text depositorText = document.createTextNode(d.getDepositor());
            depositor.appendChild(depositorText);
            deposit.appendChild(depositor);

            Element accountId = document.createElement("accountId");
            Text accountIdText = document.createTextNode(String.valueOf(d.getAccountId()));
            accountId.appendChild(accountIdText);
            deposit.appendChild(accountId);

            Element amountOnDeposit = document.createElement("amountOnDeposit");
            Text amountOnDepositText = document.createTextNode(String.valueOf(d.getAmountOnDeposit()));
            amountOnDeposit.appendChild(amountOnDepositText);
            deposit.appendChild(amountOnDeposit);

            Element profitability = document.createElement("profitability");
            Text profitabilityText = document.createTextNode(String.valueOf(d.getProfitability()));
            profitability.appendChild(profitabilityText);
            deposit.appendChild(profitability);

            Element timeConstraints = document.createElement("timeConstraints");
            Text timeConstraintsText = document.createTextNode(String.valueOf(d.getTimeConstraints()));
            timeConstraints.appendChild(timeConstraintsText);
            deposit.appendChild(timeConstraints);

            bank.appendChild(deposit);
        }
        document.appendChild(bank);

        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT,"yes");
        t.transform(new DOMSource(document),new StreamResult(new FileOutputStream(filename)));

    }

}
