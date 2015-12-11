// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class GrouponListView extends ListView
{

    private static final float THRESHOLD = 10F;
    float downX;
    float downY;

    public GrouponListView(Context context)
    {
        super(context);
    }

    public GrouponListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public GrouponListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i = motionevent.getActionMasked();
        if (i == 0)
        {
            downX = motionevent.getX();
            downY = motionevent.getY();
        } else
        if (i == 2)
        {
            float f1 = motionevent.getX();
            float f = Math.abs(motionevent.getY() - downY);
            f1 = Math.abs(f1 - downX);
            if (f > 10F && f > f1)
            {
                motionevent.setAction(0);
                motionevent.setLocation(downX, downY);
                onTouchEvent(motionevent);
                return true;
            }
        }
        return false;
    }
}
