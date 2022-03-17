package com.agh.pz.jpk.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * POJO Class for entity id
 */
@XmlRootElement(name = "identyfikatorPodmiotu")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntityId {

    @XmlElement(namespace = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/", name = "NIP")
    private String nip;

    @XmlElement(namespace = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/", name = "PelnaNazwa")
    private String fullName;

    EntityId() {}

    public EntityId(String nip, String fullName) {
        this.nip = nip;
        this.fullName = fullName;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
