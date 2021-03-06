package com.zinc.jrecycleview.anim;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zinc.jrecycleview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author       : Jiang Pengyong
 * time         : 2018-04-17 22:23
 * email        : 56002982@qq.com
 * desc         : 动画
 * version      : 1.0.0
 */

public class AnimActivity extends AppCompatActivity {

    private static final String TYPE = "ANIM_TYPE";

    private final static int PAGE_SIZE = 100;
    private RecyclerView mRecycleView;

    private AnimAdapter mAdapter;
    private final List<String> data = new ArrayList<>();
    private int mType;

    public static void startActivity(Context context, int type) {
        Intent intent = new Intent(context, AnimActivity.class);

        intent.putExtra(TYPE, type);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        mType = getIntent().getIntExtra(TYPE, AnimFactory.SLIDE_TOP);

        mRecycleView = findViewById(R.id.recycle_view);

        getInitData();

        mAdapter = new AnimAdapter(this, data);
        // 加入视图动画
        // 设置动画（设置动画会默认开启动画）
        mAdapter.setAnimations(AnimFactory.getAnimSet(mType));
        mAdapter.setOpenAnim(true);

        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(mAdapter);

    }

    public void getInitData() {
        data.clear();
        for (int i = 1; i <= PAGE_SIZE; ++i) {
            data.add("zinc Power" + i);
        }
    }

}