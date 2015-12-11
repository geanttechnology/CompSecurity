// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.shop;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.mothership.model.product.interfaces.ProductSummaryWrapper;
import com.target.ui.model.weekly_ad.WeeklyAdHomepageData;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.model.shop:
//            AggregateDealsData

public class TGTAggregateDealsData
    implements AggregateDealsData
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAggregateDealsData a(Parcel parcel)
        {
            return new TGTAggregateDealsData(parcel);
        }

        public TGTAggregateDealsData[] a(int i)
        {
            return new TGTAggregateDealsData[i];
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
    private List mAvailableCouponOffers;
    private ProductSummaryWrapper mProductSummaryData;
    private List mWeeklyAdData;

    public TGTAggregateDealsData()
    {
        mAvailableCouponOffers = new ArrayList();
        mWeeklyAdData = new ArrayList();
    }

    private TGTAggregateDealsData(Parcel parcel)
    {
        mAvailableCouponOffers = new ArrayList();
        mWeeklyAdData = new ArrayList();
        mAvailableCouponOffers = new ArrayList();
        parcel.readList(mAvailableCouponOffers, com/target/mothership/model/coupons/interfaces/AvailableCouponOffer.getClassLoader());
        mProductSummaryData = (ProductSummaryWrapper)parcel.readParcelable(com/target/mothership/model/product/interfaces/ProductSummaryWrapper.getClassLoader());
        mWeeklyAdData = new ArrayList();
        parcel.readList(mWeeklyAdData, com/target/ui/model/weekly_ad/WeeklyAdHomepageData.getClassLoader());
    }


    public List a()
    {
        return mAvailableCouponOffers;
    }

    public void a(ProductSummaryWrapper productsummarywrapper)
    {
        mProductSummaryData = productsummarywrapper;
    }

    public void a(List list)
    {
        mAvailableCouponOffers = list;
    }

    public e b()
    {
        return e.c(mProductSummaryData);
    }

    public void b(List list)
    {
        mWeeklyAdData = list;
    }

    public List c()
    {
        return mWeeklyAdData;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(mAvailableCouponOffers);
        parcel.writeParcelable(mProductSummaryData, i);
        parcel.writeList(mWeeklyAdData);
    }

}
