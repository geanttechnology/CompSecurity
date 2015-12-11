// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

// Referenced classes of package android.support.v7:
//            ajt, aiu, ajq, aiw, 
//            aid, aht, ajj, ajd, 
//            aij, aih, aif, aju, 
//            aia, ais

public final class ail
{
    public static class a
    {

        public static final aiw a;
        private Context b;
        private int c;
        private int d;
        private int e;
        private int f;
        private ajq g;
        private Executor h;
        private Executor i;
        private boolean j;
        private boolean k;
        private int l;
        private int m;
        private boolean n;
        private aiw o;
        private int p;
        private long q;
        private int r;
        private aid s;
        private aht t;
        private aia u;
        private ajj v;
        private ajd w;
        private aij x;
        private boolean y;

        static Context a(a a1)
        {
            return a1.b;
        }

        static int b(a a1)
        {
            return a1.c;
        }

        static int c(a a1)
        {
            return a1.d;
        }

        private void c()
        {
            if (h == null)
            {
                h = aih.a(l, m, o);
            } else
            {
                j = true;
            }
            if (i == null)
            {
                i = aih.a(l, m, o);
            } else
            {
                k = true;
            }
            if (t == null)
            {
                if (u == null)
                {
                    u = aih.b();
                }
                t = aih.a(b, u, q, r);
            }
            if (s == null)
            {
                s = aih.a(p);
            }
            if (n)
            {
                s = new aif(s, aju.a());
            }
            if (v == null)
            {
                v = aih.a(b);
            }
            if (w == null)
            {
                w = aih.a(y);
            }
            if (x == null)
            {
                x = aij.t();
            }
        }

        static int d(a a1)
        {
            return a1.e;
        }

        static int e(a a1)
        {
            return a1.f;
        }

        static ajq f(a a1)
        {
            return a1.g;
        }

        static Executor g(a a1)
        {
            return a1.h;
        }

        static Executor h(a a1)
        {
            return a1.i;
        }

        static int i(a a1)
        {
            return a1.l;
        }

        static int j(a a1)
        {
            return a1.m;
        }

        static aiw k(a a1)
        {
            return a1.o;
        }

        static aht l(a a1)
        {
            return a1.t;
        }

        static aid m(a a1)
        {
            return a1.s;
        }

        static aij n(a a1)
        {
            return a1.x;
        }

        static ajj o(a a1)
        {
            return a1.v;
        }

        static ajd p(a a1)
        {
            return a1.w;
        }

        static boolean q(a a1)
        {
            return a1.j;
        }

        static boolean r(a a1)
        {
            return a1.k;
        }

        static boolean s(a a1)
        {
            return a1.y;
        }

        public a a()
        {
            n = true;
            return this;
        }

        public a a(int i1)
        {
            if (i1 <= 0)
            {
                throw new IllegalArgumentException("maxCacheSize must be a positive number");
            }
            if (t != null)
            {
                ajt.c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
            }
            q = i1;
            return this;
        }

        public a a(aia aia)
        {
            if (t != null)
            {
                ajt.c("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
            }
            u = aia;
            return this;
        }

        public a a(aiw aiw1)
        {
            if (h != null || i != null)
            {
                ajt.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            o = aiw1;
            return this;
        }

        public a a(ajj ajj)
        {
            v = ajj;
            return this;
        }

        public ail b()
        {
            c();
            return new ail(this);
        }

        static 
        {
            a = aiw.a;
        }

        public a(Context context)
        {
            c = 0;
            d = 0;
            e = 0;
            f = 0;
            g = null;
            h = null;
            i = null;
            j = false;
            k = false;
            l = 3;
            m = 4;
            n = false;
            o = a;
            p = 0;
            q = 0L;
            r = 0;
            s = null;
            t = null;
            u = null;
            v = null;
            x = null;
            y = false;
            b = context.getApplicationContext();
        }
    }

    private static class b
        implements ajj
    {

        private final ajj a;

        public InputStream a(String s1, Object obj)
            throws IOException
        {
            static class _cls1
            {

                static final int a[];

                static 
                {
                    a = new int[ajj.a.values().length];
                    try
                    {
                        a[ajj.a.a.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[ajj.a.b.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1.a[ajj.a.a(s1).ordinal()])
            {
            default:
                return a.a(s1, obj);

            case 1: // '\001'
            case 2: // '\002'
                throw new IllegalStateException();
            }
        }

        public b(ajj ajj1)
        {
            a = ajj1;
        }
    }

    private static class c
        implements ajj
    {

        private final ajj a;

        public InputStream a(String s1, Object obj)
            throws IOException
        {
            obj = a.a(s1, obj);
            switch (_cls1.a[ajj.a.a(s1).ordinal()])
            {
            default:
                return ((InputStream) (obj));

            case 1: // '\001'
            case 2: // '\002'
                return new ais(((InputStream) (obj)));
            }
        }

        public c(ajj ajj1)
        {
            a = ajj1;
        }
    }


    final Resources a;
    final int b;
    final int c;
    final int d;
    final int e;
    final ajq f;
    final Executor g;
    final Executor h;
    final boolean i;
    final boolean j;
    final int k;
    final int l;
    final aiw m;
    final aid n;
    final aht o;
    final ajj p;
    final ajd q;
    final aij r;
    final ajj s;
    final ajj t;

    private ail(a a1)
    {
        a = a.a(a1).getResources();
        b = a.b(a1);
        c = a.c(a1);
        d = a.d(a1);
        e = a.e(a1);
        f = a.f(a1);
        g = a.g(a1);
        h = a.h(a1);
        k = a.i(a1);
        l = a.j(a1);
        m = a.k(a1);
        o = a.l(a1);
        n = a.m(a1);
        r = a.n(a1);
        p = a.o(a1);
        q = a.p(a1);
        i = a.q(a1);
        j = a.r(a1);
        s = new b(p);
        t = new c(p);
        ajt.a(a.s(a1));
    }

    ail(a a1, _cls1 _pcls1)
    {
        this(a1);
    }

    aiu a()
    {
        DisplayMetrics displaymetrics = a.getDisplayMetrics();
        int j1 = b;
        int i1 = j1;
        if (j1 <= 0)
        {
            i1 = displaymetrics.widthPixels;
        }
        int k1 = c;
        j1 = k1;
        if (k1 <= 0)
        {
            j1 = displaymetrics.heightPixels;
        }
        return new aiu(i1, j1);
    }
}
