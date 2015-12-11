// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            LatLngBounds, LatLng

public class LatLngBoundsCreator
    implements android.os.Parcelable.Creator
{

    public LatLngBoundsCreator()
    {
    }

    static void write(LatLngBounds latlngbounds, Parcel parcel, int i)
    {
        parcel.writeParcelable(latlngbounds.southwest, i);
        parcel.writeParcelable(latlngbounds.northeast, i);
    }

    public LatLngBounds createFromParcel(Parcel parcel)
    {
        return new LatLngBounds((LatLng)parcel.readParcelable(com/amazon/geo/mapsv2/model/LatLng.getClassLoader()), (LatLng)parcel.readParcelable(com/amazon/geo/mapsv2/model/LatLng.getClassLoader()));
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public LatLngBounds[] newArray(int i)
    {
        return new LatLngBounds[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }
}
