package com.agh.pz.launcher;

import com.agh.pz.exporter.ExporterXML;
import com.agh.pz.jpk.JPK;
import com.agh.pz.jpk.entity.Address;
import com.agh.pz.jpk.entity.Entity;
import com.agh.pz.jpk.entity.EntityId;
import com.agh.pz.jpk.header.FormCode;
import com.agh.pz.jpk.header.Header;
import com.agh.pz.parser.Parser;
import com.agh.pz.parser.ParserCSV;
import com.agh.pz.parser.ParserXLSX;
import jakarta.xml.bind.JAXBException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Main class to launch parser
 */

public class ParserLauncher {
    private static final Logger logger = LogManager.getLogger(ParserLauncher.class);

    public static void main(String[] args){

        var entity = createEntity();

        var jpk = new JPK(createHeader(), entity, parseFile(createPath(args[0]), entity));

        try {
            ExporterXML.marshal(jpk, createPath(args[1]));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to parse file
     * @param path path to file
     * @param entity entity for which we generate file
     * @return proper parsere XLSX or CSV
     */

    private static Parser parseFile(String path, Entity entity) {
        Parser parser;
        if(getExtension(path).equals("csv")){
            parser = new ParserCSV(path, entity);
            parser.parse();
            return parser;
        }
        if(getExtension(path).equals("xlsx")){
            parser = new ParserXLSX(path, entity);
            parser.parse();
            return parser;
        }
        logger.info("Invalid extension, use: csv or xlsx");
        return null;
    }

    /**
     * Get .xslx or .csv from file path
     * @param path to file
     * @return extension
     */

    private static String getExtension(String path) {
        return path.substring(path.lastIndexOf(".")+1);
    }

    /**
     * Create header for jpk type of document
     * @return Header
     */

    private static Header createHeader(){
        var dateTime = LocalDateTime.now();
        var dateFrom = LocalDate.parse("2020-10-01");
        var dateTo = LocalDate.parse("2020-12-31");

        return new Header(new FormCode("JPK_FA (3)", "1-0", "JPK_FA"),
                "3","1",dateTime,dateFrom,dateTo, 1208);
    }

    /**
     * Create for which we generate file
     * @return Entity
     */

    private static Entity createEntity(){
        var entityId = new EntityId("6762484560", "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ");

        var address = new Address("PL", "małopolskie", "m. Kraków", "Kraków",
                "ul. Feliksa Radwańskiego", 15, 1, "Kraków", "30-365" );

        return new Entity(entityId,address);
    }

    /**
     * Create needed path for file
     * @param file
     * @return path
     */

    private static String createPath(String file){
        String dir = System.getProperty("user.dir");
        return dir + "/main/src/main/resources/" + file;
    }

}

