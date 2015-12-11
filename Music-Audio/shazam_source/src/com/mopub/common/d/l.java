// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.d;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class l
{

    private static Pattern a = Pattern.compile("((\\d{1,2})|(100))%");
    private static Pattern b = Pattern.compile("\\d{2}:\\d{2}:\\d{2}(.\\d{3})?");

    public static boolean a(String s)
    {
        return !TextUtils.isEmpty(s) && a.matcher(s).matches();
    }

    public static boolean b(String s)
    {
        return !TextUtils.isEmpty(s) && b.matcher(s).matches();
    }

    public static Integer c(String s)
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
