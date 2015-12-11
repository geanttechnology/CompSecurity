// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductRecommendations;
import com.target.mothership.util.k;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductDetails

class TGTProductRecommendations
    implements ProductRecommendations
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductRecommendations a(Parcel parcel)
        {
            return new TGTProductRecommendations(parcel);
        }

        public TGTProductRecommendations[] a(int i)
        {
            return new TGTProductRecommendations[i];
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
    private List mProductDetails;
    private String mStrategyDescription;
    private String mStrategyName;

    TGTProductRecommendations()
    {
    }

    private TGTProductRecommendations(Parcel parcel)
    {
        mStrategyName = parcel.readString();
        mStrategyDescription = parcel.readString();
        mProductDetails = new ArrayList();
        parcel.readList(mProductDetails, com/target/mothership/model/product/handler/TGTProductDetails.getClassLoader());
    }


    public List a()
    {
        return k.a(mProductDetails);
    }

    public void a(String s)
    {
        mStrategyName = s;
    }

    public void a(List list)
    {
        mProductDetails = list;
    }

    public void b(String s)
    {
        mStrategyDescription = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mStrategyName);
        parcel.writeString(mStrategyDescription);
        parcel.writeList(mProductDetails);
    }

}
