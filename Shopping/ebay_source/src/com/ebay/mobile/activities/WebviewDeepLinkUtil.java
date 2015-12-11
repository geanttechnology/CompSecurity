// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

// Referenced classes of package com.ebay.mobile.activities:
//            HybridWebLandingActivity, ShowWebViewActivity

public class WebviewDeepLinkUtil
{

    public WebviewDeepLinkUtil()
    {
    }

    public static Intent parseDeepLink(Context context, String s, Uri uri)
    {
        if ("webview".equals(s))
        {
            if (!TextUtils.isEmpty(s = uri.getQueryParameter("url")) && HybridWebLandingActivity.isTrustedLanding(s))
            {
                context = new Intent(context, com/ebay/mobile/activities/HybridWebLandingActivity);
                context.putExtra("url", s);
                s = uri.getQueryParameter("title");
                if (!TextUtils.isEmpty(s))
                {
                    context.putExtra("android.intent.extra.TITLE", s);
                }
                if ("1".equals(uri.getQueryParameter("external")))
                {
                    context.putExtra(HybridWebLandingActivity.EXTRA_FLAG_EXTERNAL, true);
                }
                context.putExtra("ok", false);
                context.putExtra(ShowWebViewActivity.EXTRA_SHOW_MENU, true);
                context.putExtra("back", true);
                return context;
            }
        }
        return null;
    }
}
