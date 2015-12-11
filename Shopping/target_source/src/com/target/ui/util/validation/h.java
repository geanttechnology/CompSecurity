// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation;

import android.util.Patterns;
import com.target.mothership.util.o;
import com.target.ui.util.validation.a.e;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h
{

    private static final String ALLOWED_NAME_CHARACTERS = (new StringBuilder()).append("- '.ABCDEFGHIJKLMNOPQRSTUVWXYZ").append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase()).toString();
    private static final String CAPS_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final Pattern EMAIL_PATTERN;
    private static final String GREATERTHAN_LESSTHAN = "><";
    private static final String NAME_SPECIAL_CHARACTERS = "- '.";
    private static final String SPECIAL_CHARACTERS = "~`!@#$%^&*()-_+=;:'\",./?\\|";

    public static e a(String s, int j, int k)
    {
        ArrayList arraylist;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag = o.c(s);
        flag1 = a(s, j);
        flag2 = b(s, k);
        flag3 = c(s);
        flag4 = a(s);
        arraylist = new ArrayList(com.target.ui.util.validation.a.e.a.values().length);
        break MISSING_BLOCK_LABEL_44;
        if (!flag && flag1)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.TOO_SHORT);
        }
        if (flag2)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.TOO_LONG);
        }
        if (flag3)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.ONLY_SPACES);
        }
        if (flag4)
        {
            arraylist.add(com.target.ui.util.validation.a.e.a.SPECIAL_CHAR_NOT_ALLOWED);
        }
        return new e(s, arraylist.isEmpty(), arraylist);
    }

    public static boolean a(String s)
    {
        while (o.c(s) || a(s, ALLOWED_NAME_CHARACTERS)) 
        {
            return false;
        }
        return true;
    }

    public static boolean a(String s, int j)
    {
        while (o.c(s) || s.length() < j) 
        {
            return true;
        }
        return false;
    }

    public static boolean a(String s, String s1)
    {
        if (!o.c(s))
        {
            s = s.toCharArray();
            int k = s.length;
            int j = 0;
            while (j < k) 
            {
                if (!s1.contains(String.valueOf(s[j])))
                {
                    return false;
                }
                j++;
            }
        }
        return true;
    }

    public static boolean b(String s)
    {
        return b(s, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    public static boolean b(String s, int j)
    {
        while (o.c(s) || s.length() <= j) 
        {
            return false;
        }
        return true;
    }

    public static boolean b(String s, String s1)
    {
        if (!o.c(s))
        {
            s = s.toCharArray();
            int k = s.length;
            int j = 0;
            while (j < k) 
            {
                if (s1.contains(String.valueOf(s[j])))
                {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    public static boolean c(String s)
    {
        return o.e(s);
    }

    public static boolean c(String s, int j)
    {
        while (o.c(s) || s.length() == j) 
        {
            return false;
        }
        return true;
    }

    public static boolean d(String s)
    {
        if (o.c(s))
        {
            return false;
        } else
        {
            return a(s, "0123456789");
        }
    }

    public static boolean e(String s)
    {
        if (o.c(s))
        {
            return false;
        } else
        {
            return a(s, "~`!@#$%^&*()-_+=;:'\",./?\\|");
        }
    }

    public static boolean f(String s)
    {
        return b(s, "~`!@#$%^&*()-_+=;:'\",./?\\|");
    }

    public static boolean g(String s)
    {
        return b(s, "0123456789");
    }

    public static boolean h(String s)
    {
        return b(s, "><");
    }

    public static boolean i(String s)
    {
        if (o.e(s))
        {
            return false;
        } else
        {
            return EMAIL_PATTERN.matcher(s).matches();
        }
    }

    static 
    {
        EMAIL_PATTERN = Patterns.EMAIL_ADDRESS;
    }
}
