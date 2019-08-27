package com.chendsir.learningcode.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.chendsir.learningcode.R;

public class CommonFragmentAdapter extends BaseAdapter {
	private final Context mContext;
	private final String[] mDatas;

	public CommonFragmentAdapter(Context mContext, String[] mDatas) {
		this.mContext = mContext;
		this.mDatas = mDatas;
	}


	@Override
	public int getCount() {
		return mDatas.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView = new TextView(mContext);
		textView.setPadding(10,10,0,10);
		textView.setTextColor(Color.BLACK);
		textView.setTextSize(20);
		textView.setText(mDatas[position]);
		return textView;
	}
}
