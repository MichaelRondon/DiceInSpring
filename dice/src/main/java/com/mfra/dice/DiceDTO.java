/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mfra.dice;

import lombok.Data;

/**
 *
 * @author acost
 */
@Data
public class DiceDTO {

    private Integer modifier;

    private Integer repetitions;

    private Integer faces;

    private String name;
    
}
