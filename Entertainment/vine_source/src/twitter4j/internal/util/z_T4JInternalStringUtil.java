// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j.internal.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class z_T4JInternalStringUtil
{

    private z_T4JInternalStringUtil()
    {
        throw new AssertionError();
    }

    public static String join(List list)
    {
        StringBuilder stringbuilder = new StringBuilder(list.size() * 11);
        String s;
        for (list = list.iterator(); list.hasNext(); stringbuilder.append(s))
        {
            s = (String)list.next();
            if (stringbuilder.length() != 0)
            {
                stringbuilder.append(",");
            }
        }

        return stringbuilder.toString();
    }

    public static String join(int ai[])
    {
        StringBuilder stringbuilder = new StringBuilder(ai.length * 11);
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            int k = ai[i];
            if (stringbuilder.length() != 0)
            {
                stringbuilder.append(",");
            }
            stringbuilder.append(k);
        }

        return stringbuilder.toString();
    }

    public static String join(long al[])
    {
        StringBuilder stringbuilder = new StringBuilder(al.length * 11);
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            long l = al[i];
            if (stringbuilder.length() != 0)
            {
                stringbuilder.append(",");
            }
            stringbuilder.append(l);
        }

        return stringbuilder.toString();
    }

    public static String join(String as[])
    {
        StringBuilder stringbuilder = new StringBuilder(as.length * 11);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            if (stringbuilder.length() != 0)
            {
                stringbuilder.append(",");
            }
            stringbuilder.append(s);
        }

        return stringbuilder.toString();
    }

    public static String maskString(String s)
    {
        StringBuilder stringbuilder = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++)
        {
            stringbuilder.append("*");
        }

        return stringbuilder.toString();
    }

    public static String[] split(String s, String s1)
    {
        int i = s.indexOf(s1);
        if (i == -1)
        {
            return (new String[] {
                s
            });
        }
        ArrayList arraylist = new ArrayList();
        int j = 0;
        for (; i != -1; i = s.indexOf(s1, j))
        {
            arraylist.add(s.substring(j, i));
            j = i + s1.length();
        }

        if (j != s.length())
        {
            arraylist.add(s.substring(j));
        }
        return (String[])arraylist.toArray(new String[arraylist.size()]);
    }
}
