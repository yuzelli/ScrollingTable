package com.example.scrollingtablejava;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    //头部吸顶视图
    View mHeadStickyView;
    //头部吸顶的右侧滑动视图
    SyncHScrollView mHeadStickyHSView;
    //列表的头部视图
//    View mHeadHeaderView;
//    //列表的头部视图的右侧滑动视图
//    SyncHScrollView mHeadHeaderHSView;
    //列表视图
    ListView lv_produce;
    //数据适配器
   public ScrollingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //列表的头部视图
//        mHeadHeaderView = View.inflate(this, R.layout.item_scrolling_table, null);
//        mHeadHeaderHSView = (SyncHScrollView) mHeadHeaderView.findViewById(R.id.horizontalScrollView1);
//        mHeadHeaderView.setClickable(true);


        //头部吸顶视图
        mHeadStickyView = findViewById(R.id.head);
        mHeadStickyHSView = (SyncHScrollView) findViewById(R.id.horizontalScrollView1);
        mHeadStickyHSView.addOnScrollChangedListener(new ScrollingAdapter.OnScrollChangedListenerImp(mHeadStickyHSView));
        //TODO 划重点：这里需要从传入的列表头拿到里面的右侧滑动控件
        mHeadStickyView.setOnTouchListener(new ListViewAndHeadViewTouchListener());

        lv_produce = (ListView) findViewById(R.id.lv_produce);
//        lv_produce.addHeaderView(mHeadHeaderView);
        lv_produce.setOnTouchListener(new ListViewAndHeadViewTouchListener());


        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("ssss" + i);
        }

        adapter = new ScrollingAdapter(this, list, mHeadStickyHSView);


        lv_produce.setAdapter(adapter);

        lv_produce.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
             
            }
        });
    }


    /**
     * TODO 划重点：用来将头部和列表上面的触摸事件都分发给头部的滑动控件
     */
    class ListViewAndHeadViewTouchListener implements View.OnTouchListener {


        @Override
        public boolean onTouch(View v, MotionEvent event) {

//            mHeadHeaderHSView.onTouchEvent(event);
            mHeadStickyHSView.onTouchEvent(event);
            return false;
        }
    }
}
