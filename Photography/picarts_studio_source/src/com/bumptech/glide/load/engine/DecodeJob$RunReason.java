// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;


public final class  extends Enum
{

    private static final DECODE_DATA $VALUES[];
    public static final DECODE_DATA DECODE_DATA;
    public static final DECODE_DATA INITIALIZE;
    public static final DECODE_DATA SWITCH_TO_SOURCE_SERVICE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/bumptech/glide/load/engine/DecodeJob$RunReason, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INITIALIZE = new <init>("INITIALIZE", 0);
        SWITCH_TO_SOURCE_SERVICE = new <init>("SWITCH_TO_SOURCE_SERVICE", 1);
        DECODE_DATA = new <init>("DECODE_DATA", 2);
        $VALUES = (new .VALUES[] {
            INITIALIZE, SWITCH_TO_SOURCE_SERVICE, DECODE_DATA
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
