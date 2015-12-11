// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;
import java.math.BigDecimal;

// Referenced classes of package com.target.ui.model.checkout:
//            PayPalDisplayDetails

public class TGTPayPalDisplayDetails
    implements PayPalDisplayDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPayPalDisplayDetails a(Parcel parcel)
        {
            return new TGTPayPalDisplayDetails(parcel);
        }

        public TGTPayPalDisplayDetails[] a(int i)
        {
            return new TGTPayPalDisplayDetails[i];
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
    private BigDecimal mAppliedAmount;

    public TGTPayPalDisplayDetails()
    {
    }

    private TGTPayPalDisplayDetails(Parcel parcel)
    {
        mAppliedAmount = (BigDecimal)parcel.readSerializable();
    }


    public BigDecimal a()
    {
        return mAppliedAmount;
    }

    public void a(BigDecimal bigdecimal)
    {
        mAppliedAmount = bigdecimal;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mAppliedAmount);
    }

}
