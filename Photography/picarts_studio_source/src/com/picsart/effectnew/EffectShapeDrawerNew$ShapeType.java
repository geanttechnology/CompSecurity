// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;


public final class  extends Enum
{

    private static final Rect $VALUES[];
    public static final Rect Focal;
    public static final Rect Rect;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/effectnew/EffectShapeDrawerNew$ShapeType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Focal = new <init>("Focal", 0);
        Rect = new <init>("Rect", 1);
        $VALUES = (new .VALUES[] {
            Focal, Rect
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
