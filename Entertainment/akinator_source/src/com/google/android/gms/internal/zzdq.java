// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zze;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzfc, zzfb, zzfe, 
//            zzfd, zziz

public class zzdq
    implements zzdk
{

    static final Map zzxS;
    private final zze zzxQ;
    private final zzfc zzxR;

    public zzdq(zze zze1, zzfc zzfc1)
    {
        zzxQ = zze1;
        zzxR = zzfc1;
    }

    public void zza(zziz zziz, Map map)
    {
        String s = (String)map.get("a");
        int i = ((Integer)zzxS.get(s)).intValue();
        if (i != 5 && zzxQ != null && !zzxQ.zzbe())
        {
            zzxQ.zzp(null);
            return;
        }
        switch (i)
        {
        case 2: // '\002'
        default:
            zzb.zzaG("Unknown MRAID command called.");
            return;

        case 1: // '\001'
            zzxR.zzg(map);
            return;

        case 4: // '\004'
            (new zzfb(zziz, map)).execute();
            return;

        case 3: // '\003'
            (new zzfe(zziz, map)).execute();
            return;

        case 5: // '\005'
            (new zzfd(zziz, map)).execute();
            return;

        case 6: // '\006'
            zzxR.zzn(true);
            break;
        }
    }

    static 
    {
        zzxS = new HashMap();
        zzxS.put("resize", Integer.valueOf(1));
        zzxS.put("playVideo", Integer.valueOf(2));
        zzxS.put("storePicture", Integer.valueOf(3));
        zzxS.put("createCalendarEvent", Integer.valueOf(4));
        zzxS.put("setOrientationProperties", Integer.valueOf(5));
        zzxS.put("closeResizedAd", Integer.valueOf(6));
    }
}
