// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.radiusnetworks.ibeacon.Region;

// Referenced classes of package com.radiusnetworks.ibeacon.service:
//            RegionData

public class MonitoringData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public MonitoringData createFromParcel(Parcel parcel)
        {
            return new MonitoringData(parcel);
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

    };
    private static final String TAG = "MonitoringData";
    private boolean inside;
    private RegionData regionData;

    private MonitoringData(Parcel parcel)
    {
        boolean flag = true;
        super();
        if (parcel.readByte() != 1)
        {
            flag = false;
        }
        inside = flag;
        regionData = (RegionData)parcel.readParcelable(getClass().getClassLoader());
    }


    public MonitoringData(boolean flag, Region region)
    {
        inside = flag;
        regionData = new RegionData(region);
    }

    public int describeContents()
    {
        return 0;
    }

    public Region getRegion()
    {
        return regionData;
    }

    public boolean isInside()
    {
        return inside;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        int j;
        if (inside)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeByte((byte)j);
        parcel.writeParcelable(regionData, i);
    }

}
