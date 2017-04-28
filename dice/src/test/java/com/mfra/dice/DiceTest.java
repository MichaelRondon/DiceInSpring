package com.mfra.dice;


import com.mfra.dice.Dice;
import org.junit.Test;
import org.springframework.util.Assert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author acost
 */
public class DiceTest {

    @Test
    public void testDiceClass() {
        Dice dice = Dice.getInstance().roll();
        int lastValue = dice.getLastValue();
        Assert.isTrue(lastValue > 0 && lastValue < 7, "");
        System.out.println(dice);
        dice.setFaces(20);
        lastValue = dice.roll().getLastValue();
        Assert.isTrue(lastValue > 0 && lastValue < 21, "");
        System.out.println(dice);
        dice.setRepetitions(2);
        lastValue = dice.roll().getLastValue();
        Assert.isTrue(lastValue > 1 && lastValue < 41, "");
        System.out.println(dice);
        dice.setModifier(2);
        lastValue = dice.roll().getLastValue();
        Assert.isTrue(lastValue > 3 && lastValue < 43, "");
        System.out.println(dice);
    }
}
