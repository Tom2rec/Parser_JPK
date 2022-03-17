package com.agh.pz.parser;

import com.agh.pz.jpk.entity.Address;
import com.agh.pz.jpk.entity.Entity;
import com.agh.pz.jpk.entity.EntityId;
import com.agh.pz.jpk.invoice.Invoice;
import com.agh.pz.jpk.invoiceRow.InvoiceRow;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {
    String path = "path";
    Parser parser;



    @Before
    public void create(){
        var entityId = new EntityId("6762484560", "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ");

        var address = new Address("PL", "małopolskie", "m. Kraków", "Kraków",
                "ul. Feliksa Radwańskiego", 15, 1, "Kraków", "30-365" );

        Entity entity = new Entity(entityId,address);
        parser  = new ParserCSV(path,entity);
    }

    @Test
    public void ParserConstructorTest(){
        Assert.assertEquals("path", parser.getPath());
        Assert.assertEquals("Kraków",parser.getEntity().getAddress().getCity());
    }

    @Test
    public void toMoneyFormatTest(){
        String expected = "0.12";
        Assert.assertEquals(expected, parser.toMoneyFormat("0,\u00A012 zł"));
    }

    @Test
    public void prepareInvoiceTest(){
        List<Invoice> invoices = new ArrayList<>();
        var x = new Invoice();
        x.setP15("12");
        x.setP131("12");
        invoices.add(x);
        var x2 = new Invoice();
        x2.setP15("13");
        x2.setP131("13");
        invoices.add(x2);

        Assert.assertEquals("null-ADDRESS",parser.prepareInvoice(invoices).get(0).getP3b());

    }

    @Test
    public void prepareInvoiceRowTest(){
        List<InvoiceRow> invoiceRows = new ArrayList<>();
        var x = new InvoiceRow();
        x.setP9a("12");
        x.setP12(12);
        x.setP11("12");
        invoiceRows.add(x);
        var x2 = new InvoiceRow();
        x2.setP9a("12");
        x2.setP12(12);
        x2.setP11("12");
        invoiceRows.add(x2);


        Assert.assertEquals("12",parser.prepareInvoiceRow(invoiceRows).get(0).getP9a());

    }

}
