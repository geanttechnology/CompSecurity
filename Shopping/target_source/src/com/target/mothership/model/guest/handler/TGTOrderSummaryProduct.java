// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.target.mothership.model.guest.interfaces.OrderSummaryProduct;
import com.target.mothership.model.product.handler.TGTProduct;
import com.target.mothership.util.p;

public class TGTOrderSummaryProduct extends TGTProduct
    implements OrderSummaryProduct
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTOrderSummaryProduct a(Parcel parcel)
        {
            return new TGTOrderSummaryProduct(parcel);
        }

        public TGTOrderSummaryProduct[] a(int j)
        {
            return new TGTOrderSummaryProduct[j];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int j)
        {
            return a(j);
        }

    };
    private String mOrderItemId;
    private String mOrderItemStatus;
    private int mQuantity;

    TGTOrderSummaryProduct()
    {
    }

    public TGTOrderSummaryProduct(Parcel parcel)
    {
        super(parcel);
        mOrderItemStatus = parcel.readString();
        mQuantity = parcel.readInt();
        mOrderItemId = parcel.readString();
    }

    public String a(int j)
    {
        return p.a(this, j);
    }

    public void a(String s)
    {
        mOrderItemStatus = s;
    }

    public void b(int j)
    {
        mQuantity = j;
    }

    public void b(String s)
    {
        mOrderItemId = s;
    }

    public String c()
    {
        return mOrderItemStatus;
    }

    public int describeContents()
    {
        return 0;
    }

    public int i()
    {
        return mQuantity;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        super.writeToParcel(parcel, j);
        parcel.writeString(mOrderItemStatus);
        parcel.writeInt(mQuantity);
        parcel.writeString(mOrderItemId);
    }

}
