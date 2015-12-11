// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.billingrecord;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.models.support.ParcelableCreator;
import java.util.HashMap;

public class OrderBillingRecord
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ParcelableCreator(com/groupon/models/billingrecord/OrderBillingRecord);
    public String billingRecordId;
    public String cardType;
    public String city;
    public String firstName;
    public HashMap formParameters;
    public String formUrl;
    public String id;
    public String lastName;
    public String paymentType;
    public String termUrl;

    public OrderBillingRecord()
    {
    }

    public OrderBillingRecord(Parcel parcel)
    {
        id = parcel.readString();
        city = parcel.readString();
        cardType = parcel.readString();
        firstName = parcel.readString();
        lastName = parcel.readString();
        paymentType = parcel.readString();
        billingRecordId = parcel.readString();
        termUrl = parcel.readString();
        formUrl = parcel.readString();
        formParameters = (HashMap)parcel.readSerializable();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(city);
        parcel.writeString(cardType);
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(paymentType);
        parcel.writeString(billingRecordId);
        parcel.writeString(termUrl);
        parcel.writeString(formUrl);
        parcel.writeSerializable(formParameters);
    }

}
