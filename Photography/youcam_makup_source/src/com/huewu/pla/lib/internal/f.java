// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib.internal;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewConfiguration;

// Referenced classes of package com.huewu.pla.lib.internal:
//            PLA_AbsListView

class f
    implements Runnable
{

    final PLA_AbsListView a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private final int g;
    private int h;

    f(PLA_AbsListView pla_abslistview)
    {
        a = pla_abslistview;
        super();
        g = ViewConfiguration.get(pla_abslistview.getContext()).getScaledFadingEdgeLength();
    }

    void a()
    {
        a.removeCallbacks(this);
    }

    void a(int i)
    {
        a();
        int j = a.getChildCount();
        if (j == 0)
        {
            return;
        }
        int k = a.E;
        int l = (j + k) - 1;
        j = Math.max(0, Math.min(a.getCount() - 1, i));
        if (j < k)
        {
            i = (k - j) + 1;
            b = 2;
        } else
        if (j > l)
        {
            i = (j - l) + 1;
            b = 1;
        } else
        {
            b(j, -1, 400);
            return;
        }
        if (i > 0)
        {
            f = 400 / i;
        } else
        {
            f = 400;
        }
        c = j;
        d = -1;
        e = -1;
        a.postOnAnimation(this);
    }

    void a(int i, int j)
    {
        a(i, j, 400);
    }

    void a(int i, int j, int k)
    {
        a();
        int l = a.getChildCount();
        if (l == 0)
        {
            return;
        }
        j = a.getPaddingTop() + j;
        c = Math.max(0, Math.min(a.getCount() - 1, i));
        h = j;
        d = -1;
        e = -1;
        b = 5;
        i = a.E;
        int i1 = (i + l) - 1;
        float f1;
        if (c < i)
        {
            i -= c;
        } else
        if (c > i1)
        {
            i = c - i1;
        } else
        {
            i = a.getChildAt(c - i).getTop();
            a.c(i - j, k);
            return;
        }
        f1 = (float)i / (float)l;
        if (f1 >= 1.0F)
        {
            k = (int)((float)k / f1);
        }
        f = k;
        e = -1;
        a.postOnAnimation(this);
    }

    void b(int i, int j, int k)
    {
        int l;
        int i1;
        int j1;
        int k1;
label0:
        {
            k1 = a.E;
            int l1 = (a.getChildCount() + k1) - 1;
            i1 = a.n.top;
            j1 = a.getHeight() - a.n.bottom;
            if (i >= k1)
            {
                if (i <= l1);
            }
            if (j >= k1)
            {
                l = j;
                if (j <= l1)
                {
                    break label0;
                }
            }
            l = -1;
        }
        View view = a.getChildAt(i - k1);
        j = view.getTop();
        i = view.getBottom();
        if (i > j1)
        {
            i -= j1;
        } else
        {
            i = 0;
        }
        if (j < i1)
        {
            i = j - i1;
        }
        if (i == 0)
        {
            return;
        }
        j = i;
        if (l < 0) goto _L2; else goto _L1
_L1:
        view = a.getChildAt(l - k1);
        l = view.getTop();
        j = view.getBottom();
        k1 = Math.abs(i);
        if (i >= 0 || j + k1 <= j1) goto _L4; else goto _L3
_L3:
        j = Math.max(0, j - j1);
_L2:
        a.c(j, k);
        return;
_L4:
        j = i;
        if (i > 0)
        {
            j = i;
            if (l - k1 < i1)
            {
                j = Math.min(0, l - i1);
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void run()
    {
        int i;
        int l;
        int i1;
        i = 0;
        i1 = a.getHeight();
        l = a.E;
        b;
        JVM INSTR tableswitch 1 5: default 60
    //                   1 61
    //                   2 378
    //                   3 211
    //                   4 491
    //                   5 649;
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
                a.postOnAnimation(this);
                return;
            }
            View view = a.getChildAt(i);
            int j1 = view.getHeight();
            int j2 = view.getTop();
            if (l < a.V - 1)
            {
                i = Math.max(a.n.bottom, g);
            } else
            {
                i = a.n.bottom;
            }
            a.c(i + (j1 - (i1 - j2)), f);
            e = l;
            if (l < c)
            {
                a.postOnAnimation(this);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        i = a.getChildCount();
        if (l != d && i > 1 && i + l < a.V)
        {
            i = l + 1;
            if (i == e)
            {
                a.postOnAnimation(this);
                return;
            }
            View view1 = a.getChildAt(1);
            l = view1.getHeight();
            i1 = view1.getTop();
            int k1 = Math.max(a.n.bottom, g);
            if (i < d)
            {
                a.c(Math.max(0, (i1 + l) - k1), f);
                e = i;
                a.postOnAnimation(this);
                return;
            }
            if (i1 > k1)
            {
                a.c(i1 - k1, f);
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (l == e)
        {
            a.postOnAnimation(this);
            return;
        }
        View view2 = a.getChildAt(0);
        if (view2 != null)
        {
            i1 = view2.getTop();
            if (l > 0)
            {
                i = Math.max(g, a.n.top);
            } else
            {
                i = a.n.top;
            }
            a.c(i1 - i, f);
            e = l;
            if (l > c)
            {
                a.postOnAnimation(this);
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
                a.postOnAnimation(this);
                return;
            }
            View view3 = a.getChildAt(l1);
            l = view3.getHeight();
            l1 = view3.getTop();
            int k2 = Math.max(a.n.top, g);
            e = i;
            if (i > d)
            {
                a.c(-(i1 - l1 - k2), f);
                a.postOnAnimation(this);
                return;
            }
            i = i1 - k2;
            l = l1 + l;
            if (i > l)
            {
                a.c(-(i - l), f);
                return;
            }
        }
        if (true) goto _L1; else goto _L6
_L6:
        int i2;
        int l2;
        if (e == l)
        {
            a.postOnAnimation(this);
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
            a.c(i, l);
            a.postOnAnimation(this);
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
            a.c(j, l);
            a.postOnAnimation(this);
            return;
        } else
        {
            int k = a.getChildAt(i2 - l).getTop() - h;
            l = (int)((float)f * ((float)Math.abs(k) / (float)a.getHeight()));
            a.c(k, l);
            return;
        }
    }
}
