// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


// Referenced classes of package com.google.android.gms.analytics.internal:
//            r, g

class a
    implements ad.UncaughtExceptionHandler
{

    final r a;

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        thread = a.g();
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
