// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.target.mothership.model.guest.interfaces.EmailDeliveryShipmentDetails;
import com.target.mothership.model.guest.interfaces.OrderDetailsProduct;
import java.util.ArrayList;
import java.util.List;

public class TGTEmailDeliveryShipmentDetails
    implements EmailDeliveryShipmentDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTEmailDeliveryShipmentDetails a(Parcel parcel)
        {
            return new TGTEmailDeliveryShipmentDetails(parcel);
        }

        public TGTEmailDeliveryShipmentDetails[] a(int i)
        {
            return new TGTEmailDeliveryShipmentDetails[i];
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
    private String mRecipientEmail;
    private String mRecipientName;

    TGTEmailDeliveryShipmentDetails()
    {
    }

    private TGTEmailDeliveryShipmentDetails(Parcel parcel)
    {
        mProductList = new ArrayList();
        parcel.readList(mProductList, com/target/mothership/model/guest/interfaces/OrderDetailsProduct.getClassLoader());
        mRecipientName = parcel.readString();
        mRecipientEmail = parcel.readString();
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
        return mRecipientEmail;
    }

    public void b(String s)
    {
        mRecipientEmail = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(mProductList);
        parcel.writeString(mRecipientName);
        parcel.writeString(mRecipientEmail);
    }

}
