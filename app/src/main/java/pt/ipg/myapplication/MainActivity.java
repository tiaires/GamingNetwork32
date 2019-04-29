package pt.ipg.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button ed_enq,abrir,cancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            abrir = findViewById(R.id.button);
            ed_enq = findViewById(R.id.button3);
            cancelar=findViewById(R.id.button2);


            abrir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    abrirInquerito();
                }
            });


            ed_enq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    abrirEdit();
                }
            });

            cancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cancelar();
                }
            });

    }

        public void abrirInquerito(){

                Intent intent = new Intent(this, inquerito.class);
                startActivity(intent);
        }

        public void abrirEdit(){

                Intent intent = new Intent(this, ed_inqueiro.class);
                startActivity(intent);
        }

        public void cancelar(){

            finish();
        }

    public void abrir(View view) {
    }

    public void cancelar(View view){

    }
}
