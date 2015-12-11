// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.weekly_ad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingDetail;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.view.a;

public class WeeklyAdListingDescriptionFragment extends BaseNavigationFragment
{
    static class Views extends a
    {

        TextView finePrint;
        TextView productDescription;

        Views(View view)
        {
            super(view);
        }
    }


    private static final String WEEKLY_AD_DETAIL_ARG = "weeklyAdDetail";
    private WeeklyAdListingDetail mListingData;
    private Views mViews;

    public WeeklyAdListingDescriptionFragment()
    {
    }

    public static WeeklyAdListingDescriptionFragment a(WeeklyAdListingDetail weeklyadlistingdetail)
    {
        WeeklyAdListingDescriptionFragment weeklyadlistingdescriptionfragment = new WeeklyAdListingDescriptionFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("weeklyAdDetail", weeklyadlistingdetail);
        weeklyadlistingdescriptionfragment.setArguments(bundle);
        return weeklyadlistingdescriptionfragment;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mListingData = (WeeklyAdListingDetail)getArguments().getParcelable("weeklyAdDetail");
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.onCreateOptionsMenu(menu, menuinflater);
            j(getString(0x7f0900ca));
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03008e, viewgroup, false);
        mViews = new Views(layoutinflater);
        if (mListingData.g().b())
        {
            mViews.productDescription.setText((CharSequence)mListingData.g().c());
        }
        if (mListingData.h().b())
        {
            mViews.finePrint.setText((CharSequence)mListingData.h().c());
        }
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mViews = null;
    }
}
