// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            ah, aj, w

public final class ad
{
    static class a
        implements g
    {

        WeakHashMap a;

        private void e(ad ad1, View view)
        {
            Runnable runnable = null;
            if (a != null)
            {
                runnable = (Runnable)a.get(view);
            }
            Object obj = runnable;
            if (runnable == null)
            {
                obj = new a(this, ad1, view, (byte)0);
                if (a == null)
                {
                    a = new WeakHashMap();
                }
                a.put(view, obj);
            }
            view.removeCallbacks(((Runnable) (obj)));
            view.post(((Runnable) (obj)));
        }

        public void a(ad ad1, View view)
        {
            e(ad1, view);
        }

        public void a(ad ad1, View view, float f1)
        {
            e(ad1, view);
        }

        public void a(ad ad1, View view, ah ah1)
        {
            view.setTag(0x7e000000, ah1);
        }

        public void a(View view, long l)
        {
        }

        public void a(View view, aj aj)
        {
        }

        public void a(View view, Interpolator interpolator)
        {
        }

        public void b(ad ad1, View view)
        {
            e(ad1, view);
        }

        public void b(ad ad1, View view, float f1)
        {
            e(ad1, view);
        }

        public void c(ad ad1, View view)
        {
            if (a != null)
            {
                Runnable runnable = (Runnable)a.get(view);
                if (runnable != null)
                {
                    view.removeCallbacks(runnable);
                }
            }
            d(ad1, view);
        }

        public void c(ad ad1, View view, float f1)
        {
            e(ad1, view);
        }

        final void d(ad ad1, View view)
        {
            Object obj = view.getTag(0x7e000000);
            Runnable runnable;
            if (obj instanceof ah)
            {
                obj = (ah)obj;
            } else
            {
                obj = null;
            }
            runnable = ad.a(ad1);
            ad1 = ad.b(ad1);
            if (runnable != null)
            {
                runnable.run();
            }
            if (obj != null)
            {
                ((ah) (obj)).a(view);
                ((ah) (obj)).b(view);
            }
            if (ad1 != null)
            {
                ad1.run();
            }
            if (a != null)
            {
                a.remove(view);
            }
        }

        a()
        {
            a = null;
        }
    }

    final class a.a
        implements Runnable
    {

        WeakReference a;
        ad b;
        final a c;

        public final void run()
        {
            View view = (View)a.get();
            if (view != null)
            {
                c.d(b, view);
            }
        }

        private a.a(a a1, ad ad1, View view)
        {
            c = a1;
            super();
            a = new WeakReference(view);
            b = ad1;
        }

        a.a(a a1, ad ad1, View view, byte byte0)
        {
            this(a1, ad1, view);
        }
    }

    static class b extends a
    {

        WeakHashMap b;

        public final void a(ad ad1, View view)
        {
            view.animate().scaleY(1.0F);
        }

        public final void a(ad ad1, View view, float f1)
        {
            view.animate().alpha(f1);
        }

        public void a(ad ad1, View view, ah ah)
        {
            view.setTag(0x7e000000, ah);
            ad1 = new a(ad1);
            view.animate().setListener(new ae._cls1(ad1, view));
        }

        public final void a(View view, long l)
        {
            view.animate().setDuration(l);
        }

        public final void a(View view, Interpolator interpolator)
        {
            view.animate().setInterpolator(interpolator);
        }

        public final void b(ad ad1, View view)
        {
            view.animate().cancel();
        }

        public final void b(ad ad1, View view, float f1)
        {
            view.animate().translationX(f1);
        }

        public final void c(ad ad1, View view)
        {
            view.animate().start();
        }

        public final void c(ad ad1, View view, float f1)
        {
            view.animate().translationY(f1);
        }

        b()
        {
            b = null;
        }
    }

    static final class b.a
        implements ah
    {

        ad a;

        public final void a(View view)
        {
            if (ad.d(a) >= 0)
            {
                w.a(view, 2, null);
            }
            if (ad.a(a) != null)
            {
                ad.a(a).run();
            }
            Object obj = view.getTag(0x7e000000);
            if (obj instanceof ah)
            {
                obj = (ah)obj;
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                ((ah) (obj)).a(view);
            }
        }

        public final void b(View view)
        {
            if (ad.d(a) >= 0)
            {
                w.a(view, ad.d(a), null);
                ad.c(a);
            }
            if (ad.b(a) != null)
            {
                ad.b(a).run();
            }
            Object obj = view.getTag(0x7e000000);
            if (obj instanceof ah)
            {
                obj = (ah)obj;
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                ((ah) (obj)).b(view);
            }
        }

        public final void c(View view)
        {
            Object obj = view.getTag(0x7e000000);
            if (obj instanceof ah)
            {
                obj = (ah)obj;
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                ((ah) (obj)).c(view);
            }
        }

        b.a(ad ad1)
        {
            a = ad1;
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

        public final void a(ad ad1, View view, ah ah)
        {
            if (ah != null)
            {
                view.animate().setListener(new af._cls1(ah, view));
                return;
            } else
            {
                view.animate().setListener(null);
                return;
            }
        }

        d()
        {
        }
    }

    static class e extends c
    {

        public final void a(View view, aj aj)
        {
            view.animate().setUpdateListener(new ag._cls1(aj, view));
        }

        e()
        {
        }
    }

    static final class f extends e
    {

        f()
        {
        }
    }

    public static interface g
    {

        public abstract void a(ad ad1, View view);

        public abstract void a(ad ad1, View view, float f1);

        public abstract void a(ad ad1, View view, ah ah);

        public abstract void a(View view, long l);

        public abstract void a(View view, aj aj);

        public abstract void a(View view, Interpolator interpolator);

        public abstract void b(ad ad1, View view);

        public abstract void b(ad ad1, View view, float f1);

        public abstract void c(ad ad1, View view);

        public abstract void c(ad ad1, View view, float f1);
    }


    public static final g b;
    public WeakReference a;
    private Runnable c;
    private Runnable d;
    private int e;

    ad(View view)
    {
        c = null;
        d = null;
        e = -1;
        a = new WeakReference(view);
    }

    static Runnable a(ad ad1)
    {
        return ad1.c;
    }

    static Runnable b(ad ad1)
    {
        return ad1.d;
    }

    static int c(ad ad1)
    {
        ad1.e = -1;
        return -1;
    }

    static int d(ad ad1)
    {
        return ad1.e;
    }

    public final ad a(float f1)
    {
        View view = (View)a.get();
        if (view != null)
        {
            b.a(this, view, f1);
        }
        return this;
    }

    public final ad a(long l)
    {
        View view = (View)a.get();
        if (view != null)
        {
            b.a(view, l);
        }
        return this;
    }

    public final ad a(ah ah)
    {
        View view = (View)a.get();
        if (view != null)
        {
            b.a(this, view, ah);
        }
        return this;
    }

    public final ad a(aj aj)
    {
        View view = (View)a.get();
        if (view != null)
        {
            b.a(view, aj);
        }
        return this;
    }

    public final ad a(Interpolator interpolator)
    {
        View view = (View)a.get();
        if (view != null)
        {
            b.a(view, interpolator);
        }
        return this;
    }

    public final void a()
    {
        View view = (View)a.get();
        if (view != null)
        {
            b.b(this, view);
        }
    }

    public final ad b(float f1)
    {
        View view = (View)a.get();
        if (view != null)
        {
            b.b(this, view, f1);
        }
        return this;
    }

    public final void b()
    {
        View view = (View)a.get();
        if (view != null)
        {
            b.c(this, view);
        }
    }

    public final ad c(float f1)
    {
        View view = (View)a.get();
        if (view != null)
        {
            b.c(this, view, f1);
        }
        return this;
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            b = new f();
        } else
        if (i >= 19)
        {
            b = new e();
        } else
        if (i >= 18)
        {
            b = new c();
        } else
        if (i >= 16)
        {
            b = new d();
        } else
        if (i >= 14)
        {
            b = new b();
        } else
        {
            b = new a();
        }
    }
}
