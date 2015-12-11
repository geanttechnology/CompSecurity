// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;


// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            ShippingLineModel

public static final class  extends Enum
{

    private static final DEFAULT $VALUES[];
    public static final DEFAULT DEFAULT;
    public static final DEFAULT SUPER_SAVER_SHIPPING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/retailsearch/android/ui/results/views/messaging/ShippingLineModel$Builder$ShippingMessageType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SUPER_SAVER_SHIPPING = new <init>("SUPER_SAVER_SHIPPING", 0);
        DEFAULT = new <init>("DEFAULT", 1);
        $VALUES = (new .VALUES[] {
            SUPER_SAVER_SHIPPING, DEFAULT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
