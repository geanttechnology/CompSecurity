// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zze, zzl

class zzZi
    implements Runnable
{

    final String zzUQ;
    final zze zzZd;
    final zzUQ zzZf;
    final String zzZi;

    public void run()
    {
        com.google.android.gms.cast.geReceivedCallback gereceivedcallback;
        synchronized (zze.zze(zzZd))
        {
            gereceivedcallback = (com.google.android.gms.cast.geReceivedCallback)zze.zze(zzZd).get(zzUQ);
        }
        if (gereceivedcallback != null)
        {
            gereceivedcallback.onMessageReceived(zze.zzf(zzZd), zzUQ, zzZi);
            return;
        } else
        {
            zze.zzmZ().zzb("Discarded message for unknown namespace '%s'", new Object[] {
                zzUQ
            });
            return;
        }
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    dCallback(dCallback dcallback, zze zze1, String s, String s1)
    {
        zzZf = dcallback;
        zzZd = zze1;
        zzUQ = s;
        zzZi = s1;
        super();
    }
}
