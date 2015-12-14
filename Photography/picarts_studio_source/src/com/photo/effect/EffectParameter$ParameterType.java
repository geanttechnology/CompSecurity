// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.effect;


public final class  extends Enum
{

    private static final ParameterTypeTexture $VALUES[];
    public static final ParameterTypeTexture ParameterTypeBool;
    public static final ParameterTypeTexture ParameterTypeColor;
    public static final ParameterTypeTexture ParameterTypeDiscrete;
    public static final ParameterTypeTexture ParameterTypeFloat;
    public static final ParameterTypeTexture ParameterTypeInt;
    public static final ParameterTypeTexture ParameterTypeTexture;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/photo/effect/EffectParameter$ParameterType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ParameterTypeInt = new <init>("ParameterTypeInt", 0);
        ParameterTypeFloat = new <init>("ParameterTypeFloat", 1);
        ParameterTypeBool = new <init>("ParameterTypeBool", 2);
        ParameterTypeDiscrete = new <init>("ParameterTypeDiscrete", 3);
        ParameterTypeColor = new <init>("ParameterTypeColor", 4);
        ParameterTypeTexture = new <init>("ParameterTypeTexture", 5);
        $VALUES = (new .VALUES[] {
            ParameterTypeInt, ParameterTypeFloat, ParameterTypeBool, ParameterTypeDiscrete, ParameterTypeColor, ParameterTypeTexture
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
