// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.b.e;

import java.util.Iterator;
import java.util.Locale;

public final class a
{

    public static String a(Iterable iterable)
    {
        if (iterable != null)
        {
            if ((iterable = iterable.iterator()) != null)
            {
                if (!iterable.hasNext())
                {
                    return "";
                }
                Object obj = iterable.next();
                if (!iterable.hasNext())
                {
                    return String.valueOf(obj);
                }
                StringBuilder stringbuilder = new StringBuilder(256);
                if (obj != null)
                {
                    stringbuilder.append(obj);
                }
                do
                {
                    if (!iterable.hasNext())
                    {
                        break;
                    }
                    stringbuilder.append(',');
                    Object obj1 = iterable.next();
                    if (obj1 != null)
                    {
                        stringbuilder.append(obj1);
                    }
                } while (true);
                return stringbuilder.toString();
            }
        }
        return null;
    }

    public static boolean a(String s)
    {
        boolean flag1 = false;
        boolean flag;
        if (s == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag || s.isEmpty())
        {
            flag1 = true;
        }
        return flag1;
    }

    public static boolean b(String s)
    {
        boolean flag;
        if (s == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return !flag;
    }

    public static boolean c(String s)
    {
        return !a(s);
    }

    public static String d(String s)
    {
        String s1 = s;
        if (c(s))
        {
            s1 = s.toUpperCase(Locale.getDefault());
        }
        return s1;
    }
}
