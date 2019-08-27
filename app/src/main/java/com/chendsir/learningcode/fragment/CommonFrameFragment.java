package com.chendsir.learningcode.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.chendsir.learningcode.R;
import com.chendsir.learningcode.adapter.CommonFragmentAdapter;

public class CommonFrameFragment extends BaseFragment {
	private static final String TAG = "test";
	private TextView textView;
	private ListView listView;
	private String[] datas;
	private CommonFragmentAdapter adapter;

	@Override
	protected View initView() {
		Log.e(TAG, "常用框架别初始化了...");
		View view = View.inflate(mContext, R.layout.common_fragment_frame, null);
		listView = view.findViewById(R.id.listview);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String data = datas[position];
				Toast.makeText(mContext, "data=" + data, Toast.LENGTH_SHORT).show();
			}
		});
		return view;

//		textView = new TextView(mContext);
//		textView.setGravity(Gravity.CENTER);
//		textView.setTextSize(20);
//		textView.setTextColor(Color.BLACK);

	}

	@Override
	protected void initData() {
		super.initData();
		Log.e(TAG, "常用框架别初始化了...");
		//textView.setText("我是常用框架页面");
		datas = new String[] {"OKHttp", "xUtils3","Retrofit2","Fresco","Glide",
				"greenDao","RxJava","volley","Gson","FastJson",
				"picasso","evenBus","jcvideoplayer","pulltorefresh",
				"Expandablelistview","UniversalVideoView","....."};
		//adapter = new CommonFragmentAdapter(mContext,datas);
		ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(mContext,android.R.layout.simple_list_item_1,datas);
		listView.setAdapter(myAdapter);
	}
}
