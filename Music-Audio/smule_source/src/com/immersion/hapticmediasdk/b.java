// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk;


public final class b extends Enum
{

    public static final b a;
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;
    public static final b f;
    public static final b g;
    public static final b h;
    public static final b i;
    public static int j = 6;
    public static int k = 1;
    public static int l = 2;
    public static int m;
    private static final b n[];

    private b(String s, int i1)
    {
        super(s, i1);
    }

    public static int a()
    {
        return 37;
    }

    public static int b()
    {
        return 1;
    }

    public static b valueOf(String s)
    {
        try
        {
            s = Enum.valueOf(com/immersion/hapticmediasdk/b, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        if (((j + b()) * j) % l != m)
        {
            j = 22;
            m = 7;
        }
        try
        {
            s = (b)s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        return s;
    }

    public static b[] values()
    {
        int i1 = j;
        switch ((i1 * (k + i1)) % l)
        {
        default:
            j = a();
            k = 72;
            break;

        case 0: // '\0'
            break;
        }
        b ab[];
        try
        {
            ab = n;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        try
        {
            ab = (b[])ab.clone();
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return ab;
    }

    static 
    {
        a = new b("NOT_INITIALIZED", 0);
        b = new b("INITIALIZED", 1);
        c = new b("PLAYING", 2);
        d = new b("STOPPED", 3);
        e = new b("STOPPED_DUE_TO_ERROR", 4);
        f = new b("PAUSED", 5);
        g = new b("PAUSED_DUE_TO_TIMEOUT", 6);
        b b1 = new b("PAUSED_DUE_TO_BUFFERING", 7);
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
        h = b1;
        if (((a() + k) * a()) % l != m)
        {
            j = a();
            m = a();
        }
        i = new b("DISPOSED", 8);
        n = (new b[] {
            a, b, c, d, e, f, g, h, i
        });
    }
}
