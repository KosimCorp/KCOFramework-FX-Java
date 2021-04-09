/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kosim.kcoframework.fx.view;

import java.util.function.Supplier;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import org.kosim.kcoframework.component.KComponent;
import org.kosim.kcoframework.component.SingletonComponent;
import org.kosim.kcoframework.view.KViewChain;

/**
 *
 * @author raz
 */
public class FXVBox<S extends FXVBox<S, T>, T extends VBox> extends FXPane<S, T> {
    public S spacing(double spacing) {
        return waitForBuild(element -> {
            element.setSpacing(spacing);
        });
    }
    
    public S spacing(Supplier<Double> spacing) {
        return state(element -> {
            element.setSpacing(spacing.get());
        });
    }
    
    public S align(Pos align) {
        return waitForBuild(element -> {
            element.setAlignment(align);
        });
    }
    
    public S align(Supplier<Pos> align) {
        return state(element -> {
            element.setAlignment(align.get());
        });
    }

    @Override
    public KComponent build() {
        return new SingletonComponent(new VBox());
    }
    
}
