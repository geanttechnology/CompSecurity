// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.target.mothership.common.tender.b;
import com.target.mothership.model.tender.PaymentCardExpiration;

class TGTGuestPaymentCardExpiration
    implements PaymentCardExpiration
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTGuestPaymentCardExpiration a(Parcel parcel)
        {
            return new TGTGuestPaymentCardExpiration(parcel);
        }

        public TGTGuestPaymentCardExpiration[] a(int i)
        {
            return new TGTGuestPaymentCardExpiration[i];
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

    private TGTGuestPaymentCardExpiration(Parcel parcel)
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


    public TGTGuestPaymentCardExpiration(b b1, int i)
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
