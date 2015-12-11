// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.util;

import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;

public class UrlUtils
{

    private static final String KEYWORDS_PARAM = "keywords";

    private UrlUtils()
    {
    }

    public static String getKeywords(String s)
    {
        return getParameterValue(s, "keywords");
    }

    public static String getParameterValue(String s, String s1)
    {
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            Uri uri = null;
            if (s != null)
            {
                uri = Uri.parse(Html.fromHtml(s.replaceAll("\\+", " ")).toString());
            }
            if (uri != null)
            {
                return uri.getQueryParameter(s1);
            }
        }
        return null;
    }
}
