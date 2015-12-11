// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;
import com.target.mothership.common.tender.a;

// Referenced classes of package com.target.ui.model.checkout:
//            CardDataModel

public class TGTCardDataModel
    implements CardDataModel
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCardDataModel a(Parcel parcel)
        {
            return new TGTCardDataModel(parcel);
        }

        public TGTCardDataModel[] a(int i)
        {
            return new TGTCardDataModel[i];
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
    private String mCardNumber;
    private a mCardType;
    private String mExpiryMonth;
    private String mExpiryYear;
    private String mLast4Digits;
    private String mSecurityCode;

    public TGTCardDataModel()
    {
    }

    private TGTCardDataModel(Parcel parcel)
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
        mCardNumber = parcel.readString();
        mLast4Digits = parcel.readString();
        mExpiryMonth = parcel.readString();
        mExpiryYear = parcel.readString();
        mSecurityCode = parcel.readString();
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
        mCardNumber = s;
    }

    public String b()
    {
        return mCardNumber;
    }

    public void b(String s)
    {
        mLast4Digits = s;
    }

    public String c()
    {
        return mLast4Digits;
    }

    public void c(String s)
    {
        mExpiryYear = s;
    }

    public String d()
    {
        return mExpiryMonth;
    }

    public void d(String s)
    {
        mExpiryMonth = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return mExpiryYear;
    }

    public void e(String s)
    {
        mSecurityCode = s;
    }

    public String f()
    {
        return mSecurityCode;
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
        parcel.writeString(mCardNumber);
        parcel.writeString(mLast4Digits);
        parcel.writeString(mExpiryMonth);
        parcel.writeString(mExpiryYear);
        parcel.writeString(mSecurityCode);
    }

}
