// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.product.CatEntryId;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingVariationItem;
import com.target.mothership.util.k;

class TGTWeeklyAdListingVariationItem
    implements Parcelable, WeeklyAdListingVariationItem
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTWeeklyAdListingVariationItem a(Parcel parcel)
        {
            return new TGTWeeklyAdListingVariationItem(parcel);
        }

        public TGTWeeklyAdListingVariationItem[] a(int i)
        {
            return new TGTWeeklyAdListingVariationItem[i];
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
    private CatEntryId mCatEntryId;
    private String mColor;
    private Dpci mDpci;
    private String mImage;
    private String mPrice;
    private String mPriceLabel;
    private String mPriceMessage;
    private String mSize;
    private Tcin mTcin;

    public TGTWeeklyAdListingVariationItem()
    {
    }

    private TGTWeeklyAdListingVariationItem(Parcel parcel)
    {
        mPrice = parcel.readString();
        mPriceLabel = parcel.readString();
        mPriceMessage = parcel.readString();
        mTcin = (Tcin)parcel.readParcelable(com/target/mothership/common/product/Tcin.getClassLoader());
        mDpci = (Dpci)parcel.readParcelable(com/target/mothership/common/product/Dpci.getClassLoader());
        mCatEntryId = (CatEntryId)parcel.readParcelable(com/target/mothership/common/product/CatEntryId.getClassLoader());
        mColor = parcel.readString();
        mSize = parcel.readString();
        mImage = parcel.readString();
    }


    public String a()
    {
        return mPrice;
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

    public void a(String s)
    {
        mPrice = s;
    }

    public e b()
    {
        return k.a(mColor);
    }

    public void b(String s)
    {
        mPriceLabel = s;
    }

    public e c()
    {
        return k.a(mSize);
    }

    public void c(String s)
    {
        mPriceMessage = s;
    }

    public void d(String s)
    {
        mColor = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void e(String s)
    {
        mSize = s;
    }

    public void f(String s)
    {
        mImage = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mPrice);
        parcel.writeString(mPriceLabel);
        parcel.writeString(mPriceMessage);
        parcel.writeParcelable(mTcin, i);
        parcel.writeParcelable(mDpci, i);
        parcel.writeParcelable(mCatEntryId, i);
        parcel.writeString(mColor);
        parcel.writeString(mSize);
        parcel.writeString(mImage);
    }

}
