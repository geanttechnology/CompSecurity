// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            CircleOptions

public class CircleOptionsCreator
    implements android.os.Parcelable.Creator
{

    public CircleOptionsCreator()
    {
    }

    public CircleOptions createFromParcel(Parcel parcel)
    {
        return new CircleOptions(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public CircleOptions[] newArray(int i)
    {
        return new CircleOptions[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }
}
