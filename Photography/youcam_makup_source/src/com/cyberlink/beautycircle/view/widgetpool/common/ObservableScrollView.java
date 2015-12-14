// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.perfectcorp.utility.e;
import java.lang.reflect.Field;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            n

public class ObservableScrollView extends ScrollView
{

    protected boolean a;
    private n b;
    private boolean c;
    private boolean d;
    private int e;
    private OverScroller f;

    public ObservableScrollView(Context context)
    {
        super(context);
        b = null;
        c = false;
        d = false;
        e = 0;
        f = null;
        a = true;
        a();
    }

    public ObservableScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = null;
        c = false;
        d = false;
        e = 0;
        f = null;
        a = true;
        a();
    }

    public ObservableScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b = null;
        c = false;
        d = false;
        e = 0;
        f = null;
        a = true;
        a();
    }

    private void a()
    {
        try
        {
            Field field = android/widget/ScrollView.getDeclaredField("mScroller");
            field.setAccessible(true);
            f = (OverScroller)field.get(this);
            return;
        }
        catch (Exception exception)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                exception
            });
        }
    }

    public void computeScroll()
    {
        super.computeScroll();
        if (!d) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (f == null)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "mScroller in null"
            });
            return;
        }
        if (!f.computeScrollOffset())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (e != 2)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "SCROLL_STATE_FLING"
            });
            e = 2;
            if (b != null)
            {
                b.a(this, e);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (e == 0) goto _L1; else goto _L3
_L3:
        com.perfectcorp.utility.e.b(new Object[] {
            "SCROLL_STATE_IDLE"
        });
        c = false;
        e = 0;
        if (b != null)
        {
            b.a(this, e);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i;
        if (!a)
        {
            return false;
        }
        i = motionevent.getAction();
        if (i != 0) goto _L2; else goto _L1
_L1:
        d = true;
_L4:
        return super.onInterceptTouchEvent(motionevent);
_L2:
        if (i == 1)
        {
            d = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        if (b != null)
        {
            if (!c)
            {
                c = true;
                com.perfectcorp.utility.e.b(new Object[] {
                    "SCROLL_STATE_TOUCH_SCROLL"
                });
                e = 1;
                b.a(this, 1);
            }
            b.a(this, i, j, k, l);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
        if (!a)
        {
            return false;
        }
        i = motionevent.getAction();
        if (i != 0) goto _L2; else goto _L1
_L1:
        d = true;
_L4:
        return super.onTouchEvent(motionevent);
_L2:
        if (i == 1)
        {
            d = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setOnScrollChangeListener(n n1)
    {
        b = n1;
    }

    public void setScrollable(boolean flag)
    {
        a = flag;
    }
}
