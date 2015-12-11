// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.a;

import java.util.Map;

public class c
{

    private static final String a = com/smule/pianoandroid/a/c.getSimpleName();

    public c()
    {
    }

    public static Object a(Map map, String s)
    {
        if (map == null)
        {
            return null;
        }
        s = s.split("\\.", 2);
        if (s.length == 1)
        {
            return map.get(s[0]);
        } else
        {
            return a((Map)map.get(s[0]), s[1]);
        }
    }

    static String a()
    {
        return a;
    }

}
