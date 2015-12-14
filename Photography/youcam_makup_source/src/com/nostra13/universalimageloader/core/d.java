// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.e.a;

// Referenced classes of package com.nostra13.universalimageloader.core:
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
    private final ImageScaleType j;
    private final android.graphics.BitmapFactory.Options k;
    private final int l;
    private final boolean m;
    private final Object n;
    private final a o;
    private final a p;
    private final com.nostra13.universalimageloader.core.b.a q;
    private final Handler r;
    private final boolean s;

    private d(e e1)
    {
        a = a(e1);
        b = com.nostra13.universalimageloader.core.e.b(e1);
        c = com.nostra13.universalimageloader.core.e.c(e1);
        d = com.nostra13.universalimageloader.core.e.d(e1);
        e = com.nostra13.universalimageloader.core.e.e(e1);
        f = com.nostra13.universalimageloader.core.e.f(e1);
        g = com.nostra13.universalimageloader.core.e.g(e1);
        h = com.nostra13.universalimageloader.core.e.h(e1);
        i = com.nostra13.universalimageloader.core.e.i(e1);
        j = com.nostra13.universalimageloader.core.e.j(e1);
        k = com.nostra13.universalimageloader.core.e.k(e1);
        l = com.nostra13.universalimageloader.core.e.l(e1);
        m = com.nostra13.universalimageloader.core.e.m(e1);
        n = com.nostra13.universalimageloader.core.e.n(e1);
        o = com.nostra13.universalimageloader.core.e.o(e1);
        p = com.nostra13.universalimageloader.core.e.p(e1);
        q = com.nostra13.universalimageloader.core.e.q(e1);
        r = com.nostra13.universalimageloader.core.e.r(e1);
        s = com.nostra13.universalimageloader.core.e.s(e1);
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

    static ImageScaleType j(d d1)
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

    static com.nostra13.universalimageloader.core.b.a q(d d1)
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
        return (new e()).();
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

    public ImageScaleType j()
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

    public com.nostra13.universalimageloader.core.b.a q()
    {
        return q;
    }

    public Handler r()
    {
        return r;
    }

    boolean s()
    {
        return s;
    }
}
