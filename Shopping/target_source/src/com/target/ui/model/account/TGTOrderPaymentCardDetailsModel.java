// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.account;

import android.os.Parcel;
import com.target.mothership.common.tender.a;
import java.math.BigDecimal;

// Referenced classes of package com.target.ui.model.account:
//            OrderPaymentCardDetailsModel

public class TGTOrderPaymentCardDetailsModel
    implements OrderPaymentCardDetailsModel
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTOrderPaymentCardDetailsModel a(Parcel parcel)
        {
            return new TGTOrderPaymentCardDetailsModel(parcel);
        }

        public TGTOrderPaymentCardDetailsModel[] a(int i)
        {
            return new TGTOrderPaymentCardDetailsModel[i];
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
    BigDecimal mAppliedAmount;
    String mCardLast4Digits;
    a mCardType;

    public TGTOrderPaymentCardDetailsModel()
    {
    }

    private TGTOrderPaymentCardDetailsModel(Parcel parcel)
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
        mCardLast4Digits = parcel.readString();
        mAppliedAmount = (BigDecimal)parcel.readSerializable();
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
        mCardLast4Digits = s;
    }

    public void a(BigDecimal bigdecimal)
    {
        mAppliedAmount = bigdecimal;
    }

    public String b()
    {
        return mCardLast4Digits;
    }

    public BigDecimal c()
    {
        return mAppliedAmount;
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
        parcel.writeString(mCardLast4Digits);
        parcel.writeSerializable(mAppliedAmount);
    }

}
