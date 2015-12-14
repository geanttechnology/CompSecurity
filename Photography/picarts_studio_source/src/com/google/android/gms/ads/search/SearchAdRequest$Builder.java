// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.search;

import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.NetworkExtras;

// Referenced classes of package com.google.android.gms.ads.search:
//            SearchAdRequest

public final class zzKX
{

    private int zzKS;
    private int zzKT;
    private int zzKU;
    private int zzKV;
    private int zzKW;
    private int zzKX;
    private int zzKY;
    private String zzKZ;
    private int zzLa;
    private String zzLb;
    private int zzLc;
    private int zzLd;
    private String zzLe;
    private final com.google.android.gms.ads.internal.client. zznP = new com.google.android.gms.ads.internal.client.();
    private int zzwg;

    static int zza(zzKX zzkx)
    {
        return zzkx.zzKS;
    }

    static int zzb(zzKS zzks)
    {
        return zzks.zzwg;
    }

    static int zzc(zzwg zzwg1)
    {
        return zzwg1.zzKT;
    }

    static int zzd(zzKT zzkt)
    {
        return zzkt.zzKU;
    }

    static int zze(zzKU zzku)
    {
        return zzku.zzKV;
    }

    static int zzf(zzKV zzkv)
    {
        return zzkv.zzKW;
    }

    static int zzg(zzKW zzkw)
    {
        return zzkw.zzKX;
    }

    static int zzh(zzKX zzkx)
    {
        return zzkx.zzKY;
    }

    static String zzi(zzKY zzky)
    {
        return zzky.zzKZ;
    }

    static int zzj(zzKZ zzkz)
    {
        return zzkz.zzLa;
    }

    static String zzk(zzLa zzla)
    {
        return zzla.zzLb;
    }

    static int zzl(zzLb zzlb)
    {
        return zzlb.zzLc;
    }

    static int zzm(zzLc zzlc)
    {
        return zzlc.zzLd;
    }

    static String zzn(zzLd zzld)
    {
        return zzld.zzLe;
    }

    static com.google.android.gms.ads.internal.client. zzo(zzLe zzle)
    {
        return zzle.zznP;
    }

    public final zznP addCustomEventExtrasBundle(Class class1, Bundle bundle)
    {
        zznP.(class1, bundle);
        return this;
    }

    public final zznP addNetworkExtras(NetworkExtras networkextras)
    {
        zznP.(networkextras);
        return this;
    }

    public final zznP addNetworkExtrasBundle(Class class1, Bundle bundle)
    {
        zznP.(class1, bundle);
        return this;
    }

    public final zznP addTestDevice(String s)
    {
        zznP.(s);
        return this;
    }

    public final SearchAdRequest build()
    {
        return new SearchAdRequest(this, null);
    }

    public final zznP setAnchorTextColor(int i)
    {
        zzKS = i;
        return this;
    }

    public final zzKS setBackgroundColor(int i)
    {
        zzwg = i;
        zzKT = Color.argb(0, 0, 0, 0);
        zzKU = Color.argb(0, 0, 0, 0);
        return this;
    }

    public final zzKU setBackgroundGradient(int i, int j)
    {
        zzwg = Color.argb(0, 0, 0, 0);
        zzKT = j;
        zzKU = i;
        return this;
    }

    public final zzKU setBorderColor(int i)
    {
        zzKV = i;
        return this;
    }

    public final zzKV setBorderThickness(int i)
    {
        zzKW = i;
        return this;
    }

    public final zzKW setBorderType(int i)
    {
        zzKX = i;
        return this;
    }

    public final zzKX setCallButtonColor(int i)
    {
        zzKY = i;
        return this;
    }

    public final zzKY setCustomChannels(String s)
    {
        zzKZ = s;
        return this;
    }

    public final zzKZ setDescriptionTextColor(int i)
    {
        zzLa = i;
        return this;
    }

    public final zzLa setFontFace(String s)
    {
        zzLb = s;
        return this;
    }

    public final zzLb setHeaderTextColor(int i)
    {
        zzLc = i;
        return this;
    }

    public final zzLc setHeaderTextSize(int i)
    {
        zzLd = i;
        return this;
    }

    public final zzLd setLocation(Location location)
    {
        zznP.(location);
        return this;
    }

    public final zznP setQuery(String s)
    {
        zzLe = s;
        return this;
    }

    public final zzLe setRequestAgent(String s)
    {
        zznP.(s);
        return this;
    }

    public final zznP tagForChildDirectedTreatment(boolean flag)
    {
        zznP.(flag);
        return this;
    }

    public ()
    {
        zzKX = 0;
    }
}
