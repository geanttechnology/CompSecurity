// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.text.NumberFormat;

public class ItemWeight
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ItemWeight createFromParcel(Parcel parcel)
        {
            return new ItemWeight(parcel.readString(), parcel.readFloat());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ItemWeight[] newArray(int i)
        {
            return new ItemWeight[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String units;
    public float value;

    public ItemWeight()
    {
    }

    public ItemWeight(String s, float f)
    {
        units = s;
        value = f;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        Object obj = NumberFormat.getInstance();
        ((NumberFormat) (obj)).setMinimumFractionDigits(2);
        ((NumberFormat) (obj)).setMaximumFractionDigits(2);
        try
        {
            obj = ((NumberFormat) (obj)).format(value);
        }
        catch (NumberFormatException numberformatexception)
        {
            numberformatexception = (new StringBuilder()).append("").append(value).toString();
        }
        return (new StringBuilder()).append(((String) (obj))).append(" ").append(units).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(units);
        parcel.writeFloat(value);
    }

}
