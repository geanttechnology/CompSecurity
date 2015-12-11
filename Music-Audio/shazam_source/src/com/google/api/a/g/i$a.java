// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import com.google.api.a.f.a.a.a.a.c;

// Referenced classes of package com.google.api.a.g:
//            i, k, f

final class a.a.c.a
    implements java.util.Entry
{

    final i a;
    private Object b;
    private final k c;

    private String a()
    {
        String s1 = c.c;
        String s = s1;
        if (a.b.b)
        {
            s = s1.toLowerCase();
        }
        return s;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof java.util.Entry))
            {
                return false;
            }
            obj = (java.util.Entry)obj;
            if (!a().equals(((java.util.Entry) (obj)).getKey()) || !getValue().equals(((java.util.Entry) (obj)).getValue()))
            {
                return false;
            }
        }
        return true;
    }

    public final Object getKey()
    {
        return a();
    }

    public final Object getValue()
    {
        return b;
    }

    public final int hashCode()
    {
        return a().hashCode() ^ getValue().hashCode();
    }

    public final Object setValue(Object obj)
    {
        Object obj1 = b;
        b = com.google.api.a.f.a.a.a.a.c.a(obj);
        c.a(a.a, obj);
        return obj1;
    }

    a.a.c(i j, k k1, Object obj)
    {
        a = j;
        super();
        c = k1;
        b = com.google.api.a.f.a.a.a.a.c.a(obj);
    }
}
