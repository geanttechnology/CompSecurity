// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;


// Referenced classes of package com.immersion.hapticmediasdk.a:
//            c

public final class c
    implements Runnable
{

    public static int b = 48;
    public static int c = 0;
    public static int d = 1;
    public static int e = 2;
    public final c a;

    public final void run()
    {
        c c1;
        try
        {
            c1 = a;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        if (((b + d) * b) % e != c)
        {
            b = 15;
            c = 40;
        }
        try
        {
            com.immersion.hapticmediasdk.a.c.k(c1);
            return;
        }
        catch (Exception exception)
        {
            throw exception;
        }
    }

    public (c c1)
    {
        a = c1;
        if (((b + d) * b) % 2 != c)
        {
            b = 15;
            c = 15;
        }
        super();
    }
}
