// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;


// Referenced classes of package com.ebay.mobile.myebay:
//            MessagesBaseFragment

public static final class  extends Enum
{

    private static final MESSAGES_DETAIL $VALUES[];
    public static final MESSAGES_DETAIL MESSAGES_DETAIL;
    public static final MESSAGES_DETAIL MESSAGES_MASTER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/myebay/MessagesBaseFragment$ActivePane, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MESSAGES_MASTER = new <init>("MESSAGES_MASTER", 0);
        MESSAGES_DETAIL = new <init>("MESSAGES_DETAIL", 1);
        $VALUES = (new .VALUES[] {
            MESSAGES_MASTER, MESSAGES_DETAIL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
