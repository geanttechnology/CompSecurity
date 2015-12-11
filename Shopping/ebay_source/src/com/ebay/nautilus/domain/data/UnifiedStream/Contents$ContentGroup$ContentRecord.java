// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import com.ebay.nautilus.domain.data.CompactListing;
import com.ebay.nautilus.domain.data.EbayCosDateTime;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Contents, Category, Department, ContentSourceEnum, 
//            RecordStatusEnum, ContentTypeEnum

public static final class Watching
{
    public static final class ActiveListingsSummary
    {

        public int numberOfActiveListings;
        public int numberOfListingsWithBids;
        public int numberofListingsWithPendingOffers;

        public ActiveListingsSummary()
        {
        }
    }

    public static class BestOfferSummary
    {

        public int counterOfferCount;
        public int totalCount;

        public BestOfferSummary()
        {
        }
    }

    public static class BidSummary
    {

        public int outbidCount;
        public int totalCount;
        public int winningCount;

        public BidSummary()
        {
        }
    }

    public static final class Button
    {

        public String text;
        public String url;

        public Button()
        {
        }
    }

    public static final class BuyingOverview
    {

        public BestOfferSummary bestOfferSummary;
        public BidSummary bidSummary;
        public boolean emptyBuying;
        public PurchaseSummary purchaseSummary;

        public BuyingOverview()
        {
        }
    }

    public static final class Collection
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

        public Collection()
        {
        }
    }

    public static final class Collection.User
    {

        public String profileImageURL;
        public UserId userIdentifier;

        public Collection.User()
        {
        }
    }

    public static final class Collection.User.UserId
    {

        public String userId;
        public String username;

        public Collection.User.UserId()
        {
        }
    }

    public static final class FeedEvent
    {

        public Collection collection;
        public List collections;
        public List followers;
        public Interest interest;
        public List interests;
        public List listings;
        public Member user;
        public List users;

        public FeedEvent()
        {
        }
    }

    public static class FollowInfo
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime followDate;
        public boolean hidden;
        public Visibility visibility;

        public FollowInfo()
        {
        }
    }

    public static final class FollowInfo.Visibility extends Enum
    {

        private static final FollowInfo.Visibility $VALUES[];
        public static final FollowInfo.Visibility PRIVATE;
        public static final FollowInfo.Visibility PUBLIC;

        public static FollowInfo.Visibility valueOf(String s)
        {
            return (FollowInfo.Visibility)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$FollowInfo$Visibility, s);
        }

        public static FollowInfo.Visibility[] values()
        {
            return (FollowInfo.Visibility[])$VALUES.clone();
        }

        static 
        {
            PUBLIC = new FollowInfo.Visibility("PUBLIC", 0);
            PRIVATE = new FollowInfo.Visibility("PRIVATE", 1);
            $VALUES = (new FollowInfo.Visibility[] {
                PUBLIC, PRIVATE
            });
        }

        private FollowInfo.Visibility(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class FollowedEntities
    {

        public boolean emptyFollow;
        public List followedInterests;
        public List followedUsers;

        public FollowedEntities()
        {
        }
    }

    public static final class FollowedInterest
    {

        public FollowedInterestEntity entity;
        public FollowedInterestFollowInfo followInfo;

        public FollowedInterest()
        {
        }
    }

    public static final class FollowedInterestEntity
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime createdDate;
        public String customTitle;
        public FollowedImageUrl imageUrl;
        public String interestId;
        public String marketplaceId;
        public SearchRequest searchRequest;
        public String searchUrl;
        public String title;

        public FollowedInterestEntity()
        {
        }
    }

    public static final class FollowedInterestEntity.FollowedImageUrl
    {

        public String thumbs;

        public FollowedInterestEntity.FollowedImageUrl()
        {
        }
    }

    public static final class FollowedInterestEntity.SearchRequest
    {

        public List categoryId;
        public String keyword;

        public FollowedInterestEntity.SearchRequest()
        {
        }
    }

    public static final class FollowedInterestFollowInfo extends FollowInfo
    {

        public String customTitle;
        public boolean portedFromSavedSearches;
        public String savedSearchId;

        public FollowedInterestFollowInfo()
        {
        }
    }

    public static final class FollowedUser
    {

        public FollowedUserEntity entity;
        public FollowInfo followInfo;
        public OwnedEntities ownedEntities;

        public FollowedUser()
        {
        }
    }

    public static final class FollowedUserEntity
    {

        public SocialProfile socialProfile;
        public Collection.User.UserId userIdentifier;

        public FollowedUserEntity()
        {
        }
    }

    public static final class Follows
    {

        List collections;
        List interests;
        List members;

        public Follows()
        {
        }
    }

    public static final class Image
    {

        public String id;
        public String idType;
        public ImageSize originalSize;
        public String url;

        public Image()
        {
        }
    }

    public static final class Image.ImageSize
    {

        public int height;
        public int width;

        public Image.ImageSize()
        {
        }
    }

    public static final class Interest
    {

        public String interestId;
        public String source;
        public String title;

        public Interest()
        {
        }
    }

    public static final class Listing extends CompactListing
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

        public Listing()
        {
        }
    }

    public static final class Listing.DiscountPrice extends com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPrice
    {

        public com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum discountPriceEnum;

        public Listing.DiscountPrice()
        {
        }
    }

    public static final class Listing.EekInfo
    {

        public String displayText;
        public String label;
        public List status;

        public Listing.EekInfo()
        {
        }
    }

    public static final class Member
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

        public Member()
        {
        }
    }

    public static final class Name extends Enum
    {

        private static final Name $VALUES[];
        public static final Name listAnItem;
        public static final Name sellingTips;
        public static final Name valet;

        public static Name valueOf(String s)
        {
            return (Name)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$Name, s);
        }

        public static Name[] values()
        {
            return (Name[])$VALUES.clone();
        }

        static 
        {
            listAnItem = new Name("listAnItem", 0);
            sellingTips = new Name("sellingTips", 1);
            valet = new Name("valet", 2);
            $VALUES = (new Name[] {
                listAnItem, sellingTips, valet
            });
        }

        private Name(String s, int i)
        {
            super(s, i);
        }
    }

    public static class Notification
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

        public Notification()
        {
        }
    }

    public static class Notification.CallToAction
    {

        public com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum name;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text title;

        public Notification.CallToAction()
        {
        }
    }

    public static class Notification.NotificationSubject
    {

        public Listing listing;

        public Notification.NotificationSubject()
        {
        }
    }

    public static class Notification.NotificationSubject.Listing extends CompactListing
    {

        public String imageUrl;
        public Boolean reservePriceMet;
        public String transactionId;
        public String type;

        public Notification.NotificationSubject.Listing()
        {
        }
    }

    public static final class OwnedCollections
    {

        public int publicCount;

        public OwnedCollections()
        {
        }
    }

    public static final class OwnedEntities
    {

        public OwnedCollections collections;
        public OwnedListings listings;

        public OwnedEntities()
        {
        }
    }

    public static final class OwnedListings
    {

        public Integer activeCount;

        public OwnedListings()
        {
        }
    }

    public static class PurchaseSummary
    {

        public boolean hasMorePurchase;
        public int totalCount;
        public int waitingForPaymentCount;

        public PurchaseSummary()
        {
        }
    }

    public static final class RppEvent
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

        public RppEvent()
        {
        }
    }

    public static final class RppEventGroup
    {

        public String displayName;
        public String groupId;
        public Boolean hasMoreEvents;
        public String name;
        public List rppEvents;

        public RppEventGroup()
        {
        }
    }

    public static final class Rtm
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

        public Rtm()
        {
        }
    }

    public static final class Rtm.RtmAd
    {

        public Details details;
        public Summary summary;

        public Rtm.RtmAd()
        {
        }
    }

    public static final class Rtm.RtmAd.Details
    {

        public GoogleDfpCampaign googleDfpCampaign;

        public Rtm.RtmAd.Details()
        {
        }
    }

    public static final class Rtm.RtmAd.Details.GoogleDfpCampaign
    {

        public int adSizeHeight;
        public int adSizeWidth;
        public String adUnitId;
        public Parameters parameters;
        public String ppid;
        public boolean userTargetedFlag;

        public Rtm.RtmAd.Details.GoogleDfpCampaign()
        {
        }
    }

    public static final class Rtm.RtmAd.Details.GoogleDfpCampaign.Parameters
    {

        public List parameters;

        public Rtm.RtmAd.Details.GoogleDfpCampaign.Parameters()
        {
        }
    }

    public static final class Rtm.RtmAd.Summary
    {

        public String clickId;
        public String rtmTrackingUrl;
        public String subtitle;
        public String thumbnailUrl;
        public String title;

        public Rtm.RtmAd.Summary()
        {
        }
    }

    public static final class Rtm.RtmAdsCampaign
    {

        public List ads;
        public int numResults;
        public String provider;

        public Rtm.RtmAdsCampaign()
        {
        }
    }

    public static final class Rtm.RtmDownloadCampaign
    {

        public String appStoreUrl;
        public String infoUrl;
        public String rtmTrackingUrl;
        public String title;

        public Rtm.RtmDownloadCampaign()
        {
        }
    }

    public static final class Rtm.RtmHtmlCampaign
    {

        public String htmlPageUrl;
        public String rtmTrackingUrl;
        public String title;

        public Rtm.RtmHtmlCampaign()
        {
        }
    }

    public static final class Rtm.RtmItem
    {

        public String itemId;

        public Rtm.RtmItem()
        {
        }
    }

    public static final class Rtm.RtmItemCampaign
    {

        public String imageUrl;
        public List listings;
        public String title;

        public Rtm.RtmItemCampaign()
        {
        }
    }

    public static final class Rtm.RtmListItem
    {

        public String itemSearchUrl;
        public String itemThumbnailUrl;
        public String rtmTrackingUrl;
        public String searchDescription;

        public Rtm.RtmListItem()
        {
        }
    }

    public static final class Rtm.RtmListing
    {

        public String aspectValues;
        public String listingId;
        public String rtmTrackingUrl;
        public String type;

        public Rtm.RtmListing()
        {
        }
    }

    public static final class Rtm.RtmMultiThemedSearchCampaign
    {

        public String bannerImageUrl;
        public ThemedSearchCampaignList themedSearchCampaignList;
        public String title;

        public Rtm.RtmMultiThemedSearchCampaign()
        {
        }
    }

    public static final class Rtm.RtmMultiThemedSearchCampaign.ThemedSearchCampaignList
    {

        public List themedSearchCampaign;

        public Rtm.RtmMultiThemedSearchCampaign.ThemedSearchCampaignList()
        {
        }
    }

    public static final class Rtm.RtmTabletItemCampaign
    {

        public List listings;

        public Rtm.RtmTabletItemCampaign()
        {
        }
    }

    public static final class Rtm.RtmThemedSearchCampaign
    {

        public String bannerImageUrl;
        public RTMListItems listItems;
        public String title;

        public Rtm.RtmThemedSearchCampaign()
        {
        }
    }

    public static final class Rtm.RtmThemedSearchCampaign.RTMListItems
    {

        public List listItem;

        public Rtm.RtmThemedSearchCampaign.RTMListItems()
        {
        }
    }

    public static final class ScheduledListing
    {

        public List images;
        public String listingId;
        public com.ebay.nautilus.domain.net.api.viewlisting.Listing.ListingLifecycle listingLifecycle;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text title;

        public ScheduledListing()
        {
        }
    }

    public static final class ScheduledListing.Image
    {

        public String imageUrl;
        public String type;

        public ScheduledListing.Image()
        {
        }
    }

    public static final class SellingDraft
    {

        public String categoryIdPath;
        public String draftId;
        public String imageUrl;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime lastModified;
        public String listingMode;
        public int siteId;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text title;
        public Type type;

        public SellingDraft()
        {
        }
    }

    public static final class SellingImageList
    {

        public Button button;
        public List items;
        public Name name;
        public String title;
        public String trackingId;
        public Type type;

        public SellingImageList()
        {
        }
    }

    public static final class SellingImageList.Item
    {

        public Image image;
        public String subtext;

        public SellingImageList.Item()
        {
        }
    }

    public static final class SellingImageTemplate
    {

        public Button button;
        public Image image;
        public Name name;
        public String subtext;
        public String title;
        public String trackingId;
        public Type type;

        public SellingImageTemplate()
        {
        }
    }

    public static final class SellingOverview
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount grossMerchandiseVolume;
        public boolean hasMoreSold;
        public boolean isFirstTimeLister;
        public int numberOfActiveItems;
        public int numberOfSoldItems;
        public int numberOfUnsoldItems;
        public int periodInDays;

        public SellingOverview()
        {
        }
    }

    public static final class SignIn
    {

        public Template template;

        public SignIn()
        {
        }
    }

    public static final class SignIn.Template extends Enum
    {

        private static final SignIn.Template $VALUES[];
        public static final SignIn.Template FULLSCREEN;
        public static final SignIn.Template MINI;

        public static SignIn.Template valueOf(String s)
        {
            return (SignIn.Template)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$SignIn$Template, s);
        }

        public static SignIn.Template[] values()
        {
            return (SignIn.Template[])$VALUES.clone();
        }

        static 
        {
            FULLSCREEN = new SignIn.Template("FULLSCREEN", 0);
            MINI = new SignIn.Template("MINI", 1);
            $VALUES = (new SignIn.Template[] {
                FULLSCREEN, MINI
            });
        }

        private SignIn.Template(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class SocialProfile
    {

        public com.ebay.nautilus.domain.net.api.viewlisting.Listing.AvatarImage avatarImage;

        public SocialProfile()
        {
        }
    }

    public static final class SoldListingsSummary
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount grossMerchandiseVolume;
        public boolean hasMoreSold;
        public int numberOfItemsAwaitingPayment;
        public int numberOfSoldItems;
        public int numberOfSoldUnshippedItems;
        public int periodInDays;

        public SoldListingsSummary()
        {
        }
    }

    public static final class Topic
    {

        public Image bannerImage;
        public String categoryId;
        public List collectionIds;
        public String description;
        public String label;
        public RankDelta rankDelta;
        public SearchStats searchStats;
        public Image squareImage;
        public String title;
        public int topicId;
        public List trendingListingSummaries;

        public Topic()
        {
        }
    }

    public static final class Topic.RankDelta
    {

        public String change;
        public Topic.TextSpanValueProperty delta;

        public Topic.RankDelta()
        {
        }
    }

    public static final class Topic.SearchStats
    {

        public Topic.TextSpanValueProperty total;
        public Topic.TextSpanValueProperty totalClicks;

        public Topic.SearchStats()
        {
        }
    }

    public static class Topic.TextSpanValueProperty
    {

        public Object value;

        public Topic.TextSpanValueProperty()
        {
        }
    }

    public static final class Topic.TrendingListingSummary
    {

        public ListingSummary listingSummary;

        public Topic.TrendingListingSummary()
        {
        }
    }

    public static final class Topic.TrendingListingSummary.ListingSummary
    {

        public Image image;
        public String listingId;

        public Topic.TrendingListingSummary.ListingSummary()
        {
        }
    }

    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type ListingDraft;
        public static final Type imageListTemplate;
        public static final Type imageTemplate;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            imageTemplate = new Type("imageTemplate", 0);
            imageListTemplate = new Type("imageListTemplate", 1);
            ListingDraft = new Type("ListingDraft", 2);
            $VALUES = (new Type[] {
                imageTemplate, imageListTemplate, ListingDraft
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class UnsoldListingsSummary
    {

        public int numberOfUnsoldListings;
        public int numberOfUnsoldListingsNotRelisted;

        public UnsoldListingsSummary()
        {
        }
    }

    public static final class Watching
    {

        public List listings;

        public Watching()
        {
        }
    }


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

    public Watching()
    {
    }
}
