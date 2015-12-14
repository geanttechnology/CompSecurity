// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;


public final class  extends Enum
{

    private static final FINISHED $VALUES[];
    public static final FINISHED DATA_CACHE;
    public static final FINISHED ENCODE;
    public static final FINISHED FINISHED;
    public static final FINISHED INITIALIZE;
    public static final FINISHED RESOURCE_CACHE;
    public static final FINISHED SOURCE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/bumptech/glide/load/engine/DecodeJob$Stage, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INITIALIZE = new <init>("INITIALIZE", 0);
        RESOURCE_CACHE = new <init>("RESOURCE_CACHE", 1);
        DATA_CACHE = new <init>("DATA_CACHE", 2);
        SOURCE = new <init>("SOURCE", 3);
        ENCODE = new <init>("ENCODE", 4);
        FINISHED = new <init>("FINISHED", 5);
        $VALUES = (new .VALUES[] {
            INITIALIZE, RESOURCE_CACHE, DATA_CACHE, SOURCE, ENCODE, FINISHED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
