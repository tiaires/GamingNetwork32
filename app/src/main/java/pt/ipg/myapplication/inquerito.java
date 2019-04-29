package pt.ipg.myapplication;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import java.util.Calendar;

public class inquerito extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    Button cancelar2, guardar;
    TextView mdata;
    EditText nome, email, jogos;
    DatePickerDialog.OnDateSetListener mmdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquerito);

        cancelar2 = findViewById(R.id.button5);
        mdata = findViewById(R.id.textView3);
        nome = findViewById(R.id.editText2);
        email = findViewById(R.id.editText);
        jogos = findViewById(R.id.editText4);
        guardar = findViewById(R.id.button4);


        cancelar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar2();
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();

                /*startActivity(intent);*/
            }
        });

        mdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int ano = calendar.get(Calendar.YEAR);
                int mes = calendar.get(Calendar.MONTH);
                int dia = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        inquerito.this,
                        android.R.style.Theme_Black,
                        mmdata,
                        ano, mes, dia);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mmdata = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: onDateSet: mm/dd/yyyy\" + month + \"/\" + dayOfMonth + \"/\" + year");

                String date = month + "/" + dayOfMonth + "/" + year;
                mdata.setText(date);
            }
        };


    }


    public void cancelar2() {

        Toast.makeText(this, "Operação Cancelar selecionada", Toast.LENGTH_SHORT).show();

        finish();
    }
/*
    public void guardar2() {

        validaCampos();

        Toast.makeText(this, "Obrigado por registar o inquerito", Toast.LENGTH_SHORT).show();

    }*/
/*

    private void validaCampos() {

        boolean res = false;

        String ednome = nome.getText().toString();
        String edemail = email.getText().toString();
        String edjogos = jogos.getText().toString();

        if (res = campoVazio(ednome)) {
            nome.requestFocus();
        } else if (res = campoVazio(edjogos)) {
            jogos.requestFocus();
        } else if (res = !emailVazio(edemail)) {
            email.requestFocus();
        }


        if (res) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(getString(R.string.erro));
            dlg.setMessage("Preencha os campos em falta");
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }

    }

    private boolean campoVazio(String valor) {
        boolean res = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return res;

    }

    private boolean emailVazio(String email1) {

        boolean res = (campoVazio(email1) && Patterns.EMAIL_ADDRESS.matcher(email1).matches());
        return res;
    }*/

    private void validar(){
        nome.setError(null);
        email.setError(null);
        jogos.setError(null);

        String ednome = nome.getText().toString();
        String edemail = email.getText().toString();
        String edjogos = jogos.getText().toString();

            if(TextUtils.isEmpty(ednome)){
                nome.setError(getString(R.string.erro));
                nome.requestFocus();
                return;
            } else if(TextUtils.isEmpty(edemail)) {
                email.setError(getString(R.string.erro));
                email.requestFocus();
                return;

        }   else if(TextUtils.isEmpty(edjogos)){
                jogos.setError(getString(R.string.erro));
                jogos.requestFocus();
                return;
            }else{
                Intent intent = new Intent(inquerito.this,todos_inq.class);
                intent.putExtra("nome",nome.getText().toString());
                intent.putExtra("email",email.getText().toString());
                intent.putExtra("jogos",jogos.getText().toString());
                intent.putExtra("data",mdata.getText().toString());
                startActivity(intent);

            }

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
          /*  case R.id.inserir:
                Toast.makeText(this, "Inserir novo inquerito", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, inquerito.class);
                startActivity(intent);
                return true; */

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


