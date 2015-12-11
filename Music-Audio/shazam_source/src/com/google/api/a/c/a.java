// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c;


public final class a
{

    public static final Integer a;
    public static final Integer b;
    public static final Integer c;
    public static final String d;

    static 
    {
        a = Integer.valueOf(1);
        b = Integer.valueOf(20);
        c = Integer.valueOf(0);
        String s = String.valueOf(String.valueOf(a));
        String s1 = String.valueOf(String.valueOf(b));
        String s2 = String.valueOf(String.valueOf(c));
        d = (new StringBuilder(s.length() + 2 + s1.length() + s2.length())).append(s).append(".").append(s1).append(".").append(s2).toString().toString();
    }
}
