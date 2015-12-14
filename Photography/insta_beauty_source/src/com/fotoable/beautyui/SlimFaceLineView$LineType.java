// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;


public final class  extends Enum
{

    private static final QUBAN $VALUES[];
    public static final QUBAN EYEBAG;
    public static final QUBAN QUBAN;
    public static final QUBAN SLIMFACE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/beautyui/SlimFaceLineView$LineType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SLIMFACE = new <init>("SLIMFACE", 0);
        EYEBAG = new <init>("EYEBAG", 1);
        QUBAN = new <init>("QUBAN", 2);
        $VALUES = (new .VALUES[] {
            SLIMFACE, EYEBAG, QUBAN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
