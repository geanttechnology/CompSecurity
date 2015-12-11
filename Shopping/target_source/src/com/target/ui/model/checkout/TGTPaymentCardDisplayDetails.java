// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;
import com.target.mothership.common.tender.a;

// Referenced classes of package com.target.ui.model.checkout:
//            PaymentCardDisplayDetails

public class TGTPaymentCardDisplayDetails
    implements PaymentCardDisplayDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPaymentCardDisplayDetails a(Parcel parcel)
        {
            return new TGTPaymentCardDisplayDetails(parcel);
        }

        public TGTPaymentCardDisplayDetails[] a(int i)
        {
            return new TGTPaymentCardDisplayDetails[i];
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
    private String mAddressLine1;
    private String mAddressLine2;
    private a mCardType;
    private String mLast4Digits;

    public TGTPaymentCardDisplayDetails()
    {
    }

    private TGTPaymentCardDisplayDetails(Parcel parcel)
    {
        int i = parcel.readInt();
        a a1;
        if (i == -1)
        {
            a1 = null;
        } else
        {
            a1 = com.target.mothership.common.tender.a.values()[i];
        }
        mCardType = a1;
        mLast4Digits = parcel.readString();
        mAddressLine1 = parcel.readString();
        mAddressLine2 = parcel.readString();
    }


    public a a()
    {
        return mCardType;
    }

    public void a(a a1)
    {
        mCardType = a1;
    }

    public void a(String s)
    {
        mLast4Digits = s;
    }

    public String b()
    {
        return mLast4Digits;
    }

    public void b(String s)
    {
        mAddressLine1 = s;
    }

    public String c()
    {
        return mAddressLine1;
    }

    public void c(String s)
    {
        mAddressLine2 = s;
    }

    public String d()
    {
        return mAddressLine2;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mCardType == null)
        {
            i = -1;
        } else
        {
            i = mCardType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeString(mLast4Digits);
        parcel.writeString(mAddressLine1);
        parcel.writeString(mAddressLine2);
    }

}
