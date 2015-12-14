// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;


public final class  extends Enum
{

    private static final Skin $VALUES[];
    public static final Skin Skin;
    public static final Skin Soften;
    public static final Skin White;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/beautyui/newui/MNewSofterFragment$SoftenState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Soften = new <init>("Soften", 0);
        White = new <init>("White", 1);
        Skin = new <init>("Skin", 2);
        $VALUES = (new .VALUES[] {
            Soften, White, Skin
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
