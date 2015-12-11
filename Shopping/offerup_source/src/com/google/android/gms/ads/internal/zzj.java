// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzmi;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzi

public class zzj extends com.google.android.gms.ads.internal.client.zzq.zza
{

    private final Context mContext;
    private zzo zzoT;
    private NativeAdOptionsParcel zzoY;
    private final zzem zzox;
    private final String zzpa;
    private final VersionInfoParcel zzpb;
    private zzcw zzpg;
    private zzcx zzph;
    private zzmi zzpi;
    private zzmi zzpj;

    public zzj(Context context, String s, zzem zzem, VersionInfoParcel versioninfoparcel)
    {
        mContext = context;
        zzpa = s;
        zzox = zzem;
        zzpb = versioninfoparcel;
        zzpj = new zzmi();
        zzpi = new zzmi();
    }

    public void zza(NativeAdOptionsParcel nativeadoptionsparcel)
    {
        zzoY = nativeadoptionsparcel;
    }

    public void zza(zzcw zzcw)
    {
        zzpg = zzcw;
    }

    public void zza(zzcx zzcx)
    {
        zzph = zzcx;
    }

    public void zza(String s, zzcz zzcz, zzcy zzcy)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        } else
        {
            zzpj.put(s, zzcz);
            zzpi.put(s, zzcy);
            return;
        }
    }

    public void zzb(zzo zzo)
    {
        zzoT = zzo;
    }

    public zzp zzbk()
    {
        return new zzi(mContext, zzpa, zzox, zzpb, zzoT, zzpg, zzph, zzpj, zzpi, zzoY);
    }
}
