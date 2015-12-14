// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdv, zziz

class zzyj
    implements Runnable
{

    final String zzyc;
    final String zzyd;
    final zzdv zzyh;
    final String zzyi;
    final String zzyj;

    public void run()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("event", "precacheCanceled");
        hashmap.put("src", zzyc);
        if (!TextUtils.isEmpty(zzyd))
        {
            hashmap.put("cachedSrc", zzyd);
        }
        hashmap.put("type", zzdv.zza(zzyh, zzyi));
        hashmap.put("reason", zzyi);
        if (!TextUtils.isEmpty(zzyj))
        {
            hashmap.put("message", zzyj);
        }
        zzyh.zzoM.zzb("onPrecacheEvent", hashmap);
    }

    (zzdv zzdv1, String s, String s1, String s2, String s3)
    {
        zzyh = zzdv1;
        zzyc = s;
        zzyd = s1;
        zzyi = s2;
        zzyj = s3;
        super();
    }
}
