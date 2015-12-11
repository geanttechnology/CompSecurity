// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;


public class o
{

    private static boolean a = false;

    public static String a(String s)
    {
        String s1;
label0:
        {
            if (s != null)
            {
                s1 = s;
                if (s.length() != 0)
                {
                    break label0;
                }
            }
            s1 = "";
        }
        return s1;
    }

    public static boolean a()
    {
        return a;
    }

    public static void b()
    {
        if (!a)
        {
            a = true;
        }
    }

    public static void c()
    {
        a = false;
    }

}
