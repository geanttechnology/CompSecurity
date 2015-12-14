// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.effect;


public final class value extends Enum
{

    private static final EffectApplyTypeRenderScript $VALUES[];
    public static final EffectApplyTypeRenderScript EffectApplyTypeBitmap;
    public static final EffectApplyTypeRenderScript EffectApplyTypeNative;
    public static final EffectApplyTypeRenderScript EffectApplyTypeRenderScript;
    private int value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/photo/effect/Effect$EffectApplyType, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        EffectApplyTypeNative = new <init>("EffectApplyTypeNative", 0, 0);
        EffectApplyTypeBitmap = new <init>("EffectApplyTypeBitmap", 1, 1);
        EffectApplyTypeRenderScript = new <init>("EffectApplyTypeRenderScript", 2, 2);
        $VALUES = (new .VALUES[] {
            EffectApplyTypeNative, EffectApplyTypeBitmap, EffectApplyTypeRenderScript
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
