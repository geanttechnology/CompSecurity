// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public abstract class StringUtils
{

    public static boolean hasLength(CharSequence charsequence)
    {
        return charsequence != null && charsequence.length() > 0;
    }

    public static boolean hasLength(String s)
    {
        return hasLength(((CharSequence) (s)));
    }

    public static String[] toStringArray(Collection collection)
    {
        if (collection == null)
        {
            return null;
        } else
        {
            return (String[])collection.toArray(new String[collection.size()]);
        }
    }

    public static String[] tokenizeToStringArray(String s, String s1)
    {
        return tokenizeToStringArray(s, s1, true, true);
    }

    public static String[] tokenizeToStringArray(String s, String s1, boolean flag, boolean flag1)
    {
        if (s == null)
        {
            return null;
        }
        StringTokenizer stringtokenizer = new StringTokenizer(s, s1);
        ArrayList arraylist = new ArrayList();
        do
        {
            if (!stringtokenizer.hasMoreTokens())
            {
                break;
            }
            s1 = stringtokenizer.nextToken();
            s = s1;
            if (flag)
            {
                s = s1.trim();
            }
            if (!flag1 || s.length() > 0)
            {
                arraylist.add(s);
            }
        } while (true);
        return toStringArray(arraylist);
    }
}
