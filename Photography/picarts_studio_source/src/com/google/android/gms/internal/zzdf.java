// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzdg, zziz

public final class zzdf
    implements zzdk
{

    private final zzdg zzxn;

    public zzdf(zzdg zzdg1)
    {
        zzxn = zzdg1;
    }

    public final void zza(zziz zziz, Map map)
    {
        zziz = (String)map.get("name");
        if (zziz == null)
        {
            zzb.zzaH("App event with no name parameter.");
            return;
        } else
        {
            zzxn.onAppEvent(zziz, (String)map.get("info"));
            return;
        }
    }
}
