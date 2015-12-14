// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;


public final class _cls9 extends Enum
{

    private static final BUTTON $VALUES[];
    public static final BUTTON BUTTON;
    public static final BUTTON ICON;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/wantu/view/CommonActionBarView1$ENextBottonMode, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        ICON = new <init>("ICON", 0);
        BUTTON = new <init>("BUTTON", 1);
        $VALUES = (new .VALUES[] {
            ICON, BUTTON
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
