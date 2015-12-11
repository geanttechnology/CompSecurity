// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.offerup.android.dto:
//            Payment

public class payment
    implements Parcelable
{

    public static final android.os.esponse.Data._cls1 CREATOR = new _cls1();
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
    static Payment access$002(_cls1 _pcls1, Payment payment1)
    {
        _pcls1.payment = payment1;
        return payment1;
    }

*/

    public payment()
    {
    }

    class _cls1
        implements android.os.Parcelable.Creator
    {

        public final PaymentResponse.Data createFromParcel(Parcel parcel)
        {
            PaymentResponse.Data data = new PaymentResponse.Data();
            data.payment = (Payment)parcel.readParcelable(com/offerup/android/dto/Payment.getClassLoader());
            return data;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final PaymentResponse.Data[] newArray(int i)
        {
            return new PaymentResponse.Data[i];
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
