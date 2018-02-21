package com.example.denis.generatia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText Nume, Prenume, CNP, An_studiu, Facultate, Varsta, Credite;
    Button btnAdd, btnUpd, btnDel, btnArata;
    DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CNP = findViewById(R.id.CNP);
        Nume = findViewById(R.id.Nume);
        Prenume = findViewById(R.id.Prenume);
        An_studiu = findViewById(R.id.An_studiu);
        Facultate = findViewById(R.id.Facultate);
        Varsta = findViewById(R.id.Varsta);
        Credite = findViewById(R.id.Credite);

        btnAdd = findViewById(R.id.Adauga);
        btnUpd = findViewById(R.id.Update);
        btnDel = findViewById(R.id.sterge);
        btnArata = findViewById(R.id.arata);

        myDB = new DatabaseHelper(this);

        btnArata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewListContents.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNume = Nume.getText().toString();
                String sPrenume = Prenume.getText().toString();
                int sCNP = Integer.parseInt(CNP.getText().toString());
                String sFacultate = Facultate.getText().toString();
                int sAn_studiu = Integer.parseInt(An_studiu.getText().toString());
                int sVarsta = Integer.parseInt(Varsta.getText().toString());
                int sCredite = Integer.parseInt(Credite.getText().toString());

                //if (CNP.length(13) = true)


                if (sNume.length() != 0 && sPrenume.length() != 0 && sFacultate.length() != 0 && sCredite >= 0) {
                    AddData(sNume, sPrenume, sCNP, sAn_studiu, sFacultate, sVarsta, sCredite);
                    Nume.setText("");//resetez campurilor textului la valoarea null
                    Prenume.setText("");
                    CNP.setText("");
                    An_studiu.setText("");
                    Facultate.setText("");
                    Varsta.setText("");
                    Credite.setText("");

                } else {
                    Toast.makeText(MainActivity.this, "Campuri obligatorii de completat!", Toast.LENGTH_LONG).show();
                }
            }
        });

       /* btnUpd.setOnClickListener(new View.OnClickListener() {

                                      public void onClick(View v) {

                                          boolean isUdated = myDB.updateData(EditText.getText().toString(),
                                                  Nume.getText().toString(),
                                                  Prenume.getText().toString(),
                                                  Integer.parseInt(CNP.getText().toString()),
                                                  Facultate.getText().toString(),
                                                  Integer.parseInt(An_studiu.getText().toString()),
                                                  Integer.parseInt(Varsta.getText().toString()),
                                                  Integer.parseInt(Credite.getText().toString()));
                                      }


                                  };
       */

            /* btnDel.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String sNume = Nume.getText().toString();
                    String sPrenume = Prenume.getText().toString();
                    int sCNP = Integer.parseInt(CNP.getText().toString());
                    String sFacultate = Facultate.getText().toString();
                    int sAn_studiu = Integer.parseInt(An_studiu.getText().toString());
                    int sVarsta = Integer.parseInt(Varsta.getText().toString());
                    int sCredite = Integer.parseInt(Credite.getText().toString());


                                    }

            */


    }

    public void AddData(String Nume, String Prenume, Integer CNP, Integer An_studiu, String Facultate,
                        Integer Varsta, Integer Credite) {
        boolean insertData = myDB.addData(Nume, Prenume, CNP, An_studiu, Facultate, Varsta, Credite);

        if (insertData) {
            Toast.makeText(MainActivity.this, "Datele au fost introduse cu succes!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Eroare de inserare", Toast.LENGTH_LONG).show();
        }
    }

    public void updateData(String NumeNou, String Prenume, int CNP, int An_studiu, String Facultate, int Varsta, int Credite) {
        boolean isUpdated = myDB.addData(NumeNou, Prenume, CNP, An_studiu, Facultate, Varsta, Credite);

        if (isUpdated) {
            Toast.makeText(MainActivity.this, "Datele au fost Actualizate cu succes!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Eroare de actualizare", Toast.LENGTH_LONG).show();
        }
    }

}