// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


// Referenced classes of package com.google.android.gms.analytics.internal:
//            r, g

final class a
    implements ad.UncaughtExceptionHandler
{

    final r a;

    public final void uncaughtException(Thread thread, Throwable throwable)
    {
        thread = a.e;
        if (thread != null)
        {
            thread.e("Job execution failed", throwable);
        }
    }

    (r r1)
    {
        a = r1;
        super();
    }
}
