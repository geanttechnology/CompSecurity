// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.poshmark.data_model.models.NewListing;
import com.poshmark.webcommands.WebCommand;

// Referenced classes of package com.poshmark.ui.fragments:
//            MappPageFragment, PMFragment

public class ListingValidationPageFragment extends MappPageFragment
{

    private NewListing newListing;
    boolean showRefreshButton;

    public ListingValidationPageFragment()
    {
        showRefreshButton = false;
    }

    public void cancelListing(WebCommand webcommand)
    {
        finishActivity();
    }

    public void editListing(WebCommand webcommand)
    {
    }

    public void finishedListing(WebCommand webcommand)
    {
        webcommand = new Bundle();
        webcommand.putBoolean("FINISH_LISTING", true);
        ((PMFragment)getTargetFragment()).onFragmentResult(webcommand, 2);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        newListing = (NewListing)getFragmentDataOfType(com/poshmark/data_model/models/NewListing);
        showRefreshButton = getArguments().getBoolean("SHOW_REFRESH");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f0300d2, viewgroup, false);
    }

    public void onDestroy()
    {
        hideProgressDialog();
        super.onDestroy();
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "listing_validation_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
    }
}
