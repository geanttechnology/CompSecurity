// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public static abstract class g
{
    public static final class a
    {

        int a;
        private int b;
        private int c;
        private int d;
        private Interpolator e;
        private boolean f;
        private int g;

        static void a(a a1, RecyclerView recyclerview)
        {
            if (a1.a >= 0)
            {
                int i1 = a1.a;
                a1.a = -1;
                RecyclerView.c(recyclerview, i1);
                a1.f = false;
                return;
            }
            if (a1.f)
            {
                if (a1.e != null && a1.d <= 0)
                {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (a1.d <= 0)
                {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
                if (a1.e == null)
                {
                    if (a1.d == 0x80000000)
                    {
                        RecyclerView.w(recyclerview).a(a1.b, a1.c);
                    } else
                    {
                        RecyclerView.w(recyclerview).a(a1.b, a1.c, a1.d);
                    }
                } else
                {
                    RecyclerView.w(recyclerview).a(a1.b, a1.c, a1.d, a1.e);
                }
                a1.g = a1.g + 1;
                if (a1.g > 10)
                {
                    Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                }
                a1.f = false;
                return;
            } else
            {
                a1.g = 0;
                return;
            }
        }

        public final void a(int i1, int j1, int k1, Interpolator interpolator)
        {
            b = i1;
            c = j1;
            d = k1;
            e = interpolator;
            f = true;
        }

        public a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
            a = -1;
            f = false;
            g = 0;
            b = 0;
            c = 0;
            d = 0x80000000;
            e = null;
        }
    }


    private final a a = new a();
    int g;
    RecyclerView h;
    a i;
    boolean j;
    boolean k;
    View l;

    static void a(a.f f, int i1, int j1)
    {
label0:
        {
            boolean flag = false;
            RecyclerView recyclerview = f.h;
            if (!f.k || f.g == -1 || recyclerview == null)
            {
                f.b();
            }
            f.j = false;
            if (f.l != null)
            {
                if (RecyclerView.d(f.l) == f.g)
                {
                    View view = f.l;
                    a a2 = recyclerview.o;
                    f.a(view, f.a);
                    a.a(f.a, recyclerview);
                    f.b();
                } else
                {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    f.l = null;
                }
            }
            if (f.k)
            {
                a a1 = recyclerview.o;
                f.a(i1, j1, f.a);
                i1 = ((flag) ? 1 : 0);
                if (f.a.a >= 0)
                {
                    i1 = 1;
                }
                a.a(f.a, recyclerview);
                if (i1 != 0)
                {
                    if (!f.k)
                    {
                        break label0;
                    }
                    f.j = true;
                    RecyclerView.w(recyclerview).a();
                }
            }
            return;
        }
        f.b();
    }

    protected abstract void a();

    protected abstract void a(int i1, int j1, a a1);

    protected abstract void a(View view, a a1);

    protected final void b()
    {
        if (!k)
        {
            return;
        } else
        {
            a();
            h.o.a = -1;
            l = null;
            g = -1;
            j = false;
            k = false;
            a(i, this);
            i = null;
            h = null;
            return;
        }
    }

    public a.e()
    {
        g = -1;
    }
}
