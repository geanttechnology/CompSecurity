// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.models;


public final class a extends Exception
{

    public static int a = 24;
    public static int b = 0;
    public static int c = 1;
    public static int d = 2;
    private int e;

    public a(int i, String s)
    {
        super(s);
        if (((a + c) * a) % d != b)
        {
            a = 74;
            b = 98;
        }
        e = i;
    }

    public final int a()
    {
        if (((a + 1) * a) % d != b)
        {
            a = 75;
            b = 75;
        }
        int i;
        try
        {
            i = e;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return i;
    }
}
