// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdv, zziz

class zzyg
    implements Runnable
{

    final String zzyc;
    final String zzyd;
    final int zzye;
    final int zzyf;
    final boolean zzyg;
    final zzdv zzyh;

    public void run()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("event", "precacheProgress");
        hashmap.put("src", zzyc);
        hashmap.put("cachedSrc", zzyd);
        hashmap.put("bytesLoaded", Integer.toString(zzye));
        hashmap.put("totalBytes", Integer.toString(zzyf));
        String s;
        if (zzyg)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        hashmap.put("cacheReady", s);
        zzyh.zzoM.zzb("onPrecacheEvent", hashmap);
    }

    (zzdv zzdv1, String s, String s1, int i, int j, boolean flag)
    {
        zzyh = zzdv1;
        zzyc = s;
        zzyd = s1;
        zzye = i;
        zzyf = j;
        zzyg = flag;
        super();
    }
}
