// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            CollectionDetail

public static final class  extends Enum
{

    private static final ITEM_VARIATION $VALUES[];
    public static final ITEM_VARIATION ITEM_VARIATION;
    public static final ITEM_VARIATION LISTING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/CollectionDetail$EntryType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LISTING = new <init>("LISTING", 0);
        ITEM_VARIATION = new <init>("ITEM_VARIATION", 1);
        $VALUES = (new .VALUES[] {
            LISTING, ITEM_VARIATION
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
