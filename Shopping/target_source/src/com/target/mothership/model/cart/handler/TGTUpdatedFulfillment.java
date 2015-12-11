// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.UpdatedFulfillment;
import java.util.ArrayList;
import java.util.List;

class TGTUpdatedFulfillment
    implements UpdatedFulfillment
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTUpdatedFulfillment a(Parcel parcel)
        {
            return new TGTUpdatedFulfillment(parcel);
        }

        public TGTUpdatedFulfillment[] a(int i)
        {
            return new TGTUpdatedFulfillment[i];
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
    private List mUpdatedOrderItems;

    TGTUpdatedFulfillment()
    {
    }

    private TGTUpdatedFulfillment(Parcel parcel)
    {
        mUpdatedOrderItems = new ArrayList();
        parcel.readList(mUpdatedOrderItems, com/target/mothership/model/cart/handler/TGTUpdatedFulfillment.getClassLoader());
    }


    public void a(List list)
    {
        mUpdatedOrderItems = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(mUpdatedOrderItems);
    }

}
