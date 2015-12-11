// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


public final class ip
{

    private static boolean aF(int i)
    {
        return android.os.Build.VERSION.SDK_INT >= i;
    }

    public static boolean gc()
    {
        return aF(11);
    }

    public static boolean ge()
    {
        return aF(13);
    }

    public static boolean gf()
    {
        return aF(14);
    }
}
