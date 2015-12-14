// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.drawable;


// Referenced classes of package com.facebook.drawee.drawable:
//            RoundedCornersDrawable

public static final class  extends Enum
{

    private static final CLIPPING $VALUES[];
    public static final CLIPPING CLIPPING;
    public static final CLIPPING OVERLAY_COLOR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/facebook/drawee/drawable/RoundedCornersDrawable$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OVERLAY_COLOR = new <init>("OVERLAY_COLOR", 0);
        CLIPPING = new <init>("CLIPPING", 1);
        $VALUES = (new .VALUES[] {
            OVERLAY_COLOR, CLIPPING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
