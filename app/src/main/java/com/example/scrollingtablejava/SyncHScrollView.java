package com.example.scrollingtablejava;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * @version $Rev$
 * @auther 51644
 * @time 2018/8/27.13:55
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateData $Author$
 * @updatedes ${TODO}
 */

public class SyncHScrollView extends HorizontalScrollView {
    private static ScrollViewObserver mScrollViewObserver = new ScrollViewObserver();
    public SyncHScrollView(Context context) {
        super(context);
    }

    public SyncHScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SyncHScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {

        if (mScrollViewObserver != null) {
            mScrollViewObserver.notifyOnScrollChanged(l, t, oldl, oldt);
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public void addOnScrollChangedListener( OnScrollChangedListener listener) {
        mScrollViewObserver.addOnScrollChangedListener(listener);
    }

    /*
     * 取消 订阅 本控件 的 滚动条变化事件
     * */
    public void RemoveOnScrollChangedListener(OnScrollChangedListener listener) {
        mScrollViewObserver.removeOnScrollChangedListener(listener);
    }
    public interface OnScrollChangedListener {
        void onScrollChanged(int l, int t, int oldl, int oldt);
    }

    static  class ScrollViewObserver {
        List<OnScrollChangedListener> mList = null;

        public ScrollViewObserver() {
            this.mList = new ArrayList<>();
        }

        public void addOnScrollChangedListener(OnScrollChangedListener listener) {
            mList.add(listener);
        }

        public void removeOnScrollChangedListener(OnScrollChangedListener listener) {
            mList.remove(listener);
        }

        public void notifyOnScrollChanged(int l, int t, int oldl, int oldt) {
            if (mList == null || mList.size() == 0) {
                return;
            }
            for (OnScrollChangedListener listener :mList) {
                if (listener != null) {
                    listener.onScrollChanged(l, t, oldl, oldt);
                }
            }
        }
    }
}
