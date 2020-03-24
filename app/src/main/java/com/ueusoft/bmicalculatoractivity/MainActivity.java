package com.ueusoft.bmicalculatoractivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv_height=findViewById(R.id.tv_height);
        final TextView tv_weight=findViewById(R.id.tv_weight);
        Button btn_calButton=findViewById(R.id.tv_calbutton);

        Thread v;
        btn_calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String calButton = "";
                if (v.getId() == R.id.tv_calbutton) {
                    String height = tv_height.getText().toString();
                    String weight = tv_weight.getText().toString();
                    double res = 0, heightNum = 0, weightNum = 0;
                    if (!height.isEmpty() && !weight.isEmpty()) {
                        heightNum = Double.parseDouble(height);
                        weightNum = Double.parseDouble(weight);
                        res = weightNum / heightNum;
                        BreakIterator resText = null;
                        if (res < 18.5) {
                            resText.setText(String.valueOf(R.string.thin));
                        } else if (res > 24.5) {
                            resText.setText(String.valueOf(R.string.fat));
                        } else resText.setText(String.valueOf(R.string.normal));
                    } else Toast.makeText(MainActivity.this, "输入有误！", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
 }