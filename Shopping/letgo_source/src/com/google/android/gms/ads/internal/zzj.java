// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v7.oj;
import android.support.v7.ok;
import android.support.v7.ol;
import android.support.v7.om;
import android.support.v7.pz;
import android.support.v7.vk;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzi

public class zzj extends com.google.android.gms.ads.internal.client.zzp.zza
{

    private final Context mContext;
    private zzn zzoS;
    private NativeAdOptionsParcel zzoX;
    private final String zzoZ;
    private final pz zzow;
    private final VersionInfoParcel zzpa;
    private oj zzpf;
    private ok zzpg;
    private vk zzph;
    private vk zzpi;

    public zzj(Context context, String s, pz pz, VersionInfoParcel versioninfoparcel)
    {
        mContext = context;
        zzoZ = s;
        zzow = pz;
        zzpa = versioninfoparcel;
        zzpi = new vk();
        zzph = new vk();
    }

    public void zza(oj oj)
    {
        zzpf = oj;
    }

    public void zza(ok ok)
    {
        zzpg = ok;
    }

    public void zza(NativeAdOptionsParcel nativeadoptionsparcel)
    {
        zzoX = nativeadoptionsparcel;
    }

    public void zza(String s, om om, ol ol)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        } else
        {
            zzpi.put(s, om);
            zzph.put(s, ol);
            return;
        }
    }

    public void zzb(zzn zzn)
    {
        zzoS = zzn;
    }

    public zzo zzbk()
    {
        return new zzi(mContext, zzoZ, zzow, zzpa, zzoS, zzpf, zzpg, zzpi, zzph, zzoX);
    }
}
