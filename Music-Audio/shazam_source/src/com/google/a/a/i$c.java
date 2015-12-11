// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a;

import java.io.Serializable;

// Referenced classes of package com.google.a.a:
//            h, i, g

private static final class a
    implements h, Serializable
{

    final h a;

    public final boolean a(Object obj)
    {
        return !a.a(obj);
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof a)
        {
            obj = (a)obj;
            return a.equals(((uals) (obj)).a);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return ~a.hashCode();
    }

    public final String toString()
    {
        String s = String.valueOf(String.valueOf(a.toString()));
        return (new StringBuilder(s.length() + 16)).append("Predicates.not(").append(s).append(")").toString();
    }

    lder(h h1)
    {
        a = (h)g.a(h1);
    }
}
