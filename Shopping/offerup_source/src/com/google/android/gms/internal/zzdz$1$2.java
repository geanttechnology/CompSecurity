// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzdz, zzbb, zziz

class zzyv
    implements zzdk
{

    final zzbb zzyv;
    final client.zzb.v zzyw;

    public void zza(zziz zziz, Map map)
    {
label0:
        {
            synchronized (zzdz.zzc(zzyw.yu))
            {
                if (zzyw.yt.getStatus() != -1 && zzyw.yt.getStatus() != 1)
                {
                    break label0;
                }
            }
            return;
        }
        zzdz.zza(zzyw.yu, 0);
        zzdz.zzd(zzyw.yu).zzc(zzyv);
        zzyw.yt.zzg(zzyv);
        zzdz.zza(zzyw.yu, zzyw.yt);
        zzb.v("Successfully loaded JS Engine.");
        zziz;
        JVM INSTR monitorexit ;
        return;
        map;
        zziz;
        JVM INSTR monitorexit ;
        throw map;
    }

    client.zzb(client.zzb zzb1, zzbb zzbb)
    {
        zzyw = zzb1;
        zzyv = zzbb;
        super();
    }
}
