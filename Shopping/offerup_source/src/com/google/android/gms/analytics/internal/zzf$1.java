// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzf, zzaf

class zzMW
    implements .UncaughtExceptionHandler
{

    final zzf zzMW;

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        thread = zzMW.zziH();
        if (thread != null)
        {
            thread.zze("Job execution failed", throwable);
        }
    }

    (zzf zzf1)
    {
        zzMW = zzf1;
        super();
    }
}
