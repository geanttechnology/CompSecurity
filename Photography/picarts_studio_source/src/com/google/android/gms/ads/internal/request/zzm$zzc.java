// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zziz;
import java.util.Map;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzm

public class _cls9
    implements zzdk
{

    public void zza(zziz zziz, Map map)
    {
        zziz = (String)map.get("request_id");
        map = (String)map.get("errors");
        zzb.zzaH((new StringBuilder("Invalid request: ")).append(map).toString());
        zzm.zzfN().zzZ(zziz);
    }

    public _cls9()
    {
    }
}
