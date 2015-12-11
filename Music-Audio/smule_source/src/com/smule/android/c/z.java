// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;

import java.util.HashMap;
import java.util.Map;

public class z
{

    private Map a;

    public z()
    {
        a = new HashMap();
    }

    static Map a(z z1)
    {
        return z1.a;
    }

    public z a(String s, String s1)
    {
        a.put(s, s1);
        return this;
    }
}
