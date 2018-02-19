package com.example.cheeyene.colorcounter;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    public static final Random rnd = new Random();
    ConstraintLayout bg;
    Button mCounterButton;
    Button mResetButton;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bg = (ConstraintLayout) findViewById(R.id.constraintlayout);

        mCounterButton = (Button) findViewById(R.id.counterbutton);
        mResetButton = (Button) findViewById(R.id.resetbutton);
        text=(TextView)findViewById(R.id.txt1);

        mCounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                text.setText(Integer.toString(count));
                if ((count % 2) == 0) {
                    int col = Color.argb(255, rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
                    bg.setBackgroundColor(col);
                }else if((count % 2) != 0){
                    bg.setBackgroundColor(Color.WHITE);
                }
            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                text.setText("" + count);
                bg.setBackgroundColor(Color.WHITE);
            }
        });
    }


}
