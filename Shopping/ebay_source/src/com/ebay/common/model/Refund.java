// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.ItemCurrency;
import java.util.Date;

public class Refund
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Refund createFromParcel(Parcel parcel)
        {
            return new Refund(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Refund[] newArray(int i)
        {
            return new Refund[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public ItemCurrency refundAmount;
    public Date refundTime;
    public String refundTo;
    public String status;
    public String type;

    public Refund()
    {
    }

    Refund(Parcel parcel)
    {
        status = parcel.readString();
        type = parcel.readString();
        refundTo = parcel.readString();
        if (parcel.readInt() == 1)
        {
            refundTime = new Date(parcel.readLong());
        }
        if (parcel.readInt() == 1)
        {
            refundAmount = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(status);
        parcel.writeString(type);
        parcel.writeString(refundTo);
        int j;
        if (refundTime != null)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (refundTime != null)
        {
            parcel.writeLong(refundTime.getTime());
        }
        if (refundAmount != null)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (refundAmount != null)
        {
            refundAmount.writeToParcel(parcel, i);
        }
    }

}
