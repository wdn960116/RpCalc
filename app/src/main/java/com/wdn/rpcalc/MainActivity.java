package com.wdn.rpcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
/**
        * 人品计算器：通过输入姓名和性别，然后点击计算
        * 跳转到第二个页面显示人品值
        */
/**
 * 开发步骤：
 * 1.找到控件，并设置事件
 * 2.在点击事件当中，获取输入的信息
 * 3.将输入的信息设置到intent对象
 * 4.利用startactivity方法，将intent对象的内容传递给activity
 * 5.activity2获取到intent对象传递的内容并计算显示结果
 */
public class MainActivity extends AppCompatActivity {

    private EditText et_name;
    private RadioGroup radioGroup;
    private Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.et_name);
        radioGroup = findViewById(R.id.rg_calc);
        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });
    }
    public void click(){
        String name=et_name.getText().toString().trim();
        int id = radioGroup.getCheckedRadioButtonId();
        int sex = 0;
        if (id==R.id.rb_male){
            sex=Sex.SEX_MALE;
        }else if (id==R.id.rb_female){
            sex=Sex.SEX_FEMALE;
        }else if(id==R.id.rb_uknown){
            sex=Sex.SEX_UNKOWN;
        }
        Intent intent = new Intent();
        intent.putExtra("name",name);
        intent.putExtra("sex",sex);
        intent.setAction("android.intent.action.CalcActivity");
        intent.addCategory("android.intent.category.DEFAULT");
        startActivity(intent);
    }
}
