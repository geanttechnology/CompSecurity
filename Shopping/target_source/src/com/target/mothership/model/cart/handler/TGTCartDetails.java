// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.mothership.util.c;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class TGTCartDetails
    implements CartDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCartDetails a(Parcel parcel)
        {
            return new TGTCartDetails(parcel);
        }

        public TGTCartDetails[] a(int i)
        {
            return new TGTCartDetails[i];
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
    private List mCartMessages;
    private String mCartOrderId;
    private List mCartProducts;
    private List mCartPromotions;
    private int mCartQuantity;
    private BigDecimal mGrandTotal;
    private Currency mGrandTotalCurrency;
    private BigDecimal mTotalProductPrice;
    private Currency mTotalProductPriceCurrency;

    TGTCartDetails()
    {
    }

    private TGTCartDetails(Parcel parcel)
    {
        mCartOrderId = parcel.readString();
        mCartPromotions = new ArrayList();
        parcel.readList(mCartPromotions, com/target/mothership/model/cart/handler/TGTCartDetails.getClassLoader());
        mCartProducts = new ArrayList();
        parcel.readList(mCartProducts, com/target/mothership/model/cart/handler/TGTCartDetails.getClassLoader());
        mCartQuantity = parcel.readInt();
        mTotalProductPrice = (BigDecimal)parcel.readSerializable();
        mTotalProductPriceCurrency = (Currency)parcel.readSerializable();
        mGrandTotal = (BigDecimal)parcel.readSerializable();
        mGrandTotalCurrency = (Currency)parcel.readSerializable();
        mCartMessages = new ArrayList();
        parcel.readList(mCartMessages, com/target/mothership/model/cart/handler/TGTCartDetails.getClassLoader());
    }


    public List a()
    {
        return mCartProducts;
    }

    public void a(String s)
    {
        mCartOrderId = s;
    }

    public void a(List list)
    {
        mCartProducts = list;
    }

    public int b()
    {
        return mCartQuantity;
    }

    public void b(String s)
    {
        if (s == null)
        {
            mCartQuantity = 0;
            return;
        } else
        {
            mCartQuantity = Double.valueOf(s).intValue();
            return;
        }
    }

    public void b(List list)
    {
        mCartPromotions = list;
    }

    public BigDecimal c()
    {
        return mTotalProductPrice;
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
        mGrandTotal = s;
    }

    public void c(List list)
    {
        mCartMessages = list;
    }

    public BigDecimal d()
    {
        return mGrandTotal;
    }

    public void d(String s)
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

    public int describeContents()
    {
        return 0;
    }

    public List e()
    {
        return mCartMessages;
    }

    public void e(String s)
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

    public void f(String s)
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

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mCartOrderId);
        parcel.writeList(mCartPromotions);
        parcel.writeList(mCartProducts);
        parcel.writeInt(mCartQuantity);
        parcel.writeSerializable(mTotalProductPrice);
        parcel.writeSerializable(mTotalProductPriceCurrency);
        parcel.writeSerializable(mGrandTotal);
        parcel.writeSerializable(mGrandTotalCurrency);
        parcel.writeList(mCartMessages);
    }

}
