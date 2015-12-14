// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.decorator.sprite;


final class  extends Enum
{

    private static final SingleFingleTrans $VALUES[];
    public static final SingleFingleTrans Normal;
    public static final SingleFingleTrans SingleFingleTrans;
    public static final SingleFingleTrans SpriteChange;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/wantu/imagelib/decorator/sprite/ImageTransformPanel$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Normal = new <init>("Normal", 0);
        SpriteChange = new <init>("SpriteChange", 1);
        SingleFingleTrans = new <init>("SingleFingleTrans", 2);
        $VALUES = (new .VALUES[] {
            Normal, SpriteChange, SingleFingleTrans
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
