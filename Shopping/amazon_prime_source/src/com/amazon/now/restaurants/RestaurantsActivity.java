// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.restaurants;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.amazon.now.ChromeStyle;
import com.amazon.now.mash.NavManager;
import com.amazon.now.util.AppUtils;
import com.amazon.now.web.WebActivity;
import com.amazon.retailsearch.android.ui.UIUtils;

public class RestaurantsActivity extends WebActivity
{

    public RestaurantsActivity()
    {
    }

    public static void startActivity(Context context, String s)
    {
        startActivity(context, s, false);
    }

    public static void startActivity(Context context, String s, boolean flag)
    {
        Intent intent = new Intent(context, com/amazon/now/restaurants/RestaurantsActivity);
        intent.addFlags(0x20000);
        int i = context.getResources().getColor(0x7f0d0025);
        ChromeStyle chromestyle = new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL, i, true);
        intent.addFlags(0x10000000);
        intent.putExtra("intentStyleKey", chromestyle);
        intent.putExtra("intentUrlKey", s);
        if (flag)
        {
            NavManager.modifyIntentForNewStack(intent);
        }
        context.startActivity(intent);
    }

    protected String getLaunchUrl()
    {
        Object obj = getIntent().getStringExtra("intentUrlKey");
        if (obj != null)
        {
            return ((String) (obj));
        }
        android.net.Uri.Builder builder = Uri.parse(AppUtils.getServiceUrl(this)).buildUpon();
        obj = getIntent().getData();
        if (obj != null && !TextUtils.isEmpty(((Uri) (obj)).getPath()))
        {
            obj = ((Uri) (obj)).getPath();
        } else
        {
            obj = "/restaurants/home";
        }
        builder.appendEncodedPath(((String) (obj)));
        return builder.build().toString();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        findViewById(0x7f0e002f).setVisibility(8);
        UIUtils.closeSoftKeyboard(getViewAnimator());
    }
}
