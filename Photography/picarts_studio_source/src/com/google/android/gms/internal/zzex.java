// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class zzex
    implements NativeMediationAdRequest
{

    private final Date zzaT;
    private final Set zzaV;
    private final boolean zzaW;
    private final Location zzaX;
    private final NativeAdOptionsParcel zzoY;
    private final List zzoZ;
    private final int zzsR;
    private final int zzzI;

    public zzex(Date date, int i, Set set, Location location, boolean flag, int j, NativeAdOptionsParcel nativeadoptionsparcel, 
            List list)
    {
        zzaT = date;
        zzsR = i;
        zzaV = set;
        zzaX = location;
        zzaW = flag;
        zzzI = j;
        zzoY = nativeadoptionsparcel;
        zzoZ = list;
    }

    public final Date getBirthday()
    {
        return zzaT;
    }

    public final int getGender()
    {
        return zzsR;
    }

    public final Set getKeywords()
    {
        return zzaV;
    }

    public final Location getLocation()
    {
        return zzaX;
    }

    public final NativeAdOptions getNativeAdOptions()
    {
        if (zzoY == null)
        {
            return null;
        } else
        {
            return (new com.google.android.gms.ads.formats.NativeAdOptions.Builder()).setReturnUrlsForImageAssets(zzoY.zzwR).setImageOrientation(zzoY.zzwS).setRequestMultipleImages(zzoY.zzwT).build();
        }
    }

    public final boolean isAppInstallAdRequested()
    {
        return zzoZ != null && zzoZ.contains("2");
    }

    public final boolean isContentAdRequested()
    {
        return zzoZ != null && zzoZ.contains("1");
    }

    public final boolean isTesting()
    {
        return zzaW;
    }

    public final int taggedForChildDirectedTreatment()
    {
        return zzzI;
    }
}
