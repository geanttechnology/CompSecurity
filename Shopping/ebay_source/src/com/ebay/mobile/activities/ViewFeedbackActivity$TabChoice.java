// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;


// Referenced classes of package com.ebay.mobile.activities:
//            ViewFeedbackActivity

public static final class value extends Enum
{

    private static final AS_SELLER $VALUES[];
    public static final AS_SELLER AS_BUYER;
    public static final AS_SELLER AS_SELLER;
    public final int value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/ebay/mobile/activities/ViewFeedbackActivity$TabChoice, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    static 
    {
        AS_BUYER = new <init>("AS_BUYER", 0, 1);
        AS_SELLER = new <init>("AS_SELLER", 1, 0);
        $VALUES = (new .VALUES[] {
            AS_BUYER, AS_SELLER
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
