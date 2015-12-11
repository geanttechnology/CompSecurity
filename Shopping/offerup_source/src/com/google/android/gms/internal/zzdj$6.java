// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zziz

final class l.client.zzb
    implements zzdk
{

    public final void zza(zziz zziz1, Map map)
    {
        map = zziz1.zzhc();
        if (map != null)
        {
            map.close();
            return;
        }
        zziz1 = zziz1.zzhd();
        if (zziz1 != null)
        {
            zziz1.close();
            return;
        } else
        {
            zzb.zzaH("A GMSG tried to close something that wasn't an overlay.");
            return;
        }
    }

    l.client.zzb()
    {
    }
}
