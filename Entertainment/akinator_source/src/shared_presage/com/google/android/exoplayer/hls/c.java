// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.hls;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import shared_presage.com.google.android.exoplayer.ParserException;

final class c
{

    public static String a(String s, Pattern pattern)
    {
        s = pattern.matcher(s);
        if (s.find())
        {
            return s.group(1);
        } else
        {
            return null;
        }
    }

    public static String a(String s, Pattern pattern, String s1)
    {
        pattern = pattern.matcher(s);
        if (pattern.find() && pattern.groupCount() == 1)
        {
            return pattern.group(1);
        } else
        {
            throw new ParserException((new StringBuilder("Couldn't match ")).append(s1).append(" tag in ").append(s).toString());
        }
    }

    public static Pattern a(String s)
    {
        return Pattern.compile((new StringBuilder()).append(s).append("=(YES|NO)").toString());
    }

    public static int b(String s, Pattern pattern, String s1)
    {
        return Integer.parseInt(a(s, pattern, s1));
    }

    public static boolean b(String s, Pattern pattern)
    {
        s = pattern.matcher(s);
        if (s.find())
        {
            return "YES".equals(s.group(1));
        } else
        {
            return false;
        }
    }
}
