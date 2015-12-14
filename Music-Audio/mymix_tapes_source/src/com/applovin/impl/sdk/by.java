// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;


// Referenced classes of package com.applovin.impl.sdk:
//            bx

public class by
    implements Comparable
{

    private static int a = 0;
    private final int b;
    private final String c;
    private final Object d;

    private by(String s, Object obj)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("No name specified");
        }
        if (obj == null)
        {
            throw new IllegalArgumentException("No default value specified");
        } else
        {
            c = s;
            d = obj;
            b = a;
            a++;
            return;
        }
    }

    by(String s, Object obj, bx bx)
    {
        this(s, obj);
    }

    public int a()
    {
        return b;
    }

    Object a(Object obj)
    {
        return d.getClass().cast(obj);
    }

    public String b()
    {
        return c;
    }

    public Object c()
    {
        return d;
    }

    public int compareTo(Object obj)
    {
        if (obj != null && (obj instanceof by))
        {
            return c.compareTo(((by)obj).b());
        } else
        {
            return 0;
        }
    }

}
