// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{

    private static final Pattern b = Pattern.compile("(\\d+)[\\.](\\d+)[\\.](\\d+)([^/]*)");
    public String a;
    private String c;
    private String d;
    private String e;
    private String f;

    public b(String s)
    {
        s = b.matcher(s);
        if (!s.matches())
        {
            throw new ParseException("Version string not parsable", 0);
        } else
        {
            String as[] = new String[4];
            as[0] = s.group(1);
            as[1] = s.group(2);
            as[2] = s.group(3);
            as[3] = s.group(4);
            a(as[0], as[1], as[2], as[3]);
            return;
        }
    }

    public b(String s, String s1, String s2, String s3)
    {
        a(s, s1, s2, s3);
    }

    private void a(String s, String s1, String s2, String s3)
    {
        c = s;
        d = s1;
        e = s2;
        if (s3 == null)
        {
            s3 = "";
        }
        f = s3;
        a = (new StringBuilder()).append(c).append(".").append(d).append(".").append(e).toString();
    }

    public final String a()
    {
        return (new StringBuilder()).append(a).append(f).toString();
    }

    public final String toString()
    {
        return (new StringBuilder("AppIdVersion{")).append(a()).append('}').toString();
    }

}
