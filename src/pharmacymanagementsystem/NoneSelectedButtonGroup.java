/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

/**
 *
 * @author chai
 */
public class NoneSelectedButtonGroup extends ButtonGroup {
    
  @Override
  public void setSelected(ButtonModel model, boolean selected) {

    if (selected) {

      super.setSelected(model, selected);

    } else {

      clearSelection();
    }
  }
  
}
