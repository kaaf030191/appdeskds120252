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

    public boolean insert(String firstName, String surName, boolean gender, String birthDate) throws ParseException, SQLException {
        RepoPerson repoPerson = new QPerson();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        this.dtoPerson.setIdPerson(UUID.randomUUID().toString());
        this.dtoPerson.setCreatedAt(new Date());
        this.dtoPerson.setUpdatedAt(new Date());

        this.dtoPerson.setFirstName(firstName);
        this.dtoPerson.setSurName(surName);
        this.dtoPerson.setGender(gender);
        this.dtoPerson.setBirthDate(sdf.parse(birthDate));

        return repoPerson.insert(dtoPerson) > 0;
    }

    public List<DtoPerson> getAll() throws SQLException {
        RepoPerson repoPerson = new QPerson();

        return repoPerson.getAll();
    }
}
