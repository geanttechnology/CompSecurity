// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request;


final class  extends Enum
{

    private static final PAUSED $VALUES[];
    public static final PAUSED CANCELLED;
    public static final PAUSED CLEARED;
    public static final PAUSED COMPLETE;
    public static final PAUSED FAILED;
    public static final PAUSED PAUSED;
    public static final PAUSED PENDING;
    public static final PAUSED RUNNING;
    public static final PAUSED WAITING_FOR_SIZE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/bumptech/glide/request/SingleRequest$Status, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PENDING = new <init>("PENDING", 0);
        RUNNING = new <init>("RUNNING", 1);
        WAITING_FOR_SIZE = new <init>("WAITING_FOR_SIZE", 2);
        COMPLETE = new <init>("COMPLETE", 3);
        FAILED = new <init>("FAILED", 4);
        CANCELLED = new <init>("CANCELLED", 5);
        CLEARED = new <init>("CLEARED", 6);
        PAUSED = new <init>("PAUSED", 7);
        $VALUES = (new .VALUES[] {
            PENDING, RUNNING, WAITING_FOR_SIZE, COMPLETE, FAILED, CANCELLED, CLEARED, PAUSED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
