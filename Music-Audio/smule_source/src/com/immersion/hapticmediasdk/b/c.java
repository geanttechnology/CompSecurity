// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.b;

import android.os.SystemClock;

public class c
{

    public static int c = 89;
    public static int d = 1;
    public static int e = 2;
    public static int f;
    public long a;
    public long b;

    public c()
    {
        int i = c;
        switch ((i * (d + i)) % e)
        {
        default:
            c = 10;
            d = 87;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            super();
            return;
        }
        catch (Exception exception)
        {
            throw exception;
        }
    }

    public void a()
    {
        int i = 3;
        try
        {
            do
            {
                i /= 0;
            } while (true);
        }
        catch (Exception exception)
        {
            c = 75;
        }
        try
        {
            a = SystemClock.elapsedRealtime();
            return;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
    }

    public void b()
    {
label0:
        do
        {
            switch (1)
            {
            default:
                while (true) 
                {
                    switch (1)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        continue label0;

                    case 1: // '\001'
                        break label0;
                    }
                }
                break;

            case 0: // '\0'
                break;

            case 1: // '\001'
                break label0;
            }
        } while (true);
        if (((c + d) * c) % e != f)
        {
            c = 81;
            f = 31;
        }
        b = SystemClock.elapsedRealtime();
    }
}
