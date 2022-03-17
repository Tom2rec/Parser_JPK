package com.agh.pz.jpk.header;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * POJO Class for header form code
 */
@XmlRootElement(name = "KodFormularza")
public class FormCode {

    @XmlAttribute(name = "kodSystemowy")
    private String systemCode;

    @XmlAttribute(name = "wersjaSchemy")
    private String schemaVersion;

    @XmlValue
    private String value;

    public FormCode() {}

    public FormCode(String systemCode, String schemaVersion, String value) {
        this.systemCode = systemCode;
        this.schemaVersion = schemaVersion;
        this.value = value;
    }
}
