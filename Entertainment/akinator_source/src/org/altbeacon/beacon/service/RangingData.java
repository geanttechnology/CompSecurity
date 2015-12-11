// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.logging.LogManager;

public class RangingData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private static final String TAG = "RangingData";
    private Collection beacons;
    private Region region;

    private RangingData(Parcel parcel)
    {
        LogManager.d("RangingData", "parsing RangingData", new Object[0]);
        Parcelable aparcelable[] = parcel.readParcelableArray(getClass().getClassLoader());
        beacons = new ArrayList(aparcelable.length);
        for (int i = 0; i < aparcelable.length; i++)
        {
            beacons.add((Beacon)aparcelable[i]);
        }

        region = (Region)parcel.readParcelable(getClass().getClassLoader());
    }

    RangingData(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public RangingData(Collection collection, Region region1)
    {
        collection;
        JVM INSTR monitorenter ;
        beacons = collection;
        collection;
        JVM INSTR monitorexit ;
        region = region1;
        return;
        region1;
        collection;
        JVM INSTR monitorexit ;
        throw region1;
    }

    public int describeContents()
    {
        return 0;
    }

    public Collection getBeacons()
    {
        return beacons;
    }

    public Region getRegion()
    {
        return region;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        LogManager.d("RangingData", "writing RangingData", new Object[0]);
        parcel.writeParcelableArray((Parcelable[])beacons.toArray(new Parcelable[0]), i);
        parcel.writeParcelable(region, i);
        LogManager.d("RangingData", "done writing RangingData", new Object[0]);
    }


    /* member class not found */
    class _cls1 {}

}
