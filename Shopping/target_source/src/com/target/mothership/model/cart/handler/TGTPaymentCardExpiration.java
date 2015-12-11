// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.common.tender.b;
import com.target.mothership.model.tender.PaymentCardExpiration;

class TGTPaymentCardExpiration
    implements PaymentCardExpiration
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPaymentCardExpiration a(Parcel parcel)
        {
            return new TGTPaymentCardExpiration(parcel);
        }

        public TGTPaymentCardExpiration[] a(int i)
        {
            return new TGTPaymentCardExpiration[i];
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
    private b mMonth;
    private int mYear;

    private TGTPaymentCardExpiration(Parcel parcel)
    {
        int i = parcel.readInt();
        b b1;
        if (i == -1)
        {
            b1 = null;
        } else
        {
            b1 = com.target.mothership.common.tender.b.values()[i];
        }
        mMonth = b1;
        mYear = parcel.readInt();
    }


    public TGTPaymentCardExpiration(b b1, int i)
    {
        mMonth = b1;
        mYear = i;
    }

    public b a()
    {
        return mMonth;
    }

    public int b()
    {
        return mYear;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mMonth == null)
        {
            i = -1;
        } else
        {
            i = mMonth.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeInt(mYear);
    }

}
