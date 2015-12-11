// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziz;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzp

public class zze
{
    public static class zzb
        implements zza
    {

        private final com.google.android.gms.internal.zzhs.zza zzoL;
        private final zziz zzoM;

        public void zzq(String s)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("An auto-clicking creative is blocked");
            android.net.Uri.Builder builder = new android.net.Uri.Builder();
            builder.scheme("https");
            builder.path("//pagead2.googlesyndication.com/pagead/gen_204");
            builder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(s))
            {
                builder.appendQueryParameter("navigationURL", s);
            }
            if (zzoL != null && zzoL.zzHD != null && !TextUtils.isEmpty(zzoL.zzHD.zzEP))
            {
                builder.appendQueryParameter("debugDialog", zzoL.zzHD.zzEP);
            }
            com.google.android.gms.ads.internal.zzp.zzbv().zzc(zzoM.getContext(), zzoM.zzhh().zzJu, builder.toString());
        }

        public zzb(com.google.android.gms.internal.zzhs.zza zza1, zziz zziz1)
        {
            zzoL = zza1;
            zzoM = zziz1;
        }
    }


    private zza zzoI;
    private boolean zzoJ;
    private boolean zzoK;

    public zze()
    {
        zzoK = ((Boolean)zzby.zzus.get()).booleanValue();
    }

    public zze(boolean flag)
    {
        zzoK = flag;
    }

    public void recordClick()
    {
        zzoJ = true;
    }

    public void zza(zza zza1)
    {
        zzoI = zza1;
    }

    public boolean zzbe()
    {
        return !zzoK || zzoJ;
    }

    public void zzp(String s)
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Action was blocked because no click was detected.");
    /* block-local class not found */
    class zza {}

        if (zzoI != null)
        {
            zzoI.zzq(s);
        }
    }
}
