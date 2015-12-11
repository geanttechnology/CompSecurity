// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;

// Referenced classes of package com.google.android.gms.internal:
//            zzbw, zzbu

public class zzbx
{

    private boolean zzpA;
    private final Object zzpd = new Object();
    private SharedPreferences zzuj;

    public zzbx()
    {
        zzpA = false;
        zzuj = null;
    }

    public void initialize(Context context)
    {
label0:
        {
            synchronized (zzpd)
            {
                if (!zzpA)
                {
                    break label0;
                }
            }
            return;
        }
        context = GooglePlayServicesUtil.getRemoteContext(context);
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        zzuj = zzp.zzbC().zzv(context);
        zzpA = true;
        obj;
        JVM INSTR monitorexit ;
    }

    public Object zzd(zzbu zzbu1)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzpA)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        zzbu1 = ((zzbu) (zzbu1.zzde()));
        return zzbu1;
        obj;
        JVM INSTR monitorexit ;
        return zzbu1.zza(zzuj);
        zzbu1;
        obj;
        JVM INSTR monitorexit ;
        throw zzbu1;
    }
}
