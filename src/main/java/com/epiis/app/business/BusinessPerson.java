/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epiis.app.business;

import com.epiis.app.dataaccess.query.QPerson;
import com.epiis.app.dto.DtoPerson;
import com.epiis.app.repository.RepoPerson;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author KAAF0
 */
public class BusinessPerson {

    DtoPerson dtoPerson = null;

    public BusinessPerson() {
        this.dtoPerson = new DtoPerson();
    }

    public boolean insert(String firstName, String surName, boolean gender, Date birthDate) throws ParseException, SQLException {
        RepoPerson repoPerson = new QPerson();
        
        if(firstName.isBlank() || surName.isBlank() || birthDate == null) {
            return false;
        }

        this.dtoPerson.setIdPerson(UUID.randomUUID().toString());
        this.dtoPerson.setCreatedAt(new Date());
        this.dtoPerson.setUpdatedAt(this.dtoPerson.getCreatedAt());

        this.dtoPerson.setFirstName(firstName);
        this.dtoPerson.setSurName(surName);
        this.dtoPerson.setGender(gender);
        this.dtoPerson.setBirthDate(birthDate);

        return repoPerson.insert(dtoPerson) > 0;
    }

    public List<DtoPerson> getAll() throws SQLException {
        RepoPerson repoPerson = new QPerson();

        return repoPerson.getAll();
    }
}
