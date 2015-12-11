// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.g;

import com.gimbal.internal.proximity.core.f.e;
import java.util.LinkedHashMap;
import java.util.Map;

public final class c
{

    private static c c;
    private static int d = 2500;
    public e a;
    public Map b;

    private c()
    {
        a = new com.gimbal.internal.proximity.core.f.c("proximity.datamasks", d);
        b = new LinkedHashMap();
    }

    public static c a()
    {
        if (c == null)
        {
            c = new c();
        }
        return c;
    }

    public final void a(String s, String s1)
    {
        s1 = com.gimbal.internal.c.c.a(s1);
        a.a(s1, s);
    }

}
