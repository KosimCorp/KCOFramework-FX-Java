/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kosim.kcoframework.fx.view;

import java.util.function.Supplier;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import org.kosim.kcoframework.component.KComponent;
import org.kosim.kcoframework.component.SingletonComponent;
import org.kosim.kcoframework.view.TextEditingController;

/**
 *
 * @author raz
 */
public class FXTextField<S extends FXTextField<S, T>, T extends TextField> extends FXRegion<S, T> {
    private TextEditingController controller;
    
    public S controller(TextEditingController controller) {
        if (this.controller != null) this.controller.setComponent(null);
        
        this.controller = controller;
        
        controller.setComponent(this);
        
        return (S) this;
    }
    
    public S onAction(EventHandler<ActionEvent> action) {
        return waitForBuild(element -> {
            element.setOnAction(action);
        });
    }
    
    public S text(String text) {
        return waitForBuild(element -> {
            element.setText(text);
        });
    }
    
    public S text(Supplier<String> text) {
        return state(element -> {
            element.setText(text.get());
        });
    }

    @Override
    public KComponent build() {
        return new SingletonComponent(new TextField());
    }
}
