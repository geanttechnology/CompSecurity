// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.internal:
//            ei, eh, et

public final class eg
{

    private static final ThreadFactory a;
    private static final ThreadPoolExecutor b;

    public static void a(Runnable runnable)
    {
        try
        {
            b.execute(new eh(runnable));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Runnable runnable)
        {
            et.a("Too many background threads already running. Aborting task.", runnable);
        }
    }

    static 
    {
        a = new ei();
        b = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue(true), a);
    }
}
