// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;


public final class  extends Enum
{

    private static final RADIAL $VALUES[];
    public static final RADIAL LINEAR;
    public static final RADIAL RADIAL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/studio/editor/fragment/TiltShiftFragment$TiltShiftMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LINEAR = new <init>("LINEAR", 0);
        RADIAL = new <init>("RADIAL", 1);
        $VALUES = (new .VALUES[] {
            LINEAR, RADIAL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
