// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics.model;

import android.os.Parcel;

// Referenced classes of package com.ebay.mobile.analytics.model:
//            TrackingData

static final class 
    implements android.os.tor
{

    public TrackingData createFromParcel(Parcel parcel)
    {
        return new TrackingData(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public TrackingData[] newArray(int i)
    {
        return new TrackingData[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
