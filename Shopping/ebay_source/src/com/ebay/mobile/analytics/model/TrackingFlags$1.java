// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics.model;

import android.os.Parcel;

// Referenced classes of package com.ebay.mobile.analytics.model:
//            TrackingFlags

static final class 
    implements android.os.or
{

    public TrackingFlags createFromParcel(Parcel parcel)
    {
        return new TrackingFlags(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public TrackingFlags[] newArray(int i)
    {
        return new TrackingFlags[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
