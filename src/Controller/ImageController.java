/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Image;

/**
 *
 * @author Greg
 */
public class ImageController {
    
    private Image image;

    public ImageController(Image image) {
        this.image = image;
    }

    public int getGuess() {
        return image.getGuess();
    }

    public void setGuess(int guess) {
        this.image.setGuess(guess);
    }

    public int getAnswer() {
        return this.image.getAnswer();
    }

    public void setAnswer(int answer) {
        this.image.setAnswer(answer);
    }

    public int getWidth() {
        return this.image.getWidth();
    }

    public void setWidth(int width) {
        this.image.setWidth(width);
    }

    public int getHeight() {
        return this.image.getHeight();
    }

    public void setHeight(int height) {
        this.image.setHeight(height);
    }

    public int[] getPixles() {
        return this.image.getPixles();
    }

    public int getId() {
        return this.image.getId();
    }
}