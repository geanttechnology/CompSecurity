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
        zzAv = zza.zza(zza1);
        zzAw = com.google.android.gms.internal.zza.zzb(zza1);
        zzAx = zza.zzc(zza1);
        zzAy = zza.zzd(zza1);
        zzAz = zza.zze(zza1);
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

    private class zza
    {

        private boolean zzAv;
        private boolean zzAw;
        private boolean zzAx;
        private boolean zzAy;
        private boolean zzAz;

        static boolean zza(zza zza1)
        {
            return zza1.zzAv;
        }

        static boolean zzb(zza zza1)
        {
            return zza1.zzAw;
        }

        static boolean zzc(zza zza1)
        {
            return zza1.zzAx;
        }

        static boolean zzd(zza zza1)
        {
            return zza1.zzAy;
        }

        static boolean zze(zza zza1)
        {
            return zza1.zzAz;
        }

        public final zzff zzeh()
        {
            return new zzff(this);
        }

        public final zza zzo(boolean flag)
        {
            zzAv = flag;
            return this;
        }

        public final zza zzp(boolean flag)
        {
            zzAw = flag;
            return this;
        }

        public final zza zzq(boolean flag)
        {
            zzAx = flag;
            return this;
        }

        public final zza zzr(boolean flag)
        {
            zzAy = flag;
            return this;
        }

        public final zza zzs(boolean flag)
        {
            zzAz = flag;
            return this;
        }

        public zza()
        {
        }
    }

}
