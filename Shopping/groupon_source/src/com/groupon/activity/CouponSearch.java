// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.groupon.fragment.CouponSearchAutoComplete;
import com.groupon.fragment.CouponSearchSuggestion;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.activity:
//            GlobalSearchBase

public class CouponSearch extends GlobalSearchBase
{

    LinearLayout resultContainer;
    protected CouponSearchAutoComplete searchResultsListFragment;
    LinearLayout suggestionContainer;

    public CouponSearch()
    {
    }

    private void toggleFragment(boolean flag)
    {
        byte byte0 = 8;
        LinearLayout linearlayout = resultContainer;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        linearlayout.setVisibility(i);
        linearlayout = suggestionContainer;
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        linearlayout.setVisibility(i);
    }

    protected String getHintText()
    {
        return getString(0x7f0800db);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030078);
        bundle = getFragmentManager();
        if (bundle.findFragmentById(0x7f1001da) == null)
        {
            CouponSearchSuggestion couponsearchsuggestion = new CouponSearchSuggestion();
            bundle.beginTransaction().add(0x7f1001da, couponsearchsuggestion).commit();
        }
        searchResultsListFragment = (CouponSearchAutoComplete)bundle.findFragmentById(0x7f1001db);
        if (searchResultsListFragment == null)
        {
            searchResultsListFragment = new CouponSearchAutoComplete();
            bundle.beginTransaction().add(0x7f1001db, searchResultsListFragment).commit();
        }
    }

    public void onResume()
    {
        super.onResume();
        loggingUtils.logPageView("", getClass().getSimpleName(), Logger.NULL_NST_FIELD);
    }

    protected void onSearchExecuted(String s)
    {
    }

    protected void onSearchTextChanged(CharSequence charsequence)
    {
        if (charsequence.toString().isEmpty())
        {
            toggleFragment(false);
            return;
        } else
        {
            searchResultsListFragment.search(charsequence.toString());
            toggleFragment(true);
            return;
        }
    }
}
