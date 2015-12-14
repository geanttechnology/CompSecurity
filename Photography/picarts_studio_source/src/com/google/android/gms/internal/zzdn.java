// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzdo, zziz

public class zzdn
    implements zzdk
{

    private final zzdo zzxO;

    public zzdn(zzdo zzdo1)
    {
        zzxO = zzdo1;
    }

    public void zza(zziz zziz, Map map)
    {
        boolean flag;
        boolean flag1;
        flag = "1".equals(map.get("transparentBackground"));
        flag1 = "1".equals(map.get("blur"));
        if (map.get("blurRadius") == null) goto _L2; else goto _L1
_L1:
        float f = Float.parseFloat((String)map.get("blurRadius"));
_L4:
        zzxO.zzd(flag);
        zzxO.zza(flag1, f);
        return;
        zziz;
        zzb.zzb("Fail to parse float", zziz);
_L2:
        f = 0.0F;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
