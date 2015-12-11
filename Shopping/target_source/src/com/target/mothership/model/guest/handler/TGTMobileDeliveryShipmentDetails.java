// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.target.mothership.model.guest.interfaces.MobileDeliveryShipmentDetails;
import com.target.mothership.model.guest.interfaces.OrderDetailsProduct;
import java.util.ArrayList;
import java.util.List;

public class TGTMobileDeliveryShipmentDetails
    implements MobileDeliveryShipmentDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTMobileDeliveryShipmentDetails a(Parcel parcel)
        {
            return new TGTMobileDeliveryShipmentDetails(parcel);
        }

        public TGTMobileDeliveryShipmentDetails[] a(int i)
        {
            return new TGTMobileDeliveryShipmentDetails[i];
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
    private String mRecipientName;
    private String mRecipientPhone;

    TGTMobileDeliveryShipmentDetails()
    {
    }

    private TGTMobileDeliveryShipmentDetails(Parcel parcel)
    {
        mProductList = new ArrayList();
        parcel.readList(mProductList, com/target/mothership/model/guest/interfaces/OrderDetailsProduct.getClassLoader());
        mRecipientName = parcel.readString();
        mRecipientPhone = parcel.readString();
    }


    public List a()
    {
        return mProductList;
    }

    public void a(String s)
    {
        mRecipientName = s;
    }

    public void a(List list)
    {
        mProductList = list;
    }

    public String b()
    {
        return mRecipientPhone;
    }

    public void b(String s)
    {
        mRecipientPhone = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(mProductList);
        parcel.writeString(mRecipientName);
        parcel.writeString(mRecipientPhone);
    }

}
