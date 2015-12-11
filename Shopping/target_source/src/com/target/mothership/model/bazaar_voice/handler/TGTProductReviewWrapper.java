// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.bazaar_voice.handler;

import android.os.Parcel;
import com.target.mothership.model.bazaar_voice.interfaces.ProductReviewWrapper;
import com.target.mothership.util.k;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.bazaar_voice.handler:
//            TGTProductReview, TGTProductSecondaryReview

public class TGTProductReviewWrapper
    implements ProductReviewWrapper
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductReviewWrapper a(Parcel parcel)
        {
            return new TGTProductReviewWrapper(parcel);
        }

        public TGTProductReviewWrapper[] a(int i)
        {
            return new TGTProductReviewWrapper[i];
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
    private int mPageNumber;
    private int mPageSize;
    private List mProductReviews;
    private List mSecondaryReview;
    private int mTotalResultCount;

    TGTProductReviewWrapper()
    {
    }

    private TGTProductReviewWrapper(Parcel parcel)
    {
        mPageSize = parcel.readInt();
        mPageNumber = parcel.readInt();
        mTotalResultCount = parcel.readInt();
        mProductReviews = new ArrayList();
        parcel.readList(mProductReviews, com/target/mothership/model/bazaar_voice/handler/TGTProductReview.getClassLoader());
        mSecondaryReview = new ArrayList();
        parcel.readList(mSecondaryReview, com/target/mothership/model/bazaar_voice/handler/TGTProductSecondaryReview.getClassLoader());
    }


    public List a()
    {
        return k.a(mProductReviews);
    }

    public void a(int i)
    {
        mPageSize = i;
    }

    public void a(List list)
    {
        mProductReviews = list;
    }

    public List b()
    {
        return k.a(mSecondaryReview);
    }

    public void b(int i)
    {
        mPageNumber = i;
    }

    public void b(List list)
    {
        mSecondaryReview = list;
    }

    public int c()
    {
        return mPageSize;
    }

    public void c(int i)
    {
        mTotalResultCount = i;
    }

    public int d()
    {
        return mPageNumber;
    }

    public int describeContents()
    {
        return 0;
    }

    public int e()
    {
        return mTotalResultCount;
    }

    public int f()
    {
        if (mPageSize > 0)
        {
            return (int)Math.ceil((float)mTotalResultCount / (float)mPageSize);
        } else
        {
            return 0;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mPageSize);
        parcel.writeInt(mPageNumber);
        parcel.writeInt(mTotalResultCount);
        parcel.writeList(mProductReviews);
        parcel.writeList(mSecondaryReview);
    }

}
