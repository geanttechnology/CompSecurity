// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class paymentToken
    implements Parcelable
{

    public static final android.os.esponse.Data._cls1 CREATOR = new _cls1();
    private String paymentToken;

    public int describeContents()
    {
        return 0;
    }

    public String getPaymentToken()
    {
        return paymentToken;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(paymentToken);
    }



/*
    static String access$002(_cls1 _pcls1, String s)
    {
        _pcls1.paymentToken = s;
        return s;
    }

*/

    public paymentToken()
    {
    }

    class _cls1
        implements android.os.Parcelable.Creator
    {

        public final BraintreeTokenResponse.Data createFromParcel(Parcel parcel)
        {
            BraintreeTokenResponse.Data data = new BraintreeTokenResponse.Data();
            data.paymentToken = parcel.readString();
            return data;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final BraintreeTokenResponse.Data[] newArray(int i)
        {
            return new BraintreeTokenResponse.Data[i];
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
