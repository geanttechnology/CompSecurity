// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MsaUtil
{

    public static final int DEFAULT_QUALITY_LEVEL = 70;
    private static final Pattern EXTENSION_PATTERN = Pattern.compile("(\\.[^/\\.]*$)");
    private static final Pattern TAG_PATTERN = Pattern.compile("(\\._[^/\\.]*)(?=\\.[^/\\.]*$)");

    public MsaUtil()
    {
    }

    private static void appendTag(StringBuilder stringbuilder, String s, Object obj)
    {
        if (stringbuilder.length() == 0)
        {
            stringbuilder.append("_");
        }
        stringbuilder.append(s);
        if (obj != null)
        {
            stringbuilder.append(obj);
        }
        stringbuilder.append("_");
    }

    public static String setImageRes(String s, int i)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return s.replace("{IMG_RES}", Integer.toString(i));
        }
    }

    public static String setImageStyle(String s, boolean flag, int i, int j, int k)
    {
        StringBuilder stringbuilder = new StringBuilder(16);
        if (flag)
        {
            appendTag(stringbuilder, "AC", null);
        }
        if (i > -1)
        {
            appendTag(stringbuilder, "SX", Integer.valueOf(i));
        }
        if (j > -1)
        {
            appendTag(stringbuilder, "SY", Integer.valueOf(j));
        }
        if (k > -1)
        {
            appendTag(stringbuilder, "QL", Integer.valueOf(k));
        }
        return setImageTags(s, stringbuilder.toString(), null);
    }

    public static String setImageTags(String s, String s1)
    {
        return setImageTags(s, s1, null);
    }

    public static String setImageTags(String s, String s1, String s2)
    {
        s = TAG_PATTERN.matcher(s).replaceAll("");
        Matcher matcher = EXTENSION_PATTERN.matcher(s);
        s1 = (new StringBuilder()).append(".").append(s1);
        s = s2;
        if (s2 == null)
        {
            s = "$1";
        }
        return matcher.replaceAll(s1.append(s).toString());
    }

}
