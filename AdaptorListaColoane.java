package com.example.denis.generatia;

/**
 * Created by Denis on 05.02.2018.
 */


        import android.content.Context;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;
        import java.util.ArrayList;

public class AdaptorListaColoane extends ArrayAdapter<User> {

    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceId;

    public AdaptorListaColoane(Context context, int textViewResourceId, ArrayList<User> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        User user = users.get(position);
        Log.v("testtest", user.getNume()+"adapter");
        if (user != null)//Am si numere =>cred ca trebuie sa convertesc la string si sa vad
            //daca lungimea e diferita de zero
             {
            TextView sNume =  convertView.findViewById(R.id.textNume);
            TextView sPrenume = convertView.findViewById(R.id.textPrenume);
            TextView sCNP = convertView.findViewById(R.id.textCNP);
            TextView sAn_studiu = convertView.findViewById(R.id.textAn_studiu);
            TextView sFacultate = convertView.findViewById(R.id.textFacultate);
            TextView sVarsta = convertView.findViewById(R.id.textVarsta);
            TextView sCredite = convertView.findViewById(R.id.textCredite);

            if (sNume != null) {
                sNume.setText(user.getNume());
            }

            if (sPrenume != null) {
                sPrenume.setText((user.getPrenume()));
            }

            if (sCNP != null) {
                sCNP.setText((user.getCNP()));
            }

            if (sAn_studiu != null) {
                sAn_studiu.setText((user.getAn_studiu()));
            }
            if (sFacultate != null) {
                sFacultate.setText((user.getFacultate()));
            }

            if (sVarsta != null) {
                sVarsta.setText((user.getVarsta()));
            }
            if (sCredite != null) {
                sCredite.setText((user.getCredite()));
            }
        }

        return convertView;
    }
}
