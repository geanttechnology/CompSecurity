// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;


// Referenced classes of package com.ebay.mobile.sell.lists:
//            SellingListActivity

public static final class  extends Enum
{

    private static final SCHEDULED $VALUES[];
    public static final SCHEDULED ACTIVE;
    public static final SCHEDULED DRAFT;
    public static final SCHEDULED SCHEDULED;
    public static final SCHEDULED SOLD;
    public static final SCHEDULED UNSOLD;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/sell/lists/SellingListActivity$ListType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DRAFT = new <init>("DRAFT", 0);
        ACTIVE = new <init>("ACTIVE", 1);
        SOLD = new <init>("SOLD", 2);
        UNSOLD = new <init>("UNSOLD", 3);
        SCHEDULED = new <init>("SCHEDULED", 4);
        $VALUES = (new .VALUES[] {
            DRAFT, ACTIVE, SOLD, UNSOLD, SCHEDULED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
