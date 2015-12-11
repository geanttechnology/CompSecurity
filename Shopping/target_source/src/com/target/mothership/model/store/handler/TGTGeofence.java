// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.common.Coordinates;
import com.target.mothership.model.common.Geofence;

class TGTGeofence
    implements Parcelable, Geofence
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTGeofence a(Parcel parcel)
        {
            return new TGTGeofence(parcel);
        }

        public TGTGeofence[] a(int i)
        {
            return new TGTGeofence[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private Coordinates mCenter;
    private double mRadius;

    private TGTGeofence(Parcel parcel)
    {
        mCenter = (Coordinates)parcel.readParcelable(com/target/mothership/model/common/Coordinates.getClassLoader());
        mRadius = parcel.readDouble();
    }


    public int describeContents()
    {
        return 0;
    }

    public Coordinates getCenter()
    {
        return mCenter;
    }

    public double getRadius()
    {
        return mRadius;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mCenter, 0);
        parcel.writeDouble(mRadius);
    }

}
