// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.product.CatEntryId;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.cart.interfaces.SaveForLaterProduct;
import com.target.mothership.model.common.OrderProductImage;
import java.math.BigDecimal;

class TGTSaveForLaterProduct
    implements SaveForLaterProduct
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTSaveForLaterProduct a(Parcel parcel)
        {
            return new TGTSaveForLaterProduct(parcel);
        }

        public TGTSaveForLaterProduct[] a(int j)
        {
            return new TGTSaveForLaterProduct[j];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int j)
        {
            return a(j);
        }

    };
    private CatEntryId mCatEntryId;
    private Dpci mDpci;
    private boolean mIsInventoryAvailable;
    private String mOrderItemId;
    private OrderProductImage mOrderProductImage;
    private Tcin mParentTcin;
    private BigDecimal mPrice;
    private Tcin mTcin;
    private String mTitle;

    public TGTSaveForLaterProduct()
    {
    }

    public TGTSaveForLaterProduct(Parcel parcel)
    {
        mCatEntryId = (CatEntryId)parcel.readParcelable(com/target/mothership/common/product/CatEntryId.getClassLoader());
        mDpci = (Dpci)parcel.readParcelable(com/target/mothership/common/product/Dpci.getClassLoader());
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsInventoryAvailable = flag;
        mOrderProductImage = (OrderProductImage)parcel.readParcelable(com/target/mothership/model/common/OrderProductImage.getClassLoader());
        mOrderItemId = parcel.readString();
        mParentTcin = (Tcin)parcel.readParcelable(com/target/mothership/common/product/Tcin.getClassLoader());
        mPrice = (BigDecimal)parcel.readSerializable();
        mTcin = (Tcin)parcel.readParcelable(com/target/mothership/common/product/Tcin.getClassLoader());
        mTitle = parcel.readString();
    }

    public OrderProductImage a()
    {
        return mOrderProductImage;
    }

    public void a(CatEntryId catentryid)
    {
        mCatEntryId = catentryid;
    }

    public void a(Dpci dpci)
    {
        mDpci = dpci;
    }

    public void a(Tcin tcin)
    {
        mTcin = tcin;
    }

    public void a(OrderProductImage orderproductimage)
    {
        mOrderProductImage = orderproductimage;
    }

    public void a(String s)
    {
        mOrderItemId = s;
    }

    public void a(BigDecimal bigdecimal)
    {
        mPrice = bigdecimal;
    }

    public void a(boolean flag)
    {
        mIsInventoryAvailable = flag;
    }

    public String b()
    {
        return mOrderItemId;
    }

    public void b(Tcin tcin)
    {
        mParentTcin = tcin;
    }

    public void b(String s)
    {
        mTitle = s;
    }

    public BigDecimal c()
    {
        return mPrice;
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        return com.google.a.a.e.c(mDpci);
    }

    public e f()
    {
        return com.google.a.a.e.c(mCatEntryId);
    }

    public String g()
    {
        return mTitle;
    }

    public e h()
    {
        return com.google.a.a.e.c(mParentTcin);
    }

    public boolean i()
    {
        return mIsInventoryAvailable;
    }

    public Tcin k_()
    {
        return mTcin;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        parcel.writeParcelable(mCatEntryId, j);
        parcel.writeParcelable(mDpci, j);
        byte byte0;
        if (mIsInventoryAvailable)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeParcelable(mOrderProductImage, j);
        parcel.writeString(mOrderItemId);
        parcel.writeParcelable(mParentTcin, j);
        parcel.writeSerializable(mPrice);
        parcel.writeParcelable(mTcin, j);
        parcel.writeString(mTitle);
    }

}
