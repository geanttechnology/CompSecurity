// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class jc
{

    private static final String a = com/flurry/sdk/jc.getSimpleName();
    private boolean b;
    private long c;
    private final List d = new ArrayList();

    public jc()
    {
    }

    static long a(jc jc1, long l)
    {
        jc1.c = l;
        return l;
    }

    static List a(jc jc1)
    {
        return jc1.d;
    }

    static boolean a(jc jc1, boolean flag)
    {
        jc1.b = flag;
        return flag;
    }

    public boolean a()
    {
        return b;
    }

    public long b()
    {
        return c;
    }

    public List c()
    {
        return Collections.unmodifiableList(d);
    }

}
