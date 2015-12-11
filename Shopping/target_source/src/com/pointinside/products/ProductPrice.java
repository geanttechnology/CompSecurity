// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.os.Parcel;
import android.os.Parcelable;
import com.pointinside.internal.utils.StringUtils;

public class ProductPrice
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ProductPrice createFromParcel(Parcel parcel)
        {
            String s = parcel.readString();
            return new ProductPrice(parcel.readDouble(), s);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ProductPrice[] newArray(int i)
        {
            return new ProductPrice[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final double amount;
    public final String currency;

    public ProductPrice(double d, String s)
    {
        amount = d;
        currency = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        StringUtils.appendIfNotNull(stringbuilder, " Amount", Double.valueOf(amount));
        StringUtils.appendIfNotNull(stringbuilder, " Currency", currency);
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(currency);
        parcel.writeDouble(amount);
    }

}
