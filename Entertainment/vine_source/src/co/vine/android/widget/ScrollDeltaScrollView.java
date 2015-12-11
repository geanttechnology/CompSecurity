// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ScrollDeltaScrollView extends ScrollView
{
    public static interface ScrollDeltaListener
    {

        public abstract void onScroll(int i);
    }


    private int mLastT;
    private ScrollDeltaListener mScrollDeltaListener;

    public ScrollDeltaScrollView(Context context)
    {
        super(context);
        mScrollDeltaListener = null;
        mLastT = 0;
    }

    public ScrollDeltaScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mScrollDeltaListener = null;
        mLastT = 0;
    }

    public ScrollDeltaScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mScrollDeltaListener = null;
        mLastT = 0;
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        i = j;
        if (j < 0)
        {
            i = 0;
        }
        if (mScrollDeltaListener != null)
        {
            mScrollDeltaListener.onScroll(mLastT - i);
        }
        mLastT = i;
    }

    public void setScrollDeltaListener(ScrollDeltaListener scrolldeltalistener)
    {
        mScrollDeltaListener = scrolldeltalistener;
    }
}
