// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.models;


public class b extends Exception
{

    public static int a = 24;
    public static int b = 0;
    public static int c = 1;
    public static int d = 2;
    private int e;

    public b(int i, String s)
    {
        super(s);
label0:
        do
        {
            switch (1)
            {
            default:
                while (true) 
                {
                    switch (0)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        break label0;

                    case 1: // '\001'
                        continue label0;
                    }
                }
                break;

            case 0: // '\0'
                break;

            case 1: // '\001'
                break label0;
            }
        } while (true);
        if (((a + c) * a) % d != b)
        {
            a = 74;
            b = 98;
        }
        e = i;
    }

    public static int b()
    {
        return 1;
    }

    public static int c()
    {
        return 75;
    }

    public int a()
    {
        if (((a + b()) * a) % d != b)
        {
            a = c();
            b = c();
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
