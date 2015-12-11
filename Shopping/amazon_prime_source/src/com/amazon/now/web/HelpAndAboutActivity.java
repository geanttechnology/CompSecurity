// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.now.util.AppUtils;

// Referenced classes of package com.amazon.now.web:
//            WebActivity, NowWebFragment

public class HelpAndAboutActivity extends WebActivity
{

    public HelpAndAboutActivity()
    {
    }

    public static void startActivity(Context context)
    {
        Intent intent = new Intent(context, com/amazon/now/web/HelpAndAboutActivity);
        intent.addFlags(0x20000);
        context.startActivity(intent);
    }

    protected String getLaunchUrl()
    {
        android.net.Uri.Builder builder = Uri.parse(AppUtils.getServiceUrl(this)).buildUpon();
        builder.appendPath("helpAndAbout");
        return builder.build().toString();
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        mWebFragment.loadUrl(getLaunchUrl());
    }
}
