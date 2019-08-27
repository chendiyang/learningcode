package com.chendsir.learningcode.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.chendsir.learningcode.R;
import com.chendsir.learningcode.fragment.BaseFragment;
import com.chendsir.learningcode.fragment.CommonFrameFragment;
import com.chendsir.learningcode.fragment.CustomFragment;
import com.chendsir.learningcode.fragment.OtherFragment;
import com.chendsir.learningcode.fragment.ThirdPartyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	private RadioGroup radioGroup;
	private int position;
	private List<BaseFragment> baseFragmentList;
	private Context mContext;
	private Fragment Tempfragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext =MainActivity.this;
		radioGroup = findViewById(R.id.rg_bottom_tag);
		initFragment();
		initListener();
	}

	private void initListener() {
		radioGroup.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
		radioGroup.check(R.id.rb_common_frame);
	}

	private void initFragment() {
		baseFragmentList = new ArrayList<>();
		baseFragmentList.add(new CommonFrameFragment());
		baseFragmentList.add(new CustomFragment());
		baseFragmentList.add(new ThirdPartyFragment());
		baseFragmentList.add(new OtherFragment());
	}

	private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (checkedId) {
				case R.id.rb_common_frame:
					position = 0;
					break;
				case R.id.rb_custom:
					position = 1;
					break;
				case R.id.rb_thirdparty:
					position = 2;
					break;
				case R.id.rb_other:
					position = 3;
					break;
				default:
					position = 0;
					break;
			}
			Fragment fragment = getFragment();
			switchFragment (Tempfragment,fragment);
		}
	}

	private void switchFragment(Fragment mtempFragment, Fragment fragment) {
		if (mtempFragment != fragment) {
			Tempfragment = fragment;
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			if (!fragment.isAdded()) {
				if (mtempFragment != null) {
					ft.hide(mtempFragment);
				}
				if (fragment != null ) {
					ft.add(R.id.fl_content,fragment).commit();
				}
			}else{
				if (mtempFragment != null) {
					ft.hide(mtempFragment);
				}
				if (fragment != null) {
					ft.show(fragment).commit();
				}
			}
		}
//		FragmentManager fm = getSupportFragmentManager();
//		FragmentTransaction transaction = fm.beginTransaction();
//		transaction.replace(R.id.fl_content,fragment);
//		transaction.commit();
	}

	private BaseFragment getFragment(){
		if (baseFragmentList != null) {
			BaseFragment baseFragment = baseFragmentList.get(position);
			return baseFragment;
		}
		return  null;
	}
}
