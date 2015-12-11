// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import com.a.d;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.a.a:
//            c, g, b

public abstract class a extends AsyncTask
{

    protected Activity a;
    protected d b;
    protected g c;
    protected Exception d;
    protected boolean e;
    private b f;
    private c g;
    private long h;

    public a(Activity activity, c c1, d d1, b b1, long l)
    {
        a = activity;
        b = d1;
        g = c1;
        f = b1;
        if (l < 1000L)
        {
            h = 5000L;
            return;
        } else
        {
            h = l;
            return;
        }
    }

    private void f()
    {
        a("Notifying listener...", new Object[0]);
        if (g == null) goto _L2; else goto _L1
_L1:
        if (c == null)
        {
            g.b(f);
        } else
        {
            g.a(f, c, d);
        }
        this;
        JVM INSTR monitorenter ;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
_L2:
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected abstract void a();

    protected final void a(g g1, Exception exception)
    {
        a((new StringBuilder("end process:")).append(g1).toString(), new Object[0]);
        e = true;
        if (g1 == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        b.a(f, g1);
        c = g1;
        d = exception;
        this;
        JVM INSTR monitorenter ;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        g1;
        this;
        JVM INSTR monitorexit ;
        throw g1;
    }

    final transient void a(String s, Object aobj[])
    {
        Log.v(getClass().getSimpleName(), (new StringBuilder("[")).append(f).append("]").append(String.format(s, aobj)).toString());
    }

    public final b b()
    {
        return f;
    }

    public final boolean c()
    {
        return e;
    }

    public final void d()
    {
        if (!e)
        {
            a("Timed out. Cancelling...", new Object[0]);
            a(g.e, new TimeoutException("Timed out."));
            e = true;
            cancel(true);
            f();
            return;
        } else
        {
            a("No need to timeout, already finished", new Object[0]);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        a("Starting runner...", new Object[0]);
        if (!e)
        {
            a();
        }
        return b;
    }

    public final long e()
    {
        return h;
    }

    protected void onPostExecute(Object obj)
    {
        a("Post Execute...", new Object[0]);
        f();
    }

    protected void onPreExecute()
    {
        a("Pre Execute...", new Object[0]);
        if (g != null)
        {
            g.a(f);
        }
        e = false;
    }
}
