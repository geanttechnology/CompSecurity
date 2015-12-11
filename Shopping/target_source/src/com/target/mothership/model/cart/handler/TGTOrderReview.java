// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.common.AppliedPaymentCardTender;
import com.target.mothership.model.guest.interfaces.AppliedPayPalDetails;
import com.target.mothership.util.k;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTOrderSummary

class TGTOrderReview extends TGTOrderSummary
    implements OrderReview
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTOrderReview a(Parcel parcel)
        {
            return new TGTOrderReview(parcel);
        }

        public TGTOrderReview[] a(int i)
        {
            return new TGTOrderReview[i];
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
    private List mAppliedGiftCardTenders;
    private AppliedPaymentCardTender mAppliedPaymentCardTender;
    private AppliedPayPalDetails mPayPalDetails;
    private BigDecimal mRemainingBalance;
    private List mShipmentList;
    private String mTrackingEmailId;

    TGTOrderReview()
    {
    }

    protected TGTOrderReview(Parcel parcel)
    {
        super(parcel);
        mAppliedPaymentCardTender = (AppliedPaymentCardTender)parcel.readParcelable(com/target/mothership/model/common/AppliedPaymentCardTender.getClassLoader());
        mAppliedGiftCardTenders = new ArrayList();
        parcel.readList(mAppliedGiftCardTenders, com/target/mothership/model/cart/handler/TGTOrderReview.getClassLoader());
        mPayPalDetails = (AppliedPayPalDetails)parcel.readParcelable(com/target/mothership/model/guest/interfaces/AppliedPayPalDetails.getClassLoader());
        mShipmentList = new ArrayList();
        parcel.readList(mShipmentList, com/target/mothership/model/cart/handler/TGTOrderReview.getClassLoader());
        mTrackingEmailId = parcel.readString();
        mRemainingBalance = (BigDecimal)parcel.readSerializable();
    }

    public void a(AppliedPaymentCardTender appliedpaymentcardtender)
    {
        mAppliedPaymentCardTender = appliedpaymentcardtender;
    }

    public void a(AppliedPayPalDetails appliedpaypaldetails)
    {
        mPayPalDetails = appliedpaypaldetails;
    }

    public void a(BigDecimal bigdecimal)
    {
        mRemainingBalance = bigdecimal;
    }

    public void c(List list)
    {
        mAppliedGiftCardTenders = list;
    }

    public void d(List list)
    {
        mShipmentList = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public e k()
    {
        return com.target.mothership.util.k.a(mAppliedPaymentCardTender);
    }

    public List l()
    {
        return mAppliedGiftCardTenders;
    }

    public e m()
    {
        return e.c(mPayPalDetails);
    }

    public List n()
    {
        return new ArrayList(mShipmentList);
    }

    public String o()
    {
        return mTrackingEmailId;
    }

    public e p()
    {
        return com.target.mothership.util.k.a(mRemainingBalance);
    }

    public void q(String s)
    {
        mTrackingEmailId = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(mAppliedPaymentCardTender, i);
        parcel.writeList(mAppliedGiftCardTenders);
        parcel.writeParcelable(mPayPalDetails, i);
        parcel.writeList(mShipmentList);
        parcel.writeString(mTrackingEmailId);
        parcel.writeSerializable(mRemainingBalance);
    }

}
