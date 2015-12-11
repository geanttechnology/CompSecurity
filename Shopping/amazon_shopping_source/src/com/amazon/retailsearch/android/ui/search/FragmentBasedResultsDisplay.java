// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.search;

import android.content.Context;
import android.view.ViewStub;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.util.FeatureCompatibilityChecker;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.SearchDataSource;

// Referenced classes of package com.amazon.retailsearch.android.ui.search:
//            AbstractResultsDisplay

public class FragmentBasedResultsDisplay extends AbstractResultsDisplay
{

    SearchDataSource dataSource;

    public FragmentBasedResultsDisplay()
    {
        RetailSearchDaggerGraphController.inject(this);
    }

    public void createDisplay(Context context, ViewStub viewstub)
    {
        context = FeatureCompatibilityChecker.useCompatFragment(context);
        if (context == null)
        {
            throw new RuntimeException("Cannot use a Fragment in this context. This device runs on an Android version that is older than Honeycomb but the FragmentActivity is not being used.");
        }
        if (context.booleanValue())
        {
            viewstub.setLayoutResource(com.amazon.retailsearch.R.layout.rs_results_display_fragment_compat);
        } else
        {
            viewstub.setLayoutResource(com.amazon.retailsearch.R.layout.rs_results_display_fragment);
        }
        viewstub.inflate();
    }

    public void hide()
    {
    }

    public void onBackPressed()
    {
    }

    public void onDestroy()
    {
    }

    public void onPause()
    {
    }

    public void onResume()
    {
    }

    public void onStart()
    {
    }

    public void onStop()
    {
    }

    public void search(RetailSearchQuery retailsearchquery)
    {
        dataSource.submitQuery(retailsearchquery);
        dataSource.stageLastQuery();
    }

    public void show()
    {
    }
}
