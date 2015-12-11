// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

// Referenced classes of package com.ebay.common.rtm:
//            RtmCampaignType

public class RtmContent
{
    public static class Ad
        implements Serializable
    {

        public int adSizeHeight;
        public int adSizeWidth;
        public String adUnitId;
        public URL externalLink;
        public String externalLinkName;
        public String formattedPriceString;
        public String formattedStrikethroughPrice;
        public boolean isPla;
        public ArrayList parameters;
        public String ppid;
        public String retailerName;
        public String shippingInfo;
        public String subTitle;
        public URL thumbnailURL;
        public String title;
        public String trackingClickID;
        public URL trackingURL;
        public boolean userTargeted;

        public Ad()
        {
        }
    }

    public static class Parameter
        implements Serializable
    {

        public String key;
        public String value;

        public Parameter()
        {
        }
    }


    public ArrayList ads;
    public URL appStoreURL;
    public URL bannerImageURL;
    public RtmCampaignType campaign;
    public String campaignId;
    public String detailsTitle;
    public URL htmlPageURL;
    public URL infoURL;
    public ArrayList itemIds;
    public ArrayList itemSearchURLs;
    public String messageId;
    public String placement;
    public String rawContent;
    public ArrayList searchDescriptions;
    public String ssoScope;
    public String summarySubTitle;
    public String summaryTitle;
    public URL thumbnailURL;
    public String trackingClickID;
    public URL trackingURL;

    public RtmContent()
    {
    }
}
