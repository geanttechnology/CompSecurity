// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;


// Referenced classes of package com.pointinside.maps:
//            PIMap

public static final class  extends Enum
{

    private static final MOVING_CROSS_FADE $VALUES[];
    public static final MOVING_CROSS_FADE MOVING_CROSS_FADE;
    public static final MOVING_CROSS_FADE NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/maps/PIMap$UpdateMarkerAnimation, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        MOVING_CROSS_FADE = new <init>("MOVING_CROSS_FADE", 1);
        $VALUES = (new .VALUES[] {
            NONE, MOVING_CROSS_FADE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
