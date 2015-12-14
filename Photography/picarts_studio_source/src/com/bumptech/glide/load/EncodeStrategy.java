// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load;


public final class EncodeStrategy extends Enum
{

    private static final EncodeStrategy $VALUES[];
    public static final EncodeStrategy NONE;
    public static final EncodeStrategy SOURCE;
    public static final EncodeStrategy TRANSFORMED;

    private EncodeStrategy(String s, int i)
    {
        super(s, i);
    }

    public static EncodeStrategy valueOf(String s)
    {
        return (EncodeStrategy)Enum.valueOf(com/bumptech/glide/load/EncodeStrategy, s);
    }

    public static EncodeStrategy[] values()
    {
        return (EncodeStrategy[])$VALUES.clone();
    }

    static 
    {
        SOURCE = new EncodeStrategy("SOURCE", 0);
        TRANSFORMED = new EncodeStrategy("TRANSFORMED", 1);
        NONE = new EncodeStrategy("NONE", 2);
        $VALUES = (new EncodeStrategy[] {
            SOURCE, TRANSFORMED, NONE
        });
    }
}
