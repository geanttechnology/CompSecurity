// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.CompactListing;
import com.ebay.nautilus.domain.data.EbayCosDateTime;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            ContentSourceEnum, Category, Department, RecordStatusEnum, 
//            ContentTypeEnum

public class Contents extends BaseApiResponse
    implements Parcelable
{
    public static final class ContentGroup
    {

        public Boolean blended;
        public ContentSourceEnum contentSource;
        public List contents;
        public List follow;
        public String lastRefreshedTag;

        public ContentGroup()
        {
        }
    }

    public static final class ContentGroup.ContentRecord
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

        public ContentGroup.ContentRecord()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.ActiveListingsSummary
    {

        public int numberOfActiveListings;
        public int numberOfListingsWithBids;
        public int numberofListingsWithPendingOffers;

        public ContentGroup.ContentRecord.ActiveListingsSummary()
        {
        }
    }

    public static class ContentGroup.ContentRecord.BestOfferSummary
    {

        public int counterOfferCount;
        public int totalCount;

        public ContentGroup.ContentRecord.BestOfferSummary()
        {
        }
    }

    public static class ContentGroup.ContentRecord.BidSummary
    {

        public int outbidCount;
        public int totalCount;
        public int winningCount;

        public ContentGroup.ContentRecord.BidSummary()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Button
    {

        public String text;
        public String url;

        public ContentGroup.ContentRecord.Button()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.BuyingOverview
    {

        public ContentGroup.ContentRecord.BestOfferSummary bestOfferSummary;
        public ContentGroup.ContentRecord.BidSummary bidSummary;
        public boolean emptyBuying;
        public ContentGroup.ContentRecord.PurchaseSummary purchaseSummary;

        public ContentGroup.ContentRecord.BuyingOverview()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Collection
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

        public ContentGroup.ContentRecord.Collection()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Collection.User
    {

        public String profileImageURL;
        public UserId userIdentifier;

        public ContentGroup.ContentRecord.Collection.User()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Collection.User.UserId
    {

        public String userId;
        public String username;

        public ContentGroup.ContentRecord.Collection.User.UserId()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.FeedEvent
    {

        public ContentGroup.ContentRecord.Collection collection;
        public List collections;
        public List followers;
        public ContentGroup.ContentRecord.Interest interest;
        public List interests;
        public List listings;
        public ContentGroup.ContentRecord.Member user;
        public List users;

        public ContentGroup.ContentRecord.FeedEvent()
        {
        }
    }

    public static class ContentGroup.ContentRecord.FollowInfo
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime followDate;
        public boolean hidden;
        public Visibility visibility;

        public ContentGroup.ContentRecord.FollowInfo()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.FollowInfo.Visibility extends Enum
    {

        private static final ContentGroup.ContentRecord.FollowInfo.Visibility $VALUES[];
        public static final ContentGroup.ContentRecord.FollowInfo.Visibility PRIVATE;
        public static final ContentGroup.ContentRecord.FollowInfo.Visibility PUBLIC;

        public static ContentGroup.ContentRecord.FollowInfo.Visibility valueOf(String s)
        {
            return (ContentGroup.ContentRecord.FollowInfo.Visibility)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$FollowInfo$Visibility, s);
        }

        public static ContentGroup.ContentRecord.FollowInfo.Visibility[] values()
        {
            return (ContentGroup.ContentRecord.FollowInfo.Visibility[])$VALUES.clone();
        }

        static 
        {
            PUBLIC = new ContentGroup.ContentRecord.FollowInfo.Visibility("PUBLIC", 0);
            PRIVATE = new ContentGroup.ContentRecord.FollowInfo.Visibility("PRIVATE", 1);
            $VALUES = (new ContentGroup.ContentRecord.FollowInfo.Visibility[] {
                PUBLIC, PRIVATE
            });
        }

        private ContentGroup.ContentRecord.FollowInfo.Visibility(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ContentGroup.ContentRecord.FollowedEntities
    {

        public boolean emptyFollow;
        public List followedInterests;
        public List followedUsers;

        public ContentGroup.ContentRecord.FollowedEntities()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.FollowedInterest
    {

        public ContentGroup.ContentRecord.FollowedInterestEntity entity;
        public ContentGroup.ContentRecord.FollowedInterestFollowInfo followInfo;

        public ContentGroup.ContentRecord.FollowedInterest()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.FollowedInterestEntity
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime createdDate;
        public String customTitle;
        public FollowedImageUrl imageUrl;
        public String interestId;
        public String marketplaceId;
        public SearchRequest searchRequest;
        public String searchUrl;
        public String title;

        public ContentGroup.ContentRecord.FollowedInterestEntity()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.FollowedInterestEntity.FollowedImageUrl
    {

        public String thumbs;

        public ContentGroup.ContentRecord.FollowedInterestEntity.FollowedImageUrl()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.FollowedInterestEntity.SearchRequest
    {

        public List categoryId;
        public String keyword;

        public ContentGroup.ContentRecord.FollowedInterestEntity.SearchRequest()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.FollowedInterestFollowInfo extends ContentGroup.ContentRecord.FollowInfo
    {

        public String customTitle;
        public boolean portedFromSavedSearches;
        public String savedSearchId;

        public ContentGroup.ContentRecord.FollowedInterestFollowInfo()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.FollowedUser
    {

        public ContentGroup.ContentRecord.FollowedUserEntity entity;
        public ContentGroup.ContentRecord.FollowInfo followInfo;
        public ContentGroup.ContentRecord.OwnedEntities ownedEntities;

        public ContentGroup.ContentRecord.FollowedUser()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.FollowedUserEntity
    {

        public ContentGroup.ContentRecord.SocialProfile socialProfile;
        public ContentGroup.ContentRecord.Collection.User.UserId userIdentifier;

        public ContentGroup.ContentRecord.FollowedUserEntity()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Follows
    {

        List collections;
        List interests;
        List members;

        public ContentGroup.ContentRecord.Follows()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Image
    {

        public String id;
        public String idType;
        public ImageSize originalSize;
        public String url;

        public ContentGroup.ContentRecord.Image()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Image.ImageSize
    {

        public int height;
        public int width;

        public ContentGroup.ContentRecord.Image.ImageSize()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Interest
    {

        public String interestId;
        public String source;
        public String title;

        public ContentGroup.ContentRecord.Interest()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Listing extends CompactListing
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

        public ContentGroup.ContentRecord.Listing()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Listing.DiscountPrice extends com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPrice
    {

        public com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum discountPriceEnum;

        public ContentGroup.ContentRecord.Listing.DiscountPrice()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Listing.EekInfo
    {

        public String displayText;
        public String label;
        public List status;

        public ContentGroup.ContentRecord.Listing.EekInfo()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Member
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

        public ContentGroup.ContentRecord.Member()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Name extends Enum
    {

        private static final ContentGroup.ContentRecord.Name $VALUES[];
        public static final ContentGroup.ContentRecord.Name listAnItem;
        public static final ContentGroup.ContentRecord.Name sellingTips;
        public static final ContentGroup.ContentRecord.Name valet;

        public static ContentGroup.ContentRecord.Name valueOf(String s)
        {
            return (ContentGroup.ContentRecord.Name)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$Name, s);
        }

        public static ContentGroup.ContentRecord.Name[] values()
        {
            return (ContentGroup.ContentRecord.Name[])$VALUES.clone();
        }

        static 
        {
            listAnItem = new ContentGroup.ContentRecord.Name("listAnItem", 0);
            sellingTips = new ContentGroup.ContentRecord.Name("sellingTips", 1);
            valet = new ContentGroup.ContentRecord.Name("valet", 2);
            $VALUES = (new ContentGroup.ContentRecord.Name[] {
                listAnItem, sellingTips, valet
            });
        }

        private ContentGroup.ContentRecord.Name(String s, int i)
        {
            super(s, i);
        }
    }

    public static class ContentGroup.ContentRecord.Notification
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

        public ContentGroup.ContentRecord.Notification()
        {
        }
    }

    public static class ContentGroup.ContentRecord.Notification.CallToAction
    {

        public com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum name;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text title;

        public ContentGroup.ContentRecord.Notification.CallToAction()
        {
        }
    }

    public static class ContentGroup.ContentRecord.Notification.NotificationSubject
    {

        public Listing listing;

        public ContentGroup.ContentRecord.Notification.NotificationSubject()
        {
        }
    }

    public static class ContentGroup.ContentRecord.Notification.NotificationSubject.Listing extends CompactListing
    {

        public String imageUrl;
        public Boolean reservePriceMet;
        public String transactionId;
        public String type;

        public ContentGroup.ContentRecord.Notification.NotificationSubject.Listing()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.OwnedCollections
    {

        public int publicCount;

        public ContentGroup.ContentRecord.OwnedCollections()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.OwnedEntities
    {

        public ContentGroup.ContentRecord.OwnedCollections collections;
        public ContentGroup.ContentRecord.OwnedListings listings;

        public ContentGroup.ContentRecord.OwnedEntities()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.OwnedListings
    {

        public Integer activeCount;

        public ContentGroup.ContentRecord.OwnedListings()
        {
        }
    }

    public static class ContentGroup.ContentRecord.PurchaseSummary
    {

        public boolean hasMorePurchase;
        public int totalCount;
        public int waitingForPaymentCount;

        public ContentGroup.ContentRecord.PurchaseSummary()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.RppEvent
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

        public ContentGroup.ContentRecord.RppEvent()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.RppEventGroup
    {

        public String displayName;
        public String groupId;
        public Boolean hasMoreEvents;
        public String name;
        public List rppEvents;

        public ContentGroup.ContentRecord.RppEventGroup()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm
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

        public ContentGroup.ContentRecord.Rtm()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmAd
    {

        public Details details;
        public Summary summary;

        public ContentGroup.ContentRecord.Rtm.RtmAd()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmAd.Details
    {

        public GoogleDfpCampaign googleDfpCampaign;

        public ContentGroup.ContentRecord.Rtm.RtmAd.Details()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign
    {

        public int adSizeHeight;
        public int adSizeWidth;
        public String adUnitId;
        public Parameters parameters;
        public String ppid;
        public boolean userTargetedFlag;

        public ContentGroup.ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign.Parameters
    {

        public List parameters;

        public ContentGroup.ContentRecord.Rtm.RtmAd.Details.GoogleDfpCampaign.Parameters()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmAd.Summary
    {

        public String clickId;
        public String rtmTrackingUrl;
        public String subtitle;
        public String thumbnailUrl;
        public String title;

        public ContentGroup.ContentRecord.Rtm.RtmAd.Summary()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmAdsCampaign
    {

        public List ads;
        public int numResults;
        public String provider;

        public ContentGroup.ContentRecord.Rtm.RtmAdsCampaign()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmDownloadCampaign
    {

        public String appStoreUrl;
        public String infoUrl;
        public String rtmTrackingUrl;
        public String title;

        public ContentGroup.ContentRecord.Rtm.RtmDownloadCampaign()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmHtmlCampaign
    {

        public String htmlPageUrl;
        public String rtmTrackingUrl;
        public String title;

        public ContentGroup.ContentRecord.Rtm.RtmHtmlCampaign()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmItem
    {

        public String itemId;

        public ContentGroup.ContentRecord.Rtm.RtmItem()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmItemCampaign
    {

        public String imageUrl;
        public List listings;
        public String title;

        public ContentGroup.ContentRecord.Rtm.RtmItemCampaign()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmListItem
    {

        public String itemSearchUrl;
        public String itemThumbnailUrl;
        public String rtmTrackingUrl;
        public String searchDescription;

        public ContentGroup.ContentRecord.Rtm.RtmListItem()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmListing
    {

        public String aspectValues;
        public String listingId;
        public String rtmTrackingUrl;
        public String type;

        public ContentGroup.ContentRecord.Rtm.RtmListing()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmMultiThemedSearchCampaign
    {

        public String bannerImageUrl;
        public ThemedSearchCampaignList themedSearchCampaignList;
        public String title;

        public ContentGroup.ContentRecord.Rtm.RtmMultiThemedSearchCampaign()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmMultiThemedSearchCampaign.ThemedSearchCampaignList
    {

        public List themedSearchCampaign;

        public ContentGroup.ContentRecord.Rtm.RtmMultiThemedSearchCampaign.ThemedSearchCampaignList()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmTabletItemCampaign
    {

        public List listings;

        public ContentGroup.ContentRecord.Rtm.RtmTabletItemCampaign()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmThemedSearchCampaign
    {

        public String bannerImageUrl;
        public RTMListItems listItems;
        public String title;

        public ContentGroup.ContentRecord.Rtm.RtmThemedSearchCampaign()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Rtm.RtmThemedSearchCampaign.RTMListItems
    {

        public List listItem;

        public ContentGroup.ContentRecord.Rtm.RtmThemedSearchCampaign.RTMListItems()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.ScheduledListing
    {

        public List images;
        public String listingId;
        public com.ebay.nautilus.domain.net.api.viewlisting.Listing.ListingLifecycle listingLifecycle;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text title;

        public ContentGroup.ContentRecord.ScheduledListing()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.ScheduledListing.Image
    {

        public String imageUrl;
        public String type;

        public ContentGroup.ContentRecord.ScheduledListing.Image()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.SellingDraft
    {

        public String categoryIdPath;
        public String draftId;
        public String imageUrl;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime lastModified;
        public String listingMode;
        public int siteId;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text title;
        public ContentGroup.ContentRecord.Type type;

        public ContentGroup.ContentRecord.SellingDraft()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.SellingImageList
    {

        public ContentGroup.ContentRecord.Button button;
        public List items;
        public ContentGroup.ContentRecord.Name name;
        public String title;
        public String trackingId;
        public ContentGroup.ContentRecord.Type type;

        public ContentGroup.ContentRecord.SellingImageList()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.SellingImageList.Item
    {

        public ContentGroup.ContentRecord.Image image;
        public String subtext;

        public ContentGroup.ContentRecord.SellingImageList.Item()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.SellingImageTemplate
    {

        public ContentGroup.ContentRecord.Button button;
        public ContentGroup.ContentRecord.Image image;
        public ContentGroup.ContentRecord.Name name;
        public String subtext;
        public String title;
        public String trackingId;
        public ContentGroup.ContentRecord.Type type;

        public ContentGroup.ContentRecord.SellingImageTemplate()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.SellingOverview
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount grossMerchandiseVolume;
        public boolean hasMoreSold;
        public boolean isFirstTimeLister;
        public int numberOfActiveItems;
        public int numberOfSoldItems;
        public int numberOfUnsoldItems;
        public int periodInDays;

        public ContentGroup.ContentRecord.SellingOverview()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.SignIn
    {

        public Template template;

        public ContentGroup.ContentRecord.SignIn()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.SignIn.Template extends Enum
    {

        private static final ContentGroup.ContentRecord.SignIn.Template $VALUES[];
        public static final ContentGroup.ContentRecord.SignIn.Template FULLSCREEN;
        public static final ContentGroup.ContentRecord.SignIn.Template MINI;

        public static ContentGroup.ContentRecord.SignIn.Template valueOf(String s)
        {
            return (ContentGroup.ContentRecord.SignIn.Template)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$SignIn$Template, s);
        }

        public static ContentGroup.ContentRecord.SignIn.Template[] values()
        {
            return (ContentGroup.ContentRecord.SignIn.Template[])$VALUES.clone();
        }

        static 
        {
            FULLSCREEN = new ContentGroup.ContentRecord.SignIn.Template("FULLSCREEN", 0);
            MINI = new ContentGroup.ContentRecord.SignIn.Template("MINI", 1);
            $VALUES = (new ContentGroup.ContentRecord.SignIn.Template[] {
                FULLSCREEN, MINI
            });
        }

        private ContentGroup.ContentRecord.SignIn.Template(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ContentGroup.ContentRecord.SocialProfile
    {

        public com.ebay.nautilus.domain.net.api.viewlisting.Listing.AvatarImage avatarImage;

        public ContentGroup.ContentRecord.SocialProfile()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.SoldListingsSummary
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount grossMerchandiseVolume;
        public boolean hasMoreSold;
        public int numberOfItemsAwaitingPayment;
        public int numberOfSoldItems;
        public int numberOfSoldUnshippedItems;
        public int periodInDays;

        public ContentGroup.ContentRecord.SoldListingsSummary()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Topic
    {

        public ContentGroup.ContentRecord.Image bannerImage;
        public String categoryId;
        public List collectionIds;
        public String description;
        public String label;
        public RankDelta rankDelta;
        public SearchStats searchStats;
        public ContentGroup.ContentRecord.Image squareImage;
        public String title;
        public int topicId;
        public List trendingListingSummaries;

        public ContentGroup.ContentRecord.Topic()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Topic.RankDelta
    {

        public String change;
        public ContentGroup.ContentRecord.Topic.TextSpanValueProperty delta;

        public ContentGroup.ContentRecord.Topic.RankDelta()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Topic.SearchStats
    {

        public ContentGroup.ContentRecord.Topic.TextSpanValueProperty total;
        public ContentGroup.ContentRecord.Topic.TextSpanValueProperty totalClicks;

        public ContentGroup.ContentRecord.Topic.SearchStats()
        {
        }
    }

    public static class ContentGroup.ContentRecord.Topic.TextSpanValueProperty
    {

        public Object value;

        public ContentGroup.ContentRecord.Topic.TextSpanValueProperty()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Topic.TrendingListingSummary
    {

        public ListingSummary listingSummary;

        public ContentGroup.ContentRecord.Topic.TrendingListingSummary()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Topic.TrendingListingSummary.ListingSummary
    {

        public ContentGroup.ContentRecord.Image image;
        public String listingId;

        public ContentGroup.ContentRecord.Topic.TrendingListingSummary.ListingSummary()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Type extends Enum
    {

        private static final ContentGroup.ContentRecord.Type $VALUES[];
        public static final ContentGroup.ContentRecord.Type ListingDraft;
        public static final ContentGroup.ContentRecord.Type imageListTemplate;
        public static final ContentGroup.ContentRecord.Type imageTemplate;

        public static ContentGroup.ContentRecord.Type valueOf(String s)
        {
            return (ContentGroup.ContentRecord.Type)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$Type, s);
        }

        public static ContentGroup.ContentRecord.Type[] values()
        {
            return (ContentGroup.ContentRecord.Type[])$VALUES.clone();
        }

        static 
        {
            imageTemplate = new ContentGroup.ContentRecord.Type("imageTemplate", 0);
            imageListTemplate = new ContentGroup.ContentRecord.Type("imageListTemplate", 1);
            ListingDraft = new ContentGroup.ContentRecord.Type("ListingDraft", 2);
            $VALUES = (new ContentGroup.ContentRecord.Type[] {
                imageTemplate, imageListTemplate, ListingDraft
            });
        }

        private ContentGroup.ContentRecord.Type(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ContentGroup.ContentRecord.UnsoldListingsSummary
    {

        public int numberOfUnsoldListings;
        public int numberOfUnsoldListingsNotRelisted;

        public ContentGroup.ContentRecord.UnsoldListingsSummary()
        {
        }
    }

    public static final class ContentGroup.ContentRecord.Watching
    {

        public List listings;

        public ContentGroup.ContentRecord.Watching()
        {
        }
    }

    public static final class ContentGroup.PaginationOutput
    {

        public List pagination;

        public ContentGroup.PaginationOutput()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Contents createFromParcel(Parcel parcel)
        {
            return (Contents)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/UnifiedStream/Contents);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Contents[] newArray(int i)
        {
            return new Contents[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public List contentGroups;
    public ContentGroup.PaginationOutput paginationOutput;

    public Contents()
    {
    }

    public ContentGroup getContentGroup(ContentSourceEnum contentsourceenum)
    {
label0:
        {
            if (contentGroups == null)
            {
                break label0;
            }
            Iterator iterator = contentGroups.iterator();
            ContentGroup contentgroup;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                contentgroup = (ContentGroup)iterator.next();
            } while (contentgroup.contentSource != contentsourceenum);
            return contentgroup;
        }
        return null;
    }

}
