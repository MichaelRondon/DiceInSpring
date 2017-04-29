/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mfra.dice.util;

import java.util.Objects;

/**
 *
 * @author acost
 */
public class DataUtil {

    private DataUtil() {

    }

    public static <E> E ifNull(E eval, E default_) {
        return Objects.isNull(eval) ? default_ : eval;
    }
}
