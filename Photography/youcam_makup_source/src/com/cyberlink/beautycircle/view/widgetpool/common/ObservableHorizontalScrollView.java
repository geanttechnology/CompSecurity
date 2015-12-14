// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import com.perfectcorp.utility.e;
import java.lang.reflect.Field;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            k

public class ObservableHorizontalScrollView extends HorizontalScrollView
{

    private k a;
    private boolean b;
    private boolean c;
    private int d;
    private OverScroller e;

    public ObservableHorizontalScrollView(Context context)
    {
        super(context);
        a = null;
        b = false;
        c = false;
        d = 0;
        e = null;
        a();
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
        b = false;
        c = false;
        d = 0;
        e = null;
        a();
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = null;
        b = false;
        c = false;
        d = 0;
        e = null;
        a();
    }

    private void a()
    {
        try
        {
            Field field = android/widget/HorizontalScrollView.getDeclaredField("mScroller");
            field.setAccessible(true);
            e = (OverScroller)field.get(this);
            return;
        }
        catch (Exception exception)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                exception
            });
        }
    }

    private void a(boolean flag)
    {
        ViewParent viewparent1 = getParent();
        ViewParent viewparent = viewparent1;
        if (viewparent1 != null)
        {
            viewparent1.requestDisallowInterceptTouchEvent(flag);
            viewparent = viewparent1;
        }
        do
        {
            if (viewparent == null)
            {
                break;
            }
            if (viewparent instanceof SwipeRefreshLayout)
            {
                ViewParent viewparent2 = viewparent.getParent();
                viewparent = viewparent2;
                if (viewparent2 != null)
                {
                    viewparent2.requestDisallowInterceptTouchEvent(flag);
                    viewparent = viewparent2;
                }
            } else
            {
                viewparent = viewparent.getParent();
            }
        } while (true);
    }

    public void computeScroll()
    {
        super.computeScroll();
        if (!c) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (e == null)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "mScroller in null"
            });
            return;
        }
        if (!e.computeScrollOffset())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (d != 2)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "SCROLL_STATE_FLING"
            });
            d = 2;
            if (a != null)
            {
                a.a(this, d);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (d == 0) goto _L1; else goto _L3
_L3:
        com.perfectcorp.utility.e.b(new Object[] {
            "SCROLL_STATE_IDLE"
        });
        b = false;
        d = 0;
        if (a != null)
        {
            a.a(this, d);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        if (i != 0) goto _L2; else goto _L1
_L1:
        a(true);
_L4:
        return super.onInterceptTouchEvent(motionevent);
_L2:
        if (i == 1 || i == 3)
        {
            a(false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onScrollChanged(int i, int j, int l, int i1)
    {
        super.onScrollChanged(i, j, l, i1);
        if (a != null)
        {
            if (!b)
            {
                b = true;
                com.perfectcorp.utility.e.b(new Object[] {
                    "SCROLL_STATE_TOUCH_SCROLL"
                });
                d = 1;
                a.a(this, 1);
            }
            a.a(this, i, j, l, i1);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        if (i != 0) goto _L2; else goto _L1
_L1:
        a(true);
_L4:
        return super.onTouchEvent(motionevent);
_L2:
        if (i == 1 || i == 3)
        {
            a(false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setOnScrollChangeListener(k k1)
    {
        a = k1;
    }
}
