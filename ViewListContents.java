package com.example.denis.generatia;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Denis on 07.02.2018.
 */


public class ViewListContents extends AppCompatActivity {

    DatabaseHelper myDB;
    ArrayList<User> userList;
    ListView listView;
    User user;


   // @Override
    //public void onConfigurationChanged(Configuration newConfig) {
     //   super.onConfigurationChanged(newConfig);
    //    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    //}


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);

        myDB = new DatabaseHelper(this);

        userList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        int numLinii = data.getCount();
        Log.v("testtest", "numar inregistrari "+numLinii);
        if(numLinii == 0){
            Toast.makeText(ViewListContents.this,"Baza de date e nepopulata ",Toast.LENGTH_LONG).show();
        }else{
            int i=0;
            Log.v("testtest", " pe else");


            for (i=0; i<numLinii; i++) {
                data.moveToNext();
                Log.v("testest", data.getString(2) + " nume");
                user = new User(data.getString(1),data.getString(2), data.getInt(3),
                           data.getInt(4),data.getString(5), data.getInt(6),
                          data.getInt(7));
                userList.add(user);

            }
            //while(data.moveToNext()){

             //

              //



                AdaptorListaColoane adapter =  new AdaptorListaColoane(this,R.layout.llist_adapter_view, userList);
                listView =  findViewById(R.id.listView);
                listView.setAdapter(adapter);

            }

    }
}