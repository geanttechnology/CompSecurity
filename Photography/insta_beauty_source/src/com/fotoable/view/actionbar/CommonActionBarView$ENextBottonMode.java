// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.view.actionbar;


public final class  extends Enum
{

    private static final BUTTON $VALUES[];
    public static final BUTTON BUTTON;
    public static final BUTTON ICON;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/view/actionbar/CommonActionBarView$ENextBottonMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ICON = new <init>("ICON", 0);
        BUTTON = new <init>("BUTTON", 1);
        $VALUES = (new .VALUES[] {
            ICON, BUTTON
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
