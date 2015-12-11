// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.AddToCart;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TGTAddToCart
    implements AddToCart
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAddToCart a(Parcel parcel)
        {
            return new TGTAddToCart(parcel);
        }

        public TGTAddToCart[] a(int i)
        {
            return new TGTAddToCart[i];
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
    public String mCartOrderId;
    public List mCartProducts;
    public BigDecimal mTotalAmount;
    public int mTotalQuantity;

    TGTAddToCart()
    {
    }

    private TGTAddToCart(Parcel parcel)
    {
        mCartOrderId = parcel.readString();
        mTotalQuantity = parcel.readInt();
        mTotalAmount = (BigDecimal)parcel.readSerializable();
        mCartProducts = new ArrayList();
        parcel.readList(mCartProducts, com/target/mothership/model/cart/handler/TGTAddToCart.getClassLoader());
    }


    public int a()
    {
        return mTotalQuantity;
    }

    public void a(int i)
    {
        mTotalQuantity = i;
    }

    public void a(String s)
    {
        mCartOrderId = s;
    }

    public void a(BigDecimal bigdecimal)
    {
        mTotalAmount = bigdecimal;
    }

    public void a(List list)
    {
        mCartProducts = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mCartOrderId);
        parcel.writeInt(mTotalQuantity);
        parcel.writeSerializable(mTotalAmount);
        parcel.writeList(mCartProducts);
    }

}
