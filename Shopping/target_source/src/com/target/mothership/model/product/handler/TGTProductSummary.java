// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.common.product.p;
import com.target.mothership.model.common.TGTDvmRemoteData;
import com.target.mothership.model.dvm.interfaces.DvmRemoteData;
import com.target.mothership.model.product.interfaces.ProductSummary;
import com.target.mothership.util.k;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductDetails, TGTProductFacet, TGTProductFacetPrice

public class TGTProductSummary
    implements ProductSummary
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductSummary a(Parcel parcel)
        {
            return new TGTProductSummary(parcel);
        }

        public TGTProductSummary[] a(int j)
        {
            return new TGTProductSummary[j];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int j)
        {
            return a(j);
        }

    };
    private DvmRemoteData mDvmRemoteData;
    private List mFacetTypes;
    private List mMaxPrice;
    private List mMinPrice;
    private int mPagesNumber;
    private List mProductDetails;
    private List mProductFacets;
    private p mProductSortType;
    private boolean mRecordSetComplete;
    private int mRecordSetCount;
    private int mRecordSetStartNumber;
    private int mRecordSetTotal;
    private List mRefinedFacets;
    private String mSearchBy;
    private int mTotalPages;

    TGTProductSummary()
    {
    }

    private TGTProductSummary(Parcel parcel)
    {
        mProductDetails = new ArrayList();
        mProductFacets = new ArrayList();
        mRefinedFacets = new ArrayList();
        mMaxPrice = new ArrayList();
        mMinPrice = new ArrayList();
        mFacetTypes = new ArrayList();
        parcel.readList(mProductDetails, com/target/mothership/model/product/handler/TGTProductDetails.getClassLoader());
        parcel.readList(mProductFacets, com/target/mothership/model/product/handler/TGTProductFacet.getClassLoader());
        parcel.readList(mRefinedFacets, com/target/mothership/model/product/handler/TGTProductFacet.getClassLoader());
        parcel.readList(mMaxPrice, com/target/mothership/model/product/handler/TGTProductFacetPrice.getClassLoader());
        parcel.readList(mMinPrice, com/target/mothership/model/product/handler/TGTProductFacetPrice.getClassLoader());
        parcel.readList(mFacetTypes, com/target/mothership/common/product/EndecaId.getClassLoader());
        p p1;
        int j;
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mRecordSetComplete = flag;
        mRecordSetCount = parcel.readInt();
        mRecordSetStartNumber = parcel.readInt();
        mRecordSetTotal = parcel.readInt();
        mSearchBy = parcel.readString();
        j = parcel.readInt();
        if (j == -1)
        {
            p1 = null;
        } else
        {
            p1 = p.values()[j];
        }
        mProductSortType = p1;
        mTotalPages = parcel.readInt();
        mPagesNumber = parcel.readInt();
        mDvmRemoteData = (DvmRemoteData)parcel.readParcelable(com/target/mothership/model/common/TGTDvmRemoteData.getClassLoader());
    }


    public List a()
    {
        return k.a(mProductDetails);
    }

    public void a(int j)
    {
        mRecordSetCount = j;
    }

    public void a(p p1)
    {
        mProductSortType = p1;
    }

    public void a(DvmRemoteData dvmremotedata)
    {
        mDvmRemoteData = dvmremotedata;
    }

    public void a(String s)
    {
        mSearchBy = s;
    }

    public void a(List list)
    {
        mProductDetails = list;
    }

    public void a(boolean flag)
    {
        mRecordSetComplete = flag;
    }

    public List b()
    {
        return k.a(mProductFacets);
    }

    public void b(int j)
    {
        mRecordSetStartNumber = j;
    }

    public void b(List list)
    {
        mProductFacets = list;
    }

    public List c()
    {
        return k.a(mRefinedFacets);
    }

    public void c(int j)
    {
        mRecordSetTotal = j;
    }

    public void c(List list)
    {
        mRefinedFacets = list;
    }

    public int d()
    {
        return mRecordSetCount;
    }

    public void d(int j)
    {
        mTotalPages = j;
    }

    public void d(List list)
    {
        mMaxPrice = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public int e()
    {
        return mRecordSetStartNumber;
    }

    public void e(int j)
    {
        mPagesNumber = j;
    }

    public void e(List list)
    {
        mMinPrice = list;
    }

    public int f()
    {
        return mRecordSetTotal;
    }

    public int g()
    {
        return mTotalPages;
    }

    public int h()
    {
        return mPagesNumber;
    }

    public e i()
    {
        return k.a(mDvmRemoteData);
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        parcel.writeList(mProductDetails);
        parcel.writeList(mProductFacets);
        parcel.writeList(mRefinedFacets);
        parcel.writeList(mMaxPrice);
        parcel.writeList(mMinPrice);
        parcel.writeList(mFacetTypes);
        byte byte0;
        if (mRecordSetComplete)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeInt(mRecordSetCount);
        parcel.writeInt(mRecordSetStartNumber);
        parcel.writeInt(mRecordSetTotal);
        parcel.writeString(mSearchBy);
        if (mProductSortType == null)
        {
            j = -1;
        } else
        {
            j = mProductSortType.ordinal();
        }
        parcel.writeInt(j);
        parcel.writeInt(mTotalPages);
        parcel.writeInt(mPagesNumber);
        parcel.writeParcelable(mDvmRemoteData, 0);
    }

}
