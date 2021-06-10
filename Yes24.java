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

public class Yes24 extends AppCompatActivity{

    final Integer[] Yes24Img = {R.drawable.yes1, R.drawable.yes2, R.drawable.yes3, R.drawable.yes4, R.drawable.yes5, R.drawable.yes6, R.drawable.yes7,
            R.drawable.yes8, R.drawable.yes9, R.drawable.yes10, R.drawable.yes11, R.drawable.yes12, R.drawable.yes13, R.drawable.yes14,
            R.drawable.yes15, R.drawable.yes16, R.drawable.yes17, R.drawable.yes18, R.drawable.yes19, R.drawable.yes20, R.drawable.yes21,
            R.drawable.yes22, R.drawable.yes23,R.drawable.yes24, R.drawable.yes25, R.drawable.yes26, R.drawable.yes27, R.drawable.yes28, R.drawable.yes29,
            R.drawable.yes30, R.drawable.yes31, R.drawable.yes32, R.drawable.yes33, R.drawable.yes34, R.drawable.yes35, R.drawable.yes36,
            R.drawable.yes37,R.drawable.yes38, R.drawable.yes39, R.drawable.yes40, R.drawable.yes41, R.drawable.yes42, R.drawable.yes43,
            R.drawable.yes44, R.drawable.yes45, R.drawable.yes46, R.drawable.yes47, R.drawable.yes48, R.drawable.yes49, R.drawable.yes50,
            R.drawable.yes51, R.drawable.yes52, R.drawable.yes53, R.drawable.yes54, R.drawable.yes55, R.drawable.yes56, R.drawable.yes57,
            R.drawable.yes58, R.drawable.yes59, R.drawable.yes60, R.drawable.yes61, R.drawable.yes62, R.drawable.yes63, R.drawable.yes64,
            R.drawable.yes65, R.drawable.yes66, R.drawable.yes67, R.drawable.yes68, R.drawable.yes69, R.drawable.yes70, R.drawable.yes71,
            R.drawable.yes72, R.drawable.yes73, R.drawable.yes74, R.drawable.yes75, R.drawable.yes76, R.drawable.yes77, R.drawable.yes78,
            R.drawable.yes79, R.drawable.yes80, R.drawable.yes81, R.drawable.yes82, R.drawable.yes83, R.drawable.yes84, R.drawable.yes85,
            R.drawable.yes86, R.drawable.yes87, R.drawable.yes88, R.drawable.yes89, R.drawable.yes90, R.drawable.yes91, R.drawable.yes92,
            R.drawable.yes93, R.drawable.yes94, R.drawable.yes95, R.drawable.yes96, R.drawable.yes97, R.drawable.yes98, R.drawable.yes99, R.drawable.yes100};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yes24);

        final ListView listYes24 = (ListView) findViewById(R.id.listYes24);

        ArrayList<String> yes24_site = new ArrayList<>();
        ArrayList<String> yes24_rank = new ArrayList<>();
        ArrayList<String> yes24_name = new ArrayList<>();
        ArrayList<String> yes24_writer = new ArrayList<>();
        ArrayList<String> yes24_company = new ArrayList<>();
        ArrayList<String> yes24_price = new ArrayList<>();

        try{
            InputStream input_yes24 = getResources().openRawResource(R.raw.yes24_best);
            BufferedReader buffered_yes24 = new BufferedReader(new InputStreamReader(input_yes24));

            String test_text;

            while((test_text = buffered_yes24.readLine()) != null) {
                String[] split = test_text.split("\t");
                yes24_site.add(split[0]);
                yes24_rank.add(split[1]);
                yes24_name.add(split[2]);
                yes24_writer.add(split[3]);
                yes24_company.add(split[4]);
                yes24_price.add(split[5]);

            }

            buffered_yes24.close();
            input_yes24.close();
        } catch(IOException e) {}

        Yes24Adapter yes24_adapter = new Yes24Adapter(this, android.R.layout.simple_list_item_1, yes24_rank, yes24_name, yes24_writer, yes24_company, yes24_price);

        listYes24.setAdapter(yes24_adapter);

    }

    private class Yes24Adapter extends ArrayAdapter<String> {
        private ArrayList<String> items, items2, items3, items4, items5;

        public Yes24Adapter(Context context, int textViewResourceld, ArrayList<String> objects, ArrayList<String> objects2, ArrayList<String> objects3, ArrayList<String> objects4, ArrayList<String> objects5) {
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
                v = vi.inflate(R.layout.yes24_items, null);
            }

            ImageView imageView = (ImageView) v.findViewById(R.id.yes24book_image);

            for(int i=1; i<101; i++) {
                String str = i+"위";
                if(str.equals(items.get(position)))
                    imageView.setImageResource(Yes24Img[i-1]);
            }


            TextView textView = (TextView)v.findViewById(R.id.yes24book_rank);
            textView.setText(items.get(position));
            TextView textView2 = (TextView)v.findViewById(R.id.yes24book_name);
            textView2.setText(items2.get(position));
            TextView textView3 = (TextView)v.findViewById(R.id.yes24book_writer);
            textView3.setText(items3.get(position));
            TextView textView4 = (TextView)v.findViewById(R.id.yes24book_company);
            textView4.setText(items4.get(position));
            TextView textView5 = (TextView)v.findViewById(R.id.yes24book_price);
            textView5.setText(items5.get(position));

            return v;

        }

    }

}



