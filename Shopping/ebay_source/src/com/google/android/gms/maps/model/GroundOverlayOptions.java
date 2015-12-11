// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzc, BitmapDescriptor, LatLng, LatLngBounds

public final class GroundOverlayOptions
    implements SafeParcelable
{

    public static final zzc CREATOR = new zzc();
    private final int zzCY;
    private float zzaCT;
    private float zzaDa;
    private boolean zzaDb;
    private BitmapDescriptor zzaDd;
    private LatLng zzaDe;
    private float zzaDf;
    private float zzaDg;
    private LatLngBounds zzaDh;
    private float zzaDi;
    private float zzaDj;
    private float zzaDk;

    public GroundOverlayOptions()
    {
        zzaDb = true;
        zzaDi = 0.0F;
        zzaDj = 0.5F;
        zzaDk = 0.5F;
        zzCY = 1;
    }

    GroundOverlayOptions(int i, IBinder ibinder, LatLng latlng, float f, float f1, LatLngBounds latlngbounds, float f2, 
            float f3, boolean flag, float f4, float f5, float f6)
    {
        zzaDb = true;
        zzaDi = 0.0F;
        zzaDj = 0.5F;
        zzaDk = 0.5F;
        zzCY = i;
        zzaDd = new BitmapDescriptor(com.google.android.gms.dynamic.zzd.zza.zzbg(ibinder));
        zzaDe = latlng;
        zzaDf = f;
        zzaDg = f1;
        zzaDh = latlngbounds;
        zzaCT = f2;
        zzaDa = f3;
        zzaDb = flag;
        zzaDi = f4;
        zzaDj = f5;
        zzaDk = f6;
    }

    public int describeContents()
    {
        return 0;
    }

    public float getAnchorU()
    {
        return zzaDj;
    }

    public float getAnchorV()
    {
        return zzaDk;
    }

    public float getBearing()
    {
        return zzaCT;
    }

    public LatLngBounds getBounds()
    {
        return zzaDh;
    }

    public float getHeight()
    {
        return zzaDg;
    }

    public LatLng getLocation()
    {
        return zzaDe;
    }

    public float getTransparency()
    {
        return zzaDi;
    }

    int getVersionCode()
    {
        return zzCY;
    }

    public float getWidth()
    {
        return zzaDf;
    }

    public float getZIndex()
    {
        return zzaDa;
    }

    public boolean isVisible()
    {
        return zzaDb;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

    IBinder zzvI()
    {
        return zzaDd.zzvg().asBinder();
    }

}
