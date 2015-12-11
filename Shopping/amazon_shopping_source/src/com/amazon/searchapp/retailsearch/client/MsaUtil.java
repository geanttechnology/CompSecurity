// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import java.util.regex.Pattern;

public class MsaUtil
{

    private static final Pattern EXTENSION_PATTERN = Pattern.compile("(\\.[^/\\.]*$)");
    private static final Pattern TAG_PATTERN = Pattern.compile("(\\._[^/\\.]*)(?=\\.[^/\\.]*$)");

    public MsaUtil()
    {
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

}
