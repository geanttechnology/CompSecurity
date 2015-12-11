// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            ay, bc, be

static class a
    implements a
{
    class a
        implements Runnable
    {

        WeakReference a;
        ay b;
        final ay.a c;

        public void run()
        {
            View view = (View)a.get();
            if (view != null)
            {
                ay.a.a(c, b, view);
            }
        }

        private a(ay ay1, View view)
        {
            c = ay.a.this;
            super();
            a = new WeakReference(view);
            b = ay1;
        }

        a(ay ay1, View view, ay._cls1 _pcls1)
        {
            this(ay1, view);
        }
    }


    WeakHashMap a;

    static void a(a.b b1, ay ay1, View view)
    {
        b1.c(ay1, view);
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
            obj = new a(ay1, view, null);
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

    public void a(ay ay1, View view, float f)
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

    public void b(ay ay1, View view, float f)
    {
        d(ay1, view);
    }

    public void b(ay ay1, View view, long l)
    {
    }

    public void c(ay ay1, View view, float f)
    {
        d(ay1, view);
    }

    public void d(ay ay1, View view, float f)
    {
        d(ay1, view);
    }

    a()
    {
        a = null;
    }
}
