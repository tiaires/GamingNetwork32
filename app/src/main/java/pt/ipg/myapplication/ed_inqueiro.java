package pt.ipg.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.inserir:
                Toast.makeText(this, "Inserir novo inquerito", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, inquerito.class);
                startActivity(intent);
                return true;

         /*   case R.id.alterar:
                Toast.makeText(this, "Alterar inquerito", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, ed_inqueiro.class);
                startActivity(intent1);
                return true; */

            case R.id.eliminar:
                Toast.makeText(this, "Eliminar inquerito", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
