// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import com.mopub.common.d.j;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public final class e
{

    private static Integer a(String s)
    {
        NumberFormat numberformat = NumberFormat.getInstance(Locale.US);
        numberformat.setParseIntegerOnly(true);
        int i;
        try
        {
            i = numberformat.parse(s.trim()).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return Integer.valueOf(i);
    }

    public static String a(Map map, j j1)
    {
        return (String)map.get(j1.x);
    }

    public static Integer b(Map map, j j1)
    {
        return a(a(map, j1));
    }

    public static boolean c(Map map, j j1)
    {
        map = a(map, j1);
        if (map == null)
        {
            return false;
        } else
        {
            return map.equals("1");
        }
    }
}
