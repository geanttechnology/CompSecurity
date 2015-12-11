// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            VisibleRegion, LatLng, LatLngBounds

public class VisibleRegionCreator
    implements android.os.Parcelable.Creator
{

    public VisibleRegionCreator()
    {
    }

    static void write(VisibleRegion visibleregion, Parcel parcel, int i)
    {
        parcel.writeParcelable(visibleregion.farLeft, i);
        parcel.writeParcelable(visibleregion.farRight, i);
        parcel.writeParcelable(visibleregion.nearLeft, i);
        parcel.writeParcelable(visibleregion.nearRight, i);
        parcel.writeParcelable(visibleregion.latLngBounds, i);
    }

    public VisibleRegion createFromParcel(Parcel parcel)
    {
        return new VisibleRegion((LatLng)parcel.readParcelable(com/amazon/geo/mapsv2/model/LatLng.getClassLoader()), (LatLng)parcel.readParcelable(com/amazon/geo/mapsv2/model/LatLng.getClassLoader()), (LatLng)parcel.readParcelable(com/amazon/geo/mapsv2/model/LatLng.getClassLoader()), (LatLng)parcel.readParcelable(com/amazon/geo/mapsv2/model/LatLng.getClassLoader()), (LatLngBounds)parcel.readParcelable(com/amazon/geo/mapsv2/model/LatLngBounds.getClassLoader()));
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public VisibleRegion[] newArray(int i)
    {
        return new VisibleRegion[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }
}
