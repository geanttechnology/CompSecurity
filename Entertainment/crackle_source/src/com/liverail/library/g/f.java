// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.g;

import java.util.HashMap;
import java.util.Map;

public class f
{

    public static final String a = "0";
    public static final String b = "300";
    public static final String c = "1";
    public Map d;
    public String e;

    public f()
    {
        d = new HashMap();
    }

    public void a(String s)
    {
        d.put("rtt", s);
    }

    public boolean a()
    {
        while (e == null || !e.startsWith("http")) 
        {
            return false;
        }
        return true;
    }

    public String b()
    {
        String s = (String)d.get("erc");
        if (s != null && s.length() > 0)
        {
            return s;
        } else
        {
            return "0";
        }
    }

    public void b(String s)
    {
        d.put("erc", s);
    }

    public String toString()
    {
        return (new StringBuilder("[AdSource ")).append(d).append(" url=").append(e).append("]").toString();
    }
}
