// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.e.a;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            a, d

public class e
{

    private int a;
    private int b;
    private int c;
    private Drawable d;
    private Drawable e;
    private Drawable f;
    private boolean g;
    private boolean h;
    private boolean i;
    private ImageScaleType j;
    private android.graphics.BitmapFactory.Options k;
    private int l;
    private boolean m;
    private Object n;
    private a o;
    private a p;
    private com.nostra13.universalimageloader.core.b.a q;
    private Handler r;
    private boolean s;

    public e()
    {
        a = 0;
        b = 0;
        c = 0;
        d = null;
        e = null;
        f = null;
        g = false;
        h = false;
        i = false;
        j = ImageScaleType.c;
        k = new android.graphics.BitmapFactory.Options();
        l = 0;
        m = false;
        n = null;
        o = null;
        p = null;
        q = com.nostra13.universalimageloader.core.a.c();
        r = null;
        s = false;
        k.inPurgeable = true;
        k.inInputShareable = true;
    }

    static int a(e e1)
    {
        return e1.a;
    }

    static int b(e e1)
    {
        return e1.b;
    }

    static int c(e e1)
    {
        return e1.c;
    }

    static Drawable d(e e1)
    {
        return e1.d;
    }

    static Drawable e(e e1)
    {
        return e1.e;
    }

    static Drawable f(e e1)
    {
        return e1.f;
    }

    static boolean g(e e1)
    {
        return e1.g;
    }

    static boolean h(e e1)
    {
        return e1.h;
    }

    static boolean i(e e1)
    {
        return e1.i;
    }

    static ImageScaleType j(e e1)
    {
        return e1.j;
    }

    static android.graphics.BitmapFactory.Options k(e e1)
    {
        return e1.k;
    }

    static int l(e e1)
    {
        return e1.l;
    }

    static boolean m(e e1)
    {
        return e1.m;
    }

    static Object n(e e1)
    {
        return e1.n;
    }

    static a o(e e1)
    {
        return e1.o;
    }

    static a p(e e1)
    {
        return e1.p;
    }

    static com.nostra13.universalimageloader.core.b.a q(e e1)
    {
        return e1.q;
    }

    static Handler r(e e1)
    {
        return e1.r;
    }

    static boolean s(e e1)
    {
        return e1.s;
    }

    public d a()
    {
        return new d(this, null);
    }

    public e a(int i1)
    {
        a = i1;
        return this;
    }

    public e a(android.graphics.Bitmap.Config config)
    {
        if (config == null)
        {
            throw new IllegalArgumentException("bitmapConfig can't be null");
        } else
        {
            k.inPreferredConfig = config;
            return this;
        }
    }

    public e a(Handler handler)
    {
        r = handler;
        return this;
    }

    public e a(ImageScaleType imagescaletype)
    {
        j = imagescaletype;
        return this;
    }

    public e a(com.nostra13.universalimageloader.core.b.a a1)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("displayer can't be null");
        } else
        {
            q = a1;
            return this;
        }
    }

    public e a(d d1)
    {
        a = com.nostra13.universalimageloader.core.d.a(d1);
        b = com.nostra13.universalimageloader.core.d.b(d1);
        c = com.nostra13.universalimageloader.core.d.c(d1);
        d = com.nostra13.universalimageloader.core.d.d(d1);
        e = com.nostra13.universalimageloader.core.d.e(d1);
        f = com.nostra13.universalimageloader.core.d.f(d1);
        g = com.nostra13.universalimageloader.core.d.g(d1);
        h = com.nostra13.universalimageloader.core.d.h(d1);
        i = com.nostra13.universalimageloader.core.d.i(d1);
        j = com.nostra13.universalimageloader.core.d.j(d1);
        k = com.nostra13.universalimageloader.core.d.k(d1);
        l = com.nostra13.universalimageloader.core.d.l(d1);
        m = com.nostra13.universalimageloader.core.d.m(d1);
        n = com.nostra13.universalimageloader.core.d.n(d1);
        o = com.nostra13.universalimageloader.core.d.o(d1);
        p = com.nostra13.universalimageloader.core.d.p(d1);
        q = com.nostra13.universalimageloader.core.d.q(d1);
        r = com.nostra13.universalimageloader.core.d.r(d1);
        s = com.nostra13.universalimageloader.core.d.s(d1);
        return this;
    }

    public e a(a a1)
    {
        o = a1;
        return this;
    }

    public e a(boolean flag)
    {
        g = flag;
        return this;
    }

    public e b(int i1)
    {
        b = i1;
        return this;
    }

    public e b(boolean flag)
    {
        h = flag;
        return this;
    }

    public e c(int i1)
    {
        c = i1;
        return this;
    }

    public e c(boolean flag)
    {
        i = flag;
        return this;
    }

    public e d(boolean flag)
    {
        m = flag;
        return this;
    }

    e e(boolean flag)
    {
        s = flag;
        return this;
    }
}
