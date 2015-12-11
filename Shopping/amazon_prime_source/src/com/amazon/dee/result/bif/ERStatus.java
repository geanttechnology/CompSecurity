// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;


public final class ERStatus extends Enum
{

    private static final ERStatus $VALUES[];
    public static final ERStatus ER_APP_FILLED;
    public static final ERStatus ER_EXCEPTION;
    public static final ERStatus ER_NO_MATCH;
    public static final ERStatus ER_SUCCESS;
    public static final ERStatus ER_TIMEOUT;

    private ERStatus(String s, int i)
    {
        super(s, i);
    }

    public static ERStatus valueOf(String s)
    {
        return (ERStatus)Enum.valueOf(com/amazon/dee/result/bif/ERStatus, s);
    }

    public static ERStatus[] values()
    {
        return (ERStatus[])$VALUES.clone();
    }

    static 
    {
        ER_EXCEPTION = new ERStatus("ER_EXCEPTION", 0);
        ER_TIMEOUT = new ERStatus("ER_TIMEOUT", 1);
        ER_NO_MATCH = new ERStatus("ER_NO_MATCH", 2);
        ER_SUCCESS = new ERStatus("ER_SUCCESS", 3);
        ER_APP_FILLED = new ERStatus("ER_APP_FILLED", 4);
        $VALUES = (new ERStatus[] {
            ER_EXCEPTION, ER_TIMEOUT, ER_NO_MATCH, ER_SUCCESS, ER_APP_FILLED
        });
    }
}
