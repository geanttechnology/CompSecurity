// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zze, zzl

class zzXq
    implements Runnable
{

    final String zzTb;
    final zze zzXl;
    final zzTb zzXn;
    final String zzXq;

    public void run()
    {
        com.google.android.gms.cast.geReceivedCallback gereceivedcallback;
        synchronized (zze.zze(zzXl))
        {
            gereceivedcallback = (com.google.android.gms.cast.geReceivedCallback)zze.zze(zzXl).get(zzTb);
        }
        if (gereceivedcallback != null)
        {
            gereceivedcallback.onMessageReceived(zze.zzf(zzXl), zzTb, zzXq);
            return;
        } else
        {
            zze.zzmD().zzb("Discarded message for unknown namespace '%s'", new Object[] {
                zzTb
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
        zzXn = dcallback;
        zzXl = zze1;
        zzTb = s;
        zzXq = s1;
        super();
    }
}
