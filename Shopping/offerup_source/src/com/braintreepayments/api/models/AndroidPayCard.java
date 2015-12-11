// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import java.io.Serializable;

// Referenced classes of package com.braintreepayments.api.models:
//            PaymentMethod, PaymentMethodOptions

public class AndroidPayCard extends PaymentMethod
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    protected static final String PAYMENT_METHOD_TYPE = "AndroidPayCard";
    private AndroidPayCardDetails mDetails;

    public AndroidPayCard()
    {
    }

    private AndroidPayCard(Parcel parcel)
    {
        mDetails = (AndroidPayCardDetails)parcel.readParcelable(com/braintreepayments/api/models/AndroidPayCard$AndroidPayCardDetails.getClassLoader());
        mNonce = parcel.readString();
        mDescription = parcel.readString();
        mPaymentMethodOptions = (PaymentMethodOptions)parcel.readSerializable();
        mSource = parcel.readString();
    }

    AndroidPayCard(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public static AndroidPayCard fromJson(String s)
    {
        return (AndroidPayCard)(new Gson()).fromJson(s, com/braintreepayments/api/models/AndroidPayCard);
    }

    public int describeContents()
    {
        return 0;
    }

    public String getLastTwo()
    {
        return mDetails.getLastTwo();
    }

    public String getTypeLabel()
    {
        return "Google Wallet";
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mDetails, 0);
        parcel.writeString(mNonce);
        parcel.writeString(mDescription);
        parcel.writeSerializable(mPaymentMethodOptions);
        parcel.writeString(mSource);
    }


    private class AndroidPayCardDetails
        implements Parcelable, Serializable
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls1();
        private String mCardType;
        private String mLastTwo;

        public int describeContents()
        {
            return 0;
        }

        protected String getCardType()
        {
            return mCardType;
        }

        protected String getLastTwo()
        {
            return mLastTwo;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(mCardType);
            parcel.writeString(mLastTwo);
        }


        public AndroidPayCardDetails()
        {
        }

        private AndroidPayCardDetails(Parcel parcel)
        {
            mCardType = parcel.readString();
            mLastTwo = parcel.readString();
        }

        AndroidPayCardDetails(Parcel parcel, _cls1 _pcls1)
        {
            this(parcel);
        }

        class _cls1
            implements android.os.Parcelable.Creator
        {

            public final AndroidPayCardDetails createFromParcel(Parcel parcel)
            {
                return new AndroidPayCardDetails(parcel, null);
            }

            public final volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public final AndroidPayCardDetails[] newArray(int i)
            {
                return new AndroidPayCardDetails[i];
            }

            public final volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

                _cls1()
                {
                }
        }

    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final AndroidPayCard createFromParcel(Parcel parcel)
        {
            return new AndroidPayCard(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final AndroidPayCard[] newArray(int i)
        {
            return new AndroidPayCard[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
