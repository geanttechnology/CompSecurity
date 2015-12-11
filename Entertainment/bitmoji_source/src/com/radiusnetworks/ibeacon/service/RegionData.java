// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.radiusnetworks.ibeacon.Region;

public class RegionData extends Region
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RegionData createFromParcel(Parcel parcel)
        {
            return new RegionData(parcel);
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

    };

    private RegionData(Parcel parcel)
    {
        major = Integer.valueOf(parcel.readInt());
        if (major.intValue() == -1)
        {
            major = null;
        }
        minor = Integer.valueOf(parcel.readInt());
        if (minor.intValue() == -1)
        {
            minor = null;
        }
        proximityUuid = parcel.readString();
        uniqueId = parcel.readString();
    }


    public RegionData(Region region)
    {
        super(region);
    }

    public RegionData(String s, String s1, Integer integer, Integer integer1)
    {
        super(s, s1, integer, integer1);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte byte0 = -1;
        if (major == null)
        {
            i = -1;
        } else
        {
            i = major.intValue();
        }
        parcel.writeInt(i);
        if (minor == null)
        {
            i = byte0;
        } else
        {
            i = minor.intValue();
        }
        parcel.writeInt(i);
        parcel.writeString(proximityUuid);
        parcel.writeString(uniqueId);
    }

}
