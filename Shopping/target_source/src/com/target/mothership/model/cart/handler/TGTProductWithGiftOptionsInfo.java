// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.ProductWithGiftOptionsInfo;
import com.target.mothership.model.product.handler.TGTProduct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class TGTProductWithGiftOptionsInfo extends TGTProduct
    implements ProductWithGiftOptionsInfo
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductWithGiftOptionsInfo a(Parcel parcel)
        {
            return new TGTProductWithGiftOptionsInfo(parcel);
        }

        public TGTProductWithGiftOptionsInfo[] a(int i)
        {
            return new TGTProductWithGiftOptionsInfo[i];
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
    private String mDescription;
    private String mGiftMessage;
    private BigDecimal mGiftWrapCharge;
    private Currency mGiftWrapChargeCurrency;
    private List mImages;
    private boolean mIsEligibleForGiftWrap;
    private boolean mIsGiftWrapped;
    private BigDecimal mPrice;
    private String mProductId;
    private int mQuantity;

    TGTProductWithGiftOptionsInfo()
    {
    }

    private TGTProductWithGiftOptionsInfo(Parcel parcel)
    {
        boolean flag1 = true;
        super(parcel);
        mProductId = parcel.readString();
        mImages = new ArrayList();
        parcel.readList(mImages, com/target/mothership/model/cart/handler/TGTProductWithGiftOptionsInfo.getClassLoader());
        mDescription = parcel.readString();
        mPrice = (BigDecimal)parcel.readSerializable();
        mQuantity = parcel.readInt();
        mGiftMessage = parcel.readString();
        mGiftWrapCharge = (BigDecimal)parcel.readSerializable();
        mGiftWrapChargeCurrency = (Currency)parcel.readSerializable();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsEligibleForGiftWrap = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsGiftWrapped = flag;
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        super.writeToParcel(parcel, i);
        parcel.writeString(mProductId);
        parcel.writeList(mImages);
        parcel.writeString(mDescription);
        parcel.writeSerializable(mPrice);
        parcel.writeInt(mQuantity);
        parcel.writeString(mGiftMessage);
        parcel.writeSerializable(mGiftWrapCharge);
        parcel.writeSerializable(mGiftWrapChargeCurrency);
        byte byte0;
        if (mIsEligibleForGiftWrap)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsGiftWrapped)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
    }

}
