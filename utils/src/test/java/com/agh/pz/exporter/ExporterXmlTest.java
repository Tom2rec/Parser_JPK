package com.agh.pz.exporter;

import com.agh.pz.jpk.JPK;
import jakarta.xml.bind.JAXBException;
import org.junit.Assert;
import org.junit.Test;

public class ExporterXmlTest {

    @Test
    public void marshalTest() throws JAXBException {
        JPK jpk = new JPK();
        String path = "path";
        ExporterXML.marshal(jpk,path);
    }

}
