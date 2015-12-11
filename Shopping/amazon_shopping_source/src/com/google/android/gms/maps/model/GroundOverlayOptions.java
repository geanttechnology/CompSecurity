// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.internal.v;

// Referenced classes of package com.google.android.gms.maps.model:
//            GroundOverlayOptionsCreator, BitmapDescriptor, c, LatLng, 
//            LatLngBounds

public final class GroundOverlayOptions
    implements SafeParcelable
{

    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    private BitmapDescriptor aaA;
    private LatLng aaB;
    private float aaC;
    private float aaD;
    private LatLngBounds aaE;
    private float aaF;
    private float aaG;
    private float aaH;
    private float aaq;
    private float aax;
    private boolean aay;
    private final int xM;

    public GroundOverlayOptions()
    {
        aay = true;
        aaF = 0.0F;
        aaG = 0.5F;
        aaH = 0.5F;
        xM = 1;
    }

    GroundOverlayOptions(int i, IBinder ibinder, LatLng latlng, float f, float f1, LatLngBounds latlngbounds, float f2, 
            float f3, boolean flag, float f4, float f5, float f6)
    {
        aay = true;
        aaF = 0.0F;
        aaG = 0.5F;
        aaH = 0.5F;
        xM = i;
        aaA = new BitmapDescriptor(com.google.android.gms.dynamic.d.a.ag(ibinder));
        aaB = latlng;
        aaC = f;
        aaD = f1;
        aaE = latlngbounds;
        aaq = f2;
        aax = f3;
        aay = flag;
        aaF = f4;
        aaG = f5;
        aaH = f6;
    }

    public int describeContents()
    {
        return 0;
    }

    public float getAnchorU()
    {
        return aaG;
    }

    public float getAnchorV()
    {
        return aaH;
    }

    public float getBearing()
    {
        return aaq;
    }

    public LatLngBounds getBounds()
    {
        return aaE;
    }

    public float getHeight()
    {
        return aaD;
    }

    public LatLng getLocation()
    {
        return aaB;
    }

    public float getTransparency()
    {
        return aaF;
    }

    int getVersionCode()
    {
        return xM;
    }

    public float getWidth()
    {
        return aaC;
    }

    public float getZIndex()
    {
        return aax;
    }

    public boolean isVisible()
    {
        return aay;
    }

    IBinder jN()
    {
        return aaA.jn().asBinder();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (v.jL())
        {
            c.a(this, parcel, i);
            return;
        } else
        {
            GroundOverlayOptionsCreator.a(this, parcel, i);
            return;
        }
    }

}
