// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;


public final class  extends Enum
{

    private static final LABEL $VALUES[];
    public static final LABEL IMAGEBG;
    public static final LABEL LABEL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/fotoproedit/activity/font/FontTextLabelInfo$TEXTBGVIEWTYPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IMAGEBG = new <init>("IMAGEBG", 0);
        LABEL = new <init>("LABEL", 1);
        $VALUES = (new .VALUES[] {
            IMAGEBG, LABEL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
