// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7:
//            d, h, e, c

class f
    implements d
{
    private static class a
        implements h
    {

        List a;
        List b;
        View c;
        private long d;
        private long e;
        private float f;
        private boolean g;
        private boolean h;
        private Runnable i;

        static float a(a a1, float f1)
        {
            a1.f = f1;
            return f1;
        }

        static long a(a a1)
        {
            return a1.e();
        }

        static long b(a a1)
        {
            return a1.d;
        }

        static long c(a a1)
        {
            return a1.e;
        }

        private void d()
        {
            for (int j = b.size() - 1; j >= 0; j--)
            {
                ((e)b.get(j)).onAnimationUpdate(this);
            }

        }

        static void d(a a1)
        {
            a1.d();
        }

        static float e(a a1)
        {
            return a1.f;
        }

        private long e()
        {
            return c.getDrawingTime();
        }

        private void f()
        {
            for (int j = a.size() - 1; j >= 0; j--)
            {
                ((c)a.get(j)).onAnimationStart(this);
            }

        }

        static void f(a a1)
        {
            a1.g();
        }

        static Runnable g(a a1)
        {
            return a1.i;
        }

        private void g()
        {
            for (int j = a.size() - 1; j >= 0; j--)
            {
                ((c)a.get(j)).onAnimationEnd(this);
            }

        }

        private void h()
        {
            for (int j = a.size() - 1; j >= 0; j--)
            {
                ((c)a.get(j)).onAnimationCancel(this);
            }

        }

        public void a()
        {
            if (g)
            {
                return;
            } else
            {
                g = true;
                f();
                f = 0.0F;
                d = e();
                c.postDelayed(i, 16L);
                return;
            }
        }

        public void a(long l)
        {
            if (!g)
            {
                e = l;
            }
        }

        public void a(c c1)
        {
            a.add(c1);
        }

        public void a(e e1)
        {
            b.add(e1);
        }

        public void a(View view)
        {
            c = view;
        }

        public void b()
        {
            if (h)
            {
                return;
            }
            h = true;
            if (g)
            {
                h();
            }
            g();
        }

        public float c()
        {
            return f;
        }

        public a()
        {
            a = new ArrayList();
            b = new ArrayList();
            e = 200L;
            f = 0.0F;
            g = false;
            h = false;
            i = new _cls1(this);
        }
    }


    f()
    {
    }

    public h a()
    {
        return new a();
    }

    // Unreferenced inner class android/support/v7/f$a$1

/* anonymous class */
    class a._cls1
        implements Runnable
    {

        final a a;

        public void run()
        {
            float f1 = ((float)(a.a(a) - a.b(a)) * 1.0F) / (float)a.c(a);
            if (f1 > 1.0F || a.c.getParent() == null)
            {
                f1 = 1.0F;
            }
            a.a(a, f1);
            a.d(a);
            if (a.e(a) >= 1.0F)
            {
                a.f(a);
                return;
            } else
            {
                a.c.postDelayed(a.g(a), 16L);
                return;
            }
        }

            
            {
                a = a1;
                super();
            }
    }

}
