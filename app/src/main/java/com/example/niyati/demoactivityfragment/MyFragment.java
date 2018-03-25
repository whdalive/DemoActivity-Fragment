package com.example.niyati.demoactivityfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Niyati on 2018/3/23.
 */

public class MyFragment extends Fragment {

    //声明一个接口变量
    private ICallback mCallback;

    private Button mButton;

    //将关联的Activity的引用 赋给 声明的接口变量（也即转型）
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallback = (ICallback) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,container,false);
        //button的初始化和点击事件
        mButton = view.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过接口变量调用实现类中实现的接口方法，传递一串字符串
                mCallback.getMessage("Message: This is a message from fragment");
            }
        });
        return view;
    }
}
