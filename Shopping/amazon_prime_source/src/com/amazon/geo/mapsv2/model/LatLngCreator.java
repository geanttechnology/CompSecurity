// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            LatLng

public class LatLngCreator
    implements android.os.Parcelable.Creator
{

    public LatLngCreator()
    {
    }

    static void write(LatLng latlng, Parcel parcel, int i)
    {
        parcel.writeDouble(latlng.latitude);
        parcel.writeDouble(latlng.longitude);
    }

    public LatLng createFromParcel(Parcel parcel)
    {
        return new LatLng(parcel.readDouble(), parcel.readDouble());
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public LatLng[] newArray(int i)
    {
        return new LatLng[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }
}
