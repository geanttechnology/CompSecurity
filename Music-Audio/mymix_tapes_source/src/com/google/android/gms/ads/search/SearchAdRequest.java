// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.search;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzx;
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
    private final int zzJN;
    private final int zzJO;
    private final int zzJP;
    private final int zzJQ;
    private final int zzJR;
    private final int zzJS;
    private final int zzJT;
    private final String zzJU;
    private final int zzJV;
    private final String zzJW;
    private final int zzJX;
    private final int zzJY;
    private final String zzJZ;
    private final zzx zznN;
    private final int zzvF;

    private SearchAdRequest(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        zzJN = Builder.zza(builder);
        zzvF = Builder.zzb(builder);
        zzJO = Builder.zzc(builder);
        zzJP = Builder.zzd(builder);
        zzJQ = Builder.zze(builder);
        zzJR = Builder.zzf(builder);
        zzJS = Builder.zzg(builder);
        zzJT = Builder.zzh(builder);
        zzJU = Builder.zzi(builder);
        zzJV = Builder.zzj(builder);
        zzJW = Builder.zzk(builder);
        zzJX = Builder.zzl(builder);
        zzJY = Builder.zzm(builder);
        zzJZ = Builder.zzn(builder);
        zznN = new zzx(Builder.zzo(builder), this);
    }

    SearchAdRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public int getAnchorTextColor()
    {
        return zzJN;
    }

    public int getBackgroundColor()
    {
        return zzvF;
    }

    public int getBackgroundGradientBottom()
    {
        return zzJO;
    }

    public int getBackgroundGradientTop()
    {
        return zzJP;
    }

    public int getBorderColor()
    {
        return zzJQ;
    }

    public int getBorderThickness()
    {
        return zzJR;
    }

    public int getBorderType()
    {
        return zzJS;
    }

    public int getCallButtonColor()
    {
        return zzJT;
    }

    public String getCustomChannels()
    {
        return zzJU;
    }

    public Bundle getCustomEventExtrasBundle(Class class1)
    {
        return zznN.getCustomEventExtrasBundle(class1);
    }

    public int getDescriptionTextColor()
    {
        return zzJV;
    }

    public String getFontFace()
    {
        return zzJW;
    }

    public int getHeaderTextColor()
    {
        return zzJX;
    }

    public int getHeaderTextSize()
    {
        return zzJY;
    }

    public Location getLocation()
    {
        return zznN.getLocation();
    }

    public NetworkExtras getNetworkExtras(Class class1)
    {
        return zznN.getNetworkExtras(class1);
    }

    public Bundle getNetworkExtrasBundle(Class class1)
    {
        return zznN.getNetworkExtrasBundle(class1);
    }

    public String getQuery()
    {
        return zzJZ;
    }

    public boolean isTestDevice(Context context)
    {
        return zznN.isTestDevice(context);
    }

    zzx zzaF()
    {
        return zznN;
    }

    static 
    {
        DEVICE_ID_EMULATOR = zzx.DEVICE_ID_EMULATOR;
    }
}
