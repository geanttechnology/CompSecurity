// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package com.google.android.gms.internal:
//            zzjc, zzjd, zzie, zziz, 
//            zzan, zzcg

public class zzjb
{

    public zzjb()
    {
    }

    public zziz zza(Context context, AdSizeParcel adsizeparcel, boolean flag, boolean flag1, zzan zzan, VersionInfoParcel versioninfoparcel)
    {
        return zza(context, adsizeparcel, flag, flag1, zzan, versioninfoparcel, null, null);
    }

    public zziz zza(Context context, AdSizeParcel adsizeparcel, boolean flag, boolean flag1, zzan zzan, VersionInfoParcel versioninfoparcel, zzcg zzcg, 
            zzd zzd)
    {
        context = new zzjc(zzjd.zzb(context, adsizeparcel, flag, flag1, zzan, versioninfoparcel, zzcg, zzd));
        context.setWebViewClient(zzp.zzbx().zzb(context, flag1));
        context.setWebChromeClient(zzp.zzbx().zzf(context));
        return context;
    }
}
