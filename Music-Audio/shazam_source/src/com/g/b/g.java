// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import com.g.b.a.k;

public final class g
{

    public final String a;
    public final String b;

    public g(String s, String s1)
    {
        a = s;
        b = s1;
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof g) && k.a(a, ((g)obj).a) && k.a(b, ((g)obj).b);
    }

    public final int hashCode()
    {
        int j = 0;
        int i;
        if (b != null)
        {
            i = b.hashCode();
        } else
        {
            i = 0;
        }
        if (a != null)
        {
            j = a.hashCode();
        }
        return (i + 899) * 31 + j;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(a).append(" realm=\"").append(b).append("\"").toString();
    }
}
