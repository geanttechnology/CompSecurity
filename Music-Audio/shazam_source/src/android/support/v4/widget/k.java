// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import android.widget.Scroller;

public final class k
{
    public static interface a
    {

        public abstract Object a(Context context, Interpolator interpolator);

        public abstract void a(Object obj, int i, int j, int l);

        public abstract void a(Object obj, int i, int j, int l, int i1);

        public abstract boolean a(Object obj);

        public abstract int b(Object obj);

        public abstract int c(Object obj);

        public abstract float d(Object obj);

        public abstract boolean e(Object obj);

        public abstract void f(Object obj);

        public abstract int g(Object obj);

        public abstract int h(Object obj);
    }

    static final class b
        implements a
    {

        public final Object a(Context context, Interpolator interpolator)
        {
            if (interpolator != null)
            {
                return new Scroller(context, interpolator);
            } else
            {
                return new Scroller(context);
            }
        }

        public final void a(Object obj, int i, int j, int l)
        {
            ((Scroller)obj).startScroll(0, 0, i, j, l);
        }

        public final void a(Object obj, int i, int j, int l, int i1)
        {
            ((Scroller)obj).fling(0, 0, i, j, l, i1, 0x80000000, 0x7fffffff);
        }

        public final boolean a(Object obj)
        {
            return ((Scroller)obj).isFinished();
        }

        public final int b(Object obj)
        {
            return ((Scroller)obj).getCurrX();
        }

        public final int c(Object obj)
        {
            return ((Scroller)obj).getCurrY();
        }

        public final float d(Object obj)
        {
            return 0.0F;
        }

        public final boolean e(Object obj)
        {
            return ((Scroller)obj).computeScrollOffset();
        }

        public final void f(Object obj)
        {
            ((Scroller)obj).abortAnimation();
        }

        public final int g(Object obj)
        {
            return ((Scroller)obj).getFinalX();
        }

        public final int h(Object obj)
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

        public final Object a(Context context, Interpolator interpolator)
        {
            if (interpolator != null)
            {
                return new OverScroller(context, interpolator);
            } else
            {
                return new OverScroller(context);
            }
        }

        public final void a(Object obj, int i, int j, int l)
        {
            ((OverScroller)obj).startScroll(0, 0, i, j, l);
        }

        public final void a(Object obj, int i, int j, int l, int i1)
        {
            ((OverScroller)obj).fling(0, 0, i, j, l, i1, 0x80000000, 0x7fffffff);
        }

        public final boolean a(Object obj)
        {
            return ((OverScroller)obj).isFinished();
        }

        public final int b(Object obj)
        {
            return ((OverScroller)obj).getCurrX();
        }

        public final int c(Object obj)
        {
            return ((OverScroller)obj).getCurrY();
        }

        public float d(Object obj)
        {
            return 0.0F;
        }

        public final boolean e(Object obj)
        {
            return ((OverScroller)obj).computeScrollOffset();
        }

        public final void f(Object obj)
        {
            ((OverScroller)obj).abortAnimation();
        }

        public final int g(Object obj)
        {
            return ((OverScroller)obj).getFinalX();
        }

        public final int h(Object obj)
        {
            return ((OverScroller)obj).getFinalY();
        }

        c()
        {
        }
    }

    static final class d extends c
    {

        public final float d(Object obj)
        {
            return ((OverScroller)obj).getCurrVelocity();
        }

        d()
        {
        }
    }


    public Object a;
    public a b;

    private k(int i, Context context, Interpolator interpolator)
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

    private k(Context context, Interpolator interpolator)
    {
        this(android.os.Build.VERSION.SDK_INT, context, interpolator);
    }

    public static k a(Context context, Interpolator interpolator)
    {
        return new k(context, interpolator);
    }

    public final int a()
    {
        return b.h(a);
    }

    public final void a(int i, int j, int l, int i1)
    {
        b.a(a, i, j, l, i1);
    }

    public final void b()
    {
        b.f(a);
    }
}
