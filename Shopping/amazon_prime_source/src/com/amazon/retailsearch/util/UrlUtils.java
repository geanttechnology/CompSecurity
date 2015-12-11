// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.util;

import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlUtils
{

    private static final String KEYWORD_PARAMS[] = {
        "keywords", "keyword", "k", "field-keywords"
    };

    private UrlUtils()
    {
    }

    public static String getKeywords(String s)
    {
        String s1 = null;
        int i = 0;
        do
        {
label0:
            {
                if (i < KEYWORD_PARAMS.length)
                {
                    s1 = getParameterValue(s, KEYWORD_PARAMS[i]);
                    if (TextUtils.isEmpty(s1))
                    {
                        break label0;
                    }
                }
                return s1;
            }
            i++;
        } while (true);
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

    public static String getSearchUrl(String s, String s1)
        throws UnsupportedEncodingException
    {
        return (new StringBuilder()).append(s).append("&").append(KEYWORD_PARAMS[0]).append("=").append(URLEncoder.encode(s1, "UTF-8")).toString();
    }

}
