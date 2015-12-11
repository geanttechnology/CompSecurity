// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;


// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelActivity

public static final class displayStringResourceId extends Enum
{

    private static final CHANGED_MIND $VALUES[];
    public static final CHANGED_MIND CHANGED_MIND;
    public static final CHANGED_MIND LABEL_DESTROYED;
    public static final CHANGED_MIND LABEL_LOST;
    public static final CHANGED_MIND NOT_PRINTED;
    final int displayStringResourceId;

    public static displayStringResourceId valueOf(String s)
    {
        return (displayStringResourceId)Enum.valueOf(com/ebay/mobile/sell/shippinglabel/ShippingLabelActivity$VoidLabelReasons, s);
    }

    public static displayStringResourceId[] values()
    {
        return (displayStringResourceId[])$VALUES.clone();
    }

    public int getDisplayStringResourceId()
    {
        return displayStringResourceId;
    }

    static 
    {
        NOT_PRINTED = new <init>("NOT_PRINTED", 0, 0x7f070851);
        LABEL_DESTROYED = new <init>("LABEL_DESTROYED", 1, 0x7f07084a);
        LABEL_LOST = new <init>("LABEL_LOST", 2, 0x7f07084c);
        CHANGED_MIND = new <init>("CHANGED_MIND", 3, 0x7f07082a);
        $VALUES = (new .VALUES[] {
            NOT_PRINTED, LABEL_DESTROYED, LABEL_LOST, CHANGED_MIND
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        displayStringResourceId = j;
    }
}
