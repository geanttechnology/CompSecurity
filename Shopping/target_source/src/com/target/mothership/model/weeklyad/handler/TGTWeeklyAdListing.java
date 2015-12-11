// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.weeklyad.ProductSlug;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListing;
import com.target.mothership.util.k;
import com.target.mothership.util.p;

class TGTWeeklyAdListing
    implements Parcelable, WeeklyAdListing
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTWeeklyAdListing a(Parcel parcel)
        {
            return new TGTWeeklyAdListing(parcel);
        }

        public TGTWeeklyAdListing[] a(int i)
        {
            return new TGTWeeklyAdListing[i];
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
    private String mDisplayPrice;
    private String mEyebrow;
    private String mImageUrl;
    private ProductSlug mProductSlug;
    private Tcin mTcin;
    private String mTitle;

    public TGTWeeklyAdListing()
    {
    }

    private TGTWeeklyAdListing(Parcel parcel)
    {
        mTitle = parcel.readString();
        mDisplayPrice = parcel.readString();
        mProductSlug = (ProductSlug)parcel.readParcelable(com/target/mothership/common/weeklyad/ProductSlug.getClassLoader());
        mTcin = (Tcin)parcel.readParcelable(com/target/mothership/common/product/Tcin.getClassLoader());
        mImageUrl = parcel.readString();
        mEyebrow = parcel.readString();
    }


    public String a()
    {
        return mTitle;
    }

    public String a(int i)
    {
        return p.a(mImageUrl, i);
    }

    public void a(Tcin tcin)
    {
        mTcin = tcin;
    }

    public void a(ProductSlug productslug)
    {
        mProductSlug = productslug;
    }

    public void a(String s)
    {
        mTitle = s;
    }

    public String b()
    {
        return mDisplayPrice;
    }

    public void b(String s)
    {
        mDisplayPrice = s;
    }

    public ProductSlug c()
    {
        return mProductSlug;
    }

    public void c(String s)
    {
        mImageUrl = s;
    }

    public e d()
    {
        return k.a(mTcin);
    }

    public void d(String s)
    {
        mEyebrow = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return mImageUrl;
    }

    public String f()
    {
        return mEyebrow;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mTitle);
        parcel.writeString(mDisplayPrice);
        parcel.writeParcelable(mProductSlug, i);
        parcel.writeParcelable(mTcin, i);
        parcel.writeString(mImageUrl);
        parcel.writeString(mEyebrow);
    }

}
