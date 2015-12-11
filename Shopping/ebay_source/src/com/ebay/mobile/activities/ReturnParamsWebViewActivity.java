// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewActivity

public class ReturnParamsWebViewActivity extends ShowWebViewActivity
{

    public ReturnParamsWebViewActivity()
    {
    }

    public static void start(Activity activity, String s, String s1, String s2, Integer integer, boolean flag, boolean flag1, boolean flag2)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/activities/ReturnParamsWebViewActivity);
        intent.putExtra("url", s);
        intent.putExtra("android.intent.extra.TITLE", s1);
        if (!TextUtils.isEmpty(s2))
        {
            intent.putExtra("impression", s2);
        }
        if (flag)
        {
            intent.putExtra("use_sso", flag);
        }
        if (flag1)
        {
            intent.putExtra("add_redirect_url", true);
        }
        intent.putExtra("back", flag2);
        if (integer != null)
        {
            activity.startActivityForResult(intent, integer.intValue());
            return;
        } else
        {
            activity.startActivity(intent);
            return;
        }
    }

    protected void readAdditionalQueryParameters(Uri uri, Intent intent)
    {
        if (uri != null && uri.isHierarchical())
        {
            Iterator iterator = uri.getQueryParameterNames().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                String s1 = uri.getQueryParameter(s);
                if (!TextUtils.isEmpty(s1))
                {
                    intent.putExtra(s, s1);
                }
            } while (true);
        }
    }
}
