// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph.brushes;


public final class  extends Enum
{

    private static final LEFT $VALUES[];
    public static final LEFT LEFT;
    public static final LEFT RIGHT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/photo/morph/brushes/SwirlBrush$Mode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RIGHT = new <init>("RIGHT", 0);
        LEFT = new <init>("LEFT", 1);
        $VALUES = (new .VALUES[] {
            RIGHT, LEFT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
