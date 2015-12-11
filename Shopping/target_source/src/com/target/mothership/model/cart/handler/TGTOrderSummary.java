// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.OrderSummary;
import com.target.mothership.util.c;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTCartSummary

public class TGTOrderSummary extends TGTCartSummary
    implements OrderSummary
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTOrderSummary a(Parcel parcel)
        {
            return new TGTOrderSummary(parcel);
        }

        public TGTOrderSummary[] a(int i)
        {
            return new TGTOrderSummary[i];
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
    private List mAppliedPromoCodes;
    private String mCustomerOrderId;
    private BigDecimal mEstimatedTax;
    private Currency mEstimatedTaxCurrency;
    private BigDecimal mGiftWrapCharge;
    private Currency mGiftWrapChargeCurrency;
    private boolean mHasTaxError;
    private boolean mIsFreeShipping;
    private boolean mIsRedCardDiscountApplied;
    private BigDecimal mShippingDiscount;
    private Currency mShippingDiscountCurrency;
    private BigDecimal mStateAndLocalFee;
    private Currency mStateAndLocalFeeCurrency;
    private String mTaxError;
    private BigDecimal mTeamMemberDiscount;
    private Currency mTeamMemberDiscountCurrency;
    private String mTeamMemberNumber;
    private BigDecimal mTotalSalesTax;
    private Currency mTotalSalesTaxCurrency;
    private BigDecimal mTotalShippingCharge;
    private Currency mTotalShippingChargeCurrency;
    private BigDecimal mTotalShippingTax;
    private Currency mTotalShippingTaxCurrency;

    TGTOrderSummary()
    {
    }

    TGTOrderSummary(Parcel parcel)
    {
        boolean flag1 = true;
        super(parcel);
        mCustomerOrderId = parcel.readString();
        mEstimatedTax = (BigDecimal)parcel.readSerializable();
        mEstimatedTaxCurrency = (Currency)parcel.readSerializable();
        mGiftWrapCharge = (BigDecimal)parcel.readSerializable();
        mGiftWrapChargeCurrency = (Currency)parcel.readSerializable();
        mShippingDiscount = (BigDecimal)parcel.readSerializable();
        mShippingDiscountCurrency = (Currency)parcel.readSerializable();
        mStateAndLocalFee = (BigDecimal)parcel.readSerializable();
        mStateAndLocalFeeCurrency = (Currency)parcel.readSerializable();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHasTaxError = flag;
        mTaxError = parcel.readString();
        mTotalSalesTax = (BigDecimal)parcel.readSerializable();
        mTotalSalesTaxCurrency = (Currency)parcel.readSerializable();
        mTotalShippingCharge = (BigDecimal)parcel.readSerializable();
        mTotalShippingChargeCurrency = (Currency)parcel.readSerializable();
        mTotalShippingTax = (BigDecimal)parcel.readSerializable();
        mTotalShippingTaxCurrency = (Currency)parcel.readSerializable();
        mTeamMemberDiscount = (BigDecimal)parcel.readSerializable();
        mTeamMemberDiscountCurrency = (Currency)parcel.readSerializable();
        mTeamMemberNumber = parcel.readString();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsFreeShipping = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsRedCardDiscountApplied = flag;
        mAppliedPromoCodes = new ArrayList();
        parcel.readList(mAppliedPromoCodes, com/target/mothership/model/cart/handler/TGTOrderSummary.getClassLoader());
    }

    public void A(String s1)
    {
        mTaxError = s1;
    }

    public void B(String s1)
    {
        if (s1 != null)
        {
            s1 = new BigDecimal(s1);
        } else
        {
            s1 = c.ZERO;
        }
        mTotalShippingCharge = s1;
    }

    public void C(String s1)
    {
        if (s1 != null)
        {
            s1 = Currency.getInstance(s1);
        } else
        {
            s1 = c.USD;
        }
        mTotalShippingChargeCurrency = s1;
    }

    public void D(String s1)
    {
        if (s1 != null)
        {
            s1 = new BigDecimal(s1);
        } else
        {
            s1 = c.ZERO;
        }
        mTotalShippingTax = s1;
    }

    public void E(String s1)
    {
        if (s1 != null)
        {
            s1 = Currency.getInstance(s1);
        } else
        {
            s1 = c.USD;
        }
        mTotalShippingTaxCurrency = s1;
    }

    public void F(String s1)
    {
        if (s1 != null)
        {
            s1 = new BigDecimal(s1);
        } else
        {
            s1 = c.ZERO;
        }
        mTotalSalesTax = s1;
    }

    public void G(String s1)
    {
        if (s1 != null)
        {
            s1 = Currency.getInstance(s1);
        } else
        {
            s1 = c.USD;
        }
        mTotalSalesTaxCurrency = s1;
    }

    public void H(String s1)
    {
        if (s1 != null)
        {
            s1 = new BigDecimal(s1);
        } else
        {
            s1 = c.ZERO;
        }
        mTeamMemberDiscount = s1;
    }

    public void I(String s1)
    {
        if (s1 != null)
        {
            s1 = Currency.getInstance(s1);
        } else
        {
            s1 = c.USD;
        }
        mTeamMemberDiscountCurrency = s1;
    }

    public void J(String s1)
    {
        mTeamMemberNumber = s1;
    }

    public int b()
    {
        return super.b();
    }

    public void d(boolean flag)
    {
        mHasTaxError = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public void e(List list)
    {
        mAppliedPromoCodes = list;
    }

    public void e(boolean flag)
    {
        mIsFreeShipping = flag;
    }

    public void f(boolean flag)
    {
        mIsRedCardDiscountApplied = flag;
    }

    public boolean q()
    {
        return mHasTaxError;
    }

    public String r()
    {
        return mCustomerOrderId;
    }

    public void r(String s1)
    {
        mCustomerOrderId = s1;
    }

    public List s()
    {
        if (mAppliedPromoCodes == null)
        {
            return Collections.emptyList();
        } else
        {
            return mAppliedPromoCodes;
        }
    }

    public void s(String s1)
    {
        if (s1 != null)
        {
            s1 = new BigDecimal(s1);
        } else
        {
            s1 = c.ZERO;
        }
        mEstimatedTax = s1;
    }

    public BigDecimal t()
    {
        return mEstimatedTax;
    }

    public void t(String s1)
    {
        if (s1 != null)
        {
            s1 = Currency.getInstance(s1);
        } else
        {
            s1 = c.USD;
        }
        mEstimatedTaxCurrency = s1;
    }

    public Currency u()
    {
        return mEstimatedTaxCurrency;
    }

    public void u(String s1)
    {
        if (s1 != null)
        {
            s1 = new BigDecimal(s1);
        } else
        {
            s1 = c.ZERO;
        }
        mGiftWrapCharge = s1;
    }

    public BigDecimal v()
    {
        return mStateAndLocalFee;
    }

    public void v(String s1)
    {
        if (s1 != null)
        {
            s1 = Currency.getInstance(s1);
        } else
        {
            s1 = c.USD;
        }
        mGiftWrapChargeCurrency = s1;
    }

    public BigDecimal w()
    {
        return mTotalShippingCharge;
    }

    public void w(String s1)
    {
        if (s1 != null)
        {
            s1 = new BigDecimal(s1);
        } else
        {
            s1 = c.ZERO;
        }
        mShippingDiscount = s1;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        super.writeToParcel(parcel, i);
        parcel.writeString(mCustomerOrderId);
        parcel.writeSerializable(mEstimatedTax);
        parcel.writeSerializable(mEstimatedTaxCurrency);
        parcel.writeSerializable(mGiftWrapCharge);
        parcel.writeSerializable(mGiftWrapChargeCurrency);
        parcel.writeSerializable(mShippingDiscount);
        parcel.writeSerializable(mShippingDiscountCurrency);
        parcel.writeSerializable(mStateAndLocalFee);
        parcel.writeSerializable(mStateAndLocalFeeCurrency);
        byte byte0;
        if (mHasTaxError)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(mTaxError);
        parcel.writeSerializable(mTotalSalesTax);
        parcel.writeSerializable(mTotalSalesTaxCurrency);
        parcel.writeSerializable(mTotalShippingCharge);
        parcel.writeSerializable(mTotalShippingChargeCurrency);
        parcel.writeSerializable(mTotalShippingTax);
        parcel.writeSerializable(mTotalShippingTaxCurrency);
        parcel.writeSerializable(mTeamMemberDiscount);
        parcel.writeSerializable(mTeamMemberDiscountCurrency);
        parcel.writeString(mTeamMemberNumber);
        if (mIsFreeShipping)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsRedCardDiscountApplied)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeList(mAppliedPromoCodes);
    }

    public Currency x()
    {
        return mTotalShippingChargeCurrency;
    }

    public void x(String s1)
    {
        if (s1 != null)
        {
            s1 = Currency.getInstance(s1);
        } else
        {
            s1 = c.USD;
        }
        mShippingDiscountCurrency = s1;
    }

    public String y()
    {
        return mTeamMemberNumber;
    }

    public void y(String s1)
    {
        if (s1 != null)
        {
            s1 = new BigDecimal(s1);
        } else
        {
            s1 = c.ZERO;
        }
        mStateAndLocalFee = s1;
    }

    public void z(String s1)
    {
        if (s1 != null)
        {
            s1 = Currency.getInstance(s1);
        } else
        {
            s1 = c.USD;
        }
        mStateAndLocalFeeCurrency = s1;
    }

}
