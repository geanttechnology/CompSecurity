// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

public class OrderShippingInfo
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public OrderShippingInfo createFromParcel(Parcel parcel)
        {
            return new OrderShippingInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public OrderShippingInfo[] newArray(int i)
        {
            return new OrderShippingInfo[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public Date actualDeliveryDate;
    public Date estimatedMaxDeliveryDate;
    public Date estimatedMinDeliveryDate;
    public Date shippedDate;

    public OrderShippingInfo()
    {
        estimatedMinDeliveryDate = null;
        estimatedMaxDeliveryDate = null;
        shippedDate = null;
        actualDeliveryDate = null;
    }

    private OrderShippingInfo(Parcel parcel)
    {
        estimatedMinDeliveryDate = null;
        estimatedMaxDeliveryDate = null;
        shippedDate = null;
        actualDeliveryDate = null;
        if (parcel.readInt() == 1)
        {
            estimatedMinDeliveryDate = new Date(parcel.readLong());
        }
        if (parcel.readInt() == 1)
        {
            estimatedMaxDeliveryDate = new Date(parcel.readLong());
        }
        if (parcel.readInt() == 1)
        {
            shippedDate = new Date(parcel.readLong());
        }
        if (parcel.readInt() == 1)
        {
            actualDeliveryDate = new Date(parcel.readLong());
        }
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        if (estimatedMinDeliveryDate != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (estimatedMinDeliveryDate != null)
        {
            parcel.writeLong(estimatedMinDeliveryDate.getTime());
        }
        if (estimatedMaxDeliveryDate != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (estimatedMaxDeliveryDate != null)
        {
            parcel.writeLong(estimatedMaxDeliveryDate.getTime());
        }
        if (shippedDate != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (shippedDate != null)
        {
            parcel.writeLong(shippedDate.getTime());
        }
        if (actualDeliveryDate != null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (actualDeliveryDate != null)
        {
            parcel.writeLong(actualDeliveryDate.getTime());
        }
    }

}
