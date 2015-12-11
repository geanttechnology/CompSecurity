// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import com.ebay.nautilus.domain.data.CompactListing;
import com.ebay.nautilus.domain.data.EbayCosDateTime;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Contents, ContentSourceEnum, Category, Department, 
//            RecordStatusEnum, ContentTypeEnum

public static final class PaginationOutput
{
    public static final class ContentRecord
    {

        public ActiveListingsSummary activeListingsSummary;
        public BuyingOverview buyingOverview;
        public Category category;
        public Collection collection;
        public Department department;
        public boolean emptyBuying;
        public FeedEvent feedEvent;
        public FollowedEntities followedEntities;
        public boolean hasMoreListings;
        public String id;
        public List listAnItems;
        public SellingDraft listingDraft;
        public List listings;
        public Notification notification;
        public RppEventGroup rppEventGroup;
        public Rtm rtm;
        public ScheduledListing scheduledListing;
        public List sellerInspirations;
        public SellingOverview sellingOverview;
        public SignIn signIn;
        public SoldListingsSummary soldListingsSummary;
        public ContentSourceEnum source;
        public RecordStatusEnum status;
        public boolean suppressAwaitingPayment;
        public String title;
        public Topic topic;
        public ContentTypeEnum type;
        public UnsoldListingsSummary unsoldListingsSummary;
        public Watching watching;

        public ContentRecord()
        {
        }
    }

    public static final class ContentRecord.ActiveListingsSummary
    {

        public int numberOfActiveListings;
        public int numberOfListingsWithBids;
        public int numberofListingsWithPendingOffers;

        public ContentRecord.ActiveListingsSummary()
        {
        }
    }

    public static class ContentRecord.BestOfferSummary
    {

        public int counterOfferCount;
        public int totalCount;

        public ContentRecord.BestOfferSummary()
        {
        }
    }

    public static class ContentRecord.BidSummary
    {

        public int outbidCount;
        public int totalCount;
        public int winningCount;

        public ContentRecord.BidSummary()
        {
        }
    }

    public static final class ContentRecord.Button
    {

        public String text;
        public String url;

        public ContentRecord.Button()
        {
        }
    }

    public static final class ContentRecord.BuyingOverview
    {

        public ContentRecord.BestOfferSummary bestOfferSummary;
        public ContentRecord.BidSummary bidSummary;
        public boolean emptyBuying;
        public ContentRecord.PurchaseSummary purchaseSummary;

        public ContentRecord.BuyingOverview()
        {
        }
    }

    public static final class ContentRecord.Collection
    {

        public String collectionId;
        public User creator;
        public String description;
        public int entryCount;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount highestAmount;
        public String imageUrl;
        public List images;
        public String longDescription;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount lowestAmount;
        public String name;
        public String placementId;
        public String summary;
        public String url;
        public String videoId;

        public ContentRecord.Collection()
        {
        }
    }

    public static final class ContentRecord.Collection.User
    {

        public String profileImageURL;
        public UserId userIdentifier;

        public ContentRecord.Collection.User()
        {
        }
    }

    public static final class ContentRecord.Collection.User.UserId
    {

        public String userId;
        public String username;

        public ContentRecord.Collection.User.UserId()
        {
        }
    }

    public static final class ContentRecord.FeedEvent
    {

        public ContentRecord.Collection collection;
        public List collections;
        public List followers;
        public ContentRecord.Interest interest;
        public List interests;
        public List listings;
        public ContentRecord.Member user;
        public List users;

        public ContentRecord.FeedEvent()
        {
        }
    }

    public static class ContentRecord.FollowInfo
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime followDate;
        public boolean hidden;
        public Visibility visibility;

        public ContentRecord.FollowInfo()
        {
        }
    }

    public static final class ContentRecord.FollowInfo.Visibility extends Enum
    {

        private static final ContentRecord.FollowInfo.Visibility $VALUES[];
        public static final ContentRecord.FollowInfo.Visibility PRIVATE;
        public static final ContentRecord.FollowInfo.Visibility PUBLIC;

        public static ContentRecord.FollowInfo.Visibility valueOf(String s)
        {
            return (ContentRecord.FollowInfo.Visibility)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$FollowInfo$Visibility, s);
        }

        public static ContentRecord.FollowInfo.Visibility[] values()
        {
            return (ContentRecord.FollowInfo.Visibility[])$VALUES.clone();
        }

        static 
        {
            PUBLIC = new ContentRecord.FollowInfo.Visibility("PUBLIC", 0);
            PRIVATE = new ContentRecord.FollowInfo.Visibility("PRIVATE", 1);
            $VALUES = (new ContentRecord.FollowInfo.Visibility[] {
                PUBLIC, PRIVATE
            });
        }

        private ContentRecord.FollowInfo.Visibility(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ContentRecord.FollowedEntities
    {

        public boolean emptyFollow;
        public List followedInterests;
        public List followedUsers;

        public ContentRecord.FollowedEntities()
        {
        }
    }

    public static final class ContentRecord.FollowedInterest
    {

        public ContentRecord.FollowedInterestEntity entity;
        public ContentRecord.FollowedInterestFollowInfo followInfo;

        public ContentRecord.FollowedInterest()
        {
        }
    }

    public static final class ContentRecord.FollowedInterestEntity
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime createdDate;
        public String customTitle;
        public FollowedImageUrl imageUrl;
        public String interestId;
        public String marketplaceId;
        public SearchRequest searchRequest;
        public String searchUrl;
        public String title;

        public ContentRecord.FollowedInterestEntity()
        {
        }
    }

    public static final class ContentRecord.FollowedInterestEntity.FollowedImageUrl
    {

        public String thumbs;

        public ContentRecord.FollowedInterestEntity.FollowedImageUrl()
        {
        }
    }

    public static final class ContentRecord.FollowedInterestEntity.SearchRequest
    {

        public List categoryId;
        public String keyword;

        public ContentRecord.FollowedInterestEntity.SearchRequest()
        {
        }
    }

    public static final class ContentRecord.FollowedInterestFollowInfo extends ContentRecord.FollowInfo
    {

        public String customTitle;
        public boolean portedFromSavedSearches;
        public String savedSearchId;

        public ContentRecord.FollowedInterestFollowInfo()
        {
        }
    }

    public static final class ContentRecord.FollowedUser
    {

        public ContentRecord.FollowedUserEntity entity;
        public ContentRecord.FollowInfo followInfo;
        public ContentRecord.OwnedEntities ownedEntities;

        public ContentRecord.FollowedUser()
        {
        }
    }

    public static final class ContentRecord.FollowedUserEntity
    {

        public ContentRecord.SocialProfile socialProfile;
        public ContentRecord.Collection.User.UserId userIdentifier;

        public ContentRecord.FollowedUserEntity()
        {
        }
    }

    public static final class ContentRecord.Follows
    {

        List collections;
        List interests;
        List members;

        public ContentRecord.Follows()
        {
        }
    }

    public static final class ContentRecord.Image
    {

        public String id;
        public String idType;
        public ImageSize originalSize;
        public String url;

        public ContentRecord.Image()
        {
        }
    }

    public static final class ContentRecord.Image.ImageSize
    {

        public int height;
        public int width;

        public ContentRecord.Image.ImageSize()
        {
        }
    }

    public static final class ContentRecord.Interest
    {

        public String interestId;
        public String source;
        public String title;

        public ContentRecord.Interest()
        {
        }
    }

    public static final class ContentRecord.Listing extends CompactListing
    {

        public List aspectValuesList;
        public Boolean dealMsku;
        public List dealVariations;
        public List discountPrices;
        public EekInfo eekInfo;
        public boolean freeShippingAvailable;
        public String imageUrl;
        public Boolean multipleVariationsListed;
        public List purchaseOptions;
        public com.ebay.nautilus.domain.net.api.viewlisting.Listing.QuantityAndAvailabilityByLogisticsPlans quantityAndAvailabilityByLogisticsPlans;
        public Integer rtmTrackingUrl;
        public com.ebay.nautilus.domain.data.BaseCommonType.TimeDuration timeRemaining;

        public ContentRecord.Listing()
        {
        }
    }

    public static final class ContentRecord.Listing.DiscountPrice extends com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPrice
    {

        public com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum discountPriceEnum;

        public ContentRecord.Listing.DiscountPrice()
        {
        }
    }

    public static final class ContentRecord.Listing.EekInfo
    {

        public String displayText;
        public String label;
        public List status;

        public ContentRecord.Listing.EekInfo()
        {
        }
    }

    public static final class ContentRecord.Member
    {

        public EbayCosDateTime createDate;
        public String displayName;
        public Double feedbackPercentage;
        public Integer feedbackScore;
        public Integer feedbackStar;
        public Boolean hasStore;
        public String imageUrl;
        Boolean isTopRatedSeller;
        public EbayCosDateTime lastModifiedDate;
        public String loginName;
        public Boolean newUser;
        public String registrationSite;

        public ContentRecord.Member()
        {
        }
    }

    public static final class ContentRecord.Name extends Enum
    {

        private static final ContentRecord.Name $VALUES[];
        public static final ContentRecord.Name listAnItem;
        public static final ContentRecord.Name sellingTips;
        public static final ContentRecord.Name valet;

        public static ContentRecord.Name valueOf(String s)
        {
            return (ContentRecord.Name)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$Name, s);
        }

        public static ContentRecord.Name[] values()
        {
            return (ContentRecord.Name[])$VALUES.clone();
        }

        static 
        {
            listAnItem = new ContentRecord.Name("listAnItem", 0);
            sellingTips = new ContentRecord.Name("sellingTips", 1);
            valet = new ContentRecord.Name("valet", 2);
            $VALUES = (new ContentRecord.Name[] {
                listAnItem, sellingTips, valet
            });
        }

        private ContentRecord.Name(String s, int i)
        {
            super(s, i);
        }
    }

    public static class ContentRecord.Notification
    {

        public CallToAction action;
        public boolean buyerNotification;
        public String content;
        public int count;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime creationDate;
        public com.ebay.nautilus.domain.data.SymbanNotification.UiGroupEnum group;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime lastModifiedDate;
        public com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum mdnsName;
        public String name;
        public String notificationId;
        public String notificationType;
        public String notificationUrl;
        public boolean popup;
        public com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum status;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text subTitle;
        public NotificationSubject subject;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime subjectEventDate;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text title;

        public ContentRecord.Notification()
        {
        }
    }

    public static class ContentRecord.Notification.CallToAction
    {

        public com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum name;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text title;

        public ContentRecord.Notification.CallToAction()
        {
        }
    }

    public static class ContentRecord.Notification.NotificationSubject
    {

        public Listing listing;

        public ContentRecord.Notification.NotificationSubject()
        {
        }
    }

    public static class ContentRecord.Notification.NotificationSubject.Listing extends CompactListing
    {

        public String imageUrl;
        public Boolean reservePriceMet;
        public String transactionId;
        public String type;

        public ContentRecord.Notification.NotificationSubject.Listing()
        {
        }
    }

    public static final class ContentRecord.OwnedCollections
    {

        public int publicCount;

        public ContentRecord.OwnedCollections()
        {
        }
    }

    public static final class ContentRecord.OwnedEntities
    {

        public ContentRecord.OwnedCollections collections;
        public ContentRecord.OwnedListings listings;

        public ContentRecord.OwnedEntities()
        {
        }
    }

    public static final class ContentRecord.OwnedListings
    {

        public Integer activeCount;

        public ContentRecord.OwnedListings()
        {
        }
    }

    public static class ContentRecord.PurchaseSummary
    {

        public boolean hasMorePurchase;
        public int totalCount;
        public int waitingForPaymentCount;

        public ContentRecord.PurchaseSummary()
        {
        }
    }

    public static final class ContentRecord.RppEvent
    {

        public String description;
        public String displayName;
        public Date endDate;
        public String eventId;
        public String mobileAppBannerImageUrl;
        public String mobileAppHeroImageUrl;
        public String name;
        public Boolean showTimer;
        public String skinnyHeroImageUrl;
        public Date startDate;
        public String url;

        public ContentRecord.RppEvent()
        {
        }
    }

    public static final class ContentRecord.RppEventGroup
    {

        public String displayName;
        public String groupId;
        public Boolean hasMoreEvents;
        public String name;
        public List rppEvents;

        public ContentRecord.RppEventGroup()
        {
        }
    }

    public static final class ContentRecord.Rtm
    {

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

        public ContentRecord.Rtm()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmAd
    {

        public Details details;
        public Summary summary;

        public ContentRecord.Rtm.RtmAd()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmAd.Details
    {

        public GoogleDfpCampaign googleDfpCampaign;

        public ContentRecord.Rtm.RtmAd.Details()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign
    {

        public int adSizeHeight;
        public int adSizeWidth;
        public String adUnitId;
        public Parameters parameters;
        public String ppid;
        public boolean userTargetedFlag;

        public ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign.Parameters
    {

        public List parameters;

        public ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign.Parameters()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmAd.Summary
    {

        public String clickId;
        public String rtmTrackingUrl;
        public String subtitle;
        public String thumbnailUrl;
        public String title;

        public ContentRecord.Rtm.RtmAd.Summary()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmAdsCampaign
    {

        public List ads;
        public int numResults;
        public String provider;

        public ContentRecord.Rtm.RtmAdsCampaign()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmDownloadCampaign
    {

        public String appStoreUrl;
        public String infoUrl;
        public String rtmTrackingUrl;
        public String title;

        public ContentRecord.Rtm.RtmDownloadCampaign()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmHtmlCampaign
    {

        public String htmlPageUrl;
        public String rtmTrackingUrl;
        public String title;

        public ContentRecord.Rtm.RtmHtmlCampaign()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmItem
    {

        public String itemId;

        public ContentRecord.Rtm.RtmItem()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmItemCampaign
    {

        public String imageUrl;
        public List listings;
        public String title;

        public ContentRecord.Rtm.RtmItemCampaign()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmListItem
    {

        public String itemSearchUrl;
        public String itemThumbnailUrl;
        public String rtmTrackingUrl;
        public String searchDescription;

        public ContentRecord.Rtm.RtmListItem()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmListing
    {

        public String aspectValues;
        public String listingId;
        public String rtmTrackingUrl;
        public String type;

        public ContentRecord.Rtm.RtmListing()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmMultiThemedSearchCampaign
    {

        public String bannerImageUrl;
        public ThemedSearchCampaignList themedSearchCampaignList;
        public String title;

        public ContentRecord.Rtm.RtmMultiThemedSearchCampaign()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmMultiThemedSearchCampaign.ThemedSearchCampaignList
    {

        public List themedSearchCampaign;

        public ContentRecord.Rtm.RtmMultiThemedSearchCampaign.ThemedSearchCampaignList()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmTabletItemCampaign
    {

        public List listings;

        public ContentRecord.Rtm.RtmTabletItemCampaign()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmThemedSearchCampaign
    {

        public String bannerImageUrl;
        public RTMListItems listItems;
        public String title;

        public ContentRecord.Rtm.RtmThemedSearchCampaign()
        {
        }
    }

    public static final class ContentRecord.Rtm.RtmThemedSearchCampaign.RTMListItems
    {

        public List listItem;

        public ContentRecord.Rtm.RtmThemedSearchCampaign.RTMListItems()
        {
        }
    }

    public static final class ContentRecord.ScheduledListing
    {

        public List images;
        public String listingId;
        public com.ebay.nautilus.domain.net.api.viewlisting.Listing.ListingLifecycle listingLifecycle;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text title;

        public ContentRecord.ScheduledListing()
        {
        }
    }

    public static final class ContentRecord.ScheduledListing.Image
    {

        public String imageUrl;
        public String type;

        public ContentRecord.ScheduledListing.Image()
        {
        }
    }

    public static final class ContentRecord.SellingDraft
    {

        public String categoryIdPath;
        public String draftId;
        public String imageUrl;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime lastModified;
        public String listingMode;
        public int siteId;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text title;
        public ContentRecord.Type type;

        public ContentRecord.SellingDraft()
        {
        }
    }

    public static final class ContentRecord.SellingImageList
    {

        public ContentRecord.Button button;
        public List items;
        public ContentRecord.Name name;
        public String title;
        public String trackingId;
        public ContentRecord.Type type;

        public ContentRecord.SellingImageList()
        {
        }
    }

    public static final class ContentRecord.SellingImageList.Item
    {

        public ContentRecord.Image image;
        public String subtext;

        public ContentRecord.SellingImageList.Item()
        {
        }
    }

    public static final class ContentRecord.SellingImageTemplate
    {

        public ContentRecord.Button button;
        public ContentRecord.Image image;
        public ContentRecord.Name name;
        public String subtext;
        public String title;
        public String trackingId;
        public ContentRecord.Type type;

        public ContentRecord.SellingImageTemplate()
        {
        }
    }

    public static final class ContentRecord.SellingOverview
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount grossMerchandiseVolume;
        public boolean hasMoreSold;
        public boolean isFirstTimeLister;
        public int numberOfActiveItems;
        public int numberOfSoldItems;
        public int numberOfUnsoldItems;
        public int periodInDays;

        public ContentRecord.SellingOverview()
        {
        }
    }

    public static final class ContentRecord.SignIn
    {

        public Template template;

        public ContentRecord.SignIn()
        {
        }
    }

    public static final class ContentRecord.SignIn.Template extends Enum
    {

        private static final ContentRecord.SignIn.Template $VALUES[];
        public static final ContentRecord.SignIn.Template FULLSCREEN;
        public static final ContentRecord.SignIn.Template MINI;

        public static ContentRecord.SignIn.Template valueOf(String s)
        {
            return (ContentRecord.SignIn.Template)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$SignIn$Template, s);
        }

        public static ContentRecord.SignIn.Template[] values()
        {
            return (ContentRecord.SignIn.Template[])$VALUES.clone();
        }

        static 
        {
            FULLSCREEN = new ContentRecord.SignIn.Template("FULLSCREEN", 0);
            MINI = new ContentRecord.SignIn.Template("MINI", 1);
            $VALUES = (new ContentRecord.SignIn.Template[] {
                FULLSCREEN, MINI
            });
        }

        private ContentRecord.SignIn.Template(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ContentRecord.SocialProfile
    {

        public com.ebay.nautilus.domain.net.api.viewlisting.Listing.AvatarImage avatarImage;

        public ContentRecord.SocialProfile()
        {
        }
    }

    public static final class ContentRecord.SoldListingsSummary
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount grossMerchandiseVolume;
        public boolean hasMoreSold;
        public int numberOfItemsAwaitingPayment;
        public int numberOfSoldItems;
        public int numberOfSoldUnshippedItems;
        public int periodInDays;

        public ContentRecord.SoldListingsSummary()
        {
        }
    }

    public static final class ContentRecord.Topic
    {

        public ContentRecord.Image bannerImage;
        public String categoryId;
        public List collectionIds;
        public String description;
        public String label;
        public RankDelta rankDelta;
        public SearchStats searchStats;
        public ContentRecord.Image squareImage;
        public String title;
        public int topicId;
        public List trendingListingSummaries;

        public ContentRecord.Topic()
        {
        }
    }

    public static final class ContentRecord.Topic.RankDelta
    {

        public String change;
        public ContentRecord.Topic.TextSpanValueProperty delta;

        public ContentRecord.Topic.RankDelta()
        {
        }
    }

    public static final class ContentRecord.Topic.SearchStats
    {

        public ContentRecord.Topic.TextSpanValueProperty total;
        public ContentRecord.Topic.TextSpanValueProperty totalClicks;

        public ContentRecord.Topic.SearchStats()
        {
        }
    }

    public static class ContentRecord.Topic.TextSpanValueProperty
    {

        public Object value;

        public ContentRecord.Topic.TextSpanValueProperty()
        {
        }
    }

    public static final class ContentRecord.Topic.TrendingListingSummary
    {

        public ListingSummary listingSummary;

        public ContentRecord.Topic.TrendingListingSummary()
        {
        }
    }

    public static final class ContentRecord.Topic.TrendingListingSummary.ListingSummary
    {

        public ContentRecord.Image image;
        public String listingId;

        public ContentRecord.Topic.TrendingListingSummary.ListingSummary()
        {
        }
    }

    public static final class ContentRecord.Type extends Enum
    {

        private static final ContentRecord.Type $VALUES[];
        public static final ContentRecord.Type ListingDraft;
        public static final ContentRecord.Type imageListTemplate;
        public static final ContentRecord.Type imageTemplate;

        public static ContentRecord.Type valueOf(String s)
        {
            return (ContentRecord.Type)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$Type, s);
        }

        public static ContentRecord.Type[] values()
        {
            return (ContentRecord.Type[])$VALUES.clone();
        }

        static 
        {
            imageTemplate = new ContentRecord.Type("imageTemplate", 0);
            imageListTemplate = new ContentRecord.Type("imageListTemplate", 1);
            ListingDraft = new ContentRecord.Type("ListingDraft", 2);
            $VALUES = (new ContentRecord.Type[] {
                imageTemplate, imageListTemplate, ListingDraft
            });
        }

        private ContentRecord.Type(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ContentRecord.UnsoldListingsSummary
    {

        public int numberOfUnsoldListings;
        public int numberOfUnsoldListingsNotRelisted;

        public ContentRecord.UnsoldListingsSummary()
        {
        }
    }

    public static final class ContentRecord.Watching
    {

        public List listings;

        public ContentRecord.Watching()
        {
        }
    }

    public static final class PaginationOutput
    {

        public List pagination;

        public PaginationOutput()
        {
        }
    }


    public Boolean blended;
    public ContentSourceEnum contentSource;
    public List contents;
    public List follow;
    public String lastRefreshedTag;

    public PaginationOutput()
    {
    }
}
