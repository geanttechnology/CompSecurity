// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.amazon.now.mash.NavManager;
import com.amazon.now.util.AppUtils;
import com.amazon.now.web.WebActivity;
import com.amazon.retailsearch.android.ui.UIUtils;

public class HomeActivity extends WebActivity
{

    public static final String POST_SIGN_IN_PATH = "postSignIn";

    public HomeActivity()
    {
    }

    public static Intent getHomeIntent(Context context)
    {
        context = new Intent(context, com/amazon/now/home/HomeActivity);
        NavManager.modifyIntentForNewStack(context);
        return context;
    }

    protected String getLaunchUrl()
    {
        String s = super.getLaunchUrl();
        Object obj = s;
        if (s == null)
        {
            obj = Uri.parse(AppUtils.getServiceUrl(this)).buildUpon();
            ((android.net.Uri.Builder) (obj)).appendPath("home");
            obj = ((android.net.Uri.Builder) (obj)).build().toString();
        }
        return ((String) (obj));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        findViewById(0x7f0e002f).setVisibility(8);
        UIUtils.closeSoftKeyboard(getViewAnimator());
    }
}
