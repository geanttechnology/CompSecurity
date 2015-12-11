// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.c.a.b.a.e;
import com.c.a.b.f.a;

// Referenced classes of package com.c.a.b:
//            e

public final class d
{

    private final int a;
    private final int b;
    private final int c;
    private final Drawable d;
    private final Drawable e;
    private final Drawable f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final e j;
    private final android.graphics.BitmapFactory.Options k;
    private final int l;
    private final boolean m;
    private final Object n;
    private final a o;
    private final a p;
    private final com.c.a.b.c.a q;
    private final Handler r;
    private final boolean s;

    private d(com.c.a.b.e e1)
    {
        a = com.c.a.b.e.a(e1);
        b = com.c.a.b.e.b(e1);
        c = com.c.a.b.e.c(e1);
        d = com.c.a.b.e.d(e1);
        e = com.c.a.b.e.e(e1);
        f = com.c.a.b.e.f(e1);
        g = com.c.a.b.e.g(e1);
        h = com.c.a.b.e.h(e1);
        i = com.c.a.b.e.i(e1);
        j = com.c.a.b.e.j(e1);
        k = com.c.a.b.e.k(e1);
        l = com.c.a.b.e.l(e1);
        m = com.c.a.b.e.m(e1);
        n = com.c.a.b.e.n(e1);
        o = com.c.a.b.e.o(e1);
        p = com.c.a.b.e.p(e1);
        q = com.c.a.b.e.q(e1);
        r = com.c.a.b.e.r(e1);
        s = com.c.a.b.e.s(e1);
    }


    static int a(d d1)
    {
        return d1.a;
    }

    static int b(d d1)
    {
        return d1.b;
    }

    static int c(d d1)
    {
        return d1.c;
    }

    static Drawable d(d d1)
    {
        return d1.d;
    }

    static Drawable e(d d1)
    {
        return d1.e;
    }

    static Drawable f(d d1)
    {
        return d1.f;
    }

    static boolean g(d d1)
    {
        return d1.g;
    }

    static boolean h(d d1)
    {
        return d1.h;
    }

    static boolean i(d d1)
    {
        return d1.i;
    }

    static e j(d d1)
    {
        return d1.j;
    }

    static android.graphics.BitmapFactory.Options k(d d1)
    {
        return d1.k;
    }

    static int l(d d1)
    {
        return d1.l;
    }

    static boolean m(d d1)
    {
        return d1.m;
    }

    static Object n(d d1)
    {
        return d1.n;
    }

    static a o(d d1)
    {
        return d1.o;
    }

    static a p(d d1)
    {
        return d1.p;
    }

    static com.c.a.b.c.a q(d d1)
    {
        return d1.q;
    }

    static Handler r(d d1)
    {
        return d1.r;
    }

    static boolean s(d d1)
    {
        return d1.s;
    }

    public static d t()
    {
        return (new com.c.a.b.e()).c();
    }

    public Drawable a(Resources resources)
    {
        if (a != 0)
        {
            return resources.getDrawable(a);
        } else
        {
            return d;
        }
    }

    public boolean a()
    {
        return d != null || a != 0;
    }

    public Drawable b(Resources resources)
    {
        if (b != 0)
        {
            return resources.getDrawable(b);
        } else
        {
            return e;
        }
    }

    public boolean b()
    {
        return e != null || b != 0;
    }

    public Drawable c(Resources resources)
    {
        if (c != 0)
        {
            return resources.getDrawable(c);
        } else
        {
            return f;
        }
    }

    public boolean c()
    {
        return f != null || c != 0;
    }

    public boolean d()
    {
        return o != null;
    }

    public boolean e()
    {
        return p != null;
    }

    public boolean f()
    {
        return l > 0;
    }

    public boolean g()
    {
        return g;
    }

    public boolean h()
    {
        return h;
    }

    public boolean i()
    {
        return i;
    }

    public e j()
    {
        return j;
    }

    public android.graphics.BitmapFactory.Options k()
    {
        return k;
    }

    public int l()
    {
        return l;
    }

    public boolean m()
    {
        return m;
    }

    public Object n()
    {
        return n;
    }

    public a o()
    {
        return o;
    }

    public a p()
    {
        return p;
    }

    public com.c.a.b.c.a q()
    {
        return q;
    }

    public Handler r()
    {
        if (s)
        {
            return null;
        }
        if (r == null)
        {
            if (Looper.myLooper() != Looper.getMainLooper())
            {
                throw new IllegalStateException("ImageLoader.displayImage(...) must be invoked from the main thread or from Looper thread");
            } else
            {
                return new Handler();
            }
        } else
        {
            return r;
        }
    }

    boolean s()
    {
        return s;
    }
}
