// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils.do.do;

import java.util.Map;

public final class a
{

    private String a;
    private Map b;

    private a(String s, Map map)
    {
        a = s;
        b = map;
    }

    public static a a(String s, Map map)
    {
        return new a(s, map);
    }

    public final String a()
    {
        return a;
    }

    public final Map b()
    {
        return b;
    }
}
