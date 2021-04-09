/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kosim.kcoframework.fx.view;

import java.util.function.Supplier;
import javafx.scene.control.Labeled;
import javafx.scene.paint.Paint;
import org.kosim.kcoframework.view.KViewChain;

/**
 *
 * @author raz
 */
public abstract class FXLabeled<S extends FXLabeled<S, T>, T extends Labeled> extends FXRegion<S, T> {
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
    
    public S textFill(Paint textFill) {
        return waitForBuild(element -> {
            element.setTextFill(textFill);
        });
    }
    
    public S textFill(Supplier<Paint> textFill) {
        return state(element -> {
            element.setTextFill(textFill.get());
        });
    }
}
