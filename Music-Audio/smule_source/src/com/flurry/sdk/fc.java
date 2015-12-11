// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fc
{

    private static final String a = com/flurry/sdk/fc.getSimpleName();
    private boolean b;
    private long c;
    private final List d = new ArrayList();

    public fc()
    {
    }

    static long a(fc fc1, long l)
    {
        fc1.c = l;
        return l;
    }

    static List a(fc fc1)
    {
        return fc1.d;
    }

    static boolean a(fc fc1, boolean flag)
    {
        fc1.b = flag;
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
