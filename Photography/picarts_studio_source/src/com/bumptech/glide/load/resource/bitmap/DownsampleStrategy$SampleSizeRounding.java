// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;


public final class  extends Enum
{

    private static final QUALITY $VALUES[];
    public static final QUALITY MEMORY;
    public static final QUALITY QUALITY;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/bumptech/glide/load/resource/bitmap/DownsampleStrategy$SampleSizeRounding, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MEMORY = new <init>("MEMORY", 0);
        QUALITY = new <init>("QUALITY", 1);
        $VALUES = (new .VALUES[] {
            MEMORY, QUALITY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
