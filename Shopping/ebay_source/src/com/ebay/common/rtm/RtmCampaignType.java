// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;


public final class RtmCampaignType extends Enum
{

    private static final RtmCampaignType $VALUES[];
    public static final RtmCampaignType CELEBRITY_ITEMS_CAMPAIGN;
    public static final RtmCampaignType DOWNLOADAPP_CAMPAIGN;
    public static final RtmCampaignType GOOGLE_DFP_CAMPAIGN;
    public static final RtmCampaignType HTML_CAMPAIGN;
    public static final RtmCampaignType ITEM_LIST_CAMPAIGN;
    public static final RtmCampaignType THEMED_SEARCH_CAMPAIGN;
    public static final RtmCampaignType UNDEFINED_CAMPAIGN;

    private RtmCampaignType(String s, int i)
    {
        super(s, i);
    }

    public static RtmCampaignType valueOf(String s)
    {
        return (RtmCampaignType)Enum.valueOf(com/ebay/common/rtm/RtmCampaignType, s);
    }

    public static RtmCampaignType[] values()
    {
        return (RtmCampaignType[])$VALUES.clone();
    }

    static 
    {
        UNDEFINED_CAMPAIGN = new RtmCampaignType("UNDEFINED_CAMPAIGN", 0);
        DOWNLOADAPP_CAMPAIGN = new RtmCampaignType("DOWNLOADAPP_CAMPAIGN", 1);
        HTML_CAMPAIGN = new RtmCampaignType("HTML_CAMPAIGN", 2);
        THEMED_SEARCH_CAMPAIGN = new RtmCampaignType("THEMED_SEARCH_CAMPAIGN", 3);
        CELEBRITY_ITEMS_CAMPAIGN = new RtmCampaignType("CELEBRITY_ITEMS_CAMPAIGN", 4);
        ITEM_LIST_CAMPAIGN = new RtmCampaignType("ITEM_LIST_CAMPAIGN", 5);
        GOOGLE_DFP_CAMPAIGN = new RtmCampaignType("GOOGLE_DFP_CAMPAIGN", 6);
        $VALUES = (new RtmCampaignType[] {
            UNDEFINED_CAMPAIGN, DOWNLOADAPP_CAMPAIGN, HTML_CAMPAIGN, THEMED_SEARCH_CAMPAIGN, CELEBRITY_ITEMS_CAMPAIGN, ITEM_LIST_CAMPAIGN, GOOGLE_DFP_CAMPAIGN
        });
    }
}
