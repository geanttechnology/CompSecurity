// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load;


public final class DecodeFormat extends Enum
{

    private static final DecodeFormat $VALUES[];
    public static final DecodeFormat DEFAULT;
    public static final DecodeFormat PREFER_ARGB_8888;
    public static final DecodeFormat PREFER_RGB_565;

    private DecodeFormat(String s, int i)
    {
        super(s, i);
    }

    public static DecodeFormat valueOf(String s)
    {
        return (DecodeFormat)Enum.valueOf(com/bumptech/glide/load/DecodeFormat, s);
    }

    public static DecodeFormat[] values()
    {
        return (DecodeFormat[])$VALUES.clone();
    }

    static 
    {
        PREFER_ARGB_8888 = new DecodeFormat("PREFER_ARGB_8888", 0);
        PREFER_RGB_565 = new DecodeFormat("PREFER_RGB_565", 1);
        $VALUES = (new DecodeFormat[] {
            PREFER_ARGB_8888, PREFER_RGB_565
        });
        DEFAULT = PREFER_ARGB_8888;
    }
}
