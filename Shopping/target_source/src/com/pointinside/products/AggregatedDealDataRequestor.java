// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import com.pointinside.PIException;
import com.pointinside.analytics.BaseAnalyticsData;
import com.pointinside.analytics.CommonAnalyticsData;
import com.pointinside.internal.utils.IOUtils;
import com.pointinside.net.requestor.WebserviceRequestor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

// Referenced classes of package com.pointinside.products:
//            AggregatedDealDataResult, AggregatedDealDataURLBuilder, SearchAnalyticsData

public final class AggregatedDealDataRequestor extends WebserviceRequestor
{
    public static final class Builder
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

        public Builder background(boolean flag)
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
            return new AggregatedDealDataRequestor(aggregateddealdataurlbuilder);
        }

        public Builder commonAnalyticsData(CommonAnalyticsData commonanalyticsdata)
        {
            mCommonAnalyticsData = commonanalyticsdata;
            return this;
        }

        public Builder facet(Map map)
        {
            mFacets = map;
            return this;
        }

        public Builder keyword(String s)
        {
            mKeywordToSearch = s;
            return this;
        }

        public Builder localTime(long l)
        {
            mLocalTime = l;
            return this;
        }

        public Builder maxDealsLimit(int i)
        {
            mMaxDealsLimit = i;
            return this;
        }

        public Builder offset(int i)
        {
            mOffset = i;
            return this;
        }

        public Builder rankUsing(String s)
        {
            mRankUsing = s;
            return this;
        }

        public Builder source(String s)
        {
            mSource = s;
            return this;
        }

        public Builder storeID(String s)
        {
            mStoreID = s;
            return this;
        }

        public Builder venueUUID(String s)
        {
            mVenueUUID = s;
            return this;
        }

        public Builder()
        {
            mRankUsing = null;
            mOffset = 0;
            mBackground = false;
            mCommonAnalyticsData = null;
            mLocalTime = 0L;
            mFacets = null;
        }
    }


    private AggregatedDealDataRequestor(AggregatedDealDataURLBuilder aggregateddealdataurlbuilder)
    {
        super(aggregateddealdataurlbuilder, new AggregatedDealDataResult());
    }


    public AggregatedDealDataResult fetchResult()
        throws PIException
    {
        lastNetworkDate = System.currentTimeMillis();
        AggregatedDealDataResult aggregateddealdataresult;
        HttpURLConnection httpurlconnection = ((AggregatedDealDataURLBuilder)URL).openConnection();
        aggregateddealdataresult = (AggregatedDealDataResult)parseResponseAsObject(IOUtils.executeHttpRequest(httpurlconnection, "GET"));
        httpurlconnection.disconnect();
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        return aggregateddealdataresult;
        Object obj;
        obj;
        throw new PIException(((Throwable) (obj)));
        obj;
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        throw obj;
    }

    String getPOSTBody(SearchAnalyticsData searchanalyticsdata)
    {
        return (new com.pointinside.internal.utils.IOUtils.AnalyticsPOSTData(new BaseAnalyticsData[] {
            searchanalyticsdata
        })).getJSONString();
    }

    public void sendAnalyticsInfo(SearchAnalyticsData searchanalyticsdata)
        throws IOException
    {
        ((AggregatedDealDataURLBuilder)URL).setQualifiers("analytics");
        lastPostBody = getPOSTBody(searchanalyticsdata);
        searchanalyticsdata = ((AggregatedDealDataURLBuilder)URL).openConnection();
        IOUtils.executeHttpPostRequest(searchanalyticsdata, lastPostBody);
        searchanalyticsdata.disconnect();
    }
}
