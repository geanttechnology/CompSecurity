// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.common.a.b;
import com.target.mothership.common.a.f;
import com.target.mothership.model.cart.interfaces.FreeProduct;
import com.target.mothership.model.product.handler.TGTProduct;
import com.target.mothership.util.c;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class TGTFreeProduct extends TGTProduct
    implements FreeProduct
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTFreeProduct a(Parcel parcel)
        {
            return new TGTFreeProduct(parcel);
        }

        public TGTFreeProduct[] a(int i)
        {
            return new TGTFreeProduct[i];
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
    private Currency mCurrency;
    private b mDeliveryMethod;
    private String mExpectedDeliveryDateString;
    private f mFulfillmentType;
    private List mImages;
    private boolean mIsGiftCard;
    private BigDecimal mPrice;
    private int mQuantity;

    TGTFreeProduct()
    {
    }

    public TGTFreeProduct(Parcel parcel)
    {
        Object obj1 = null;
        super(parcel);
        mImages = new ArrayList();
        parcel.readList(mImages, com/target/mothership/model/cart/handler/TGTFreeProduct.getClassLoader());
        mExpectedDeliveryDateString = parcel.readString();
        mCurrency = (Currency)parcel.readSerializable();
        mPrice = (BigDecimal)parcel.readSerializable();
        int i = parcel.readInt();
        Object obj;
        boolean flag;
        if (i == -1)
        {
            obj = null;
        } else
        {
            obj = f.values()[i];
        }
        mFulfillmentType = ((f) (obj));
        i = parcel.readInt();
        if (i == -1)
        {
            obj = obj1;
        } else
        {
            obj = com.target.mothership.common.a.b.values()[i];
        }
        mDeliveryMethod = ((b) (obj));
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsGiftCard = flag;
        mQuantity = parcel.readInt();
    }

    public List a()
    {
        return mImages;
    }

    public void a(b b1)
    {
        mDeliveryMethod = b1;
    }

    public void a(f f1)
    {
        mFulfillmentType = f1;
    }

    public void a(String s)
    {
        if (s == null)
        {
            mQuantity = 0;
            return;
        } else
        {
            mQuantity = Double.valueOf(s).intValue();
            return;
        }
    }

    public void a(List list)
    {
        mImages = list;
    }

    public void a(boolean flag)
    {
        mIsGiftCard = flag;
    }

    public BigDecimal b()
    {
        return mPrice;
    }

    public void b(String s)
    {
        mExpectedDeliveryDateString = s;
    }

    public b c()
    {
        return mDeliveryMethod;
    }

    public void c(String s)
    {
        if (s != null)
        {
            s = Currency.getInstance(s);
        } else
        {
            s = c.USD;
        }
        mCurrency = s;
    }

    public int d()
    {
        return mQuantity;
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
        mPrice = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte byte1 = -1;
        super.writeToParcel(parcel, i);
        parcel.writeList(mImages);
        parcel.writeString(mExpectedDeliveryDateString);
        parcel.writeSerializable(mCurrency);
        parcel.writeSerializable(mPrice);
        byte byte0;
        if (mFulfillmentType == null)
        {
            i = -1;
        } else
        {
            i = mFulfillmentType.ordinal();
        }
        parcel.writeInt(i);
        if (mDeliveryMethod == null)
        {
            i = byte1;
        } else
        {
            i = mDeliveryMethod.ordinal();
        }
        parcel.writeInt(i);
        if (mIsGiftCard)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeInt(mQuantity);
    }

}
