package com.example.myapplication;
//package com.mkyong;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean checkvalid(String str)
    {
        //boolean flag=false;
        for(int i=0;i<str.length();i++)
            if(Character.isAlphabetic(str.charAt(i)))
                return false;
        return true;
    }

    public void clicked(View view) {
        TextView tv = findViewById(R.id.textView);    //textbox
        Button temp = (Button) view;
        String str = temp.getText().toString();
        str=str.substring(str.length()-1);
        String temp2 = tv.getText().toString();
        if(!checkvalid(temp2))
            temp2="";
        tv.setText(temp2 + str);
        //tv.setText(tv.getText().toString()+"1");
    }
    public void backspaceClicked(View view)
    {
        TextView tv = findViewById(R.id.textView);
        String str=tv.getText().toString();
        if(!str.equals(""))
        {
            str=str.substring(0,str.length()-1);
            tv.setText(str);
        }

    }
    public void clearClicked(View view)
    {
        TextView tv=findViewById(R.id.textView);
        tv.setText("");
    }

    public void equalsClicked(View view)
    {
        TextView tv = findViewById(R.id.textView);
        String str = tv.getText().toString();
        EvaluateString ev=new EvaluateString();
        double answer=ev.evaluate(str);
        String ans;
        ans=String.format("%.6f",answer);
        if(answer-(int)answer<0.00001)
            ans=String.format("%d",(int)answer);
        tv.setText(ans);

    }

}