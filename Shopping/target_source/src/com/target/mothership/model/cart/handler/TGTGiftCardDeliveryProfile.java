// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.GiftCardDeliveryProfile;

public class TGTGiftCardDeliveryProfile
    implements GiftCardDeliveryProfile
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTGiftCardDeliveryProfile a(Parcel parcel)
        {
            return new TGTGiftCardDeliveryProfile(parcel);
        }

        public TGTGiftCardDeliveryProfile[] a(int i)
        {
            return new TGTGiftCardDeliveryProfile[i];
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
    private String mGiftCardAddressId;
    private String mGiftCardFromName;
    private String mGiftCardToEmail;
    private String mGiftCardToName;
    private String mGiftCardToPhone;

    TGTGiftCardDeliveryProfile()
    {
    }

    private TGTGiftCardDeliveryProfile(Parcel parcel)
    {
        mGiftCardAddressId = parcel.readString();
        mGiftCardFromName = parcel.readString();
        mGiftCardToName = parcel.readString();
        mGiftCardToEmail = parcel.readString();
        mGiftCardToPhone = parcel.readString();
    }


    public String a()
    {
        return mGiftCardFromName;
    }

    public void a(String s)
    {
        mGiftCardAddressId = s;
    }

    public void b(String s)
    {
        mGiftCardFromName = s;
    }

    public void c(String s)
    {
        mGiftCardToName = s;
    }

    public void d(String s)
    {
        mGiftCardToEmail = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void e(String s)
    {
        mGiftCardToPhone = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mGiftCardAddressId);
        parcel.writeString(mGiftCardFromName);
        parcel.writeString(mGiftCardToName);
        parcel.writeString(mGiftCardToEmail);
        parcel.writeString(mGiftCardToPhone);
    }

}
