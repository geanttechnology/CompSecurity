// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            StreetViewPanoramaOrientation

public class StreetViewPanoramaOrientationCreator
    implements android.os.Parcelable.Creator
{

    public StreetViewPanoramaOrientationCreator()
    {
    }

    public StreetViewPanoramaOrientation createFromParcel(Parcel parcel)
    {
        return new StreetViewPanoramaOrientation(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public StreetViewPanoramaOrientation[] newArray(int i)
    {
        return new StreetViewPanoramaOrientation[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }
}
