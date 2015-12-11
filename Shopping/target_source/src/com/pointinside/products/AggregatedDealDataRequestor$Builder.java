// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import com.pointinside.analytics.CommonAnalyticsData;
import java.util.Map;

// Referenced classes of package com.pointinside.products:
//            AggregatedDealDataRequestor, AggregatedDealDataURLBuilder

public static final class mFacets
{

    private boolean mBackground;
    private CommonAnalyticsData mCommonAnalyticsData;
    private Map mFacets;
    private String mKeywordToSearch;
    private long mLocalTime;
    private int mMaxDealsLimit;
    private int mOffset;
    private String mRankUsing;
    private String mSource;
    private String mStoreID;
    private String mVenueUUID;

    public mFacets background(boolean flag)
    {
        mBackground = flag;
        return this;
    }

    public AggregatedDealDataRequestor build()
    {
        AggregatedDealDataURLBuilder aggregateddealdataurlbuilder = new AggregatedDealDataURLBuilder();
        aggregateddealdataurlbuilder.keywordToSearch = mKeywordToSearch;
        aggregateddealdataurlbuilder.source = mSource;
        aggregateddealdataurlbuilder.commonAnalyticData = mCommonAnalyticsData;
        aggregateddealdataurlbuilder.storeID = mStoreID;
        aggregateddealdataurlbuilder.venueUUID = mVenueUUID;
        aggregateddealdataurlbuilder.rankUsing = mRankUsing;
        aggregateddealdataurlbuilder.facets = mFacets;
        aggregateddealdataurlbuilder.background = mBackground;
        aggregateddealdataurlbuilder.maxDealsLimit = mMaxDealsLimit;
        aggregateddealdataurlbuilder.localTime = mLocalTime;
        aggregateddealdataurlbuilder.offset = mOffset;
        return new AggregatedDealDataRequestor(aggregateddealdataurlbuilder, null);
    }

    public mOffset commonAnalyticsData(CommonAnalyticsData commonanalyticsdata)
    {
        mCommonAnalyticsData = commonanalyticsdata;
        return this;
    }

    public mCommonAnalyticsData facet(Map map)
    {
        mFacets = map;
        return this;
    }

    public mFacets keyword(String s)
    {
        mKeywordToSearch = s;
        return this;
    }

    public mKeywordToSearch localTime(long l)
    {
        mLocalTime = l;
        return this;
    }

    public mLocalTime maxDealsLimit(int i)
    {
        mMaxDealsLimit = i;
        return this;
    }

    public mMaxDealsLimit offset(int i)
    {
        mOffset = i;
        return this;
    }

    public mOffset rankUsing(String s)
    {
        mRankUsing = s;
        return this;
    }

    public mRankUsing source(String s)
    {
        mSource = s;
        return this;
    }

    public mSource storeID(String s)
    {
        mStoreID = s;
        return this;
    }

    public mStoreID venueUUID(String s)
    {
        mVenueUUID = s;
        return this;
    }

    public ()
    {
        mRankUsing = null;
        mOffset = 0;
        mBackground = false;
        mCommonAnalyticsData = null;
        mLocalTime = 0L;
        mFacets = null;
    }
}
