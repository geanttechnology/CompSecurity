// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.b;


public class d
{

    public static int a = 88;
    public static int b = 1;
    public static int c = 2;
    public static int d;
    private boolean e;

    public d()
    {
        int i = a;
        switch ((i * (b + i)) % c)
        {
        default:
            a = a();
            b = a();
            // fall through

        case 0: // '\0'
            super();
            break;
        }
label0:
        do
        {
            switch (0)
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
                break label0;

            case 1: // '\001'
                break;
            }
        } while (true);
        e = true;
    }

    public static int a()
    {
        return 53;
    }

    public boolean b()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = e;
        if (((a + b) * a) % c != d)
        {
            a = 88;
            d = 88;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Object obj;
        obj;
        throw obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }
}
