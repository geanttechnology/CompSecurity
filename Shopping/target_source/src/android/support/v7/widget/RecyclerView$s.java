// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.widget.p;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView, q

private class tContext
    implements Runnable
{

    final RecyclerView a;
    private int b;
    private int c;
    private p d;
    private Interpolator e;
    private boolean f;
    private boolean g;

    private float a(float f1)
    {
        return (float)Math.sin((float)((double)(f1 - 0.5F) * 0.4712389167638204D));
    }

    private int b(int i, int j, int k, int l)
    {
        int i1 = Math.abs(i);
        int j1 = Math.abs(j);
        float f1;
        float f2;
        float f3;
        boolean flag;
        if (i1 > j1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k = (int)Math.sqrt(k * k + l * l);
        j = (int)Math.sqrt(i * i + j * j);
        if (flag)
        {
            i = a.getWidth();
        } else
        {
            i = a.getHeight();
        }
        l = i / 2;
        f3 = Math.min(1.0F, ((float)j * 1.0F) / (float)i);
        f1 = l;
        f2 = l;
        f3 = a(f3);
        if (k > 0)
        {
            i = Math.round(1000F * Math.abs((f3 * f2 + f1) / (float)k)) * 4;
        } else
        {
            if (flag)
            {
                j = i1;
            } else
            {
                j = j1;
            }
            i = (int)(((float)j / (float)i + 1.0F) * 300F);
        }
        return Math.min(i, 2000);
    }

    private void c()
    {
        g = false;
        f = true;
    }

    private void d()
    {
        f = false;
        if (g)
        {
            a();
        }
    }

    void a()
    {
        if (f)
        {
            g = true;
            return;
        } else
        {
            a.removeCallbacks(this);
            ai.a(a, this);
            return;
        }
    }

    public void a(int i, int j)
    {
        RecyclerView.b(a, 2);
        c = 0;
        b = 0;
        d.a(0, 0, i, j, 0x80000000, 0x7fffffff, 0x80000000, 0x7fffffff);
        a();
    }

    public void a(int i, int j, int k)
    {
        a(i, j, k, android.support.v7.widget.RecyclerView.p());
    }

    public void a(int i, int j, int k, int l)
    {
        a(i, j, b(i, j, k, l));
    }

    public void a(int i, int j, int k, Interpolator interpolator)
    {
        if (e != interpolator)
        {
            e = interpolator;
            d = p.a(a.getContext(), interpolator);
        }
        RecyclerView.b(a, 2);
        c = 0;
        b = 0;
        d.a(0, 0, i, j, k);
        a();
    }

    public void b()
    {
        a.removeCallbacks(this);
        d.h();
    }

    public void b(int i, int j)
    {
        a(i, j, 0, 0);
    }

    public void run()
    {
        p p1;
        a a1;
        c();
        RecyclerView.e(a);
        p1 = d;
        a1 = RecyclerView.d(a).mSmoothScroller;
        if (!p1.g()) goto _L2; else goto _L1
_L1:
        int i;
        int k;
        int i1;
        int i3 = p1.b();
        int j3 = p1.c();
        int k2 = i3 - b;
        int l2 = j3 - c;
        int j = 0;
        boolean flag3 = false;
        int l = 0;
        boolean flag1 = false;
        b = i3;
        c = j3;
        i1 = 0;
        i = 0;
        k = 0;
        boolean flag2 = false;
        if (RecyclerView.f(a) != null)
        {
            a.b();
            RecyclerView.b(a, true);
            j = ((flag3) ? 1 : 0);
            if (k2 != 0)
            {
                j = RecyclerView.d(a).a(k2, a.mRecycler, a.mState);
                i = k2 - j;
            }
            k = ((flag2) ? 1 : 0);
            l = ((flag1) ? 1 : 0);
            if (l2 != 0)
            {
                l = RecyclerView.d(a).b(l2, a.mRecycler, a.mState);
                k = l2 - l;
            }
            if (RecyclerView.g(a))
            {
                int j1 = a.mChildHelper.b();
                for (i1 = 0; i1 < j1; i1++)
                {
                    View view = a.mChildHelper.b(i1);
                    Object obj = a.a(view);
                    if (obj == null || ((a) (obj)).mShadowingHolder == null)
                    {
                        continue;
                    }
                    obj = ((mShadowingHolder) (obj)).mShadowingHolder.itemView;
                    int l1 = view.getLeft();
                    int j2 = view.getTop();
                    if (l1 != ((View) (obj)).getLeft() || j2 != ((View) (obj)).getTop())
                    {
                        ((View) (obj)).layout(l1, j2, ((View) (obj)).getWidth() + l1, ((View) (obj)).getHeight() + j2);
                    }
                }

            }
            if (a1 != null && !a1.b() && a1.c())
            {
                i1 = a.mState.e();
                if (i1 == 0)
                {
                    a1.a();
                } else
                if (a1.d() >= i1)
                {
                    a1.a(i1 - 1);
                    a(a1, k2 - i, l2 - k);
                } else
                {
                    a(a1, k2 - i, l2 - k);
                }
            }
            RecyclerView.b(a, false);
            a.a(false);
            i1 = i;
        }
        if (!RecyclerView.h(a).isEmpty())
        {
            a.invalidate();
        }
        if (ai.a(a) != 2)
        {
            RecyclerView.a(a, k2, l2);
        }
        if (i1 == 0 && k == 0) goto _L4; else goto _L3
_L3:
        int k1 = (int)p1.f();
        boolean flag;
        int i2;
        if (i1 != i3)
        {
            if (i1 < 0)
            {
                i = -k1;
            } else
            if (i1 > 0)
            {
                i = k1;
            } else
            {
                i = 0;
            }
            i2 = i;
        } else
        {
            i2 = 0;
        }
        if (k == j3) goto _L6; else goto _L5
_L5:
        if (k >= 0) goto _L8; else goto _L7
_L7:
        i = -k1;
_L10:
        if (ai.a(a) != 2)
        {
            a.d(i2, i);
        }
        if ((i2 != 0 || i1 == i3 || p1.d() == 0) && (i != 0 || k == j3 || p1.e() == 0))
        {
            p1.h();
        }
_L4:
        if (j != 0 || l != 0)
        {
            RecyclerView.b(a, j, l);
        }
        if (!RecyclerView.i(a))
        {
            a.invalidate();
        }
        if (l2 != 0 && RecyclerView.d(a).e() && l == l2)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (k2 != 0 && RecyclerView.d(a).d() && j == k2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (k2 == 0 && l2 == 0 || flag || i != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (p1.a() || i == 0)
        {
            RecyclerView.b(a, 0);
        } else
        {
            a();
        }
_L2:
        if (a1 != null && a1.b())
        {
            a(a1, 0, 0);
        }
        d();
        return;
_L8:
        i = k1;
        if (k <= 0)
        {
            i = 0;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        i = 0;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public (RecyclerView recyclerview)
    {
        a = recyclerview;
        super();
        e = android.support.v7.widget.RecyclerView.p();
        f = false;
        g = false;
        d = p.a(recyclerview.getContext(), android.support.v7.widget.RecyclerView.p());
    }
}
