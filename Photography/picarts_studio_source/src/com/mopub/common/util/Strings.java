// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.util;

import android.text.TextUtils;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings
{

    private static Pattern absolutePattern = Pattern.compile("\\d{2}:\\d{2}:\\d{2}(.\\d{3})?");
    private static Pattern percentagePattern = Pattern.compile("((\\d{1,2})|(100))%");

    public Strings()
    {
    }

    public static String fromStream(InputStream inputstream)
    {
        StringBuilder stringbuilder = new StringBuilder();
        byte abyte0[] = new byte[4096];
        for (int i = 0; i != -1; i = inputstream.read(abyte0))
        {
            stringbuilder.append(new String(abyte0, 0, i));
        }

        inputstream.close();
        return stringbuilder.toString();
    }

    public static boolean isAbsoluteTracker(String s)
    {
        return !TextUtils.isEmpty(s) && absolutePattern.matcher(s).matches();
    }

    public static boolean isPercentageTracker(String s)
    {
        return !TextUtils.isEmpty(s) && percentagePattern.matcher(s).matches();
    }

    public static Integer parseAbsoluteOffset(String s)
    {
        if (s != null)
        {
            if ((s = s.split(":")).length == 3)
            {
                return Integer.valueOf(Integer.parseInt(s[0]) * 60 * 60 * 1000 + Integer.parseInt(s[1]) * 60 * 1000 + (int)(Float.parseFloat(s[2]) * 1000F));
            }
        }
        return null;
    }

}
