// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang;


public class StringUtils
{

    public StringUtils()
    {
    }

    public static boolean isBlank(String s)
    {
        if (s != null)
        {
            int j = s.length();
            if (j != 0)
            {
                int i = 0;
                while (i < j) 
                {
                    if (!Character.isWhitespace(s.charAt(i)))
                    {
                        return false;
                    }
                    i++;
                }
            }
        }
        return true;
    }

    public static boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    public static boolean isNotEmpty(String s)
    {
        return !isEmpty(s);
    }
}
