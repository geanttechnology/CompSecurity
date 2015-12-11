// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.guest.interfaces.OrderDetailsProduct;
import com.target.mothership.model.guest.interfaces.ShipHomeShipmentDetails;
import java.util.ArrayList;
import java.util.List;

public class TGTShipHomeShipmentDetails
    implements ShipHomeShipmentDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTShipHomeShipmentDetails a(Parcel parcel)
        {
            return new TGTShipHomeShipmentDetails(parcel);
        }

        public TGTShipHomeShipmentDetails[] a(int i)
        {
            return new TGTShipHomeShipmentDetails[i];
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
    private List mProductList;
    private GuestAddress mShippingAddress;

    TGTShipHomeShipmentDetails()
    {
    }

    private TGTShipHomeShipmentDetails(Parcel parcel)
    {
        mProductList = new ArrayList();
        parcel.readList(mProductList, com/target/mothership/model/guest/interfaces/OrderDetailsProduct.getClassLoader());
        mShippingAddress = (GuestAddress)parcel.readParcelable(com/target/mothership/model/common/GuestAddress.getClassLoader());
    }


    public List a()
    {
        return mProductList;
    }

    public void a(GuestAddress guestaddress)
    {
        mShippingAddress = guestaddress;
    }

    public void a(List list)
    {
        mProductList = list;
    }

    public GuestAddress b()
    {
        return mShippingAddress;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(mProductList);
        parcel.writeParcelable(mShippingAddress, i);
    }

}
