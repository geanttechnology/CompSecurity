// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.search;

import android.graphics.Color;

// Referenced classes of package com.google.android.gms.ads.search:
//            SearchAdRequest

public static final class zzHS
{

    private int zzHN;
    private int zzHO;
    private int zzHP;
    private int zzHQ;
    private int zzHR;
    private int zzHS;
    private int zzHT;
    private String zzHU;
    private int zzHV;
    private String zzHW;
    private int zzHX;
    private int zzHY;
    private String zzHZ;
    private final com.google.android.gms.ads.internal.client. zznL = new com.google.android.gms.ads.internal.client.();
    private int zzvc;

    static int zza(zzHS zzhs)
    {
        return zzhs.zzHN;
    }

    static int zzb(zzHN zzhn)
    {
        return zzhn.zzvc;
    }

    static int zzc(zzvc zzvc1)
    {
        return zzvc1.zzHO;
    }

    static int zzd(zzHO zzho)
    {
        return zzho.zzHP;
    }

    static int zze(zzHP zzhp)
    {
        return zzhp.zzHQ;
    }

    static int zzf(zzHQ zzhq)
    {
        return zzhq.zzHR;
    }

    static int zzg(zzHR zzhr)
    {
        return zzhr.zzHS;
    }

    static int zzh(zzHS zzhs)
    {
        return zzhs.zzHT;
    }

    static String zzi(zzHT zzht)
    {
        return zzht.zzHU;
    }

    static int zzj(zzHU zzhu)
    {
        return zzhu.zzHV;
    }

    static String zzk(zzHV zzhv)
    {
        return zzhv.zzHW;
    }

    static int zzl(zzHW zzhw)
    {
        return zzhw.zzHX;
    }

    static int zzm(zzHX zzhx)
    {
        return zzhx.zzHY;
    }

    static String zzn(zzHY zzhy)
    {
        return zzhy.zzHZ;
    }

    static com.google.android.gms.ads.internal.client. zzo(zzHZ zzhz)
    {
        return zzhz.zznL;
    }

    public SearchAdRequest build()
    {
        return new SearchAdRequest(this, null);
    }

    public zznL setAnchorTextColor(int i)
    {
        zzHN = i;
        return this;
    }

    public zzHN setBackgroundColor(int i)
    {
        zzvc = i;
        zzHO = Color.argb(0, 0, 0, 0);
        zzHP = Color.argb(0, 0, 0, 0);
        return this;
    }

    public zzHP setDescriptionTextColor(int i)
    {
        zzHV = i;
        return this;
    }

    public zzHV setFontFace(String s)
    {
        zzHW = s;
        return this;
    }

    public zzHW setHeaderTextColor(int i)
    {
        zzHX = i;
        return this;
    }

    public zzHX setHeaderTextSize(int i)
    {
        zzHY = i;
        return this;
    }

    public zzHY setQuery(String s)
    {
        zzHZ = s;
        return this;
    }

    public ()
    {
        zzHS = 0;
    }
}
