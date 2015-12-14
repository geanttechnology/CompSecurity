// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;


public final class  extends Enum
{

    private static final Slim $VALUES[];
    public static final Slim Adjust;
    public static final Slim Editor;
    public static final Slim Legs;
    public static final Slim Mosaic;
    public static final Slim Slim;
    public static final Slim Text;
    public static final Slim Tickers;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/beautyui/newui/MNewProEditScrollView$SecondToolState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Text = new <init>("Text", 0);
        Editor = new <init>("Editor", 1);
        Tickers = new <init>("Tickers", 2);
        Mosaic = new <init>("Mosaic", 3);
        Adjust = new <init>("Adjust", 4);
        Legs = new <init>("Legs", 5);
        Slim = new <init>("Slim", 6);
        $VALUES = (new .VALUES[] {
            Text, Editor, Tickers, Mosaic, Adjust, Legs, Slim
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
