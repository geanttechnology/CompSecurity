// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.ebay.common.UserCache;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.nautilus.domain.content.dm.UssFeedDataManager;

// Referenced classes of package com.ebay.mobile.following:
//            BrowseFollowingFragment

public class BrowseFollowingActivity extends BaseActivity
{

    private boolean refreshSearch;

    public BrowseFollowingActivity()
    {
        refreshSearch = false;
    }

    public static Intent getStartActivityIntent(Context context, boolean flag)
    {
        context = new Intent(context, com/ebay/mobile/following/BrowseFollowingActivity);
        context.putExtra("searchOnly", flag);
        return context;
    }

    public static void startActivity(Context context, boolean flag)
    {
        context.startActivity(getStartActivityIntent(context, flag));
    }

    public String getTrackingEventName()
    {
        return "Following";
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        UssFeedDataManager ussfeeddatamanager = (UssFeedDataManager)UssFeedDataManager.getIfExists(getEbayContext(), UssFeedDataManager.KEY);
        if (ussfeeddatamanager != null)
        {
            ussfeeddatamanager.invalidateData();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300b2);
        if (bundle == null)
        {
            Object obj = getIntent();
            refreshSearch = getIntent().getBooleanExtra("saved_search_from_notification", false);
            bundle = new Bundle();
            bundle.putBoolean("searchOnly", ((Intent) (obj)).getBooleanExtra("searchOnly", false));
            obj = new BrowseFollowingFragment();
            ((BrowseFollowingFragment) (obj)).setArguments(bundle);
            getFragmentManager().beginTransaction().add(0x7f1001c9, ((android.app.Fragment) (obj))).commit();
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (refreshSearch)
        {
            (new UserCache(this)).refreshSavedSearchList();
            refreshSearch = false;
        }
    }
}
