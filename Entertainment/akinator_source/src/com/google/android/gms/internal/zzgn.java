// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzgm, zziq, zzcm

public class zzgn
    implements zzgm.zza
{

    private final boolean zzEa;
    private final boolean zzEb;

    public zzgn(boolean flag, boolean flag1)
    {
        zzEa = flag;
        zzEb = flag1;
    }

    public com.google.android.gms.ads.internal.formats.zzh.zza zza(zzgm zzgm1, JSONObject jsonobject)
        throws JSONException, InterruptedException, ExecutionException
    {
        return zzb(zzgm1, jsonobject);
    }

    public zzd zzb(zzgm zzgm1, JSONObject jsonobject)
        throws JSONException, InterruptedException, ExecutionException
    {
        Object obj = zzgm1.zza(jsonobject, "images", true, zzEa, zzEb);
        zziq zziq1 = zzgm1.zza(jsonobject, "app_icon", true, zzEa);
        zzgm1 = zzgm1.zze(jsonobject);
        ArrayList arraylist = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((zziq)((Iterator) (obj)).next()).get())) { }
        return new zzd(jsonobject.getString("headline"), arraylist, jsonobject.getString("body"), (zzcm)zziq1.get(), jsonobject.getString("call_to_action"), jsonobject.optDouble("rating", -1D), jsonobject.optString("store"), jsonobject.optString("price"), (zza)zzgm1.get(), new Bundle());
    }
}
