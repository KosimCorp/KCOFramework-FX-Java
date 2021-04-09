/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kosim.kcoframework.fx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.kosim.kcoframework.KCOFramework;
import org.kosim.kcoframework.component.KComponent;

/**
 *
 * @author raz
 */
public class FXApplication<T extends FXApplication<T>> {
    static FXApplication instance;
    
    private KComponent home;
    
    public FXApplication() {
        instance = FXApplication.this;
    }
    
    public T home(KComponent home) {
        this.home = home;
        
        return (T) this;
    }
    
    public void launch(String[] args) {
        KCOFramework.setDefaultElementEngine(new FXElementEngine());
        
        Application.launch(ApplicationImpl.class, args);
    }

    KComponent getHome() {
        return home;
    }
}
