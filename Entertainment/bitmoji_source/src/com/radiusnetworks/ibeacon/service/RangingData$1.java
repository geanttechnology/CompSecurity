// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.os.Parcel;

// Referenced classes of package com.radiusnetworks.ibeacon.service:
//            RangingData

static final class 
    implements android.os.ator
{

    public RangingData createFromParcel(Parcel parcel)
    {
        return new RangingData(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public RangingData[] newArray(int i)
    {
        return new RangingData[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
