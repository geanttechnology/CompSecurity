// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import com.cyberlink.youcammakeup.utility.at;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class o
{

    private List a;
    private Map b;

    public o()
    {
        a = null;
        b = null;
        a = new ArrayList();
        b = new HashMap();
    }

    public o(o o1)
    {
        this();
        if (o1 != null)
        {
            a.addAll(o1.a);
            b.putAll(o1.b);
        }
    }

    public List a()
    {
        return new ArrayList(a);
    }

    public void a(String s)
    {
        a(s, null);
    }

    public void a(String s, at at1)
    {
        a.add(s);
        b.put(s, new at(at1));
    }

    public at b(String s)
    {
        return (at)b.get(s);
    }
}
