// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.offerup.android.dto.response.BaseResponse;

// Referenced classes of package com.offerup.android.dto:
//            Payment

public class PaymentResponse extends BaseResponse
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    Data data;

    public PaymentResponse()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public Payment getPayment()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.getPayment();
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
        private Payment payment;

        public int describeContents()
        {
            return 0;
        }

        public Payment getPayment()
        {
            return payment;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeParcelable(payment, i);
        }



/*
        static Payment access$002(Data data1, Payment payment1)
        {
            data1.payment = payment1;
            return payment1;
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
                data1.payment = (Payment)parcel.readParcelable(com/offerup/android/dto/Payment.getClassLoader());
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

        public final PaymentResponse createFromParcel(Parcel parcel)
        {
            PaymentResponse paymentresponse = new PaymentResponse();
            paymentresponse.data = (Data)parcel.readParcelable(com/offerup/android/dto/PaymentResponse$Data.getClassLoader());
            return paymentresponse;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final PaymentResponse[] newArray(int i)
        {
            return new PaymentResponse[i];
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
