// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.radiusnetworks.ibeacon.IBeacon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IBeaconData extends IBeacon
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public IBeaconData createFromParcel(Parcel parcel)
        {
            return new IBeaconData(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public IBeaconData[] newArray(int i)
        {
            return new IBeaconData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    private IBeaconData(Parcel parcel)
    {
        major = parcel.readInt();
        minor = parcel.readInt();
        proximityUuid = parcel.readString();
        proximity = Integer.valueOf(parcel.readInt());
        accuracy = Double.valueOf(parcel.readDouble());
        rssi = parcel.readInt();
        txPower = parcel.readInt();
        bluetoothAddress = parcel.readString();
    }


    public IBeaconData(IBeacon ibeacon)
    {
        super(ibeacon);
    }

    public static Collection fromIBeaconDatas(Collection collection)
    {
        ArrayList arraylist = new ArrayList();
        if (collection != null)
        {
            for (collection = collection.iterator(); collection.hasNext(); arraylist.add(collection.next())) { }
        }
        return arraylist;
    }

    public static Collection fromIBeacons(Collection collection)
    {
        ArrayList arraylist = new ArrayList();
        for (collection = collection.iterator(); collection.hasNext(); arraylist.add(new IBeaconData((IBeacon)collection.next()))) { }
        return arraylist;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(major);
        parcel.writeInt(minor);
        parcel.writeString(proximityUuid);
        parcel.writeInt(getProximity());
        parcel.writeDouble(getAccuracy());
        parcel.writeInt(rssi);
        parcel.writeInt(txPower);
        parcel.writeString(bluetoothAddress);
    }

}
