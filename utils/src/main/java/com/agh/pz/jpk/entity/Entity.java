package com.agh.pz.jpk.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * POJO Class for entity
 */
@XmlRootElement(name = "Podmiot1")
@XmlAccessorType(XmlAccessType.FIELD)
public class Entity {

    @XmlElement(name = "IdentyfikatorPodmiotu", namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
    private EntityId entityId;

    @XmlElement(name = "AdresPodmiotu", namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
    private Address address;

    public Entity() {}

    public Entity(EntityId entityId, Address address) {
        this.entityId = entityId;
        this.address = address;
    }

    public EntityId getEntityId() {
        return entityId;
    }

    public void setEntityId(EntityId entityId) {
        this.entityId = entityId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
