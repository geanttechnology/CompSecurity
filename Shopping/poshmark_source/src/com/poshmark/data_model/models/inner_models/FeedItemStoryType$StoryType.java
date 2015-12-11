// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            FeedItemStoryType

public static final class  extends Enum
{

    private static final INVALID $VALUES[];
    public static final INVALID BRAND_ADD_MIFU;
    public static final INVALID BRAND_CHECKOUT_MIFU;
    public static final INVALID BRAND_JUSTIN_MIFU;
    public static final INVALID BRAND_LISTING_ADD_MIFU;
    public static final INVALID BRAND_RECOMMEND_MIFU;
    public static final INVALID CLOSET_ADD_MIFU;
    public static final INVALID CLOSET_ADD_SIFU;
    public static final INVALID CLOSET_ADD_SIFU_SOCIAL;
    public static final INVALID CLOSET_RECOMMEND_MIFU;
    public static final INVALID CLOSET_UPDATE_MIFU;
    public static final INVALID CLOSET_UPDATE_SIFU;
    public static final INVALID CLOSET_UPDATE_SIFU_SOCIAL;
    public static final INVALID INVALID;
    public static final INVALID LISTING_SHARE_MIFU;
    public static final INVALID LISTING_SHARE_SIFU;
    public static final INVALID LISTING_SHARE_SIFU_SOCIAL;
    public static final INVALID POSHPOST_SIFU;
    public static final INVALID SELF_SHARE_MIFU;
    public static final INVALID SELF_SHARE_SIFU;
    public static final INVALID SELF_SHARE_SIFU_SOCIAL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CLOSET_ADD_SIFU = new <init>("CLOSET_ADD_SIFU", 0);
        CLOSET_ADD_SIFU_SOCIAL = new <init>("CLOSET_ADD_SIFU_SOCIAL", 1);
        CLOSET_ADD_MIFU = new <init>("CLOSET_ADD_MIFU", 2);
        CLOSET_UPDATE_SIFU = new <init>("CLOSET_UPDATE_SIFU", 3);
        CLOSET_UPDATE_SIFU_SOCIAL = new <init>("CLOSET_UPDATE_SIFU_SOCIAL", 4);
        CLOSET_UPDATE_MIFU = new <init>("CLOSET_UPDATE_MIFU", 5);
        LISTING_SHARE_SIFU = new <init>("LISTING_SHARE_SIFU", 6);
        LISTING_SHARE_SIFU_SOCIAL = new <init>("LISTING_SHARE_SIFU_SOCIAL", 7);
        LISTING_SHARE_MIFU = new <init>("LISTING_SHARE_MIFU", 8);
        SELF_SHARE_SIFU = new <init>("SELF_SHARE_SIFU", 9);
        SELF_SHARE_SIFU_SOCIAL = new <init>("SELF_SHARE_SIFU_SOCIAL", 10);
        SELF_SHARE_MIFU = new <init>("SELF_SHARE_MIFU", 11);
        BRAND_ADD_MIFU = new <init>("BRAND_ADD_MIFU", 12);
        BRAND_RECOMMEND_MIFU = new <init>("BRAND_RECOMMEND_MIFU", 13);
        BRAND_CHECKOUT_MIFU = new <init>("BRAND_CHECKOUT_MIFU", 14);
        BRAND_LISTING_ADD_MIFU = new <init>("BRAND_LISTING_ADD_MIFU", 15);
        BRAND_JUSTIN_MIFU = new <init>("BRAND_JUSTIN_MIFU", 16);
        CLOSET_RECOMMEND_MIFU = new <init>("CLOSET_RECOMMEND_MIFU", 17);
        POSHPOST_SIFU = new <init>("POSHPOST_SIFU", 18);
        INVALID = new <init>("INVALID", 19);
        $VALUES = (new .VALUES[] {
            CLOSET_ADD_SIFU, CLOSET_ADD_SIFU_SOCIAL, CLOSET_ADD_MIFU, CLOSET_UPDATE_SIFU, CLOSET_UPDATE_SIFU_SOCIAL, CLOSET_UPDATE_MIFU, LISTING_SHARE_SIFU, LISTING_SHARE_SIFU_SOCIAL, LISTING_SHARE_MIFU, SELF_SHARE_SIFU, 
            SELF_SHARE_SIFU_SOCIAL, SELF_SHARE_MIFU, BRAND_ADD_MIFU, BRAND_RECOMMEND_MIFU, BRAND_CHECKOUT_MIFU, BRAND_LISTING_ADD_MIFU, BRAND_JUSTIN_MIFU, CLOSET_RECOMMEND_MIFU, POSHPOST_SIFU, INVALID
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
