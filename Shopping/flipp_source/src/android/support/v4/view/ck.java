// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            cr, cl, cw, cj

class ck
    implements cr
{

    WeakHashMap a;

    ck()
    {
        a = null;
    }

    private void d(cj cj1, View view)
    {
        Runnable runnable = null;
        if (a != null)
        {
            runnable = (Runnable)a.get(view);
        }
        Object obj = runnable;
        if (runnable == null)
        {
            obj = new cl(this, cj1, view, (byte)0);
            if (a == null)
            {
                a = new WeakHashMap();
            }
            a.put(view, obj);
        }
        view.removeCallbacks(((Runnable) (obj)));
        view.post(((Runnable) (obj)));
    }

    public void a(cj cj1, View view)
    {
        d(cj1, view);
    }

    public void a(cj cj1, View view, float f)
    {
        d(cj1, view);
    }

    public void a(cj cj1, View view, cw cw1)
    {
        view.setTag(0x7e000000, cw1);
    }

    public void a(View view, long l)
    {
    }

    public void b(cj cj1, View view)
    {
        if (a != null)
        {
            Runnable runnable = (Runnable)a.get(view);
            if (runnable != null)
            {
                view.removeCallbacks(runnable);
            }
        }
        c(cj1, view);
    }

    public void b(cj cj1, View view, float f)
    {
        d(cj1, view);
    }

    final void c(cj cj1, View view)
    {
        Object obj = view.getTag(0x7e000000);
        Runnable runnable;
        if (obj instanceof cw)
        {
            obj = (cw)obj;
        } else
        {
            obj = null;
        }
        runnable = cj.a(cj1);
        cj1 = cj.b(cj1);
        if (runnable != null)
        {
            runnable.run();
        }
        if (obj != null)
        {
            ((cw) (obj)).a(view);
            ((cw) (obj)).b(view);
        }
        if (cj1 != null)
        {
            cj1.run();
        }
        if (a != null)
        {
            a.remove(view);
        }
    }

    public void c(cj cj1, View view, float f)
    {
        d(cj1, view);
    }
}
