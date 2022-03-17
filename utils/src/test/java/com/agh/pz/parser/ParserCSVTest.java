package com.agh.pz.parser;

import com.agh.pz.jpk.entity.Address;
import com.agh.pz.jpk.entity.Entity;
import com.agh.pz.jpk.entity.EntityId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParserCSVTest {



    Entity entity;
    ParserCSV parserCSV;
    String path = "/home/tturek/Documents/personal/UST/PZ/Parser/main/src/main/resources/faktury-sprzedazowe-test.csv";


    @Before
    public void start(){
        var entityId = new EntityId("6762484560", "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ");

        var address = new Address("PL", "małopolskie", "m. Kraków", "Kraków",
                "ul. Feliksa Radwańskiego", 15, 1, "Kraków", "30-365" );

        entity = new Entity(entityId,address);
        parserCSV = new ParserCSV(path,entity);
    }

    @Test
    public void parseTest(){
        parserCSV.parse();
        Assert.assertEquals(108, parserCSV.getInvoiceRowControl().getNumber());
    }


}


