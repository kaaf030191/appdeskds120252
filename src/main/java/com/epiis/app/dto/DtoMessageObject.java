/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epiis.app.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KAAF0
 */
public class DtoMessageObject {
    private String type;
    public List<String> listMessage;
    
    public DtoMessageObject() {
        this.type = "error";
        this.listMessage = new ArrayList<>();
    }
    
    public String getType() {
        return this.type;
    }
    
    public void success() {
        this.type = "success";
    }
    
    public void warning() {
        this.type = "warning";
    }
    
    public void error() {
        this.type = "error";
    }
    
    public void exception() {
        this.type = "exception";
    }
}
