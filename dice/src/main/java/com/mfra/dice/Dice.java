/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mfra.dice;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import lombok.Getter;

/**
 *
 * @author acost
 */
public class Dice {

    private static final int DEFAULT_MODIFIER = 0;
    private static final int DEFAULT_REPETITIONS = 1;
    private static final int DEFAULT_FACES = 6;

    @Getter
    private int modifier = DEFAULT_MODIFIER;

    @Getter
    private int repetitions = DEFAULT_REPETITIONS;

    @Getter
    private int faces = DEFAULT_FACES;

    @Getter
    private String name;

    @Getter
    private int lastValue;

    private StringBuilder stringBuilder;

    private final Random random = new Random();

    /**
     * @param faces
     */
    private Dice() {
    }

    public static Dice getInstance() {
        return new Dice();
    }

    public Dice setModifier(int modifier) {
        this.modifier = modifier;
        return this;
    }

    public Dice setRepetitions(int repetitions) {
        this.repetitions = repetitions;
        return this;
    }

    public Dice setFaces(int faces) {
        this.faces = faces;
        return this;
    }

    public Dice setName(String name) {
        this.name = name;
        return this;
    }

    public Dice roll(DiceDTO diceDTO) {
        this.faces = diceDTO.getFaces();
        this.repetitions = diceDTO.getRepetitions();
        this.modifier = diceDTO.getModifier();
        this.name = diceDTO.getName();
        return roll();
    }

    /**
     * @return
     */
    public Dice roll() {
        List<Integer> results = new LinkedList<>();
        for (int i = 0; i < repetitions; i++) {
            results.add(this.baseRoll());
        }
        String collect = results.stream().map(integer -> integer.toString()).collect(Collectors.joining(" - "));
        this.lastValue = results.parallelStream().mapToInt(Integer::intValue).sum() + modifier;

        this.stringBuilder = new StringBuilder();
        this.stringBuilder.append(Objects.nonNull(name) ? String.format("%s rolls a ", name) : "Rolls a ");
        this.stringBuilder.append((DEFAULT_FACES != faces) ? String.format("dice of %d faces ", faces) : "dice ");
        this.stringBuilder.append((DEFAULT_REPETITIONS != repetitions) ? String.format("%d times ", repetitions) : "");
        this.stringBuilder.append((DEFAULT_MODIFIER != modifier) ? String.format("and sums %d %n", modifier) : "\n");

        this.stringBuilder.append((repetitions != 1)
                ? String.format("The result were: %s. Total: %d.", collect, this.lastValue)
                : String.format("The result were: %d.", this.lastValue));
        return this;
    }

    @Override
    public String toString() {
        return Objects.isNull(this.stringBuilder) ? "" : this.stringBuilder.toString();
    }

    /**
     * @return random.nextInt(faces)+1
     */
    private int baseRoll() {
        return this.random.nextInt(this.faces) + 1;
    }

//    /**
//     *
//     * @param expression
//     * @return IDice object with the result of the dice roll.
//     */
//    public static Dice getDice(String expression) {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("The expression is incorrect: ");
//        stringBuilder.append(expression);
//        try {
//            if (expression != null) {
//                return readExpression(expression);
//
//            } else {
//                throw new GeneralException(stringBuilder.toString());
//            }
//        } catch (NumberFormatException e) {
//            throw new GeneralException(stringBuilder.toString());
//        } catch (NoSuchElementException e) {
//            throw new GeneralException(stringBuilder.toString());
//        }
//    }
//
//    private static Dice readExpression(String expression) {
//        Integer repetitions = 1;
//        Integer modifier = 0;
//        int faces = 1;
//        expression = expression.toUpperCase();
//        StringTokenizer stringTokenizer = new StringTokenizer(expression, "D");
//        String nextToken;
//        if (stringTokenizer.countTokens() == 2) {
//            nextToken = stringTokenizer.nextToken();
//            repetitions = new BigDecimal(nextToken).intValue();
//        }
//        nextToken = stringTokenizer.nextToken();
//        if (nextToken.contains("+")) {
//            stringTokenizer = new StringTokenizer(nextToken, "+");
//            nextToken = stringTokenizer.nextToken();
//            faces = new BigDecimal(nextToken).intValue();
//            nextToken = stringTokenizer.nextToken();
//            modifier = new BigDecimal(nextToken).intValue();
//        } else if (nextToken.contains("-")) {
//            stringTokenizer = new StringTokenizer(nextToken, "-");
//            nextToken = stringTokenizer.nextToken();
//            faces = new BigDecimal(nextToken).intValue();
//            nextToken = stringTokenizer.nextToken();
//            modifier = new BigDecimal(nextToken).intValue();
//            modifier = -modifier;
//        } else {
//            faces = new BigDecimal(nextToken).intValue();
//        }
//        return getDice(faces, repetitions, modifier);
//    }
}
