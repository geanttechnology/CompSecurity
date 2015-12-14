// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

public class DragableSpace extends ViewGroup
{

    private Scroller a;
    private VelocityTracker b;
    private int c;
    private int d;
    private float e;
    private int f;
    private int g;

    public DragableSpace(Context context)
    {
        super(context);
        c = 0;
        d = 0;
        f = 0;
        g = 0;
        a = new Scroller(context);
        g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -1));
    }

    public DragableSpace(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = 0;
        d = 0;
        f = 0;
        g = 0;
        a = new Scroller(context);
        g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -1));
        d = 0;
    }

    private void a(int i)
    {
        Log.i("DragableSpace", (new StringBuilder("snap To Screen ")).append(i).toString());
        d = i;
        i = getWidth() * i - c;
        a.startScroll(c, 0, i, 0, Math.abs(i) * 2);
        invalidate();
    }

    public void computeScroll()
    {
        if (a.computeScrollOffset())
        {
            c = a.getCurrX();
            scrollTo(c, 0);
            postInvalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        if (i != 2 || f == 0) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        float f1 = motionevent.getX();
        i;
        JVM INSTR tableswitch 0 3: default 56
    //                   0 101
    //                   1 131
    //                   2 65
    //                   3 131;
           goto _L3 _L4 _L5 _L6 _L5
_L5:
        break MISSING_BLOCK_LABEL_131;
_L3:
        break; /* Loop/switch isn't completed */
_L6:
        break; /* Loop/switch isn't completed */
_L8:
        if (f == 0)
        {
            return false;
        }
        if (true) goto _L1; else goto _L7
_L7:
        boolean flag;
        if ((int)Math.abs(f1 - e) > g)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            f = 1;
        }
          goto _L8
_L4:
        e = f1;
        int j;
        if (a.isFinished())
        {
            j = 0;
        } else
        {
            j = 1;
        }
        f = j;
          goto _L8
        f = 0;
          goto _L8
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        l = getChildCount();
        i = 0;
        for (j = 0; i < l; j = k)
        {
            View view = getChildAt(i);
            k = j;
            if (view.getVisibility() != 8)
            {
                k = view.getMeasuredWidth();
                view.layout(j, 0, j + k, view.getMeasuredHeight());
                k = j + k;
            }
            i++;
        }

    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        int l = android.view.View.MeasureSpec.getSize(i);
        if (android.view.View.MeasureSpec.getMode(i) != 0x40000000)
        {
            throw new IllegalStateException("error mode.");
        }
        if (android.view.View.MeasureSpec.getMode(j) != 0x40000000)
        {
            throw new IllegalStateException("error mode.");
        }
        int i1 = getChildCount();
        for (int k = 0; k < i1; k++)
        {
            getChildAt(k).measure(i, j);
        }

        Log.i("DragableSpace", (new StringBuilder("moving to screen ")).append(d).toString());
        scrollTo(d * l, 0);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        float f1;
        int i;
        if (b == null)
        {
            b = VelocityTracker.obtain();
        }
        b.addMovement(motionevent);
        i = motionevent.getAction();
        f1 = motionevent.getX();
        i;
        JVM INSTR tableswitch 0 3: default 64
    //                   0 74
    //                   1 196
    //                   2 107
    //                   3 338;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        c = getScrollX();
        return true;
_L2:
        Log.i("DragableSpace", "event : down");
        if (!a.isFinished())
        {
            a.abortAnimation();
        }
        e = f1;
        continue; /* Loop/switch isn't completed */
_L4:
        int j = (int)(e - f1);
        e = f1;
        if (j < 0)
        {
            if (c > 0)
            {
                scrollBy(Math.max(-c, j), 0);
            }
        } else
        if (j > 0)
        {
            int i1 = getChildAt(getChildCount() - 1).getRight() - c - getWidth();
            if (i1 > 0)
            {
                scrollBy(Math.min(i1, j), 0);
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        Log.i("DragableSpace", "event : up");
        motionevent = b;
        motionevent.computeCurrentVelocity(1000);
        int k = (int)motionevent.getXVelocity();
        if (k > 1000 && d > 0)
        {
            a(d - 1);
        } else
        if (k < -1000 && d < getChildCount() - 1)
        {
            a(d + 1);
        } else
        {
            int l = getWidth();
            l = (c + l / 2) / l;
            Log.i("DragableSpace", "from des");
            a(l);
        }
        if (b != null)
        {
            b.recycle();
            b = null;
        }
        f = 0;
        continue; /* Loop/switch isn't completed */
_L5:
        Log.i("DragableSpace", "event : cancel");
        f = 0;
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void setToScreen(int i)
    {
        Log.i("DragableSpace", (new StringBuilder("set To Screen ")).append(i).toString());
        d = i;
        int j = getWidth();
        a.startScroll(i * j, 0, 0, 0, 10);
        invalidate();
    }
}
