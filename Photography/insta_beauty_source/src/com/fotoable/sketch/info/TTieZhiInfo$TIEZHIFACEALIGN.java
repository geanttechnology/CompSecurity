// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.info;


public final class  extends Enum
{

    private static final FACEALIGN_BOTTOM $VALUES[];
    public static final FACEALIGN_BOTTOM FACEALIGN_BOTTOM;
    public static final FACEALIGN_BOTTOM FACEALIGN_CENTER;
    public static final FACEALIGN_BOTTOM FACEALIGN_TOP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/sketch/info/TTieZhiInfo$TIEZHIFACEALIGN, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FACEALIGN_CENTER = new <init>("FACEALIGN_CENTER", 0);
        FACEALIGN_TOP = new <init>("FACEALIGN_TOP", 1);
        FACEALIGN_BOTTOM = new <init>("FACEALIGN_BOTTOM", 2);
        $VALUES = (new .VALUES[] {
            FACEALIGN_CENTER, FACEALIGN_TOP, FACEALIGN_BOTTOM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
