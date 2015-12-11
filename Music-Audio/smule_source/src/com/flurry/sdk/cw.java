// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;

public final class cw
{

    public static String a(Context context)
    {
        String s;
        if (context == null)
        {
            s = null;
        } else
        {
            String s1 = b(context);
            s = s1;
            if (TextUtils.isEmpty(s1))
            {
                return c(context);
            }
        }
        return s;
    }

    static String b(Context context)
    {
        while (context == null || android.os.Build.VERSION.SDK_INT < 17) 
        {
            return null;
        }
        return WebSettings.getDefaultUserAgent(context);
    }

    static String c(Context context)
    {
        if (context == null)
        {
            return null;
        } else
        {
            return (new WebView(context)).getSettings().getUserAgentString();
        }
    }
}
