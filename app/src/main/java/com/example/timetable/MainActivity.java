package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button[] button=new Button[56];//button的集合
    class_table class_table=new class_table();//课表
    public int weeknum;//周数
    Boolean viewid=false;//用来记录屏幕的位置，flase是周一到周五，true是周三到周日
    Boolean coverid=false;//用来表示是否显示不在的课，true为显示
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            button_and_table();//初始化
        }
        catch (Exception e){
            new log_out().log_out(e);
        }
    }
    public void button_and_table(){//初始化按钮和课表周数
        button[11] = findViewById(R.id.button11);
        button[12] = findViewById(R.id.button12);
        button[13] = findViewById(R.id.button13);
        button[14] = findViewById(R.id.button14);
        button[15] = findViewById(R.id.button15);
        button[21] = findViewById(R.id.button21);
        button[22] = findViewById(R.id.button22);
        button[23] = findViewById(R.id.button23);
        button[24] = findViewById(R.id.button24);
        button[25] = findViewById(R.id.button25);
        button[31] = findViewById(R.id.button31);
        button[32] = findViewById(R.id.button32);
        button[33] = findViewById(R.id.button33);
        button[34] = findViewById(R.id.button34);
        button[35] = findViewById(R.id.button35);
        button[41] = findViewById(R.id.button41);
        button[42] = findViewById(R.id.button42);
        button[43] = findViewById(R.id.button43);
        button[44] = findViewById(R.id.button44);
        button[45] = findViewById(R.id.button45);
        button[51] = findViewById(R.id.button51);
        button[52] = findViewById(R.id.button52);
        button[53] = findViewById(R.id.button53);
        button[54] = findViewById(R.id.button54);
        button[55] = findViewById(R.id.button55);
        class_table.set_class();
        time time=new time();
        time.gettime();
        weeknum=time.week_num;
        class_on();
        TextView textView=findViewById(R.id.textView6);
        String text="这是第"+Integer.toString(time.week_num)+"周";
        textView.setText(text);
    }

    //设置课表
    public void class_on(){
        int[] class_posion;
        if(!viewid){//根据viewid判断应该读取哪些课
            class_posion= new int[]{11, 12, 13, 14, 15, 21, 22, 23, 24, 25, 31, 32, 33, 34, 35, 41, 42, 43, 44, 45, 51, 52, 53, 54, 55};
        }
        else{
            class_posion= new int[]{31, 32, 33, 34, 35, 41, 42, 43, 44, 45, 51, 52, 53, 54, 55, 61, 62, 63, 64, 65, 71, 72, 73, 74, 75};
        }
        for(int i=0;i<class_posion.length;i++){
            int posion=class_posion[i];

            //根据viewid选择button
            Button buttonx;
            if(!viewid){
                buttonx=button[posion];
            }
            else{
                buttonx=button[posion-20];
            }

            if(class_table.title[posion]==null){
                buttonx.setVisibility(View.INVISIBLE);
            }
            else{
                buttonx.setText(class_table.title[posion]);
                if(class_table.start_week[posion]>weeknum||class_table.over_week[posion]<weeknum){
                    if(coverid){
                        buttonx.setVisibility(View.VISIBLE);
                    }
                    else{
                        buttonx.setVisibility(View.INVISIBLE);
                    }
                }
                else{
                    buttonx.setVisibility(View.VISIBLE);
                }

            }
        }
    }
    public void week_num_change(Boolean change){//这里的change是true则是加是flase则是减少
        if(change){
            week_num++;
        }
        else{
            week_num=week_num-1;
        }
        class_on();
    }
    public void view_change(){//修改viewID并且重置课表达到翻页的效果，这个函数给翻页按钮
        if(viewid){
            viewid=false;
        }
        else{
            viewid=false;
        }
        class_on();
    }
    public void tanchuang(int location){//弹出窗口，int是课的代号
        if(viewid){//当视角处在周三到周日的时候，传来的位置要+20
            location=location+20;
        }
        AlertDialog alertDialog1=new AlertDialog.Builder(this)
                .setTitle(class_table.title[location])//标题
                .setMessage("教师：+"+class_table.teacher[location]+"\n" +
                        "时间："+Integer.toString(class_table.start_week[location])+"-"+Integer.toString(class_table.over_week[location])+"周\n" +
                        "地点："+class_table.posion[location])//内容
                .create();
        alertDialog1.show();
    }
    public void test(View view){

    }




//----------------------以下是button的批量界面，以及该class结尾的}----------------------------------------------------
    public void button11(View view){
        tanchuang(11);
    }
    public void button12(View view){
        tanchuang(12);
    }
    public void button13(View view){
        tanchuang(13);
    }
    public void button14(View view){
        tanchuang(14);
    }
    public void button15(View view){
        tanchuang(15);
    }
    public void button21(View view){
        tanchuang(21);
    }
    public void button22(View view){
        tanchuang(22);
    }
    public void button23(View view){
        tanchuang(23);
    }
    public void button24(View view){
        tanchuang(24);
    }
    public void button25(View view){
        tanchuang(25);
    }
    public void button31(View view){
        tanchuang(31);
    }
    public void button32(View view){
        tanchuang(32);
    }
    public void button33(View view){
        tanchuang(33);
    }
    public void button34(View view){
        tanchuang(34);
    }
    public void button35(View view){
        tanchuang(35);
    }
    public void button41(View view){
        tanchuang(41);
    }
    public void button42(View view){
        tanchuang(42);
    }
    public void button43(View view){
        tanchuang(43);
    }
    public void button44(View view){
        tanchuang(44);
    }
    public void button45(View view){
        tanchuang(45);
    }
    public void button51(View view){
        tanchuang(51);
    }
    public void button52(View view){
        tanchuang(52);
    }
    public void button53(View view){
        tanchuang(53);
    }
    public void button54(View view){
        tanchuang(54);
    }
    public void button55(View view){
        tanchuang(55);
    }    
}