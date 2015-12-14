// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;


final class  extends Enum
{

    private static final Double_End $VALUES[];
    public static final Double_End Double_End;
    public static final Double_End Double_Move;
    public static final Double_End Double_Start;
    public static final Double_End Double_default;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/sketch/view/TTieZhiComposeView$DoubleTouchState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Double_default = new <init>("Double_default", 0);
        Double_Start = new <init>("Double_Start", 1);
        Double_Move = new <init>("Double_Move", 2);
        Double_End = new <init>("Double_End", 3);
        $VALUES = (new .VALUES[] {
            Double_default, Double_Start, Double_Move, Double_End
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
