// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;

// Referenced classes of package android.support.v7:
//            ait, ajq, ajf, aih

public final class aij
{
    public static class a
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
        private ait j;
        private android.graphics.BitmapFactory.Options k;
        private int l;
        private boolean m;
        private Object n;
        private ajq o;
        private ajq p;
        private ajf q;
        private Handler r;
        private boolean s;

        static int a(a a1)
        {
            return a1.a;
        }

        static int b(a a1)
        {
            return a1.b;
        }

        static int c(a a1)
        {
            return a1.c;
        }

        static Drawable d(a a1)
        {
            return a1.d;
        }

        static Drawable e(a a1)
        {
            return a1.e;
        }

        static Drawable f(a a1)
        {
            return a1.f;
        }

        static boolean g(a a1)
        {
            return a1.g;
        }

        static boolean h(a a1)
        {
            return a1.h;
        }

        static boolean i(a a1)
        {
            return a1.i;
        }

        static ait j(a a1)
        {
            return a1.j;
        }

        static android.graphics.BitmapFactory.Options k(a a1)
        {
            return a1.k;
        }

        static int l(a a1)
        {
            return a1.l;
        }

        static boolean m(a a1)
        {
            return a1.m;
        }

        static Object n(a a1)
        {
            return a1.n;
        }

        static ajq o(a a1)
        {
            return a1.o;
        }

        static ajq p(a a1)
        {
            return a1.p;
        }

        static ajf q(a a1)
        {
            return a1.q;
        }

        static Handler r(a a1)
        {
            return a1.r;
        }

        static boolean s(a a1)
        {
            return a1.s;
        }

        public a a(int i1)
        {
            a = i1;
            return this;
        }

        public a a(aij aij1)
        {
            a = aij.a(aij1);
            b = aij.b(aij1);
            c = aij.c(aij1);
            d = aij.d(aij1);
            e = aij.e(aij1);
            f = aij.f(aij1);
            g = aij.g(aij1);
            h = aij.h(aij1);
            i = aij.i(aij1);
            j = aij.j(aij1);
            k = aij.k(aij1);
            l = aij.l(aij1);
            m = aij.m(aij1);
            n = aij.n(aij1);
            o = aij.o(aij1);
            p = aij.p(aij1);
            q = aij.q(aij1);
            r = aij.r(aij1);
            s = aij.s(aij1);
            return this;
        }

        public a a(ait ait1)
        {
            j = ait1;
            return this;
        }

        public a a(ajf ajf)
        {
            if (ajf == null)
            {
                throw new IllegalArgumentException("displayer can't be null");
            } else
            {
                q = ajf;
                return this;
            }
        }

        public a a(boolean flag)
        {
            i = flag;
            return this;
        }

        public aij a()
        {
            return new aij(this);
        }

        public a b(int i1)
        {
            b = i1;
            return this;
        }

        public a b(boolean flag)
        {
            m = flag;
            return this;
        }

        public a c(int i1)
        {
            c = i1;
            return this;
        }

        public a()
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
            j = ait.c;
            k = new android.graphics.BitmapFactory.Options();
            l = 0;
            m = false;
            n = null;
            o = null;
            p = null;
            q = aih.c();
            r = null;
            s = false;
            k.inPurgeable = true;
            k.inInputShareable = true;
        }
    }


    private final int a;
    private final int b;
    private final int c;
    private final Drawable d;
    private final Drawable e;
    private final Drawable f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final ait j;
    private final android.graphics.BitmapFactory.Options k;
    private final int l;
    private final boolean m;
    private final Object n;
    private final ajq o;
    private final ajq p;
    private final ajf q;
    private final Handler r;
    private final boolean s;

    private aij(a a1)
    {
        a = a.a(a1);
        b = a.b(a1);
        c = a.c(a1);
        d = a.d(a1);
        e = a.e(a1);
        f = a.f(a1);
        g = a.g(a1);
        h = a.h(a1);
        i = a.i(a1);
        j = a.j(a1);
        k = a.k(a1);
        l = a.l(a1);
        m = a.m(a1);
        n = a.n(a1);
        o = a.o(a1);
        p = a.p(a1);
        q = a.q(a1);
        r = a.r(a1);
        s = a.s(a1);
    }


    static int a(aij aij1)
    {
        return aij1.a;
    }

    static int b(aij aij1)
    {
        return aij1.b;
    }

    static int c(aij aij1)
    {
        return aij1.c;
    }

    static Drawable d(aij aij1)
    {
        return aij1.d;
    }

    static Drawable e(aij aij1)
    {
        return aij1.e;
    }

    static Drawable f(aij aij1)
    {
        return aij1.f;
    }

    static boolean g(aij aij1)
    {
        return aij1.g;
    }

    static boolean h(aij aij1)
    {
        return aij1.h;
    }

    static boolean i(aij aij1)
    {
        return aij1.i;
    }

    static ait j(aij aij1)
    {
        return aij1.j;
    }

    static android.graphics.BitmapFactory.Options k(aij aij1)
    {
        return aij1.k;
    }

    static int l(aij aij1)
    {
        return aij1.l;
    }

    static boolean m(aij aij1)
    {
        return aij1.m;
    }

    static Object n(aij aij1)
    {
        return aij1.n;
    }

    static ajq o(aij aij1)
    {
        return aij1.o;
    }

    static ajq p(aij aij1)
    {
        return aij1.p;
    }

    static ajf q(aij aij1)
    {
        return aij1.q;
    }

    static Handler r(aij aij1)
    {
        return aij1.r;
    }

    static boolean s(aij aij1)
    {
        return aij1.s;
    }

    public static aij t()
    {
        return (new a()).a();
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

    public ait j()
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

    public ajq o()
    {
        return o;
    }

    public ajq p()
    {
        return p;
    }

    public ajf q()
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
