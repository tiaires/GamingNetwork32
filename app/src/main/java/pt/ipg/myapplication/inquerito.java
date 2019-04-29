package pt.ipg.myapplication;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Calendar;

public class inquerito extends AppCompatActivity {

        private static final String TAG = "MainActivity";

        Button cancelar2,guardar;
        TextView mdata;
        EditText nome,email,jogos;
        DatePickerDialog.OnDateSetListener mmdata;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquerito);

        cancelar2=findViewById(R.id.button5);
        mdata=findViewById(R.id.textView3);
        nome=findViewById(R.id.editText2);
        email=findViewById(R.id.editText);
        jogos=findViewById(R.id.editText4);
        guardar=findViewById(R.id.button4);


        cancelar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar2();
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar2();
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
                month=month+1;
                Log.d(TAG, "onDateSet: onDateSet: mm/dd/yyyy\" + month + \"/\" + dayOfMonth + \"/\" + year");

                String date = month + "/" + dayOfMonth + "/" + year;
                mdata.setText(date);
            }
        };


    }


    public void cancelar2(){

        Toast.makeText(this,"Operação Cancelar selecionada",Toast.LENGTH_SHORT).show();

        finish();
    }

    public void guardar2(){

        validaCampos();

        Toast.makeText(this,"Obrigado por registar o inquerito",Toast.LENGTH_SHORT).show();

        }




    private void validaCampos(){

            boolean res = false;

            String ednome = nome.getText().toString();
            String edemail = email.getText().toString();
            String edjogos = jogos.getText().toString();

            if (res = campoVazio(ednome)){
                    nome.requestFocus();
            }   else
                        if (res =campoVazio(edjogos)){
                            jogos.requestFocus();
                        } else
                                if (res = !emailVazio(edemail)){
                                    email.requestFocus();
                                }


            if (res){
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle(getString(R.string.erro));
                dlg.setMessage("Preencha os campos em falta");
                dlg.setNeutralButton("OK",null);
                dlg.show();
            }

    }

    private boolean campoVazio(String valor){
        boolean res=(TextUtils.isEmpty(valor) || valor.trim().isEmpty() );
        return res;

    }

    private boolean emailVazio(String email1){

        boolean res = (campoVazio(email1) && Patterns.EMAIL_ADDRESS.matcher(email1).matches());
        return res;
    }

}
