package com.example.examenpspasiergusmano;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Creamos las variables que mas tarde vincularemos
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    ImageView iv1,iv2,iv3,iv4,iv5,iv6;


    private static final int OP_cargar1 = 1;
    private static final int OP_cargar2 = 2;
    private static final int OP_cargar3 = 3;
    private static final int OP_cargar4 = 4;
    private static final int OP_cargar5 = 5;
    private static final int OP_cargar6 = 6;

    //Le damos el valor a las url
    public static final String URL1="https://ia601702.us.archive.org/0/items/icon-2_202008/icon%20%282%29.png";
    public static final String URL2="https://archive.org/services/img/unnamed_20201109";
    public static final String URL3="https://ia803206.us.archive.org/2/items/atv-launcher_202008/ATV%20Launcher.png";
    public static final String URL4="https://ia600106.us.archive.org/28/items/MouseToggleLogo/Mouse%20Toggle%20logo.jpeg";
    public static final String URL5="https://archive.org/services/img/mx-player-pro_20210102";
    public static String URL6="https://ia601702.us.archive.org/0/items/icon-2_202008/icon%20%282%29.png";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vinculamos cada variable con su elemento en la vista
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);
        btn5=findViewById(R.id.button5);
        btn6=findViewById(R.id.button6);

        iv1=findViewById(R.id.iv1);
        iv2=findViewById(R.id.iv2);
        iv3=findViewById(R.id.iv3);
        iv4=findViewById(R.id.iv4);
        iv5=findViewById(R.id.iv5);
        iv6=findViewById(R.id.iv6);

        //Se elige un numero random del 1 al 5 y dependiendo de cual sea la url6 tendra el valor de una url o otra
        Random rand = new Random();
        int n = rand.nextInt(6);

        switch (n){
            case 1:
                URL6="https://ia601702.us.archive.org/0/items/icon-2_202008/icon%20%282%29.png";
                break;
            case 2:
                URL6="https://archive.org/services/img/unnamed_20201109";
                break;
            case  3:
                URL6="https://ia803206.us.archive.org/2/items/atv-launcher_202008/ATV%20Launcher.png";
                break;
            case  4:
                URL6="https://ia600106.us.archive.org/28/items/MouseToggleLogo/Mouse%20Toggle%20logo.jpeg";
                break;
            case  5:
                URL6="https://archive.org/services/img/mx-player-pro_20210102";
                break;
            default:

        }
    }//Aqui termina el onCreate

    //Dependiendo del boton que clicke pasa unos datos o otros
    @SuppressLint("NonConstantResourceId")
    public void onClick (View view) {

            switch (view.getId()){
                case R.id.button1:
                    Log.e("onClick", "hola");
                    new miHilo(OP_cargar1, URL1).start();
                    break;
                case R.id.button2:
                   new miHilo(OP_cargar2, URL2).start();
                    break;
                case R.id.button3:
                   new miHilo(OP_cargar3, URL3).start();
                    break;

                case R.id.button4:
                   new miHilo(OP_cargar4, URL4).start();
                    break;
                case R.id.button5:
                   new miHilo(OP_cargar5, URL5).start();
                    break;
                case R.id.button6:
                   new miHilo(OP_cargar6, URL6).start();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }
        }


    //Este es el hilo principal, llamamos a este hilo y le pasamos diferentes operaciones
    //Estas operaciones estan declaradas en el onCreate y dependiendo de que operacion se realiza
    //La clase Utilities usa una funcion o otra
    public class miHilo extends Thread {
        private final int operacion;
        private String url;
        private Bitmap res;

        public miHilo(int operacion, String url) {
            this.operacion = operacion;
            this.url = url;
        }

        @Override
        public void run() {
            switch (operacion){
                case OP_cargar1:
                    //Res toma el valor que devuelve la funcion de la clase utilities
                    //En este caso llamamos a la funcion getBitmap y le pasamos la url de la imagen que hemos recibido
                    res = Utilites.getBitmapFromURL(url);
                    runOnUiThread(() -> iv1.setImageBitmap(res));
                    break;
                case OP_cargar2:
                    res = Utilites.getBitmapFromURL(url);
                    runOnUiThread(() -> iv2.setImageBitmap(res));
                    break;
                case  OP_cargar3:
                    res = Utilites.getBitmapFromURL(url);
                    runOnUiThread(() -> iv3.setImageBitmap(res));
                    break;
                case  OP_cargar4:
                    res = Utilites.getBitmapFromURL(url);
                    runOnUiThread(() -> iv4.setImageBitmap(res));
                    break;
                case  OP_cargar5:
                    res = Utilites.getBitmapFromURL(url);
                    runOnUiThread(() -> iv5.setImageBitmap(res));
                    break;
                case  OP_cargar6:
                    res = Utilites.getBitmapFromURL(url);
                    runOnUiThread(() -> iv6.setImageBitmap(res));
                    break;
                default:

            }

        }
    }

}
