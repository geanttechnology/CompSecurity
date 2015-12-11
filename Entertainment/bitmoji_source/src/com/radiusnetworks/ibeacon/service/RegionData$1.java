// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.os.Parcel;

// Referenced classes of package com.radiusnetworks.ibeacon.service:
//            RegionData

static final class 
    implements android.os.eator
{

    public RegionData createFromParcel(Parcel parcel)
    {
        return new RegionData(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public RegionData[] newArray(int i)
    {
        return new RegionData[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
