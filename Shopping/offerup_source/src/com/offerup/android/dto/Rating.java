// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Rating
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private float average;
    private int count;

    public Rating()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public float getAverage()
    {
        return average;
    }

    public int getCount()
    {
        return count;
    }

    public void setAverage(float f)
    {
        average = f;
    }

    public void setCount(int i)
    {
        count = i;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(count);
        parcel.writeFloat(average);
    }



/*
    static int access$002(Rating rating, int i)
    {
        rating.count = i;
        return i;
    }

*/


/*
    static float access$102(Rating rating, float f)
    {
        rating.average = f;
        return f;
    }

*/

    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final Rating createFromParcel(Parcel parcel)
        {
            Rating rating = new Rating();
            rating.count = parcel.readInt();
            rating.average = parcel.readFloat();
            return rating;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final Rating[] newArray(int i)
        {
            return new Rating[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
