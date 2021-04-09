/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kosim.kcoframework.fx.view;

import java.util.Objects;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import org.kosim.kcoframework.component.KComponent;
import org.kosim.kcoframework.component.SingletonComponent;
import org.kosim.kcoframework.view.KViewChain;

/**
 *
 * @author raz
 */
public class FXScene<S extends FXScene<S, T>, T extends Scene> extends KViewChain<S, T> {
    private KComponent root;
    
    public S root(KComponent root) {
        this.root = root;
        
        return (S) this;
    }
    
    public S fill(Paint paint) {
        return waitForBuild(root -> root.setFill(paint));
    }

    @Override
    public KComponent build() {
        Objects.requireNonNull(root);
        
        return new SingletonComponent(new Scene((Parent) renderChild(root)));
    }
    
}
