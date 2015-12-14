// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewConfiguration;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview:
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

    h(AbsListView abslistview)
    {
        a = abslistview;
        super();
        g = ViewConfiguration.get(abslistview.getContext()).getScaledFadingEdgeLength();
    }

    void a()
    {
        a.removeCallbacks(this);
    }

    void a(int i)
    {
        a();
        if (a.ah)
        {
            a.M = new Runnable(i) {

                final int a;
                final h b;

                public void run()
                {
                    b.a(a);
                }

            
            {
                b = h.this;
                a = i;
                super();
            }
            };
        } else
        {
            int j = a.getChildCount();
            if (j != 0)
            {
                int k = a.T;
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
                    a(j, -1, 200);
                    return;
                }
                if (i > 0)
                {
                    f = 200 / i;
                } else
                {
                    f = 200;
                }
                c = j;
                d = -1;
                e = -1;
                a.post(this);
                return;
            }
        }
    }

    void a(int i, int j, int k)
    {
        int l;
        int i1;
        int j1;
        int k1;
label0:
        {
            k1 = a.T;
            int l1 = (a.getChildCount() + k1) - 1;
            i1 = a.s.left;
            j1 = a.getWidth() - a.s.right;
            if (i < k1 || i > l1)
            {
                m.d("AbsListView", (new StringBuilder()).append("scrollToVisible called with targetPos ").append(i).append(" not visible [").append(k1).append(", ").append(l1).append("]").toString());
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
        j = view.getLeft();
        i = view.getRight();
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
        l = view.getLeft();
        j = view.getRight();
        k1 = Math.abs(i);
        if (i >= 0 || j + k1 <= j1) goto _L4; else goto _L3
_L3:
        j = Math.max(0, j - j1);
_L2:
        a.b(j, k);
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
        i1 = a.getWidth();
        l = a.T;
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
            if (l < a.am - 1)
            {
                i = Math.max(a.s.right, g);
            } else
            {
                i = a.s.right;
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
        if (l != d && i > 1 && i + l < a.am)
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
            int k1 = Math.max(a.s.right, g);
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
                i = Math.max(g, a.s.left);
            } else
            {
                i = a.s.left;
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
            int k2 = Math.max(a.s.left, g);
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
