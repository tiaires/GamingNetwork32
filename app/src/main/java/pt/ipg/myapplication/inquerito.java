package pt.ipg.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class inquerito extends AppCompatActivity {

        private Button cancelar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquerito);

        cancelar2=findViewById(R.id.button5);

        cancelar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar2();
            }
        });
    }


    public void cancelar2(){

        finish();
    }

}
