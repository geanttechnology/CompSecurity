// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.groupon.util.ScrollChangeListener;

public class ScrollEventRecyclerView extends RecyclerView
{

    protected float delta;
    protected ScrollChangeListener deltaListener;
    protected float originTouch;

    public ScrollEventRecyclerView(Context context)
    {
        super(context);
    }

    public ScrollEventRecyclerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public ScrollEventRecyclerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (deltaListener == null) goto _L2; else goto _L1
_L1:
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 36
    //                   0 42
    //                   1 36
    //                   2 53;
           goto _L2 _L3 _L2 _L4
_L2:
        return super.onInterceptTouchEvent(motionevent);
_L3:
        originTouch = motionevent.getRawY();
        continue; /* Loop/switch isn't completed */
_L4:
        originTouch = motionevent.getRawY();
        if (true) goto _L2; else goto _L5
_L5:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (deltaListener == null) goto _L2; else goto _L1
_L1:
        motionevent.getAction();
        JVM INSTR tableswitch 1 3: default 36
    //                   1 79
    //                   2 42
    //                   3 79;
           goto _L2 _L3 _L4 _L3
_L2:
        return super.onTouchEvent(motionevent);
_L4:
        delta = originTouch - motionevent.getRawY();
        originTouch = motionevent.getRawY();
        deltaListener.onScrollDelta(delta);
        continue; /* Loop/switch isn't completed */
_L3:
        deltaListener.onScrollFinish(delta);
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void setOnScrollDelta(ScrollChangeListener scrollchangelistener)
    {
        deltaListener = scrollchangelistener;
    }
}
