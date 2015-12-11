// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import com.ebay.mobile.activities.ShowWebViewActivity;

public class PreviewListingActivity extends ShowWebViewActivity
{

    public PreviewListingActivity()
    {
    }

    public static void start(Activity activity, String s, String s1)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/sell/PreviewListingActivity);
        intent.putExtra("url", s);
        intent.putExtra("android.intent.extra.TITLE", s1);
        activity.startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }

    protected void readIntent()
    {
        super.readIntent();
        useSso = true;
    }
}
