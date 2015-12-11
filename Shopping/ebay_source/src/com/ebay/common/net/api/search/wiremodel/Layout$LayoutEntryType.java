// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.wiremodel;


// Referenced classes of package com.ebay.common.net.api.search.wiremodel:
//            Layout

public static final class  extends Enum
{

    private static final REWRITE_START $VALUES[];
    public static final REWRITE_START LABELED_ITEM_ANSWER;
    public static final REWRITE_START LISTING;
    public static final REWRITE_START PRODUCT;
    public static final REWRITE_START QUERY_ANSWER;
    public static final REWRITE_START REWRITE_START;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/net/api/search/wiremodel/Layout$LayoutEntryType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LISTING = new <init>("LISTING", 0);
        PRODUCT = new <init>("PRODUCT", 1);
        LABELED_ITEM_ANSWER = new <init>("LABELED_ITEM_ANSWER", 2);
        QUERY_ANSWER = new <init>("QUERY_ANSWER", 3);
        REWRITE_START = new <init>("REWRITE_START", 4);
        $VALUES = (new .VALUES[] {
            LISTING, PRODUCT, LABELED_ITEM_ANSWER, QUERY_ANSWER, REWRITE_START
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
