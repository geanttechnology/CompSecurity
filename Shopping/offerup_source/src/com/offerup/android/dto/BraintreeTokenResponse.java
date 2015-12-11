// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.offerup.android.dto.response.BaseResponse;

public class BraintreeTokenResponse extends BaseResponse
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    Data data;

    public BraintreeTokenResponse()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public String getPaymentToken()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.getPaymentToken();
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(data, i);
    }


    private class Data
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls1();
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
        static String access$002(Data data1, String s)
        {
            data1.paymentToken = s;
            return s;
        }

*/

        public Data()
        {
        }

        class _cls1
            implements android.os.Parcelable.Creator
        {

            public final Data createFromParcel(Parcel parcel)
            {
                Data data1 = new Data();
                data1.paymentToken = parcel.readString();
                return data1;
            }

            public final volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public final Data[] newArray(int i)
            {
                return new Data[i];
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

        public final BraintreeTokenResponse createFromParcel(Parcel parcel)
        {
            BraintreeTokenResponse braintreetokenresponse = new BraintreeTokenResponse();
            braintreetokenresponse.data = (Data)parcel.readParcelable(com/offerup/android/dto/BraintreeTokenResponse$Data.getClassLoader());
            return braintreetokenresponse;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final BraintreeTokenResponse[] newArray(int i)
        {
            return new BraintreeTokenResponse[i];
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
