// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.OrderCompletionShipmentDetails;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.common.PickUpPersonDetails;
import java.util.ArrayList;
import java.util.List;

public class TGTOrderCompletionShipmentDetails
    implements OrderCompletionShipmentDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTOrderCompletionShipmentDetails a(Parcel parcel)
        {
            return new TGTOrderCompletionShipmentDetails(parcel);
        }

        public TGTOrderCompletionShipmentDetails[] a(int i)
        {
            return new TGTOrderCompletionShipmentDetails[i];
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
    private PickUpPersonDetails mPickUpPersonDetails;
    private List mProducts;
    private GuestAddress mShippingAddress;

    TGTOrderCompletionShipmentDetails()
    {
    }

    private TGTOrderCompletionShipmentDetails(Parcel parcel)
    {
        mProducts = new ArrayList();
        parcel.readList(mProducts, com/target/mothership/model/cart/handler/TGTOrderCompletionShipmentDetails.getClassLoader());
        mShippingAddress = (GuestAddress)parcel.readParcelable(com/target/mothership/model/common/GuestAddress.getClassLoader());
        mPickUpPersonDetails = (PickUpPersonDetails)parcel.readParcelable(com/target/mothership/model/common/PickUpPersonDetails.getClassLoader());
    }


    public List a()
    {
        return mProducts;
    }

    public void a(GuestAddress guestaddress)
    {
        mShippingAddress = guestaddress;
    }

    public void a(PickUpPersonDetails pickuppersondetails)
    {
        mPickUpPersonDetails = pickuppersondetails;
    }

    public void a(List list)
    {
        mProducts = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(mProducts);
        parcel.writeParcelable(mShippingAddress, i);
        parcel.writeParcelable(mPickUpPersonDetails, 0);
    }

}
