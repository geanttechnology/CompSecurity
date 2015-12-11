// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.braintreepayments.api.models:
//            PaymentMethod, PaymentMethodOptions, PostalAddress

public class PayPalAccount extends PaymentMethod
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    protected static final String PAYMENT_METHOD_TYPE = "PayPalAccount";
    private PostalAddress mBillingAddress;
    private String mConsentCode;
    private String mCorrelationId;
    private PayPalDetails mDetails;

    public PayPalAccount()
    {
    }

    private PayPalAccount(Parcel parcel)
    {
        mConsentCode = parcel.readString();
        mCorrelationId = parcel.readString();
        mDetails = (PayPalDetails)parcel.readParcelable(com/braintreepayments/api/models/PayPalAccount$PayPalDetails.getClassLoader());
        mNonce = parcel.readString();
        mDescription = parcel.readString();
        mPaymentMethodOptions = (PaymentMethodOptions)parcel.readSerializable();
        mSource = parcel.readString();
        mBillingAddress = (PostalAddress)parcel.readParcelable(com/braintreepayments/api/models/PostalAddress.getClassLoader());
    }

    PayPalAccount(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public static PayPalAccount fromJson(String s)
    {
        PayPalAccount paypalaccount = (PayPalAccount)(new Gson()).fromJson(s, com/braintreepayments/api/models/PayPalAccount);
        try
        {
            s = (new JSONObject(s)).getJSONObject("details").getJSONObject("payerInfo").getJSONObject("accountAddress").toString();
            paypalaccount.mBillingAddress = (PostalAddress)(new Gson()).fromJson(s, com/braintreepayments/api/models/PostalAddress);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return paypalaccount;
        }
        return paypalaccount;
    }

    public int describeContents()
    {
        return 0;
    }

    public PostalAddress getBillingAddress()
    {
        return mBillingAddress;
    }

    public String getDescription()
    {
        if (TextUtils.equals(super.getDescription(), "PayPal") && !TextUtils.isEmpty(getEmail()))
        {
            return getEmail();
        } else
        {
            return super.getDescription();
        }
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
        return "PayPal";
    }

    protected void setConsentCode(String s)
    {
        mConsentCode = s;
    }

    protected void setCorrelationId(String s)
    {
        mCorrelationId = s;
    }

    protected void setEmail(String s)
    {
        mDetails = new PayPalDetails();
        mDetails.setEmail(s);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mConsentCode);
        parcel.writeString(mCorrelationId);
        parcel.writeParcelable(mDetails, 0);
        parcel.writeString(mNonce);
        parcel.writeString(mDescription);
        parcel.writeSerializable(mPaymentMethodOptions);
        parcel.writeString(mSource);
        parcel.writeParcelable(mBillingAddress, 0);
    }


    private class PayPalDetails
        implements Parcelable, Serializable
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls1();
        private String mEmail;

        private String getEmail()
        {
            return mEmail;
        }

        private void setEmail(String s)
        {
            mEmail = s;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(mEmail);
        }




        public PayPalDetails()
        {
        }

        private PayPalDetails(Parcel parcel)
        {
            mEmail = parcel.readString();
        }

        PayPalDetails(Parcel parcel, _cls1 _pcls1)
        {
            this(parcel);
        }

        class _cls1
            implements android.os.Parcelable.Creator
        {

            public final PayPalDetails createFromParcel(Parcel parcel)
            {
                return new PayPalDetails(parcel, null);
            }

            public final volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public final PayPalDetails[] newArray(int i)
            {
                return new PayPalDetails[i];
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

        public final PayPalAccount createFromParcel(Parcel parcel)
        {
            return new PayPalAccount(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final PayPalAccount[] newArray(int i)
        {
            return new PayPalAccount[i];
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
