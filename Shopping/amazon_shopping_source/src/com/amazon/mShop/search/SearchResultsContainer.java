// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.DelayedInitView;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.voice.MShopVoicePackageProxy;
import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryBar;
import com.amazon.shopapp.voice.mshop.MShopVoiceModule;

// Referenced classes of package com.amazon.mShop.search:
//            SearchIntentBuilder

public class SearchResultsContainer extends LinearLayout
    implements DelayedInitView
{

    private static final String TAG = com/amazon/mShop/search/SearchResultsContainer.getSimpleName();
    private AmazonActivity mActivity;
    private String mDepartment;
    private String mFilter;
    private EditText mSearchBarInput;
    private View mSearchResultView;

    public SearchResultsContainer(Context context)
    {
        super(context);
        mActivity = (AmazonActivity)context;
        initViews();
    }

    private void goToSearchEntry()
    {
        Object obj;
        if (mSearchBarInput.getText() != null)
        {
            obj = mSearchBarInput.getText().toString();
        } else
        {
            obj = null;
        }
        obj = (new SearchIntentBuilder(mActivity)).query(((String) (obj))).filter(mFilter).categoryName(mDepartment).showSearchEntryView(true).selectInitialQuery(true).clickStreamOrigin(mActivity.getClickStreamOrigin()).build();
        ActivityUtils.startSearchActivity(mActivity, ((android.content.Intent) (obj)));
    }

    private void setupVoiceSearch(RetailSearchEntryBar retailsearchentrybar)
    {
        if (retailsearchentrybar != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((retailsearchentrybar = (Button)retailsearchentrybar.findViewById(com.amazon.mShop.android.lib.R.id.rs_voice_search_btn)) == null) goto _L1; else goto _L3
_L3:
        try
        {
            if (!MShopVoiceModule.getInstance().voiceSearchInResultEnabled())
            {
                retailsearchentrybar.setVisibility(8);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (RetailSearchEntryBar retailsearchentrybar)
        {
            Log.e(TAG, "Failed to setup voice search", retailsearchentrybar);
            return;
        }
        retailsearchentrybar.setVisibility(0);
        retailsearchentrybar.setOnClickListener(new android.view.View.OnClickListener() {

            final SearchResultsContainer this$0;

            public void onClick(View view)
            {
                if (mActivity != null)
                {
                    MShopVoicePackageProxy.getInstance().openVoiceSearch(mActivity, false);
                }
            }

            
            {
                this$0 = SearchResultsContainer.this;
                super();
            }
        });
        return;
    }

    public Editable getSearchTerm()
    {
        return mSearchBarInput.getText();
    }

    protected void initViews()
    {
        setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        setOrientation(1);
        RetailSearchEntryBar retailsearchentrybar = (RetailSearchEntryBar)View.inflate(getContext(), com.amazon.mShop.android.lib.R.layout.rs_search_entry_bar, null);
        retailsearchentrybar.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        mSearchBarInput = (EditText)retailsearchentrybar.findViewById(com.amazon.mShop.android.lib.R.id.rs_search_src_text);
        mSearchBarInput.setFocusable(false);
        setupVoiceSearch(retailsearchentrybar);
        addView(retailsearchentrybar);
    }

    public void onPushViewCompleted()
    {
    }

    public void setSearchResultView(View view)
    {
        if (mSearchResultView != null)
        {
            removeView(mSearchResultView);
        }
        mSearchResultView = view;
        if (view != null)
        {
            addView(view);
        }
    }

    public void setSearchTerm(CharSequence charsequence)
    {
        mSearchBarInput.setText(charsequence);
    }

    public void updateSearchBar(String s, String s1)
    {
        mFilter = s;
        mDepartment = s1;
        mSearchBarInput.setOnKeyListener(new android.view.View.OnKeyListener() {

            final SearchResultsContainer this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
                if ((66 == i || 23 == i) && 1 == keyevent.getAction())
                {
                    goToSearchEntry();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = SearchResultsContainer.this;
                super();
            }
        });
        s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = getResources().getString(com.amazon.mShop.android.lib.R.string.rs_search_all_departments);
        }
        mSearchBarInput.setHint(getResources().getString(com.amazon.mShop.android.lib.R.string.rs_search_in_department, new Object[] {
            s
        }));
        mSearchBarInput.setOnClickListener(new android.view.View.OnClickListener() {

            final SearchResultsContainer this$0;

            public void onClick(View view)
            {
                goToSearchEntry();
            }

            
            {
                this$0 = SearchResultsContainer.this;
                super();
            }
        });
    }



}
