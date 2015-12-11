// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class StringUtil
{

    public StringUtil()
    {
    }

    public static String ellipsizeAtCount(String s, int i)
    {
        String s1 = s;
        String s2 = s1;
        if (s != null)
        {
            s2 = s1;
            if (s.length() > i)
            {
                s = s.substring(0, i);
                s2 = (new StringBuilder()).append(s).append("...").toString();
            }
        }
        return s2;
    }

    public static String removeHtmlFromString(String s)
    {
        return Jsoup.parse(s).text();
    }
}
