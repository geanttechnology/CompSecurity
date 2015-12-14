// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;


public final class A extends Enum
{

    private static final SHAPE $VALUES[];
    public static final SHAPE BRUSH;
    public static final SHAPE SHAPE;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/picsart/effectnew/EffectsDrawController$EffectsDrawMode, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        BRUSH = new <init>("BRUSH", 0);
        SHAPE = new <init>("SHAPE", 1);
        $VALUES = (new .VALUES[] {
            BRUSH, SHAPE
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
