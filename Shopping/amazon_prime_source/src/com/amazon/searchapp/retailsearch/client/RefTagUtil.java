// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RefTagUtil
{

    public static final String REF_TAG_PARAMETER = "ref";
    private static final Pattern REF_TAG_PATTERN = Pattern.compile("^(?:[^\\?]*/+)?ref=([^/\\?]*)");

    public RefTagUtil()
    {
    }

    public static String addRefTag(String s, String s1)
    {
        if (s1 == null)
        {
            return s;
        }
        if (s != null)
        {
            s = new StringBuilder(s);
        } else
        {
            s = new StringBuilder();
        }
        if (s.length() > 0 && s.charAt(s.length() - 1) != '/')
        {
            s.append('/');
        }
        return s.append("ref").append('=').append(s1).toString();
    }

    public static String getRefTag(String s)
    {
        if (s != null)
        {
            if ((s = REF_TAG_PATTERN.matcher(s)).find())
            {
                return s.group(1);
            }
        }
        return null;
    }

}
