// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.search;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.amazon.now.AmazonActivity;
import com.amazon.retailsearch.android.ui.DelayedInitView;
import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryBar;

// Referenced classes of package com.amazon.now.search:
//            SearchIntentBuilder

public class SearchResultsContainer extends LinearLayout
    implements DelayedInitView
{

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

    public SearchResultsContainer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
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
        obj = (new SearchIntentBuilder(mActivity)).query(((String) (obj))).filter(mFilter).categoryName(mDepartment).showSearchEntryView(true).build();
        mActivity.startActivity(((android.content.Intent) (obj)));
    }

    public Editable getSearchTerm()
    {
        return mSearchBarInput.getText();
    }

    protected void initViews()
    {
        setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        setOrientation(1);
        RetailSearchEntryBar retailsearchentrybar = (RetailSearchEntryBar)View.inflate(getContext(), 0x7f030056, null);
        retailsearchentrybar.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        mSearchBarInput = (EditText)retailsearchentrybar.findViewById(0x7f0e012b);
        mSearchBarInput.setFocusable(false);
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
        mSearchBarInput.setHint(getResources().getString(0x7f07003a));
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
