// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import com.pointinside.analytics.CommonAnalyticsData;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.pointinside.products:
//            AutocompleteRequestor, AutocompleteURLBuilder

public static final class mKeywordToSearch
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
        return new AutocompleteRequestor(autocompleteurlbuilder, null);
    }

    public transient leteClassType classes(leteClassType aleteclasstype[])
    {
        mClasses = Arrays.asList(aleteclasstype);
        return this;
    }

    public mClasses commonAnalyticsData(CommonAnalyticsData commonanalyticsdata)
    {
        mCommonAnalyticsData = commonanalyticsdata;
        return this;
    }

    public mCommonAnalyticsData maxSuggestionsLimit(int i)
    {
        mMaxSuggestionLimit = i;
        return this;
    }

    public mMaxSuggestionLimit rankUsing(String s)
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

    public leteClassType(String s)
    {
        mMaxSuggestionLimit = 0x80000000;
        mClasses = null;
        mRankUsing = null;
        mCommonAnalyticsData = null;
        mKeywordToSearch = s;
    }
}
