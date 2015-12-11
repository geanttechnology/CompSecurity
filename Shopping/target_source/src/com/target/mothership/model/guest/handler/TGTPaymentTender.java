// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.target.mothership.common.tender.PaymentTender;

public class TGTPaymentTender
    implements PaymentTender
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPaymentTender a(Parcel parcel)
        {
            return new TGTPaymentTender(parcel);
        }

        public TGTPaymentTender[] a(int i)
        {
            return new TGTPaymentTender[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private String mCardInfoId;

    protected TGTPaymentTender()
    {
    }

    protected TGTPaymentTender(Parcel parcel)
    {
        mCardInfoId = parcel.readString();
    }

    public String a()
    {
        return mCardInfoId;
    }

    public void c(String s)
    {
        mCardInfoId = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mCardInfoId);
    }

}
