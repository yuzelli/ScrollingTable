package com.example.scrollingtablejava;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * @version $Rev$
 * @auther 51644
 * @time 2018/8/27.13:53
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateData $Author$
 * @updatedes ${TODO}
 */

public class InterceptScrollContainer extends LinearLayout {
    public InterceptScrollContainer(Context context) {
        super(context);
    }

    public InterceptScrollContainer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public InterceptScrollContainer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        return true;
    }
}
