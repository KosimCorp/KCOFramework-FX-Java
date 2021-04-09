/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kosim.kcoframework.fx.view;

import java.util.function.Supplier;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Paint;
import org.kosim.kcoframework.view.KViewChain;

/**
 *
 * @author raz
 */
public abstract class FXRegion<S extends FXRegion<S, T>, T extends Region> extends KViewChain<S, T> {
    public S padding(Insets padding) {
        return waitForBuild(element -> {
            element.setPadding(padding);
        });
    }
    
    public S padding(Supplier<Insets> padding) {
        return state(element -> {
            element.setPadding(padding.get());
        });
    }
    
    public S prefSize(double width, double height) {
        return waitForBuild(element -> {
            element.setPrefSize(width, height);
        });
    }
    
    public S prefWidth(double width) {
        return waitForBuild(element -> {
            element.setPrefWidth(width);
        });
    }
    
    public S prefHeight(double height) {
        return waitForBuild(element -> {
            element.setPrefHeight(height);
        });
    }
    
    public S maxSize(double width, double height) {
        return waitForBuild(element -> {
            element.setMaxSize(width, height);
        });
    }
    
    public S maxWidth(double width) {
        return waitForBuild(element -> {
            element.setMaxWidth(width);
        });
    }
    
    public S maxHeight(double height) {
        return waitForBuild(element -> {
            element.setMaxHeight(height);
        });
    }
    
    public S minSize(double width, double height) {
        return waitForBuild(element -> {
            element.setMaxSize(width, height);
        });
    }
    
    public S minWidth(double width) {
        return waitForBuild(element -> {
            element.setMinWidth(width);
        });
    }
    
    public S minHeight(double height) {
        return waitForBuild(element -> {
            element.setMinHeight(height);
        });
    }
    
    public S background(Paint paint) {
        return background(new Background(new BackgroundFill(paint, CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
    public S background(Supplier<Background> background) {
        return state(element -> {
            element.setBackground(background.get());
        });
    }
    
    public S background(Background background) {
        return waitForBuild(element -> {
            element.setBackground(background);
        });
    }
}
