package pt.ipg.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ed_inqueiro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ed_inqueiro);

        Button senha = findViewById(R.id.button9);

        senha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tsenha = findViewById(R.id.editText5);
                String senhas = tsenha.getText().toString();

                if(senhas.equals("1234")){
                    alert("Login realizado com sucesso");
                    abrirTodos_inq();
                } else {
                    alert("Senha incorreta");
                }
            }
        });
    }

    private void alert(String s){

        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

    public void abrirTodos_inq(){
        Intent intent = new Intent(this, todos_inq.class);
        startActivity(intent);
    }
}
