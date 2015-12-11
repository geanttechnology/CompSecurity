// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.e.b;

import com.target.mothership.common.product.p;
import java.net.URL;
import java.util.List;

public class e
{

    private URL mDvmImpressionUrl;
    private List mFacet;
    private List mMaxPrice;
    private List mMinPrice;
    private List mProduct;
    private boolean mRecordSetComplete;
    private String mRecordSetCount;
    private String mRecordSetStartNumber;
    private String mRecordSetTotal;
    private List mRefineCategories;
    private String mResponseTime;
    private String mSearchBy;
    private String mSortBy;
    private p mSortType;
    private String mTotalPage;

    public e()
    {
    }

    public List a()
    {
        return mProduct;
    }

    public List b()
    {
        return mFacet;
    }

    public List c()
    {
        return mMaxPrice;
    }

    public List d()
    {
        return mMinPrice;
    }

    public List e()
    {
        return mRefineCategories;
    }

    public Boolean f()
    {
        return Boolean.valueOf(mRecordSetComplete);
    }

    public String g()
    {
        return mRecordSetCount;
    }

    public String h()
    {
        return mRecordSetStartNumber;
    }

    public String i()
    {
        return mRecordSetTotal;
    }

    public String j()
    {
        return mSearchBy;
    }

    public p k()
    {
        if (mSortBy == null || mSortBy.isEmpty())
        {
            return mSortType;
        }
        if (mSortType != null) goto _L2; else goto _L1
_L1:
        p ap[];
        int i1;
        int j1;
        ap = p.values();
        j1 = ap.length;
        i1 = 0;
_L7:
        if (i1 >= j1) goto _L2; else goto _L3
_L3:
        p p1 = ap[i1];
        if (!p1.toString().toLowerCase().equals(mSortBy.toLowerCase())) goto _L5; else goto _L4
_L4:
        mSortType = p1;
_L2:
        return mSortType;
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public String l()
    {
        return mTotalPage;
    }

    public URL m()
    {
        return mDvmImpressionUrl;
    }
}
