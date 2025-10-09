/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epiis.app.dataaccess.query;

import com.epiis.app.dataaccess.entity.EntityPerson;
import com.epiis.app.dto.DtoPerson;
import com.epiis.app.main.DataBaseContext;
import com.epiis.app.repository.RepoPerson;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KAAF0
 */
public class QPerson implements RepoPerson {

    private DataBaseContext dbc = null;
    private EntityPerson entityPerson = null;
    private List<EntityPerson> listPerson = null;
    private List<DtoPerson> listDtoPerson = null;
    private String script = null;
    private int rowsQuantityAfected = 0;

    @Override
    public int insert(DtoPerson dtoPerson) throws SQLException {
        this.dbc = new DataBaseContext();

        this.script = "insert into tperson values(?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = this.dbc.connection.prepareStatement(this.script);
        
        entityPerson = new EntityPerson();

        entityPerson.setIdPerson(dtoPerson.getIdPerson());
        entityPerson.setFirstName(dtoPerson.getFirstName());
        entityPerson.setSurName(dtoPerson.getSurName());
        entityPerson.setGender(dtoPerson.isGender());
        entityPerson.setBirthDate(dtoPerson.getBirthDate());
        entityPerson.setCreatedAt(dtoPerson.getCreatedAt());
        entityPerson.setUpdatedAt(dtoPerson.getUpdatedAt());

        ps.setString(1, entityPerson.getIdPerson());
        ps.setString(2, entityPerson.getFirstName());
        ps.setString(3, entityPerson.getSurName());
        ps.setBoolean(4, entityPerson.isGender());
        ps.setDate(5, new java.sql.Date(entityPerson.getBirthDate().getTime()));
        ps.setTimestamp(6, new java.sql.Timestamp(entityPerson.getCreatedAt().getTime()));
        ps.setTimestamp(7, new java.sql.Timestamp(entityPerson.getUpdatedAt().getTime()));

        this.rowsQuantityAfected = ps.executeUpdate();

        this.dbc.connection.close();

        return rowsQuantityAfected;
    }

    @Override
    public List<DtoPerson> getAll() throws SQLException {
        this.dbc = new DataBaseContext();

        this.listPerson = new ArrayList<>();
        this.listDtoPerson = new ArrayList<>();

        this.script = "select * from tperson";

        PreparedStatement ps = this.dbc.connection.prepareStatement(this.script);

        ResultSet rows = ps.executeQuery();

        while (rows.next()) {
            EntityPerson personTemp = new EntityPerson();

            personTemp.setIdPerson(rows.getString("idPerson"));
            personTemp.setFirstName(rows.getString("firstName"));
            personTemp.setSurName(rows.getString("surName"));
            personTemp.setGender(rows.getBoolean("gender"));
            personTemp.setBirthDate(rows.getDate("birthDate"));
            personTemp.setCreatedAt(rows.getTimestamp("createdAt"));
            personTemp.setUpdatedAt(rows.getTimestamp("updatedAt"));

            this.listPerson.add(personTemp);
        }
        
        for(EntityPerson item: this.listPerson) {
            DtoPerson dtoPersonTemp = new DtoPerson();

            dtoPersonTemp.setIdPerson(item.getIdPerson());
            dtoPersonTemp.setFirstName(item.getFirstName());
            dtoPersonTemp.setSurName(item.getSurName());
            dtoPersonTemp.setGender(item.isGender());
            dtoPersonTemp.setBirthDate(item.getBirthDate());
            dtoPersonTemp.setCreatedAt(item.getCreatedAt());
            dtoPersonTemp.setUpdatedAt(item.getUpdatedAt());

            this.listDtoPerson.add(dtoPersonTemp);
        }

        this.dbc.connection.close();

        return this.listDtoPerson;
    }
}
