// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class TouchableRelativeLayout extends RelativeLayout
{
    public static interface TouchListener
    {

        public abstract boolean onInterceptTouchEvent(MotionEvent motionevent);

        public abstract boolean onTouchEvent(MotionEvent motionevent);
    }


    public TouchListener mTouchListener;

    public TouchableRelativeLayout(Context context)
    {
        super(context);
    }

    public TouchableRelativeLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (mTouchListener != null)
        {
            return mTouchListener.onInterceptTouchEvent(motionevent);
        } else
        {
            return super.onInterceptTouchEvent(motionevent);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (mTouchListener != null)
        {
            return mTouchListener.onTouchEvent(motionevent);
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public void setTouchListener(TouchListener touchlistener)
    {
        mTouchListener = touchlistener;
    }
}
