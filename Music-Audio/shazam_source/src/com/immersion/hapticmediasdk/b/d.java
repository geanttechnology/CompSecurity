// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.b;


public final class d
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
            a = 53;
            b = 53;
            // fall through

        case 0: // '\0'
            super();
            break;
        }
        e = true;
    }

    public final boolean a()
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
