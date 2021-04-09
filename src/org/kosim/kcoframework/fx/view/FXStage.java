/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kosim.kcoframework.fx.view;

import java.util.function.Supplier;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.kosim.kcoframework.component.KComponent;
import org.kosim.kcoframework.component.SingletonComponent;
import org.kosim.kcoframework.view.KViewChain;

/**
 *
 * @author raz
 */
public class FXStage<S extends FXStage<S, T>, T extends Stage> extends KViewChain<S, T> {
    public FXStage() {
        setInherited(true);
    }
    
    public S initOwner(KComponent<? extends Stage> component) {
        return waitForBuild(root -> root.initOwner(component.getLastElement().getLastRoot()));
    }
    
    public S initStyle(StageStyle stageStyle) {
        return waitForBuild(root -> root.initStyle(stageStyle));
    }
    
    public S title(Supplier<String> title) {
        return state((root) -> root.setTitle(title.get()));
    }
    
    public S title(String title) {
        return waitForBuild(root -> root.setTitle(title));
    }
    
    public S scene(KComponent<? extends Scene> scene) {
        return waitForBuild(root -> root.setScene(renderChild(scene)));
    }
    
    public S centerOnScreen() {
        return waitForBuild(root -> root.centerOnScreen());
    }

    @Override
    public KComponent build() {
        return new SingletonComponent(new Stage());
    }
}
