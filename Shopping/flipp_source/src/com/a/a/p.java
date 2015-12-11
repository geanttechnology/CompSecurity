// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;


public final class p
{

    public final String a;
    public final String b;

    public p(String s, String s1)
    {
        a = s;
        b = s1;
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof p) && ((p)obj).a.equals(a) && ((p)obj).b.equals(b);
    }

    public final int hashCode()
    {
        return a.hashCode() + b.hashCode() * 31;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(a).append(" realm=\"").append(b).append("\"").toString();
    }
}
