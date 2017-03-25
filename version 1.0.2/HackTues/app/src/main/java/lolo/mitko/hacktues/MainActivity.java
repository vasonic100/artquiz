package lolo.mitko.hacktues;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssetManager assetManager = getAssets();
        try {
            InputStream  input = assetManager.open("questions.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(input));

            String line;
            while((line=br.readLine())!=null){
                Log.d("123",line);
            }
            Log.d("123","passed");
        } catch (IOException e) {
            Log.d("123","nope");
            e.printStackTrace();
        }

        enable_buttons();

    }

    private void enable_buttons() {
        btn_start = (Button) findViewById(R.id.button_start);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Questions.class);
                startActivity(i);
            }
        });

    }
}