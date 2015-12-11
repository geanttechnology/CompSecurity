// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


public final class p
{

    boolean a;
    String b;
    int c;

    p(boolean flag, String s, int i)
    {
        a = flag;
        b = s;
        c = i;
    }

    public final String toString()
    {
        if (a)
        {
            return (new StringBuilder()).append(b).append(":").append(c).toString();
        } else
        {
            return "no reward";
        }
    }
}
