// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.tapjoy.internal:
//            bg

public final class y
{

    private static Handler a;

    public static Handler a()
    {
        com/tapjoy/internal/y;
        JVM INSTR monitorenter ;
        Handler handler;
        if (a == null)
        {
            a = new Handler(Looper.getMainLooper());
        }
        handler = a;
        com/tapjoy/internal/y;
        JVM INSTR monitorexit ;
        return handler;
        Exception exception;
        exception;
        throw exception;
    }

    public static bg a(Handler handler)
    {
        return new bg(handler) {

            final Handler a;

            public final boolean a(Runnable runnable)
            {
                return a.post(runnable);
            }

            
            {
                a = handler;
                super();
            }
        };
    }
}
