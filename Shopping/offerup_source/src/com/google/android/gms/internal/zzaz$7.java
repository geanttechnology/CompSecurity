// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzaz, zzax, zziz

class zzrw
    implements zzdk
{

    final zzaz zzrw;

    public void zza(zziz zziz, Map map)
    {
        if (!zzrw.zzb(map))
        {
            return;
        } else
        {
            zzb.zzaF((new StringBuilder("Received request to untrack: ")).append(com.google.android.gms.internal.zzaz.zzb(zzrw).zzbX()).toString());
            zzrw.destroy();
            return;
        }
    }

    l.client.zzb(zzaz zzaz1)
    {
        zzrw = zzaz1;
        super();
    }
}
