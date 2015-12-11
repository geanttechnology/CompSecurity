// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import java.io.Serializable;

// Referenced classes of package com.braintreepayments.api.models:
//            PaymentMethod, ThreeDSecureInfo, PaymentMethodOptions

public class Card extends PaymentMethod
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    protected static final String PAYMENT_METHOD_TYPE = "CreditCard";
    private BillingAddress mBillingAddress;
    private String mCvv;
    private CardDetails mDetails;
    private String mExpirationDate;
    private String mExpirationMonth;
    private String mExpirationYear;
    private String mNumber;
    private ThreeDSecureInfo mThreeDSecureInfo;

    public Card()
    {
    }

    private Card(Parcel parcel)
    {
        mBillingAddress = (BillingAddress)parcel.readParcelable(com/braintreepayments/api/models/Card$BillingAddress.getClassLoader());
        mThreeDSecureInfo = (ThreeDSecureInfo)parcel.readParcelable(com/braintreepayments/api/models/ThreeDSecureInfo.getClassLoader());
        mDetails = (CardDetails)parcel.readParcelable(com/braintreepayments/api/models/Card$CardDetails.getClassLoader());
        mExpirationMonth = parcel.readString();
        mExpirationYear = parcel.readString();
        mExpirationDate = parcel.readString();
        mNumber = parcel.readString();
        mCvv = parcel.readString();
        mNonce = parcel.readString();
        mDescription = parcel.readString();
        mPaymentMethodOptions = (PaymentMethodOptions)parcel.readSerializable();
        mSource = parcel.readString();
    }

    Card(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public static Card fromJson(String s)
    {
        return (Card)(new Gson()).fromJson(s, com/braintreepayments/api/models/Card);
    }

    public int describeContents()
    {
        return 0;
    }

    public String getLastTwo()
    {
        return mDetails.getLastTwo();
    }

    public ThreeDSecureInfo getThreeDSecureInfo()
    {
        return mThreeDSecureInfo;
    }

    public String getTypeLabel()
    {
        return mDetails.getCardType();
    }

    protected void setBillingAddress(BillingAddress billingaddress)
    {
        mBillingAddress = billingaddress;
    }

    protected void setCardNumber(String s)
    {
        mNumber = s;
    }

    protected void setCvv(String s)
    {
        mCvv = s;
    }

    protected void setExpirationDate(String s)
    {
        mExpirationDate = s;
    }

    protected void setExpirationMonth(String s)
    {
        mExpirationMonth = s;
    }

    protected void setExpirationYear(String s)
    {
        mExpirationYear = s;
    }

    protected void setThreeDSecureInfo(ThreeDSecureInfo threedsecureinfo)
    {
        mThreeDSecureInfo = threedsecureinfo;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mBillingAddress, 0);
        parcel.writeParcelable(mThreeDSecureInfo, 0);
        parcel.writeParcelable(mDetails, 0);
        parcel.writeString(mExpirationMonth);
        parcel.writeString(mExpirationYear);
        parcel.writeString(mExpirationDate);
        parcel.writeString(mNumber);
        parcel.writeString(mCvv);
        parcel.writeString(mNonce);
        parcel.writeString(mDescription);
        parcel.writeSerializable(mPaymentMethodOptions);
        parcel.writeString(mSource);
    }


    private class BillingAddress
        implements Parcelable, Serializable
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls1();
        private String mCountryName;
        private String mFirstName;
        private String mLastName;
        private String mLocality;
        private String mPostalCode;
        private String mRegion;
        private String mStreetAddress;

        public int describeContents()
        {
            return 0;
        }

        protected void setCountryName(String s)
        {
            mCountryName = s;
        }

        protected void setFirstName(String s)
        {
            mFirstName = s;
        }

        protected void setLastName(String s)
        {
            mLastName = s;
        }

        protected void setLocality(String s)
        {
            mLocality = s;
        }

        protected void setPostalCode(String s)
        {
            mPostalCode = s;
        }

        protected void setRegion(String s)
        {
            mRegion = s;
        }

        protected void setStreetAddress(String s)
        {
            mStreetAddress = s;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(mFirstName);
            parcel.writeString(mLastName);
            parcel.writeString(mCountryName);
            parcel.writeString(mLocality);
            parcel.writeString(mPostalCode);
            parcel.writeString(mRegion);
            parcel.writeString(mStreetAddress);
        }


        public BillingAddress()
        {
        }

        private BillingAddress(Parcel parcel)
        {
            mFirstName = parcel.readString();
            mLastName = parcel.readString();
            mCountryName = parcel.readString();
            mLocality = parcel.readString();
            mPostalCode = parcel.readString();
            mRegion = parcel.readString();
            mStreetAddress = parcel.readString();
        }

        BillingAddress(Parcel parcel, _cls1 _pcls1)
        {
            this(parcel);
        }

        class _cls1
            implements android.os.Parcelable.Creator
        {

            public final BillingAddress createFromParcel(Parcel parcel)
            {
                return new BillingAddress(parcel, null);
            }

            public final volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public final BillingAddress[] newArray(int i)
            {
                return new BillingAddress[i];
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


    private class CardDetails
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


        public CardDetails()
        {
        }

        private CardDetails(Parcel parcel)
        {
            mCardType = parcel.readString();
            mLastTwo = parcel.readString();
        }

        CardDetails(Parcel parcel, _cls1 _pcls1)
        {
            this(parcel);
        }

        class _cls1
            implements android.os.Parcelable.Creator
        {

            public final CardDetails createFromParcel(Parcel parcel)
            {
                return new CardDetails(parcel, null);
            }

            public final volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public final CardDetails[] newArray(int i)
            {
                return new CardDetails[i];
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

        public final Card createFromParcel(Parcel parcel)
        {
            return new Card(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final Card[] newArray(int i)
        {
            return new Card[i];
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
