// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import com.target.mothership.util.o;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class af
{
    private static class a
        implements Comparator
    {

        public int a(String s, String s1)
        {
            if (s == null || s1 == null)
            {
                return 0;
            }
            if (s.contains("$"))
            {
                s = s.trim().replace("$", "");
            } else
            {
                s = s.trim();
            }
            if (s1.contains("$"))
            {
                s1 = s1.trim().replace("$", "");
            } else
            {
                s1 = s1.trim();
            }
            if (!af.c(s) || !af.c(s1))
            {
                return 0;
            }
            s = new BigDecimal(s);
            s1 = new BigDecimal(s1);
            if (s.intValue() > s1.intValue())
            {
                return 1;
            }
            return s.intValue() >= s1.intValue() ? 0 : -1;
        }

        public int compare(Object obj, Object obj1)
        {
            return a((String)obj, (String)obj1);
        }

        private a()
        {
        }

    }


    public static final String DELIMITER_COMMA = ",";
    public static final String DOLLAR_SIGN = "$";
    public static final String ELLIPSIS = "...";

    public static String a(String s)
    {
        if (!o.g(s))
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        s = s.toLowerCase().toCharArray();
        int j = s.length;
        int i = 0;
        boolean flag1 = true;
        while (i < j) 
        {
            char c2 = s[i];
            char c1;
            boolean flag;
            if (Character.isSpaceChar(c2))
            {
                flag = true;
                c1 = c2;
            } else
            {
                c1 = c2;
                flag = flag1;
                if (flag1)
                {
                    c1 = Character.toTitleCase(c2);
                    flag = false;
                }
            }
            stringbuilder.append(c1);
            i++;
            flag1 = flag;
        }
        return stringbuilder.toString();
    }

    public static String a(String s, int i)
    {
        String s1;
        if (o.e(s) || i < 0)
        {
            s1 = "";
        } else
        {
            s1 = s;
            if (s.length() > i)
            {
                return s.substring(0, i);
            }
        }
        return s1;
    }

    public static List a(List list)
    {
        if (list == null)
        {
            Collections.emptyList();
        }
        Collections.sort(list, new a());
        return list;
    }

    public static String b(String s, int i)
    {
        String s1;
        if (o.e(s) || i < 0)
        {
            s1 = "";
        } else
        {
            s1 = s;
            if (s.length() > i)
            {
                return s.substring(0, i - Math.min(i, "...".length())).concat("...");
            }
        }
        return s1;
    }

    public static List b(String s)
    {
        if (s == null)
        {
            return Collections.emptyList();
        } else
        {
            return Arrays.asList(s.split(","));
        }
    }

    static boolean c(String s)
    {
        return d(s);
    }

    private static boolean d(String s)
    {
        try
        {
            Double.parseDouble(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }
}
