// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.d.e;
import android.support.v4.view.w;
import android.support.v4.widget.k;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView, m

private final class tContext
    implements Runnable
{

    int a;
    int b;
    k c;
    final RecyclerView d;
    private Interpolator e;
    private boolean f;
    private boolean g;

    final void a()
    {
        if (f)
        {
            g = true;
            return;
        } else
        {
            d.removeCallbacks(this);
            w.a(d, this);
            return;
        }
    }

    public final void a(int i, int j)
    {
        int j1 = Math.abs(i);
        int k1 = Math.abs(j);
        float f1;
        float f2;
        float f3;
        int l;
        boolean flag;
        int l1;
        int i2;
        int j2;
        if (j1 > k1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l1 = (int)Math.sqrt(0.0D);
        i2 = (int)Math.sqrt(i * i + j * j);
        if (flag)
        {
            l = d.getWidth();
        } else
        {
            l = d.getHeight();
        }
        j2 = l / 2;
        f3 = Math.min(1.0F, ((float)i2 * 1.0F) / (float)l);
        f1 = j2;
        f2 = j2;
        f3 = (float)Math.sin((float)((double)(f3 - 0.5F) * 0.4712389167638204D));
        if (l1 > 0)
        {
            l = Math.round(1000F * Math.abs((f3 * f2 + f1) / (float)l1)) * 4;
        } else
        {
            int i1;
            if (flag)
            {
                i1 = j1;
            } else
            {
                i1 = k1;
            }
            l = (int)(((float)i1 / (float)l + 1.0F) * 300F);
        }
        a(i, j, Math.min(l, 2000));
    }

    public final void a(int i, int j, int l)
    {
        a(i, j, l, RecyclerView.j());
    }

    public final void a(int i, int j, int l, Interpolator interpolator)
    {
        if (e != interpolator)
        {
            e = interpolator;
            c = k.a(d.getContext(), interpolator);
        }
        RecyclerView.b(d, 2);
        b = 0;
        a = 0;
        interpolator = c;
        ((k) (interpolator)).b.c(((k) (interpolator)).a, i, j, l);
        a();
    }

    public final void run()
    {
        k k1;
        a a1;
        g = false;
        f = true;
        RecyclerView.f(d);
        k1 = c;
        a1 = android.support.v7.widget.RecyclerView.e(d).j;
        if (!k1.b.j(k1.a)) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        int l;
        int i1;
        int j1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        i3 = k1.b.j(k1.a);
        j3 = k1.b.j(k1.a);
        k2 = i3 - a;
        l2 = j3 - b;
        l1 = 0;
        i = 0;
        i2 = 0;
        i1 = 0;
        a = i3;
        b = j3;
        j2 = 0;
        j = 0;
        j1 = 0;
        l = 0;
        if (RecyclerView.g(d) == null)
        {
            break MISSING_BLOCK_LABEL_960;
        }
        d.a();
        RecyclerView.h(d);
        android.support.v4.d.e.a("RV Scroll");
        if (k2 != 0)
        {
            i = android.support.v7.widget.RecyclerView.e(d).a(k2, d.a, d.o);
            j = k2 - i;
        }
        if (l2 != 0)
        {
            i1 = android.support.v7.widget.RecyclerView.e(d).b(l2, d.a, d.o);
            l = l2 - i1;
        }
        android.support.v4.d.e.a();
        if (RecyclerView.i(d))
        {
            l1 = d.c.a();
            for (j1 = 0; j1 < l1; j1++)
            {
                View view = d.c.b(j1);
                Object obj = d.a(view);
                if (obj == null || ((d) (obj)).h == null)
                {
                    continue;
                }
                obj = ((h) (obj)).h.a;
                i2 = view.getLeft();
                j2 = view.getTop();
                if (i2 != ((View) (obj)).getLeft() || j2 != ((View) (obj)).getTop())
                {
                    ((View) (obj)).layout(i2, j2, ((View) (obj)).getWidth() + i2, ((View) (obj)).getHeight() + j2);
                }
            }

        }
        RecyclerView.j(d);
        d.a(false);
        j1 = l;
        i2 = i1;
        j2 = j;
        l1 = i;
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_960;
        }
        j1 = l;
        i2 = i1;
        j2 = j;
        l1 = i;
        if (a1.j)
        {
            break MISSING_BLOCK_LABEL_960;
        }
        j1 = l;
        i2 = i1;
        j2 = j;
        l1 = i;
        if (!a1.k)
        {
            break MISSING_BLOCK_LABEL_960;
        }
        j1 = d.o.a();
        if (j1 != 0) goto _L4; else goto _L3
_L3:
        a1.b();
        l1 = i;
_L5:
        if (!android.support.v7.widget.RecyclerView.k(d).isEmpty())
        {
            d.invalidate();
        }
        if (w.a(d) != 2)
        {
            RecyclerView.a(d, k2, l2);
        }
        if (j != 0 || l != 0)
        {
            j1 = (int)k1.b.d(k1.a);
            if (j != i3)
            {
                if (j < 0)
                {
                    i = -j1;
                } else
                if (j > 0)
                {
                    i = j1;
                } else
                {
                    i = 0;
                }
                i2 = i;
            } else
            {
                i2 = 0;
            }
            if (l != j3)
            {
                if (l < 0)
                {
                    i = -j1;
                } else
                {
                    i = j1;
                    if (l <= 0)
                    {
                        i = 0;
                    }
                }
            } else
            {
                i = 0;
            }
            if (w.a(d) != 2)
            {
                RecyclerView recyclerview = d;
                if (i2 < 0)
                {
                    recyclerview.c();
                    recyclerview.i.a(-i2);
                } else
                if (i2 > 0)
                {
                    recyclerview.d();
                    recyclerview.k.a(i2);
                }
                if (i < 0)
                {
                    recyclerview.e();
                    recyclerview.j.a(-i);
                } else
                if (i > 0)
                {
                    recyclerview.f();
                    recyclerview.l.a(i);
                }
                if (i2 != 0 || i != 0)
                {
                    w.d(recyclerview);
                }
            }
            if ((i2 != 0 || j == i3 || k1.b.d(k1.a) == 0) && (i != 0 || l == j3 || k1.a() == 0))
            {
                k1.b();
            }
        }
        if (l1 != 0 || i1 != 0)
        {
            d.a(l1, i1);
        }
        if (!RecyclerView.l(d))
        {
            d.invalidate();
        }
        if (l2 != 0 && android.support.v7.widget.RecyclerView.e(d).d() && i1 == l2)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (k2 != 0 && android.support.v7.widget.RecyclerView.e(d).c() && l1 == k2)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (k2 == 0 && l2 == 0 || j != 0 || i != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (k1.b.c(k1.a) || i == 0)
        {
            RecyclerView.b(d, 0);
        } else
        {
            a();
        }
_L2:
        if (a1 != null)
        {
            if (a1.j)
            {
                a(a1, 0, 0);
            }
            if (!g)
            {
                a1.b();
            }
        }
        f = false;
        if (g)
        {
            a();
        }
        return;
_L4:
        if (a1.g >= j1)
        {
            a1.g = j1 - 1;
        }
        a(a1, k2 - j, l2 - l);
        l1 = i;
        j2 = j;
        i2 = i1;
        j1 = l;
        i1 = i2;
        j = j2;
        l = j1;
          goto _L5
    }

    public (RecyclerView recyclerview)
    {
        d = recyclerview;
        super();
        e = RecyclerView.j();
        f = false;
        g = false;
        c = k.a(recyclerview.getContext(), RecyclerView.j());
    }
}
