// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;


// Referenced classes of package com.ebay.mobile.activities:
//            ComposeNewMessageActivity

public static final class Q extends Enum
{

    private static final PAYMENT_REMINDER $VALUES[];
    public static final PAYMENT_REMINDER BUYER_ASK_QUESTION;
    public static final PAYMENT_REMINDER PAYMENT_REMINDER;
    public static final PAYMENT_REMINDER SELLER_REPLY;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/ebay/mobile/activities/ComposeNewMessageActivity$MemberMessageTagValues, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        BUYER_ASK_QUESTION = new <init>("BUYER_ASK_QUESTION", 0);
        SELLER_REPLY = new <init>("SELLER_REPLY", 1);
        PAYMENT_REMINDER = new <init>("PAYMENT_REMINDER", 2);
        $VALUES = (new .VALUES[] {
            BUYER_ASK_QUESTION, SELLER_REPLY, PAYMENT_REMINDER
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
