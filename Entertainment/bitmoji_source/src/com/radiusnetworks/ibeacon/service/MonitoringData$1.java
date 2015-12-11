// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.os.Parcel;

// Referenced classes of package com.radiusnetworks.ibeacon.service:
//            MonitoringData

static final class _cls9
    implements android.os.r
{

    public MonitoringData createFromParcel(Parcel parcel)
    {
        return new MonitoringData(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public MonitoringData[] newArray(int i)
    {
        return new MonitoringData[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    _cls9()
    {
    }
}
