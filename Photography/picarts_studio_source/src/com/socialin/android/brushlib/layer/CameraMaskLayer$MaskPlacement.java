// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.layer;


public final class  extends Enum
{

    private static final ABOVE $VALUES[];
    public static final ABOVE ABOVE;
    public static final ABOVE BELOW;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/brushlib/layer/CameraMaskLayer$MaskPlacement, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        BELOW = new <init>("BELOW", 0);
        ABOVE = new <init>("ABOVE", 1);
        $VALUES = (new .VALUES[] {
            BELOW, ABOVE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
