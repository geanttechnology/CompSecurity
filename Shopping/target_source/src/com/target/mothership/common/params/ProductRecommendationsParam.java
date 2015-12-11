// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.product.CategoryId;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.util.k;
import java.util.ArrayList;
import java.util.List;

public class ProductRecommendationsParam
    implements Parcelable
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a CART_NOT_EMPTY_RECOMMENDATIONS;
        public static final a CART_RECOMMENDATIONS;
        public static final a DEFAULT_RECOMMENDATION;
        public static final a LIST_RECOMMENDATIONS;
        public static final a PDP_RECOMMENDATIONS;
        public static final a PLP_RECOMMENDATIONS;
        public static final a SLP_RECOMMENDATIONS;
        private String mValue;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/common/params/ProductRecommendationsParam$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        public String toString()
        {
            return mValue;
        }

        static 
        {
            PDP_RECOMMENDATIONS = new a("PDP_RECOMMENDATIONS", 0, "pdpdroidh1");
            PLP_RECOMMENDATIONS = new a("PLP_RECOMMENDATIONS", 1, "plpdroidh1");
            SLP_RECOMMENDATIONS = new a("SLP_RECOMMENDATIONS", 2, "slpdroidh1");
            CART_RECOMMENDATIONS = new a("CART_RECOMMENDATIONS", 3, "driodemptych1");
            LIST_RECOMMENDATIONS = new a("LIST_RECOMMENDATIONS", 4, "rlistdroidh1");
            CART_NOT_EMPTY_RECOMMENDATIONS = new a("CART_NOT_EMPTY_RECOMMENDATIONS", 5, "droidcarth1");
            DEFAULT_RECOMMENDATION = new a("DEFAULT_RECOMMENDATION", 6, "");
            $VALUES = (new a[] {
                PDP_RECOMMENDATIONS, PLP_RECOMMENDATIONS, SLP_RECOMMENDATIONS, CART_RECOMMENDATIONS, LIST_RECOMMENDATIONS, CART_NOT_EMPTY_RECOMMENDATIONS, DEFAULT_RECOMMENDATION
            });
        }

        private a(String s, int i, String s1)
        {
            super(s, i);
            mValue = s1;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ProductRecommendationsParam a(Parcel parcel)
        {
            return new ProductRecommendationsParam(parcel);
        }

        public ProductRecommendationsParam[] a(int i)
        {
            return new ProductRecommendationsParam[i];
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
    private static final int MAX_RECOMMENDATION = 16;
    private static final int MIN_RECOMMENDATION = 2;
    private CategoryId mCategoryId;
    private Guest mGuest;
    private Integer mMaxLimit;
    private Integer mMinLimit;
    private a mRecommendationType;
    private String mSearchTerm;
    private List mTcins;

    public ProductRecommendationsParam()
    {
        mRecommendationType = a.DEFAULT_RECOMMENDATION;
    }

    private ProductRecommendationsParam(Parcel parcel)
    {
        mMinLimit = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
        mMaxLimit = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
        mTcins = new ArrayList();
        parcel.readList(mTcins, com/target/mothership/common/product/Tcin.getClassLoader());
        mSearchTerm = parcel.readString();
        mCategoryId = (CategoryId)parcel.readParcelable(com/target/mothership/common/product/CategoryId.getClassLoader());
        int i = parcel.readInt();
        if (i == -1)
        {
            parcel = null;
        } else
        {
            parcel = a.values()[i];
        }
        mRecommendationType = parcel;
    }


    public a a()
    {
        return mRecommendationType;
    }

    public void a(int i)
    {
        if (i < 2)
        {
            throw new IllegalArgumentException("Minimum recommendation is 2 items");
        }
        if (i > 16)
        {
            throw new IllegalArgumentException("Minimum recommendation is cannot be more than max limit max limit is : 16");
        } else
        {
            mMinLimit = Integer.valueOf(i);
            return;
        }
    }

    public void a(a a1)
    {
        mRecommendationType = a1;
    }

    public void a(CategoryId categoryid)
    {
        mCategoryId = categoryid;
    }

    public void a(Guest guest)
    {
        mGuest = guest;
    }

    public void a(String s)
    {
        mSearchTerm = s;
    }

    public void a(List list)
    {
        mTcins = list;
    }

    public e b()
    {
        return k.a(mMinLimit);
    }

    public void b(int i)
    {
        if (i < 2)
        {
            throw new IllegalArgumentException("Maximum recommendation should be more than min limit : 2");
        }
        if (i > 16)
        {
            throw new IllegalArgumentException("Maximum limit for recommendation is reached, Limit is : 16");
        } else
        {
            mMaxLimit = Integer.valueOf(i);
            return;
        }
    }

    public e c()
    {
        return k.a(mMaxLimit);
    }

    public List d()
    {
        return k.a(mTcins);
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        return k.a(mSearchTerm);
    }

    public e f()
    {
        return k.a(mCategoryId);
    }

    public e g()
    {
        return k.a(mGuest);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeValue(mMinLimit);
        parcel.writeValue(mMaxLimit);
        parcel.writeList(mTcins);
        parcel.writeString(mSearchTerm);
        parcel.writeParcelable(mCategoryId, 0);
        if (mRecommendationType == null)
        {
            i = -1;
        } else
        {
            i = mRecommendationType.ordinal();
        }
        parcel.writeInt(i);
    }

}
