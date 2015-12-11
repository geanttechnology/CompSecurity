// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ap;
import android.support.v4.widget.n;
import android.support.v4.widget.s;
import android.support.v4.widget.t;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView, au, d, bi, 
//            bd, bf

final class bh
    implements Runnable
{

    int a;
    int b;
    s c;
    final RecyclerView d;
    private Interpolator e;
    private boolean f;
    private boolean g;

    public bh(RecyclerView recyclerview)
    {
        d = recyclerview;
        super();
        e = RecyclerView.h();
        f = false;
        g = false;
        c = s.a(recyclerview.getContext(), RecyclerView.h());
    }

    final void a()
    {
        if (f)
        {
            g = true;
            return;
        } else
        {
            ap.a(d, this);
            return;
        }
    }

    public final void a(int i, int j)
    {
        int i1 = Math.abs(i);
        int j1 = Math.abs(j);
        float f1;
        float f2;
        float f3;
        int k;
        boolean flag;
        int k1;
        int l1;
        int i2;
        if (i1 > j1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k1 = (int)Math.sqrt(0.0D);
        l1 = (int)Math.sqrt(i * i + j * j);
        if (flag)
        {
            k = d.getWidth();
        } else
        {
            k = d.getHeight();
        }
        i2 = k / 2;
        f3 = Math.min(1.0F, ((float)l1 * 1.0F) / (float)k);
        f1 = i2;
        f2 = i2;
        f3 = (float)Math.sin((float)((double)(f3 - 0.5F) * 0.4712389167638204D));
        if (k1 > 0)
        {
            k = Math.round(1000F * Math.abs((f3 * f2 + f1) / (float)k1)) * 4;
        } else
        {
            int l;
            if (flag)
            {
                l = i1;
            } else
            {
                l = j1;
            }
            k = (int)(((float)l / (float)k + 1.0F) * 300F);
        }
        a(i, j, Math.min(k, 2000));
    }

    public final void a(int i, int j, int k)
    {
        a(i, j, k, RecyclerView.h());
    }

    public final void a(int i, int j, int k, Interpolator interpolator)
    {
        if (e != interpolator)
        {
            e = interpolator;
            c = s.a(d.getContext(), interpolator);
        }
        RecyclerView.b(d, 2);
        b = 0;
        a = 0;
        c.a(0, 0, i, j, k);
        a();
    }

    public final void run()
    {
        s s1;
        bd bd1;
        g = false;
        f = true;
        RecyclerView.f(d);
        s1 = c;
        bd1 = RecyclerView.e(d).r;
        if (!s1.e()) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        int k;
        int k2 = s1.a();
        int l2 = s1.b();
        int i3 = k2 - a;
        int j3 = l2 - b;
        int i1 = 0;
        boolean flag1 = false;
        int l = 0;
        int j1 = 0;
        a = k2;
        b = l2;
        j = 0;
        i = 0;
        k = 0;
        boolean flag = false;
        if (RecyclerView.g(d) != null)
        {
            d.a();
            RecyclerView.a(d, true);
            j = ((flag1) ? 1 : 0);
            if (i3 != 0)
            {
                j = RecyclerView.e(d).a(i3, d.a, d.m);
                i = i3 - j;
            }
            k = ((flag) ? 1 : 0);
            l = j1;
            if (j3 != 0)
            {
                l = RecyclerView.e(d).b(j3, d.a, d.m);
                k = j3 - l;
            }
            if (RecyclerView.h(d))
            {
                j1 = d.c.a();
                i1 = 0;
                while (i1 < j1) 
                {
                    View view = d.c.b(i1);
                    Object obj = d.a(view);
                    if (obj == null || ((bi) (obj)).h == null)
                    {
                        continue;
                    }
                    int k1;
                    int i2;
                    if (((bi) (obj)).h != null)
                    {
                        obj = ((bi) (obj)).h.a;
                    } else
                    {
                        obj = null;
                    }
                    if (obj == null)
                    {
                        continue;
                    }
                    k1 = view.getLeft();
                    i2 = view.getTop();
                    if (k1 != ((View) (obj)).getLeft() || i2 != ((View) (obj)).getTop())
                    {
                        ((View) (obj)).layout(k1, i2, ((View) (obj)).getWidth() + k1, ((View) (obj)).getHeight() + i2);
                    }
                    i1++;
                }
            }
            if (bd1 != null && !bd1.j && bd1.k)
            {
                i1 = d.m.a();
                if (i1 == 0)
                {
                    bd1.b();
                } else
                {
                    if (bd1.g >= i1)
                    {
                        bd1.g = i1 - 1;
                    }
                    bd.a(bd1, i3 - i, j3 - k);
                }
            }
            RecyclerView.a(d, false);
            d.a(false);
            i1 = j;
            j = i;
        }
        if (i3 == i1 && j3 == l)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (!RecyclerView.i(d).isEmpty())
        {
            d.invalidate();
        }
        if (ap.a(d) != 2)
        {
            RecyclerView.a(d, i3, j3);
        }
        if (j == 0 && k == 0) goto _L4; else goto _L3
_L3:
        int l1 = (int)s1.b.d(s1.a);
        RecyclerView recyclerview;
        int j2;
        if (j != k2)
        {
            if (j < 0)
            {
                i = -l1;
            } else
            if (j > 0)
            {
                i = l1;
            } else
            {
                i = 0;
            }
            j2 = i;
        } else
        {
            j2 = 0;
        }
        if (k == l2) goto _L6; else goto _L5
_L5:
        if (k >= 0) goto _L8; else goto _L7
_L7:
        i = -l1;
_L10:
        if (ap.a(d) != 2)
        {
            recyclerview = d;
            if (j2 < 0)
            {
                recyclerview.b();
                recyclerview.g.a(-j2);
            } else
            if (j2 > 0)
            {
                recyclerview.c();
                recyclerview.i.a(j2);
            }
            if (i < 0)
            {
                recyclerview.d();
                recyclerview.h.a(-i);
            } else
            if (i > 0)
            {
                recyclerview.e();
                recyclerview.j.a(i);
            }
            if (j2 != 0 || i != 0)
            {
                ap.d(recyclerview);
            }
        }
        if ((j2 != 0 || j == k2 || s1.c() == 0) && (i != 0 || k == l2 || s1.d() == 0))
        {
            s1.f();
        }
_L4:
        if (i1 != 0 || l != 0)
        {
            RecyclerView.j(d);
            if (RecyclerView.k(d) != null)
            {
                RecyclerView.k(d);
            }
        }
        if (!RecyclerView.l(d))
        {
            d.invalidate();
        }
        if (s1.b.a(s1.a) || !j1)
        {
            RecyclerView.b(d, 0);
        } else
        {
            a();
        }
_L2:
        if (bd1 != null && bd1.j)
        {
            bd.a(bd1, 0, 0);
        }
        f = false;
        if (g)
        {
            a();
        }
        return;
_L8:
        i = l1;
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
}
