// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class a
{

    private final String a = "https";
    private final String b;
    private final String c = "/api/v1";

    a(String s)
    {
        boolean flag = Pattern.compile("^staging").matcher(s).matches();
        if (flag)
        {
            s = "staging.moodpresence.com";
        } else
        {
            s = "api.moodpresence.com";
        }
        b = s;
    }

    String a()
    {
        return a;
    }

    String b()
    {
        return b;
    }

    String c()
    {
        return c;
    }
}
