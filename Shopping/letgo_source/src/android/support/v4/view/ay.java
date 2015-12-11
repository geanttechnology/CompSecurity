// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            bc, be, az, ah, 
//            ba, bb

public class ay
{
    static class a
        implements g
    {

        WeakHashMap a;

        static void a(a a1, ay ay1, View view)
        {
            a1.c(ay1, view);
        }

        private void a(View view)
        {
            if (a != null)
            {
                Runnable runnable = (Runnable)a.get(view);
                if (runnable != null)
                {
                    view.removeCallbacks(runnable);
                }
            }
        }

        private void c(ay ay1, View view)
        {
            Object obj = view.getTag(0x7e000000);
            Runnable runnable;
            if (obj instanceof bc)
            {
                obj = (bc)obj;
            } else
            {
                obj = null;
            }
            runnable = ay.a(ay1);
            ay1 = ay.b(ay1);
            if (runnable != null)
            {
                runnable.run();
            }
            if (obj != null)
            {
                ((bc) (obj)).onAnimationStart(view);
                ((bc) (obj)).onAnimationEnd(view);
            }
            if (ay1 != null)
            {
                ay1.run();
            }
            if (a != null)
            {
                a.remove(view);
            }
        }

        private void d(ay ay1, View view)
        {
            Runnable runnable;
            Object obj;
            if (a != null)
            {
                runnable = (Runnable)a.get(view);
            } else
            {
                runnable = null;
            }
            obj = runnable;
            if (runnable == null)
            {
                obj = new a(this, ay1, view);
                if (a == null)
                {
                    a = new WeakHashMap();
                }
                a.put(view, obj);
            }
            view.removeCallbacks(((Runnable) (obj)));
            view.post(((Runnable) (obj)));
        }

        public void a(ay ay1, View view)
        {
            d(ay1, view);
        }

        public void a(ay ay1, View view, float f1)
        {
            d(ay1, view);
        }

        public void a(ay ay1, View view, long l)
        {
        }

        public void a(ay ay1, View view, bc bc1)
        {
            view.setTag(0x7e000000, bc1);
        }

        public void a(ay ay1, View view, be be)
        {
        }

        public void a(ay ay1, View view, Interpolator interpolator)
        {
        }

        public void b(ay ay1, View view)
        {
            a(view);
            c(ay1, view);
        }

        public void b(ay ay1, View view, float f1)
        {
            d(ay1, view);
        }

        public void b(ay ay1, View view, long l)
        {
        }

        public void c(ay ay1, View view, float f1)
        {
            d(ay1, view);
        }

        public void d(ay ay1, View view, float f1)
        {
            d(ay1, view);
        }

        a()
        {
            a = null;
        }
    }

    class a.a
        implements Runnable
    {

        WeakReference a;
        ay b;
        final a c;

        public void run()
        {
            View view = (View)a.get();
            if (view != null)
            {
                a.a(c, b, view);
            }
        }

        private a.a(a a1, ay ay1, View view)
        {
            c = a1;
            super();
            a = new WeakReference(view);
            b = ay1;
        }

    }

    static class b extends a
    {

        WeakHashMap b;

        public void a(ay ay1, View view)
        {
            az.a(view);
        }

        public void a(ay ay1, View view, float f1)
        {
            az.a(view, f1);
        }

        public void a(ay ay1, View view, long l)
        {
            az.a(view, l);
        }

        public void a(ay ay1, View view, bc bc)
        {
            view.setTag(0x7e000000, bc);
            az.a(view, new a(ay1));
        }

        public void a(ay ay1, View view, Interpolator interpolator)
        {
            az.a(view, interpolator);
        }

        public void b(ay ay1, View view)
        {
            az.b(view);
        }

        public void b(ay ay1, View view, float f1)
        {
            az.b(view, f1);
        }

        public void b(ay ay1, View view, long l)
        {
            az.b(view, l);
        }

        public void c(ay ay1, View view, float f1)
        {
            az.c(view, f1);
        }

        public void d(ay ay1, View view, float f1)
        {
            az.d(view, f1);
        }

        b()
        {
            b = null;
        }
    }

    static class b.a
        implements bc
    {

        ay a;

        public void onAnimationCancel(View view)
        {
            Object obj = view.getTag(0x7e000000);
            if (obj instanceof bc)
            {
                obj = (bc)obj;
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                ((bc) (obj)).onAnimationCancel(view);
            }
        }

        public void onAnimationEnd(View view)
        {
            if (ay.c(a) >= 0)
            {
                ah.a(view, ay.c(a), null);
                ay.a(a, -1);
            }
            if (ay.b(a) != null)
            {
                ay.b(a).run();
            }
            Object obj = view.getTag(0x7e000000);
            if (obj instanceof bc)
            {
                obj = (bc)obj;
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                ((bc) (obj)).onAnimationEnd(view);
            }
        }

        public void onAnimationStart(View view)
        {
            if (ay.c(a) >= 0)
            {
                ah.a(view, 2, null);
            }
            if (ay.a(a) != null)
            {
                ay.a(a).run();
            }
            Object obj = view.getTag(0x7e000000);
            if (obj instanceof bc)
            {
                obj = (bc)obj;
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                ((bc) (obj)).onAnimationStart(view);
            }
        }

        b.a(ay ay1)
        {
            a = ay1;
        }
    }

    static class c extends d
    {

        c()
        {
        }
    }

    static class d extends b
    {

        public void a(ay ay1, View view, bc bc)
        {
            ba.a(view, bc);
        }

        d()
        {
        }
    }

    static class e extends c
    {

        public void a(ay ay1, View view, be be)
        {
            bb.a(view, be);
        }

        e()
        {
        }
    }

    static class f extends e
    {

        f()
        {
        }
    }

    static interface g
    {

        public abstract void a(ay ay1, View view);

        public abstract void a(ay ay1, View view, float f1);

        public abstract void a(ay ay1, View view, long l);

        public abstract void a(ay ay1, View view, bc bc);

        public abstract void a(ay ay1, View view, be be);

        public abstract void a(ay ay1, View view, Interpolator interpolator);

        public abstract void b(ay ay1, View view);

        public abstract void b(ay ay1, View view, float f1);

        public abstract void b(ay ay1, View view, long l);

        public abstract void c(ay ay1, View view, float f1);

        public abstract void d(ay ay1, View view, float f1);
    }


    static final g a;
    private WeakReference b;
    private Runnable c;
    private Runnable d;
    private int e;

    ay(View view)
    {
        c = null;
        d = null;
        e = -1;
        b = new WeakReference(view);
    }

    static int a(ay ay1, int i)
    {
        ay1.e = i;
        return i;
    }

    static Runnable a(ay ay1)
    {
        return ay1.c;
    }

    static Runnable b(ay ay1)
    {
        return ay1.d;
    }

    static int c(ay ay1)
    {
        return ay1.e;
    }

    public ay a(float f1)
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.a(this, view, f1);
        }
        return this;
    }

    public ay a(long l)
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.a(this, view, l);
        }
        return this;
    }

    public ay a(bc bc)
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.a(this, view, bc);
        }
        return this;
    }

    public ay a(be be)
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.a(this, view, be);
        }
        return this;
    }

    public ay a(Interpolator interpolator)
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.a(this, view, interpolator);
        }
        return this;
    }

    public void a()
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.a(this, view);
        }
    }

    public ay b(float f1)
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.b(this, view, f1);
        }
        return this;
    }

    public ay b(long l)
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.b(this, view, l);
        }
        return this;
    }

    public void b()
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.b(this, view);
        }
    }

    public ay c(float f1)
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.c(this, view, f1);
        }
        return this;
    }

    public ay d(float f1)
    {
        View view = (View)b.get();
        if (view != null)
        {
            a.d(this, view, f1);
        }
        return this;
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            a = new f();
        } else
        if (i >= 19)
        {
            a = new e();
        } else
        if (i >= 18)
        {
            a = new c();
        } else
        if (i >= 16)
        {
            a = new d();
        } else
        if (i >= 14)
        {
            a = new b();
        } else
        {
            a = new a();
        }
    }
}
