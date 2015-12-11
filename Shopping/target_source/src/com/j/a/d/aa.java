// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import com.j.a.g.b;
import com.j.a.g.m;
import java.util.HashMap;

public class aa
{

    private static aa b;
    private HashMap a;

    public aa()
    {
        a = new HashMap();
    }

    public static aa a()
    {
        if (b != null)
        {
            return b;
        } else
        {
            b = new aa();
            return b;
        }
    }

    public void a(String s)
    {
        while (m.a(b.r) || !a.containsKey(s)) 
        {
            return;
        }
        ((com.j.a.b)a.get(s)).a();
    }

    public void a(String s, com.j.a.b b1)
    {
        a.put(s, b1);
    }
}
