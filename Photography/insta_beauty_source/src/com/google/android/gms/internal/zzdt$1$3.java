// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdg, zzdt, zzhr, zzbb, 
//            zzid

class zzwZ
    implements zzdg
{

    final zzbb zzwV;
    final zzwZ zzwW;
    final zzhr zzwZ;

    public void zza(zzid zzid, Map map)
    {
        synchronized (zzdt.zzc(zzwW.wU))
        {
            zzb.zzaA("JS Engine is requesting an update");
            if (zzdt.zze(zzwW.wU) == 0)
            {
                zzb.zzaA("Starting reload.");
                zzdt.zza(zzwW.wU, 2);
                zzwW.wU.zzdT();
            }
            zzwV.zzb("/requestReload", (zzdg)zzwZ.get());
        }
        return;
        map;
        zzid;
        JVM INSTR monitorexit ;
        throw map;
    }

    client.zzb(client.zzb zzb1, zzbb zzbb1, zzhr zzhr1)
    {
        zzwW = zzb1;
        zzwV = zzbb1;
        zzwZ = zzhr1;
        super();
    }
}
