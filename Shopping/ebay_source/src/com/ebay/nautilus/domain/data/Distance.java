// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Distance
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Distance createFromParcel(Parcel parcel)
        {
            return new Distance(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Distance[] newArray(int i)
        {
            return new Distance[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public double length;
    public String unit;

    public Distance()
    {
    }

    public Distance(Parcel parcel)
    {
        length = parcel.readDouble();
        unit = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeDouble(length);
        parcel.writeString(unit);
    }

}
