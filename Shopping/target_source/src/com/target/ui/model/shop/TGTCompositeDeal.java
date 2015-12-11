// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.shop;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.mothership.model.product.interfaces.ProductDetails;

// Referenced classes of package com.target.ui.model.shop:
//            CompositeDeal

public class TGTCompositeDeal
    implements CompositeDeal
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCompositeDeal a(Parcel parcel)
        {
            return new TGTCompositeDeal(parcel);
        }

        public TGTCompositeDeal[] a(int i)
        {
            return new TGTCompositeDeal[i];
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
    private final AvailableCouponOffer mAvailableCouponOffer;
    private final ProductDetails mProductDetails;

    private TGTCompositeDeal(Parcel parcel)
    {
        mAvailableCouponOffer = (AvailableCouponOffer)parcel.readParcelable(com/target/mothership/model/coupons/interfaces/AvailableCouponOffer.getClassLoader());
        mProductDetails = (ProductDetails)parcel.readParcelable(com/target/mothership/model/product/interfaces/ProductDetails.getClassLoader());
    }


    public TGTCompositeDeal(AvailableCouponOffer availablecouponoffer)
    {
        mAvailableCouponOffer = availablecouponoffer;
        mProductDetails = null;
    }

    public TGTCompositeDeal(ProductDetails productdetails)
    {
        mProductDetails = productdetails;
        mAvailableCouponOffer = null;
    }

    public int a()
    {
        return mAvailableCouponOffer == null ? 2 : 1;
    }

    public e b()
    {
        return e.c(mAvailableCouponOffer);
    }

    public e c()
    {
        return e.c(mProductDetails);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mAvailableCouponOffer, i);
        parcel.writeParcelable(mProductDetails, i);
    }

}
