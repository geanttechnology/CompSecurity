// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.search;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.amazon.retailsearch.android.ui.search:
//            CoreResultsFragmentWrapper, CoreResultsFragment

public class ResultsFragment extends Fragment
    implements CoreResultsFragmentWrapper
{

    CoreResultsFragment coreFragment;

    public ResultsFragment()
    {
        coreFragment = new CoreResultsFragment();
    }

    public CoreResultsFragment getCoreResultsFragment()
    {
        return coreFragment;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (coreFragment != null)
        {
            coreFragment.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return coreFragment.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void onPause()
    {
        super.onPause();
        coreFragment.onPause();
    }

    public void onResume()
    {
        super.onResume();
        coreFragment.onResume();
    }

    public void onStart()
    {
        super.onStart();
        coreFragment.onStart();
    }

    public void onStop()
    {
        super.onStop();
        coreFragment.onStop();
    }
}
