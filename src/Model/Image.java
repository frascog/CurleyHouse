/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Greg
 */
public class Image {

    private final int[] pixles;
    private final int id;
    private int guess;
    private int answer;
    private int width;
    private int height;

    public Image(int id,int[] pixles,int width, int height) {
        this.height = height;
        this.width = width;
        this.pixles = pixles;
        this.id = id;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[] getPixles() {
        return pixles;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + "";
    }
}
