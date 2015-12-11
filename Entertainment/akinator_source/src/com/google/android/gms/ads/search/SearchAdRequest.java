// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.search;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.mediation.NetworkExtras;

public final class SearchAdRequest
{

    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final int zzKS;
    private final int zzKT;
    private final int zzKU;
    private final int zzKV;
    private final int zzKW;
    private final int zzKX;
    private final int zzKY;
    private final String zzKZ;
    private final int zzLa;
    private final String zzLb;
    private final int zzLc;
    private final int zzLd;
    private final String zzLe;
    private final zzy zznO;
    private final int zzwg;

    private SearchAdRequest(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        zzKS = Builder.zza(builder);
        zzwg = Builder.zzb(builder);
        zzKT = Builder.zzc(builder);
        zzKU = Builder.zzd(builder);
        zzKV = Builder.zze(builder);
        zzKW = Builder.zzf(builder);
        zzKX = Builder.zzg(builder);
        zzKY = Builder.zzh(builder);
        zzKZ = Builder.zzi(builder);
        zzLa = Builder.zzj(builder);
        zzLb = Builder.zzk(builder);
        zzLc = Builder.zzl(builder);
        zzLd = Builder.zzm(builder);
        zzLe = Builder.zzn(builder);
        zznO = new zzy(Builder.zzo(builder), this);
    }

    SearchAdRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public int getAnchorTextColor()
    {
        return zzKS;
    }

    public int getBackgroundColor()
    {
        return zzwg;
    }

    public int getBackgroundGradientBottom()
    {
        return zzKT;
    }

    public int getBackgroundGradientTop()
    {
        return zzKU;
    }

    public int getBorderColor()
    {
        return zzKV;
    }

    public int getBorderThickness()
    {
        return zzKW;
    }

    public int getBorderType()
    {
        return zzKX;
    }

    public int getCallButtonColor()
    {
        return zzKY;
    }

    public String getCustomChannels()
    {
        return zzKZ;
    }

    public Bundle getCustomEventExtrasBundle(Class class1)
    {
        return zznO.getCustomEventExtrasBundle(class1);
    }

    public int getDescriptionTextColor()
    {
        return zzLa;
    }

    public String getFontFace()
    {
        return zzLb;
    }

    public int getHeaderTextColor()
    {
        return zzLc;
    }

    public int getHeaderTextSize()
    {
        return zzLd;
    }

    public Location getLocation()
    {
        return zznO.getLocation();
    }

    public NetworkExtras getNetworkExtras(Class class1)
    {
        return zznO.getNetworkExtras(class1);
    }

    public Bundle getNetworkExtrasBundle(Class class1)
    {
        return zznO.getNetworkExtrasBundle(class1);
    }

    public String getQuery()
    {
        return zzLe;
    }

    public boolean isTestDevice(Context context)
    {
        return zznO.isTestDevice(context);
    }

    zzy zzaF()
    {
        return zznO;
    }

    static 
    {
        DEVICE_ID_EMULATOR = zzy.DEVICE_ID_EMULATOR;
    }
}
