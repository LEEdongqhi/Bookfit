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

public class St11 extends AppCompatActivity{

    final Integer[] St11Img = {R.drawable.ele1, R.drawable.ele2, R.drawable.ele3, R.drawable.ele4, R.drawable.ele5, R.drawable.ele6, R.drawable.ele7,
            R.drawable.ele8, R.drawable.ele9, R.drawable.ele10, R.drawable.ele11, R.drawable.ele12, R.drawable.ele13, R.drawable.ele14,
            R.drawable.ele15, R.drawable.ele16, R.drawable.ele17, R.drawable.ele18, R.drawable.ele19, R.drawable.ele20, R.drawable.ele21,
            R.drawable.ele22, R.drawable.ele23,R.drawable.ele24, R.drawable.ele25, R.drawable.ele26, R.drawable.ele27, R.drawable.ele28, R.drawable.ele29,
            R.drawable.ele30, R.drawable.ele31, R.drawable.ele32, R.drawable.ele33, R.drawable.ele34, R.drawable.ele35, R.drawable.ele36,
            R.drawable.ele37,R.drawable.ele38, R.drawable.ele39, R.drawable.ele40, R.drawable.ele41, R.drawable.ele42, R.drawable.ele43,
            R.drawable.ele44, R.drawable.ele45, R.drawable.ele46, R.drawable.ele47, R.drawable.ele48, R.drawable.ele49, R.drawable.ele50,
            R.drawable.ele51, R.drawable.ele52, R.drawable.ele53, R.drawable.ele54, R.drawable.ele55, R.drawable.ele56, R.drawable.ele57,
            R.drawable.ele58, R.drawable.ele59, R.drawable.ele60, R.drawable.ele61, R.drawable.ele62, R.drawable.ele63, R.drawable.ele64,
            R.drawable.ele65, R.drawable.ele66, R.drawable.ele67, R.drawable.ele68, R.drawable.ele69, R.drawable.ele70, R.drawable.ele71,
            R.drawable.ele72, R.drawable.ele73, R.drawable.ele74, R.drawable.ele75, R.drawable.ele76, R.drawable.ele77, R.drawable.ele78,
            R.drawable.ele79, R.drawable.ele80, R.drawable.ele81, R.drawable.ele82, R.drawable.ele83, R.drawable.ele84, R.drawable.ele85,
            R.drawable.ele86, R.drawable.ele87, R.drawable.ele88, R.drawable.ele89, R.drawable.ele90, R.drawable.ele91, R.drawable.ele92,
            R.drawable.ele93, R.drawable.ele94, R.drawable.ele95, R.drawable.ele96, R.drawable.ele97, R.drawable.ele98, R.drawable.ele99, R.drawable.ele100};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st11);

        final ListView listSt11 = (ListView) findViewById(R.id.listSt11);

        ArrayList<String> st11_site = new ArrayList<>();
        ArrayList<String> st11_rank = new ArrayList<>();
        ArrayList<String> st11_name = new ArrayList<>();
        ArrayList<String> st11_writer = new ArrayList<>();
        ArrayList<String> st11_company = new ArrayList<>();
        ArrayList<String> st11_price = new ArrayList<>();

        try{
            InputStream input_st11 = getResources().openRawResource(R.raw.st11_best);
            BufferedReader buffered_st11 = new BufferedReader(new InputStreamReader(input_st11));

            String test_text;

            while((test_text = buffered_st11.readLine()) != null) {
                String[] split = test_text.split("\t");
                st11_site.add(split[0]);
                st11_rank.add(split[1]);
                st11_name.add(split[2]);
                st11_writer.add(split[3]);
                st11_company.add(split[4]);
                st11_price.add(split[5]);

            }

            buffered_st11.close();
            input_st11.close();
        } catch(IOException e) {}

        St11Adapter st11_adapter = new St11Adapter(this, android.R.layout.simple_list_item_1, st11_rank, st11_name, st11_writer, st11_company, st11_price);

        listSt11.setAdapter(st11_adapter);

    }

    private class St11Adapter extends ArrayAdapter<String> {
        private ArrayList<String> items, items2, items3, items4, items5;

        public St11Adapter(Context context, int textViewResourceld, ArrayList<String> objects, ArrayList<String> objects2, ArrayList<String> objects3, ArrayList<String> objects4, ArrayList<String> objects5) {
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
                v = vi.inflate(R.layout.st11_items, null);
            }

            ImageView imageView = (ImageView) v.findViewById(R.id.st11book_image);

            for(int i=1; i<101; i++) {
                String str = i+"위";
                if(str.equals(items.get(position)))
                    imageView.setImageResource(St11Img[i-1]);
            }


            TextView textView = (TextView)v.findViewById(R.id.st11book_rank);
            textView.setText(items.get(position));
            TextView textView2 = (TextView)v.findViewById(R.id.st11book_name);
            textView2.setText(items2.get(position));
            TextView textView3 = (TextView)v.findViewById(R.id.st11book_writer);
            textView3.setText(items3.get(position));
            TextView textView4 = (TextView)v.findViewById(R.id.st11book_company);
            textView4.setText(items4.get(position));
            TextView textView5 = (TextView)v.findViewById(R.id.st11book_price);
            textView5.setText(items5.get(position));

            return v;

        }

    }

}
