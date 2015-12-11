// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductVariationDimensions;
import com.target.mothership.model.product.interfaces.ProductVariationSummary;
import com.target.mothership.util.k;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TGTProductVariationSummary
    implements ProductVariationSummary
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductVariationSummary a(Parcel parcel)
        {
            return new TGTProductVariationSummary(parcel);
        }

        public TGTProductVariationSummary[] a(int i)
        {
            return new TGTProductVariationSummary[i];
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
    private List mDimension01;
    private List mDimension02;
    private List mImageUrls;
    private ProductVariationDimensions mProductVariationDimension;

    TGTProductVariationSummary()
    {
    }

    private TGTProductVariationSummary(Parcel parcel)
    {
        mImageUrls = new ArrayList();
        parcel.readList(mImageUrls, java/net/URL.getClassLoader());
        mDimension01 = new ArrayList();
        parcel.readList(mDimension01, java/lang/String.getClassLoader());
        mDimension02 = new ArrayList();
        parcel.readList(mDimension02, java/lang/String.getClassLoader());
        mProductVariationDimension = (ProductVariationDimensions)parcel.readParcelable(com/target/mothership/model/product/interfaces/ProductVariationDimensions.getClassLoader());
    }


    public List a()
    {
        return k.a(mImageUrls);
    }

    public void a(ProductVariationDimensions productvariationdimensions)
    {
        mProductVariationDimension = productvariationdimensions;
    }

    public void a(List list)
    {
        mImageUrls = list;
    }

    public List b()
    {
        return k.a(mDimension01);
    }

    public void b(List list)
    {
        mDimension01 = list;
    }

    public List c()
    {
        return k.a(mDimension02);
    }

    public void c(List list)
    {
        mDimension02 = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(mImageUrls);
        parcel.writeList(mDimension01);
        parcel.writeList(mDimension02);
        parcel.writeParcelable(mProductVariationDimension, 0);
    }

}
