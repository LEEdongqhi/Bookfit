package com.example.bookfit;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import android.content.Context;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.SimpleAdapter;

public class Kyobo extends AppCompatActivity{

    final Integer[] KyoboImg = {R.drawable.kyobo1, R.drawable.kyobo2, R.drawable.kyobo3, R.drawable.kyobo4, R.drawable.kyobo5, R.drawable.kyobo6, R.drawable.kyobo7,
            R.drawable.kyobo8, R.drawable.kyobo9, R.drawable.kyobo10, R.drawable.kyobo11, R.drawable.kyobo12, R.drawable.kyobo13, R.drawable.kyobo14,
            R.drawable.kyobo15, R.drawable.kyobo16, R.drawable.kyobo17, R.drawable.kyobo18, R.drawable.kyobo19, R.drawable.kyobo20, R.drawable.kyobo21,
            R.drawable.kyobo22, R.drawable.kyobo23,R.drawable.kyobo24, R.drawable.kyobo25, R.drawable.kyobo26, R.drawable.kyobo27, R.drawable.kyobo28, R.drawable.kyobo29,
            R.drawable.kyobo30, R.drawable.kyobo31, R.drawable.kyobo32, R.drawable.kyobo33, R.drawable.kyobo34, R.drawable.kyobo35, R.drawable.kyobo36,
            R.drawable.kyobo37,R.drawable.kyobo38, R.drawable.kyobo39, R.drawable.kyobo40, R.drawable.kyobo41, R.drawable.kyobo42, R.drawable.kyobo43,
            R.drawable.kyobo44, R.drawable.kyobo45, R.drawable.kyobo46, R.drawable.kyobo47, R.drawable.kyobo48, R.drawable.kyobo49, R.drawable.kyobo50,
            R.drawable.kyobo51, R.drawable.kyobo52, R.drawable.kyobo53, R.drawable.kyobo54, R.drawable.kyobo55, R.drawable.kyobo56, R.drawable.kyobo57,
            R.drawable.kyobo58, R.drawable.kyobo59, R.drawable.kyobo60, R.drawable.kyobo61, R.drawable.kyobo62, R.drawable.kyobo63, R.drawable.kyobo64,
            R.drawable.kyobo65, R.drawable.kyobo66, R.drawable.kyobo67, R.drawable.kyobo68, R.drawable.kyobo69, R.drawable.kyobo70, R.drawable.kyobo71,
            R.drawable.kyobo72, R.drawable.kyobo73, R.drawable.kyobo74, R.drawable.kyobo75, R.drawable.kyobo76, R.drawable.kyobo77, R.drawable.kyobo78,
            R.drawable.kyobo79, R.drawable.kyobo80, R.drawable.kyobo81, R.drawable.kyobo82, R.drawable.kyobo83, R.drawable.kyobo84, R.drawable.kyobo85,
            R.drawable.kyobo86, R.drawable.kyobo87, R.drawable.kyobo88, R.drawable.kyobo89, R.drawable.kyobo90, R.drawable.kyobo91, R.drawable.kyobo92,
            R.drawable.kyobo93, R.drawable.kyobo94, R.drawable.kyobo95, R.drawable.kyobo96, R.drawable.kyobo97, R.drawable.kyobo98, R.drawable.kyobo99, R.drawable.kyobo100};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kyobo);

        final ListView listKyobo = (ListView) findViewById(R.id.listKyobo);

        ArrayList<String> kyobo_site = new ArrayList<>();
        ArrayList<String> kyobo_rank = new ArrayList<>();
        ArrayList<String> kyobo_name = new ArrayList<>();
        ArrayList<String> kyobo_writer = new ArrayList<>();
        ArrayList<String> kyobo_company = new ArrayList<>();
        ArrayList<String> kyobo_price = new ArrayList<>();

        try{
            InputStream input_kyobo = getResources().openRawResource(R.raw.kyobo_best);
            BufferedReader buffered_kyobo = new BufferedReader(new InputStreamReader(input_kyobo));

            String test_text;

            while((test_text = buffered_kyobo.readLine()) != null) {
                String[] split = test_text.split("\t");
                kyobo_site.add(split[0]);
                kyobo_rank.add(split[1]);
                kyobo_name.add(split[2]);
                kyobo_writer.add(split[3]);
                kyobo_company.add(split[4]);
                kyobo_price.add(split[5]);

            }

            buffered_kyobo.close();
            input_kyobo.close();
        } catch(IOException e) {}

        KyoboAdapter kyobo_adapter = new KyoboAdapter(this, android.R.layout.simple_list_item_1, kyobo_rank, kyobo_name, kyobo_writer, kyobo_company, kyobo_price);

        listKyobo.setAdapter(kyobo_adapter);

    }

    private class KyoboAdapter extends ArrayAdapter<String> {
        private ArrayList<String> items, items2, items3, items4, items5;

        public KyoboAdapter(Context context, int textViewResourceld, ArrayList<String> objects, ArrayList<String> objects2, ArrayList<String> objects3, ArrayList<String> objects4, ArrayList<String> objects5) {
            super(context, textViewResourceld, objects);
            this.items=objects;
            this.items2=objects2;
            this.items3=objects3;
            this.items4=objects4;
            this.items5=objects5;

        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.kyobo_items, null);
            }

            ImageView imageView = (ImageView) v.findViewById(R.id.kyobobook_image);

            for(int i=1; i<101; i++) {
                String str = i+"위";
                if(str.equals(items.get(position)))
                    imageView.setImageResource(KyoboImg[i-1]);
            }


            TextView textView = (TextView)v.findViewById(R.id.kyobobook_rank);
            textView.setText(items.get(position));
            TextView textView2 = (TextView)v.findViewById(R.id.kyobobook_name);
            textView2.setText(items2.get(position));
            TextView textView3 = (TextView)v.findViewById(R.id.kyobobook_writer);
            textView3.setText(items3.get(position));
            TextView textView4 = (TextView)v.findViewById(R.id.kyobobook_company);
            textView4.setText(items4.get(position));
            TextView textView5 = (TextView)v.findViewById(R.id.kyobobook_price);
            textView5.setText(items5.get(position));

            return v;

        }

    }

}
