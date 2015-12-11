// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.content.Context;
import android.content.Intent;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.customclientfields.RefmarkerClientField;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Util;
import com.amazon.retailsearch.android.api.intent.search.SearchIntentUriBuilder;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.searchapp.retailsearch.client.SearchMethod;

// Referenced classes of package com.amazon.mShop.search:
//            SearchActivity

public class SearchIntentBuilder
{

    private String asrRequestId;
    private int interpretationNum;
    private String mCategoryName;
    private String mClickStreamOrigin;
    private final Context mContext;
    private String mDataUrl;
    private int mExtraFlag;
    private String mFilter;
    private String mQuery;
    private String mRefmarker;
    private RetailSearchQuery mRsQuery;
    private SearchMethod mSearchMethod;
    private boolean mSelectInitialQuery;
    private boolean mShowSearchEntryView;
    private String utteranceId;

    public SearchIntentBuilder(Context context)
    {
        mQuery = null;
        mFilter = null;
        mCategoryName = null;
        mDataUrl = null;
        mShowSearchEntryView = false;
        mSelectInitialQuery = false;
        mClickStreamOrigin = null;
        mRefmarker = null;
        mRsQuery = null;
        mExtraFlag = -1;
        mContext = context;
    }

    public SearchIntentBuilder asrRequestId(String s)
    {
        asrRequestId = s;
        return this;
    }

    public Intent build()
    {
        if (mQuery == null && mFilter == null && mDataUrl == null)
        {
            mShowSearchEntryView = true;
        }
        Intent intent = new Intent(mContext, com/amazon/mShop/search/SearchActivity);
        if (ActivityUtils.shouldReorderActivity(mContext))
        {
            intent.addFlags(0x20000);
        }
        intent.putExtra("selectInitialQuery", mSelectInitialQuery);
        intent.putExtra("SHOW_SEARCH_ENTRY_VIEW", mShowSearchEntryView);
        if (mClickStreamOrigin != null)
        {
            intent.putExtra("clickStreamOrigin", mClickStreamOrigin);
        } else
        {
            intent.putExtra("clickStreamOrigin", ClickStreamTag.ORIGIN_SEARCH.getTag());
        }
        intent.setData((new SearchIntentUriBuilder()).categoryName(mCategoryName).dataUrl(mDataUrl).filter(mFilter).query(mQuery).searchMethod(mSearchMethod).asrRequestId(asrRequestId).utteranceId(utteranceId).interpretationNum(interpretationNum).build());
        if (mExtraFlag != -1)
        {
            intent.addFlags(mExtraFlag);
        }
        if (!(mContext instanceof SearchActivity) && !Util.isEmpty(mRefmarker))
        {
            RefmarkerClientField.logServiceMethodNameAndRefmarker("adv_search_v34", mRefmarker);
        }
        intent.putExtra(RetailSearchQuery.INTENT_EXTRA_KEY, mRsQuery);
        return intent;
    }

    public SearchIntentBuilder categoryName(String s)
    {
        mCategoryName = s;
        return this;
    }

    public SearchIntentBuilder clickStreamOrigin(String s)
    {
        mClickStreamOrigin = s;
        return this;
    }

    public SearchIntentBuilder dataUrl(String s)
    {
        mDataUrl = s;
        return this;
    }

    public SearchIntentBuilder extraFlag(int i)
    {
        mExtraFlag = i;
        return this;
    }

    public SearchIntentBuilder filter(String s)
    {
        mFilter = s;
        return this;
    }

    public SearchIntentBuilder interpretationNum(int i)
    {
        interpretationNum = i;
        return this;
    }

    public SearchIntentBuilder query(String s)
    {
        mQuery = s;
        return this;
    }

    public SearchIntentBuilder refmarker(String s)
    {
        mRefmarker = s;
        return this;
    }

    public SearchIntentBuilder retailSearchQuery(RetailSearchQuery retailsearchquery)
    {
        mRsQuery = retailsearchquery;
        return this;
    }

    public SearchIntentBuilder searchMethod(SearchMethod searchmethod)
    {
        mSearchMethod = searchmethod;
        return this;
    }

    public SearchIntentBuilder selectInitialQuery(boolean flag)
    {
        mSelectInitialQuery = flag;
        return this;
    }

    public SearchIntentBuilder showSearchEntryView(boolean flag)
    {
        mShowSearchEntryView = flag;
        return this;
    }

    public SearchIntentBuilder utteranceId(String s)
    {
        utteranceId = s;
        return this;
    }
}
