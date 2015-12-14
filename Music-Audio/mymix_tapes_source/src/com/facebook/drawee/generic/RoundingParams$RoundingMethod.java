// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.generic;


// Referenced classes of package com.facebook.drawee.generic:
//            RoundingParams

public static final class  extends Enum
{

    private static final BITMAP_ONLY $VALUES[];
    public static final BITMAP_ONLY BITMAP_ONLY;
    public static final BITMAP_ONLY OVERLAY_COLOR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/facebook/drawee/generic/RoundingParams$RoundingMethod, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OVERLAY_COLOR = new <init>("OVERLAY_COLOR", 0);
        BITMAP_ONLY = new <init>("BITMAP_ONLY", 1);
        $VALUES = (new .VALUES[] {
            OVERLAY_COLOR, BITMAP_ONLY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
