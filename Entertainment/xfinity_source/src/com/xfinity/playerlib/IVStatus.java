// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib;


public final class IVStatus extends Enum
{

    private static final IVStatus $VALUES[];
    public static final IVStatus IV_FAILED;
    public static final IVStatus IV_SUCCESS;
    public static final IVStatus PENDING;

    private IVStatus(String s, int i)
    {
        super(s, i);
    }

    public static IVStatus valueOf(String s)
    {
        return (IVStatus)Enum.valueOf(com/xfinity/playerlib/IVStatus, s);
    }

    public static IVStatus[] values()
    {
        return (IVStatus[])$VALUES.clone();
    }

    static 
    {
        PENDING = new IVStatus("PENDING", 0);
        IV_FAILED = new IVStatus("IV_FAILED", 1);
        IV_SUCCESS = new IVStatus("IV_SUCCESS", 2);
        $VALUES = (new IVStatus[] {
            PENDING, IV_FAILED, IV_SUCCESS
        });
    }
}
