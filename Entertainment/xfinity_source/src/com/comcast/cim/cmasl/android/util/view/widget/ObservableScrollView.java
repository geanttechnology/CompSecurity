// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ScrollView;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.widget:
//            OnObservableScrollChangedListener

public class ObservableScrollView extends ScrollView
{
    class YScrollDetector extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final ObservableScrollView this$0;

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            boolean flag = false;
            try
            {
                f1 = Math.abs(f1);
                f = Math.abs(f);
            }
            // Misplaced declaration of an exception variable
            catch (MotionEvent motionevent)
            {
                return false;
            }
            if (f1 > f)
            {
                flag = true;
            }
            return flag;
        }

        YScrollDetector()
        {
            this$0 = ObservableScrollView.this;
            super();
        }
    }


    private GestureDetector gestureDetector;
    private OnObservableScrollChangedListener onObservableScrollChangedListener;

    public ObservableScrollView(Context context)
    {
        super(context);
        onObservableScrollChangedListener = null;
        init(context);
    }

    public ObservableScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        onObservableScrollChangedListener = null;
        init(context);
    }

    public ObservableScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        onObservableScrollChangedListener = null;
        init(context);
    }

    private void init(Context context)
    {
        gestureDetector = new GestureDetector(new YScrollDetector());
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 8 && !gestureDetector.onTouchEvent(motionevent))
        {
            return false;
        } else
        {
            return super.onInterceptTouchEvent(motionevent);
        }
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        if (onObservableScrollChangedListener != null)
        {
            onObservableScrollChangedListener.onObservableScrollChanged(this, i, j, k, l);
        }
    }

    public void setOnObservableScrollChangedListener(OnObservableScrollChangedListener onobservablescrollchangedlistener)
    {
        onObservableScrollChangedListener = onobservablescrollchangedlistener;
    }
}
