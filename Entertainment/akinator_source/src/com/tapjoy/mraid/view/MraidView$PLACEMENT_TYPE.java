// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;


// Referenced classes of package com.tapjoy.mraid.view:
//            MraidView

public static final class  extends Enum
{

    private static final INTERSTITIAL $VALUES[];
    public static final INTERSTITIAL INLINE;
    public static final INTERSTITIAL INTERSTITIAL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/tapjoy/mraid/view/MraidView$PLACEMENT_TYPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INLINE = new <init>("INLINE", 0);
        INTERSTITIAL = new <init>("INTERSTITIAL", 1);
        $VALUES = (new .VALUES[] {
            INLINE, INTERSTITIAL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
