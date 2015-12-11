// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            ad, ah, aj

static class a
    implements a
{
    final class a
        implements Runnable
    {

        WeakReference a;
        ad b;
        final ad.a c;

        public final void run()
        {
            View view = (View)a.get();
            if (view != null)
            {
                c.d(b, view);
            }
        }

        private a(ad ad1, View view)
        {
            c = ad.a.this;
            super();
            a = new WeakReference(view);
            b = ad1;
        }

        a(ad ad1, View view, byte byte0)
        {
            this(ad1, view);
        }
    }


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
            obj = new a(ad1, view, (byte)0);
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

    public void a(ad ad1, View view, float f)
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

    public void b(ad ad1, View view, float f)
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

    public void c(ad ad1, View view, float f)
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
