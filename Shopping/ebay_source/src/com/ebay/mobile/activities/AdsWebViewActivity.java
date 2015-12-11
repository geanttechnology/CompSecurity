// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.Menu;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewActivity

public class AdsWebViewActivity extends ShowWebViewActivity
{

    public AdsWebViewActivity()
    {
    }

    public static void start(Activity activity, String s, String s1, String s2)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/activities/AdsWebViewActivity);
        intent.putExtra("url", s);
        intent.putExtra("android.intent.extra.TITLE", s1);
        if (!TextUtils.isEmpty(s2))
        {
            intent.putExtra("impression", s2);
        }
        activity.startActivity(intent);
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        boolean flag = super.onPrepareOptionsMenu(menu);
        menu.clear();
        getSupportActionBar().setLogo(0x7f020261);
        return flag;
    }
}
