// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzgv, zzin, zzgx, 
//            zziz, zzhy

class zzFT
    implements zzdk
{

    final zzgv zzFT;

    public void zza(zziz zziz1, Map map)
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
        zzgx zzgx1;
        zzgx1 = new zzgx(-2, map);
        if (zzgv.zzc(zzFT).equals(zzgx1.getRequestId()))
        {
            break MISSING_BLOCK_LABEL_100;
        }
        zzb.zzaH((new StringBuilder()).append(zzgx1.getRequestId()).append(" ==== ").append(zzgv.zzc(zzFT)).toString());
        obj;
        JVM INSTR monitorexit ;
        return;
        zziz1;
        obj;
        JVM INSTR monitorexit ;
        throw zziz1;
        String s = zzgx1.getUrl();
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        zzb.zzaH("URL missing in loadAdUrl GMSG.");
        obj;
        JVM INSTR monitorexit ;
        return;
        if (s.contains("%40mediation_adapters%40"))
        {
            zziz1 = s.replaceAll("%40mediation_adapters%40", zzhy.zza(zziz1.getContext(), (String)map.get("check_adapters"), zzgv.zzd(zzFT)));
            zzgx1.setUrl(zziz1);
            zzb.v((new StringBuilder("Ad request URL modified to ")).append(zziz1).toString());
        }
        com.google.android.gms.internal.zzgv.zzb(zzFT).zzf(zzgx1);
        obj;
        JVM INSTR monitorexit ;
    }

    l.client.zzb(zzgv zzgv1)
    {
        zzFT = zzgv1;
        super();
    }
}
