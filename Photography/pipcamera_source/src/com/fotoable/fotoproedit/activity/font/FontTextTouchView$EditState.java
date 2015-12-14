// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;


public final class  extends Enum
{

    private static final Edit_Tap $VALUES[];
    public static final Edit_Tap Edit_Default;
    public static final Edit_Tap Edit_Rotate;
    public static final Edit_Tap Edit_Tap;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/fotoproedit/activity/font/FontTextTouchView$EditState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Edit_Default = new <init>("Edit_Default", 0);
        Edit_Rotate = new <init>("Edit_Rotate", 1);
        Edit_Tap = new <init>("Edit_Tap", 2);
        $VALUES = (new .VALUES[] {
            Edit_Default, Edit_Rotate, Edit_Tap
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
