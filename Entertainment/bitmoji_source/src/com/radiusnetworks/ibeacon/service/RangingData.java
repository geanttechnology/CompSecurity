// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.radiusnetworks.ibeacon.IBeaconManager;
import com.radiusnetworks.ibeacon.Region;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.radiusnetworks.ibeacon.service:
//            IBeaconData, RegionData

public class RangingData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RangingData createFromParcel(Parcel parcel)
        {
            return new RangingData(parcel);
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

    };
    private static final String TAG = "RangingData";
    private Collection iBeaconDatas;
    private RegionData regionData;

    private RangingData(Parcel parcel)
    {
        if (IBeaconManager.debug)
        {
            Log.d("RangingData", "parsing RangingData");
        }
        Parcelable aparcelable[] = parcel.readParcelableArray(getClass().getClassLoader());
        iBeaconDatas = new ArrayList(aparcelable.length);
        for (int i = 0; i < aparcelable.length; i++)
        {
            iBeaconDatas.add((IBeaconData)aparcelable[i]);
        }

        regionData = (RegionData)parcel.readParcelable(getClass().getClassLoader());
    }


    public RangingData(Collection collection, Region region)
    {
        collection;
        JVM INSTR monitorenter ;
        iBeaconDatas = IBeaconData.fromIBeacons(collection);
        collection;
        JVM INSTR monitorexit ;
        regionData = new RegionData(region);
        return;
        region;
        collection;
        JVM INSTR monitorexit ;
        throw region;
    }

    public RangingData(Collection collection, RegionData regiondata)
    {
        iBeaconDatas = collection;
        regionData = regiondata;
    }

    public int describeContents()
    {
        return 0;
    }

    public Collection getIBeacons()
    {
        return iBeaconDatas;
    }

    public RegionData getRegion()
    {
        return regionData;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (IBeaconManager.debug)
        {
            Log.d("RangingData", "writing RangingData");
        }
        parcel.writeParcelableArray((Parcelable[])iBeaconDatas.toArray(new Parcelable[0]), i);
        parcel.writeParcelable(regionData, i);
        if (IBeaconManager.debug)
        {
            Log.d("RangingData", "done writing RangingData");
        }
    }

}
