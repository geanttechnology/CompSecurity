// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.wiremodel;


// Referenced classes of package com.ebay.common.net.api.search.wiremodel:
//            Rewrite

static final class apiName extends Enum
{

    private static final ITEM_TITLE_AND_DESCRIPTION_SEARCH $VALUES[];
    public static final ITEM_TITLE_AND_DESCRIPTION_SEARCH ITEM_TITLE_AND_DESCRIPTION_SEARCH;
    public static final ITEM_TITLE_AND_DESCRIPTION_SEARCH ITEM_TITLE_SEARCH;
    String apiName;

    public static apiName valueOf(String s)
    {
        return (apiName)Enum.valueOf(com/ebay/common/net/api/search/wiremodel/Rewrite$RewriteResult$SearchRequest$SearchScope, s);
    }

    public static apiName[] values()
    {
        return (apiName[])$VALUES.clone();
    }

    static 
    {
        ITEM_TITLE_SEARCH = new <init>("ITEM_TITLE_SEARCH", 0, "ItemTitleSearch");
        ITEM_TITLE_AND_DESCRIPTION_SEARCH = new <init>("ITEM_TITLE_AND_DESCRIPTION_SEARCH", 1, "ItemTitleAndDescriptionSearch");
        $VALUES = (new .VALUES[] {
            ITEM_TITLE_SEARCH, ITEM_TITLE_AND_DESCRIPTION_SEARCH
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        apiName = s1;
    }
}
