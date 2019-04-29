package pt.ipg.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class todos_inq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_inq);

        final TextView t1 = findViewById(R.id.textView8);
        final TextView t2 = findViewById(R.id.textView9);
        final TextView t3 = findViewById(R.id.textView10);
        final TextView t4 = findViewById(R.id.textView11);

        t1.setText(getIntent().getExtras().getString("nome"));
        t2.setText(getIntent().getExtras().getString("email"));
        t3.setText(getIntent().getExtras().getString("jogos"));
        t4.setText(getIntent().getExtras().getString("data"));

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

            case R.id.alterar:
                Toast.makeText(this, "Alterar inquerito", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, ed_inqueiro.class);
                startActivity(intent1);
                return true;

            case R.id.eliminar:
                Toast.makeText(this, "Eliminar inquerito", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, todos_inq.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
