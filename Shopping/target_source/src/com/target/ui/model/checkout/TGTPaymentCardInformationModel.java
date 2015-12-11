// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.model.common.PaymentCardTender;

// Referenced classes of package com.target.ui.model.checkout:
//            PaymentCardInformationModel, BillingCardDetailsModel

public class TGTPaymentCardInformationModel
    implements PaymentCardInformationModel
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPaymentCardInformationModel a(Parcel parcel)
        {
            return new TGTPaymentCardInformationModel(parcel);
        }

        public TGTPaymentCardInformationModel[] a(int i)
        {
            return new TGTPaymentCardInformationModel[i];
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
    private BillingCardDetailsModel mBillingCardDetails;
    private boolean mIsAppliedPaymentCard;
    private boolean mIsDefaultPaymentCard;
    private PaymentTender mPaymentTender;

    public TGTPaymentCardInformationModel()
    {
    }

    private TGTPaymentCardInformationModel(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        mBillingCardDetails = (BillingCardDetailsModel)parcel.readParcelable(com/target/ui/model/checkout/BillingCardDetailsModel.getClassLoader());
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsAppliedPaymentCard = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsDefaultPaymentCard = flag;
        mPaymentTender = (PaymentTender)parcel.readParcelable(com/target/mothership/model/common/PaymentCardTender.getClassLoader());
    }


    public BillingCardDetailsModel a()
    {
        return mBillingCardDetails;
    }

    public void a(PaymentTender paymenttender)
    {
        mPaymentTender = paymenttender;
    }

    public void a(BillingCardDetailsModel billingcarddetailsmodel)
    {
        mBillingCardDetails = billingcarddetailsmodel;
    }

    public void a(boolean flag)
    {
        mIsAppliedPaymentCard = flag;
    }

    public void b(boolean flag)
    {
        mIsDefaultPaymentCard = flag;
    }

    public boolean b()
    {
        return mIsAppliedPaymentCard;
    }

    public boolean c()
    {
        return mIsDefaultPaymentCard;
    }

    public PaymentTender d()
    {
        return mPaymentTender;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeParcelable(mBillingCardDetails, i);
        byte byte0;
        if (mIsAppliedPaymentCard)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsDefaultPaymentCard)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeParcelable(mPaymentTender, 0);
    }

}
