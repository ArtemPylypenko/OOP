package org.example.XSD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XSDValidatorTest {

    @Test
    void validate() {
        XSDValidator validator = new XSDValidator();
        assertTrue(validator.validate("test.xml", "schema.xsd"));
        assertTrue(validator.validate("temp.xml", "schema.xsd"));
    }
}