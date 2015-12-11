// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

// Referenced classes of package com.google.android.gms.maps:
//            zzb

public final class StreetViewPanoramaOptions
    implements SafeParcelable
{

    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private Boolean zzaIB;
    private Boolean zzaIH;
    private StreetViewPanoramaCamera zzaJo;
    private String zzaJp;
    private LatLng zzaJq;
    private Integer zzaJr;
    private Boolean zzaJs;
    private Boolean zzaJt;
    private Boolean zzaJu;

    public StreetViewPanoramaOptions()
    {
        zzaJs = Boolean.valueOf(true);
        zzaIH = Boolean.valueOf(true);
        zzaJt = Boolean.valueOf(true);
        zzaJu = Boolean.valueOf(true);
        mVersionCode = 1;
    }

    StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetviewpanoramacamera, String s, LatLng latlng, Integer integer, byte byte0, byte byte1, 
            byte byte2, byte byte3, byte byte4)
    {
        zzaJs = Boolean.valueOf(true);
        zzaIH = Boolean.valueOf(true);
        zzaJt = Boolean.valueOf(true);
        zzaJu = Boolean.valueOf(true);
        mVersionCode = i;
        zzaJo = streetviewpanoramacamera;
        zzaJq = latlng;
        zzaJr = integer;
        zzaJp = s;
        zzaJs = zza.zza(byte0);
        zzaIH = zza.zza(byte1);
        zzaJt = zza.zza(byte2);
        zzaJu = zza.zza(byte3);
        zzaIB = zza.zza(byte4);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final Boolean getPanningGesturesEnabled()
    {
        return zzaJt;
    }

    public final String getPanoramaId()
    {
        return zzaJp;
    }

    public final LatLng getPosition()
    {
        return zzaJq;
    }

    public final Integer getRadius()
    {
        return zzaJr;
    }

    public final Boolean getStreetNamesEnabled()
    {
        return zzaJu;
    }

    public final StreetViewPanoramaCamera getStreetViewPanoramaCamera()
    {
        return zzaJo;
    }

    public final Boolean getUseViewLifecycleInFragment()
    {
        return zzaIB;
    }

    public final Boolean getUserNavigationEnabled()
    {
        return zzaJs;
    }

    final int getVersionCode()
    {
        return mVersionCode;
    }

    public final Boolean getZoomGesturesEnabled()
    {
        return zzaIH;
    }

    public final StreetViewPanoramaOptions panningGesturesEnabled(boolean flag)
    {
        zzaJt = Boolean.valueOf(flag);
        return this;
    }

    public final StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetviewpanoramacamera)
    {
        zzaJo = streetviewpanoramacamera;
        return this;
    }

    public final StreetViewPanoramaOptions panoramaId(String s)
    {
        zzaJp = s;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latlng)
    {
        zzaJq = latlng;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latlng, Integer integer)
    {
        zzaJq = latlng;
        zzaJr = integer;
        return this;
    }

    public final StreetViewPanoramaOptions streetNamesEnabled(boolean flag)
    {
        zzaJu = Boolean.valueOf(flag);
        return this;
    }

    public final StreetViewPanoramaOptions useViewLifecycleInFragment(boolean flag)
    {
        zzaIB = Boolean.valueOf(flag);
        return this;
    }

    public final StreetViewPanoramaOptions userNavigationEnabled(boolean flag)
    {
        zzaJs = Boolean.valueOf(flag);
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.maps.zzb.zza(this, parcel, i);
    }

    public final StreetViewPanoramaOptions zoomGesturesEnabled(boolean flag)
    {
        zzaIH = Boolean.valueOf(flag);
        return this;
    }

    final byte zzxA()
    {
        return zza.zze(zzaIB);
    }

    final byte zzxE()
    {
        return zza.zze(zzaIH);
    }

    final byte zzxP()
    {
        return zza.zze(zzaJs);
    }

    final byte zzxQ()
    {
        return zza.zze(zzaJt);
    }

    final byte zzxR()
    {
        return zza.zze(zzaJu);
    }

}
