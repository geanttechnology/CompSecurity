// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Process;
import com.google.android.gms.ads.internal.p;
import java.util.concurrent.Callable;

// Referenced classes of package com.google.android.gms.d:
//            gl, gx, gd

static final class b
    implements Runnable
{

    final gx a;
    final Callable b;

    public final void run()
    {
        try
        {
            Process.setThreadPriority(10);
            a.b(b.call());
            return;
        }
        catch (Exception exception)
        {
            p.h().a(exception, true);
        }
        a.cancel(true);
    }

    ernal.p(gx gx1, Callable callable)
    {
        a = gx1;
        b = callable;
        super();
    }
}
