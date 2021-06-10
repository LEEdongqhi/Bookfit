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

public class Bandi extends AppCompatActivity{

    final Integer[] BandiImg = {R.drawable.bandi1, R.drawable.bandi2, R.drawable.bandi3, R.drawable.bandi4, R.drawable.bandi5, R.drawable.bandi6, R.drawable.bandi7,
            R.drawable.bandi8, R.drawable.bandi9, R.drawable.bandi10, R.drawable.bandi11, R.drawable.bandi12, R.drawable.bandi13, R.drawable.bandi14,
            R.drawable.bandi15, R.drawable.bandi16, R.drawable.bandi17, R.drawable.bandi18, R.drawable.bandi19, R.drawable.bandi20, R.drawable.bandi21,
            R.drawable.bandi22, R.drawable.bandi23,R.drawable.bandi24, R.drawable.bandi25, R.drawable.bandi26, R.drawable.bandi27, R.drawable.bandi28, R.drawable.bandi29,
            R.drawable.bandi30, R.drawable.bandi31, R.drawable.bandi32, R.drawable.bandi33, R.drawable.bandi34, R.drawable.bandi35, R.drawable.bandi36,
            R.drawable.bandi37,R.drawable.bandi38, R.drawable.bandi39, R.drawable.bandi40, R.drawable.bandi41, R.drawable.bandi42, R.drawable.bandi43,
            R.drawable.bandi44, R.drawable.bandi45, R.drawable.bandi46, R.drawable.bandi47, R.drawable.bandi48, R.drawable.bandi49, R.drawable.bandi50,
            R.drawable.bandi51, R.drawable.bandi52, R.drawable.bandi53, R.drawable.bandi54, R.drawable.bandi55, R.drawable.bandi56, R.drawable.bandi57,
            R.drawable.bandi58, R.drawable.bandi59, R.drawable.bandi60, R.drawable.bandi61, R.drawable.bandi62, R.drawable.bandi63, R.drawable.bandi64,
            R.drawable.bandi65, R.drawable.bandi66, R.drawable.bandi67, R.drawable.bandi68, R.drawable.bandi69, R.drawable.bandi70, R.drawable.bandi71,
            R.drawable.bandi72, R.drawable.bandi73, R.drawable.bandi74, R.drawable.bandi75, R.drawable.bandi76, R.drawable.bandi77, R.drawable.bandi78,
            R.drawable.bandi79, R.drawable.bandi80, R.drawable.bandi81, R.drawable.bandi82, R.drawable.bandi83, R.drawable.bandi84, R.drawable.bandi85,
            R.drawable.bandi86, R.drawable.bandi87, R.drawable.bandi88, R.drawable.bandi89, R.drawable.bandi90, R.drawable.bandi91, R.drawable.bandi92,
            R.drawable.bandi93, R.drawable.bandi94, R.drawable.bandi95, R.drawable.bandi96, R.drawable.bandi97, R.drawable.bandi98, R.drawable.bandi99, R.drawable.bandi100};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bandi);

        final ListView listBandi = (ListView) findViewById(R.id.listBandi);

        ArrayList<String> bandi_site = new ArrayList<>();
        ArrayList<String> bandi_rank = new ArrayList<>();
        ArrayList<String> bandi_name = new ArrayList<>();
        ArrayList<String> bandi_writer = new ArrayList<>();
        ArrayList<String> bandi_company = new ArrayList<>();
        ArrayList<String> bandi_price = new ArrayList<>();

        try{
            InputStream input_bandi = getResources().openRawResource(R.raw.bandi_best);
            BufferedReader buffered_bandi = new BufferedReader(new InputStreamReader(input_bandi));

            String test_text;

            while((test_text = buffered_bandi.readLine()) != null) {
                String[] split = test_text.split("\t");
                bandi_site.add(split[0]);
                bandi_rank.add(split[1]);
                bandi_name.add(split[2]);
                bandi_writer.add(split[3]);
                bandi_company.add(split[4]);
                bandi_price.add(split[5]);

            }

            buffered_bandi.close();
            input_bandi.close();
        } catch(IOException e) {}

        BandiAdapter bandi_adapter = new BandiAdapter(this, android.R.layout.simple_list_item_1, bandi_rank, bandi_name, bandi_writer, bandi_company, bandi_price);

        listBandi.setAdapter(bandi_adapter);

    }

    private class BandiAdapter extends ArrayAdapter<String> {
        private ArrayList<String> items, items2, items3, items4, items5;

        public BandiAdapter(Context context, int textViewResourceld, ArrayList<String> objects, ArrayList<String> objects2, ArrayList<String> objects3, ArrayList<String> objects4, ArrayList<String> objects5) {
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
                v = vi.inflate(R.layout.bandi_items, null);
            }

            ImageView imageView = (ImageView) v.findViewById(R.id.bandibook_image);

            for(int i=1; i<101; i++) {
                String str = i+"위";
                if(str.equals(items.get(position)))
                    imageView.setImageResource(BandiImg[i-1]);
            }


            TextView textView = (TextView)v.findViewById(R.id.bandibook_rank);
            textView.setText(items.get(position));
            TextView textView2 = (TextView)v.findViewById(R.id.bandibook_name);
            textView2.setText(items2.get(position));
            TextView textView3 = (TextView)v.findViewById(R.id.bandibook_writer);
            textView3.setText(items3.get(position));
            TextView textView4 = (TextView)v.findViewById(R.id.bandibook_company);
            textView4.setText(items4.get(position));
            TextView textView5 = (TextView)v.findViewById(R.id.bandibook_price);
            textView5.setText(items5.get(position));

            return v;

        }

    }

}