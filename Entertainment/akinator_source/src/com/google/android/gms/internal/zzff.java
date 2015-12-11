// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import org.json.JSONException;
import org.json.JSONObject;

public class zzff
{

    private final boolean zzAv;
    private final boolean zzAw;
    private final boolean zzAx;
    private final boolean zzAy;
    private final boolean zzAz;

    private zzff(zza zza1)
    {
    /* block-local class not found */
    class zza {}

        zzAv = zza.zza(zza1);
        zzAw = com.google.android.gms.internal.zza.zzb(zza1);
        zzAx = zza.zzc(zza1);
        zzAy = zza.zzd(zza1);
        zzAz = zza.zze(zza1);
    }

    zzff(zza zza1, _cls1 _pcls1)
    {
        this(zza1);
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = (new JSONObject()).put("sms", zzAv).put("tel", zzAw).put("calendar", zzAx).put("storePicture", zzAy).put("inlineVideo", zzAz);
        }
        catch (JSONException jsonexception)
        {
            zzb.zzb("Error occured while obtaining the MRAID capabilities.", jsonexception);
            return null;
        }
        return jsonobject;
    }
}
