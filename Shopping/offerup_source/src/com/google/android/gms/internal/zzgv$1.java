// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzgv, zzin, zzgx, 
//            zziz

class zzFT
    implements zzdk
{

    final zzgv zzFT;

    public void zza(zziz zziz, Map map)
    {
label0:
        {
            synchronized (zzgv.zza(zzFT))
            {
                if (!com.google.android.gms.internal.zzgv.zzb(zzFT).isDone())
                {
                    break label0;
                }
            }
            return;
        }
        if (zzgv.zzc(zzFT).equals(map.get("request_id")))
        {
            break MISSING_BLOCK_LABEL_55;
        }
        zziz;
        JVM INSTR monitorexit ;
        return;
        map;
        zziz;
        JVM INSTR monitorexit ;
        throw map;
        map = new zzgx(1, map);
        zzb.zzaH((new StringBuilder("Invalid ")).append(map.getType()).append(" request error: ").append(map.zzfU()).toString());
        com.google.android.gms.internal.zzgv.zzb(zzFT).zzf(map);
        zziz;
        JVM INSTR monitorexit ;
    }

    l.client.zzb(zzgv zzgv1)
    {
        zzFT = zzgv1;
        super();
    }
}
