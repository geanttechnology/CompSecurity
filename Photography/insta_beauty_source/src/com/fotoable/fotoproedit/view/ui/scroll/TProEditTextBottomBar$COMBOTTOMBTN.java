// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;


public final class  extends Enum
{

    private static final STYLE $VALUES[];
    public static final STYLE DEFAULT;
    public static final STYLE FONT;
    public static final STYLE KEYBOARD;
    public static final STYLE STYLE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/fotoproedit/view/ui/scroll/TProEditTextBottomBar$COMBOTTOMBTN, s);
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
        $VALUES = (new .VALUES[] {
            DEFAULT, KEYBOARD, FONT, STYLE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
