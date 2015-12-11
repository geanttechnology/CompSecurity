// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;


public final class WatchlistOption extends Enum
{

    private static final WatchlistOption $VALUES[];
    public static final WatchlistOption ADD;
    public static final WatchlistOption DELETE;

    private WatchlistOption(String s, int i)
    {
        super(s, i);
    }

    public static WatchlistOption valueOf(String s)
    {
        return (WatchlistOption)Enum.valueOf(com/offerup/android/dto/WatchlistOption, s);
    }

    public static WatchlistOption[] values()
    {
        return (WatchlistOption[])$VALUES.clone();
    }

    static 
    {
        ADD = new WatchlistOption("ADD", 0);
        DELETE = new WatchlistOption("DELETE", 1);
        $VALUES = (new WatchlistOption[] {
            ADD, DELETE
        });
    }
}
