/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kosim.kcoframework.fx.view;

import javafx.scene.control.Label;
import org.kosim.kcoframework.component.KComponent;
import org.kosim.kcoframework.component.SingletonComponent;

/**
 *
 * @author raz
 * @param <S>
 * @param <T>
 */
public class FXLabel<S extends FXLabel<S, T>, T extends Label> extends FXLabeled<S, T> {
    @Override
    public KComponent build() {
        return new SingletonComponent(new Label());
    }
    
}
