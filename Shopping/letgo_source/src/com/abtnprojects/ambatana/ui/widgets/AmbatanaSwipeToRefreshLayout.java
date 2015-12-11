// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.aqo;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class AmbatanaSwipeToRefreshLayout extends SwipeRefreshLayout
{
    public static interface a
    {

        public abstract boolean a();
    }


    private a c;
    private boolean d;

    public AmbatanaSwipeToRefreshLayout(Context context)
    {
        this(context, null);
    }

    public AmbatanaSwipeToRefreshLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public boolean a()
    {
        if (c == null)
        {
            aqo.c("OnChildScrollUpListener not set", new Object[0]);
        }
        if (c == null)
        {
            return false;
        } else
        {
            return c.a();
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        d = true;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        d = false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (d)
        {
            return super.onInterceptTouchEvent(motionevent);
        } else
        {
            return true;
        }
    }

    public void setAcceptEvents(boolean flag)
    {
        d = flag;
    }

    public void setOnChildScrollUpListener(a a1)
    {
        c = a1;
    }
}
