// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zziz, zzan, zzaj

final class .client.zzb
    implements zzdk
{

    public final void zza(zziz zziz1, Map map)
    {
        String s = (String)map.get("tx");
        String s1 = (String)map.get("ty");
        map = (String)map.get("td");
        int i;
        int j;
        int k;
        try
        {
            i = Integer.parseInt(s);
            j = Integer.parseInt(s1);
            k = Integer.parseInt(map);
            zziz1 = zziz1.zzhg();
        }
        // Misplaced declaration of an exception variable
        catch (zziz zziz1)
        {
            zzb.zzaH("Could not parse touch parameters from gmsg.");
            return;
        }
        if (zziz1 == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        zziz1.zzab().zza(i, j, k);
    }

    .client.zzb()
    {
    }
}
