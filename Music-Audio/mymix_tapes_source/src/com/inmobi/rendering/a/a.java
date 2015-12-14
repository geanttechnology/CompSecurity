// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.a;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

final class a
{

    int a;
    String b;
    long c;
    int d;
    AtomicBoolean e;
    boolean f;
    boolean g;

    public a(int i, String s, boolean flag, boolean flag1, int j, long l)
    {
        a = i;
        b = s;
        c = l;
        d = j;
        e = new AtomicBoolean(false);
        g = flag;
        f = flag1;
    }

    public a(String s, boolean flag, boolean flag1, int i)
    {
        this(0x7fffffff & (new Random()).nextInt(), s, flag, flag1, i, System.currentTimeMillis());
    }
}
