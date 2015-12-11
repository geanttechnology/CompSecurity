// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import com.pointinside.PIException;
import com.pointinside.analytics.CommonAnalyticsData;
import com.pointinside.internal.ParameterCheck;
import com.pointinside.internal.utils.IOUtils;
import com.pointinside.net.requestor.WebserviceRequestor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.pointinside.products:
//            AutocompleteResult, AutocompleteURLBuilder

public final class AutocompleteRequestor extends WebserviceRequestor
{
    public static final class AutocompleteClassType extends Enum
    {

        private static final AutocompleteClassType $VALUES[];
        public static final AutocompleteClassType autocomplete;
        public static final AutocompleteClassType deal;

        public static AutocompleteClassType valueOf(String s)
        {
            return (AutocompleteClassType)Enum.valueOf(com/pointinside/products/AutocompleteRequestor$AutocompleteClassType, s);
        }

        public static AutocompleteClassType[] values()
        {
            return (AutocompleteClassType[])$VALUES.clone();
        }

        static 
        {
            autocomplete = new AutocompleteClassType("autocomplete", 0);
            deal = new AutocompleteClassType("deal", 1);
            $VALUES = (new AutocompleteClassType[] {
                autocomplete, deal
            });
        }

        private AutocompleteClassType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Builder
    {

        private List mClasses;
        private CommonAnalyticsData mCommonAnalyticsData;
        private String mKeywordToSearch;
        private int mMaxSuggestionLimit;
        private String mRankUsing;
        private String mSource;
        private String mStoreID;
        private String mVenueUUID;

        public AutocompleteRequestor build()
        {
            AutocompleteURLBuilder autocompleteurlbuilder = new AutocompleteURLBuilder(mKeywordToSearch);
            autocompleteurlbuilder.source = mSource;
            autocompleteurlbuilder.commonAnalyticData = mCommonAnalyticsData;
            autocompleteurlbuilder.maxSuggestionsLimit = mMaxSuggestionLimit;
            autocompleteurlbuilder.storeID = mStoreID;
            autocompleteurlbuilder.venueUUID = mVenueUUID;
            autocompleteurlbuilder.classes = mClasses;
            autocompleteurlbuilder.rankUsing = mRankUsing;
            return new AutocompleteRequestor(autocompleteurlbuilder);
        }

        public transient Builder classes(AutocompleteClassType aautocompleteclasstype[])
        {
            mClasses = Arrays.asList(aautocompleteclasstype);
            return this;
        }

        public Builder commonAnalyticsData(CommonAnalyticsData commonanalyticsdata)
        {
            mCommonAnalyticsData = commonanalyticsdata;
            return this;
        }

        public Builder maxSuggestionsLimit(int i)
        {
            mMaxSuggestionLimit = i;
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

        public Builder(String s)
        {
            mMaxSuggestionLimit = 0x80000000;
            mClasses = null;
            mRankUsing = null;
            mCommonAnalyticsData = null;
            mKeywordToSearch = s;
        }
    }


    private AutocompleteRequestor(AutocompleteURLBuilder autocompleteurlbuilder)
    {
        super(autocompleteurlbuilder, new AutocompleteResult());
    }


    public AutocompleteResult fetchResult()
        throws PIException
    {
        if (ParameterCheck.isNullOrEmpty(((AutocompleteURLBuilder)URL).keywordToSearch))
        {
            throw new PIException("Keyword is either null or empty. Cannot complete autocomplete request. Make sure to use valid keyword when building an AutocompleteRequestor");
        }
        lastNetworkDate = System.currentTimeMillis();
        AutocompleteResult autocompleteresult;
        HttpURLConnection httpurlconnection = ((AutocompleteURLBuilder)URL).openConnection();
        autocompleteresult = (AutocompleteResult)parseResponseAsObject(IOUtils.executeHttpRequest(httpurlconnection, "GET"));
        httpurlconnection.disconnect();
        autocompleteresult.url = AutocompleteURLBuilder.copy((AutocompleteURLBuilder)URL);
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        return autocompleteresult;
        Object obj;
        obj;
        throw new PIException(((Throwable) (obj)));
        obj;
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        throw obj;
    }
}
