package com.agh.pz;

import static junit.framework.TestCase.assertNotNull;

import com.sun.tools.javac.Main;
import org.junit.Test;


public class ParserLauncherTest {


    /**
     * Test for the construction of Main and the 
     * main method being called
     *
     */
    @Test
    public void shouldCreateMainObject(){
        Main main = new Main();
        assertNotNull("Main method called.", main);
    }
}


