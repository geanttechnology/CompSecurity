// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe;


public final class  extends Enum
{

    public static final ERROR CLOSE_ABORTED;
    public static final ERROR CLOSE_FINISHED;
    private static final ERROR ENUM$VALUES[];
    public static final ERROR ERROR;
    public static final ERROR PENDING_CLOSE;
    public static final ERROR STARTED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/sponsorpay/publisher/mbe/SPBrandEngageClientStatusListener$SPBrandEngageClientStatus, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        STARTED = new <init>("STARTED", 0);
        CLOSE_FINISHED = new <init>("CLOSE_FINISHED", 1);
        CLOSE_ABORTED = new <init>("CLOSE_ABORTED", 2);
        PENDING_CLOSE = new <init>("PENDING_CLOSE", 3);
        ERROR = new <init>("ERROR", 4);
        ENUM$VALUES = (new ENUM.VALUES[] {
            STARTED, CLOSE_FINISHED, CLOSE_ABORTED, PENDING_CLOSE, ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
