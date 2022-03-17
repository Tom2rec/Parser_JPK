package com.agh.pz.exporter;

import com.agh.pz.jpk.JPK;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

/**
 * Class for exporting pojo to xml
 */
public class ExporterXML {

    private ExporterXML() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Method to marshal JPK to XML
     * @param jpk main object for jpk type of document
     * @param path to file
     * @throws JAXBException
     */

    public static void marshal( JPK jpk, String path) throws JAXBException {
        var context = JAXBContext.newInstance(JPK.class);
        var mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(jpk, new File(path));
    }


}
