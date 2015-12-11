// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            CameraPosition, LatLng

public class CameraPositionCreator
    implements android.os.Parcelable.Creator
{

    public CameraPositionCreator()
    {
    }

    static void write(CameraPosition cameraposition, Parcel parcel, int i)
    {
        parcel.writeFloat(cameraposition.bearing);
        parcel.writeParcelable(cameraposition.target, i);
        parcel.writeFloat(cameraposition.tilt);
        parcel.writeFloat(cameraposition.zoom);
    }

    public CameraPosition createFromParcel(Parcel parcel)
    {
        float f = parcel.readFloat();
        LatLng latlng = (LatLng)parcel.readParcelable(getClass().getClassLoader());
        float f1 = parcel.readFloat();
        return new CameraPosition(latlng, parcel.readFloat(), f1, f);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public CameraPosition[] newArray(int i)
    {
        return new CameraPosition[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }
}
