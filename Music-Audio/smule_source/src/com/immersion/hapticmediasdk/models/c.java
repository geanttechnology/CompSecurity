// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.models;


public class c extends Exception
{

    public static int a = 89;
    public static int b = 0;
    public static int c = 1;
    public static int d = 2;

    public c(String s)
    {
        if (((a + c) * a) % d != b)
        {
            a = 11;
            b = 70;
        }
        try
        {
            super(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
    }
}
