// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;

public class RoundCornerListView extends ListView
{

    public RoundCornerListView(Context context)
    {
        super(context);
    }

    public RoundCornerListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 38
    //                   1 32
    //                   2 32;
           goto _L1 _L2 _L1 _L1
_L1:
        return super.onInterceptTouchEvent(motionevent);
_L2:
        int i = pointToPosition((int)motionevent.getX(), (int)motionevent.getY());
        if (i != -1)
        {
            if (i == 0)
            {
                if (i == getAdapter().getCount() - 1)
                {
                    setSelector(0x7f020251);
                } else
                {
                    setSelector(0x7f020254);
                }
            } else
            if (i == getAdapter().getCount() - 1)
            {
                setSelector(0x7f020252);
            } else
            {
                setSelector(0x7f020253);
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
