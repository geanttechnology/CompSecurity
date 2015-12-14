// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph.brushes;


public final class  extends Enum
{

    private static final AVERAGE $VALUES[];
    public static final AVERAGE AVERAGE;
    public static final AVERAGE PHOTOSHOP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/photo/morph/brushes/RestoreBrush$Mode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PHOTOSHOP = new <init>("PHOTOSHOP", 0);
        AVERAGE = new <init>("AVERAGE", 1);
        $VALUES = (new .VALUES[] {
            PHOTOSHOP, AVERAGE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
