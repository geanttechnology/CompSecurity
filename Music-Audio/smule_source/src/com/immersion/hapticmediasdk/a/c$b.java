// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;


// Referenced classes of package com.immersion.hapticmediasdk.a:
//            c

public class a
    implements Runnable
{

    public static int b = 2;
    public static int c = 1;
    public static int d = 2;
    public static int e;
    public final c a;

    public static int a()
    {
        return 54;
    }

    public void run()
    {
        com.immersion.hapticmediasdk.a.c.c(a);
    }

    public (c c1)
    {
label0:
        do
        {
            switch (0)
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
                break label0;

            case 1: // '\001'
                break;
            }
        } while (true);
        int i = b;
        switch ((i * (c + i)) % d)
        {
        default:
            b = a();
            c = a();
            // fall through

        case 0: // '\0'
            a = c1;
            break;
        }
        super();
    }
}
