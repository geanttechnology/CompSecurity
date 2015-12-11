// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;
import com.google.a.a.e;
import java.math.BigDecimal;

// Referenced classes of package com.target.ui.model.checkout:
//            PaymentDetailsModel, PaymentCardDisplayDetails, PayPalDisplayDetails

public class TGTPaymentDetailsModel
    implements PaymentDetailsModel
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPaymentDetailsModel a(Parcel parcel)
        {
            return new TGTPaymentDetailsModel(parcel);
        }

        public TGTPaymentDetailsModel[] a(int i)
        {
            return new TGTPaymentDetailsModel[i];
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
    private boolean mHasValidPayment;
    private PayPalDisplayDetails mPayPalDisplayDetails;
    private PaymentCardDisplayDetails mPaymentCardDisplayDetails;
    private BigDecimal mRemainingBalance;

    public TGTPaymentDetailsModel()
    {
    }

    private TGTPaymentDetailsModel(Parcel parcel)
    {
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHasValidPayment = flag;
        mPaymentCardDisplayDetails = (PaymentCardDisplayDetails)parcel.readParcelable(com/target/ui/model/checkout/PaymentCardDisplayDetails.getClassLoader());
        mPayPalDisplayDetails = (PayPalDisplayDetails)parcel.readParcelable(com/target/ui/model/checkout/PayPalDisplayDetails.getClassLoader());
        mRemainingBalance = (BigDecimal)parcel.readSerializable();
    }


    public void a(PayPalDisplayDetails paypaldisplaydetails)
    {
        mPayPalDisplayDetails = paypaldisplaydetails;
    }

    public void a(PaymentCardDisplayDetails paymentcarddisplaydetails)
    {
        mPaymentCardDisplayDetails = paymentcarddisplaydetails;
    }

    public void a(boolean flag)
    {
        mHasValidPayment = flag;
    }

    public boolean a()
    {
        return mHasValidPayment;
    }

    public e b()
    {
        return e.c(mPaymentCardDisplayDetails);
    }

    public e c()
    {
        return e.c(mPayPalDisplayDetails);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte byte0;
        if (mHasValidPayment)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeParcelable(mPaymentCardDisplayDetails, i);
        parcel.writeParcelable(mPayPalDisplayDetails, i);
        parcel.writeSerializable(mRemainingBalance);
    }

}
