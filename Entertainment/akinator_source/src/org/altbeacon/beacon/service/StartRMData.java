// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.os.Parcel;
import android.os.Parcelable;
import org.altbeacon.beacon.Region;

public class StartRMData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private boolean backgroundFlag;
    private long betweenScanPeriod;
    private String callbackPackageName;
    private Region region;
    private long scanPeriod;

    public StartRMData(long l, long l1, boolean flag)
    {
        scanPeriod = l;
        betweenScanPeriod = l1;
        backgroundFlag = flag;
    }

    private StartRMData(Parcel parcel)
    {
        region = (Region)parcel.readParcelable(org/altbeacon/beacon/service/StartRMData.getClassLoader());
        callbackPackageName = parcel.readString();
        scanPeriod = parcel.readLong();
        betweenScanPeriod = parcel.readLong();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        backgroundFlag = flag;
    }

    StartRMData(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public StartRMData(Region region1, String s)
    {
        region = region1;
        callbackPackageName = s;
    }

    public StartRMData(Region region1, String s, long l, long l1, boolean flag)
    {
        scanPeriod = l;
        betweenScanPeriod = l1;
        region = region1;
        callbackPackageName = s;
        backgroundFlag = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean getBackgroundFlag()
    {
        return backgroundFlag;
    }

    public long getBetweenScanPeriod()
    {
        return betweenScanPeriod;
    }

    public String getCallbackPackageName()
    {
        return callbackPackageName;
    }

    public Region getRegionData()
    {
        return region;
    }

    public long getScanPeriod()
    {
        return scanPeriod;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(region, i);
        parcel.writeString(callbackPackageName);
        parcel.writeLong(scanPeriod);
        parcel.writeLong(betweenScanPeriod);
        if (backgroundFlag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }


    /* member class not found */
    class _cls1 {}

}
