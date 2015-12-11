// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.CartUsableShippingInfo;
import java.util.ArrayList;
import java.util.List;

public class TGTCartUsableShippingInfo
    implements CartUsableShippingInfo
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCartUsableShippingInfo a(Parcel parcel)
        {
            return new TGTCartUsableShippingInfo(parcel);
        }

        public TGTCartUsableShippingInfo[] a(int i)
        {
            return new TGTCartUsableShippingInfo[i];
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
    private List mCartItems;
    private String mCustomerOrderNumber;
    private boolean mIsMultiShipping;
    private String mOrderId;
    private List mUsableShipAddresses;

    TGTCartUsableShippingInfo()
    {
    }

    private TGTCartUsableShippingInfo(Parcel parcel)
    {
        mOrderId = parcel.readString();
        mCustomerOrderNumber = parcel.readString();
        mCartItems = new ArrayList();
        parcel.readList(mCartItems, com/target/mothership/model/cart/handler/TGTCartUsableShippingInfo.getClassLoader());
        mUsableShipAddresses = new ArrayList();
        parcel.readList(mUsableShipAddresses, com/target/mothership/model/cart/handler/TGTCartUsableShippingInfo.getClassLoader());
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsMultiShipping = flag;
    }


    public List a()
    {
        return mUsableShipAddresses;
    }

    public void a(String s)
    {
        mOrderId = s;
    }

    public void a(List list)
    {
        mCartItems = list;
    }

    public void a(boolean flag)
    {
        mIsMultiShipping = flag;
    }

    public void b(String s)
    {
        mCustomerOrderNumber = s;
    }

    public void b(List list)
    {
        mUsableShipAddresses = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mOrderId);
        parcel.writeString(mCustomerOrderNumber);
        parcel.writeList(mCartItems);
        parcel.writeList(mUsableShipAddresses);
        byte byte0;
        if (mIsMultiShipping)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
    }

}
