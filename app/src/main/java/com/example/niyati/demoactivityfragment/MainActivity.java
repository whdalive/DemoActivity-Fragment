package com.example.niyati.demoactivityfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ICallback {

    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.activity_text);

        //获取FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //获取FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //实例化要添加的fragment
        MyFragment fragment = new MyFragment();


        //动态添加fragment
        fragmentTransaction.add(R.id.fragment_container,fragment).commit();

    }

    //实现接口方法，收到fragment传递过来的字符串后，更新TextView
    @Override
    public void getMessage(String message) {
        mTextView.setText(message);
    }
}
