// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.search;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewStub;
import com.amazon.retailsearch.android.api.display.results.ResultsInfoBarWidgetType;
import com.amazon.retailsearch.android.util.FeatureCompatibilityChecker;
import com.amazon.retailsearch.data.stores.StoreManager;

// Referenced classes of package com.amazon.retailsearch.android.ui.search:
//            AbstractResultsDisplay, CoreResultsFragmentWrapper, CoreResultsFragment

public class FragmentBasedResultsDisplay extends AbstractResultsDisplay
{

    private CoreResultsFragment coreResultsFragment;

    public FragmentBasedResultsDisplay()
    {
    }

    public void createDisplay(Context context, ViewStub viewstub)
    {
        Boolean boolean1 = FeatureCompatibilityChecker.useCompatFragment(context);
        if (boolean1 == null)
        {
            throw new RuntimeException("Cannot use a Fragment in this context. This device runs on an Android version that is older than Honeycomb but the FragmentActivity is not being used.");
        }
        if (boolean1.booleanValue())
        {
            viewstub.setLayoutResource(com.amazon.retailsearch.R.layout.rs_results_display_fragment_compat);
            viewstub.inflate();
            context = (CoreResultsFragmentWrapper)((FragmentActivity)context).getSupportFragmentManager().findFragmentById(com.amazon.retailsearch.R.id.results_fragment);
        } else
        {
            viewstub.setLayoutResource(com.amazon.retailsearch.R.layout.rs_results_display_fragment);
            viewstub.inflate();
            context = (CoreResultsFragmentWrapper)((Activity)context).getFragmentManager().findFragmentById(com.amazon.retailsearch.R.id.results_fragment);
        }
        if (context != null)
        {
            context = context.getCoreResultsFragment();
        } else
        {
            context = null;
        }
        coreResultsFragment = context;
        if (coreResultsFragment != null)
        {
            coreResultsFragment.setExternalWidgetsManager(externalWidgetsManager);
        }
    }

    public StoreManager getStoreManager()
    {
        if (coreResultsFragment == null)
        {
            return null;
        } else
        {
            return coreResultsFragment.getStoreManager();
        }
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

    public void setResultsInfoBarWidgetType(ResultsInfoBarWidgetType resultsinfobarwidgettype, View view)
    {
        if (coreResultsFragment != null)
        {
            coreResultsFragment.setResultsInfoBarWidgetType(resultsinfobarwidgettype, view);
        }
    }

    public void show()
    {
    }
}
