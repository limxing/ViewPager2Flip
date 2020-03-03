package com.huichang.viewpager2flip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

	ViewPager2 mViewPager2;

	int[] mPic = new int[]{R.mipmap.pic1, R.mipmap.pic2, R.mipmap.pic3, R.mipmap.pic4, R.mipmap.pic5};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mViewPager2 = findViewById(R.id.mViewPager2);
		mViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
		mViewPager2.setPageTransformer(
				new StereoPagerTransformer(getResources().getDisplayMetrics().widthPixels));
		mViewPager2.setAdapter(new RecyclerView.Adapter<ViewHolder>() {
			@NonNull
			@Override
			public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
				View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_viewpager, parent, false);
				return new ViewHolder(view);
			}

			@Override
			public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
				holder.mImageView.setImageResource(mPic[position]);
			}

			@Override
			public int getItemCount() {
				return 5;
			}
		});
	}

	class ViewHolder extends RecyclerView.ViewHolder {
		public ImageView mImageView;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			mImageView = itemView.findViewById(R.id.img_bg);
		}
	}
}
