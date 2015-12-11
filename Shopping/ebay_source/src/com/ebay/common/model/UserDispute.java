// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

public class UserDispute
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public UserDispute createFromParcel(Parcel parcel)
        {
            return new UserDispute(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public UserDispute[] newArray(int i)
        {
            return new UserDispute[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public Date createdTime;
    public String creditEligibility;
    public String explanation;
    public String id;
    public String itemId;
    public String orderLineItemId;
    public String reason;
    public String state;
    public String status;
    public String transactionId;

    public UserDispute()
    {
    }

    private UserDispute(Parcel parcel)
    {
        if (1 == parcel.readInt())
        {
            createdTime = new Date(parcel.readLong());
        }
        creditEligibility = parcel.readString();
        explanation = parcel.readString();
        id = parcel.readString();
        reason = parcel.readString();
        state = parcel.readString();
        status = parcel.readString();
        itemId = parcel.readString();
        orderLineItemId = parcel.readString();
        transactionId = parcel.readString();
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (createdTime != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (createdTime != null)
        {
            parcel.writeLong(createdTime.getTime());
        }
        parcel.writeString(creditEligibility);
        parcel.writeString(explanation);
        parcel.writeString(id);
        parcel.writeString(reason);
        parcel.writeString(state);
        parcel.writeString(status);
        parcel.writeString(itemId);
        parcel.writeString(orderLineItemId);
        parcel.writeString(transactionId);
    }

}
