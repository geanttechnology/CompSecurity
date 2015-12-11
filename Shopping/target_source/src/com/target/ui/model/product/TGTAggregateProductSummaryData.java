// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.product;

import android.os.Parcel;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.product.interfaces.ProductSummaryWrapper;
import com.target.ui.util.v;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.model.product:
//            AggregateProductSummaryData

public class TGTAggregateProductSummaryData
    implements AggregateProductSummaryData
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAggregateProductSummaryData a(Parcel parcel)
        {
            return new TGTAggregateProductSummaryData(parcel);
        }

        public TGTAggregateProductSummaryData[] a(int i)
        {
            return new TGTAggregateProductSummaryData[i];
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
    private List mDvmDataResponses;
    private ProductSummaryWrapper mProductSummaryWrapper;

    public TGTAggregateProductSummaryData()
    {
    }

    protected TGTAggregateProductSummaryData(Parcel parcel)
    {
        mProductSummaryWrapper = (ProductSummaryWrapper)parcel.readParcelable(com/target/mothership/model/product/interfaces/ProductSummaryWrapper.getClassLoader());
        mDvmDataResponses = new ArrayList();
        parcel.readList(mDvmDataResponses, com/target/mothership/model/dvm/interfaces/DvmDataResponse.getClassLoader());
    }

    public TGTAggregateProductSummaryData(ProductSummaryWrapper productsummarywrapper, List list)
    {
        mProductSummaryWrapper = productsummarywrapper;
        mDvmDataResponses = list;
    }

    public ProductSummaryWrapper a()
    {
        return mProductSummaryWrapper;
    }

    public void a(ProductSummaryWrapper productsummarywrapper)
    {
        mProductSummaryWrapper = productsummarywrapper;
    }

    public void a(List list)
    {
        mDvmDataResponses = list;
    }

    public List b()
    {
        return v.a(mDvmDataResponses);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mProductSummaryWrapper, 0);
        parcel.writeList(mDvmDataResponses);
    }

}
