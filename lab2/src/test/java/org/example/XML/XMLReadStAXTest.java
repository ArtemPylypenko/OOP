package org.example.XML;

import org.example.deposits.Deposit;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class XMLReadStAXTest {

    @Test
    void read() throws XMLStreamException, ParserConfigurationException, IOException, SAXException, TransformerException {
        ArrayList<Deposit> deposits = new ArrayList<>();
        Deposit dep1 = new Deposit("dep1","dep1","urgent","dep1",
                "1","1","1","1");
        Deposit dep2 = new Deposit("dep2","dep2","urgent","dep2",
                "2","2","2","2");
        Deposit dep3 = new Deposit("dep3","dep3","urgent","dep3",
                "3","3","3","3");
        deposits.add(dep1);
        deposits.add(dep2);
        deposits.add(dep3);
        XMLCreateDOM.create(deposits,"test.xml");
        assertEquals(Arrays.toString(deposits.toArray()), Arrays.toString(XMLReadStAX.read("test.xml").toArray()));
    }
}