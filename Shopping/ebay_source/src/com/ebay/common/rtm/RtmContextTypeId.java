// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;


public final class RtmContextTypeId extends Enum
{

    private static final RtmContextTypeId $VALUES[];
    public static final RtmContextTypeId ANDROID_MOBILE_APP_CONTEXT_ID_TYPE;
    public static final RtmContextTypeId BUYER_GUARANTEE_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId BUYING_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId CATEGORY_PORTAL_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId CCHP_MEBAAG_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId CFADS_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId CHECKOUT_MERCH_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId DEFAULT_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId EBX_CHECKOUT_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId EBX_VALUE_PROPOSITION_CONTEXT_TYPE;
    public static final RtmContextTypeId EXTERNAL_RTM_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId FEEDBACK_CONFIRMATION_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId FEEDBACK_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId GLOBAL_HEADER_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId GUEST_CHECKOUT_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId IH_DCP_CAT_RTM_TYPE_ID;
    public static final RtmContextTypeId INVALID_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId MERCH_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId MERCH_FB_SOCIAL_RECO_CONTEXT_ID;
    public static final RtmContextTypeId MOBILE_APP_HOME_PAGE_CONTEXT_ID;
    public static final RtmContextTypeId MOTORS_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId MYEBAY_DIDNTWIN_MERCH_CONTEXT_ID;
    public static final RtmContextTypeId MYWORLD_RTM_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId NGXO_PAYPAL_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId PAYPAL_RTM_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId RESOLN_INTERSTITIAL_TYPE_ID;
    public static final RtmContextTypeId REWARDS_NEWS_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId RTM_IMPRESSION_CONTEXT_TYPE;
    public static final RtmContextTypeId SHOP_CART_MERCH_RTM_TYPE_ID;
    public static final RtmContextTypeId SIGNIN_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId SIGNOUT_PP_MODULE_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId SITE_EMAIL_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId SPPM_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId STATIC_HTML_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId STORE_FUNTIONALITY_GUIDE_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId SUNSHINE_ADS_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId SYI32_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId SYI_LISTING_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId VIEW_ITEM_CONTEXT_TYPE_ID;
    public static final RtmContextTypeId VIEW_ITEM_SIMPLE_CONTEXT_TYPE_ID;
    private int value;

    private RtmContextTypeId(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static RtmContextTypeId valueOf(String s)
    {
        return (RtmContextTypeId)Enum.valueOf(com/ebay/common/rtm/RtmContextTypeId, s);
    }

    public static RtmContextTypeId[] values()
    {
        return (RtmContextTypeId[])$VALUES.clone();
    }

    public int getValue()
    {
        return value;
    }

    public String toString()
    {
        return String.valueOf(value);
    }

    static 
    {
        VIEW_ITEM_CONTEXT_TYPE_ID = new RtmContextTypeId("VIEW_ITEM_CONTEXT_TYPE_ID", 0, 0);
        STORE_FUNTIONALITY_GUIDE_CONTEXT_TYPE_ID = new RtmContextTypeId("STORE_FUNTIONALITY_GUIDE_CONTEXT_TYPE_ID", 1, 1);
        SITE_EMAIL_CONTEXT_TYPE_ID = new RtmContextTypeId("SITE_EMAIL_CONTEXT_TYPE_ID", 2, 2);
        CATEGORY_PORTAL_CONTEXT_TYPE_ID = new RtmContextTypeId("CATEGORY_PORTAL_CONTEXT_TYPE_ID", 3, 3);
        EBX_CHECKOUT_CONTEXT_TYPE_ID = new RtmContextTypeId("EBX_CHECKOUT_CONTEXT_TYPE_ID", 4, 4);
        SPPM_CONTEXT_TYPE_ID = new RtmContextTypeId("SPPM_CONTEXT_TYPE_ID", 5, 5);
        PAYPAL_RTM_CONTEXT_TYPE_ID = new RtmContextTypeId("PAYPAL_RTM_CONTEXT_TYPE_ID", 6, 6);
        MYWORLD_RTM_CONTEXT_TYPE_ID = new RtmContextTypeId("MYWORLD_RTM_CONTEXT_TYPE_ID", 7, 7);
        EXTERNAL_RTM_CONTEXT_TYPE_ID = new RtmContextTypeId("EXTERNAL_RTM_CONTEXT_TYPE_ID", 8, 8);
        SYI32_CONTEXT_TYPE_ID = new RtmContextTypeId("SYI32_CONTEXT_TYPE_ID", 9, 9);
        VIEW_ITEM_SIMPLE_CONTEXT_TYPE_ID = new RtmContextTypeId("VIEW_ITEM_SIMPLE_CONTEXT_TYPE_ID", 10, 10);
        MOTORS_CONTEXT_TYPE_ID = new RtmContextTypeId("MOTORS_CONTEXT_TYPE_ID", 11, 11);
        SUNSHINE_ADS_CONTEXT_TYPE_ID = new RtmContextTypeId("SUNSHINE_ADS_CONTEXT_TYPE_ID", 12, 12);
        NGXO_PAYPAL_CONTEXT_TYPE_ID = new RtmContextTypeId("NGXO_PAYPAL_CONTEXT_TYPE_ID", 13, 13);
        SYI_LISTING_CONTEXT_TYPE_ID = new RtmContextTypeId("SYI_LISTING_CONTEXT_TYPE_ID", 14, 14);
        EBX_VALUE_PROPOSITION_CONTEXT_TYPE = new RtmContextTypeId("EBX_VALUE_PROPOSITION_CONTEXT_TYPE", 15, 15);
        GUEST_CHECKOUT_CONTEXT_TYPE_ID = new RtmContextTypeId("GUEST_CHECKOUT_CONTEXT_TYPE_ID", 16, 16);
        GLOBAL_HEADER_CONTEXT_TYPE_ID = new RtmContextTypeId("GLOBAL_HEADER_CONTEXT_TYPE_ID", 17, 17);
        STATIC_HTML_CONTEXT_TYPE_ID = new RtmContextTypeId("STATIC_HTML_CONTEXT_TYPE_ID", 18, 18);
        BUYER_GUARANTEE_CONTEXT_TYPE_ID = new RtmContextTypeId("BUYER_GUARANTEE_CONTEXT_TYPE_ID", 19, 19);
        FEEDBACK_CONFIRMATION_CONTEXT_TYPE_ID = new RtmContextTypeId("FEEDBACK_CONFIRMATION_CONTEXT_TYPE_ID", 20, 20);
        CCHP_MEBAAG_CONTEXT_TYPE_ID = new RtmContextTypeId("CCHP_MEBAAG_CONTEXT_TYPE_ID", 21, 21);
        DEFAULT_CONTEXT_TYPE_ID = new RtmContextTypeId("DEFAULT_CONTEXT_TYPE_ID", 22, 22);
        INVALID_CONTEXT_TYPE_ID = new RtmContextTypeId("INVALID_CONTEXT_TYPE_ID", 23, 0xfa0a1f01);
        MERCH_CONTEXT_TYPE_ID = new RtmContextTypeId("MERCH_CONTEXT_TYPE_ID", 24, 23);
        CHECKOUT_MERCH_CONTEXT_TYPE_ID = new RtmContextTypeId("CHECKOUT_MERCH_CONTEXT_TYPE_ID", 25, 24);
        SIGNOUT_PP_MODULE_CONTEXT_TYPE_ID = new RtmContextTypeId("SIGNOUT_PP_MODULE_CONTEXT_TYPE_ID", 26, 25);
        REWARDS_NEWS_CONTEXT_TYPE_ID = new RtmContextTypeId("REWARDS_NEWS_CONTEXT_TYPE_ID", 27, 26);
        RTM_IMPRESSION_CONTEXT_TYPE = new RtmContextTypeId("RTM_IMPRESSION_CONTEXT_TYPE", 28, 27);
        SHOP_CART_MERCH_RTM_TYPE_ID = new RtmContextTypeId("SHOP_CART_MERCH_RTM_TYPE_ID", 29, 28);
        IH_DCP_CAT_RTM_TYPE_ID = new RtmContextTypeId("IH_DCP_CAT_RTM_TYPE_ID", 30, 29);
        RESOLN_INTERSTITIAL_TYPE_ID = new RtmContextTypeId("RESOLN_INTERSTITIAL_TYPE_ID", 31, 30);
        CFADS_CONTEXT_TYPE_ID = new RtmContextTypeId("CFADS_CONTEXT_TYPE_ID", 32, 31);
        SIGNIN_CONTEXT_TYPE_ID = new RtmContextTypeId("SIGNIN_CONTEXT_TYPE_ID", 33, 32);
        BUYING_CONTEXT_TYPE_ID = new RtmContextTypeId("BUYING_CONTEXT_TYPE_ID", 34, 33);
        FEEDBACK_CONTEXT_TYPE_ID = new RtmContextTypeId("FEEDBACK_CONTEXT_TYPE_ID", 35, 34);
        MYEBAY_DIDNTWIN_MERCH_CONTEXT_ID = new RtmContextTypeId("MYEBAY_DIDNTWIN_MERCH_CONTEXT_ID", 36, 35);
        MERCH_FB_SOCIAL_RECO_CONTEXT_ID = new RtmContextTypeId("MERCH_FB_SOCIAL_RECO_CONTEXT_ID", 37, 36);
        MOBILE_APP_HOME_PAGE_CONTEXT_ID = new RtmContextTypeId("MOBILE_APP_HOME_PAGE_CONTEXT_ID", 38, 37);
        ANDROID_MOBILE_APP_CONTEXT_ID_TYPE = new RtmContextTypeId("ANDROID_MOBILE_APP_CONTEXT_ID_TYPE", 39, 39);
        $VALUES = (new RtmContextTypeId[] {
            VIEW_ITEM_CONTEXT_TYPE_ID, STORE_FUNTIONALITY_GUIDE_CONTEXT_TYPE_ID, SITE_EMAIL_CONTEXT_TYPE_ID, CATEGORY_PORTAL_CONTEXT_TYPE_ID, EBX_CHECKOUT_CONTEXT_TYPE_ID, SPPM_CONTEXT_TYPE_ID, PAYPAL_RTM_CONTEXT_TYPE_ID, MYWORLD_RTM_CONTEXT_TYPE_ID, EXTERNAL_RTM_CONTEXT_TYPE_ID, SYI32_CONTEXT_TYPE_ID, 
            VIEW_ITEM_SIMPLE_CONTEXT_TYPE_ID, MOTORS_CONTEXT_TYPE_ID, SUNSHINE_ADS_CONTEXT_TYPE_ID, NGXO_PAYPAL_CONTEXT_TYPE_ID, SYI_LISTING_CONTEXT_TYPE_ID, EBX_VALUE_PROPOSITION_CONTEXT_TYPE, GUEST_CHECKOUT_CONTEXT_TYPE_ID, GLOBAL_HEADER_CONTEXT_TYPE_ID, STATIC_HTML_CONTEXT_TYPE_ID, BUYER_GUARANTEE_CONTEXT_TYPE_ID, 
            FEEDBACK_CONFIRMATION_CONTEXT_TYPE_ID, CCHP_MEBAAG_CONTEXT_TYPE_ID, DEFAULT_CONTEXT_TYPE_ID, INVALID_CONTEXT_TYPE_ID, MERCH_CONTEXT_TYPE_ID, CHECKOUT_MERCH_CONTEXT_TYPE_ID, SIGNOUT_PP_MODULE_CONTEXT_TYPE_ID, REWARDS_NEWS_CONTEXT_TYPE_ID, RTM_IMPRESSION_CONTEXT_TYPE, SHOP_CART_MERCH_RTM_TYPE_ID, 
            IH_DCP_CAT_RTM_TYPE_ID, RESOLN_INTERSTITIAL_TYPE_ID, CFADS_CONTEXT_TYPE_ID, SIGNIN_CONTEXT_TYPE_ID, BUYING_CONTEXT_TYPE_ID, FEEDBACK_CONTEXT_TYPE_ID, MYEBAY_DIDNTWIN_MERCH_CONTEXT_ID, MERCH_FB_SOCIAL_RECO_CONTEXT_ID, MOBILE_APP_HOME_PAGE_CONTEXT_ID, ANDROID_MOBILE_APP_CONTEXT_ID_TYPE
        });
    }
}
