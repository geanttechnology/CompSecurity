// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductSummary;
import com.target.mothership.model.product.interfaces.ProductSummaryWrapper;
import com.target.mothership.services.z;

public class TGTProductSummaryWrapper
    implements ProductSummaryWrapper
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductSummaryWrapper a(Parcel parcel)
        {
            return new TGTProductSummaryWrapper(parcel);
        }

        public TGTProductSummaryWrapper[] a(int i)
        {
            return new TGTProductSummaryWrapper[i];
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
    private ProductSummary mProductSummary;
    private z mResponseCode;

    TGTProductSummaryWrapper()
    {
    }

    private TGTProductSummaryWrapper(Parcel parcel)
    {
        int i = parcel.readInt();
        z z1;
        if (i == -1)
        {
            z1 = null;
        } else
        {
            z1 = mResponseCode;
            z1 = z.values()[i];
        }
        mResponseCode = z1;
        mProductSummary = (ProductSummary)parcel.readParcelable(com/target/mothership/model/product/interfaces/ProductSummary.getClassLoader());
    }


    public ProductSummary a()
    {
        return mProductSummary;
    }

    public void a(ProductSummary productsummary)
    {
        mProductSummary = productsummary;
    }

    public void a(z z1)
    {
        mResponseCode = z1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mResponseCode == null)
        {
            i = -1;
        } else
        {
            i = mResponseCode.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeParcelable(mProductSummary, 0);
    }

}
