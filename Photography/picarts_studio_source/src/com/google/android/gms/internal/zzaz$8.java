// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzaz, zziz

class zzrw
    implements zzdk
{

    final zzaz zzrw;

    public void zza(zziz zziz, Map map)
    {
        while (!zzrw.zzb(map) || !map.containsKey("isVisible")) 
        {
            return;
        }
        boolean flag;
        if ("1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzrw.zzg(Boolean.valueOf(flag).booleanValue());
    }

    (zzaz zzaz1)
    {
        zzrw = zzaz1;
        super();
    }
}
