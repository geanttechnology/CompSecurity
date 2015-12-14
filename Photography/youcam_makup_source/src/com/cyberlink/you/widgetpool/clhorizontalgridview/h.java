// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.clhorizontalgridview;

import android.graphics.Rect;
import android.view.View;

// Referenced classes of package com.cyberlink.you.widgetpool.clhorizontalgridview:
//            AbsListView

class h
    implements Runnable
{

    final AbsListView a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private final int g;
    private int h;

    void a()
    {
        a.removeCallbacks(this);
    }

    public void run()
    {
        int i;
        int l;
        int i1;
        i = 0;
        i1 = a.getWidth();
        l = a.S;
        b;
        JVM INSTR tableswitch 1 5: default 60
    //                   1 61
    //                   2 385
    //                   3 214
    //                   4 501
    //                   5 663;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        i = a.getChildCount() - 1;
        l += i;
        if (i >= 0)
        {
            if (l == e)
            {
                a.post(this);
                return;
            }
            View view = a.getChildAt(i);
            int j1 = view.getWidth();
            int j2 = view.getLeft();
            if (l < a.al - 1)
            {
                i = Math.max(a.r.right, g);
            } else
            {
                i = a.r.right;
            }
            a.a(i + (j1 - (i1 - j2)), f, true);
            e = l;
            if (l < c)
            {
                a.post(this);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        i = a.getChildCount();
        if (l != d && i > 1 && i + l < a.al)
        {
            i = l + 1;
            if (i == e)
            {
                a.post(this);
                return;
            }
            View view1 = a.getChildAt(1);
            l = view1.getWidth();
            i1 = view1.getLeft();
            int k1 = Math.max(a.r.right, g);
            if (i < d)
            {
                a.a(Math.max(0, (i1 + l) - k1), f, true);
                e = i;
                a.post(this);
                return;
            }
            if (i1 > k1)
            {
                a.a(i1 - k1, f, true);
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (l == e)
        {
            a.post(this);
            return;
        }
        View view2 = a.getChildAt(0);
        if (view2 != null)
        {
            i1 = view2.getLeft();
            if (l > 0)
            {
                i = Math.max(g, a.r.left);
            } else
            {
                i = a.r.left;
            }
            a.a(i1 - i, f, true);
            e = l;
            if (l > c)
            {
                a.post(this);
                return;
            }
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        int l1 = a.getChildCount() - 2;
        if (l1 >= 0)
        {
            i = l + l1;
            if (i == e)
            {
                a.post(this);
                return;
            }
            View view3 = a.getChildAt(l1);
            l = view3.getWidth();
            l1 = view3.getLeft();
            int k2 = Math.max(a.r.left, g);
            e = i;
            if (i > d)
            {
                a.a(-(i1 - l1 - k2), f, true);
                a.post(this);
                return;
            }
            i = i1 - k2;
            l = l1 + l;
            if (i > l)
            {
                a.a(-(i - l), f, true);
                return;
            }
        }
        if (true) goto _L1; else goto _L6
_L6:
        int i2;
        int l2;
        if (e == l)
        {
            a.post(this);
            return;
        }
        e = l;
        i1 = a.getChildCount();
        i2 = c;
        l2 = (l + i1) - 1;
        if (i2 >= l) goto _L8; else goto _L7
_L7:
        i = (l - i2) + 1;
_L10:
        float f1;
        f1 = Math.min(Math.abs((float)i / (float)i1), 1.0F);
        if (i2 < l)
        {
            i = (int)((float)(-a.getHeight()) * f1);
            l = (int)(f1 * (float)f);
            a.a(i, l, true);
            a.post(this);
            return;
        }
        break; /* Loop/switch isn't completed */
_L8:
        if (i2 > l2)
        {
            i = i2 - l2;
        }
        if (true) goto _L10; else goto _L9
_L9:
        if (i2 > l2)
        {
            int j = (int)((float)a.getHeight() * f1);
            l = (int)(f1 * (float)f);
            a.a(j, l, true);
            a.post(this);
            return;
        } else
        {
            int k = a.getChildAt(i2 - l).getLeft() - h;
            l = (int)((float)f * ((float)Math.abs(k) / (float)a.getHeight()));
            a.a(k, l, true);
            return;
        }
    }
}
