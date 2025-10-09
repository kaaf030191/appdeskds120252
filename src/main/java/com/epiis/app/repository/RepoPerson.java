/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epiis.app.repository;

import com.epiis.app.dto.DtoPerson;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author KAAF0
 */
public interface RepoPerson {
    int insert(DtoPerson dtoPerson) throws SQLException;
    List<DtoPerson> getAll() throws SQLException;
}
