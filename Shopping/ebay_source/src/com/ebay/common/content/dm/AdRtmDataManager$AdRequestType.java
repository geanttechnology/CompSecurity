// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;


// Referenced classes of package com.ebay.common.content.dm:
//            AdRtmDataManager

public static final class  extends Enum
{

    private static final PLA $VALUES[];
    public static final PLA DISPLAY;
    public static final PLA NONE;
    public static final PLA PLA;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/content/dm/AdRtmDataManager$AdRequestType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        DISPLAY = new <init>("DISPLAY", 1);
        PLA = new <init>("PLA", 2);
        $VALUES = (new .VALUES[] {
            NONE, DISPLAY, PLA
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
