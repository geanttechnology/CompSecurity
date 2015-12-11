// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzdu, zziz, zzdt, 
//            zzdx

public class zzdw
    implements zzdk
{

    public zzdw()
    {
    }

    public void zza(zziz zziz1, Map map)
    {
        zzdu zzdu1 = zzp.zzbI();
        if (map.containsKey("abort"))
        {
            if (!zzdu1.zza(zziz1))
            {
                zzb.zzaH("Precache abort but no preload task running.");
            }
            return;
        }
        String s = (String)map.get("src");
        if (s == null)
        {
            zzb.zzaH("Precache video action is missing the src parameter.");
            return;
        }
        int i;
        try
        {
            i = Integer.parseInt((String)map.get("player"));
        }
        catch (NumberFormatException numberformatexception)
        {
            i = 0;
        }
        if (map.containsKey("mimetype"))
        {
            map = (String)map.get("mimetype");
        } else
        {
            map = "";
        }
        if (zzdu1.zzb(zziz1))
        {
            zzb.zzaH("Precache task already running.");
            return;
        } else
        {
            com.google.android.gms.common.internal.zzb.zzs(zziz1.zzhb());
            (new zzdt(zziz1, zziz1.zzhb().zzoG.zza(zziz1, i, map), s)).zzgz();
            return;
        }
    }
}
