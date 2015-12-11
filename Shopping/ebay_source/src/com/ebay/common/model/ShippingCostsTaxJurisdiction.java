// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ShippingCostsTaxJurisdiction
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShippingCostsTaxJurisdiction createFromParcel(Parcel parcel)
        {
            return new ShippingCostsTaxJurisdiction(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShippingCostsTaxJurisdiction[] newArray(int i)
        {
            return new ShippingCostsTaxJurisdiction[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String jurisdictionId;
    public float salesTaxPercent;
    public boolean shippingIncludedInTax;

    public ShippingCostsTaxJurisdiction()
    {
    }

    private ShippingCostsTaxJurisdiction(Parcel parcel)
    {
        boolean flag = true;
        super();
        jurisdictionId = parcel.readString();
        salesTaxPercent = parcel.readFloat();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        shippingIncludedInTax = flag;
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(jurisdictionId);
        parcel.writeFloat(salesTaxPercent);
        if (shippingIncludedInTax)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }

}
