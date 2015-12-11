// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;


public final class ClickStreamTag
{

    public static final ClickStreamTag ORIGIN_BARCODE = new ClickStreamTag("Barcode");
    public static final ClickStreamTag ORIGIN_BARCODE_MATCH = new ClickStreamTag("BarcodeMatch");
    public static final ClickStreamTag ORIGIN_BROWSE = new ClickStreamTag("Browse");
    public static final ClickStreamTag ORIGIN_CART = new ClickStreamTag("Cart");
    public static final ClickStreamTag ORIGIN_DEAL = new ClickStreamTag("Deal");
    public static final ClickStreamTag ORIGIN_DEFAULT = new ClickStreamTag("UndefinedClickStreamOrigin");
    public static final ClickStreamTag ORIGIN_HOME = new ClickStreamTag("Home");
    public static final ClickStreamTag ORIGIN_MOBILEADS = new ClickStreamTag("Ads");
    public static final ClickStreamTag ORIGIN_NOTIFICATION = new ClickStreamTag("Notification");
    public static final ClickStreamTag ORIGIN_ORDER = new ClickStreamTag("Order");
    public static final ClickStreamTag ORIGIN_PRICECHECK_HOME_SAVED_PRODUCT = new ClickStreamTag("RizzoSavedProduct");
    public static final ClickStreamTag ORIGIN_PUBLIC_URL = new ClickStreamTag("PublicURL");
    public static final ClickStreamTag ORIGIN_RECOMMENDATIONS = new ClickStreamTag("Recommendations");
    public static final ClickStreamTag ORIGIN_RECOMMENDEDITEMS = new ClickStreamTag("RecommendedItems");
    public static final ClickStreamTag ORIGIN_REMEMBERS = new ClickStreamTag("Remembers");
    public static final ClickStreamTag ORIGIN_RVI = new ClickStreamTag("RecentlyViewedItems");
    public static final ClickStreamTag ORIGIN_SEARCH = new ClickStreamTag("Search");
    public static final ClickStreamTag ORIGIN_SEARCH_VOICE = new ClickStreamTag("SearchVoice");
    public static final ClickStreamTag ORIGIN_SEARCH_VOICE_CORRECTION = new ClickStreamTag("SearchVoiceCorrection");
    public static final ClickStreamTag ORIGIN_SIMILAR_ITEMS = new ClickStreamTag("SimilarItems");
    public static final ClickStreamTag ORIGIN_SNAP_TELL = new ClickStreamTag("SnapTell");
    public static final ClickStreamTag ORIGIN_VIEW_IT_BARCODE_ACTIVATED_FROM_DEEP_LINK = new ClickStreamTag("barcode_link");
    public static final ClickStreamTag ORIGIN_VIEW_IT_BARCODE_ACTIVATED_FROM_HOME = new ClickStreamTag("barcode_hp");
    public static final ClickStreamTag ORIGIN_VIEW_IT_BARCODE_ACTIVATED_FROM_SEARCH = new ClickStreamTag("barcode_search");
    public static final ClickStreamTag ORIGIN_VIEW_IT_FLOW_ACTIVATED_FROM_DEEP_LINK = new ClickStreamTag("fl_link");
    public static final ClickStreamTag ORIGIN_VIEW_IT_FLOW_ACTIVATED_FROM_SEARCH = new ClickStreamTag("fl_search");
    public static final ClickStreamTag ORIGIN_VIEW_IT_FLOW_ALL_MATCHES_BARCODE = new ClickStreamTag("fl_barcode_histoth");
    public static final ClickStreamTag ORIGIN_VIEW_IT_FLOW_ALL_MATCHES_IMAGE = new ClickStreamTag("fl_image_histoth");
    public static final ClickStreamTag ORIGIN_VIEW_IT_FLOW_EXPANDED_TRAY_BARCODE = new ClickStreamTag("fl_barcode_mhist");
    public static final ClickStreamTag ORIGIN_VIEW_IT_FLOW_EXPANDED_TRAY_IMAGE = new ClickStreamTag("fl_image_mhist");
    public static final ClickStreamTag ORIGIN_VIEW_IT_FLOW_MINI_TRAY_BARCODE = new ClickStreamTag("fl_barcode_match");
    public static final ClickStreamTag ORIGIN_VIEW_IT_FLOW_MINI_TRAY_IMAGE = new ClickStreamTag("fl_image_match");
    public static final ClickStreamTag ORIGIN_WEARABLES_GEAR = new ClickStreamTag("wearable_gear");
    public static final ClickStreamTag ORIGIN_WEARABLES_WEAR = new ClickStreamTag("wearable_wear");
    public static final ClickStreamTag ORIGIN_WISHLIST = new ClickStreamTag("List");
    private final String tag;

    public ClickStreamTag(String s)
    {
        tag = s;
    }

    public static String createFullClickstreamTag(String s)
    {
        if (s != null)
        {
            return (new StringBuilder()).append("mshop_ap_am_").append(s.toLowerCase()).toString();
        } else
        {
            return null;
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (obj.getClass() == getClass())
                {
                    return tag.equals(((ClickStreamTag)obj).tag);
                }
            }
        }
        return flag;
    }

    public String getTag()
    {
        return tag;
    }

    public int hashCode()
    {
        int i;
        if (tag == null)
        {
            i = 0;
        } else
        {
            i = tag.hashCode();
        }
        return i + 527;
    }

}
