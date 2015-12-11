// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.animation.Interpolator;

class g
{
    static interface a
    {

        public abstract void a(g g1);

        public abstract void b(g g1);

        public abstract void c(g g1);
    }

    static class b
        implements a
    {

        public void a(g g1)
        {
        }

        public void b(g g1)
        {
        }

        public void c(g g1)
        {
        }

        b()
        {
        }
    }

    static interface c
    {

        public abstract void a(g g1);
    }

    static interface d
    {

        public abstract g a();
    }

    static abstract class e
    {

        abstract void a();

        abstract void a(float f, float f1);

        abstract void a(int i);

        abstract void a(int i, int j);

        abstract void a(a a1);

        abstract void a(b b1);

        abstract void a(Interpolator interpolator);

        abstract int b();

        abstract void c();

        abstract float d();

        e()
        {
        }
    }

    static interface e.a
    {

        public abstract void a();

        public abstract void b();

        public abstract void c();
    }

    static interface e.b
    {

        public abstract void a();
    }


    private final e a;

    g(e e1)
    {
        a = e1;
    }

    public void a()
    {
        a.a();
    }

    public void a(float f, float f1)
    {
        a.a(f, f1);
    }

    public void a(int i)
    {
        a.a(i);
    }

    public void a(int i, int j)
    {
        a.a(i, j);
    }

    public void a(a a1)
    {
        if (a1 != null)
        {
            a.a(new e.a(a1) {

                final a a;
                final g b;

                public void a()
                {
                    a.c(b);
                }

                public void b()
                {
                    a.a(b);
                }

                public void c()
                {
                    a.b(b);
                }

            
            {
                b = g.this;
                a = a1;
                super();
            }
            });
            return;
        } else
        {
            a.a(null);
            return;
        }
    }

    public void a(c c1)
    {
        if (c1 != null)
        {
            a.a(new e.b(c1) {

                final c a;
                final g b;

                public void a()
                {
                    a.a(b);
                }

            
            {
                b = g.this;
                a = c1;
                super();
            }
            });
            return;
        } else
        {
            a.a(null);
            return;
        }
    }

    public void a(Interpolator interpolator)
    {
        a.a(interpolator);
    }

    public int b()
    {
        return a.b();
    }

    public void c()
    {
        a.c();
    }

    public float d()
    {
        return a.d();
    }
}
