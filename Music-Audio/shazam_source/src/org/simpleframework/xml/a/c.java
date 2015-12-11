// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.a;

import java.util.Map;

// Referenced classes of package org.simpleframework.xml.a:
//            b

public final class c
    implements b
{

    private b a;
    private Map b;

    public c(Map map)
    {
        this(map, (byte)0);
    }

    private c(Map map, byte byte0)
    {
        a = null;
        b = map;
    }

    public final String a(String s)
    {
        Object obj1 = null;
        Object obj;
        if (b != null)
        {
            obj = b.get(s);
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            obj = obj.toString();
        } else
        {
            obj = obj1;
            if (a != null)
            {
                return a.a(s);
            }
        }
        return ((String) (obj));
    }
}
