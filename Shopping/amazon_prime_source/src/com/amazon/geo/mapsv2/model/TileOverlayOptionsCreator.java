// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            TileOverlayOptions

public class TileOverlayOptionsCreator
    implements android.os.Parcelable.Creator
{

    public TileOverlayOptionsCreator()
    {
    }

    public TileOverlayOptions createFromParcel(Parcel parcel)
    {
        return new TileOverlayOptions(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public TileOverlayOptions[] newArray(int i)
    {
        return new TileOverlayOptions[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }
}
