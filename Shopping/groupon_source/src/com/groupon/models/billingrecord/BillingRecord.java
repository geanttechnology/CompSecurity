// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.billingrecord;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.models.support.ParcelableCreator;
import java.util.ArrayList;

public class BillingRecord
    implements Parcelable
{
    public static class List
    {

        public ArrayList billingRecords;

        public List()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new ParcelableCreator(com/groupon/models/billingrecord/BillingRecord);
    public String billingRecordId;
    public String cardNumber;
    public String cardType;
    public String city;
    public String country;
    public Integer expirationMonth;
    public Integer expirationYear;
    public String firstName;
    public String id;
    public Boolean isDefault;
    public String lastName;
    public String name;
    public String paymentType;
    public String postalCode;
    public Boolean requireCVV;
    public String state;
    public String streetAddress1;
    public String streetAddress2;
    public String uuid;

    public BillingRecord()
    {
    }

    public BillingRecord(Parcel parcel)
    {
        id = parcel.readString();
        uuid = parcel.readString();
        firstName = parcel.readString();
        lastName = parcel.readString();
        streetAddress1 = parcel.readString();
        streetAddress2 = parcel.readString();
        city = parcel.readString();
        state = parcel.readString();
        country = parcel.readString();
        postalCode = parcel.readString();
        paymentType = parcel.readString();
        cardType = parcel.readString();
        cardNumber = parcel.readString();
        expirationMonth = (Integer)parcel.readValue(null);
        expirationYear = (Integer)parcel.readValue(null);
        isDefault = (Boolean)parcel.readValue(null);
        billingRecordId = parcel.readString();
        name = parcel.readString();
        requireCVV = (Boolean)parcel.readValue(null);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(uuid);
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(streetAddress1);
        parcel.writeString(streetAddress2);
        parcel.writeString(city);
        parcel.writeString(state);
        parcel.writeString(country);
        parcel.writeString(postalCode);
        parcel.writeString(paymentType);
        parcel.writeString(cardType);
        parcel.writeString(cardNumber);
        parcel.writeValue(expirationMonth);
        parcel.writeValue(expirationYear);
        parcel.writeValue(isDefault);
        parcel.writeString(billingRecordId);
        parcel.writeString(name);
        parcel.writeValue(requireCVV);
    }

}
