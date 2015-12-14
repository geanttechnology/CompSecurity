// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;


final class  extends Enum
{

    private static final Single_End $VALUES[];
    public static final Single_End Single_End;
    public static final Single_End Single_Move;
    public static final Single_End Single_Start;
    public static final Single_End Single_default;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/fotoproedit/activity/font/FontTextTouchView$SingleTouchState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Single_default = new <init>("Single_default", 0);
        Single_Start = new <init>("Single_Start", 1);
        Single_Move = new <init>("Single_Move", 2);
        Single_End = new <init>("Single_End", 3);
        $VALUES = (new .VALUES[] {
            Single_default, Single_Start, Single_Move, Single_End
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
