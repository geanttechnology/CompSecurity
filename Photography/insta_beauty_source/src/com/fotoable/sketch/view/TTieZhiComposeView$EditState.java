// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;


final class  extends Enum
{

    private static final Edit_Tap $VALUES[];
    public static final Edit_Tap Edit_Default;
    public static final Edit_Tap Edit_Delete;
    public static final Edit_Tap Edit_Flip;
    public static final Edit_Tap Edit_None;
    public static final Edit_Tap Edit_Rotate;
    public static final Edit_Tap Edit_Tap;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/sketch/view/TTieZhiComposeView$EditState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Edit_None = new <init>("Edit_None", 0);
        Edit_Default = new <init>("Edit_Default", 1);
        Edit_Delete = new <init>("Edit_Delete", 2);
        Edit_Flip = new <init>("Edit_Flip", 3);
        Edit_Rotate = new <init>("Edit_Rotate", 4);
        Edit_Tap = new <init>("Edit_Tap", 5);
        $VALUES = (new .VALUES[] {
            Edit_None, Edit_Default, Edit_Delete, Edit_Flip, Edit_Rotate, Edit_Tap
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
