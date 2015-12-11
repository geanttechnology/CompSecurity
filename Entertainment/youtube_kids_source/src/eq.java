// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import java.util.WeakHashMap;

class eq
    implements ex
{

    private WeakHashMap a;

    eq()
    {
        a = null;
    }

    private void c(ep ep1, View view)
    {
        Runnable runnable = null;
        if (a != null)
        {
            runnable = (Runnable)a.get(view);
        }
        Object obj = runnable;
        if (runnable == null)
        {
            obj = new er(this, ep1, view);
            if (a == null)
            {
                a = new WeakHashMap();
            }
            a.put(view, obj);
        }
        view.removeCallbacks(((Runnable) (obj)));
        view.post(((Runnable) (obj)));
    }

    public void a(ep ep1, View view)
    {
        c(ep1, view);
    }

    public void a(ep ep1, View view, float f)
    {
        c(ep1, view);
    }

    public void a(ep ep1, View view, fa fa1)
    {
        view.setTag(0x7e000000, fa1);
    }

    void b(ep ep1, View view)
    {
        Object obj = view.getTag(0x7e000000);
        Runnable runnable;
        if (obj instanceof fa)
        {
            obj = (fa)obj;
        } else
        {
            obj = null;
        }
        runnable = ep.a(ep1);
        ep1 = ep.b(ep1);
        if (runnable != null)
        {
            runnable.run();
        }
        if (obj != null)
        {
            ((fa) (obj)).a(view);
            ((fa) (obj)).b(view);
        }
        if (ep1 != null)
        {
            ep1.run();
        }
        if (a != null)
        {
            a.remove(view);
        }
    }
}
