// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Scroller;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            HorizontalScrollView, y

public class x
    implements android.view.View.OnTouchListener
{

    public static String a = "HorizontalScrollViewPager";
    private HorizontalScrollView b;
    private ViewGroup c;
    private boolean d;
    private boolean e;
    private Scroller f;
    private Runnable g;
    private VelocityTracker h;
    private int i;
    private int j;
    private int k;
    private y l;

    public x(HorizontalScrollView horizontalscrollview, ViewGroup viewgroup, boolean flag, y y1, boolean flag1)
    {
        d = false;
        e = false;
        i = 0;
        j = 500;
        b = horizontalscrollview;
        c = viewgroup;
        d = flag;
        e = flag1;
        if (flag)
        {
            l = y1;
        }
        f = new Scroller(b.getContext(), new OvershootInterpolator());
        g = new Runnable() {

            final x a;

            public void run()
            {
                x.a(a).computeScrollOffset();
                x.b(a).scrollTo(x.a(a).getCurrX(), 0);
                if (!x.a(a).isFinished())
                {
                    x.b(a).post(this);
                }
            }

            
            {
                a = x.this;
                super();
            }
        };
    }

    static Scroller a(x x1)
    {
        return x1.f;
    }

    static HorizontalScrollView b(x x1)
    {
        return x1.b;
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (h == null)
        {
            h = VelocityTracker.obtain();
        }
        if (e)
        {
            YMKLauncherEvent.a(true);
        }
        view = h;
        view.addMovement(motionevent);
        f.forceFinished(true);
        b.removeCallbacks(g);
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 88
    //                   0 90
    //                   1 126
    //                   2 88
    //                   3 105;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        return false;
_L2:
        k = motionevent.getPointerId(0);
        view.clear();
        return false;
_L4:
        h.clear();
        h.recycle();
        h = null;
        return false;
_L3:
        float f1;
        int i1;
        int k1;
        view.computeCurrentVelocity(1000);
        f1 = view.getXVelocity(k);
        Log.d(a, (new StringBuilder()).append("").append(f1).toString());
        int i2 = b.getWidth();
        int j1 = c.getPaddingLeft();
        int j2 = c.getWidth() - c.getPaddingLeft();
        k1 = j2 - i2;
        int l1 = b.getScrollX();
        i1 = i2 / 2;
        if (d)
        {
            if (f1 > (float)j)
            {
                i1 = i - 1;
            } else
            if (f1 < (float)(-j))
            {
                i1 = i + 1;
            } else
            {
                i1 = ((i1 + l1) - j1) / i2;
                if (k1 / i2 == i1 && l1 > i1 * i2 && l1 % i2 > (j2 % i2) / 2)
                {
                    i1++;
                }
            }
            if (i1 >= 0 && i1 <= j2 / i2)
            {
                i = i1;
                if (l != null)
                {
                    l.a(i);
                }
            }
            i1 = i1 * i2 + j1;
        } else
        {
            if (f1 <= (float)j)
            {
                continue; /* Loop/switch isn't completed */
            }
            i1 = j1;
        }
_L6:
        f.startScroll(l1, 0, Math.max(Math.min(k1, i1), j1) - l1, 0, 500);
        b.post(g);
        h.clear();
        h.recycle();
        h = null;
        return true;
        if (f1 >= (float)(-j)) goto _L1; else goto _L5
_L5:
        i1 = k1;
          goto _L6
        if (true) goto _L1; else goto _L7
_L7:
    }

}
