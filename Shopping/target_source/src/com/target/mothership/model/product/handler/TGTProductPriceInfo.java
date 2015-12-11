// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.product.n;
import com.target.mothership.model.product.interfaces.ProductPrice;
import com.target.mothership.model.product.interfaces.ProductPriceInfo;
import com.target.mothership.model.product.interfaces.ProductPriceRange;
import com.target.mothership.util.k;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductPrice, TGTProductPriceRange

public class TGTProductPriceInfo
    implements ProductPriceInfo
{

    private n mPriceType;
    private ProductPrice mProductPrice;
    private ProductPriceRange mProductPriceRange;

    TGTProductPriceInfo()
    {
    }

    TGTProductPriceInfo(Parcel parcel)
    {
        int l = parcel.readInt();
        n n1;
        if (l == -1)
        {
            n1 = null;
        } else
        {
            n1 = n.values()[l];
        }
        mPriceType = n1;
        mProductPrice = (ProductPrice)parcel.readParcelable(com/target/mothership/model/product/handler/TGTProductPrice.getClassLoader());
        mProductPriceRange = (ProductPriceRange)parcel.readParcelable(com/target/mothership/model/product/handler/TGTProductPriceRange.getClassLoader());
    }

    public void a(n n1)
    {
        mPriceType = n1;
    }

    public void a(ProductPrice productprice)
    {
        mProductPrice = productprice;
    }

    public void a(ProductPriceRange productpricerange)
    {
        mProductPriceRange = productpricerange;
    }

    public boolean a()
    {
        return false;
    }

    public int describeContents()
    {
        return 0;
    }

    public n i()
    {
        return mPriceType;
    }

    public e j()
    {
        return com.target.mothership.util.k.a(mProductPrice);
    }

    public e k()
    {
        return com.target.mothership.util.k.a(mProductPriceRange);
    }

    public void writeToParcel(Parcel parcel, int l)
    {
        if (mPriceType == null)
        {
            l = -1;
        } else
        {
            l = mPriceType.ordinal();
        }
        parcel.writeInt(l);
        parcel.writeParcelable(mProductPrice, 0);
        parcel.writeParcelable(mProductPriceRange, 0);
    }
}
