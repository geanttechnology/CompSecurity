// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;


public final class  extends Enum
{

    private static final BUBBLE $VALUES[];
    public static final BUBBLE BUBBLE;
    public static final BUBBLE DEFAULT;
    public static final BUBBLE FONT;
    public static final BUBBLE KEYBOARD;
    public static final BUBBLE STYLE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/fotoproedit/activity/font/TProEditTextBottomBar$COMBOTTOMBTN, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DEFAULT = new <init>("DEFAULT", 0);
        KEYBOARD = new <init>("KEYBOARD", 1);
        FONT = new <init>("FONT", 2);
        STYLE = new <init>("STYLE", 3);
        BUBBLE = new <init>("BUBBLE", 4);
        $VALUES = (new .VALUES[] {
            DEFAULT, KEYBOARD, FONT, STYLE, BUBBLE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
