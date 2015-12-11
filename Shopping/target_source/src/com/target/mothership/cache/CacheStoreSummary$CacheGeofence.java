// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.common.Coordinates;
import com.target.mothership.model.common.Geofence;

// Referenced classes of package com.target.mothership.cache:
//            CacheStoreSummary

private static class <init>
    implements Parcelable, Geofence
{

    public static final android.os.ry.CacheGeofence.mRadius CREATOR = new android.os.Parcelable.Creator() {

        public CacheStoreSummary.CacheGeofence createFromParcel(Parcel parcel)
        {
            return new CacheStoreSummary.CacheGeofence(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CacheStoreSummary.CacheGeofence[] newArray(int i)
        {
            return new CacheStoreSummary.CacheGeofence[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private es mCoordinates;
    private double mRadius;

    public int describeContents()
    {
        return 0;
    }

    public Coordinates getCenter()
    {
        return mCoordinates;
    }

    public double getRadius()
    {
        return mRadius;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mCoordinates, 0);
        parcel.writeDouble(mRadius);
    }


    _cls1(double d, double d1, double d2)
    {
        mCoordinates = new es(d, d1);
        mRadius = d2;
    }

    private mRadius(Parcel parcel)
    {
        mCoordinates = (es)parcel.readParcelable(com/target/mothership/cache/CacheStoreSummary$CacheCoordinates.getClassLoader());
        mRadius = parcel.readDouble();
    }

    mRadius(Parcel parcel, mRadius mradius)
    {
        this(parcel);
    }
}
