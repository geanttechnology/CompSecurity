// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a;

import java.io.Serializable;

// Referenced classes of package com.google.a.a:
//            h, i

private static final class <init>
    implements h, Serializable
{

    private final Object a;

    public final boolean a(Object obj)
    {
        return a.equals(obj);
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof uals)
        {
            obj = (uals)obj;
            return a.equals(((uals) (obj)).a);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return a.hashCode();
    }

    public final String toString()
    {
        String s = String.valueOf(String.valueOf(a));
        return (new StringBuilder(s.length() + 20)).append("Predicates.equalTo(").append(s).append(")").toString();
    }

    private lder(Object obj)
    {
        a = obj;
    }

    a(Object obj, byte byte0)
    {
        this(obj);
    }
}
