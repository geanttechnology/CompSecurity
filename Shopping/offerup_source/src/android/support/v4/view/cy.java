// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            dg, dk, cx, cz, 
//            dm

class cy
    implements dg
{

    private WeakHashMap a;

    cy()
    {
        a = null;
    }

    static void a(cy cy1, cx cx1, View view)
    {
        cy1.c(cx1, view);
    }

    private void c(cx cx1, View view)
    {
        Object obj = view.getTag(0x7e000000);
        Runnable runnable;
        if (obj instanceof dk)
        {
            obj = (dk)obj;
        } else
        {
            obj = null;
        }
        runnable = cx.a(cx1);
        cx1 = cx.b(cx1);
        if (runnable != null)
        {
            runnable.run();
        }
        if (obj != null)
        {
            ((dk) (obj)).onAnimationStart(view);
            ((dk) (obj)).onAnimationEnd(view);
        }
        if (cx1 != null)
        {
            cx1.run();
        }
        if (a != null)
        {
            a.remove(view);
        }
    }

    private void d(cx cx1, View view)
    {
        Runnable runnable = null;
        if (a != null)
        {
            runnable = (Runnable)a.get(view);
        }
        Object obj = runnable;
        if (runnable == null)
        {
            obj = new cz(this, cx1, view, (byte)0);
            if (a == null)
            {
                a = new WeakHashMap();
            }
            a.put(view, obj);
        }
        view.removeCallbacks(((Runnable) (obj)));
        view.post(((Runnable) (obj)));
    }

    public long a(View view)
    {
        return 0L;
    }

    public void a(cx cx1, View view)
    {
        d(cx1, view);
    }

    public void a(cx cx1, View view, float f)
    {
        d(cx1, view);
    }

    public void a(cx cx1, View view, dk dk1)
    {
        view.setTag(0x7e000000, dk1);
    }

    public void a(View view, long l)
    {
    }

    public void a(View view, dm dm)
    {
    }

    public void a(View view, Interpolator interpolator)
    {
    }

    public void b(cx cx1, View view)
    {
        if (a != null)
        {
            Runnable runnable = (Runnable)a.get(view);
            if (runnable != null)
            {
                view.removeCallbacks(runnable);
            }
        }
        c(cx1, view);
    }

    public void b(cx cx1, View view, float f)
    {
        d(cx1, view);
    }

    public void b(View view, long l)
    {
    }

    public void c(cx cx1, View view, float f)
    {
        d(cx1, view);
    }

    public void d(cx cx1, View view, float f)
    {
        d(cx1, view);
    }

    public void e(cx cx1, View view, float f)
    {
        d(cx1, view);
    }
}
