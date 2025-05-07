package br.dev.breno.temperatura;

import br.dev.breno.temperatura.gui.ConversaoFrame;
import java.text.ParseException;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {
        
        SwingUtilities.invokeLater(() -> {
            try {
                new ConversaoFrame().setVisible(true);
            } catch (ParseException ex) {
            }
        });
    

    }
   
  

}
