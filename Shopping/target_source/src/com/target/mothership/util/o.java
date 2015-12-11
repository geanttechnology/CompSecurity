// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class o
{

    private static final int DECIMAL_PLACES = 2;
    public static final String EMPTY_STRING = "";
    public static final String EQUALS_STRING = "=";
    public static final String HYPHEN_STRING = "-";
    public static final String NULL_STRING = "null";
    public static final String SPACE_STRING = " ";

    public static String a(String s, int j)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (j -= s.length(); j > 0; j--)
        {
            stringbuilder.append("0");
        }

        stringbuilder.append(s);
        return stringbuilder.toString();
    }

    private static String a(String s, boolean flag)
    {
        if (s == null || s.length() == 0)
        {
            return s;
        }
        int k = s.length();
        StringBuffer stringbuffer = new StringBuffer(k);
        int j = 0;
        boolean flag1 = true;
        while (j < k) 
        {
            char c1 = s.charAt(j);
            if (Character.isWhitespace(c1))
            {
                stringbuffer.append(c1);
                flag1 = true;
            } else
            if (flag1)
            {
                stringbuffer.append(Character.toTitleCase(c1));
                flag1 = false;
            } else
            if (flag)
            {
                stringbuffer.append(Character.toLowerCase(c1));
            } else
            {
                stringbuffer.append(c1);
            }
            j++;
        }
        return stringbuffer.toString();
    }

    public static String a(Collection collection, String s)
    {
        if (collection == null || collection.isEmpty())
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        collection = collection.iterator();
        stringbuilder.append((String)collection.next());
        for (; collection.hasNext(); stringbuilder.append(s).append((String)collection.next())) { }
        return stringbuilder.toString();
    }

    public static String a(List list, String s)
    {
        if (list == null)
        {
            return "";
        } else
        {
            return a((String[])list.toArray(new String[list.size()]), s);
        }
    }

    public static String a(String as[], char c1)
    {
        int j = 1;
        if (as == null || as.length == 0)
        {
            return "";
        }
        if (as.length == 1)
        {
            return as[0];
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(as[0]);
        for (; j < as.length; j++)
        {
            stringbuilder.append(c1).append(as[j]);
        }

        return stringbuilder.toString();
    }

    public static String a(String as[], String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int k = as.length;
        for (int j = 0; j < k; j++)
        {
            stringbuilder.append(as[j]);
            if (j != k - 1)
            {
                stringbuilder.append(s);
            }
        }

        return stringbuilder.toString();
    }

    public static boolean a(String s)
    {
        return s == null;
    }

    public static boolean a(String s, String s1)
    {
        if (s == null && s1 == null)
        {
            return true;
        }
        if (s != null && s1 != null)
        {
            return s.equals(s1);
        } else
        {
            return false;
        }
    }

    public static String b(String s, int j)
    {
        String s1;
        if (e(s) || j < 0)
        {
            s1 = "";
        } else
        {
            s1 = s;
            if (s.length() > j)
            {
                return s.substring(0, j);
            }
        }
        return s1;
    }

    public static boolean b(String s)
    {
        return !a(s);
    }

    public static boolean c(String s)
    {
        return s == null || s.length() == 0;
    }

    public static boolean d(String s)
    {
        return !c(s);
    }

    public static boolean e(String s)
    {
        return s == null || s.trim().length() == 0;
    }

    public static boolean f(String s)
    {
        return !e(s);
    }

    public static boolean g(String s)
    {
        return d(s) && !s.equalsIgnoreCase("null");
    }

    public static String h(String s)
    {
        return a(s, false);
    }

    public static double i(String s)
    {
        double d1 = 0.0D;
        if (g(s))
        {
            try
            {
                d1 = Double.parseDouble(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return 0.0D;
            }
        }
        return d1;
    }
}
