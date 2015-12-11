// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.categoryBrowse;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.SearchBar;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.search.SearchIntentBuilder;
import com.amazon.mShop.util.ActivityUtils;

public class CategorySearchBar extends SearchBar
{

    private AmazonActivity mActivity;
    private String mDepartment;
    private String mFilter;

    public CategorySearchBar(Context context)
    {
        super(context);
        mActivity = (AmazonActivity)context;
    }

    public CategorySearchBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mActivity = (AmazonActivity)context;
    }

    protected void checkPreviousSearchTerm()
    {
    }

    protected void goToSearchEntry(String s, boolean flag)
    {
        s = (new SearchIntentBuilder(mActivity)).query(s).filter(mFilter).categoryName(mDepartment).showSearchEntryView(true).selectInitialQuery(flag).clickStreamOrigin(ClickStreamTag.ORIGIN_BROWSE.getTag()).build();
        ActivityUtils.startSearchActivity(mActivity, s);
    }

    protected void initSearchBar()
    {
        super.initSearchBar();
        View view = getSearchBar();
        int i = view.getPaddingLeft();
        int j = view.getPaddingRight();
        int k = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.category_browse_search_bar_padding);
        view.setPadding(i, k, j, k);
    }

    public void logRefMarker()
    {
        RefMarkerObserver.logRefMarker("br_sr");
    }
}
