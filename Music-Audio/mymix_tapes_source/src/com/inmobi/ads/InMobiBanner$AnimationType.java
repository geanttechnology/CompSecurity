// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;


// Referenced classes of package com.inmobi.ads:
//            InMobiBanner

public static final class  extends Enum
{

    private static final ROTATE_VERTICAL_AXIS $VALUES[];
    public static final ROTATE_VERTICAL_AXIS ANIMATION_ALPHA;
    public static final ROTATE_VERTICAL_AXIS ANIMATION_OFF;
    public static final ROTATE_VERTICAL_AXIS ROTATE_HORIZONTAL_AXIS;
    public static final ROTATE_VERTICAL_AXIS ROTATE_VERTICAL_AXIS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/ads/InMobiBanner$AnimationType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ANIMATION_OFF = new <init>("ANIMATION_OFF", 0);
        ROTATE_HORIZONTAL_AXIS = new <init>("ROTATE_HORIZONTAL_AXIS", 1);
        ANIMATION_ALPHA = new <init>("ANIMATION_ALPHA", 2);
        ROTATE_VERTICAL_AXIS = new <init>("ROTATE_VERTICAL_AXIS", 3);
        $VALUES = (new .VALUES[] {
            ANIMATION_OFF, ROTATE_HORIZONTAL_AXIS, ANIMATION_ALPHA, ROTATE_VERTICAL_AXIS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
