// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma.internal;


public final class a
{

    public static RuntimeException a(Throwable throwable)
    {
        b(throwable);
        return null;
    }

    public static void b(Throwable throwable)
    {
        c(throwable);
    }

    private static void c(Throwable throwable)
    {
        throw throwable;
    }
}
