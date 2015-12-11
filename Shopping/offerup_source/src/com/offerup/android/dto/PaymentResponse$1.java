// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;

// Referenced classes of package com.offerup.android.dto:
//            PaymentResponse

final class ta
    implements android.os.
{

    public final PaymentResponse createFromParcel(Parcel parcel)
    {
        PaymentResponse paymentresponse = new PaymentResponse();
        paymentresponse.data = (ta)parcel.readParcelable(com/offerup/android/dto/PaymentResponse$Data.getClassLoader());
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

    ta()
    {
    }
}
