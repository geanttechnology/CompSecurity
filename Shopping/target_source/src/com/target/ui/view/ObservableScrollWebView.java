// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

public class ObservableScrollWebView extends WebView
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(int i, int j);
    }


    private boolean mIsScrolling;
    private a mListener;

    public ObservableScrollWebView(Context context)
    {
        super(context);
        mIsScrolling = false;
    }

    public ObservableScrollWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsScrolling = false;
    }

    public ObservableScrollWebView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mIsScrolling = false;
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        mListener.a(i - k, j - l);
        mIsScrolling = true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getActionMasked();
        JVM INSTR tableswitch 1 3: default 32
    //                   1 38
    //                   2 32
    //                   3 38;
           goto _L1 _L2 _L1 _L2
_L1:
        return super.onTouchEvent(motionevent);
_L2:
        if (mIsScrolling)
        {
            mIsScrolling = false;
            if (mListener != null)
            {
                mListener.a();
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void setOnScrollListener(a a1)
    {
        mListener = a1;
    }
}
