// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;


// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewCommonProgressAndError

public static final class I extends Enum
{

    private static final CUSTOM_ERROR $VALUES[];
    public static final CUSTOM_ERROR CONNECTION_ERROR;
    public static final CUSTOM_ERROR CUSTOM_ERROR;
    public static final CUSTOM_ERROR NORMAL;
    public static final CUSTOM_ERROR PROGRESS;
    public static final CUSTOM_ERROR SERVICE_ERROR;
    public static final CUSTOM_ERROR TRANSLUCENT_PROGRESS;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/ebay/mobile/viewitem/ItemViewCommonProgressAndError$LayoutState, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        NORMAL = new <init>("NORMAL", 0);
        PROGRESS = new <init>("PROGRESS", 1);
        TRANSLUCENT_PROGRESS = new <init>("TRANSLUCENT_PROGRESS", 2);
        CONNECTION_ERROR = new <init>("CONNECTION_ERROR", 3);
        SERVICE_ERROR = new <init>("SERVICE_ERROR", 4);
        CUSTOM_ERROR = new <init>("CUSTOM_ERROR", 5);
        $VALUES = (new .VALUES[] {
            NORMAL, PROGRESS, TRANSLUCENT_PROGRESS, CONNECTION_ERROR, SERVICE_ERROR, CUSTOM_ERROR
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
