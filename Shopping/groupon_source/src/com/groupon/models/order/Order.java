// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.order;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.models.billingrecord.OrderBillingRecord;
import com.groupon.models.support.ParcelableCreator;

public class Order
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ParcelableCreator(com/groupon/models/order/Order);
    public static final String ORDER_ID = "orderId";
    public OrderBillingRecord billingRecord;
    public String id;
    public String supportId;

    public Order()
    {
        id = "";
    }

    public Order(Parcel parcel)
    {
        id = "";
        id = parcel.readString();
        supportId = parcel.readString();
        billingRecord = (OrderBillingRecord)parcel.readParcelable(com/groupon/models/billingrecord/OrderBillingRecord.getClassLoader());
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(supportId);
        parcel.writeParcelable(billingRecord, i);
    }

}
