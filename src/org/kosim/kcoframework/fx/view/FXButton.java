/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kosim.kcoframework.fx.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import org.kosim.kcoframework.component.KComponent;
import org.kosim.kcoframework.component.SingletonComponent;

/**
 *
 * @author raz
 */
public class FXButton<S extends FXButton<S, T>, T extends Button> extends FXLabeled<S, T> {
    public S onAction(EventHandler<ActionEvent> action) {
        return waitForBuild(element -> {
            element.setOnAction(action);
        });
    }

    @Override
    public KComponent build() {
        return new SingletonComponent<>(new Button());
    }
    
}
