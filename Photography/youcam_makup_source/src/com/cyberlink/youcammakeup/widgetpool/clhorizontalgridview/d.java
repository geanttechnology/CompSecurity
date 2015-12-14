// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview;

import android.view.VelocityTracker;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview:
//            u, AbsListView, t, h

class d
    implements Runnable
{

    final AbsListView a;
    private final u b;
    private int c;
    private final Runnable d = new Runnable() {

        final d a;

        public void run()
        {
            int i = AbsListView.d(a.a);
            VelocityTracker velocitytracker = AbsListView.e(a.a);
            u u1 = d.a(a);
            if (velocitytracker == null || i == -1)
            {
                return;
            }
            velocitytracker.computeCurrentVelocity(1000, AbsListView.f(a.a));
            float f = -velocitytracker.getXVelocity(i);
            if (Math.abs(f) >= (float)AbsListView.g(a.a) && u1.a(f, 0.0F))
            {
                a.a.postDelayed(this, 40L);
                return;
            } else
            {
                a.b();
                a.a.D = 3;
                a.a.b(1);
                return;
            }
        }

            
            {
                a = d.this;
                super();
            }
    };

    d(AbsListView abslistview)
    {
        a = abslistview;
        super();
        b = new u(abslistview.getContext());
    }

    static u a(d d1)
    {
        return d1.b;
    }

    void a()
    {
        if (b.a(a.getScrollX(), 0, 0, 0, 0, 0))
        {
            a.D = 6;
            a.invalidate();
            a.post(this);
            return;
        } else
        {
            a.D = -1;
            a.b(0);
            return;
        }
    }

    void a(int i)
    {
        int j;
        if (i < 0)
        {
            j = 0x7fffffff;
        } else
        {
            j = 0;
        }
        c = j;
        b.a(null);
        b.a(j, 0, i, 0, 0, 0x7fffffff, 0, 0x7fffffff);
        a.D = 4;
        a.post(this);
    }

    void a(int i, int j, boolean flag)
    {
        android.view.animation.Interpolator interpolator;
        u u1;
        int k;
        if (i < 0)
        {
            k = 0x7fffffff;
        } else
        {
            k = 0;
        }
        c = k;
        u1 = b;
        if (flag)
        {
            interpolator = AbsListView.R;
        } else
        {
            interpolator = null;
        }
        u1.a(interpolator);
        b.a(k, 0, i, 0, j);
        a.D = 4;
        a.post(this);
    }

    void b()
    {
        a.D = -1;
        a.removeCallbacks(this);
        a.removeCallbacks(d);
        a.b(0);
        AbsListView.k(a);
        b.e();
    }

    void b(int i)
    {
        b.a(null);
        b.a(a.getScrollX(), 0, i, 0, 0, 0, 0, a.getWidth(), 0x80000000, 0x7fffffff);
        a.D = 6;
        a.invalidate();
        a.post(this);
    }

    void c()
    {
        a.postDelayed(d, 40L);
    }

    void c(int i)
    {
        int j;
        b.a(a.getScrollX(), 0, a.P);
        j = a.getOverScrollMode();
        if (j != 0 && (j != 1 || AbsListView.h(a))) goto _L2; else goto _L1
_L1:
        a.D = 6;
        int k = (int)b.c();
        if (i > 0)
        {
            AbsListView.i(a).a(k);
        } else
        {
            AbsListView.j(a).a(k);
        }
_L4:
        a.invalidate();
        a.post(this);
        return;
_L2:
        a.D = -1;
        if (a.G != null)
        {
            a.G.a();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void run()
    {
        boolean flag;
        int l;
        flag = true;
        l = 0;
        a.D;
        JVM INSTR tableswitch 3 6: default 44
    //                   3 49
    //                   4 59
    //                   5 44
    //                   6 434;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        b();
_L6:
        return;
_L2:
        if (b.a()) goto _L5; else goto _L3
_L3:
        if (a.ah)
        {
            a.g();
        }
        if (a.am == 0 || a.getChildCount() == 0)
        {
            b();
            return;
        }
        Object obj = b;
        boolean flag1 = ((u) (obj)).d();
        l = ((u) (obj)).b();
        int i = c - l;
        int j;
        boolean flag2;
        if (i > 0)
        {
            a.y = a.T;
            obj = a.getChildAt(0);
            a.z = ((View) (obj)).getLeft();
            i = Math.min(a.getWidth() - a.getPaddingRight() - a.getPaddingLeft() - 1, i);
        } else
        {
            j = a.getChildCount() - 1;
            a.y = a.T + j;
            obj = a.getChildAt(j);
            a.z = ((View) (obj)).getLeft();
            i = Math.max(-(a.getWidth() - a.getPaddingRight() - a.getPaddingLeft() - 1), i);
        }
        obj = a.getChildAt(a.y - a.T);
        int k;
        int i1;
        if (obj != null)
        {
            j = ((View) (obj)).getLeft();
        } else
        {
            j = 0;
        }
        flag2 = a.c(i, i);
        if (!flag2 || i == 0)
        {
            flag = false;
        }
        if (flag)
        {
            if (obj != null)
            {
                j = -(i - (((View) (obj)).getLeft() - j));
                AbsListView.a(a, j, 0, a.getScrollX(), 0, 0, 0, a.P, 0, false);
            }
            if (flag1)
            {
                c(i);
                return;
            }
        } else
        if (flag1 && !flag)
        {
            if (flag2)
            {
                a.invalidate();
            }
            c = l;
            a.post(this);
            return;
        } else
        {
            b();
            return;
        }
_L5:
        if (true) goto _L6; else goto _L4
_L4:
        obj = b;
        if (((u) (obj)).d())
        {
            k = a.getScrollX();
            i1 = ((u) (obj)).b();
            if (AbsListView.b(a, i1 - k, 0, k, 0, 0, 0, a.P, 0, false))
            {
                if (k <= 0 && i1 > 0)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                i = l;
                if (k >= 0)
                {
                    i = l;
                    if (i1 < 0)
                    {
                        i = 1;
                    }
                }
                if (j != 0 || i != 0)
                {
                    k = (int)((u) (obj)).c();
                    j = k;
                    if (i != 0)
                    {
                        j = -k;
                    }
                    ((u) (obj)).e();
                    a(j);
                    return;
                } else
                {
                    a();
                    return;
                }
            } else
            {
                a.invalidate();
                a.post(this);
                return;
            }
        } else
        {
            b();
            return;
        }
    }
}
