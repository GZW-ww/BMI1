package com.ueusoft.bmicalculatoractivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.BreakIterator;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button button1,button2;
    EditText heightText,weightText;
    TextView BMIText,classificationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        button1=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        heightText=findViewById(R.id.height);
        weightText=findViewById(R.id.weight);
        BMIText=findViewById(R.id.text2);
        classificationText=findViewById(R.id.text4);
        //计算结果
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat nf=new DecimalFormat("0.00");//保留两位小数
                double weight,height,BMI;
                weight=Double.parseDouble(weightText.getText().toString());
                height=Double.parseDouble(heightText.getText().toString());
                BMI=weight/(height*height);//计算公式
                BMIText.setText(nf.format(BMI));
                if (BMI<20){
                    classificationText.setText("偏瘦   你都这么瘦了，还不快去吃好吃的");
                }
                else if(BMI>25){
                    classificationText.setText("超重了  注意饮食健康哦");
                }else {
                    classificationText.setText("正常 继续保持哦");
                }
            }
        });
//清除数据
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightText.setText("");
                heightText.setText("");
                BMIText.setText("");
                classificationText.setText("");
            }
        });
    }
}