// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzgm, zziq, zzcm

public class zzgo
    implements zzgm.zza
{

    private final boolean zzEa;
    private final boolean zzEb;

    public zzgo(boolean flag, boolean flag1)
    {
        zzEa = flag;
        zzEb = flag1;
    }

    public com.google.android.gms.ads.internal.formats.zzh.zza zza(zzgm zzgm1, JSONObject jsonobject)
    {
        return zzc(zzgm1, jsonobject);
    }

    public zze zzc(zzgm zzgm1, JSONObject jsonobject)
    {
        Object obj = zzgm1.zza(jsonobject, "images", true, zzEa, zzEb);
        zziq zziq1 = zzgm1.zza(jsonobject, "secondary_image", false, zzEa);
        zzgm1 = zzgm1.zze(jsonobject);
        ArrayList arraylist = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((zziq)((Iterator) (obj)).next()).get())) { }
        return new zze(jsonobject.getString("headline"), arraylist, jsonobject.getString("body"), (zzcm)zziq1.get(), jsonobject.getString("call_to_action"), jsonobject.getString("advertiser"), (zza)zzgm1.get(), new Bundle());
    }
}
