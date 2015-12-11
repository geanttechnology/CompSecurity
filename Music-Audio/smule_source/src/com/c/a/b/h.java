// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b;

import android.content.Context;
import com.c.a.a.a.b;
import com.c.a.a.b.a.a;
import com.c.a.b.a.i;
import com.c.a.b.b.d;
import com.c.a.c.c;
import java.util.concurrent.Executor;

// Referenced classes of package com.c.a.b:
//            a, d, g

public class h
{

    public static final i a;
    private boolean A;
    private Context b;
    private int c;
    private int d;
    private int e;
    private int f;
    private android.graphics.Bitmap.CompressFormat g;
    private int h;
    private com.c.a.b.f.a i;
    private Executor j;
    private Executor k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private boolean p;
    private i q;
    private int r;
    private int s;
    private int t;
    private com.c.a.a.b.c u;
    private b v;
    private com.c.a.a.a.b.a w;
    private com.c.a.b.d.b x;
    private d y;
    private com.c.a.b.d z;

    public h(Context context)
    {
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = null;
        h = 0;
        i = null;
        j = null;
        k = null;
        l = false;
        m = false;
        n = 3;
        o = 4;
        p = false;
        q = a;
        r = 0;
        s = 0;
        t = 0;
        u = null;
        v = null;
        w = null;
        x = null;
        z = null;
        A = false;
        b = context.getApplicationContext();
    }

    static Context a(h h1)
    {
        return h1.b;
    }

    static int b(h h1)
    {
        return h1.c;
    }

    private void b()
    {
        if (j == null)
        {
            j = com.c.a.b.a.a(n, o, q);
        } else
        {
            l = true;
        }
        if (k == null)
        {
            k = com.c.a.b.a.a(n, o, q);
        } else
        {
            m = true;
        }
        if (v == null)
        {
            if (w == null)
            {
                w = com.c.a.b.a.a();
            }
            v = com.c.a.b.a.a(b, w, s, t);
        }
        if (u == null)
        {
            u = com.c.a.b.a.a(r);
        }
        if (p)
        {
            u = new a(u, com.c.a.b.a.h.a());
        }
        if (x == null)
        {
            x = com.c.a.b.a.a(b);
        }
        if (y == null)
        {
            y = com.c.a.b.a.a(A);
        }
        if (z == null)
        {
            z = com.c.a.b.d.t();
        }
    }

    static int c(h h1)
    {
        return h1.d;
    }

    static int d(h h1)
    {
        return h1.e;
    }

    static int e(h h1)
    {
        return h1.f;
    }

    static android.graphics.Bitmap.CompressFormat f(h h1)
    {
        return h1.g;
    }

    static int g(h h1)
    {
        return h1.h;
    }

    static com.c.a.b.f.a h(h h1)
    {
        return h1.i;
    }

    static Executor i(h h1)
    {
        return h1.j;
    }

    static Executor j(h h1)
    {
        return h1.k;
    }

    static int k(h h1)
    {
        return h1.n;
    }

    static int l(h h1)
    {
        return h1.o;
    }

    static i m(h h1)
    {
        return h1.q;
    }

    static b n(h h1)
    {
        return h1.v;
    }

    static com.c.a.a.b.c o(h h1)
    {
        return h1.u;
    }

    static com.c.a.b.d p(h h1)
    {
        return h1.z;
    }

    static boolean q(h h1)
    {
        return h1.A;
    }

    static com.c.a.b.d.b r(h h1)
    {
        return h1.x;
    }

    static d s(h h1)
    {
        return h1.y;
    }

    static boolean t(h h1)
    {
        return h1.l;
    }

    static boolean u(h h1)
    {
        return h1.m;
    }

    public g a()
    {
        b();
        return new g(this, null);
    }

    public h a(int i1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("memoryCacheSize must be a positive number");
        }
        if (u != null)
        {
            com.c.a.c.c.c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
        }
        r = i1;
        return this;
    }

    public h a(com.c.a.a.b.c c1)
    {
        if (r != 0)
        {
            com.c.a.c.c.c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
        }
        u = c1;
        return this;
    }

    public h b(int i1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("maxCacheSize must be a positive number");
        }
        if (v != null || t > 0)
        {
            com.c.a.c.c.c("discCache(), discCacheSize() and discCacheFileCount calls overlap each other", new Object[0]);
        }
        s = i1;
        return this;
    }

    public h c(int i1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("maxFileCount must be a positive number");
        }
        if (v != null || s > 0)
        {
            com.c.a.c.c.c("discCache(), discCacheSize() and discCacheFileCount calls overlap each other", new Object[0]);
        }
        s = 0;
        t = i1;
        return this;
    }

    static 
    {
        a = i.a;
    }
}
