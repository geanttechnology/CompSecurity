// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzb, zzl

class zzMB
    implements Runnable
{

    final String zzMA;
    final Runnable zzMB;
    final zzb zzMy;

    public void run()
    {
        zzb.zza(zzMy).zzbi(zzMA);
        if (zzMB != null)
        {
            zzMB.run();
        }
    }

    (zzb zzb1, String s, Runnable runnable)
    {
        zzMy = zzb1;
        zzMA = s;
        zzMB = runnable;
        super();
    }
}
