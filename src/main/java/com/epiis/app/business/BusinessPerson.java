/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epiis.app.business;

import com.epiis.app.dataaccess.query.QPerson;
import com.epiis.app.dto.DtoMessageObject;
import com.epiis.app.dto.DtoPerson;
import com.epiis.app.repository.RepoPerson;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author KAAF0
 */
public class BusinessPerson {

    DtoMessageObject mo = null;
    DtoPerson dtoPerson = null;

    public BusinessPerson() {
        this.dtoPerson = new DtoPerson();
    }

    public DtoMessageObject insert(String firstName, String surName, boolean gender, Date birthDate) {
        try {
            this.mo = new DtoMessageObject();
            
            RepoPerson repoPerson = new QPerson();

            if(firstName.isBlank() || surName.isBlank() || birthDate == null) {
                this.mo.listMessage.add("Complete todos los datos faltantes.");
                
                return this.mo;
            }

            this.dtoPerson.setIdPerson(UUID.randomUUID().toString());
            this.dtoPerson.setCreatedAt(new Date());
            this.dtoPerson.setUpdatedAt(this.dtoPerson.getCreatedAt());

            this.dtoPerson.setFirstName(firstName);
            this.dtoPerson.setSurName(surName);
            this.dtoPerson.setGender(gender);
            this.dtoPerson.setBirthDate(birthDate);
            
            repoPerson.insert(dtoPerson);

            this.mo.success();
            this.mo.listMessage.add("Operación realizada correctamente.");
        } catch (SQLException ex) {
            this.mo.exception();
            
            this.mo.listMessage.add("Algo salio mal, estamos trabajando para solucionarlo, agradecemos supaciencia.");
            this.mo.listMessage.add(ex.getMessage());
        }
        
        return this.mo;
    }

    public List<DtoPerson> getAll() throws SQLException {
        RepoPerson repoPerson = new QPerson();

        return repoPerson.getAll();
    }
}
