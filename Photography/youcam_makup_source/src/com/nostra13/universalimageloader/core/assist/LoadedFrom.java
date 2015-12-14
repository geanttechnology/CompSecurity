// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;


public final class LoadedFrom extends Enum
{

    public static final LoadedFrom a;
    public static final LoadedFrom b;
    public static final LoadedFrom c;
    private static final LoadedFrom d[];

    private LoadedFrom(String s, int i)
    {
        super(s, i);
    }

    public static LoadedFrom valueOf(String s)
    {
        return (LoadedFrom)Enum.valueOf(com/nostra13/universalimageloader/core/assist/LoadedFrom, s);
    }

    public static LoadedFrom[] values()
    {
        return (LoadedFrom[])d.clone();
    }

    static 
    {
        a = new LoadedFrom("NETWORK", 0);
        b = new LoadedFrom("DISC_CACHE", 1);
        c = new LoadedFrom("MEMORY_CACHE", 2);
        d = (new LoadedFrom[] {
            a, b, c
        });
    }
}
