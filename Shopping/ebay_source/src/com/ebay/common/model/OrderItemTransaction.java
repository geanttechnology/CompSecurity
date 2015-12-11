// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.ebay.common.model:
//            ItemTransaction

public class OrderItemTransaction extends ItemTransaction
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public OrderItemTransaction createFromParcel(Parcel parcel)
        {
            return new OrderItemTransaction(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public OrderItemTransaction[] newArray(int i)
        {
            return new OrderItemTransaction[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String itemId;
    public String site;
    public String sku;
    public String title;

    public OrderItemTransaction()
    {
    }

    OrderItemTransaction(Parcel parcel)
    {
        ItemTransaction.CREATOR.createFromParcel(parcel);
        itemId = parcel.readString();
        site = parcel.readString();
        title = parcel.readString();
        sku = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeString(itemId);
        parcel.writeString(site);
        parcel.writeString(title);
        parcel.writeString(sku);
    }

}
