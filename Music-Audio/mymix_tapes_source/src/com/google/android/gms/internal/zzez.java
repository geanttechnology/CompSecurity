// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import org.json.JSONException;
import org.json.JSONObject;

public class zzez
{

    private final boolean zzzI;
    private final boolean zzzJ;
    private final boolean zzzK;
    private final boolean zzzL;
    private final boolean zzzM;

    private zzez(zza zza1)
    {
    /* block-local class not found */
    class zza {}

        zzzI = zza.zza(zza1);
        zzzJ = com.google.android.gms.internal.zza.zzb(zza1);
        zzzK = zza.zzc(zza1);
        zzzL = zza.zzd(zza1);
        zzzM = zza.zze(zza1);
    }

    zzez(zza zza1, _cls1 _pcls1)
    {
        this(zza1);
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = (new JSONObject()).put("sms", zzzI).put("tel", zzzJ).put("calendar", zzzK).put("storePicture", zzzL).put("inlineVideo", zzzM);
        }
        catch (JSONException jsonexception)
        {
            zzb.zzb("Error occured while obtaining the MRAID capabilities.", jsonexception);
            return null;
        }
        return jsonobject;
    }
}
