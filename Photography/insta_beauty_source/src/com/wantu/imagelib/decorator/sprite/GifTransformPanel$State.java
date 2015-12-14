// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.decorator.sprite;


final class A extends Enum
{

    private static final Scale $VALUES[];
    public static final Scale Pan;
    public static final Scale Rotate;
    public static final Scale Scale;
    public static final Scale SpriteChange;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/wantu/imagelib/decorator/sprite/GifTransformPanel$State, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        SpriteChange = new <init>("SpriteChange", 0);
        Pan = new <init>("Pan", 1);
        Rotate = new <init>("Rotate", 2);
        Scale = new <init>("Scale", 3);
        $VALUES = (new .VALUES[] {
            SpriteChange, Pan, Rotate, Scale
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
