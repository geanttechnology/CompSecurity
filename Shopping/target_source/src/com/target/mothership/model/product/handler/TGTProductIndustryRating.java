// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductEsrbRating;
import com.target.mothership.model.product.interfaces.ProductIndustryRating;
import com.target.mothership.model.product.interfaces.ProductMpaaRating;
import com.target.mothership.model.product.interfaces.ProductRiaaRating;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductRiaaRating, TGTProductMpaaRating, TGTProductEsrbRating

public class TGTProductIndustryRating
    implements ProductIndustryRating
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductIndustryRating a(Parcel parcel)
        {
            return new TGTProductIndustryRating(parcel);
        }

        public TGTProductIndustryRating[] a(int i)
        {
            return new TGTProductIndustryRating[i];
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
    private ProductEsrbRating mEsrbRating;
    private ProductMpaaRating mMpaaRating;
    private ProductRiaaRating mRiaaRating;

    TGTProductIndustryRating()
    {
    }

    private TGTProductIndustryRating(Parcel parcel)
    {
        mRiaaRating = (ProductRiaaRating)parcel.readParcelable(com/target/mothership/model/product/handler/TGTProductRiaaRating.getClassLoader());
        mMpaaRating = (ProductMpaaRating)parcel.readParcelable(com/target/mothership/model/product/handler/TGTProductMpaaRating.getClassLoader());
        mEsrbRating = (ProductEsrbRating)parcel.readParcelable(com/target/mothership/model/product/handler/TGTProductEsrbRating.getClassLoader());
    }


    public void a(ProductEsrbRating productesrbrating)
    {
        mEsrbRating = productesrbrating;
    }

    public void a(ProductMpaaRating productmpaarating)
    {
        mMpaaRating = productmpaarating;
    }

    public void a(ProductRiaaRating productriaarating)
    {
        mRiaaRating = productriaarating;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mRiaaRating, 0);
        parcel.writeParcelable(mMpaaRating, 0);
        parcel.writeParcelable(mEsrbRating, 0);
    }

}
