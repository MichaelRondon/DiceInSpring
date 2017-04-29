/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mfra.dice.rest;

import com.mfra.dice.model.Dice;
import com.mfra.dice.model.DiceDTO;
import com.mfra.dice.model.DiceResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acost
 */
@RestController
@RequestMapping("/app")
public class DiceController {

    @RequestMapping(value = "/dice", method = RequestMethod.POST)
    public ResponseEntity<DiceResponseDTO> greeting(@RequestBody DiceDTO diceDTO) {
        return new ResponseEntity(new DiceResponseDTO(Dice.getInstance().roll(diceDTO)), HttpStatus.OK);
    }

}
