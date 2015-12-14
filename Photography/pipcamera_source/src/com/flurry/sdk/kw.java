// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public class kw
{

    private String a;

    private kw()
    {
    }


    public kw(String s)
    {
        a = s;
    }

    static String a(kw kw1)
    {
        return kw1.a;
    }

    static String a(kw kw1, String s)
    {
        kw1.a = s;
        return s;
    }

    public String a()
    {
        return a;
    }
}
