// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.common.Coordinates;

class TGTCoordinates
    implements Parcelable, Coordinates
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCoordinates a(Parcel parcel)
        {
            return new TGTCoordinates(parcel);
        }

        public TGTCoordinates[] a(int i)
        {
            return new TGTCoordinates[i];
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
    private double mLatitude;
    private double mLongitude;

    private TGTCoordinates(Parcel parcel)
    {
        mLongitude = parcel.readDouble();
        mLatitude = parcel.readDouble();
    }


    public int describeContents()
    {
        return 0;
    }

    public double getLatitude()
    {
        return mLatitude;
    }

    public double getLongitude()
    {
        return mLongitude;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeDouble(mLongitude);
        parcel.writeDouble(mLatitude);
    }

}
