// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.do;

import java.util.List;
import java.util.Map;

public final class c
{

    private String a;
    private String b;
    private String c;
    private List d;

    public c()
    {
    }

    public c(Map map)
    {
label0:
        {
            super();
            if (map.containsKey("type"))
            {
                a = (String)map.get("type");
            }
            if (map.containsKey("match"))
            {
                b = (String)map.get("match");
            }
            if (map.containsKey("value"))
            {
                if (!a.equals("array"))
                {
                    break label0;
                }
                d = (List)map.get("value");
            }
            return;
        }
        c = (String)map.get("value");
    }

    public final String a()
    {
        return a;
    }

    public final String b()
    {
        return b;
    }

    public final String c()
    {
        return c;
    }

    public final List d()
    {
        return d;
    }
}
