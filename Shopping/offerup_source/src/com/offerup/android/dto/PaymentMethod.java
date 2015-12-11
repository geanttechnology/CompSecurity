// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;
import b.a.a;

// Referenced classes of package com.offerup.android.dto:
//            CreditCard, GoogleWalletMetaData

public class PaymentMethod
    implements Parcelable, Comparable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public static final String GOOGLE_WALLET_TYPE = "androidpaycard";
    a createdDate;
    CreditCard creditCard;
    Boolean defaultPaymentMethod;
    GoogleWalletMetaData googleWalletMetaData;
    String googleWalletTransactionId;
    long id;
    String imageUrl;
    String label;
    String token;
    String type;
    a updatedDate;

    public PaymentMethod()
    {
    }

    public PaymentMethod(String s)
    {
        googleWalletTransactionId = s;
        type = "androidpaycard";
    }

    public int compareTo(PaymentMethod paymentmethod)
    {
label0:
        {
            int j = paymentmethod.isDefaultPaymentMethod().compareTo(isDefaultPaymentMethod());
            int i = j;
            if (j == 0)
            {
                if (paymentmethod.getUpdatedDate() != null && getUpdatedDate() != null)
                {
                    break label0;
                }
                i = 0;
            }
            return i;
        }
        return paymentmethod.getUpdatedDate().b(getUpdatedDate());
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((PaymentMethod)obj);
    }

    public int describeContents()
    {
        return 0;
    }

    public a getCreatedDate()
    {
        return createdDate;
    }

    public CreditCard getCreditCard()
    {
        return creditCard;
    }

    public GoogleWalletMetaData getGoogleWalletMetaData()
    {
        return googleWalletMetaData;
    }

    public String getGoogleWalletTransactionId()
    {
        return googleWalletTransactionId;
    }

    public long getId()
    {
        return id;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getLabel()
    {
        return label;
    }

    public String getToken()
    {
        return token;
    }

    public String getType()
    {
        return type;
    }

    public a getUpdatedDate()
    {
        return updatedDate;
    }

    public boolean isAndroidPay()
    {
        return "androidpaycard".equals(getType());
    }

    public Boolean isDefaultPaymentMethod()
    {
        return defaultPaymentMethod;
    }

    public void setGoogleWalletMetaData(GoogleWalletMetaData googlewalletmetadata)
    {
        googleWalletMetaData = googlewalletmetadata;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(id);
        parcel.writeString(token);
        parcel.writeSerializable(createdDate);
        parcel.writeSerializable(updatedDate);
        int j;
        if (defaultPaymentMethod != null && defaultPaymentMethod.booleanValue())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeString(imageUrl);
        parcel.writeString(label);
        parcel.writeString(type);
        parcel.writeParcelable(creditCard, i);
        parcel.writeParcelable(googleWalletMetaData, i);
        parcel.writeString(googleWalletTransactionId);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final PaymentMethod createFromParcel(Parcel parcel)
        {
            PaymentMethod paymentmethod = new PaymentMethod();
            paymentmethod.id = parcel.readLong();
            paymentmethod.token = parcel.readString();
            paymentmethod.createdDate = (a)parcel.readSerializable();
            paymentmethod.updatedDate = (a)parcel.readSerializable();
            paymentmethod.defaultPaymentMethod = Boolean.valueOf((new OfferUpBoolean(parcel.readInt())).value);
            paymentmethod.imageUrl = parcel.readString();
            paymentmethod.label = parcel.readString();
            paymentmethod.type = parcel.readString();
            paymentmethod.creditCard = (CreditCard)parcel.readParcelable(com/offerup/android/dto/CreditCard.getClassLoader());
            paymentmethod.googleWalletMetaData = (GoogleWalletMetaData)parcel.readParcelable(com/offerup/android/dto/GoogleWalletMetaData.getClassLoader());
            paymentmethod.googleWalletTransactionId = parcel.readString();
            return paymentmethod;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final PaymentMethod[] newArray(int i)
        {
            return new PaymentMethod[i];
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
