// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.millennialmedia.android:
//            an, aj, al, ao, 
//            MMActivity, d

abstract class ai
{

    private static final String a = com/millennialmedia/android/ai.getName();
    protected WeakReference b;
    protected WeakReference c;

    ai()
    {
    }

    static long a(String s)
    {
        if (s != null)
        {
            return (long)Float.parseFloat(s);
        } else
        {
            return -4L;
        }
    }

    static aj a(Callable callable)
    {
        callable = new FutureTask(callable);
        an.a(callable);
        callable = (aj)callable.get();
        return callable;
        callable;
        al.a(a, "Future interrupted", callable);
_L2:
        return null;
        callable;
        al.a(a, "Future execution problem: ", callable);
        if (true) goto _L2; else goto _L1
_L1:
    }

    abstract aj a(String s, Map map);

    final void a(ao ao1)
    {
        c = new WeakReference(ao1);
    }

    final d b()
    {
        Object obj = (ao)c.get();
        if (obj != null)
        {
            obj = ((ao) (obj)).g();
            if (obj instanceof MMActivity)
            {
                obj = ((MMActivity)obj).a;
                if (obj instanceof d)
                {
                    return (d)obj;
                }
            }
        }
        return null;
    }

    final void b(Context context)
    {
        b = new WeakReference(context);
    }

}
