// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzi, zzac

class zzNj
    implements Runnable
{

    final zzac zzNj;
    final zzNj zzNk;

    public void run()
    {
        if (!zzNk.Ng.isConnected())
        {
            zzNk.Ng.zzbb("Connected to service after a timeout");
            zzi.zza(zzNk.Ng, zzNj);
        }
    }

    _cls9(_cls9 _pcls9, zzac zzac)
    {
        zzNk = _pcls9;
        zzNj = zzac;
        super();
    }
}
