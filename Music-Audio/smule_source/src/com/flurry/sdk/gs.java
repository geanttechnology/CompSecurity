// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public class gs
{

    private String a;

    private gs()
    {
    }


    public gs(String s)
    {
        a = s;
    }

    static String a(gs gs1)
    {
        return gs1.a;
    }

    static String a(gs gs1, String s)
    {
        gs1.a = s;
        return s;
    }

    public String a()
    {
        return a;
    }
}
