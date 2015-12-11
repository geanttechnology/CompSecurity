// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear;


// Referenced classes of package com.amazon.mShop.wearable.wear:
//            MShopWearListenerService

private static final class I extends Enum
{

    private static final ONE_CLICK_ENABLED $VALUES[];
    public static final ONE_CLICK_ENABLED AUTH;
    public static final ONE_CLICK_ENABLED ONE_CLICK_ENABLED;
    public static final ONE_CLICK_ENABLED US_LOCALE;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        US_LOCALE = new <init>("US_LOCALE", 0);
        AUTH = new <init>("AUTH", 1);
        ONE_CLICK_ENABLED = new <init>("ONE_CLICK_ENABLED", 2);
        $VALUES = (new .VALUES[] {
            US_LOCALE, AUTH, ONE_CLICK_ENABLED
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
