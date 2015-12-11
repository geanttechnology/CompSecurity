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

public class CoinbaseAccount extends PaymentMethod
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    protected static final String PAYMENT_METHOD_TYPE = "CoinbaseAccount";
    private String mAccessCode;
    private CoinbaseAccountDetails mDetails;
    private String mRedirectUri;

    public CoinbaseAccount()
    {
    }

    private CoinbaseAccount(Parcel parcel)
    {
        mAccessCode = parcel.readString();
        mRedirectUri = parcel.readString();
        mDetails = (CoinbaseAccountDetails)parcel.readParcelable(com/braintreepayments/api/models/CoinbaseAccount$CoinbaseAccountDetails.getClassLoader());
        mNonce = parcel.readString();
        mDescription = parcel.readString();
        mPaymentMethodOptions = (PaymentMethodOptions)parcel.readSerializable();
        mSource = parcel.readString();
    }

    CoinbaseAccount(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public static CoinbaseAccount fromJson(String s)
    {
        return (CoinbaseAccount)(new Gson()).fromJson(s, com/braintreepayments/api/models/CoinbaseAccount);
    }

    public int describeContents()
    {
        return 0;
    }

    public String getEmail()
    {
        if (mDetails != null)
        {
            return mDetails.getEmail();
        } else
        {
            return "";
        }
    }

    public String getTypeLabel()
    {
        return "Coinbase";
    }

    protected void setAccessCode(String s)
    {
        mAccessCode = s;
    }

    protected void setRedirectUri(String s)
    {
        mRedirectUri = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mAccessCode);
        parcel.writeString(mRedirectUri);
        parcel.writeParcelable(mDetails, 0);
        parcel.writeString(mNonce);
        parcel.writeString(mDescription);
        parcel.writeSerializable(mPaymentMethodOptions);
        parcel.writeString(mSource);
    }


    private class CoinbaseAccountDetails
        implements Parcelable, Serializable
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls1();
        private String mEmail;

        public int describeContents()
        {
            return 0;
        }

        public String getEmail()
        {
            return mEmail;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(mEmail);
        }


        public CoinbaseAccountDetails()
        {
        }

        private CoinbaseAccountDetails(Parcel parcel)
        {
            mEmail = parcel.readString();
        }

        CoinbaseAccountDetails(Parcel parcel, _cls1 _pcls1)
        {
            this(parcel);
        }

        class _cls1
            implements android.os.Parcelable.Creator
        {

            public final CoinbaseAccountDetails createFromParcel(Parcel parcel)
            {
                return new CoinbaseAccountDetails(parcel, null);
            }

            public final volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public final CoinbaseAccountDetails[] newArray(int i)
            {
                return new CoinbaseAccountDetails[i];
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

        public final CoinbaseAccount createFromParcel(Parcel parcel)
        {
            return new CoinbaseAccount(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final CoinbaseAccount[] newArray(int i)
        {
            return new CoinbaseAccount[i];
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
