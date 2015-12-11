// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Contents

public static final class RtmThemedSearchCampaign
{
    public static final class RtmAd
    {

        public Details details;
        public Summary summary;

        public RtmAd()
        {
        }
    }

    public static final class RtmAd.Details
    {

        public GoogleDfpCampaign googleDfpCampaign;

        public RtmAd.Details()
        {
        }
    }

    public static final class RtmAd.Details.GoogleDfpCampaign
    {

        public int adSizeHeight;
        public int adSizeWidth;
        public String adUnitId;
        public Parameters parameters;
        public String ppid;
        public boolean userTargetedFlag;

        public RtmAd.Details.GoogleDfpCampaign()
        {
        }
    }

    public static final class RtmAd.Details.GoogleDfpCampaign.Parameters
    {

        public List parameters;

        public RtmAd.Details.GoogleDfpCampaign.Parameters()
        {
        }
    }

    public static final class RtmAd.Summary
    {

        public String clickId;
        public String rtmTrackingUrl;
        public String subtitle;
        public String thumbnailUrl;
        public String title;

        public RtmAd.Summary()
        {
        }
    }

    public static final class RtmAdsCampaign
    {

        public List ads;
        public int numResults;
        public String provider;

        public RtmAdsCampaign()
        {
        }
    }

    public static final class RtmDownloadCampaign
    {

        public String appStoreUrl;
        public String infoUrl;
        public String rtmTrackingUrl;
        public String title;

        public RtmDownloadCampaign()
        {
        }
    }

    public static final class RtmHtmlCampaign
    {

        public String htmlPageUrl;
        public String rtmTrackingUrl;
        public String title;

        public RtmHtmlCampaign()
        {
        }
    }

    public static final class RtmItem
    {

        public String itemId;

        public RtmItem()
        {
        }
    }

    public static final class RtmItemCampaign
    {

        public String imageUrl;
        public List listings;
        public String title;

        public RtmItemCampaign()
        {
        }
    }

    public static final class RtmListItem
    {

        public String itemSearchUrl;
        public String itemThumbnailUrl;
        public String rtmTrackingUrl;
        public String searchDescription;

        public RtmListItem()
        {
        }
    }

    public static final class RtmListing
    {

        public String aspectValues;
        public String listingId;
        public String rtmTrackingUrl;
        public String type;

        public RtmListing()
        {
        }
    }

    public static final class RtmMultiThemedSearchCampaign
    {

        public String bannerImageUrl;
        public ThemedSearchCampaignList themedSearchCampaignList;
        public String title;

        public RtmMultiThemedSearchCampaign()
        {
        }
    }

    public static final class RtmMultiThemedSearchCampaign.ThemedSearchCampaignList
    {

        public List themedSearchCampaign;

        public RtmMultiThemedSearchCampaign.ThemedSearchCampaignList()
        {
        }
    }

    public static final class RtmTabletItemCampaign
    {

        public List listings;

        public RtmTabletItemCampaign()
        {
        }
    }

    public static final class RtmThemedSearchCampaign
    {

        public String bannerImageUrl;
        public RTMListItems listItems;
        public String title;

        public RtmThemedSearchCampaign()
        {
        }
    }

    public static final class RtmThemedSearchCampaign.RTMListItems
    {

        public List listItem;

        public RtmThemedSearchCampaign.RTMListItems()
        {
        }
    }


    public RtmAdsCampaign adsCampaign;
    public int cardStyle;
    public String clickId;
    public String description;
    public RtmDownloadCampaign downloadAppCampaign;
    public RtmHtmlCampaign htmlCampaign;
    public String imageUrl;
    public RtmItemCampaign itemCampaign;
    public String logoUrl;
    public RtmMultiThemedSearchCampaign multiThemedSearchCampaign;
    public String rtmTrackingUrl;
    public String subTitle;
    public RtmTabletItemCampaign tabletItemCampaign;
    public RtmThemedSearchCampaign themedSearchCampaign;
    public String title;

    public RtmThemedSearchCampaign()
    {
    }
}
