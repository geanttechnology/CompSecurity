// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;


// Referenced classes of package com.ebay.common.net.api.followinterest:
//            SaasSearchRequest

public static final class  extends Enum
{

    private static final ItemTitleAndDescriptionSearch $VALUES[];
    public static final ItemTitleAndDescriptionSearch ItemTitleAndDescriptionSearch;
    public static final ItemTitleAndDescriptionSearch ItemTitleSearch;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/net/api/followinterest/SaasSearchRequest$SearchScope, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ItemTitleSearch = new <init>("ItemTitleSearch", 0);
        ItemTitleAndDescriptionSearch = new <init>("ItemTitleAndDescriptionSearch", 1);
        $VALUES = (new .VALUES[] {
            ItemTitleSearch, ItemTitleAndDescriptionSearch
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
