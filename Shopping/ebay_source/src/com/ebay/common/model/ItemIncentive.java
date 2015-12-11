// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.CurrencyAmount;

public class ItemIncentive
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ItemIncentive createFromParcel(Parcel parcel)
        {
            return new ItemIncentive(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ItemIncentive[] newArray(int i)
        {
            return new ItemIncentive[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public boolean includesBooster;
    public String itemID;
    public CurrencyAmount rewardAmount;
    public String transactionID;
    public String variationID;

    public ItemIncentive()
    {
    }

    private ItemIncentive(Parcel parcel)
    {
        itemID = parcel.readString();
        transactionID = parcel.readString();
        variationID = parcel.readString();
        rewardAmount = (CurrencyAmount)parcel.readParcelable(com/ebay/nautilus/domain/data/CurrencyAmount.getClassLoader());
        boolean flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        includesBooster = flag;
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        i = 0;
        parcel.writeString(itemID);
        parcel.writeString(transactionID);
        parcel.writeString(variationID);
        parcel.writeParcelable(rewardAmount, 0);
        if (includesBooster)
        {
            i = 1;
        }
        parcel.writeInt(i);
    }

}
