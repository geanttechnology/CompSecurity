// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.android.gms.d:
//            ez, he, gn, hf

public abstract class ew extends ez
    implements hf.a
{

    protected boolean a;
    private final hf k;
    private boolean l;

    protected ew(Context context, gb.a a1, he he1, fb.a a2)
    {
        super(context, a1, he1, a2);
        a = false;
        l = false;
        k = he1.i();
    }

    private boolean c(long l1)
    {
        l1 = 60000L - (SystemClock.elapsedRealtime() - l1);
        if (l1 <= 1L)
        {
            return false;
        }
        try
        {
            e.wait(l1);
        }
        catch (InterruptedException interruptedexception)
        {
            throw new ez.a("Ad request cancelled.", -1);
        }
        return true;
    }

    protected final void a(long l1)
    {
        do
        {
            if (!c(l1))
            {
                throw new ez.a("Timed out waiting for WebView to finish loading.", 2);
            }
            if (l)
            {
                throw new ez.a("Received cancellation request from creative.", 0);
            }
        } while (!a);
    }

    public final void a(he he1, boolean flag)
    {
        boolean flag1 = true;
        he1 = ((he) (e));
        he1;
        JVM INSTR monitorenter ;
        com.google.android.gms.ads.internal.util.client.b.a(3);
        a = true;
        Exception exception;
        if (!flag)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        l = flag;
        e.notify();
        he1;
        JVM INSTR monitorexit ;
        return;
        exception;
        he1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b()
    {
        synchronized (f)
        {
            d.stopLoading();
            p.g().a(d.getWebView());
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
