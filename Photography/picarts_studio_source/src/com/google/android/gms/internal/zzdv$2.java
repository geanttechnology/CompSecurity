// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdv, zziz

class zzyf
    implements Runnable
{

    final String zzyc;
    final String zzyd;
    final int zzyf;
    final zzdv zzyh;

    public void run()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("event", "precacheComplete");
        hashmap.put("src", zzyc);
        hashmap.put("cachedSrc", zzyd);
        hashmap.put("totalBytes", Integer.toString(zzyf));
        zzyh.zzoM.zzb("onPrecacheEvent", hashmap);
    }

    (zzdv zzdv1, String s, String s1, int i)
    {
        zzyh = zzdv1;
        zzyc = s;
        zzyd = s1;
        zzyf = i;
        super();
    }
}
