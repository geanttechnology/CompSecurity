// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;


// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzp, zzv, zzs

class zzaMU
    implements Runnable
{

    final String zzaMU;
    final zzp zzaMV;

    public void run()
    {
        zzs zzs1 = zzaMV.zzaKG.zzzs();
        if (!zzs1.isInitialized() || zzs1.zzAp())
        {
            zzaMV.zzl(6, "Persisted config not initialized . Not logging error/warn.");
            return;
        } else
        {
            zzs1.zzaNh.zzbn(zzaMU);
            return;
        }
    }

    b(zzp zzp1, String s)
    {
        zzaMV = zzp1;
        zzaMU = s;
        super();
    }
}
