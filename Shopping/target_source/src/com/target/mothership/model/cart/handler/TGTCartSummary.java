// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.CartSummary;
import com.target.mothership.util.c;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class TGTCartSummary
    implements CartSummary
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCartSummary a(Parcel parcel)
        {
            return new TGTCartSummary(parcel);
        }

        public TGTCartSummary[] a(int i1)
        {
            return new TGTCartSummary[i1];
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
    private List mCartMessages;
    private BigDecimal mGrandTotal;
    private Currency mGrandTotalCurrency;
    private BigDecimal mHandlingFee;
    private BigDecimal mHandlingFeeDiscount;
    private Currency mHandlingFeeDiscountCurrency;
    private BigDecimal mHandlingFeeTax;
    private String mOrderId;
    private List mPromotions;
    private int mQuantity;
    private BigDecimal mSavings;
    private Currency mSavingsCurrency;
    private BigDecimal mSavingsPercent;
    private Currency mTotalAdjustmentCurrency;
    private BigDecimal mTotalAdjustments;
    private BigDecimal mTotalProductPrice;
    private Currency mTotalProductPriceCurrency;

    TGTCartSummary()
    {
    }

    TGTCartSummary(Parcel parcel)
    {
        mPromotions = new ArrayList();
        parcel.readList(mPromotions, com/target/mothership/model/cart/handler/TGTCartSummary.getClassLoader());
        mGrandTotal = (BigDecimal)parcel.readSerializable();
        mGrandTotalCurrency = (Currency)parcel.readSerializable();
        mHandlingFee = (BigDecimal)parcel.readSerializable();
        mHandlingFeeDiscount = (BigDecimal)parcel.readSerializable();
        mHandlingFeeDiscountCurrency = (Currency)parcel.readSerializable();
        mHandlingFeeTax = (BigDecimal)parcel.readSerializable();
        mSavings = (BigDecimal)parcel.readSerializable();
        mSavingsCurrency = (Currency)parcel.readSerializable();
        mSavingsPercent = (BigDecimal)parcel.readSerializable();
        mTotalAdjustments = (BigDecimal)parcel.readSerializable();
        mTotalAdjustmentCurrency = (Currency)parcel.readSerializable();
        mTotalProductPrice = (BigDecimal)parcel.readSerializable();
        mTotalProductPriceCurrency = (Currency)parcel.readSerializable();
        mQuantity = parcel.readInt();
        mOrderId = parcel.readString();
        mCartMessages = new ArrayList();
        parcel.readList(mCartMessages, com/target/mothership/model/cart/handler/TGTCartSummary.getClassLoader());
    }

    public String a()
    {
        return mOrderId;
    }

    public void a(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mGrandTotal = s;
    }

    public void a(List list)
    {
        mPromotions = list;
    }

    public int b()
    {
        return mQuantity;
    }

    public void b(String s)
    {
        if (s != null)
        {
            s = Currency.getInstance(s);
        } else
        {
            s = c.USD;
        }
        mGrandTotalCurrency = s;
    }

    public void b(List list)
    {
        mCartMessages = list;
    }

    public BigDecimal c()
    {
        return mGrandTotal;
    }

    public void c(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mHandlingFee = s;
    }

    public Currency d()
    {
        return mGrandTotalCurrency;
    }

    public void d(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mHandlingFeeDiscount = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public BigDecimal e()
    {
        return mHandlingFee;
    }

    public void e(String s)
    {
        if (s != null)
        {
            s = Currency.getInstance(s);
        } else
        {
            s = c.USD;
        }
        mHandlingFeeDiscountCurrency = s;
    }

    public BigDecimal f()
    {
        return mHandlingFeeDiscount;
    }

    public void f(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mHandlingFeeTax = s;
    }

    public BigDecimal g()
    {
        return mSavings;
    }

    public void g(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mSavings = s;
    }

    public BigDecimal h()
    {
        return mTotalAdjustments;
    }

    public void h(String s)
    {
        if (s != null)
        {
            s = Currency.getInstance(s);
        } else
        {
            s = c.USD;
        }
        mSavingsCurrency = s;
    }

    public BigDecimal i()
    {
        return mTotalProductPrice;
    }

    public void i(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mSavingsPercent = s;
    }

    public Currency j()
    {
        return mTotalProductPriceCurrency;
    }

    public void j(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mTotalAdjustments = s;
    }

    public void k(String s)
    {
        if (s != null)
        {
            s = Currency.getInstance(s);
        } else
        {
            s = c.USD;
        }
        mTotalAdjustmentCurrency = s;
    }

    public void l(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mTotalProductPrice = s;
    }

    public void m(String s)
    {
        if (s != null)
        {
            s = Currency.getInstance(s);
        } else
        {
            s = c.USD;
        }
        mTotalProductPriceCurrency = s;
    }

    public void n(String s)
    {
        int i1;
        if (s != null)
        {
            i1 = Double.valueOf(s).intValue();
        } else
        {
            i1 = 0;
        }
        mQuantity = i1;
    }

    public void o(String s)
    {
        mOrderId = s;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeList(mPromotions);
        parcel.writeSerializable(mGrandTotal);
        parcel.writeSerializable(mGrandTotalCurrency);
        parcel.writeSerializable(mHandlingFee);
        parcel.writeSerializable(mHandlingFeeDiscount);
        parcel.writeSerializable(mHandlingFeeDiscountCurrency);
        parcel.writeSerializable(mHandlingFeeTax);
        parcel.writeSerializable(mSavings);
        parcel.writeSerializable(mSavingsCurrency);
        parcel.writeSerializable(mSavingsPercent);
        parcel.writeSerializable(mTotalAdjustments);
        parcel.writeSerializable(mTotalAdjustmentCurrency);
        parcel.writeSerializable(mTotalProductPrice);
        parcel.writeSerializable(mTotalProductPriceCurrency);
        parcel.writeInt(mQuantity);
        parcel.writeString(mOrderId);
        parcel.writeList(mCartMessages);
    }

}
