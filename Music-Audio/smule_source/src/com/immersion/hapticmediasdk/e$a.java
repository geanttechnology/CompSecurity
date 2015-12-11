// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk;


// Referenced classes of package com.immersion.hapticmediasdk:
//            e, b

public class 
{

    public static final int a[];
    public static int b = 88;
    public static int c = 1;
    public static int d = 2;

    static 
    {
        a = new int[com.immersion.hapticmediasdk.b.values().length];
        NoSuchFieldError nosuchfielderror;
        int i;
        try
        {
            a[b.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        a[b.b.ordinal()] = 2;
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
_L4:
        try
        {
            a[b.c.ordinal()] = 3;
        }
        // Misplaced declaration of an exception variable
        catch (NoSuchFieldError nosuchfielderror) { }
        a[b.f.ordinal()] = 4;
        i = b;
        switch ((i * (c + i)) % d)
        {
        default:
            b = 57;
            c = 26;
            break;

        case 0: // '\0'
            break;
        }
_L2:
        try
        {
            a[b.g.ordinal()] = 5;
        }
        // Misplaced declaration of an exception variable
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[b.h.ordinal()] = 6;
        }
        // Misplaced declaration of an exception variable
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[b.d.ordinal()] = 7;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
        nosuchfielderror;
        if (true) goto _L2; else goto _L1
_L1:
        nosuchfielderror;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
