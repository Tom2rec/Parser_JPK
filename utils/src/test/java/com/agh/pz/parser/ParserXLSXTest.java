package com.agh.pz.parser;

import com.agh.pz.jpk.entity.Address;
import com.agh.pz.jpk.entity.Entity;
import com.agh.pz.jpk.entity.EntityId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParserXLSXTest {

        Entity entity;
        ParserXLSX parserXLSX;
        String path = "/home/tturek/Documents/personal/UST/PZ/Parser/main/src/main/resources/faktury-sprzedazowe-test.xlsx";


        @Before
        public void start(){
            var entityId = new EntityId("6762484560", "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ");

            var address = new Address("PL", "małopolskie", "m. Kraków", "Kraków",
                    "ul. Feliksa Radwańskiego", 15, 1, "Kraków", "30-365" );

            entity = new Entity(entityId,address);
            parserXLSX = new ParserXLSX(path,entity);
        }

        @Test
        public void parseTest(){
            parserXLSX.parse();
            Assert.assertEquals(108, parserXLSX.getInvoiceRowControl().getNumber());
        }
}
