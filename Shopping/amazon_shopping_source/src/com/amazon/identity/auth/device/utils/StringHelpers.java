// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringHelpers
{

    private StringHelpers()
    {
    }

    public static int compareTo(String s, String s1)
    {
        if (s == null)
        {
            return s1 == null ? 0 : -1;
        }
        if (s1 == null)
        {
            return 1;
        } else
        {
            return s.compareTo(s1);
        }
    }

    public static String convertToHex(String s)
    {
        return String.format("%x", new Object[] {
            new BigInteger(s.getBytes())
        });
    }

    public static String findMatch(String s, String s1)
    {
        if (s1 != null)
        {
            if ((s = Pattern.compile(s).matcher(s1)).find())
            {
                if (s.groupCount() == 0)
                {
                    return s.group();
                } else
                {
                    return s.group(1);
                }
            }
        }
        return null;
    }

    public static String join(String s, Collection collection)
    {
        if (collection == null)
        {
            return null;
        } else
        {
            return TextUtils.join(s, collection);
        }
    }

    public static String join(String s, String as[])
    {
        if (as == null)
        {
            return null;
        } else
        {
            return join(s, ((Collection) (Arrays.asList(as))));
        }
    }

    public static String[] split(String s, String s1)
    {
        if (TextUtils.isEmpty(s))
        {
            return new String[0];
        } else
        {
            return TextUtils.split(s, s1);
        }
    }

    public static List splitToList(String s, String s1)
    {
        return Arrays.asList(split(s, s1));
    }

    public static Set splitToSet(String s, String s1)
    {
        return new HashSet(splitToList(s, s1));
    }
}
