// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.os.AsyncTask;
import com.appnexus.opensdk.b.b;
import java.util.ArrayList;
import java.util.LinkedList;

// Referenced classes of package com.appnexus.opensdk:
//            h, g, aa

abstract class ao
    implements h
{

    private long a;
    LinkedList b;
    protected g c;
    private ArrayList d;

    ao()
    {
        a = -1L;
        d = new ArrayList();
    }

    public final long a(long l)
    {
        if (a > 0L)
        {
            return l - a;
        } else
        {
            return -1L;
        }
    }

    public final LinkedList a()
    {
        return b;
    }

    public abstract void c();

    public final void d()
    {
        c = new g(this);
        a = System.currentTimeMillis();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            c.execute(new Void[0]);
            return;
        }
    }

    protected final void e()
    {
        if (d.isEmpty())
        {
            return;
        }
        StringBuilder stringbuilder = new StringBuilder("Mediated Classes: \n");
        for (int i = d.size(); i > 0; i--)
        {
            stringbuilder.append(String.format("%d: %s\n", new Object[] {
                Integer.valueOf(i), d.get(i - 1)
            }));
        }

        com.appnexus.opensdk.b.b.c(b.c, stringbuilder.toString());
        d.clear();
    }

    protected final aa f()
    {
        if (b != null && b.getFirst() != null)
        {
            d.add(((aa)b.getFirst()).a);
            return (aa)b.removeFirst();
        } else
        {
            return null;
        }
    }
}
