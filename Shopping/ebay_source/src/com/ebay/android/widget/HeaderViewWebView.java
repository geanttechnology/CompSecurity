// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebView;

public class HeaderViewWebView extends WebView
{

    private View header;
    private int headerHeight;
    private boolean multiTouchInHeader;
    private boolean touch;
    private float touchDownX;
    private float touchDownY;
    private boolean touchInHeader;
    private int touchSlop;
    private int visibleHeaderHeight;

    public HeaderViewWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        visibleHeaderHeight = -1;
        touch = false;
        setWillNotDraw(false);
        touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private int visibleHeaderHeight()
    {
        return headerHeight - getScrollY();
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        int i;
        boolean flag1;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        flag5 = true;
        flag4 = true;
        flag3 = false;
        i = getScrollY();
        visibleHeaderHeight = headerHeight - i;
        touch = true;
        flag1 = flag3;
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 5: default 76
    //                   0 146
    //                   1 322
    //                   2 239
    //                   3 322
    //                   4 80
    //                   5 203;
           goto _L1 _L2 _L3 _L4 _L3 _L5 _L6
_L5:
        break; /* Loop/switch isn't completed */
_L1:
        flag1 = flag3;
_L8:
        if (touchInHeader || flag1)
        {
            flag1 = false;
            if (header != null)
            {
                MotionEvent motionevent1 = MotionEvent.obtainNoHistory(motionevent);
                motionevent1.offsetLocation(getX(), i);
                flag1 = header.dispatchTouchEvent(motionevent1);
                motionevent1.recycle();
            }
            if (multiTouchInHeader)
            {
                return flag1;
            }
        }
        break; /* Loop/switch isn't completed */
_L2:
        touchDownX = motionevent.getX();
        touchDownY = motionevent.getY();
        if (touchDownY <= (float)visibleHeaderHeight)
        {
            flag1 = flag4;
        } else
        {
            flag1 = false;
        }
        touchInHeader = flag1;
        multiTouchInHeader = false;
        flag1 = flag3;
        continue; /* Loop/switch isn't completed */
_L6:
        if (motionevent.getY() <= (float)visibleHeaderHeight)
        {
            flag1 = flag5;
        } else
        {
            flag1 = false;
        }
        multiTouchInHeader = flag1;
        flag1 = flag3;
        continue; /* Loop/switch isn't completed */
_L4:
        float f = motionevent.getX() - touchDownX;
        float f1 = motionevent.getY() - touchDownY;
        boolean flag;
        if ((double)touchSlop < Math.sqrt(f * f + f1 * f1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag3;
        if (!multiTouchInHeader)
        {
            flag1 = flag3;
            if (flag)
            {
                flag1 = touchInHeader;
                touchInHeader = false;
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        flag1 = touchInHeader;
        touchInHeader = false;
        if (true) goto _L8; else goto _L7
_L7:
        motionevent = MotionEvent.obtain(motionevent);
        if (visibleHeaderHeight > 0)
        {
            motionevent.offsetLocation(0.0F, -visibleHeaderHeight);
        }
        boolean flag2 = super.dispatchTouchEvent(motionevent);
        motionevent.recycle();
        return flag2;
    }

    protected void onDraw(Canvas canvas)
    {
        if (touch && visibleHeaderHeight > 0)
        {
            int i = canvas.save();
            canvas.translate(0.0F, visibleHeaderHeight);
            super.onDraw(canvas);
            canvas.restoreToCount(i);
            touch = false;
            return;
        }
        int j = visibleHeaderHeight();
        if (j > 0)
        {
            int k = canvas.save();
            canvas.translate(0.0F, j);
            super.onDraw(canvas);
            canvas.restoreToCount(k);
            visibleHeaderHeight = -1;
            return;
        } else
        {
            super.onDraw(canvas);
            visibleHeaderHeight = -1;
            return;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return true;
    }

    protected void onMeasure(int i, int j)
    {
        boolean flag = false;
        super.onMeasure(i, j);
        header = getChildAt(0);
        if (header == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = header.getMeasuredHeight();
        }
        headerHeight = i;
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        if (header != null)
        {
            header.offsetLeftAndRight(i - header.getLeft());
        }
    }
}
