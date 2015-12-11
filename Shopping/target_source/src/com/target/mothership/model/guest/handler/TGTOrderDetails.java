// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.AppliedPayPalDetails;
import com.target.mothership.model.guest.interfaces.AppliedPaymentCard;
import com.target.mothership.model.guest.interfaces.EmailDeliveryShipmentDetails;
import com.target.mothership.model.guest.interfaces.MobileDeliveryShipmentDetails;
import com.target.mothership.model.guest.interfaces.OrderDetails;
import com.target.mothership.model.guest.interfaces.OrderDetailsProduct;
import com.target.mothership.model.guest.interfaces.ShipHomeShipmentDetails;
import com.target.mothership.model.guest.interfaces.StorePickUpShipmentDetails;
import com.target.mothership.util.k;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

public class TGTOrderDetails
    implements OrderDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTOrderDetails a(Parcel parcel)
        {
            return new TGTOrderDetails(parcel);
        }

        public TGTOrderDetails[] a(int i1)
        {
            return new TGTOrderDetails[i1];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i1)
        {
            return a(i1);
        }

    };
    private List mAppliedGiftCardList;
    private AppliedPayPalDetails mAppliedPayPalDetails;
    private AppliedPaymentCard mAppliedPaymentCard;
    private List mCancelledItemList;
    private String mCustomerOrderNumber;
    private EmailDeliveryShipmentDetails mEmailDeliveryShipmentDetails;
    private BigDecimal mEstimatedTax;
    private Currency mEstimatedTaxCurrency;
    private BigDecimal mGiftWrapCharge;
    private Currency mGiftWrapChargeCurrency;
    private BigDecimal mGrandTotal;
    private Currency mGrandTotalCurrency;
    private BigDecimal mHandlingFee;
    private BigDecimal mHandlingFeeDiscount;
    private Currency mHandlingFeeDiscountCurrency;
    private BigDecimal mHandlingFeeTax;
    private boolean mHasStorePickupItem;
    private boolean mIsEligibleToChangeStorePickupInfo;
    private boolean mIsOrderCancellable;
    private boolean mIsReorderable;
    private boolean mIsReturnable;
    private boolean mIsStorePickUpExtendPossible;
    private MobileDeliveryShipmentDetails mMobileDeliveryShipmentDetails;
    private Date mOrderPlacedDate;
    private String mOrderStatus;
    private List mPromotions;
    private int mQuantity;
    private BigDecimal mSavings;
    private Currency mSavingsCurrency;
    private BigDecimal mSavingsPercent;
    private ShipHomeShipmentDetails mShipHomeShipmentDetails;
    private BigDecimal mShippingDiscount;
    private Currency mShippingDiscountCurrency;
    private BigDecimal mStateAndLocalFee;
    private Currency mStateAndLocalFeeCurrency;
    private StorePickUpShipmentDetails mStorePickUpShipmentDetails;
    private BigDecimal mTotalAdjustment;
    private Currency mTotalAdjustmentCurrency;
    private BigDecimal mTotalProductPrice;
    private Currency mTotalProductPriceCurrency;
    private BigDecimal mTotalSalesTaxAmount;
    private Currency mTotalSalesTaxCurrency;
    private BigDecimal mTotalShippingCharge;
    private Currency mTotalShippingChargeCurrency;
    private BigDecimal mTotalShippingTax;
    private Currency mTotalShippingTaxCurrency;

    TGTOrderDetails()
    {
    }

    private TGTOrderDetails(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        mCancelledItemList = new ArrayList();
        parcel.readList(mCancelledItemList, com/target/mothership/model/guest/interfaces/OrderDetailsProduct.getClassLoader());
        mShipHomeShipmentDetails = (ShipHomeShipmentDetails)parcel.readParcelable(com/target/mothership/model/guest/interfaces/ShipHomeShipmentDetails.getClassLoader());
        mStorePickUpShipmentDetails = (StorePickUpShipmentDetails)parcel.readParcelable(com/target/mothership/model/guest/interfaces/StorePickUpShipmentDetails.getClassLoader());
        mEmailDeliveryShipmentDetails = (EmailDeliveryShipmentDetails)parcel.readParcelable(com/target/mothership/model/guest/interfaces/EmailDeliveryShipmentDetails.getClassLoader());
        mMobileDeliveryShipmentDetails = (MobileDeliveryShipmentDetails)parcel.readParcelable(com/target/mothership/model/guest/interfaces/MobileDeliveryShipmentDetails.getClassLoader());
        mAppliedPaymentCard = (AppliedPaymentCard)parcel.readParcelable(com/target/mothership/model/guest/interfaces/AppliedPaymentCard.getClassLoader());
        mAppliedGiftCardList = new ArrayList();
        parcel.readList(mAppliedGiftCardList, com/target/mothership/model/guest/handler/TGTOrderDetails.getClassLoader());
        mAppliedPayPalDetails = (AppliedPayPalDetails)parcel.readParcelable(com/target/mothership/model/guest/interfaces/AppliedPayPalDetails.getClassLoader());
        mCustomerOrderNumber = parcel.readString();
        long l1 = parcel.readLong();
        Date date;
        boolean flag;
        if (l1 == -1L)
        {
            date = null;
        } else
        {
            date = new Date(l1);
        }
        mOrderPlacedDate = date;
        mOrderStatus = parcel.readString();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsOrderCancellable = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsReorderable = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsReturnable = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHasStorePickupItem = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsEligibleToChangeStorePickupInfo = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsStorePickUpExtendPossible = flag;
        mQuantity = parcel.readInt();
        mPromotions = new ArrayList();
        parcel.readList(mPromotions, com/target/mothership/model/guest/handler/TGTOrderDetails.getClassLoader());
        mGrandTotal = (BigDecimal)parcel.readSerializable();
        mGrandTotalCurrency = (Currency)parcel.readSerializable();
        mSavings = (BigDecimal)parcel.readSerializable();
        mSavingsPercent = (BigDecimal)parcel.readSerializable();
        mSavingsCurrency = (Currency)parcel.readSerializable();
        mTotalAdjustment = (BigDecimal)parcel.readSerializable();
        mTotalAdjustmentCurrency = (Currency)parcel.readSerializable();
        mTotalProductPrice = (BigDecimal)parcel.readSerializable();
        mTotalProductPriceCurrency = (Currency)parcel.readSerializable();
        mHandlingFee = (BigDecimal)parcel.readSerializable();
        mHandlingFeeDiscount = (BigDecimal)parcel.readSerializable();
        mHandlingFeeDiscountCurrency = (Currency)parcel.readSerializable();
        mHandlingFeeTax = (BigDecimal)parcel.readSerializable();
        mEstimatedTax = (BigDecimal)parcel.readSerializable();
        mEstimatedTaxCurrency = (Currency)parcel.readSerializable();
        mGiftWrapCharge = (BigDecimal)parcel.readSerializable();
        mGiftWrapChargeCurrency = (Currency)parcel.readSerializable();
        mShippingDiscount = (BigDecimal)parcel.readSerializable();
        mShippingDiscountCurrency = (Currency)parcel.readSerializable();
        mStateAndLocalFee = (BigDecimal)parcel.readSerializable();
        mStateAndLocalFeeCurrency = (Currency)parcel.readSerializable();
        mTotalSalesTaxAmount = (BigDecimal)parcel.readSerializable();
        mTotalSalesTaxCurrency = (Currency)parcel.readSerializable();
        mTotalShippingCharge = (BigDecimal)parcel.readSerializable();
        mTotalShippingChargeCurrency = (Currency)parcel.readSerializable();
        mTotalShippingTax = (BigDecimal)parcel.readSerializable();
        mTotalShippingTaxCurrency = (Currency)parcel.readSerializable();
    }


    public List a()
    {
        return mCancelledItemList;
    }

    public void a(int i1)
    {
        mQuantity = i1;
    }

    public void a(AppliedPayPalDetails appliedpaypaldetails)
    {
        mAppliedPayPalDetails = appliedpaypaldetails;
    }

    public void a(AppliedPaymentCard appliedpaymentcard)
    {
        mAppliedPaymentCard = appliedpaymentcard;
    }

    public void a(EmailDeliveryShipmentDetails emaildeliveryshipmentdetails)
    {
        mEmailDeliveryShipmentDetails = emaildeliveryshipmentdetails;
    }

    public void a(MobileDeliveryShipmentDetails mobiledeliveryshipmentdetails)
    {
        mMobileDeliveryShipmentDetails = mobiledeliveryshipmentdetails;
    }

    public void a(ShipHomeShipmentDetails shiphomeshipmentdetails)
    {
        mShipHomeShipmentDetails = shiphomeshipmentdetails;
    }

    public void a(StorePickUpShipmentDetails storepickupshipmentdetails)
    {
        mStorePickUpShipmentDetails = storepickupshipmentdetails;
    }

    public void a(String s)
    {
        mCustomerOrderNumber = s;
    }

    public void a(BigDecimal bigdecimal)
    {
        mGrandTotal = bigdecimal;
    }

    public void a(Currency currency)
    {
        mGrandTotalCurrency = currency;
    }

    public void a(Date date)
    {
        mOrderPlacedDate = date;
    }

    public void a(List list)
    {
        mCancelledItemList = list;
    }

    public void a(boolean flag)
    {
        mIsOrderCancellable = flag;
    }

    public e b()
    {
        return com.target.mothership.util.k.a(mShipHomeShipmentDetails);
    }

    public void b(String s)
    {
        mOrderStatus = s;
    }

    public void b(BigDecimal bigdecimal)
    {
        mSavings = bigdecimal;
    }

    public void b(Currency currency)
    {
        mSavingsCurrency = currency;
    }

    public void b(List list)
    {
        mAppliedGiftCardList = list;
    }

    public void b(boolean flag)
    {
        mIsReorderable = flag;
    }

    public e c()
    {
        return com.target.mothership.util.k.a(mStorePickUpShipmentDetails);
    }

    public void c(BigDecimal bigdecimal)
    {
        mSavingsPercent = bigdecimal;
    }

    public void c(Currency currency)
    {
        mTotalAdjustmentCurrency = currency;
    }

    public void c(List list)
    {
        mPromotions = list;
    }

    public void c(boolean flag)
    {
        mIsReturnable = flag;
    }

    public e d()
    {
        return com.target.mothership.util.k.a(mEmailDeliveryShipmentDetails);
    }

    public void d(BigDecimal bigdecimal)
    {
        mTotalAdjustment = bigdecimal;
    }

    public void d(Currency currency)
    {
        mTotalProductPriceCurrency = currency;
    }

    public void d(boolean flag)
    {
        mHasStorePickupItem = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        return com.target.mothership.util.k.a(mMobileDeliveryShipmentDetails);
    }

    public void e(BigDecimal bigdecimal)
    {
        mTotalProductPrice = bigdecimal;
    }

    public void e(Currency currency)
    {
        mHandlingFeeDiscountCurrency = currency;
    }

    public void e(boolean flag)
    {
        mIsEligibleToChangeStorePickupInfo = flag;
    }

    public e f()
    {
        return com.target.mothership.util.k.a(mAppliedPaymentCard);
    }

    public void f(BigDecimal bigdecimal)
    {
        mHandlingFee = bigdecimal;
    }

    public void f(Currency currency)
    {
        mEstimatedTaxCurrency = currency;
    }

    public void f(boolean flag)
    {
        mIsStorePickUpExtendPossible = flag;
    }

    public List g()
    {
        return mAppliedGiftCardList;
    }

    public void g(BigDecimal bigdecimal)
    {
        mHandlingFeeDiscount = bigdecimal;
    }

    public void g(Currency currency)
    {
        mGiftWrapChargeCurrency = currency;
    }

    public e h()
    {
        return com.target.mothership.util.k.a(mAppliedPayPalDetails);
    }

    public void h(BigDecimal bigdecimal)
    {
        mHandlingFeeTax = bigdecimal;
    }

    public void h(Currency currency)
    {
        mShippingDiscountCurrency = currency;
    }

    public String i()
    {
        return mCustomerOrderNumber;
    }

    public void i(BigDecimal bigdecimal)
    {
        mEstimatedTax = bigdecimal;
    }

    public void i(Currency currency)
    {
        mStateAndLocalFeeCurrency = currency;
    }

    public Date j()
    {
        return mOrderPlacedDate;
    }

    public void j(BigDecimal bigdecimal)
    {
        mGiftWrapCharge = bigdecimal;
    }

    public void j(Currency currency)
    {
        mTotalSalesTaxCurrency = currency;
    }

    public BigDecimal k()
    {
        return mGrandTotal;
    }

    public void k(BigDecimal bigdecimal)
    {
        mShippingDiscount = bigdecimal;
    }

    public void k(Currency currency)
    {
        mTotalShippingChargeCurrency = currency;
    }

    public void l(BigDecimal bigdecimal)
    {
        mStateAndLocalFee = bigdecimal;
    }

    public void l(Currency currency)
    {
        mTotalShippingTaxCurrency = currency;
    }

    public void m(BigDecimal bigdecimal)
    {
        mTotalSalesTaxAmount = bigdecimal;
    }

    public void n(BigDecimal bigdecimal)
    {
        mTotalShippingCharge = bigdecimal;
    }

    public void o(BigDecimal bigdecimal)
    {
        mTotalShippingTax = bigdecimal;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        boolean flag = true;
        parcel.writeList(mCancelledItemList);
        parcel.writeParcelable(mShipHomeShipmentDetails, 0);
        parcel.writeParcelable(mStorePickUpShipmentDetails, 0);
        parcel.writeParcelable(mEmailDeliveryShipmentDetails, 0);
        parcel.writeParcelable(mMobileDeliveryShipmentDetails, 0);
        parcel.writeParcelable(mAppliedPaymentCard, 0);
        parcel.writeList(mAppliedGiftCardList);
        parcel.writeParcelable(mAppliedPayPalDetails, 0);
        parcel.writeString(mCustomerOrderNumber);
        byte byte0;
        long l1;
        if (mOrderPlacedDate != null)
        {
            l1 = mOrderPlacedDate.getTime();
        } else
        {
            l1 = -1L;
        }
        parcel.writeLong(l1);
        parcel.writeString(mOrderStatus);
        if (mIsOrderCancellable)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsReorderable)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsReturnable)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mHasStorePickupItem)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsEligibleToChangeStorePickupInfo)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsStorePickUpExtendPossible)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeInt(mQuantity);
        parcel.writeList(mPromotions);
        parcel.writeSerializable(mGrandTotal);
        parcel.writeSerializable(mGrandTotalCurrency);
        parcel.writeSerializable(mSavings);
        parcel.writeSerializable(mSavingsPercent);
        parcel.writeSerializable(mSavingsCurrency);
        parcel.writeSerializable(mTotalAdjustment);
        parcel.writeSerializable(mTotalAdjustmentCurrency);
        parcel.writeSerializable(mTotalProductPrice);
        parcel.writeSerializable(mTotalProductPriceCurrency);
        parcel.writeSerializable(mHandlingFee);
        parcel.writeSerializable(mHandlingFeeDiscount);
        parcel.writeSerializable(mHandlingFeeDiscountCurrency);
        parcel.writeSerializable(mHandlingFeeTax);
        parcel.writeSerializable(mEstimatedTax);
        parcel.writeSerializable(mEstimatedTaxCurrency);
        parcel.writeSerializable(mGiftWrapCharge);
        parcel.writeSerializable(mGiftWrapChargeCurrency);
        parcel.writeSerializable(mShippingDiscount);
        parcel.writeSerializable(mShippingDiscountCurrency);
        parcel.writeSerializable(mStateAndLocalFee);
        parcel.writeSerializable(mStateAndLocalFeeCurrency);
        parcel.writeSerializable(mTotalSalesTaxAmount);
        parcel.writeSerializable(mTotalSalesTaxCurrency);
        parcel.writeSerializable(mTotalShippingCharge);
        parcel.writeSerializable(mTotalShippingChargeCurrency);
        parcel.writeSerializable(mTotalShippingTax);
        parcel.writeSerializable(mTotalShippingTaxCurrency);
    }

}
