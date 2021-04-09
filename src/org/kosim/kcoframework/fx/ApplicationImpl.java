/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kosim.kcoframework.fx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.kosim.kcoframework.KCOFramework;
import org.kosim.kcoframework.fx.view.FXScene;
import org.kosim.kcoframework.fx.view.FXStage;

/**
 *
 * @author raz
 */
public class ApplicationImpl extends Application {
    @Override
    public void init() throws Exception {
        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        var view = new FXStage<>()
                .custom(() -> stage)
                .scene(
                    new FXScene<>()
                        .root(FXApplication.instance.getHome())
                );
        
        KCOFramework.render(view).show();
    }

    @Override
    public void stop() throws Exception {
        
    }
}
