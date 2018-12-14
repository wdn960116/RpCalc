package com.wdn.rpcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    private TextView tv_name;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        tv_name = findViewById(R.id.tv_name);
        tv_result = findViewById(R.id.tv_result);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int sex = intent.getIntExtra("sex", 0);
        System.out.println("sex"+sex);
        tv_name.setText(name);
        byte[] result;
        result=name.getBytes();
        int score =0;
        switch (sex){
            case Sex.SEX_MALE:
               showArray(result,Sex.SEX_MALE);
                break;
                case Sex.SEX_FEMALE:
                    showArray(result,Sex.SEX_FEMALE);
                    break;
                    case Sex.SEX_UNKOWN:
                        showArray(result,Sex.SEX_UNKOWN);
                        break;
                        default:
                            break;
        }

        for (byte s:result){
            score+=s&0xff;
            System.out.println("score"+score);
        }
        score=Math.abs(score)%100;
        tv_result.setText("人品值为："+score);
    }


   private void showArray(byte[] arr,int sex) {
       for (int i = 0; i < arr.length; i++) {
           arr[i] += sex;
           System.out.print(arr[i]);
       }
       System.out.println();
   }

}
