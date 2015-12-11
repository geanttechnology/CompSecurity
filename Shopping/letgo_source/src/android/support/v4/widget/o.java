// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

// Referenced classes of package android.support.v4.widget:
//            p, q

public class o
{
    static interface a
    {

        public abstract Object a(Context context, Interpolator interpolator);

        public abstract void a(Object obj, int i, int j, int k, int l, int i1);

        public abstract void a(Object obj, int i, int j, int k, int l, int i1, int j1, 
                int k1, int l1);

        public abstract boolean a(Object obj);

        public abstract int b(Object obj);

        public abstract int c(Object obj);

        public abstract float d(Object obj);

        public abstract boolean e(Object obj);

        public abstract void f(Object obj);

        public abstract int g(Object obj);

        public abstract int h(Object obj);
    }

    static class b
        implements a
    {

        public Object a(Context context, Interpolator interpolator)
        {
            if (interpolator != null)
            {
                return new Scroller(context, interpolator);
            } else
            {
                return new Scroller(context);
            }
        }

        public void a(Object obj, int i, int j, int k, int l, int i1)
        {
            ((Scroller)obj).startScroll(i, j, k, l, i1);
        }

        public void a(Object obj, int i, int j, int k, int l, int i1, int j1, 
                int k1, int l1)
        {
            ((Scroller)obj).fling(i, j, k, l, i1, j1, k1, l1);
        }

        public boolean a(Object obj)
        {
            return ((Scroller)obj).isFinished();
        }

        public int b(Object obj)
        {
            return ((Scroller)obj).getCurrX();
        }

        public int c(Object obj)
        {
            return ((Scroller)obj).getCurrY();
        }

        public float d(Object obj)
        {
            return 0.0F;
        }

        public boolean e(Object obj)
        {
            return ((Scroller)obj).computeScrollOffset();
        }

        public void f(Object obj)
        {
            ((Scroller)obj).abortAnimation();
        }

        public int g(Object obj)
        {
            return ((Scroller)obj).getFinalX();
        }

        public int h(Object obj)
        {
            return ((Scroller)obj).getFinalY();
        }

        b()
        {
        }
    }

    static class c
        implements a
    {

        public Object a(Context context, Interpolator interpolator)
        {
            return p.a(context, interpolator);
        }

        public void a(Object obj, int i, int j, int k, int l, int i1)
        {
            p.a(obj, i, j, k, l, i1);
        }

        public void a(Object obj, int i, int j, int k, int l, int i1, int j1, 
                int k1, int l1)
        {
            p.a(obj, i, j, k, l, i1, j1, k1, l1);
        }

        public boolean a(Object obj)
        {
            return p.a(obj);
        }

        public int b(Object obj)
        {
            return p.b(obj);
        }

        public int c(Object obj)
        {
            return p.c(obj);
        }

        public float d(Object obj)
        {
            return 0.0F;
        }

        public boolean e(Object obj)
        {
            return p.d(obj);
        }

        public void f(Object obj)
        {
            p.e(obj);
        }

        public int g(Object obj)
        {
            return p.f(obj);
        }

        public int h(Object obj)
        {
            return p.g(obj);
        }

        c()
        {
        }
    }

    static class d extends c
    {

        public float d(Object obj)
        {
            return q.a(obj);
        }

        d()
        {
        }
    }


    Object a;
    a b;

    private o(int i, Context context, Interpolator interpolator)
    {
        if (i >= 14)
        {
            b = new d();
        } else
        if (i >= 9)
        {
            b = new c();
        } else
        {
            b = new b();
        }
        a = b.a(context, interpolator);
    }

    o(Context context, Interpolator interpolator)
    {
        this(android.os.Build.VERSION.SDK_INT, context, interpolator);
    }

    public static o a(Context context)
    {
        return a(context, null);
    }

    public static o a(Context context, Interpolator interpolator)
    {
        return new o(context, interpolator);
    }

    public void a(int i, int j, int k, int l, int i1)
    {
        b.a(a, i, j, k, l, i1);
    }

    public void a(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1)
    {
        b.a(a, i, j, k, l, i1, j1, k1, l1);
    }

    public boolean a()
    {
        return b.a(a);
    }

    public int b()
    {
        return b.b(a);
    }

    public int c()
    {
        return b.c(a);
    }

    public int d()
    {
        return b.g(a);
    }

    public int e()
    {
        return b.h(a);
    }

    public float f()
    {
        return b.d(a);
    }

    public boolean g()
    {
        return b.e(a);
    }

    public void h()
    {
        b.f(a);
    }
}
