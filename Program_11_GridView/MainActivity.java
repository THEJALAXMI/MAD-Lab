package com.example.grid;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    int[] images = {
            R.drawable.damon,
            R.drawable.stefan,
            R.drawable.elijah,
            R.drawable.klaus,
            R.drawable.kol,
            R.drawable.tyler
    };

    String[] names = {
            "DAMON",
            "STEFAN",
            "ELIJAH",
            "KLAUS",
            "KOL",
            "TYLER"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        ImageAdapter adapter = new ImageAdapter(this, images);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        showAlertDialog(position);
                    }
                }
        );
    }

    private void showAlertDialog(int position) {

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(images[position]);

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder.setTitle(names[position]);

        builder.setMessage(
                "YOU SELECTED " + names[position]
        );

        builder.setIcon(images[position]);

        builder.setPositiveButton("OKAY", null);

        builder.show();
    }
}