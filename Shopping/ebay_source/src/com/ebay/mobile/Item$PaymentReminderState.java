// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;


// Referenced classes of package com.ebay.mobile:
//            Item

public static final class  extends Enum
{

    private static final STATE_SENT $VALUES[];
    public static final STATE_SENT STATE_DISABLED;
    public static final STATE_SENT STATE_ENABLED;
    public static final STATE_SENT STATE_SENT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/Item$PaymentReminderState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STATE_DISABLED = new <init>("STATE_DISABLED", 0);
        STATE_ENABLED = new <init>("STATE_ENABLED", 1);
        STATE_SENT = new <init>("STATE_SENT", 2);
        $VALUES = (new .VALUES[] {
            STATE_DISABLED, STATE_ENABLED, STATE_SENT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
