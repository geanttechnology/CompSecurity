// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;


public final class  extends Enum
{

    private static final PATTERN $VALUES[];
    public static final PATTERN BLUR;
    public static final PATTERN COLOR;
    public static final PATTERN PATTERN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/studio/editor/fragment/SquareFitFragment$SquareFitMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        BLUR = new <init>("BLUR", 0);
        COLOR = new <init>("COLOR", 1);
        PATTERN = new <init>("PATTERN", 2);
        $VALUES = (new .VALUES[] {
            BLUR, COLOR, PATTERN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
