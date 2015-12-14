// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.utility.image;


public final class  extends Enum
{

    private static final IN_MEMORY $VALUES[];
    public static final IN_MEMORY IN_MEMORY;
    public static final IN_MEMORY SYNC_IO;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/wantu/utility/image/BinaryBitmapCache$CacheStratigy, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SYNC_IO = new <init>("SYNC_IO", 0);
        IN_MEMORY = new <init>("IN_MEMORY", 1);
        $VALUES = (new .VALUES[] {
            SYNC_IO, IN_MEMORY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
