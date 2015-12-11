// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics;


public final class h
{

    public static final long NONSENSE_TIME_MS = -1L;
    private boolean isValid;
    private final long when = System.currentTimeMillis();

    public h()
    {
        isValid = true;
    }

    public static long a(h h1)
    {
        if (h1 == null || !h1.b())
        {
            return -1L;
        } else
        {
            return System.currentTimeMillis() - h1.c();
        }
    }

    public void a()
    {
        isValid = false;
    }

    public boolean b()
    {
        return isValid;
    }

    public long c()
    {
        return when;
    }
}
