package com.chendsir.learningcode.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.chendsir.learningcode.R;

public class LauncherActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				startMainActivity();
			}
		},3000);
	}


	private void startMainActivity() {
		startActivity(new Intent(LauncherActivity.this,MainActivity.class));
		finish();
	}
}
