// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.cloud9.android.knobs;

import android.os.SystemProperties;
import java.util.HashMap;
import java.util.Map;

public class Knobs
{

    private static final Map overrides = new HashMap();

    private Knobs()
    {
    }

    private static Object firstNonNull(Object obj, Object obj1)
    {
        if (obj != null)
        {
            return obj;
        } else
        {
            return obj1;
        }
    }

    public static int get(String s, int i)
    {
        return Integer.parseInt(get(s, Integer.toString(i)));
    }

    public static String get(String s, String s1)
    {
        return (String)firstNonNull(overrides.get(s), SystemProperties.get(s, s1));
    }

    public static boolean get(String s, boolean flag)
    {
        return Boolean.parseBoolean(get(s, Boolean.toString(flag)));
    }

}
