// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.radiusnetworks.ibeacon.service:
//            RegionData

public class StartRMData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public StartRMData createFromParcel(Parcel parcel)
        {
            return new StartRMData(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public StartRMData[] newArray(int i)
        {
            return new StartRMData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private long betweenScanPeriod;
    private String callbackPackageName;
    private RegionData regionData;
    private long scanPeriod;

    public StartRMData(long l, long l1)
    {
        scanPeriod = l;
        betweenScanPeriod = l1;
    }

    private StartRMData(Parcel parcel)
    {
        regionData = (RegionData)parcel.readParcelable(getClass().getClassLoader());
        callbackPackageName = parcel.readString();
        scanPeriod = parcel.readLong();
        betweenScanPeriod = parcel.readLong();
    }


    public StartRMData(RegionData regiondata, String s)
    {
        regionData = regiondata;
        callbackPackageName = s;
    }

    public StartRMData(RegionData regiondata, String s, long l, long l1)
    {
        scanPeriod = l;
        betweenScanPeriod = l1;
        regionData = regiondata;
        callbackPackageName = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public long getBetweenScanPeriod()
    {
        return betweenScanPeriod;
    }

    public String getCallbackPackageName()
    {
        return callbackPackageName;
    }

    public RegionData getRegionData()
    {
        return regionData;
    }

    public long getScanPeriod()
    {
        return scanPeriod;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(regionData, i);
        parcel.writeString(callbackPackageName);
        parcel.writeLong(scanPeriod);
        parcel.writeLong(betweenScanPeriod);
    }

}
