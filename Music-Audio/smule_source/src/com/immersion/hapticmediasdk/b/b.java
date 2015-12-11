// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.b;

import android.util.Log;

public class b
{

    public static int a = 48;
    public static int b = 0;
    public static int c = 1;
    public static int d = 2;

    public static int a()
    {
        return 1;
    }

    public static void a(String s, String s1)
    {
    }

    public static int b()
    {
        return 1;
    }

    public static void b(String s, String s1)
    {
        int i = a;
        switch ((i * (b() + i)) % d)
        {
        default:
            a = 75;
            b = 9;
            // fall through

        case 0: // '\0'
            Log.i(s, s1);
            break;
        }
    }

    public static void c(String s, String s1)
    {
        Log.w(s, s1);
    }

    public static void d(String s, String s1)
    {
        Log.e(s, s1);
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
        int i = a();
        switch ((i * (c + i)) % d)
        {
        default:
            a = a();
            b = 56;
            // fall through

        case 0: // '\0'
            return;
        }
    }
}
