// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.common.a.b;
import com.target.mothership.model.cart.interfaces.UpdatedFulfillmentOrderItem;

public class TGTUpdatedFulfillmentOrderItem
    implements UpdatedFulfillmentOrderItem
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTUpdatedFulfillmentOrderItem a(Parcel parcel)
        {
            return new TGTUpdatedFulfillmentOrderItem(parcel);
        }

        public TGTUpdatedFulfillmentOrderItem[] a(int i)
        {
            return new TGTUpdatedFulfillmentOrderItem[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private b mDeliveryMethod;
    private int mShipModeId;

    TGTUpdatedFulfillmentOrderItem()
    {
    }

    private TGTUpdatedFulfillmentOrderItem(Parcel parcel)
    {
        int i = parcel.readInt();
        b b1;
        if (i == -1)
        {
            b1 = null;
        } else
        {
            b1 = b.values()[i];
        }
        mDeliveryMethod = b1;
        mShipModeId = parcel.readInt();
    }


    public void a(int i)
    {
        mShipModeId = i;
    }

    public void a(b b1)
    {
        mDeliveryMethod = b1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mDeliveryMethod == null)
        {
            i = -1;
        } else
        {
            i = mDeliveryMethod.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeInt(mShipModeId);
    }

}
