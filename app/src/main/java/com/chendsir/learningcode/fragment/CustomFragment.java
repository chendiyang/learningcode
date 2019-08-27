package com.chendsir.learningcode.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class CustomFragment extends BaseFragment {
	private static final String TAG = "test";
	private TextView textView;


	@Override
	protected View initView() {
		Log.e(TAG, "自定义页面初始化了...");
		textView = new TextView(mContext);
		textView.setGravity(Gravity.CENTER);
		textView.setTextSize(20);
		textView.setTextColor(Color.BLACK);
		return textView;
	}

	@Override
	protected void initData(){
		super.initData();
		Log.e(TAG, "自定义页面初始化了...");
		textView.setText("我是自定义页面");
	}
}
