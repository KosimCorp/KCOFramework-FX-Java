/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kosim.kcoframework.fx.view;

import java.util.List;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import org.kosim.kcoframework.component.KComponent;
import org.kosim.kcoframework.component.SingletonComponent;

/**
 *
 * @author raz
 */
public class FXPane<S extends FXPane<S, T>, T extends Pane> extends FXRegion<S, T> {
    public S children(KComponent... children) {
        return waitForBuild(element -> {
            element.getChildren().addAll(
                List.of(children).stream().map(child -> renderChild(child)).toArray(Node[]::new)
            );
        });
    }

    @Override
    public KComponent build() {
        return new SingletonComponent(new Pane());
    }
    
}
