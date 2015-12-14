// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

public class LinearHorizontalRecyclerView extends RecyclerView
{

    private float a;
    private float b;

    public LinearHorizontalRecyclerView(Context context)
    {
        super(context);
    }

    public LinearHorizontalRecyclerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public LinearHorizontalRecyclerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        boolean flag2;
        flag2 = true;
        getParent().requestDisallowInterceptTouchEvent(true);
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 44
    //                   0 90
    //                   1 155
    //                   2 114;
           goto _L1 _L2 _L3 _L4
_L3:
        break MISSING_BLOCK_LABEL_155;
_L1:
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = true;
_L5:
        ViewParent viewparent = getParent();
        if (!flag || ((LinearLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0 || flag1)
        {
            flag2 = false;
        }
        viewparent.requestDisallowInterceptTouchEvent(flag2);
        return super.onInterceptTouchEvent(motionevent);
_L2:
        a = motionevent.getX();
        b = motionevent.getY();
        flag1 = false;
        flag = true;
          goto _L5
_L4:
        if (Math.abs(motionevent.getX() - a) > Math.abs(motionevent.getY() - b))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = false;
          goto _L5
        flag1 = true;
        flag = true;
          goto _L5
    }
}
