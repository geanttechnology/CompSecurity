.class public Lcom/amazon/mShop/control/item/ProductController;
.super Ljava/lang/Object;
.source "ProductController.java"

# interfaces
.implements Lcom/amazon/mShop/control/VariationsSelectionAdapter;
.implements Lcom/amazon/mShop/control/item/Product;
.implements Lcom/amazon/mShop/ui/ListingSelectionListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/control/item/ProductController$DealListener;,
        Lcom/amazon/mShop/control/item/ProductController$ProductListener;
    }
.end annotation


# static fields
.field public static final PRODUCT_KINDLE_GROUP_IDS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final PRODUCT_VIDEO_GROUP_IDS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private asin:Ljava/lang/String;

.field private basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

.field private basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

.field private blackCurtain:Ljava/lang/Boolean;

.field private final browser:Lcom/amazon/mShop/control/PagedListingBrowser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/control/PagedListingBrowser",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private clickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field private currentProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

.field private dealId:Ljava/lang/String;

.field private externalBuyLink:Lcom/amazon/rio/j2me/client/services/mShop/WebLink;

.field private extraProductInfo:Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

.field private image:[B

.field private imageUrl:Ljava/lang/String;

.field private isNoPrefetchChildren:Z

.field private isSimilarItemsEnabled:Z

.field private listId:Ljava/lang/String;

.field private listItemId:Ljava/lang/String;

.field private mDeal:Lcom/amazon/rio/j2me/client/services/mShop/Deal;

.field private mDealListener:Lcom/amazon/mShop/control/item/ProductController$DealListener;

.field private volatile mExcludeImages:Z

.field private mExtraOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

.field private mIsSelectedChild:Z

.field private mPendingDealId:Ljava/lang/String;

.field private mPendingDealType:Ljava/lang/String;

.field private mRequestId:Ljava/lang/String;

.field private mSimiliarItemsCount:I

.field private maxSwatchDimension:I

.field private merchantId:Ljava/lang/String;

.field private multiImages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;",
            ">;"
        }
    .end annotation
.end field

.field private final objectSubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

.field private offerId:Ljava/lang/String;

.field private pendingProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

.field private price:Ljava/lang/String;

.field private primeOneClickShippineOffers:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

.field private primeOneClickShippingOffersReceived:Z

.field private productSavings:Lcom/amazon/rio/j2me/client/services/mShop/Savings;

.field private selectedChild:Lcom/amazon/mShop/control/item/Variations$Child;

.field private final shareLinkByName:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/rio/j2me/client/services/mShop/WebLink;",
            ">;"
        }
    .end annotation
.end field

.field private shortDescription:Ljava/lang/String;

.field private showPriceClicked:Z

.field private subscribers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/control/item/ProductSubscriber;",
            ">;"
        }
    .end annotation
.end field

.field private thumbnail:[B

.field private title:Ljava/lang/String;

.field private variations:Lcom/amazon/mShop/control/item/Variations;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 1407
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lcom/amazon/mShop/control/item/ProductController;->PRODUCT_KINDLE_GROUP_IDS:Ljava/util/Set;

    .line 1409
    sget-object v0, Lcom/amazon/mShop/control/item/ProductController;->PRODUCT_KINDLE_GROUP_IDS:Ljava/util/Set;

    const-string/jumbo v1, "ebooks_display_on_website"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1410
    sget-object v0, Lcom/amazon/mShop/control/item/ProductController;->PRODUCT_KINDLE_GROUP_IDS:Ljava/util/Set;

    const-string/jumbo v1, "digitaltextfeeds_display_on_website"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1411
    sget-object v0, Lcom/amazon/mShop/control/item/ProductController;->PRODUCT_KINDLE_GROUP_IDS:Ljava/util/Set;

    const-string/jumbo v1, "digital_documents_display_on_website"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1413
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lcom/amazon/mShop/control/item/ProductController;->PRODUCT_VIDEO_GROUP_IDS:Ljava/util/Set;

    .line 1415
    sget-object v0, Lcom/amazon/mShop/control/item/ProductController;->PRODUCT_VIDEO_GROUP_IDS:Ljava/util/Set;

    const-string/jumbo v1, "download_tv_episode_display_on_website"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1416
    sget-object v0, Lcom/amazon/mShop/control/item/ProductController;->PRODUCT_VIDEO_GROUP_IDS:Ljava/util/Set;

    const-string/jumbo v1, "download_tv_season_display_on_website"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1417
    sget-object v0, Lcom/amazon/mShop/control/item/ProductController;->PRODUCT_VIDEO_GROUP_IDS:Ljava/util/Set;

    const-string/jumbo v1, "download_tv_series_display_on_website"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1418
    sget-object v0, Lcom/amazon/mShop/control/item/ProductController;->PRODUCT_VIDEO_GROUP_IDS:Ljava/util/Set;

    const-string/jumbo v1, "download_movie_display_on_website"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1419
    return-void
.end method

.method public constructor <init>(Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;)V
    .locals 2
    .param p1, "homeItem"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    .prologue
    const/4 v1, 0x0

    .line 92
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 245
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    .line 289
    iput-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController;->isSimilarItemsEnabled:Z

    .line 295
    iput-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController;->isNoPrefetchChildren:Z

    .line 301
    iput v1, p0, Lcom/amazon/mShop/control/item/ProductController;->maxSwatchDimension:I

    .line 406
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->shareLinkByName:Ljava/util/Map;

    .line 469
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->blackCurtain:Ljava/lang/Boolean;

    .line 479
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->multiImages:Ljava/util/List;

    .line 1594
    const/4 v0, 0x3

    iput v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mSimiliarItemsCount:I

    .line 1600
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mExcludeImages:Z

    .line 1800
    new-instance v0, Lcom/amazon/mShop/control/item/ProductController$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/control/item/ProductController$1;-><init>(Lcom/amazon/mShop/control/item/ProductController;)V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->objectSubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    .line 93
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    .line 94
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/ProductController;->updateWithObject(Ljava/lang/Object;)V

    .line 95
    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;)V
    .locals 2
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 130
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 245
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    .line 289
    iput-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController;->isSimilarItemsEnabled:Z

    .line 295
    iput-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController;->isNoPrefetchChildren:Z

    .line 301
    iput v1, p0, Lcom/amazon/mShop/control/item/ProductController;->maxSwatchDimension:I

    .line 406
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->shareLinkByName:Ljava/util/Map;

    .line 469
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->blackCurtain:Ljava/lang/Boolean;

    .line 479
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->multiImages:Ljava/util/List;

    .line 1594
    const/4 v0, 0x3

    iput v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mSimiliarItemsCount:I

    .line 1600
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mExcludeImages:Z

    .line 1800
    new-instance v0, Lcom/amazon/mShop/control/item/ProductController$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/control/item/ProductController$1;-><init>(Lcom/amazon/mShop/control/item/ProductController;)V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->objectSubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    .line 131
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    .line 132
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/ProductController;->updateWithObject(Ljava/lang/Object;)V

    .line 133
    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;Lcom/amazon/mShop/control/item/ClickStreamTag;)V
    .locals 2
    .param p1, "object"    # Ljava/lang/Object;
    .param p2, "clickStreamTag"    # Lcom/amazon/mShop/control/item/ClickStreamTag;

    .prologue
    const/4 v1, 0x0

    .line 135
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 245
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    .line 289
    iput-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController;->isSimilarItemsEnabled:Z

    .line 295
    iput-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController;->isNoPrefetchChildren:Z

    .line 301
    iput v1, p0, Lcom/amazon/mShop/control/item/ProductController;->maxSwatchDimension:I

    .line 406
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->shareLinkByName:Ljava/util/Map;

    .line 469
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->blackCurtain:Ljava/lang/Boolean;

    .line 479
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->multiImages:Ljava/util/List;

    .line 1594
    const/4 v0, 0x3

    iput v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mSimiliarItemsCount:I

    .line 1600
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mExcludeImages:Z

    .line 1800
    new-instance v0, Lcom/amazon/mShop/control/item/ProductController$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/control/item/ProductController$1;-><init>(Lcom/amazon/mShop/control/item/ProductController;)V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->objectSubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    .line 136
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    .line 137
    iput-object p2, p0, Lcom/amazon/mShop/control/item/ProductController;->clickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 138
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/ProductController;->updateWithObject(Ljava/lang/Object;)V

    .line 139
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;)V
    .locals 2
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "clickStreamTag"    # Lcom/amazon/mShop/control/item/ClickStreamTag;

    .prologue
    const/4 v1, 0x0

    .line 116
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 245
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    .line 289
    iput-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController;->isSimilarItemsEnabled:Z

    .line 295
    iput-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController;->isNoPrefetchChildren:Z

    .line 301
    iput v1, p0, Lcom/amazon/mShop/control/item/ProductController;->maxSwatchDimension:I

    .line 406
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->shareLinkByName:Ljava/util/Map;

    .line 469
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->blackCurtain:Ljava/lang/Boolean;

    .line 479
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->multiImages:Ljava/util/List;

    .line 1594
    const/4 v0, 0x3

    iput v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mSimiliarItemsCount:I

    .line 1600
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mExcludeImages:Z

    .line 1800
    new-instance v0, Lcom/amazon/mShop/control/item/ProductController$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/control/item/ProductController$1;-><init>(Lcom/amazon/mShop/control/item/ProductController;)V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->objectSubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    .line 117
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    .line 118
    iput-object p2, p0, Lcom/amazon/mShop/control/item/ProductController;->clickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 119
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->asin:Ljava/lang/String;

    .line 120
    return-void
.end method

.method static synthetic access$1000(Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p1, "x1"    # Ljava/lang/Exception;
    .param p2, "x2"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 75
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/control/item/ProductController;->notifyError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    return-void
.end method

.method static synthetic access$1100(Lcom/amazon/mShop/control/item/ProductController;)Lcom/amazon/mShop/control/item/Variations$Child;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->selectedChild:Lcom/amazon/mShop/control/item/Variations$Child;

    return-object v0
.end method

.method static synthetic access$1102(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/mShop/control/item/Variations$Child;)Lcom/amazon/mShop/control/item/Variations$Child;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p1, "x1"    # Lcom/amazon/mShop/control/item/Variations$Child;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->selectedChild:Lcom/amazon/mShop/control/item/Variations$Child;

    return-object p1
.end method

.method static synthetic access$1200(Lcom/amazon/mShop/control/item/ProductController;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mRequestId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    .prologue
    .line 75
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/ProductController;->setBasicProduct(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    return-void
.end method

.method static synthetic access$1500(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    .line 75
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/ProductController;->setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V

    return-void
.end method

.method static synthetic access$1600(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    .prologue
    .line 75
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/ProductController;->setPrimeOneClickShippingOffers(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;)V

    return-void
.end method

.method static synthetic access$1700(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

    .prologue
    .line 75
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/ProductController;->setExtraProduct(Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;)V

    return-void
.end method

.method static synthetic access$1800(Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 75
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->notifyCancelled()V

    return-void
.end method

.method static synthetic access$1900(Lcom/amazon/mShop/control/item/ProductController;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p1, "x1"    # Z

    .prologue
    .line 75
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/ProductController;->setPrimeOneClickShippineOffersReceived(Z)V

    return-void
.end method

.method static synthetic access$2202(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/mShop/control/item/Variations;)Lcom/amazon/mShop/control/item/Variations;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p1, "x1"    # Lcom/amazon/mShop/control/item/Variations;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->variations:Lcom/amazon/mShop/control/item/Variations;

    return-object p1
.end method

.method static synthetic access$2400(Lcom/amazon/mShop/control/item/ProductController;[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;)Lcom/amazon/mShop/control/item/Variations$Child;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p1, "x1"    # [Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    .param p2, "x2"    # [Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    .param p3, "x3"    # [Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    .prologue
    .line 75
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mShop/control/item/ProductController;->getPreselectedVariationChild([Lcom/amazon/rio/j2me/client/services/mShop/Dimension;[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;)Lcom/amazon/mShop/control/item/Variations$Child;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$2500(Lcom/amazon/mShop/control/item/ProductController;)Lcom/amazon/mShop/control/item/ProductController$DealListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mDealListener:Lcom/amazon/mShop/control/item/ProductController$DealListener;

    return-object v0
.end method

.method static synthetic access$2600(Lcom/amazon/mShop/control/item/ProductController;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mPendingDealId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2602(Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->mPendingDealId:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$2700(Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 75
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->clearMultiImages()V

    return-void
.end method

.method static synthetic access$2800(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;

    .prologue
    .line 75
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/ProductController;->setMultiImages(Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;)V

    return-void
.end method

.method static synthetic access$2900(Lcom/amazon/mShop/control/item/ProductController;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->shareLinkByName:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 75
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->notifyBrowserAvailableCountChanged()V

    return-void
.end method

.method static synthetic access$3002(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/WebLink;)Lcom/amazon/rio/j2me/client/services/mShop/WebLink;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/WebLink;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->externalBuyLink:Lcom/amazon/rio/j2me/client/services/mShop/WebLink;

    return-object p1
.end method

.method static synthetic access$3100(Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 75
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->notifyDealBlockUpdated()V

    return-void
.end method

.method static synthetic access$3600(Lcom/amazon/mShop/control/item/ProductController;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->asin:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/control/item/ProductController;)Lcom/amazon/mShop/control/PagedListingBrowser;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 75
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->notifyImageChanged()V

    return-void
.end method

.method static synthetic access$600(Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/Object;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p1, "x1"    # Ljava/lang/Object;

    .prologue
    .line 75
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/ProductController;->updateWithObject(Ljava/lang/Object;)V

    return-void
.end method

.method static synthetic access$700(Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 75
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->notifyProductUpdated()V

    return-void
.end method

.method static synthetic access$800(Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 75
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->notifyServiceCallComplete()V

    return-void
.end method

.method static synthetic access$900(Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 75
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->productRequestEnded()V

    return-void
.end method

.method private clearMultiImages()V
    .locals 1

    .prologue
    .line 490
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->multiImages:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 491
    return-void
.end method

.method private creatProductRequest()Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 1615
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;-><init>()V

    .line 1617
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->setAsin(Ljava/lang/String;)V

    .line 1621
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->offerId:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1622
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getOfferId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->setOfferId(Ljava/lang/String;)V

    .line 1625
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->selectedChild:Lcom/amazon/mShop/control/item/Variations$Child;

    if-eqz v1, :cond_6

    .line 1626
    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->setVariationChild(Z)V

    .line 1629
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->selectedChild:Lcom/amazon/mShop/control/item/Variations$Child;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/Variations$Child;->getImage()[B

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty([B)Z

    move-result v1

    if-eqz v1, :cond_1

    iget-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController;->mExcludeImages:Z

    if-eqz v1, :cond_2

    .line 1630
    :cond_1
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->setExcludeImage(Ljava/lang/Boolean;)V

    .line 1639
    :cond_2
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->clickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->setClickStreamOrigin(Ljava/lang/String;)V

    .line 1641
    iget-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController;->isSimilarItemsEnabled:Z

    if-eqz v1, :cond_3

    .line 1642
    iget v1, p0, Lcom/amazon/mShop/control/item/ProductController;->mSimiliarItemsCount:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->setSimsCount(Ljava/lang/Integer;)V

    .line 1645
    :cond_3
    iget-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController;->isNoPrefetchChildren:Z

    if-eqz v1, :cond_4

    .line 1646
    iget-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController;->isNoPrefetchChildren:Z

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->setNoPrefetchChildren(Ljava/lang/Boolean;)V

    .line 1647
    :cond_4
    iget v1, p0, Lcom/amazon/mShop/control/item/ProductController;->maxSwatchDimension:I

    if-lez v1, :cond_5

    .line 1648
    iget v1, p0, Lcom/amazon/mShop/control/item/ProductController;->maxSwatchDimension:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->setMaxSwatchDimension(Ljava/lang/Integer;)V

    .line 1650
    :cond_5
    iget-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController;->mExcludeImages:Z

    if-eqz v1, :cond_8

    .line 1651
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->setExcludeImage(Ljava/lang/Boolean;)V

    .line 1652
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->setMaxImageDimension(I)V

    .line 1657
    :goto_1
    return-object v0

    .line 1633
    :cond_6
    iget-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController;->mIsSelectedChild:Z

    if-eqz v1, :cond_7

    .line 1634
    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->setVariationChild(Z)V

    goto :goto_0

    .line 1635
    :cond_7
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->isPreselectedByCustomer()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1636
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->setVariationsModelOverride(Ljava/lang/Integer;)V

    goto :goto_0

    .line 1654
    :cond_8
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getMaxImageDimension()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->setMaxImageDimension(I)V

    goto :goto_1
.end method

.method private deleteExtraProduct()V
    .locals 1

    .prologue
    .line 599
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->extraProductInfo:Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

    .line 600
    return-void
.end method

.method public static getAmazonPoints(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Ljava/lang/String;
    .locals 1
    .param p0, "offer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    .line 967
    if-eqz p0, :cond_0

    .line 968
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPoints()Ljava/lang/String;

    move-result-object v0

    .line 970
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getOfferShippingPrice(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;)Ljava/lang/String;
    .locals 2
    .param p0, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .param p1, "extraOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    .prologue
    .line 846
    invoke-static {p0}, Lcom/amazon/mShop/control/item/ProductController;->isEligibleForPrimeShipping(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z

    move-result v1

    if-nez v1, :cond_1

    invoke-static {p0}, Lcom/amazon/mShop/control/item/ProductController;->isEligibleForPrimePlusShipping(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z

    move-result v1

    if-nez v1, :cond_1

    invoke-static {p0}, Lcom/amazon/mShop/control/item/ProductController;->isEligibleForAddOnItem(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z

    move-result v1

    if-nez v1, :cond_1

    invoke-static {p0}, Lcom/amazon/mShop/control/item/ProductController;->isEligibleForSuperSaverShipping(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 848
    if-eqz p1, :cond_0

    .line 849
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->getShippingCharge()Ljava/lang/String;

    move-result-object v1

    .line 860
    :goto_0
    return-object v1

    .line 852
    :cond_0
    if-eqz p0, :cond_1

    .line 853
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getShippingOffer()Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    move-result-object v0

    .line 854
    .local v0, "shippingOffer":Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    if-eqz v0, :cond_1

    .line 855
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->getPrice()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 860
    .end local v0    # "shippingOffer":Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private getPreselectedVariationChild([Lcom/amazon/rio/j2me/client/services/mShop/Dimension;[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;)Lcom/amazon/mShop/control/item/Variations$Child;
    .locals 3
    .param p1, "dimensions"    # [Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    .param p2, "variationProductInfos"    # [Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    .param p3, "visualBuckets"    # [Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    .prologue
    .line 1233
    const/4 v0, 0x0

    .line 1234
    .local v0, "child":Lcom/amazon/mShop/control/item/Variations$Child;
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/ProductController;->isAllDimensionsPreselected([Lcom/amazon/rio/j2me/client/services/mShop/Dimension;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->isPreselectedByCustomer()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1236
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->variations:Lcom/amazon/mShop/control/item/Variations;

    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/control/item/Variations;->getChildWithAsin(Ljava/lang/String;)Lcom/amazon/mShop/control/item/Variations$Child;

    move-result-object v0

    .line 1241
    :cond_1
    :goto_0
    return-object v0

    .line 1237
    :cond_2
    const/4 v1, 0x1

    array-length v2, p2

    if-ne v1, v2, :cond_1

    .line 1239
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->variations:Lcom/amazon/mShop/control/item/Variations;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/Variations;->getChildren()[Lcom/amazon/mShop/control/item/Variations$Child;

    move-result-object v1

    const/4 v2, 0x0

    aget-object v0, v1, v2

    goto :goto_0
.end method

.method private getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 376
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->price:Ljava/lang/String;

    return-object v0
.end method

.method public static getPriceToDisplay(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Ljava/lang/String;
    .locals 2
    .param p0, "basicProduct"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    .param p1, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    const/4 v0, 0x0

    .line 947
    if-eqz p1, :cond_1

    .line 948
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPriceViolatesMap()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 963
    :cond_0
    :goto_0
    return-object v0

    .line 954
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getVariationPriceRange()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 955
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getVariationPriceRange()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 959
    :cond_2
    if-eqz p1, :cond_0

    .line 960
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPrice()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getUsedAndNewOfferSummaryCount(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)I
    .locals 2
    .param p0, "basicProduct"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    .prologue
    const/4 v1, 0x0

    .line 691
    if-nez p0, :cond_1

    .line 698
    :cond_0
    :goto_0
    return v1

    .line 694
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getUsedAndNewSummary()Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    move-result-object v0

    .line 695
    .local v0, "offerSummary":Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    if-eqz v0, :cond_0

    .line 698
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;->getCount()I

    move-result v1

    goto :goto_0
.end method

.method public static hasMarketPlaceOffers(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z
    .locals 3
    .param p0, "basicProduct"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    .param p1, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 659
    invoke-static {p0}, Lcom/amazon/mShop/control/item/ProductController;->getUsedAndNewOfferSummaryCount(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)I

    move-result v0

    .line 660
    .local v0, "count":I
    if-nez v0, :cond_1

    .line 666
    :cond_0
    :goto_0
    return v1

    .line 663
    :cond_1
    if-ne v2, v0, :cond_2

    if-nez p1, :cond_0

    :cond_2
    move v1, v2

    .line 666
    goto :goto_0
.end method

.method private isAllDimensionsPreselected([Lcom/amazon/rio/j2me/client/services/mShop/Dimension;)Z
    .locals 3
    .param p1, "dimensions"    # [Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    .prologue
    const/4 v1, 0x0

    .line 1283
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1291
    :cond_0
    :goto_0
    return v1

    .line 1286
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v2, p1

    if-ge v0, v2, :cond_2

    .line 1287
    aget-object v2, p1, v0

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;->getPreselect()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1286
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1291
    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public static isAudiobook(Ljava/lang/String;)Z
    .locals 1
    .param p0, "groupId"    # Ljava/lang/String;

    .prologue
    .line 1438
    const-string/jumbo v0, "audible_display_on_website"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isEligibleForAddOnItem(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z
    .locals 4
    .param p0, "basicOfferListing"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    const/4 v1, 0x0

    .line 755
    if-nez p0, :cond_1

    .line 760
    :cond_0
    :goto_0
    return v1

    .line 759
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v0

    .line 760
    .local v0, "badgeInfo":Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getType()Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/ui/resources/BadgeType;->ADD_ON:Lcom/amazon/mShop/ui/resources/BadgeType;

    invoke-virtual {v3}, Lcom/amazon/mShop/ui/resources/BadgeType;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method

.method public static isEligibleForPrimePlusShipping(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z
    .locals 5
    .param p0, "basicOfferListing"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    const/4 v2, 0x0

    .line 767
    if-nez p0, :cond_1

    .line 776
    :cond_0
    :goto_0
    return v2

    .line 771
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v0

    .line 772
    .local v0, "badgeInfo":Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getType()Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/ui/resources/BadgeType;->PRIME_PLUS:Lcom/amazon/mShop/ui/resources/BadgeType;

    invoke-virtual {v4}, Lcom/amazon/mShop/ui/resources/BadgeType;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 773
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v1

    .line 774
    .local v1, "user":Lcom/amazon/mShop/model/auth/User;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/amazon/mShop/model/auth/User;->isPrime()Z

    move-result v3

    if-eqz v3, :cond_0

    const/4 v2, 0x1

    goto :goto_0
.end method

.method public static isEligibleForPrimeShipping(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z
    .locals 5
    .param p0, "basicOfferListing"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    const/4 v2, 0x0

    .line 797
    if-nez p0, :cond_1

    .line 806
    :cond_0
    :goto_0
    return v2

    .line 801
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v0

    .line 802
    .local v0, "badgeInfo":Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getType()Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/ui/resources/BadgeType;->PRIME:Lcom/amazon/mShop/ui/resources/BadgeType;

    invoke-virtual {v4}, Lcom/amazon/mShop/ui/resources/BadgeType;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 803
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v1

    .line 804
    .local v1, "user":Lcom/amazon/mShop/model/auth/User;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/amazon/mShop/model/auth/User;->isPrime()Z

    move-result v3

    if-eqz v3, :cond_0

    const/4 v2, 0x1

    goto :goto_0
.end method

.method public static isEligibleForSuperSaverShipping(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z
    .locals 3
    .param p0, "basicOfferListing"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    const/4 v1, 0x0

    .line 821
    if-nez p0, :cond_1

    .line 830
    :cond_0
    :goto_0
    return v1

    .line 825
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getEligibleForSuperSaverShipping()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 829
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v0

    .line 830
    .local v0, "user":Lcom/amazon/mShop/model/auth/User;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/amazon/mShop/model/auth/User;->isPrime()Z

    move-result v2

    if-nez v2, :cond_0

    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public static isKindleBook(Ljava/lang/String;)Z
    .locals 1
    .param p0, "groupId"    # Ljava/lang/String;

    .prologue
    .line 1430
    sget-object v0, Lcom/amazon/mShop/control/item/ProductController;->PRODUCT_KINDLE_GROUP_IDS:Ljava/util/Set;

    invoke-interface {v0, p0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isMobileApp(Ljava/lang/String;)Z
    .locals 1
    .param p0, "groupId"    # Ljava/lang/String;

    .prologue
    .line 1423
    const-string/jumbo v0, "mobile_application_display_on_website"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1424
    const/4 v0, 0x1

    .line 1426
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isMusic(Ljava/lang/String;)Z
    .locals 2
    .param p0, "groupId"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x1

    .line 1442
    const-string/jumbo v1, "digital_music_track_display_on_website"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1449
    :cond_0
    :goto_0
    return v0

    .line 1444
    :cond_1
    const-string/jumbo v1, "digital_music_album_display_on_website"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1446
    const-string/jumbo v1, "digital_music_artist_display_on_website"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1449
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isPreselectedByCustomer()Z
    .locals 2

    .prologue
    .line 1250
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getClickStreamTag()Lcom/amazon/mShop/control/item/ClickStreamTag;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v0

    .line 1251
    .local v0, "tag":Ljava/lang/String;
    sget-object v1, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_CART:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_WISHLIST:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_ORDER:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1252
    :cond_0
    const/4 v1, 0x1

    .line 1254
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static isVideo(Ljava/lang/String;)Z
    .locals 1
    .param p0, "groupId"    # Ljava/lang/String;

    .prologue
    .line 1434
    sget-object v0, Lcom/amazon/mShop/control/item/ProductController;->PRODUCT_VIDEO_GROUP_IDS:Ljava/util/Set;

    invoke-interface {v0, p0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private notifyBrowserAvailableCountChanged()V
    .locals 4

    .prologue
    .line 1700
    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 1701
    .local v2, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/item/ProductSubscriber;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/control/item/ProductSubscriber;

    .line 1702
    .local v1, "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    invoke-interface {v1}, Lcom/amazon/mShop/control/item/ProductSubscriber;->onBrowserAvailableCountChanged()V

    goto :goto_0

    .line 1704
    .end local v1    # "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    :cond_0
    return-void
.end method

.method private notifyCancelled()V
    .locals 4

    .prologue
    .line 1765
    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 1766
    .local v2, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/item/ProductSubscriber;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/control/item/ProductSubscriber;

    .line 1767
    .local v1, "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    invoke-interface {v1}, Lcom/amazon/mShop/control/item/ProductSubscriber;->onCancelled()V

    goto :goto_0

    .line 1770
    .end local v1    # "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->productRequestEnded()V

    .line 1771
    return-void
.end method

.method private notifyDealBlockUpdated()V
    .locals 4

    .prologue
    .line 1744
    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 1745
    .local v2, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/item/ProductSubscriber;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/control/item/ProductSubscriber;

    .line 1746
    .local v1, "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    invoke-interface {v1}, Lcom/amazon/mShop/control/item/ProductSubscriber;->onDealBlockUpdated()V

    goto :goto_0

    .line 1748
    .end local v1    # "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    :cond_0
    return-void
.end method

.method private notifyError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 4
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    const/4 v1, 0x1

    .line 1779
    iget-object v3, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-lt v3, v1, :cond_0

    .line 1780
    .local v1, "size":I
    :goto_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-ge v0, v1, :cond_1

    .line 1781
    iget-object v3, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/control/item/ProductSubscriber;

    .line 1782
    .local v2, "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    invoke-interface {v2, p1, p2}, Lcom/amazon/mShop/control/item/ProductSubscriber;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 1780
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1779
    .end local v0    # "i":I
    .end local v1    # "size":I
    .end local v2    # "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 1785
    .restart local v0    # "i":I
    .restart local v1    # "size":I
    :cond_1
    return-void
.end method

.method private notifyImageChanged()V
    .locals 4

    .prologue
    .line 1733
    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 1734
    .local v2, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/item/ProductSubscriber;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/control/item/ProductSubscriber;

    .line 1735
    .local v1, "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    invoke-interface {v1}, Lcom/amazon/mShop/control/item/ProductSubscriber;->onImageChanged()V

    goto :goto_0

    .line 1737
    .end local v1    # "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    :cond_0
    return-void
.end method

.method private notifyPriceUpdated()V
    .locals 4

    .prologue
    .line 1722
    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 1723
    .local v2, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/item/ProductSubscriber;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/control/item/ProductSubscriber;

    .line 1724
    .local v1, "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    invoke-interface {v1}, Lcom/amazon/mShop/control/item/ProductSubscriber;->onPriceBlockUpdated()V

    goto :goto_0

    .line 1726
    .end local v1    # "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    :cond_0
    return-void
.end method

.method private notifyProductUpdated()V
    .locals 4

    .prologue
    .line 1711
    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 1712
    .local v2, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/item/ProductSubscriber;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/control/item/ProductSubscriber;

    .line 1713
    .local v1, "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    invoke-interface {v1}, Lcom/amazon/mShop/control/item/ProductSubscriber;->onProductUpdated()V

    goto :goto_0

    .line 1715
    .end local v1    # "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    :cond_0
    return-void
.end method

.method private notifyServiceCallComplete()V
    .locals 4

    .prologue
    .line 1791
    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 1792
    .local v2, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/item/ProductSubscriber;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/control/item/ProductSubscriber;

    .line 1793
    .local v1, "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    invoke-interface {v1}, Lcom/amazon/mShop/control/item/ProductSubscriber;->onServiceCallComplete()V

    goto :goto_0

    .line 1795
    .end local v1    # "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    :cond_0
    return-void
.end method

.method private notifySimilarItemsGalleryUpdated()V
    .locals 4

    .prologue
    .line 1755
    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 1756
    .local v2, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/item/ProductSubscriber;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/control/item/ProductSubscriber;

    .line 1757
    .local v1, "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    invoke-interface {v1}, Lcom/amazon/mShop/control/item/ProductSubscriber;->onSimilarItemsGalleryUpdated()V

    goto :goto_0

    .line 1759
    .end local v1    # "subscriber":Lcom/amazon/mShop/control/item/ProductSubscriber;
    :cond_0
    return-void
.end method

.method private productRequestEnded()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1665
    iput-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->currentProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    .line 1666
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->pendingProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1667
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->pendingProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->currentProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    .line 1668
    iput-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->pendingProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    .line 1669
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->currentProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->creatProductRequest()Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;

    move-result-object v1

    # invokes: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->start(Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$200(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;)V

    .line 1672
    :cond_0
    return-void
.end method

.method private reset()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 1512
    invoke-direct {p0, v0}, Lcom/amazon/mShop/control/item/ProductController;->setAsin(Ljava/lang/String;)V

    .line 1513
    invoke-direct {p0, v0}, Lcom/amazon/mShop/control/item/ProductController;->setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V

    .line 1514
    invoke-direct {p0, v0}, Lcom/amazon/mShop/control/item/ProductController;->setBasicProduct(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    .line 1515
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/control/item/ProductController;->setEncodedLargeImage([B)V

    .line 1516
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->deleteExtraProduct()V

    .line 1517
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/control/item/ProductController;->setOfferId(Ljava/lang/String;)V

    .line 1518
    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->price:Ljava/lang/String;

    .line 1519
    invoke-direct {p0, v0}, Lcom/amazon/mShop/control/item/ProductController;->setPrimeOneClickShippingOffers(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;)V

    .line 1520
    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->selectedChild:Lcom/amazon/mShop/control/item/Variations$Child;

    .line 1521
    iput-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController;->mIsSelectedChild:Z

    .line 1522
    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->shortDescription:Ljava/lang/String;

    .line 1523
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/control/item/ProductController;->setShowPriceClicked(Z)V

    .line 1524
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/control/item/ProductController;->setThumbnail([B)V

    .line 1525
    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->title:Ljava/lang/String;

    .line 1526
    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->variations:Lcom/amazon/mShop/control/item/Variations;

    .line 1527
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/control/item/ProductController;->setDealId(Ljava/lang/String;)V

    .line 1528
    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mExtraOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    .line 1529
    return-void
.end method

.method private setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 340
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->asin:Ljava/lang/String;

    .line 341
    return-void
.end method

.method private setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V
    .locals 1
    .param p1, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    const/4 v0, 0x0

    .line 459
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .line 460
    if-eqz p1, :cond_0

    .line 461
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPrice()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->price:Ljava/lang/String;

    .line 462
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getOfferId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->offerId:Ljava/lang/String;

    .line 467
    :goto_0
    return-void

    .line 464
    :cond_0
    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->price:Ljava/lang/String;

    .line 465
    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->offerId:Ljava/lang/String;

    goto :goto_0
.end method

.method private setBasicProduct(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V
    .locals 1
    .param p1, "basicProduct"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    .prologue
    const/4 v0, 0x0

    .line 433
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    .line 434
    if-eqz p1, :cond_2

    .line 435
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getTitle()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->title:Ljava/lang/String;

    .line 436
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->asin:Ljava/lang/String;

    .line 437
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getShortDescription()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->shortDescription:Ljava/lang/String;

    .line 438
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getBlackCurtain()Ljava/lang/Boolean;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 439
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getBlackCurtain()Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->blackCurtain:Ljava/lang/Boolean;

    .line 441
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 442
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/control/item/ProductController;->setImageUrl(Ljava/lang/String;)V

    .line 449
    :cond_1
    :goto_0
    return-void

    .line 444
    :cond_2
    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->title:Ljava/lang/String;

    .line 445
    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->asin:Ljava/lang/String;

    .line 446
    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->shortDescription:Ljava/lang/String;

    .line 447
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->blackCurtain:Ljava/lang/Boolean;

    goto :goto_0
.end method

.method private setExtraProduct(Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;)V
    .locals 0
    .param p1, "from"    # Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

    .prologue
    .line 592
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->extraProductInfo:Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

    .line 593
    return-void
.end method

.method private setImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 506
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->imageUrl:Ljava/lang/String;

    .line 507
    return-void
.end method

.method private setMultiImages(Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;)V
    .locals 1
    .param p1, "multiImage"    # Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;

    .prologue
    .line 486
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->multiImages:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 487
    return-void
.end method

.method private setPrimeOneClickShippineOffersReceived(Z)V
    .locals 0
    .param p1, "received"    # Z

    .prologue
    .line 1166
    iput-boolean p1, p0, Lcom/amazon/mShop/control/item/ProductController;->primeOneClickShippingOffersReceived:Z

    .line 1167
    return-void
.end method

.method private setPrimeOneClickShippingOffers(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;)V
    .locals 1
    .param p1, "offers"    # Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    .prologue
    .line 1161
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->primeOneClickShippineOffers:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    .line 1162
    if-eqz p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/amazon/mShop/control/item/ProductController;->primeOneClickShippingOffersReceived:Z

    .line 1163
    return-void

    .line 1162
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private startProductRequest()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1564
    new-instance v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    invoke-direct {v0, p0, v2}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;-><init>(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/mShop/control/item/ProductController$1;)V

    .line 1565
    .local v0, "newProductRequestListener":Lcom/amazon/mShop/control/item/ProductController$ProductListener;
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_0

    .line 1567
    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->pendingProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    .line 1578
    :goto_0
    return-void

    .line 1568
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->currentProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    if-eqz v1, :cond_1

    .line 1570
    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->pendingProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    .line 1571
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->currentProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # invokes: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->cancel()V
    invoke-static {v1}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$000(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)V

    goto :goto_0

    .line 1573
    :cond_1
    iput-object v2, p0, Lcom/amazon/mShop/control/item/ProductController;->pendingProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    .line 1574
    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->currentProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    .line 1575
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->currentProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->creatProductRequest()Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;

    move-result-object v2

    # invokes: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->start(Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;)V
    invoke-static {v1, v2}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$200(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;)V

    goto :goto_0
.end method

.method private updateWithObject(Ljava/lang/Object;)V
    .locals 6
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v5, 0x0

    .line 182
    instance-of v4, p1, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    if-eqz v4, :cond_3

    move-object v3, p1

    .line 183
    check-cast v3, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 184
    .local v3, "r":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/amazon/mShop/control/item/ProductController;->setBasicProduct(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    .line 185
    iget-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->blackCurtain:Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 186
    invoke-direct {p0, v5}, Lcom/amazon/mShop/control/item/ProductController;->setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V

    .line 190
    :goto_0
    iget-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->clickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->clickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 191
    :cond_0
    sget-object v4, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->clickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 240
    .end local v3    # "r":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    :cond_1
    :goto_1
    return-void

    .line 188
    .restart local v3    # "r":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    :cond_2
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/amazon/mShop/control/item/ProductController;->setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V

    goto :goto_0

    .line 193
    .end local v3    # "r":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    :cond_3
    instance-of v4, p1, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    if-eqz v4, :cond_6

    move-object v1, p1

    .line 194
    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    .line 195
    .local v1, "item":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v4

    if-eqz v4, :cond_4

    .line 196
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/amazon/mShop/control/item/ProductController;->setBasicProduct(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    .line 200
    :goto_2
    iget-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->blackCurtain:Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 201
    invoke-direct {p0, v5}, Lcom/amazon/mShop/control/item/ProductController;->setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V

    .line 205
    :goto_3
    sget-object v4, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_HOME:Lcom/amazon/mShop/control/item/ClickStreamTag;

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->clickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

    goto :goto_1

    .line 198
    :cond_4
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getAsin()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->asin:Ljava/lang/String;

    goto :goto_2

    .line 203
    :cond_5
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/amazon/mShop/control/item/ProductController;->setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V

    goto :goto_3

    .line 206
    .end local v1    # "item":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    :cond_6
    instance-of v4, p1, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;

    if-eqz v4, :cond_7

    move-object v1, p1

    .line 207
    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;

    .line 208
    .local v1, "item":Lcom/amazon/rio/j2me/client/services/mShop/CartItem;
    invoke-direct {p0, v5}, Lcom/amazon/mShop/control/item/ProductController;->setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V

    .line 209
    invoke-direct {p0, v5}, Lcom/amazon/mShop/control/item/ProductController;->setBasicProduct(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    .line 210
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getAsin()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->asin:Ljava/lang/String;

    .line 211
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getOfferId()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->offerId:Ljava/lang/String;

    .line 212
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getPrice()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->price:Ljava/lang/String;

    .line 213
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->title:Ljava/lang/String;

    .line 214
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getShortDescription()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->shortDescription:Ljava/lang/String;

    .line 215
    sget-object v4, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_CART:Lcom/amazon/mShop/control/item/ClickStreamTag;

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->clickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 216
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getMerchantInfo()Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

    move-result-object v2

    .line 217
    .local v2, "merchantInfo":Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;
    if-eqz v2, :cond_1

    .line 218
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->getMerchantId()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->merchantId:Ljava/lang/String;

    goto :goto_1

    .line 225
    .end local v1    # "item":Lcom/amazon/rio/j2me/client/services/mShop/CartItem;
    .end local v2    # "merchantInfo":Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;
    :cond_7
    instance-of v4, p1, Lcom/amazon/rio/j2me/client/services/mShop/Deal;

    if-eqz v4, :cond_1

    move-object v0, p1

    .line 226
    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;

    .line 227
    .local v0, "deal":Lcom/amazon/rio/j2me/client/services/mShop/Deal;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->getAsin()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->asin:Ljava/lang/String;

    .line 228
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->getTitle()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->title:Ljava/lang/String;

    .line 229
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->getOfferId()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->offerId:Ljava/lang/String;

    .line 230
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->getSavings()Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    move-result-object v4

    if-eqz v4, :cond_8

    .line 231
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->getSavings()Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->getPrePromoPrice()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->price:Ljava/lang/String;

    .line 233
    :cond_8
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->getDealId()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->mPendingDealId:Ljava/lang/String;

    .line 236
    iget-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->mPendingDealId:Ljava/lang/String;

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/control/item/ProductController;->requestDeal(Ljava/lang/String;)V

    .line 237
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->getImage()[B

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/control/item/ProductController;->setThumbnail([B)V

    .line 238
    sget-object v4, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_DEAL:Lcom/amazon/mShop/control/item/ClickStreamTag;

    iput-object v4, p0, Lcom/amazon/mShop/control/item/ProductController;->clickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

    goto/16 :goto_1
.end method


# virtual methods
.method public addSubscriber(Lcom/amazon/mShop/control/item/ProductSubscriber;)V
    .locals 1
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/item/ProductSubscriber;

    .prologue
    .line 254
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 255
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 260
    :cond_0
    return-void
.end method

.method public clearSelectedChild()V
    .locals 1

    .prologue
    .line 1270
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->selectedChild:Lcom/amazon/mShop/control/item/Variations$Child;

    .line 1271
    return-void
.end method

.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 344
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .locals 1

    .prologue
    .line 455
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    return-object v0
.end method

.method public getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    .locals 1

    .prologue
    .line 429
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    return-object v0
.end method

.method public getClickStreamTag()Lcom/amazon/mShop/control/item/ClickStreamTag;
    .locals 1

    .prologue
    .line 317
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->clickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

    return-object v0
.end method

.method public getConditionalOffersSummary(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    .locals 3
    .param p1, "condition"    # Ljava/lang/String;

    .prologue
    .line 716
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getConditionalOffersSummaryList()[Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;

    move-result-object v1

    .line 717
    .local v1, "summaries":[Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    if-eqz v1, :cond_1

    .line 718
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, v1

    if-ge v0, v2, :cond_1

    .line 719
    aget-object v2, v1, v0

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;->getCondition()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 720
    aget-object v2, v1, v0

    .line 724
    .end local v0    # "i":I
    :goto_1
    return-object v2

    .line 718
    .restart local v0    # "i":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 724
    .end local v0    # "i":I
    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public getConditionalOffersSummaryList()[Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    .locals 3

    .prologue
    .line 705
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getExtraProduct()Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

    move-result-object v0

    .line 706
    .local v0, "extraProduct":Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;
    if-eqz v0, :cond_0

    .line 707
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->getOfferListSummaries()Ljava/util/List;

    move-result-object v1

    .line 708
    .local v1, "summaries":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;>;"
    if-eqz v1, :cond_0

    .line 709
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    new-array v2, v2, [Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;

    invoke-interface {v1, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;

    .line 712
    .end local v1    # "summaries":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;>;"
    :goto_0
    return-object v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getDealId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1172
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->dealId:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayPrice()Ljava/lang/String;
    .locals 2

    .prologue
    .line 916
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->isPriceHidden()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 917
    const/4 v0, 0x0

    .line 932
    :cond_0
    :goto_0
    return-object v0

    .line 920
    :cond_1
    const/4 v0, 0x0

    .line 921
    .local v0, "displayPrice":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->mustSelectVariationChild()Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    if-eqz v1, :cond_2

    .line 922
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getVariationPriceRange()Ljava/lang/String;

    move-result-object v0

    .line 925
    :cond_2
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getProductSavings()Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    move-result-object v1

    if-eqz v1, :cond_3

    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getProductSavings()Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->getPromoPrice()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 927
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getProductSavings()Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->getPromoPrice()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 928
    :cond_3
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 929
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->getPrice()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getEncodedLargeImage()[B
    .locals 1

    .prologue
    .line 496
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->image:[B

    return-object v0
.end method

.method public getExternalBuyLink()Lcom/amazon/rio/j2me/client/services/mShop/WebLink;
    .locals 1

    .prologue
    .line 415
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->externalBuyLink:Lcom/amazon/rio/j2me/client/services/mShop/WebLink;

    return-object v0
.end method

.method public getExtraOfferListing()Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;
    .locals 1

    .prologue
    .line 605
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mExtraOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    return-object v0
.end method

.method public getExtraProduct()Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;
    .locals 1

    .prologue
    .line 584
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->extraProductInfo:Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

    return-object v0
.end method

.method public getGroupId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1482
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    if-eqz v0, :cond_0

    .line 1483
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getProductGroupId()Ljava/lang/String;

    move-result-object v0

    .line 1485
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getImage()[B
    .locals 2

    .prologue
    .line 531
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getEncodedLargeImage()[B

    move-result-object v0

    .line 532
    .local v0, "encodedImage":[B
    if-eqz v0, :cond_0

    array-length v1, v0

    if-nez v1, :cond_1

    .line 533
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getThumbnail()[B

    move-result-object v0

    .line 535
    :cond_1
    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 510
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->imageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getListId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 398
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->listId:Ljava/lang/String;

    return-object v0
.end method

.method public getListItemId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 388
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->listItemId:Ljava/lang/String;

    return-object v0
.end method

.method public getMaxImageDimension()I
    .locals 2

    .prologue
    .line 1587
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getResources()Lcom/amazon/mShop/platform/Resources;

    move-result-object v0

    .line 1588
    .local v0, "res":Lcom/amazon/mShop/platform/Resources;
    const/16 v1, 0xb

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Resources;->getDimensionPixelSize(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    return v1
.end method

.method public getMerchantId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 364
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->merchantId:Ljava/lang/String;

    return-object v0
.end method

.method public getMultiImages()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;",
            ">;"
        }
    .end annotation

    .prologue
    .line 482
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->multiImages:Ljava/util/List;

    return-object v0
.end method

.method public getOfferId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 354
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->offerId:Ljava/lang/String;

    return-object v0
.end method

.method public getPendingDealId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1191
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mPendingDealId:Ljava/lang/String;

    return-object v0
.end method

.method public getPendingDealType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1212
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mPendingDealType:Ljava/lang/String;

    return-object v0
.end method

.method public getPrimeOneClickShippingOffers()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;
    .locals 1

    .prologue
    .line 1150
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->primeOneClickShippineOffers:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    return-object v0
.end method

.method public getPrimeOneClickShippingOffersReceived()Z
    .locals 1

    .prologue
    .line 1157
    iget-boolean v0, p0, Lcom/amazon/mShop/control/item/ProductController;->primeOneClickShippingOffersReceived:Z

    return v0
.end method

.method public getProductSavings()Lcom/amazon/rio/j2me/client/services/mShop/Savings;
    .locals 1

    .prologue
    .line 1218
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->productSavings:Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    return-object v0
.end method

.method public getRequestId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 334
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mRequestId:Ljava/lang/String;

    return-object v0
.end method

.method public getSelectedVariationChild()Lcom/amazon/mShop/control/item/Variations$Child;
    .locals 1

    .prologue
    .line 1354
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->selectedChild:Lcom/amazon/mShop/control/item/Variations$Child;

    return-object v0
.end method

.method public getThumbnail()[B
    .locals 1

    .prologue
    .line 516
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->getCurrentImage()[B

    move-result-object v0

    if-eqz v0, :cond_0

    .line 517
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->getCurrentImage()[B

    move-result-object v0

    .line 519
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->thumbnail:[B

    goto :goto_0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 370
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getVariations()Lcom/amazon/mShop/control/item/Variations;
    .locals 1

    .prologue
    .line 1229
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->variations:Lcom/amazon/mShop/control/item/Variations;

    return-object v0
.end method

.method public hasExternalBuyLink()Z
    .locals 1

    .prologue
    .line 419
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->externalBuyLink:Lcom/amazon/rio/j2me/client/services/mShop/WebLink;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->externalBuyLink:Lcom/amazon/rio/j2me/client/services/mShop/WebLink;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/WebLink;->getLinkUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasMarketPlaceOffers()Z
    .locals 3

    .prologue
    .line 643
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    iget-object v2, p0, Lcom/amazon/mShop/control/item/ProductController;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    invoke-static {v1, v2}, Lcom/amazon/mShop/control/item/ProductController;->hasMarketPlaceOffers(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 644
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getConditionalOffersSummaryList()[Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;

    move-result-object v0

    .line 645
    .local v0, "summaries":[Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    if-eqz v0, :cond_0

    array-length v1, v0

    if-lez v1, :cond_0

    .line 646
    const/4 v1, 0x1

    .line 649
    .end local v0    # "summaries":[Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isAudiobook()Z
    .locals 1

    .prologue
    .line 1478
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getGroupId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->isAudiobook(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public isAvailableFromThirdPartiesOnly()Z
    .locals 1

    .prologue
    .line 731
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getOfferId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->hasMarketPlaceOffers()Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isKindleBook()Z
    .locals 1

    .prologue
    .line 1462
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getGroupId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->isKindleBook(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public isMobileApp()Z
    .locals 1

    .prologue
    .line 1458
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getGroupId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->isMobileApp(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public isMusic()Z
    .locals 1

    .prologue
    .line 1470
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getGroupId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->isMusic(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public isPriceHidden()Z
    .locals 1

    .prologue
    .line 625
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPriceViolatesMap()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/control/item/ProductController;->showPriceClicked:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isProductWithVariations()Z
    .locals 1

    .prologue
    .line 1372
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getVariationParentAsin()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isVideo()Z
    .locals 1

    .prologue
    .line 1466
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getGroupId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->isVideo(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public mustSelectVariationChild()Z
    .locals 1

    .prologue
    .line 1361
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->selectedChild:Lcom/amazon/mShop/control/item/Variations$Child;

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mIsSelectedChild:Z

    if-eqz v0, :cond_1

    .line 1362
    :cond_0
    const/4 v0, 0x0

    .line 1365
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->isProductWithVariations()Z

    move-result v0

    goto :goto_0
.end method

.method public removeSubscriber(Lcom/amazon/mShop/control/item/ProductSubscriber;)V
    .locals 2
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/item/ProductSubscriber;

    .prologue
    const/4 v1, 0x0

    .line 274
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 276
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_2

    .line 277
    iput-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->pendingProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    .line 278
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->currentProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    if-eqz v0, :cond_1

    .line 279
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->currentProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # invokes: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->cancel()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$000(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)V

    .line 281
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    if-eqz v0, :cond_2

    .line 282
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->setSecondarySubscriber(Lcom/amazon/mShop/control/ObjectSubscriber;)V

    .line 283
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->setSelectionListener(Lcom/amazon/mShop/ui/ListingSelectionListener;)V

    .line 286
    :cond_2
    return-void
.end method

.method public replayProductRequest()V
    .locals 1

    .prologue
    .line 1581
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->currentProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    if-eqz v0, :cond_0

    .line 1582
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->currentProductRequestListener:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->replay()V

    .line 1584
    :cond_0
    return-void
.end method

.method public requestDeal(Ljava/lang/String;)V
    .locals 2
    .param p1, "dealId"    # Ljava/lang/String;

    .prologue
    .line 2394
    if-eqz p1, :cond_1

    .line 2395
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mDealListener:Lcom/amazon/mShop/control/item/ProductController$DealListener;

    if-nez v0, :cond_0

    .line 2396
    new-instance v0, Lcom/amazon/mShop/control/item/ProductController$DealListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/mShop/control/item/ProductController$DealListener;-><init>(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/mShop/control/item/ProductController$1;)V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mDealListener:Lcom/amazon/mShop/control/item/ProductController$DealListener;

    .line 2398
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController;->mDealListener:Lcom/amazon/mShop/control/item/ProductController$DealListener;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/control/item/ProductController$DealListener;->requestDeal(Ljava/lang/String;)V

    .line 2400
    :cond_1
    return-void
.end method

.method public selectionChanged(II)V
    .locals 2
    .param p1, "newIndex"    # I
    .param p2, "oldIndex"    # I

    .prologue
    .line 1679
    if-eq p1, p2, :cond_0

    .line 1680
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->reset()V

    .line 1681
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->getCurrentObject()Ljava/lang/Object;

    move-result-object v0

    .line 1682
    .local v0, "product":Ljava/lang/Object;
    invoke-direct {p0, v0}, Lcom/amazon/mShop/control/item/ProductController;->updateWithObject(Ljava/lang/Object;)V

    .line 1683
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->startProductRequest()V

    .line 1684
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->notifyProductUpdated()V

    .line 1685
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->notifyImageChanged()V

    .line 1688
    .end local v0    # "product":Ljava/lang/Object;
    :cond_0
    return-void
.end method

.method public setClickStreamTag(Lcom/amazon/mShop/control/item/ClickStreamTag;)V
    .locals 0
    .param p1, "clickStreamValue"    # Lcom/amazon/mShop/control/item/ClickStreamTag;

    .prologue
    .line 321
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->clickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 322
    return-void
.end method

.method public setDeal(Lcom/amazon/rio/j2me/client/services/mShop/Deal;)V
    .locals 0
    .param p1, "deal"    # Lcom/amazon/rio/j2me/client/services/mShop/Deal;

    .prologue
    .line 2384
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->mDeal:Lcom/amazon/rio/j2me/client/services/mShop/Deal;

    .line 2385
    return-void
.end method

.method public setDealId(Ljava/lang/String;)V
    .locals 0
    .param p1, "dealId"    # Ljava/lang/String;

    .prologue
    .line 1176
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->dealId:Ljava/lang/String;

    .line 1177
    return-void
.end method

.method public setEncodedLargeImage([B)V
    .locals 0
    .param p1, "encodedLargeImage"    # [B

    .prologue
    .line 500
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->image:[B

    .line 501
    return-void
.end method

.method public setExtraOfferListing(Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;)V
    .locals 0
    .param p1, "ol"    # Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    .prologue
    .line 609
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->mExtraOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    .line 610
    return-void
.end method

.method public setIsSelectedChild(Z)V
    .locals 0
    .param p1, "isSelectedChild"    # Z

    .prologue
    .line 1279
    iput-boolean p1, p0, Lcom/amazon/mShop/control/item/ProductController;->mIsSelectedChild:Z

    .line 1280
    return-void
.end method

.method public setListId(Ljava/lang/String;)V
    .locals 0
    .param p1, "listId"    # Ljava/lang/String;

    .prologue
    .line 402
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->listId:Ljava/lang/String;

    .line 403
    return-void
.end method

.method public setListItemId(Ljava/lang/String;)V
    .locals 0
    .param p1, "listItemId"    # Ljava/lang/String;

    .prologue
    .line 392
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->listItemId:Ljava/lang/String;

    .line 393
    return-void
.end method

.method public setMerchantId(Ljava/lang/String;)V
    .locals 0
    .param p1, "merchantId"    # Ljava/lang/String;

    .prologue
    .line 360
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->merchantId:Ljava/lang/String;

    .line 361
    return-void
.end method

.method public setOfferId(Ljava/lang/String;)V
    .locals 0
    .param p1, "offerId"    # Ljava/lang/String;

    .prologue
    .line 350
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->offerId:Ljava/lang/String;

    .line 351
    return-void
.end method

.method public setProductSavings(Lcom/amazon/rio/j2me/client/services/mShop/Savings;)V
    .locals 0
    .param p1, "savings"    # Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    .prologue
    .line 1222
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->productSavings:Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    .line 1223
    return-void
.end method

.method public setSelectedVariationChild(Lcom/amazon/mShop/control/item/Variations$Child;)V
    .locals 4
    .param p1, "child"    # Lcom/amazon/mShop/control/item/Variations$Child;

    .prologue
    const/4 v3, 0x0

    .line 1300
    if-eqz p1, :cond_4

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->selectedChild:Lcom/amazon/mShop/control/item/Variations$Child;

    if-eq p1, v1, :cond_4

    .line 1301
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->selectedChild:Lcom/amazon/mShop/control/item/Variations$Child;

    .line 1303
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/Variations$Child;->getVariationProductInfo()Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    move-result-object v0

    .line 1305
    .local v0, "variationProductInfo":Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/amazon/mShop/control/item/ProductController;->setAsin(Ljava/lang/String;)V

    .line 1307
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/Variations$Child;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/amazon/mShop/control/item/ProductController;->setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V

    .line 1310
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setAsin(Ljava/lang/String;)V

    .line 1311
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->getImagesCount()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setImagesCount(I)V

    .line 1312
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->getOffersSummary()Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setUsedAndNewSummary(Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;)V

    .line 1313
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->getListPrice()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setListPrice(Ljava/lang/String;)V

    .line 1317
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/Variations$Child;->getImage()[B

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty([B)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1318
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/Variations$Child;->getImage()[B

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/control/item/ProductController;->setEncodedLargeImage([B)V

    .line 1321
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/Variations$Child;->getImageUrl()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/amazon/mShop/control/item/ProductController;->setImageUrl(Ljava/lang/String;)V

    .line 1323
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/control/item/ProductController;->setDealId(Ljava/lang/String;)V

    .line 1324
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/control/item/ProductController;->setDeal(Lcom/amazon/rio/j2me/client/services/mShop/Deal;)V

    .line 1325
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->mDealListener:Lcom/amazon/mShop/control/item/ProductController$DealListener;

    if-eqz v1, :cond_1

    .line 1326
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->mDealListener:Lcom/amazon/mShop/control/item/ProductController$DealListener;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/ProductController$DealListener;->cancel()V

    .line 1329
    :cond_1
    invoke-direct {p0, v3}, Lcom/amazon/mShop/control/item/ProductController;->setPrimeOneClickShippingOffers(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;)V

    .line 1330
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/control/item/ProductController;->setShowPriceClicked(Z)V

    .line 1332
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->extraProductInfo:Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

    if-eqz v1, :cond_2

    .line 1333
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->extraProductInfo:Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

    invoke-virtual {v1, v3}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->setProductMessages(Ljava/util/List;)V

    .line 1334
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->extraProductInfo:Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

    invoke-virtual {v1, v3}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->setOfferListSummaries(Ljava/util/List;)V

    .line 1335
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->extraProductInfo:Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

    invoke-virtual {v1, v3}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->setOffers(Ljava/util/List;)V

    .line 1336
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->extraProductInfo:Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

    invoke-virtual {v1, v3}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->setSimilarItems(Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;)V

    .line 1339
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->mExtraOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    if-eqz v1, :cond_3

    .line 1340
    iput-object v3, p0, Lcom/amazon/mShop/control/item/ProductController;->mExtraOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    .line 1343
    :cond_3
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/control/item/ProductController;->setProductSavings(Lcom/amazon/rio/j2me/client/services/mShop/Savings;)V

    .line 1345
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->startProductRequest()V

    .line 1346
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->notifyProductUpdated()V

    .line 1347
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->notifySimilarItemsGalleryUpdated()V

    .line 1348
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->notifyImageChanged()V

    .line 1350
    .end local v0    # "variationProductInfo":Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    :cond_4
    return-void
.end method

.method public setShowPriceClicked(Z)V
    .locals 1
    .param p1, "showPriceClicked"    # Z

    .prologue
    .line 629
    iget-boolean v0, p0, Lcom/amazon/mShop/control/item/ProductController;->showPriceClicked:Z

    if-eq v0, p1, :cond_0

    .line 630
    iput-boolean p1, p0, Lcom/amazon/mShop/control/item/ProductController;->showPriceClicked:Z

    .line 631
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->notifyPriceUpdated()V

    .line 633
    :cond_0
    return-void
.end method

.method public setThumbnail([B)V
    .locals 0
    .param p1, "thumbnail"    # [B

    .prologue
    .line 523
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController;->thumbnail:[B

    .line 524
    return-void
.end method

.method public shouldBuyFromFriendApp()Z
    .locals 4

    .prologue
    const/4 v1, 0x1

    .line 1489
    iget-object v2, p0, Lcom/amazon/mShop/control/item/ProductController;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    if-eqz v2, :cond_3

    .line 1490
    iget-object v2, p0, Lcom/amazon/mShop/control/item/ProductController;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getProductGroupId()Ljava/lang/String;

    move-result-object v0

    .line 1491
    .local v0, "groupId":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eq v2, v1, :cond_3

    .line 1492
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->isMobileApp()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->isAmazonAppStoreSupported()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1505
    .end local v0    # "groupId":Ljava/lang/String;
    :cond_0
    :goto_0
    return v1

    .line 1494
    .restart local v0    # "groupId":Ljava/lang/String;
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->isMusic()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->isAmazonMp3Supported()Z

    move-result v2

    if-nez v2, :cond_0

    .line 1496
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->isKindleBook()Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->isAmazonKindleSupported()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 1497
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getBindingSymbol()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_3

    const-string/jumbo v2, "kindle_edition"

    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getBindingSymbol()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 1505
    .end local v0    # "groupId":Ljava/lang/String;
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->hasExternalBuyLink()Z

    move-result v1

    goto :goto_0

    .line 1500
    .restart local v0    # "groupId":Ljava/lang/String;
    :cond_4
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->isVideo()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->isAmazonVideoSupported()Z

    move-result v2

    if-eqz v2, :cond_3

    goto :goto_0
.end method

.method public tryStartRequest()V
    .locals 2

    .prologue
    .line 268
    const/4 v0, 0x1

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController;->subscribers:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 269
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController;->startProductRequest()V

    .line 271
    :cond_0
    return-void
.end method
