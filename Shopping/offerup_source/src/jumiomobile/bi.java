// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bi
{

    public static String a(String s, int i)
    {
        String s1 = s;
        if (s != null)
        {
            s = s.trim();
            s1 = s;
            if (s.length() > i)
            {
                s1 = s.substring(0, i);
            }
        }
        return s1;
    }

    public static String a(String s, int i, String s1)
    {
        String s2 = s;
        if (s != null)
        {
            s2 = s;
            if (s1 != null)
            {
                a(s, i);
                s2 = s;
                if (!Pattern.compile(s1).matcher(s).matches())
                {
                    s2 = null;
                }
            }
        }
        return s2;
    }
}
