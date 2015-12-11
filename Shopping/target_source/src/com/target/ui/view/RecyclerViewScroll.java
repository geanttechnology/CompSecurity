// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class RecyclerViewScroll extends RecyclerView
{

    private boolean mDisableScrolling;

    public RecyclerViewScroll(Context context)
    {
        super(context);
    }

    public RecyclerViewScroll(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public RecyclerViewScroll(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void b(boolean flag)
    {
        mDisableScrolling = flag;
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (mDisableScrolling)
        {
            switch (motionevent.getAction())
            {
            case 2: // '\002'
            default:
                return true;

            case 0: // '\0'
            case 1: // '\001'
            case 3: // '\003'
                break;
            }
        }
        return super.dispatchTouchEvent(motionevent);
    }
}
