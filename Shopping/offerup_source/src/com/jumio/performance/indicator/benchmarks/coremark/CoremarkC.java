// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.performance.indicator.benchmarks.coremark;

import jumiomobile.pi;
import jumiomobile.pj;

public class CoremarkC extends pi
{

    public CoremarkC()
    {
    }

    public static String g()
    {
        return "CoreMark";
    }

    public static native double runCoremark();

    protected double b()
    {
        return runCoremark();
    }

    public String c()
    {
        return g();
    }

    public String e()
    {
        return "Instr./Sec";
    }

    public pj f()
    {
        if (d() == null)
        {
            a();
        }
        if (d().doubleValue() > 3000D)
        {
            return pj.c;
        }
        if (d().doubleValue() < 2000D)
        {
            return pj.a;
        } else
        {
            return pj.b;
        }
    }
}
