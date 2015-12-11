// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;

import java.nio.MappedByteBuffer;

public class e
{

    public static int c = 32;
    public static int d = 0;
    public static int e = 1;
    public static int f = 2;
    public int a;
    public MappedByteBuffer b;

    private e()
    {
        if (((c + e) * c) % f != d)
        {
            c = a();
            d = 95;
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

    public e(com.immersion.hapticmediasdk.a.g.a a1)
    {
        if (((c + b()) * c) % c() != d)
        {
            c = a();
            d = a();
        }
        try
        {
            this();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.immersion.hapticmediasdk.a.g.a a1)
        {
            throw a1;
        }
    }

    public static int a()
    {
        return 13;
    }

    public static int b()
    {
        return 1;
    }

    public static int c()
    {
        return 2;
    }
}
