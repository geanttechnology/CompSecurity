// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph.brushes;


public final class  extends Enum
{

    private static final OUT $VALUES[];
    public static final OUT IN;
    public static final OUT OUT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/photo/morph/brushes/SqueezeBrush$Mode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IN = new <init>("IN", 0);
        OUT = new <init>("OUT", 1);
        $VALUES = (new .VALUES[] {
            IN, OUT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
