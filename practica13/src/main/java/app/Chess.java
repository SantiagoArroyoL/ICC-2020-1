/**
 * Programa que dibuja el tablero de ajedrez
 * @author Arroyo Lozano Santiago
 * @version 18/10/2019 A
 */
package app;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.HashMap;
import ajedrez.Tablero;
import ajedrez.piezas.Color;
import ajedrez.piezas.Pieza;
import ajedrez.piezas.Peon;
import ajedrez.piezas.Dama;

public class Chess extends PApplet {

   private Tablero tablero;
   private HashMap<String, PImage> imagenes;

   public static void main(String[] args) {
      PApplet.main("app.Chess");
   }

   @Override
   public void settings() {
      //Diferenciamos entre pantallas de 16:9 y 4:3
      if (displayWidth/16 == 120) {
        int m = displayHeight/9;
        size(displayWidth/2, displayHeight-m);
     } else {
        int m = displayHeight/3;
        size(displayWidth/2, displayHeight-m);
     }
   }

   @Override
   public void setup() {
      tablero = Tablero.obtenerInstancia();
      imagenes = new HashMap<>();
      imagenes.put("PeonBLANCO", loadImage(getClass().getResource("/w-pawn.png").getPath()));
      imagenes.put("PeonNEGRO", loadImage(getClass().getResource("/b-pawn.png").getPath()));
      imagenes.put("DamaBLANCO", loadImage(getClass().getResource("/w-queen.png").getPath()));
      imagenes.put("DamaNEGRO", loadImage(getClass().getResource("/b-queen.png").getPath()));
      noLoop();
   }

   /**
    * Método que dibuja el rectángulo que necesitamos (Se repite las veces necesarias)
    */
   @Override
   public void draw() {
      if (displayWidth/16 == 120) {
         //Para pantallas 16:9
         int m = displayHeight/9;
         int lado = m;
         int n = displayWidth/16;
         for (int i = 0; i < 8; i ++) {
            for (int j = 0; j < 8; j ++) {
               if ((i + j + 1) % 2 == 0) {
                  fill(0x44000000);
               } else {
                  fill(255);
               }
               rect(i * n, j * m, (i + 1) * n, (j + 1) * m);

               Pieza pieza = tablero.obtenerPieza(j,i);
               if (pieza != null) {
                  // image(imagenes.get(pieza.getClass().getSimpleName() + pieza.obtenerColor()), i * n, j * m, (i + 1) * n, (j + 1) * m);
                  image(imagenes.get(pieza.getClass().getSimpleName() + pieza.obtenerColor()), lado * i, lado * j, lado , lado);
               }

            }
         }
      } else {
         //Para pantallas 4:3
         int m = displayHeight/12;
         int n = displayWidth/16;
         for (int i = 0; i < 8; i ++) {
            for (int j = 0; j < 8; j ++) {
               if ((i + j + 1) % 2 == 0) {
                  fill(0x44000000);
               } else {
                  fill(255);
               }
               rect(i * n, j * m, (i + 1) * n, (j + 1) * m);

               Pieza pieza = tablero.obtenerPieza(j,i);
               if (pieza != null) {
                  image(imagenes.get(pieza.getClass().getSimpleName() + pieza.obtenerColor()), i * n, j * m, (i + 1) * n, (j + 1) * m);
               }

            }
         }
      }
   }//Cierre del método
}//Cierre de la clase
