// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;


public final class  extends Enum
{

    private static final PAINT $VALUES[];
    public static final PAINT PAINT;
    public static final PAINT TRANSFORM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/photo/morph/MorphGLSurfaceView$TouchMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TRANSFORM = new <init>("TRANSFORM", 0);
        PAINT = new <init>("PAINT", 1);
        $VALUES = (new .VALUES[] {
            TRANSFORM, PAINT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
