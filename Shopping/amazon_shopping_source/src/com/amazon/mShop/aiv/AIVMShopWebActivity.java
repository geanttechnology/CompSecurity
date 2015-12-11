// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.aiv;

import android.content.Intent;
import android.content.res.Resources;
import android.webkit.WebView;
import com.amazon.mShop.categoryBrowse.CategoryMetadata;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.search.ScopedSearch;
import com.amazon.mShop.web.MShopWebActivity;

public class AIVMShopWebActivity extends MShopWebActivity
    implements ScopedSearch
{

    private static final String AIV_MSHOP_WEB_ACTIVITY_CLASS = com/amazon/mShop/aiv/AIVMShopWebActivity.getSimpleName();
    private static final String AIV_SEARCH_ALIAS = "instant-video";
    public static final String CALLING_CLASS_NAME = "CallingClassName";
    public static final String FORCE_CLEAR_HISTORY = "ForceClearHistory";
    private static final String SEARCH_BASE_URL = "/s?ref=MshopAivContextSearch&i=instant-video";

    public AIVMShopWebActivity()
    {
    }

    public void beginForwardTransition(String s)
    {
        getWebView().setVisibility(8);
        super.beginForwardTransition(s);
        getWebView().setVisibility(0);
    }

    public CategoryMetadata getCategoryMetadata()
    {
        return new CategoryMetadata(getResources().getString(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv), "/s?ref=MshopAivContextSearch&i=instant-video", "instant-video");
    }

    public int getCurrentDepartmentDepth()
    {
        return 1;
    }

    protected void onNewIntent(Intent intent)
    {
        boolean flag1 = false;
        boolean flag2 = intent.getBooleanExtra("ForceClearHistory", false);
        String s = intent.getStringExtra("CallingClassName");
        boolean flag = flag1;
        if (!flag2)
        {
            flag = flag1;
            if (AIV_MSHOP_WEB_ACTIVITY_CLASS.equals(s))
            {
                flag = true;
            }
        }
        intent.putExtra("KeepHistoryStack", flag);
        super.onNewIntent(intent);
    }

    protected void onResume()
    {
        super.onResume();
        getGNODrawer().focusOn("mshop:aiv");
    }

}
