// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            l, m

public class ObservableRelativeLayout extends RelativeLayout
{

    private l a;
    private m b;

    public ObservableRelativeLayout(Context context)
    {
        super(context);
        a = null;
        b = null;
    }

    public ObservableRelativeLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
        b = null;
    }

    public ObservableRelativeLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = null;
        b = null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (a == null)
        {
            return false;
        } else
        {
            return a.a(motionevent);
        }
    }

    public void setOnInterceptTouchEventListener(l l1)
    {
        a = l1;
    }

    public void setOnPressStateChangeListener(m m1)
    {
        b = m1;
    }

    public void setPressed(boolean flag)
    {
        super.setPressed(flag);
        if (b != null)
        {
            b.a(this, flag);
        }
    }
}
