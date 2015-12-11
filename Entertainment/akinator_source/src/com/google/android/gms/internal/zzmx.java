// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


public final class zzmx
{

    public static boolean isAtLeastL()
    {
        return zzqD();
    }

    private static boolean zzcd(int i)
    {
        return android.os.Build.VERSION.SDK_INT >= i;
    }

    public static boolean zzqA()
    {
        return zzcd(18);
    }

    public static boolean zzqB()
    {
        return zzcd(19);
    }

    public static boolean zzqC()
    {
        return zzcd(20);
    }

    public static boolean zzqD()
    {
        return zzcd(21);
    }

    public static boolean zzqE()
    {
        return zzcd(23);
    }

    public static boolean zzqu()
    {
        return zzcd(11);
    }

    public static boolean zzqv()
    {
        return zzcd(12);
    }

    public static boolean zzqw()
    {
        return zzcd(13);
    }

    public static boolean zzqx()
    {
        return zzcd(14);
    }

    public static boolean zzqy()
    {
        return zzcd(16);
    }

    public static boolean zzqz()
    {
        return zzcd(17);
    }
}
