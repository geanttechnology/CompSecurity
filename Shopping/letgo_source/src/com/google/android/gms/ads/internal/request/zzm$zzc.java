// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.support.v7.ox;
import android.support.v7.pc;
import android.support.v7.ul;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzm

public static class _cls9
    implements ox
{

    public void zza(ul ul, Map map)
    {
        ul = (String)map.get("request_id");
        map = (String)map.get("errors");
        zzb.zzaE((new StringBuilder()).append("Invalid request: ").append(map).toString());
        zzm.zzfD().b(ul);
    }

    public _cls9()
    {
    }
}
