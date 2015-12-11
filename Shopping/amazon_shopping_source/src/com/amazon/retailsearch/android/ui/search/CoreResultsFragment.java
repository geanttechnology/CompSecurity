// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.search;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.retailsearch.android.fragments.AbstractFragment;

// Referenced classes of package com.amazon.retailsearch.android.ui.search:
//            SearchResultView

public class CoreResultsFragment extends AbstractFragment
{

    private SearchResultView searchResultView;

    public CoreResultsFragment()
    {
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (searchResultView != null)
        {
            searchResultView.onConfigurationChanged(configuration);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(com.amazon.retailsearch.R.layout.search_page_root, viewgroup, false);
        searchResultView = (SearchResultView)layoutinflater.findViewById(com.amazon.retailsearch.R.id.rs_search_result_view);
        return layoutinflater;
    }

    public void onPause()
    {
        if (searchResultView != null)
        {
            searchResultView.onPause();
        }
    }

    public void onResume()
    {
        if (searchResultView != null)
        {
            searchResultView.onResume();
        }
    }

    public void onStart()
    {
        if (searchResultView != null)
        {
            searchResultView.onStart();
        }
    }

    public void onStop()
    {
        if (searchResultView != null)
        {
            searchResultView.onStop();
        }
    }
}
