// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            w

public class HorizontalScrollView extends android.widget.HorizontalScrollView
{

    private int a;
    private boolean b;
    private w c;

    public HorizontalScrollView(Context context)
    {
        super(context);
        a = 1;
        b = false;
        c = null;
    }

    public HorizontalScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 1;
        b = false;
        c = null;
    }

    public HorizontalScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = 1;
        b = false;
        c = null;
    }

    public void fling(int i)
    {
        super.fling(a * i);
    }

    public int getAmplifyValue()
    {
        return a;
    }

    public w getOnScrollChangedListener()
    {
        return c;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        flag = super.onInterceptTouchEvent(motionevent);
        if (motionevent.getActionMasked() == 0)
        {
            b = false;
        }
        if (!b) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        b = true;
        if (c == null) goto _L1; else goto _L3
_L3:
        c.b();
        return flag;
        if (flag || b || motionevent.getActionMasked() != 3 && motionevent.getActionMasked() != 1 || c == null) goto _L1; else goto _L4
_L4:
        c.a();
        return flag;
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        if (c != null)
        {
            c.a(i, j, k, l);
        }
    }

    public void setAmplifyValue(int i)
    {
        a = i;
    }

    public void setOnScrollChangedListener(w w1)
    {
        c = w1;
    }
}
