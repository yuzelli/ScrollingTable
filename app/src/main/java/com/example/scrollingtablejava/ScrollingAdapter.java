package com.example.scrollingtablejava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import java.util.List;

/**
 * @version $Rev$
 * @auther 51644
 * @time 2018/8/27.14:30
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateData $Author$
 * @updatedes ${TODO}
 */

public class ScrollingAdapter extends BaseAdapter {

    private List<String> currentData;

    private LayoutInflater inflater;
    private Context context;
    /**
     * ListView头部中的横向滑动视图
     */
    private SyncHScrollView headScrollView;

    public ScrollingAdapter(Context context, List<String> currentData, SyncHScrollView headScrollView) {
        this.currentData = currentData;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.headScrollView = headScrollView;
    }

    @Override
    public int getCount() {
        return currentData.size();
    }

    @Override
    public Object getItem(int position) {
        return currentData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_scrolling_table, parent, false);
            SyncHScrollView scrollView1 = (SyncHScrollView) convertView.findViewById(R.id.horizontalScrollView1);

            //TODO 划重点：这里需要从传入的列表头拿到里面的右侧滑动控件
            //将当前条目的右侧滑动控件添加到头部滑动控件的滑动观察者集合中

            headScrollView.addOnScrollChangedListener(new OnScrollChangedListenerImp(scrollView1));

            //进行holder的初始化操作
            holder.scrollView1 = scrollView1;
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.txt2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.txt3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.txt4 = (TextView) convertView.findViewById(R.id.textView4);
            holder.txt5 = (TextView) convertView.findViewById(R.id.textView5);
            holder.txt6 = (TextView) convertView.findViewById(R.id.textView6);
            holder.txt7 = (TextView) convertView.findViewById(R.id.textView7);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_title.setText(currentData.get(position));
        holder.txt2.setText(currentData.get(position)+"one");
        holder.txt3.setText(currentData.get(position)+"two");
        holder.txt4.setText(currentData.get(position)+"three");
        holder.txt5.setText(currentData.get(position)+"four");
        holder.txt6.setText(currentData.get(position)+"five");
        holder.txt7.setText(currentData.get(position)+"six");

        return convertView;
    }

     public static class OnScrollChangedListenerImp implements SyncHScrollView.OnScrollChangedListener {

        private SyncHScrollView mScrollViewArg;

        public OnScrollChangedListenerImp(SyncHScrollView mScrollViewArg) {
            this.mScrollViewArg = mScrollViewArg;
        }

        @Override
        public void onScrollChanged(int l, int t, int oldl, int oldt) {
            mScrollViewArg.smoothScrollTo(l, t);
        }
    }


    class ViewHolder {

        public HorizontalScrollView scrollView1;
        public TextView tv_title;
        public TextView txt2;
        public TextView txt3;
        public TextView txt4;
        public TextView txt5;
        public TextView txt6;
        public TextView txt7;

    }
}
