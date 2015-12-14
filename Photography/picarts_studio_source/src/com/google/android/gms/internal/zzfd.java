// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzie, zziz

public class zzfd
{

    private final boolean zzAq;
    private final String zzAr;
    private final zziz zzoM;

    public zzfd(zziz zziz1, Map map)
    {
        zzoM = zziz1;
        zzAr = (String)map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange"))
        {
            zzAq = Boolean.parseBoolean((String)map.get("allowOrientationChange"));
            return;
        } else
        {
            zzAq = true;
            return;
        }
    }

    public void execute()
    {
        if (zzoM == null)
        {
            zzb.zzaH("AdWebView is null");
            return;
        }
        int i;
        if ("portrait".equalsIgnoreCase(zzAr))
        {
            i = zzp.zzbx().zzgH();
        } else
        if ("landscape".equalsIgnoreCase(zzAr))
        {
            i = zzp.zzbx().zzgG();
        } else
        if (zzAq)
        {
            i = -1;
        } else
        {
            i = zzp.zzbx().zzgI();
        }
        zzoM.setRequestedOrientation(i);
    }
}
