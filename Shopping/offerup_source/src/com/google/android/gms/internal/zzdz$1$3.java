// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzdz, zzil, zzbb, 
//            zziz

class zzyz
    implements zzdk
{

    final zzbb zzyv;
    final zzyz zzyw;
    final zzil zzyz;

    public void zza(zziz zziz, Map map)
    {
        synchronized (zzdz.zzc(zzyw.yu))
        {
            zzb.zzaG("JS Engine is requesting an update");
            if (zzdz.zze(zzyw.yu) == 0)
            {
                zzb.zzaG("Starting reload.");
                zzdz.zza(zzyw.yu, 2);
                zzyw.yu.zzdN();
            }
            zzyv.zzb("/requestReload", (zzdk)zzyz.get());
        }
        return;
        map;
        zziz;
        JVM INSTR monitorexit ;
        throw map;
    }

    client.zzb(client.zzb zzb1, zzbb zzbb1, zzil zzil1)
    {
        zzyw = zzb1;
        zzyv = zzbb1;
        zzyz = zzil1;
        super();
    }
}
