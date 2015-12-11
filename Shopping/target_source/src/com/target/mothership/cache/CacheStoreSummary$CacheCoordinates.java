// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.common.Coordinates;

// Referenced classes of package com.target.mothership.cache:
//            CacheStoreSummary

private static class <init>
    implements Parcelable, Coordinates
{

    public static final android.os.CacheCoordinates.mLon CREATOR = new android.os.Parcelable.Creator() {

        public CacheStoreSummary.CacheCoordinates createFromParcel(Parcel parcel)
        {
            return new CacheStoreSummary.CacheCoordinates(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CacheStoreSummary.CacheCoordinates[] newArray(int i)
        {
            return new CacheStoreSummary.CacheCoordinates[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private double mLat;
    private double mLon;

    public int describeContents()
    {
        return 0;
    }

    public double getLatitude()
    {
        return mLat;
    }

    public double getLongitude()
    {
        return mLon;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeDouble(mLat);
        parcel.writeDouble(mLon);
    }


    _cls1(double d, double d1)
    {
        mLat = d;
        mLon = d1;
    }

    private mLon(Parcel parcel)
    {
        mLat = parcel.readDouble();
        mLon = parcel.readDouble();
    }

    mLon(Parcel parcel, mLon mlon)
    {
        this(parcel);
    }
}
