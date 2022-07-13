package sg.edu.rp.c346.id21013643.problemstatementl09;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSingers, etYear;
    Button btnInsert, btnShowList;
    RatingBar rbInsertStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        etTitle = findViewById(R.id.etTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShow);
        //rg = findViewById(R.id.rgStars);
        rbInsertStar = findViewById(R.id.rb);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = etTitle.getText().toString().trim();
                String singers = etSingers.getText().toString().trim();
                if (title.length() == 0 || singers.length() == 0){
                    Toast.makeText(MainActivity.this, "Incomplete data", Toast.LENGTH_SHORT).show();
                    return;
                }

                String year_str = etYear.getText().toString().trim();
                int year = Integer.valueOf(year_str);
                //int stars = getStars();

                DBHelper dbh = new DBHelper(MainActivity.this);

                int rating = (int) rbInsertStar.getRating();

                //long result = dbh.insertSong(title, singers, year, stars);
                long result = dbh.insertSong(title, singers, year, rating);

                if (result != -1) {
                    Toast.makeText(MainActivity.this, "Song inserted", Toast.LENGTH_LONG).show();
                    etTitle.setText("");
                    etSingers.setText("");
                    etYear.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Insert failed", Toast.LENGTH_LONG).show();
                }


            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

    }
}