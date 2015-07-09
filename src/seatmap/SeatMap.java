
package seatmap;

import java.io.IOException;


/**
 *
 * @author Patripon
 */
public class SeatMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {  
        
        MapaAsientos seatmap1 = new MapaAsientos();
        Gui2 gui2 = new Gui2();
        
        seatmap1.crear();
        
        gui2.crearVentana();
        
        
        
       
       
    }
    
}
