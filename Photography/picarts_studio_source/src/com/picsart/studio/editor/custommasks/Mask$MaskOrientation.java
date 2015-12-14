// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;


public final class  extends Enum
{

    private static final BOTH $VALUES[];
    public static final BOTH BOTH;
    public static final BOTH LANDSCAPE;
    public static final BOTH PORTRAIT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/studio/editor/custommasks/Mask$MaskOrientation, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LANDSCAPE = new <init>("LANDSCAPE", 0);
        PORTRAIT = new <init>("PORTRAIT", 1);
        BOTH = new <init>("BOTH", 2);
        $VALUES = (new .VALUES[] {
            LANDSCAPE, PORTRAIT, BOTH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
