/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kosim.kcoframework.fx;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.kosim.kcoframework.component.KComponent;
import org.kosim.kcoframework.component.element.ElementEngine;
import org.kosim.kcoframework.event.KEvent;
import org.kosim.kcoframework.fx.view.FXTextField;
import org.kosim.kcoframework.view.KBuilder;
import org.kosim.kcoframework.view.TextEditingController;

/**
 *
 * @author raz
 */
public class FXElementEngine implements ElementEngine {
    @Override
    public Object render(KComponent component) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispatch(KComponent component, KEvent event) {
        if (component instanceof KBuilder) {
            if (event.getKey() == KBuilder.CHANGE_CHILD) {
                Node node = (Node) component.getLastElement().getLastRoot();
                Parent n = node.getParent();
                
                if (n == null) return;

                if (n instanceof Pane) {
                    Pane p = (Pane) n;

                    int index = p.getChildren().indexOf(node);

                    p.getChildren().set(index, (Node) component.createElement().render());
                } else if (n instanceof ScrollPane) {
                    ScrollPane p = (ScrollPane) n;
                    
                    p.setContent((Node) component.createElement().render());
                }
            }
        } else if (component instanceof FXTextField) {
            TextField textField = (TextField) component.getLastElement().getLastRoot();
            
            if (event.getKey() == TextEditingController.SET_TEXT) {
                textField.setText((String) event.getArgs()[0]);
            } else if (event.getKey() == TextEditingController.CLEAR_TEXT) {
                textField.clear();
            }
        }
    }

    @Override
    public Object get(KComponent component, KEvent event) {
        if (component instanceof FXTextField) {
            TextField textField = (TextField) component.getLastElement().getLastRoot();
            
            if (event.getKey() == TextEditingController.GET_TEXT) {
                return textField.getText();
            }
        }
        
        return null;
    }
}
