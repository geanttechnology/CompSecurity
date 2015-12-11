// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.search;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;

// Referenced classes of package com.amazon.now.search:
//            SearchActivity

public class SearchIntentBuilder
{

    private String mCategoryName;
    private final Context mContext;
    private String mDataUrl;
    private String mFilter;
    private String mMerchantId;
    private String mQuery;
    private RetailSearchQuery mRsQuery;
    private boolean mShowSearchEntryView;
    private String mStoreDiscriminator;

    public SearchIntentBuilder(Context context)
    {
        mQuery = null;
        mFilter = null;
        mCategoryName = null;
        mDataUrl = null;
        mShowSearchEntryView = false;
        mRsQuery = null;
        mMerchantId = null;
        mStoreDiscriminator = null;
        mContext = context;
    }

    public Intent build()
    {
        if (mQuery == null && mFilter == null && mDataUrl == null)
        {
            mShowSearchEntryView = true;
        }
        Intent intent = new Intent(mContext, com/amazon/now/search/SearchActivity);
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        String s;
        if (mQuery == null)
        {
            s = "";
        } else
        {
            s = mQuery;
        }
        builder.appendQueryParameter("paramQueryText", s);
        if (mFilter == null)
        {
            s = "";
        } else
        {
            s = mFilter;
        }
        builder.appendQueryParameter("paramDepartmentFilter", s);
        if (mCategoryName == null)
        {
            s = "";
        } else
        {
            s = mCategoryName;
        }
        builder.appendQueryParameter("paramDepartmentName", s);
        if (mDataUrl == null)
        {
            s = "";
        } else
        {
            s = mDataUrl;
        }
        builder.appendQueryParameter("paramDataUrl", s);
        if (mMerchantId == null)
        {
            s = "";
        } else
        {
            s = mMerchantId;
        }
        builder.appendQueryParameter("paramMerchantId", s);
        intent.setData(builder.build());
        if (!TextUtils.isEmpty(mStoreDiscriminator))
        {
            intent.putExtra("intentKeyStoreDiscriminator", mStoreDiscriminator);
        }
        intent.putExtra("SHOW_SEARCH_ENTRY_VIEW", mShowSearchEntryView);
        intent.putExtra(RetailSearchQuery.INTENT_EXTRA_KEY, mRsQuery);
        return intent;
    }

    public SearchIntentBuilder categoryName(String s)
    {
        mCategoryName = s;
        return this;
    }

    public SearchIntentBuilder dataUrl(String s)
    {
        mDataUrl = s;
        return this;
    }

    public SearchIntentBuilder filter(String s)
    {
        mFilter = s;
        return this;
    }

    public SearchIntentBuilder merchantId(String s)
    {
        mMerchantId = s;
        return this;
    }

    public SearchIntentBuilder query(String s)
    {
        mQuery = s;
        return this;
    }

    public SearchIntentBuilder retailSearchQuery(RetailSearchQuery retailsearchquery)
    {
        mRsQuery = retailsearchquery;
        return this;
    }

    public SearchIntentBuilder showSearchEntryView(boolean flag)
    {
        mShowSearchEntryView = flag;
        return this;
    }

    public SearchIntentBuilder storeDiscriminator(String s)
    {
        mStoreDiscriminator = s;
        return this;
    }
}
