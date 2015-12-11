// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class SelectableLayout extends LinearLayout
{

    private float mDownPosY;
    private boolean mMoveOccured;

    public SelectableLayout(Context context)
    {
        super(context);
        mMoveOccured = false;
        mDownPosY = 0.0F;
    }

    public SelectableLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mMoveOccured = false;
        mDownPosY = 0.0F;
    }

    public SelectableLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mMoveOccured = false;
        mDownPosY = 0.0F;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 36
    //                   0 42
    //                   1 94
    //                   2 63
    //                   3 119;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return super.onInterceptTouchEvent(motionevent);
_L2:
        setEffectPressed(true);
        mDownPosY = motionevent.getY();
        mMoveOccured = false;
        continue; /* Loop/switch isn't completed */
_L4:
        if (Math.abs(motionevent.getY() - mDownPosY) > 10F)
        {
            mMoveOccured = true;
            setEffectPressed(false);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (!mMoveOccured)
        {
            mMoveOccured = false;
            mDownPosY = 0.0F;
        }
        setEffectPressed(false);
        continue; /* Loop/switch isn't completed */
_L5:
        setEffectPressed(false);
        if (true) goto _L1; else goto _L6
_L6:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        boolean flag1 = super.onTouchEvent(motionevent);
        flag = flag1;
        if (!flag1)
        {
            flag = flag1;
            if (motionevent.getAction() == 0)
            {
                flag = true;
            }
        }
        motionevent.getAction();
        JVM INSTR tableswitch 1 2: default 48
    //                   1 80
    //                   2 50;
           goto _L1 _L2 _L3
_L1:
        return flag;
_L3:
        if (Math.abs(motionevent.getY() - mDownPosY) > 10F)
        {
            mMoveOccured = true;
            setEffectPressed(false);
            return flag;
        }
          goto _L1
_L2:
        if (!mMoveOccured)
        {
            mMoveOccured = false;
            mDownPosY = 0.0F;
        }
        setEffectPressed(false);
        return flag;
    }

    protected void setEffectPressed(boolean flag)
    {
        if (flag)
        {
            int i = getPaddingLeft();
            int j = getPaddingTop();
            int k = getPaddingRight();
            int l = getPaddingBottom();
            setBackgroundResource(com.amazon.mShop.android.lib.R.drawable.orange_outline_sharp_corner);
            setPadding(i, j, k, l);
            return;
        } else
        {
            setBackgroundColor(getResources().getColor(0x106000d));
            return;
        }
    }
}
