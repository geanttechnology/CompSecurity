// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            MraidView

public static final class  extends Enum
{

    private static final HIDDEN $VALUES[];
    public static final HIDDEN DEFAULT;
    public static final HIDDEN EXPANDED;
    public static final HIDDEN HIDDEN;
    public static final HIDDEN LOADING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/ads/MraidView$ViewState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LOADING = new <init>("LOADING", 0);
        DEFAULT = new <init>("DEFAULT", 1);
        EXPANDED = new <init>("EXPANDED", 2);
        HIDDEN = new <init>("HIDDEN", 3);
        $VALUES = (new .VALUES[] {
            LOADING, DEFAULT, EXPANDED, HIDDEN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
