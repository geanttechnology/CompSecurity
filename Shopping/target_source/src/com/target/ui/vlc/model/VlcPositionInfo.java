// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.vlc.model;

import android.os.Parcel;
import android.os.Parcelable;

public class VlcPositionInfo
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VlcPositionInfo a(Parcel parcel)
        {
            return new VlcPositionInfo(parcel);
        }

        public VlcPositionInfo[] a(int i)
        {
            return new VlcPositionInfo[i];
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
    private float mAccuracy;
    private float mAngleDegrees;
    private String mFloorSpaceId;
    private Long mTimeStamp;
    private float mX;
    private float mY;
    private float mZ;

    public VlcPositionInfo(float f1, float f2, float f3, float f4, float f5, long l, 
            String s)
    {
        mX = f1;
        mY = f2;
        mZ = f3;
        mAngleDegrees = f4;
        mAccuracy = f5;
        mTimeStamp = Long.valueOf(l);
        mFloorSpaceId = s;
    }

    protected VlcPositionInfo(Parcel parcel)
    {
        mX = parcel.readFloat();
        mY = parcel.readFloat();
        mZ = parcel.readFloat();
        mAngleDegrees = parcel.readFloat();
        mAccuracy = parcel.readFloat();
        mTimeStamp = (Long)parcel.readValue(java/lang/Long.getClassLoader());
        mFloorSpaceId = parcel.readString();
    }

    public float a()
    {
        return mX;
    }

    public float b()
    {
        return mY;
    }

    public float c()
    {
        return mZ;
    }

    public float d()
    {
        return mAngleDegrees;
    }

    public int describeContents()
    {
        return 0;
    }

    public float e()
    {
        return mAccuracy;
    }

    public Long f()
    {
        return mTimeStamp;
    }

    public String g()
    {
        return mFloorSpaceId;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeFloat(mX);
        parcel.writeFloat(mY);
        parcel.writeFloat(mZ);
        parcel.writeFloat(mAngleDegrees);
        parcel.writeFloat(mAccuracy);
        parcel.writeValue(mTimeStamp);
        parcel.writeValue(mFloorSpaceId);
    }

}
