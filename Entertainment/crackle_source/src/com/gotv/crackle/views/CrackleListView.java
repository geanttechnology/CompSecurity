// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.ListView;

public class CrackleListView extends ListView
{

    private float mLastX;
    private float mLastY;
    private float mXDistance;
    private float mYDistance;

    public CrackleListView(Context context)
    {
        super(context);
    }

    public CrackleListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        super.dispatchKeyEvent(keyevent);
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 38
    //                   1 32
    //                   2 67;
           goto _L1 _L2 _L1 _L3
_L1:
        return super.onInterceptTouchEvent(motionevent);
_L2:
        mYDistance = 0.0F;
        mXDistance = 0.0F;
        mLastX = motionevent.getX();
        mLastY = motionevent.getY();
        continue; /* Loop/switch isn't completed */
_L3:
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        mXDistance = mXDistance + Math.abs(f - mLastX);
        mYDistance = mYDistance + Math.abs(f1 - mLastY);
        mLastX = f;
        mLastY = f1;
        if (mXDistance > mYDistance)
        {
            return false;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }
}
