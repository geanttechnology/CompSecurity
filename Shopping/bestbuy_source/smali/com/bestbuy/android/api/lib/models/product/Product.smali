.class public Lcom/bestbuy/android/api/lib/models/product/Product;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field public static final ACCESSORIES_IMAGE:Ljava/lang/String; = "accessoriesImage"

.field public static final ACTIVE:Ljava/lang/String; = "active"

.field public static final ADVERTISED_PRICE_RESTRICTION:Ljava/lang/String; = "advertisedPriceRestriction"

.field public static final ALTERNATE_VIEWS_IMAGE:Ljava/lang/String; = "alternateViewsImage"

.field public static final ANGLE_IMAGE:Ljava/lang/String; = "angleImage"

.field public static final ARTIST_NAME:Ljava/lang/String; = "artistName"

.field public static final BACKVIEW_IMAGE:Ljava/lang/String; = "backViewImage"

.field public static final BUYBACK_PLANS:Ljava/lang/String; = "buybackPlans"

.field public static final BUYBACK_PLANS_SKU:Ljava/lang/String; = "buybackPlans.sku"

.field public static final CATEGORY_PATH:Ljava/lang/String; = "categoryPath"

.field public static final CUSTOMER_REVIEW_AVERAGE:Ljava/lang/String; = "customerReviewAverage"

.field public static final CUSTOMER_REVIEW_COUNT:Ljava/lang/String; = "customerReviewCount"

.field public static final DEPARTMENT_ID:Ljava/lang/String; = "departmentId"

.field public static final DESCRIPTION:Ljava/lang/String; = "description"

.field public static final DETAILS:Ljava/lang/String; = "details"

.field public static final ESRB_RATING:Ljava/lang/String; = "esrbRating"

.field public static final FORMAT:Ljava/lang/String; = "format"

.field public static final FREQUENTLY_PURCHASED_WITH:Ljava/lang/String; = "frequentlyPurchasedWith"

.field public static final FRIENDS_AND_FAMILY_PICKUP:Ljava/lang/String; = "friendsAndFamilyPickup"

.field public static final HOME_DELIVERY:Ljava/lang/String; = "homeDelivery"

.field public static final IMAGE:Ljava/lang/String; = "image"

.field public static final IN_STORE_AVAILABILITY:Ljava/lang/String; = "inStoreAvailability"

.field public static final IN_STORE_PICKUP:Ljava/lang/String; = "inStorePickup"

.field public static final LARGE_FRONT_IMAGE:Ljava/lang/String; = "largeFrontImage"

.field public static final LARGE_IMAGE:Ljava/lang/String; = "largeImage"

.field public static final LEFTVIEW_IMAGE:Ljava/lang/String; = "leftViewImage"

.field public static final LONG_DESCRIPTION:Ljava/lang/String; = "longDescription"

.field public static final MANUFACTURER:Ljava/lang/String; = "manufacturer"

.field public static final MARKETING_COPY:Ljava/lang/String; = "marketing_copy"

.field public static final MARKET_PLACE_ITEMS:Ljava/lang/String; = "marketplace"

.field public static final MEDIUM_IMAGE:Ljava/lang/String; = "mediumImage"

.field public static final MODEL_NUMBER:Ljava/lang/String; = "modelNumber"

.field public static final NAME:Ljava/lang/String; = "name"

.field public static final ONLINE_AVAILABILITY:Ljava/lang/String; = "onlineAvailability"

.field public static final ON_SALE:Ljava/lang/String; = "onSale"

.field public static final ORDERABLE:Ljava/lang/String; = "orderable"

.field public static final PLAN_PRICE:Ljava/lang/String; = "planPrice"

.field public static final PLATFORM:Ljava/lang/String; = "platform"

.field public static final PLOT:Ljava/lang/String; = "plot"

.field public static final PREOWNED:Ljava/lang/String; = "preowned"

.field public static final PRICE:Ljava/lang/String; = "price"

.field public static final PRICE_RESTRICTION:Ljava/lang/String; = "priceRestriction"

.field public static final PRODUCT_ID:Ljava/lang/String; = "productId"

.field public static final PROTECTION_PLANS:Ljava/lang/String; = "protectionPlans"

.field public static final PROTECTION_PLANS_SKU:Ljava/lang/String; = "protectionPlans.sku"

.field public static final PROTECTION_PLAN_TERM:Ljava/lang/String; = "protectionPlanTerm"

.field public static final PROTECTION_PLAN_TYPE:Ljava/lang/String; = "protectionPlanType"

.field public static final REGULAR_PRICE:Ljava/lang/String; = "regularPrice"

.field public static final RELEASE_DATE:Ljava/lang/String; = "releaseDate"

.field public static final REMOTE_CONTROL_IMAGE:Ljava/lang/String; = "remoteControlImage"

.field public static final RESTRICTED_SALE_PRICE:Ljava/lang/String; = "restrictedSalePrice"

.field public static final RIGHTVIEW_IMAGE:Ljava/lang/String; = "rightViewImage"

.field public static final RZ_LEVELS:Ljava/lang/String; = "rz_levels"

.field public static final SALE_PRICE:Ljava/lang/String; = "salePrice"

.field public static final SHORT_DESCRIPTION:Ljava/lang/String; = "shortDescription"

.field public static final SKU:Ljava/lang/String; = "sku"

.field public static final SKUS:Ljava/lang/String; = "skus"

.field public static final SPECIAL_ORDER:Ljava/lang/String; = "specialOrder"

.field private static TAG:Ljava/lang/String; = null

.field public static final THUMBNAIL_IMAGE:Ljava/lang/String; = "thumbnailImage"

.field public static final TITLE:Ljava/lang/String; = "title"

.field public static final TOPVIEW_IMAGE:Ljava/lang/String; = "topViewImage"

.field public static final TRADE_IN_VALUE:Ljava/lang/String; = "tradeInValue"

.field public static final TYPE:Ljava/lang/String; = "type"

.field public static final URL:Ljava/lang/String; = "url"

.field public static final VALUE:Ljava/lang/String; = "value"

.field private static frequentlyPurchasedWith:Ljava/util/ArrayList; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final serialVersionUID:J = 0x56584c78b2ebae9eL


# instance fields
.field private accessories:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private active:Z

.field private activeUpdateDate:Ljava/util/Date;

.field private additionalFeatures:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private addtoCartUrl:Ljava/lang/String;

.field private affiliateAddToCartUrl:Ljava/lang/String;

.field private affilliateUrl:Ljava/lang/String;

.field private albumLabel:Ljava/lang/String;

.field private albumTitle:Ljava/lang/String;

.field private alternateSkus:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;",
            ">;"
        }
    .end annotation
.end field

.field private artistName:Ljava/lang/String;

.field private aspectRatio:Ljava/lang/String;

.field private availableStoreId:Ljava/lang/String;

.field public bbyProduct:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field private bestBuyItemId:D

.field private bestSellingRank:I

.field private brandLabel:Ljava/lang/String;

.field private brandName:Ljava/lang/String;

.field private breadcrumb:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$BreadCrumb;",
            ">;"
        }
    .end annotation
.end field

.field private bundleItemCount:I

.field private bundledIn:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private buybackPlans:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private cast:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private categories:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;"
        }
    .end annotation
.end field

.field private categoryID:Ljava/lang/String;

.field private chatType:Ljava/lang/String;

.field private cjAffiliateAddToCartUrl:Ljava/lang/String;

.field private cjAffiliateUrl:Ljava/lang/String;

.field private clearance:Z

.field private colorId:Ljava/lang/String;

.field private colorName:Ljava/lang/String;

.field private colorOptions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;",
            ">;"
        }
    .end annotation
.end field

.field private condition:Ljava/lang/String;

.field private contractOptions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;",
            ">;"
        }
    .end annotation
.end field

.field private crew:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public customerReviewAverage:D

.field private customerReviewCount:I

.field private department:Ljava/lang/String;

.field private departmentId:I

.field private depth:Ljava/lang/String;

.field private description:Ljava/lang/String;

.field private details:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;"
        }
    .end annotation
.end field

.field private digital:Z

.field private energyStarCompatible:Z

.field private epValue:Ljava/lang/String;

.field private erbRating:Ljava/lang/String;

.field private features:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private fileSize:Ljava/lang/String;

.field private format:Ljava/lang/String;

.field private formatOptions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;",
            ">;"
        }
    .end annotation
.end field

.field private freeShipping:Z

.field private freeShippingCode:Ljava/lang/String;

.field private friendsAndFamilyPickup:Z

.field private fulfilledBy:Ljava/lang/String;

.field private geekSquadCertified:Z

.field private genre:Ljava/lang/String;

.field private height:Ljava/lang/String;

.field private homeDelivery:Z

.field private images:Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

.field private inStoreAvailability:Z

.field private inStoreAvailabilityText:Ljava/lang/String;

.field private inStoreAvailabilityTextHtml:Ljava/lang/String;

.field private inStoreAvailabilityUpdateDate:Ljava/util/Date;

.field private inStorePickup:Z

.field private includedItemList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private isActiveSku:Z

.field private isContractProduct:Z

.field private itemUpdateDate:Ljava/util/Date;

.field private keywords:Ljava/lang/String;

.field private label:Ljava/lang/String;

.field private lengthInMinutes:I

.field private listingId:Ljava/lang/String;

.field private longDescription:Ljava/lang/String;

.field private longDescriptionHtml:Ljava/lang/String;

.field private lowPriceGuarantee:Z

.field private lowPriceGuaranteedProduct:Z

.field private mAccessoriesList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product;",
            ">;"
        }
    .end annotation
.end field

.field private mFreeBonusContentList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$BonusContent;",
            ">;"
        }
    .end annotation
.end field

.field private mSoftwareORGameDetails:Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;

.field private manufacturer:Ljava/lang/String;

.field private marketPlace:Z

.field private mediaType:Ljava/lang/String;

.field private members:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mobileUrl:Ljava/lang/String;

.field private modelNumber:Ljava/lang/String;

.field private monoStereo:Ljava/lang/String;

.field private movieCastCrewList:Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;

.field private movieDetailsList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Details;",
            ">;"
        }
    .end annotation
.end field

.field private movieRating:Ljava/lang/String;

.field private movieUrl:Ljava/lang/String;

.field private mpaaRating:Ljava/lang/String;

.field private musicDetailsList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Details;",
            ">;"
        }
    .end annotation
.end field

.field private name:Ljava/lang/String;

.field private newProduct:Z

.field private numberOfPlayers:Ljava/lang/String;

.field private offers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;"
        }
    .end annotation
.end field

.field private onlineAvailability:Z

.field private onlineAvailabilityText:Ljava/lang/String;

.field private onlineAvailabilityTextHtml:Ljava/lang/String;

.field private onlineAvailabilityUpdateDate:Ljava/util/Date;

.field private onlineOnly:Z

.field private onlinePlay:Z

.field private orderable:Ljava/lang/String;

.field private originalReleaseDate:Ljava/util/Date;

.field private outletCenter:Z

.field private parentalAdvisory:Z

.field private platform:Ljava/lang/String;

.field private plot:Ljava/lang/String;

.field private plotHtml:Ljava/lang/String;

.field private preowned:Z

.field private priceBlock:Lcom/bestbuy/android/api/lib/models/product/PriceBlock;

.field private prodBlock:Lcom/bestbuy/android/api/lib/models/product/ProductBlock;

.field private productClass:Ljava/lang/String;

.field private productClassId:I

.field private productFeatures:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Feature;",
            ">;"
        }
    .end annotation
.end field

.field private productId:Ljava/lang/String;

.field private productOptionType:Ljava/lang/String;

.field public productSummary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

.field private productTemplate:Ljava/lang/String;

.field private productType:Ljava/lang/String;

.field private productVideos:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;",
            ">;"
        }
    .end annotation
.end field

.field private protectionPlanDetails:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private protectionPlanHighPrice:D

.field private protectionPlanLowPrice:D

.field private protectionPlanName:Ljava/lang/String;

.field private protectionPlanPrice:D

.field private protectionPlans:Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;

.field private publisher:Ljava/lang/String;

.field private quantityLimit:I

.field private refurbished:Z

.field private relatedProducts:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private releaseDate:Ljava/lang/String;

.field private review:Lcom/bestbuy/android/api/lib/models/product/Review;

.field private salesRankLongTerm:I

.field private salesRankMediumTerm:I

.field private salesRankShortTerm:I

.field private secondaryMarket:Z

.field private sellerId:Ljava/lang/String;

.field private shippingCost:D

.field private shippingRestrictions:Ljava/lang/String;

.field private shippingWeight:Ljava/lang/String;

.field private shipping_ground:D

.field private shipping_nextDay:D

.field private shipping_secondDay:D

.field private shipping_vendorDelivery:D

.field private shortDescription:Ljava/lang/String;

.field private shortDescriptionHtml:Ljava/lang/String;

.field private sku:Ljava/lang/String;

.field private smartCapable:Z

.field private softwareAge:Ljava/lang/String;

.field private softwareGrade:Ljava/lang/String;

.field private softwareNumberOfPlayers:Ljava/lang/String;

.field private songsTrackList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;"
        }
    .end annotation
.end field

.field private source:Ljava/lang/String;

.field private specialFeatures:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private specialOrder:Z

.field private specifications:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Specification;",
            ">;"
        }
    .end annotation
.end field

.field private startDate:Ljava/util/Date;

.field private studio:Ljava/lang/String;

.field private studioLive:Ljava/lang/String;

.field private subClass:Ljava/lang/String;

.field private subClassId:I

.field private subtitleLanguages:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private synopsis:Ljava/lang/String;

.field private tabs:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private theatricalReleaseDate:Ljava/util/Date;

.field private title:Ljava/lang/String;

.field private tradeInValue:D

.field private type:Ljava/lang/String;

.field private upc:Ljava/lang/String;

.field private url:Ljava/lang/String;

.field private vendor:Ljava/lang/String;

.field private videoLanguages:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private wallMountable:Z

.field private warrantyLabor:Ljava/lang/String;

.field private warrantyParts:Ljava/lang/String;

.field private weight:Ljava/lang/String;

.field private width:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lcom/bestbuy/android/api/lib/models/product/Product;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1133
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 114
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->epValue:Ljava/lang/String;

    .line 123
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->description:Ljava/lang/String;

    .line 124
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->shortDescription:Ljava/lang/String;

    .line 125
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->shortDescriptionHtml:Ljava/lang/String;

    .line 126
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->longDescription:Ljava/lang/String;

    .line 127
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->longDescriptionHtml:Ljava/lang/String;

    .line 131
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->categoryID:Ljava/lang/String;

    .line 149
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->protectionPlans:Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;

    .line 251
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->songsTrackList:Ljava/util/ArrayList;

    .line 313
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->refurbished:Z

    .line 324
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->isActiveSku:Z

    .line 325
    iput v1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->bundleItemCount:I

    .line 1133
    return-void
.end method

.method static synthetic access$002(Lcom/bestbuy/android/api/lib/models/product/Product;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->sku:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$102(Lcom/bestbuy/android/api/lib/models/product/Product;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->productId:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$202(Lcom/bestbuy/android/api/lib/models/product/Product;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->name:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$502(Lcom/bestbuy/android/api/lib/models/product/Product;Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;)Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->images:Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    return-object p1
.end method

.method static synthetic access$600(Lcom/bestbuy/android/api/lib/models/product/Product;)I
    .locals 1

    .prologue
    .line 27
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewCount:I

    return v0
.end method

.method static synthetic access$602(Lcom/bestbuy/android/api/lib/models/product/Product;I)I
    .locals 0

    .prologue
    .line 27
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewCount:I

    return p1
.end method

.method public static getFrequentlyPurchasedWith()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 555
    sget-object v0, Lcom/bestbuy/android/api/lib/models/product/Product;->frequentlyPurchasedWith:Ljava/util/ArrayList;

    return-object v0
.end method

.method public static loadBBYOpenData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product;
    .locals 8

    .prologue
    const/4 v1, 0x0

    .line 1142
    new-instance v3, Lcom/bestbuy/android/api/lib/models/product/Product;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/product/Product;-><init>()V

    .line 1144
    const-string v0, "sku"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->sku:Ljava/lang/String;

    .line 1145
    const-string v0, "name"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->name:Ljava/lang/String;

    .line 1146
    const-string v0, "upc"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->upc:Ljava/lang/String;

    .line 1147
    const-string v0, "productId"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->productId:Ljava/lang/String;

    .line 1148
    const-string v0, "modelNumber"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->modelNumber:Ljava/lang/String;

    .line 1149
    const-string v0, "bestBuyItemId"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->bestBuyItemId:D

    .line 1152
    invoke-static {p0}, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/PriceBlock;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->priceBlock:Lcom/bestbuy/android/api/lib/models/product/PriceBlock;

    .line 1155
    const-string v0, "description"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->description:Ljava/lang/String;

    .line 1156
    const-string v0, "shortDescription"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->shortDescription:Ljava/lang/String;

    .line 1157
    const-string v0, "shortDescriptionHtml"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->shortDescriptionHtml:Ljava/lang/String;

    .line 1158
    const-string v0, "longDescription"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->longDescription:Ljava/lang/String;

    .line 1159
    const-string v0, "longDescriptionHtml"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->longDescriptionHtml:Ljava/lang/String;

    .line 1163
    :try_start_0
    const-string v0, "details"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 1165
    if-eqz v2, :cond_1

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_1

    move v0, v1

    .line 1166
    :goto_0
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v0, v4, :cond_1

    .line 1167
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 1168
    new-instance v5, Lorg/apache/http/message/BasicNameValuePair;

    const-string v6, "name"

    invoke-virtual {v4, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "value"

    invoke-virtual {v4, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v5, v6, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 1169
    iget-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->details:Ljava/util/ArrayList;

    if-nez v4, :cond_0

    .line 1170
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->details:Ljava/util/ArrayList;

    .line 1172
    :cond_0
    iget-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->details:Ljava/util/ArrayList;

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1166
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1175
    :catch_0
    move-exception v0

    .line 1176
    sget-object v2, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Could not parse details data: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1180
    :cond_1
    :try_start_1
    const-string v0, "features"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 1181
    if-eqz v2, :cond_3

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_3

    move v0, v1

    .line 1182
    :goto_1
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v0, v4, :cond_3

    .line 1183
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 1184
    iget-object v5, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->features:Ljava/util/ArrayList;

    if-nez v5, :cond_2

    .line 1185
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iput-object v5, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->features:Ljava/util/ArrayList;

    .line 1187
    :cond_2
    iget-object v5, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->features:Ljava/util/ArrayList;

    const-string v6, "feature"

    invoke-virtual {v4, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 1182
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1191
    :catch_1
    move-exception v0

    .line 1192
    sget-object v2, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Could not parse features data: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1197
    :cond_3
    :try_start_2
    const-string v0, "frequentlyPurchasedWith"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 1198
    if-eqz v4, :cond_4

    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-eqz v0, :cond_4

    .line 1199
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/product/Product;->frequentlyPurchasedWith:Ljava/util/ArrayList;

    move v2, v1

    .line 1200
    :goto_2
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v2, v0, :cond_4

    .line 1201
    invoke-virtual {v4, v2}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    .line 1202
    sget-object v5, Lcom/bestbuy/android/api/lib/models/product/Product;->frequentlyPurchasedWith:Ljava/util/ArrayList;

    const-string v6, "sku"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 1200
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_2

    .line 1205
    :catch_2
    move-exception v0

    .line 1206
    sget-object v2, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Could not parse frequentlyPurchasedWith data:  "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1211
    :cond_4
    :try_start_3
    const-string v0, "offers"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->loadData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->offers:Ljava/util/ArrayList;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    .line 1217
    :goto_3
    :try_start_4
    const-string v0, "bundledIn"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 1218
    if-eqz v2, :cond_5

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_5

    move v0, v1

    .line 1219
    :goto_4
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v0, v4, :cond_5

    .line 1220
    iget-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->bundledIn:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "sku"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4

    .line 1219
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    .line 1212
    :catch_3
    move-exception v0

    .line 1213
    sget-object v2, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Could not parse Offer data: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    .line 1223
    :catch_4
    move-exception v0

    .line 1224
    sget-object v2, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Could not parse bundled array. "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1228
    :cond_5
    :try_start_5
    const-string v0, "categoryPath"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 1229
    if-eqz v2, :cond_7

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_7

    .line 1231
    iget-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->categories:Ljava/util/ArrayList;

    if-nez v0, :cond_6

    .line 1232
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->categories:Ljava/util/ArrayList;

    :cond_6
    move v0, v1

    .line 1234
    :goto_5
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v0, v1, :cond_7

    .line 1235
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    .line 1236
    const-string v4, "name"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 1237
    const-string v5, "id"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1238
    iget-object v5, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->categories:Ljava/util/ArrayList;

    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    invoke-direct {v6, v1, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_5

    .line 1234
    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    .line 1241
    :catch_5
    move-exception v0

    .line 1242
    sget-object v1, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not parse category. "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1246
    :cond_7
    const-string v0, "accessories"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    const-string v1, "sku"

    invoke-static {v0, v1}, Lcom/bestbuy/android/api/lib/models/product/Product;->loadKeyValue(Lorg/json/JSONArray;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->accessories:Ljava/util/ArrayList;

    .line 1247
    const-string v0, "includedItemList"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    const-string v1, "includedItem"

    invoke-static {v0, v1}, Lcom/bestbuy/android/api/lib/models/product/Product;->loadKeyValue(Lorg/json/JSONArray;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->includedItemList:Ljava/util/ArrayList;

    .line 1248
    const-string v0, "relatedProducts"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    const-string v1, "sku"

    invoke-static {v0, v1}, Lcom/bestbuy/android/api/lib/models/product/Product;->loadKeyValue(Lorg/json/JSONArray;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->relatedProducts:Ljava/util/ArrayList;

    .line 1253
    const-string v0, "protectionPlanHighPrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->protectionPlanHighPrice:D

    .line 1254
    const-string v0, "protectionPlanLowPrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->protectionPlanLowPrice:D

    .line 1257
    invoke-static {p0}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->loadImageData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->images:Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    .line 1260
    const-string v0, "bestSellingRank"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->bestSellingRank:I

    .line 1261
    const-string v0, "salesRankLongTerm"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->salesRankLongTerm:I

    .line 1262
    const-string v0, "salesRankMediumTerm"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->salesRankMediumTerm:I

    .line 1263
    const-string v0, "salesRankShortTerm"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->salesRankShortTerm:I

    .line 1266
    const-string v0, "customerReviewAverage"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewAverage:D

    .line 1267
    const-string v0, "customerReviewCount"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewCount:I

    .line 1270
    const-string v0, "department"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->department:Ljava/lang/String;

    .line 1271
    const-string v0, "type"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->type:Ljava/lang/String;

    .line 1272
    const-string v0, "condition"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->condition:Ljava/lang/String;

    .line 1273
    const-string v0, "departmentId"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->departmentId:I

    .line 1274
    const-string v0, "format"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->format:Ljava/lang/String;

    .line 1275
    const-string v0, "manufacturer"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->manufacturer:Ljava/lang/String;

    .line 1276
    const-string v0, "subClass"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->subClass:Ljava/lang/String;

    .line 1277
    const-string v0, "subClassId"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->subClassId:I

    .line 1278
    const-string v0, "productTemplate"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->productTemplate:Ljava/lang/String;

    .line 1279
    const-string v0, "productClass"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->productClass:Ljava/lang/String;

    .line 1280
    const-string v0, "productClassId"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->productClassId:I

    .line 1281
    const-string v0, "newProduct"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->newProduct:Z

    .line 1282
    const-string v0, "preowned"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->preowned:Z

    .line 1284
    const-string v0, "digital"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->digital:Z

    .line 1285
    const-string v0, "active"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->active:Z

    .line 1288
    :try_start_6
    sget-object v0, Lgv;->a:Ljava/text/SimpleDateFormat;

    const-string v1, "activeUpdateDate"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->activeUpdateDate:Ljava/util/Date;
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_6

    .line 1294
    :goto_6
    :try_start_7
    sget-object v0, Lgv;->a:Ljava/text/SimpleDateFormat;

    const-string v1, "itemUpdateDate"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->itemUpdateDate:Ljava/util/Date;
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_7

    .line 1298
    :goto_7
    const-string v0, "quantityLimit"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->quantityLimit:I

    .line 1300
    :try_start_8
    sget-object v0, Lgv;->a:Ljava/text/SimpleDateFormat;

    const-string v1, "startDate"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->startDate:Ljava/util/Date;
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_8

    .line 1305
    :goto_8
    :try_start_9
    const-string v0, "releaseDate"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->releaseDate:Ljava/lang/String;
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_9

    .line 1310
    :goto_9
    const-string v0, "color"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->colorName:Ljava/lang/String;

    .line 1311
    const-string v0, "depth"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->depth:Ljava/lang/String;

    .line 1312
    const-string v0, "height"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->height:Ljava/lang/String;

    .line 1313
    const-string v0, "width"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->width:Ljava/lang/String;

    .line 1314
    const-string v0, "weight"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->weight:Ljava/lang/String;

    .line 1317
    const-string v0, "inStoreAvailability"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->inStoreAvailability:Z

    .line 1318
    const-string v0, "onlineAvailability"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->onlineAvailability:Z

    .line 1319
    const-string v0, "inStorePickup"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->inStorePickup:Z

    .line 1320
    const-string v0, "homeDelivery"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->homeDelivery:Z

    .line 1321
    const-string v0, "friendsAndFamilyPickup"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->friendsAndFamilyPickup:Z

    .line 1322
    const-string v0, "specialOrder"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->specialOrder:Z

    .line 1324
    :try_start_a
    sget-object v0, Lgv;->c:Ljava/text/SimpleDateFormat;

    const-string v1, "inStoreAvailabilityUpdateDate"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->inStoreAvailabilityUpdateDate:Ljava/util/Date;
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_a

    .line 1328
    :goto_a
    const-string v0, "inStoreAvailabilityText"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->inStoreAvailabilityText:Ljava/lang/String;

    .line 1329
    const-string v0, "inStoreAvailabilityTextHtml"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->inStoreAvailabilityTextHtml:Ljava/lang/String;

    .line 1331
    :try_start_b
    sget-object v0, Lgv;->c:Ljava/text/SimpleDateFormat;

    const-string v1, "onlineAvailabilityUpdateDate"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->onlineAvailabilityUpdateDate:Ljava/util/Date;
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_b

    .line 1335
    :goto_b
    const-string v0, "onlineAvailabilityText"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->onlineAvailabilityText:Ljava/lang/String;

    .line 1336
    const-string v0, "onlineAvailabilityTextHtml"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->onlineAvailabilityTextHtml:Ljava/lang/String;

    .line 1339
    const-string v0, "shippingWeight"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->shippingWeight:Ljava/lang/String;

    .line 1340
    const-string v0, "shippingRestrictions"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->shippingRestrictions:Ljava/lang/String;

    .line 1341
    const-string v0, "shippingCost"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->shippingCost:D

    .line 1342
    const-string v0, "shipping"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 1343
    if-eqz v0, :cond_8

    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-lez v1, :cond_8

    .line 1345
    const/4 v1, 0x0

    :try_start_c
    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    .line 1346
    const-string v1, "nextDay"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->shipping_nextDay:D

    .line 1347
    const-string v1, "secondDay"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->shipping_secondDay:D

    .line 1348
    const-string v1, "VendorDelivery"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->shipping_vendorDelivery:D

    .line 1349
    const-string v1, "ground"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->shipping_ground:D
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_c

    .line 1356
    :cond_8
    :goto_c
    const-string v0, "secondaryMarket"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->secondaryMarket:Z

    .line 1357
    const-string v0, "sellerId"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->sellerId:Ljava/lang/String;

    .line 1358
    const-string v0, "source"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->source:Ljava/lang/String;

    .line 1359
    const-string v0, "listingId"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->listingId:Ljava/lang/String;

    .line 1360
    const-string v0, "fulfilledBy"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->fulfilledBy:Ljava/lang/String;

    .line 1363
    const-string v0, "warrantyParts"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->warrantyParts:Ljava/lang/String;

    .line 1364
    const-string v0, "warrantyLabor"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->warrantyLabor:Ljava/lang/String;

    .line 1367
    const-string v0, "url"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->url:Ljava/lang/String;

    .line 1368
    const-string v0, "affilliateUrl"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->affilliateUrl:Ljava/lang/String;

    .line 1369
    const-string v0, "cjAffiliateUrl"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->cjAffiliateUrl:Ljava/lang/String;

    .line 1370
    const-string v0, "cjAffiliateAddToCartUrl"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->cjAffiliateAddToCartUrl:Ljava/lang/String;

    .line 1371
    const-string v0, "addtoCartUrl"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->addtoCartUrl:Ljava/lang/String;

    .line 1372
    const-string v0, "affiliateAddToCartUrl"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->affiliateAddToCartUrl:Ljava/lang/String;

    .line 1373
    const-string v0, "mobileUrl"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->mobileUrl:Ljava/lang/String;

    .line 1377
    const-string v0, "albumLabel"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->albumLabel:Ljava/lang/String;

    .line 1378
    const-string v0, "albumTitle"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->albumTitle:Ljava/lang/String;

    .line 1379
    const-string v0, "artistName"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->artistName:Ljava/lang/String;

    .line 1380
    const-string v0, "genre"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->genre:Ljava/lang/String;

    .line 1382
    :try_start_d
    sget-object v0, Lgv;->a:Ljava/text/SimpleDateFormat;

    const-string v1, "originalReleaseDate"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->originalReleaseDate:Ljava/util/Date;
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_d

    .line 1386
    :goto_d
    const-string v0, "parentalAdvisory"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->parentalAdvisory:Z

    .line 1387
    const-string v0, "studioLive"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->studioLive:Ljava/lang/String;

    .line 1388
    const-string v0, "monoStereo"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->monoStereo:Ljava/lang/String;

    .line 1391
    const-string v0, "aspectRatio"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->aspectRatio:Ljava/lang/String;

    .line 1395
    const-string v0, "lengthInMinutes"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->lengthInMinutes:I

    .line 1396
    const-string v0, "mpaaRating"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->mpaaRating:Ljava/lang/String;

    .line 1397
    const-string v0, "plot"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->plot:Ljava/lang/String;

    .line 1398
    const-string v0, "plotHtml"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->plotHtml:Ljava/lang/String;

    .line 1399
    const-string v0, "studio"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->studio:Ljava/lang/String;

    .line 1401
    :try_start_e
    sget-object v0, Lgv;->a:Ljava/text/SimpleDateFormat;

    const-string v1, "theatricalReleaseDate"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->theatricalReleaseDate:Ljava/util/Date;
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_e

    .line 1406
    :goto_e
    const-string v0, "subtitleLanguages"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 1407
    if-eqz v0, :cond_9

    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-lez v1, :cond_9

    .line 1408
    const-string v1, "language"

    invoke-static {v0, v1}, Lcom/bestbuy/android/api/lib/models/product/Product;->loadKeyValue(Lorg/json/JSONArray;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->subtitleLanguages:Ljava/util/ArrayList;

    .line 1411
    :cond_9
    const-string v0, "videoLanguages"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 1412
    if-eqz v0, :cond_a

    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-lez v1, :cond_a

    .line 1413
    const-string v1, "language"

    invoke-static {v0, v1}, Lcom/bestbuy/android/api/lib/models/product/Product;->loadKeyValue(Lorg/json/JSONArray;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->videoLanguages:Ljava/util/ArrayList;

    .line 1416
    :cond_a
    const-string v0, "additionalFeatures"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 1417
    if-eqz v0, :cond_b

    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-lez v1, :cond_b

    .line 1418
    const-string v1, "feature"

    invoke-static {v0, v1}, Lcom/bestbuy/android/api/lib/models/product/Product;->loadKeyValue(Lorg/json/JSONArray;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->additionalFeatures:Ljava/util/ArrayList;

    .line 1422
    :cond_b
    const-string v0, "onlinePlay"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->onlinePlay:Z

    .line 1423
    const-string v0, "softwareGrade"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->softwareGrade:Ljava/lang/String;

    .line 1424
    const-string v0, "softwareNumberOfPlayers"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->softwareNumberOfPlayers:Ljava/lang/String;

    .line 1425
    const-string v0, "softwareAge"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->softwareAge:Ljava/lang/String;

    .line 1426
    const-string v0, "platform"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->platform:Ljava/lang/String;

    .line 1427
    const-string v0, "erbRating"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->erbRating:Ljava/lang/String;

    .line 1428
    const-string v0, "numberOfPlayers"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->numberOfPlayers:Ljava/lang/String;

    .line 1429
    const-string v0, "tradeInValue"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->tradeInValue:D

    .line 1431
    return-object v3

    .line 1289
    :catch_6
    move-exception v0

    .line 1290
    sget-object v1, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not parse activeUpdateDate: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_6

    .line 1295
    :catch_7
    move-exception v0

    .line 1296
    sget-object v1, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not parse itemUpdateDate: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_7

    .line 1301
    :catch_8
    move-exception v0

    .line 1302
    sget-object v1, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not parse startDate: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_8

    .line 1306
    :catch_9
    move-exception v0

    .line 1307
    sget-object v1, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not parse releaseDate: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_9

    .line 1325
    :catch_a
    move-exception v0

    .line 1326
    sget-object v1, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not parse inStoreAvailablityUpdateDate: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_a

    .line 1332
    :catch_b
    move-exception v0

    .line 1333
    sget-object v1, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not parse onlineAvailabilityUpdateDate: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_b

    .line 1350
    :catch_c
    move-exception v0

    .line 1351
    sget-object v1, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not parse Shipping data: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_c

    .line 1383
    :catch_d
    move-exception v0

    .line 1384
    sget-object v1, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not parse originalReleaseDate: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_d

    .line 1402
    :catch_e
    move-exception v0

    .line 1403
    sget-object v1, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not parse theatricalReleaseDate: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_e
.end method

.method public static loadCBProductAggregateData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product;
    .locals 9

    .prologue
    const/4 v8, 0x1

    const/4 v1, 0x0

    .line 1559
    const-string v0, "sku"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 1560
    new-instance v3, Lcom/bestbuy/android/api/lib/models/product/Product;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/product/Product;-><init>()V

    .line 1561
    const-string v0, "errorMessage"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "errorCode"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1562
    const-string v0, "errorCode"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1563
    const-string v4, "PRODUCT_SKU_INACTIVE"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1564
    iput-boolean v1, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->isActiveSku:Z

    .line 1566
    :cond_0
    const-string v0, "productId"

    const-string v4, ""

    invoke-virtual {v2, v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->productId:Ljava/lang/String;

    .line 1567
    const-string v0, "url"

    const-string v4, ""

    invoke-virtual {v2, v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->url:Ljava/lang/String;

    .line 1568
    const-string v0, "upc"

    const-string v4, ""

    invoke-virtual {v2, v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->upc:Ljava/lang/String;

    .line 1569
    const-string v0, "productType"

    const-string v4, ""

    invoke-virtual {v2, v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->productType:Ljava/lang/String;

    .line 1570
    const-string v0, "skuId"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->sku:Ljava/lang/String;

    .line 1571
    const-string v0, "active"

    invoke-virtual {v2, v0, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->active:Z

    .line 1572
    const-string v0, "esrbRating"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 1573
    const-string v0, "esrbRating"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "rating"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->erbRating:Ljava/lang/String;

    .line 1575
    :cond_1
    const-string v0, "movieRatings"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 1576
    const-string v0, "movieRatings"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "rating"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->movieRating:Ljava/lang/String;

    .line 1577
    const-string v0, "movieRatings"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "link"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 1578
    const-string v0, "movieRatings"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "link"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "url"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->movieUrl:Ljava/lang/String;

    .line 1582
    :cond_2
    const-string v0, "color"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 1583
    const-string v0, "color"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "displayName"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->colorName:Ljava/lang/String;

    .line 1584
    const-string v0, "color"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "id"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->colorId:Ljava/lang/String;

    .line 1586
    :cond_3
    const-string v0, "manufacturerId"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 1587
    const-string v0, "manufacturerId"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "modelNumber"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->modelNumber:Ljava/lang/String;

    .line 1588
    :cond_4
    const-string v0, "names"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 1589
    const-string v0, "names"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "short"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->name:Ljava/lang/String;

    .line 1590
    :cond_5
    iget-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->productType:Ljava/lang/String;

    const-string v4, "bundle"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 1591
    const-string v0, "bundleItems"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 1592
    if-eqz v4, :cond_6

    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_6

    .line 1593
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->bundledIn:Ljava/util/ArrayList;

    move v0, v1

    .line 1594
    :goto_0
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v5

    if-ge v0, v5, :cond_6

    .line 1595
    iget-object v5, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->bundledIn:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "sku"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1594
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1599
    :cond_6
    const-string v0, "department"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_7

    .line 1600
    const-string v0, "department"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "displayName"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->department:Ljava/lang/String;

    .line 1601
    const-string v0, "department"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "id"

    const-string v5, "0"

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->departmentId:I

    .line 1603
    :cond_7
    const-string v0, "class"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_8

    .line 1604
    const-string v0, "class"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "displayName"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->productClass:Ljava/lang/String;

    .line 1605
    const-string v0, "class"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "id"

    const-string v5, "0"

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->productClassId:I

    .line 1607
    :cond_8
    const-string v0, "subclass"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_9

    .line 1608
    const-string v0, "subclass"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "displayName"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->subClass:Ljava/lang/String;

    .line 1609
    const-string v0, "subclass"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "id"

    const-string v5, "0"

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->subClassId:I

    .line 1611
    :cond_9
    const-string v0, "includedItems"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    const-string v4, "name"

    invoke-static {v0, v4}, Lcom/bestbuy/android/api/lib/models/product/Product;->loadKeyValue(Lorg/json/JSONArray;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->includedItemList:Ljava/util/ArrayList;

    .line 1612
    const-string v0, "condition"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->condition:Ljava/lang/String;

    .line 1613
    iget-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->condition:Ljava/lang/String;

    if-eqz v0, :cond_a

    iget-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->condition:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_a

    .line 1614
    iget-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->condition:Ljava/lang/String;

    const-string v4, "refurbished"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1b

    .line 1615
    iput-boolean v8, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->refurbished:Z

    .line 1618
    :goto_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->condition:Ljava/lang/String;

    invoke-virtual {v4, v1, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->condition:Ljava/lang/String;

    invoke-virtual {v4, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->condition:Ljava/lang/String;

    .line 1620
    :cond_a
    const-string v0, "attributes"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_b

    .line 1621
    const-string v0, "attributes"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "energyStarCompatible"

    invoke-virtual {v0, v4, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->energyStarCompatible:Z

    .line 1622
    const-string v0, "attributes"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "lowPriceGuaranteedProduct"

    invoke-virtual {v0, v4, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->lowPriceGuaranteedProduct:Z

    .line 1624
    const-string v0, "attributes"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "smartCapable"

    invoke-virtual {v0, v4, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->smartCapable:Z

    .line 1625
    const-string v0, "attributes"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "wallMountable"

    invoke-virtual {v0, v4, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->wallMountable:Z

    .line 1626
    const-string v0, "attributes"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "newProduct"

    invoke-virtual {v0, v4, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->newProduct:Z

    .line 1627
    const-string v0, "attributes"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "marketplaceProduct"

    invoke-virtual {v0, v4, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->marketPlace:Z

    .line 1628
    const-string v0, "attributes"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "parentalAdvisory"

    invoke-virtual {v0, v4, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->parentalAdvisory:Z

    .line 1631
    :cond_b
    const-string v0, "meta"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_c

    .line 1632
    const-string v0, "meta"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "description"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->description:Ljava/lang/String;

    .line 1633
    const-string v0, "meta"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "title"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->title:Ljava/lang/String;

    .line 1634
    const-string v0, "meta"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "keywords"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->keywords:Ljava/lang/String;

    .line 1637
    :cond_c
    const-string v0, "descriptions"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_d

    .line 1638
    const-string v0, "descriptions"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "short"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->shortDescription:Ljava/lang/String;

    .line 1639
    const-string v0, "descriptions"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "long"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->longDescription:Ljava/lang/String;

    .line 1640
    const-string v0, "descriptions"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "synopsis"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->synopsis:Ljava/lang/String;

    .line 1643
    :cond_d
    const-string v0, "brand"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_e

    .line 1644
    const-string v0, "brand"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "label"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->brandLabel:Ljava/lang/String;

    .line 1645
    const-string v0, "brand"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "brand"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->brandName:Ljava/lang/String;

    .line 1646
    const-string v0, "brand"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "vendor"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->vendor:Ljava/lang/String;

    .line 1647
    const-string v0, "brand"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "publisher"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->publisher:Ljava/lang/String;

    .line 1648
    const-string v0, "brand"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "label"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->label:Ljava/lang/String;

    .line 1650
    :cond_e
    const-string v0, "features"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    if-eqz v0, :cond_f

    .line 1651
    const-string v0, "features"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$Feature;->loadFeaturesData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->productFeatures:Ljava/util/ArrayList;

    .line 1653
    :cond_f
    const-string v0, "dates"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_10

    .line 1654
    const-string v0, "dates"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "streetDate"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->releaseDate:Ljava/lang/String;

    .line 1656
    :cond_10
    const-string v0, "productFamily"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    if-eqz v0, :cond_11

    .line 1657
    const-string v0, "Color"

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->productOptionType:Ljava/lang/String;

    .line 1658
    const-string v0, "productFamily"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "options"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 1659
    if-eqz v0, :cond_11

    .line 1660
    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->loadAlternateSKUData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->colorOptions:Ljava/util/ArrayList;

    .line 1662
    :cond_11
    const-string v0, "productOptions"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_13

    .line 1663
    const-string v0, "productOptions"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "multipleSellers"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    .line 1666
    const-string v0, "Format"

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->productOptionType:Ljava/lang/String;

    .line 1667
    const-string v0, "productOptions"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "alternateProducts"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 1668
    if-eqz v0, :cond_12

    .line 1669
    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->loadAlternateSKUData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->formatOptions:Ljava/util/ArrayList;

    .line 1670
    :cond_12
    const-string v0, "productOptions"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "contractOptions"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 1671
    if-eqz v0, :cond_13

    .line 1672
    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->loadAlternateSKUData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->contractOptions:Ljava/util/ArrayList;

    .line 1675
    :cond_13
    const-string v0, "properties"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_16

    .line 1676
    const-string v0, "properties"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "fileSize"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->fileSize:Ljava/lang/String;

    .line 1677
    const-string v0, "properties"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "chatType"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->chatType:Ljava/lang/String;

    .line 1678
    const-string v0, "properties"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "format"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->format:Ljava/lang/String;

    .line 1679
    const-string v0, "properties"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "freeShippingCode"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->freeShippingCode:Ljava/lang/String;

    .line 1680
    const-string v0, "properties"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "contractCondition"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1681
    const-string v4, "2_YEARS_NEW"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_14

    const-string v4, "2_YEARS_UPGRADE"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_15

    .line 1682
    :cond_14
    iput-boolean v8, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->isContractProduct:Z

    .line 1684
    :cond_15
    const-string v0, "properties"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "primaryArtist"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 1685
    const-string v4, "properties"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "mediaType"

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->mediaType:Ljava/lang/String;

    .line 1686
    if-eqz v0, :cond_16

    .line 1687
    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "displayName"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->artistName:Ljava/lang/String;

    .line 1690
    :cond_16
    const-string v0, "specifications"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    if-eqz v0, :cond_17

    .line 1691
    const-string v0, "specifications"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$Specification;->loadProductSpecificationData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->specifications:Ljava/util/ArrayList;

    .line 1693
    :cond_17
    const-string v0, "breadcrumb"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    if-eqz v0, :cond_18

    .line 1694
    const-string v0, "breadcrumb"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$BreadCrumb;->loadBreadCrumbDetails(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->breadcrumb:Ljava/util/ArrayList;

    .line 1696
    :cond_18
    const-string v0, "customerRatings"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 1697
    if-eqz v0, :cond_19

    .line 1698
    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/product/Review;->loadReviewData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Review;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->review:Lcom/bestbuy/android/api/lib/models/product/Review;

    .line 1699
    const-string v4, "averageRating"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_1c

    .line 1700
    const-string v4, "averageRating"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "score"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewAverage:D

    .line 1701
    const-string v4, "totalCount"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewCount:I

    .line 1707
    :cond_19
    :goto_2
    const-string v0, "media"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->loadCBAPIImageData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->images:Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    .line 1708
    const-string v0, "media"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_1a

    .line 1709
    const-string v0, "media"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;->loadProductVideos(Lorg/json/JSONObject;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->productVideos:Ljava/util/ArrayList;

    .line 1710
    :cond_1a
    const-string v0, "tabs"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 1711
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->tabs:Ljava/util/ArrayList;

    .line 1712
    if-eqz v4, :cond_1d

    move v0, v1

    .line 1713
    :goto_3
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v5

    if-ge v0, v5, :cond_1d

    .line 1714
    iget-object v5, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->tabs:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "id"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1713
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 1617
    :cond_1b
    iput-boolean v1, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->refurbished:Z

    goto/16 :goto_1

    .line 1703
    :cond_1c
    const-wide/16 v4, 0x0

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewAverage:D

    .line 1704
    iput v1, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewCount:I

    goto :goto_2

    .line 1718
    :cond_1d
    const-string v0, "specialFeatures"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 1719
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->specialFeatures:Ljava/util/ArrayList;

    .line 1720
    if-eqz v4, :cond_1e

    move v0, v1

    .line 1721
    :goto_4
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v5

    if-ge v0, v5, :cond_1e

    .line 1722
    iget-object v5, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->specialFeatures:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "value"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1721
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    .line 1726
    :cond_1e
    const-string v0, "protectionPlan"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_1f

    .line 1727
    const-string v0, "protectionPlan"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "displayName"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->protectionPlanName:Ljava/lang/String;

    .line 1728
    const-string v0, "protectionPlan"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "currentPrice"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->protectionPlanPrice:D

    .line 1730
    :cond_1f
    const-string v0, "bundleItems"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    if-eqz v0, :cond_20

    .line 1731
    const-string v0, "bundleItems"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    move v0, v1

    .line 1732
    :goto_5
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v5

    if-ge v0, v5, :cond_20

    .line 1733
    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 1734
    iget-object v6, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->bundledIn:Ljava/util/ArrayList;

    const-string v7, "skuId"

    invoke-virtual {v5, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1732
    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    .line 1737
    :cond_20
    const-string v0, "services"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_21

    .line 1738
    const-string v0, "services"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "blackTieProtection"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_21

    .line 1739
    const-string v0, "services"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "blackTieProtection"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 1740
    const-string v4, "linkToBlackTieProtectionPdpTab"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->geekSquadCertified:Z

    .line 1744
    :cond_21
    const-string v0, "trackInfo"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    if-eqz v0, :cond_22

    .line 1745
    const-string v0, "trackInfo"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "tracks"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 1746
    if-eqz v0, :cond_22

    .line 1747
    :goto_6
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v1, v4, :cond_22

    .line 1748
    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 1749
    iget-object v5, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->songsTrackList:Ljava/util/ArrayList;

    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v7, "displayName"

    invoke-virtual {v4, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const-string v8, "playURL"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v6, v7, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1747
    add-int/lit8 v1, v1, 0x1

    goto :goto_6

    .line 1755
    :cond_22
    const-string v0, "softwareDetails"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_23

    .line 1756
    const-string v0, "softwareDetails"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;->getSoftwareORGameDetailsData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->mSoftwareORGameDetails:Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;

    .line 1759
    :cond_23
    const-string v0, "gameDetails"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_24

    .line 1760
    const-string v0, "gameDetails"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;->getSoftwareORGameDetailsData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->mSoftwareORGameDetails:Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;

    .line 1764
    :cond_24
    const-string v0, "bonusContent"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    if-eqz v0, :cond_25

    .line 1765
    const-string v0, "bonusContent"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$BonusContent;->loadFreeBonusContent(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product;->mFreeBonusContentList:Ljava/util/ArrayList;

    .line 1767
    :cond_25
    return-object v3
.end method

.method public static loadEPData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product;
    .locals 7

    .prologue
    .line 1441
    new-instance v1, Lcom/bestbuy/android/api/lib/models/product/Product;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/product/Product;-><init>()V

    .line 1442
    const-string v0, "id"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->sku:Ljava/lang/String;

    .line 1443
    const-string v0, "name"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->name:Ljava/lang/String;

    .line 1444
    const-string v0, "upc"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->upc:Ljava/lang/String;

    .line 1445
    const-string v0, "productId"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->productId:Ljava/lang/String;

    .line 1446
    const-string v0, "modelNumber"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->modelNumber:Ljava/lang/String;

    .line 1447
    const-string v0, "shortDescription"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->shortDescription:Ljava/lang/String;

    .line 1448
    const-string v0, "url"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->url:Ljava/lang/String;

    .line 1449
    const-string v0, "addToCartUrl"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->addtoCartUrl:Ljava/lang/String;

    .line 1450
    const-string v0, "mobileUrl"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->mobileUrl:Ljava/lang/String;

    .line 1451
    invoke-static {p0}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->loadImageData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->images:Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    .line 1453
    :try_start_0
    const-string v0, "categoryPath"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 1454
    if-eqz v2, :cond_1

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 1456
    iget-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->categories:Ljava/util/ArrayList;

    if-nez v0, :cond_0

    .line 1457
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->categories:Ljava/util/ArrayList;

    .line 1459
    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_1

    .line 1460
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 1461
    const-string v4, "name"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 1462
    const-string v5, "id"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 1463
    iget-object v5, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->categories:Ljava/util/ArrayList;

    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    invoke-direct {v6, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1459
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1466
    :catch_0
    move-exception v0

    .line 1467
    sget-object v2, Lcom/bestbuy/android/api/lib/models/product/Product;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not parse category. "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1469
    :cond_1
    invoke-static {p0}, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/PriceBlock;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->priceBlock:Lcom/bestbuy/android/api/lib/models/product/PriceBlock;

    .line 1470
    const-string v0, "customerReviewAverage"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewAverage:D

    .line 1471
    const-string v0, "customerReviewCount"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewCount:I

    .line 1472
    const-string v0, "active"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product;->active:Z

    .line 1474
    return-object v1
.end method

.method private static loadKeyValue(Lorg/json/JSONArray;Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1781
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1783
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 1785
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 1786
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 1787
    invoke-virtual {v2, p1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1785
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1790
    :cond_0
    return-object v1
.end method

.method public static loadPandaData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product;
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 1500
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Product;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/product/Product;-><init>()V

    .line 1501
    const-string v1, "skuId"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->sku:Ljava/lang/String;

    .line 1502
    const-string v1, "url"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->url:Ljava/lang/String;

    .line 1503
    const-string v1, "names"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "short"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->name:Ljava/lang/String;

    .line 1504
    const-string v1, "productId"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->productId:Ljava/lang/String;

    .line 1505
    const-string v1, "productType"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->productType:Ljava/lang/String;

    .line 1506
    const-string v1, "descriptions"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1507
    const-string v1, "descriptions"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "short"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->shortDescription:Ljava/lang/String;

    .line 1508
    const-string v1, "descriptions"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "long"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->longDescription:Ljava/lang/String;

    .line 1509
    const-string v1, "descriptions"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "synopsis"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->synopsis:Ljava/lang/String;

    .line 1511
    :cond_0
    const-string v1, "meta"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 1512
    const-string v1, "meta"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "description"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->description:Ljava/lang/String;

    .line 1513
    const-string v1, "meta"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "title"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->title:Ljava/lang/String;

    .line 1514
    const-string v1, "meta"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "keywords"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->keywords:Ljava/lang/String;

    .line 1516
    :cond_1
    const-string v1, "customerRatings"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 1517
    if-eqz v1, :cond_7

    const-string v2, "averageRating"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_7

    .line 1518
    const-string v2, "averageRating"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "score"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewAverage:D

    .line 1519
    const-string v2, "totalCount"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    iput v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewCount:I

    .line 1524
    :goto_0
    const-string v1, "properties"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    if-eqz v1, :cond_4

    .line 1525
    const-string v1, "properties"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "contractCondition"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1526
    const-string v2, "2_YEARS_NEW"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string v2, "2_YEARS_UPGRADE"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 1527
    :cond_2
    iput-boolean v5, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->isContractProduct:Z

    .line 1529
    :cond_3
    const-string v1, "properties"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "freeShippingCode"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->freeShippingCode:Ljava/lang/String;

    .line 1531
    :cond_4
    const-string v1, "attributes"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 1532
    if-eqz v1, :cond_5

    .line 1534
    const-string v2, "marketplaceProduct"

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->marketPlace:Z

    .line 1535
    const-string v2, "outletCenterProduct"

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->outletCenter:Z

    .line 1536
    const-string v2, "lowPriceGuaranteedProduct"

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->lowPriceGuarantee:Z

    .line 1537
    const-string v2, "onlineOnly"

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->onlineOnly:Z

    .line 1538
    const-string v2, "smartCapable"

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->smartCapable:Z

    .line 1540
    :cond_5
    const-string v1, "condition"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 1541
    const-string v1, "condition"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1542
    const-string v2, "refurbished"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 1543
    iput-boolean v5, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->refurbished:Z

    .line 1547
    :cond_6
    :goto_1
    const-string v1, "media"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    invoke-static {v1}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->loadPandaAPIImageData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->images:Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    .line 1549
    return-object v0

    .line 1521
    :cond_7
    const-wide/16 v2, 0x0

    iput-wide v2, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewAverage:D

    .line 1522
    iput v4, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewCount:I

    goto/16 :goto_0

    .line 1545
    :cond_8
    iput-boolean v4, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->refurbished:Z

    goto :goto_1
.end method

.method public static loadSolrData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product;
    .locals 4

    .prologue
    .line 1484
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Product;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/product/Product;-><init>()V

    .line 1485
    const-string v1, "skuid"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->sku:Ljava/lang/String;

    .line 1486
    const-string v1, "title"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->name:Ljava/lang/String;

    .line 1487
    invoke-static {p0}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->loadImageData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->images:Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    .line 1488
    const-string v1, "customerrating"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewAverage:D

    .line 1489
    const-string v1, "numberofreviews"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    iput v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewCount:I

    .line 1490
    return-object v0
.end method


# virtual methods
.method public getAccessories()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 575
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->accessories:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getAccessoriesList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1111
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->mAccessoriesList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getActiveUpdateDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 699
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->activeUpdateDate:Ljava/util/Date;

    return-object v0
.end method

.method public getAdditionalFeatures()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 951
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->additionalFeatures:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getAddtoCartUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 863
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->addtoCartUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getAffiliateAddToCartUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 867
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->affiliateAddToCartUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getAffilliateUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 851
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->affilliateUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getAlbumLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 875
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->albumLabel:Ljava/lang/String;

    return-object v0
.end method

.method public getAlbumTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 879
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->albumTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getAlternateSkus()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;",
            ">;"
        }
    .end annotation

    .prologue
    .line 402
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->alternateSkus:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getArtistName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 883
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->artistName:Ljava/lang/String;

    return-object v0
.end method

.method public getAspectRatio()Ljava/lang/String;
    .locals 1

    .prologue
    .line 907
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->aspectRatio:Ljava/lang/String;

    return-object v0
.end method

.method public getAvailableStoreId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 351
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->availableStoreId:Ljava/lang/String;

    return-object v0
.end method

.method public getBbyProduct()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;
    .locals 1

    .prologue
    .line 343
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->bbyProduct:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    return-object v0
.end method

.method public getBestBuyItemId()D
    .locals 2

    .prologue
    .line 511
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->bestBuyItemId:D

    return-wide v0
.end method

.method public getBestSellingRank()I
    .locals 1

    .prologue
    .line 615
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->bestSellingRank:I

    return v0
.end method

.method public getBrandLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1015
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->brandLabel:Ljava/lang/String;

    return-object v0
.end method

.method public getBrandName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1027
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->brandName:Ljava/lang/String;

    return-object v0
.end method

.method public getBreadcrumb()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$BreadCrumb;",
            ">;"
        }
    .end annotation

    .prologue
    .line 335
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->breadcrumb:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getBundleItemCount()I
    .locals 1

    .prologue
    .line 367
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->bundleItemCount:I

    return v0
.end method

.method public getBundledIn()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 563
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->bundledIn:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getBuybackPlans()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 587
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->buybackPlans:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCast()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 911
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->cast:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCategories()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;"
        }
    .end annotation

    .prologue
    .line 567
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->categories:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCategoryID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 495
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->categoryID:Ljava/lang/String;

    return-object v0
.end method

.method public getChatType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1043
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->chatType:Ljava/lang/String;

    return-object v0
.end method

.method public getCjAffiliateAddToCartUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 859
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->cjAffiliateAddToCartUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getCjAffiliateUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 855
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->cjAffiliateUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getColor()Ljava/lang/String;
    .locals 1

    .prologue
    .line 719
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->colorName:Ljava/lang/String;

    return-object v0
.end method

.method public getColorId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 723
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->colorId:Ljava/lang/String;

    return-object v0
.end method

.method public getColorName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 391
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->colorName:Ljava/lang/String;

    return-object v0
.end method

.method public getColorOptions()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1063
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->colorOptions:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 647
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->condition:Ljava/lang/String;

    return-object v0
.end method

.method public getContractOptions()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1075
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->contractOptions:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCrew()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 915
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->crew:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCustomerReviewAverage()D
    .locals 2

    .prologue
    .line 631
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewAverage:D

    return-wide v0
.end method

.method public getCustomerReviewCount()I
    .locals 1

    .prologue
    .line 635
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewCount:I

    return v0
.end method

.method public getDepartment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 639
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->department:Ljava/lang/String;

    return-object v0
.end method

.method public getDepartmentId()I
    .locals 1

    .prologue
    .line 651
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->departmentId:I

    return v0
.end method

.method public getDepth()Ljava/lang/String;
    .locals 1

    .prologue
    .line 727
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->depth:Ljava/lang/String;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 523
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getDetails()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;"
        }
    .end annotation

    .prologue
    .line 543
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->details:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getEpValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 387
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->epValue:Ljava/lang/String;

    return-object v0
.end method

.method public getErbRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 975
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->erbRating:Ljava/lang/String;

    return-object v0
.end method

.method public getFeatures()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 551
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->features:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getFileSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 422
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->fileSize:Ljava/lang/String;

    return-object v0
.end method

.method public getFormat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 655
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->format:Ljava/lang/String;

    return-object v0
.end method

.method public getFormatOptions()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1067
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->formatOptions:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getFreeBonusContentList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$BonusContent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1123
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->mFreeBonusContentList:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    .line 1124
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->mFreeBonusContentList:Ljava/util/ArrayList;

    .line 1126
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->mFreeBonusContentList:Ljava/util/ArrayList;

    goto :goto_0
.end method

.method public getFreeShippingCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1047
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->freeShippingCode:Ljava/lang/String;

    return-object v0
.end method

.method public getFulfilledBy()Ljava/lang/String;
    .locals 1

    .prologue
    .line 835
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->fulfilledBy:Ljava/lang/String;

    return-object v0
.end method

.method public getGenre()Ljava/lang/String;
    .locals 1

    .prologue
    .line 887
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->genre:Ljava/lang/String;

    return-object v0
.end method

.method public getHeight()Ljava/lang/String;
    .locals 1

    .prologue
    .line 731
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->height:Ljava/lang/String;

    return-object v0
.end method

.method public getImages()Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;
    .locals 1

    .prologue
    .line 611
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->images:Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    return-object v0
.end method

.method public getInStoreAvailabilityText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 771
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->inStoreAvailabilityText:Ljava/lang/String;

    return-object v0
.end method

.method public getInStoreAvailabilityTextHtml()Ljava/lang/String;
    .locals 1

    .prologue
    .line 775
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->inStoreAvailabilityTextHtml:Ljava/lang/String;

    return-object v0
.end method

.method public getInStoreAvailabilityUpdateDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 767
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->inStoreAvailabilityUpdateDate:Ljava/util/Date;

    return-object v0
.end method

.method public getIncludedItemList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 579
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->includedItemList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getItemUpdateDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 703
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->itemUpdateDate:Ljava/util/Date;

    return-object v0
.end method

.method public getKeywords()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1023
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->keywords:Ljava/lang/String;

    return-object v0
.end method

.method public getLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 406
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->label:Ljava/lang/String;

    return-object v0
.end method

.method public getLengthInMinutes()I
    .locals 1

    .prologue
    .line 919
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->lengthInMinutes:I

    return v0
.end method

.method public getListingId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 831
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->listingId:Ljava/lang/String;

    return-object v0
.end method

.method public getLongDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 535
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->longDescription:Ljava/lang/String;

    return-object v0
.end method

.method public getLongDescriptionHtml()Ljava/lang/String;
    .locals 1

    .prologue
    .line 539
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->longDescriptionHtml:Ljava/lang/String;

    return-object v0
.end method

.method public getManufacturer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 659
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->manufacturer:Ljava/lang/String;

    return-object v0
.end method

.method public getMediaType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 410
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->mediaType:Ljava/lang/String;

    return-object v0
.end method

.method public getMembers()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 571
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->members:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getMobileUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 871
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->mobileUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getModelNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 507
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->modelNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getMonoStereo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 903
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->monoStereo:Ljava/lang/String;

    return-object v0
.end method

.method public getMovieCastCrewList()Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;
    .locals 1

    .prologue
    .line 1087
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->movieCastCrewList:Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;

    return-object v0
.end method

.method public getMovieDetailsList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Details;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1079
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->movieDetailsList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getMovieRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 979
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->movieRating:Ljava/lang/String;

    return-object v0
.end method

.method public getMovieUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 983
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->movieUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getMpaaRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 923
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->mpaaRating:Ljava/lang/String;

    return-object v0
.end method

.method public getMusicDetailsList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Details;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1095
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->musicDetailsList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 487
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getNumberOfPlayers()Ljava/lang/String;
    .locals 1

    .prologue
    .line 987
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->numberOfPlayers:Ljava/lang/String;

    return-object v0
.end method

.method public getOffers()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 559
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->offers:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getOnlineAvailabilityText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 783
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->onlineAvailabilityText:Ljava/lang/String;

    return-object v0
.end method

.method public getOnlineAvailabilityTextHtml()Ljava/lang/String;
    .locals 1

    .prologue
    .line 787
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->onlineAvailabilityTextHtml:Ljava/lang/String;

    return-object v0
.end method

.method public getOnlineAvailabilityUpdateDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 779
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->onlineAvailabilityUpdateDate:Ljava/util/Date;

    return-object v0
.end method

.method public getOrderable()Ljava/lang/String;
    .locals 1

    .prologue
    .line 454
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->orderable:Ljava/lang/String;

    return-object v0
.end method

.method public getOriginalReleaseDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 891
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->originalReleaseDate:Ljava/util/Date;

    return-object v0
.end method

.method public getPlatform()Ljava/lang/String;
    .locals 1

    .prologue
    .line 971
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->platform:Ljava/lang/String;

    return-object v0
.end method

.method public getPlot()Ljava/lang/String;
    .locals 1

    .prologue
    .line 927
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->plot:Ljava/lang/String;

    return-object v0
.end method

.method public getPlotHtml()Ljava/lang/String;
    .locals 1

    .prologue
    .line 931
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->plotHtml:Ljava/lang/String;

    return-object v0
.end method

.method public getPriceBlock()Lcom/bestbuy/android/api/lib/models/product/PriceBlock;
    .locals 1

    .prologue
    .line 515
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->priceBlock:Lcom/bestbuy/android/api/lib/models/product/PriceBlock;

    return-object v0
.end method

.method public getProdBlock()Lcom/bestbuy/android/api/lib/models/product/ProductBlock;
    .locals 1

    .prologue
    .line 1115
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->prodBlock:Lcom/bestbuy/android/api/lib/models/product/ProductBlock;

    return-object v0
.end method

.method public getProductClass()Ljava/lang/String;
    .locals 1

    .prologue
    .line 675
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->productClass:Ljava/lang/String;

    return-object v0
.end method

.method public getProductClassId()I
    .locals 1

    .prologue
    .line 679
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->productClassId:I

    return v0
.end method

.method public getProductFeatures()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Feature;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1031
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->productFeatures:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 503
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->productId:Ljava/lang/String;

    return-object v0
.end method

.method public getProductOptionType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 430
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->productOptionType:Ljava/lang/String;

    return-object v0
.end method

.method public getProductSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;
    .locals 1

    .prologue
    .line 359
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->productSummary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    return-object v0
.end method

.method public getProductTemplate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 671
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->productTemplate:Ljava/lang/String;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 995
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getProductVideos()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;",
            ">;"
        }
    .end annotation

    .prologue
    .line 363
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->productVideos:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getProtectionPlanDetails()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 599
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->protectionPlanDetails:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getProtectionPlanHighPrice()D
    .locals 2

    .prologue
    .line 603
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->protectionPlanHighPrice:D

    return-wide v0
.end method

.method public getProtectionPlanLowPrice()D
    .locals 2

    .prologue
    .line 607
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->protectionPlanLowPrice:D

    return-wide v0
.end method

.method public getProtectionPlanName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1055
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->protectionPlanName:Ljava/lang/String;

    return-object v0
.end method

.method public getProtectionPlanPrice()D
    .locals 2

    .prologue
    .line 1059
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->protectionPlanPrice:D

    return-wide v0
.end method

.method public getProtectionPlans()Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;
    .locals 1

    .prologue
    .line 591
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->protectionPlans:Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;

    return-object v0
.end method

.method public getPublisher()Ljava/lang/String;
    .locals 1

    .prologue
    .line 418
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->publisher:Ljava/lang/String;

    return-object v0
.end method

.method public getQuantityLimit()I
    .locals 1

    .prologue
    .line 707
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->quantityLimit:I

    return v0
.end method

.method public getRelatedProducts()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 583
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->relatedProducts:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getReleaseDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 715
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->releaseDate:Ljava/lang/String;

    return-object v0
.end method

.method public getReview()Lcom/bestbuy/android/api/lib/models/product/Review;
    .locals 1

    .prologue
    .line 1051
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->review:Lcom/bestbuy/android/api/lib/models/product/Review;

    return-object v0
.end method

.method public getSalesRankLongTerm()I
    .locals 1

    .prologue
    .line 619
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->salesRankLongTerm:I

    return v0
.end method

.method public getSalesRankMediumTerm()I
    .locals 1

    .prologue
    .line 623
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->salesRankMediumTerm:I

    return v0
.end method

.method public getSalesRankShortTerm()I
    .locals 1

    .prologue
    .line 627
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->salesRankShortTerm:I

    return v0
.end method

.method public getSellerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 823
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->sellerId:Ljava/lang/String;

    return-object v0
.end method

.method public getShippingCost()D
    .locals 2

    .prologue
    .line 799
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->shippingCost:D

    return-wide v0
.end method

.method public getShippingRestrictions()Ljava/lang/String;
    .locals 1

    .prologue
    .line 795
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->shippingRestrictions:Ljava/lang/String;

    return-object v0
.end method

.method public getShippingWeight()Ljava/lang/String;
    .locals 1

    .prologue
    .line 791
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->shippingWeight:Ljava/lang/String;

    return-object v0
.end method

.method public getShipping_ground()D
    .locals 2

    .prologue
    .line 815
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->shipping_ground:D

    return-wide v0
.end method

.method public getShipping_nextDay()D
    .locals 2

    .prologue
    .line 803
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->shipping_nextDay:D

    return-wide v0
.end method

.method public getShipping_secondDay()D
    .locals 2

    .prologue
    .line 807
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->shipping_secondDay:D

    return-wide v0
.end method

.method public getShipping_vendorDelivery()D
    .locals 2

    .prologue
    .line 811
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->shipping_vendorDelivery:D

    return-wide v0
.end method

.method public getShortDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 527
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->shortDescription:Ljava/lang/String;

    return-object v0
.end method

.method public getShortDescriptionHtml()Ljava/lang/String;
    .locals 1

    .prologue
    .line 531
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->shortDescriptionHtml:Ljava/lang/String;

    return-object v0
.end method

.method public getSku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 483
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->sku:Ljava/lang/String;

    return-object v0
.end method

.method public getSoftwareAge()Ljava/lang/String;
    .locals 1

    .prologue
    .line 967
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->softwareAge:Ljava/lang/String;

    return-object v0
.end method

.method public getSoftwareGrade()Ljava/lang/String;
    .locals 1

    .prologue
    .line 959
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->softwareGrade:Ljava/lang/String;

    return-object v0
.end method

.method public getSoftwareNumberOfPlayers()Ljava/lang/String;
    .locals 1

    .prologue
    .line 963
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->softwareNumberOfPlayers:Ljava/lang/String;

    return-object v0
.end method

.method public getSoftwareORGameDetails()Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;
    .locals 1

    .prologue
    .line 1103
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->mSoftwareORGameDetails:Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;

    return-object v0
.end method

.method public getSongsTrackList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;"
        }
    .end annotation

    .prologue
    .line 547
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->songsTrackList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getSource()Ljava/lang/String;
    .locals 1

    .prologue
    .line 827
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->source:Ljava/lang/String;

    return-object v0
.end method

.method public getSpecialFeatures()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 478
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->specialFeatures:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getSpecifications()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Specification;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1039
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->specifications:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getStartDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 711
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->startDate:Ljava/util/Date;

    return-object v0
.end method

.method public getStudio()Ljava/lang/String;
    .locals 1

    .prologue
    .line 935
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->studio:Ljava/lang/String;

    return-object v0
.end method

.method public getStudioLive()Ljava/lang/String;
    .locals 1

    .prologue
    .line 899
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->studioLive:Ljava/lang/String;

    return-object v0
.end method

.method public getSubClass()Ljava/lang/String;
    .locals 1

    .prologue
    .line 663
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->subClass:Ljava/lang/String;

    return-object v0
.end method

.method public getSubClassId()I
    .locals 1

    .prologue
    .line 667
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->subClassId:I

    return v0
.end method

.method public getSubtitleLanguages()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 943
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->subtitleLanguages:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getSynopsis()Ljava/lang/String;
    .locals 1

    .prologue
    .line 466
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->synopsis:Ljava/lang/String;

    return-object v0
.end method

.method public getTabs()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 474
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->tabs:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTheatricalReleaseDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 939
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->theatricalReleaseDate:Ljava/util/Date;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1019
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getTradeInValue()D
    .locals 2

    .prologue
    .line 991
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->tradeInValue:D

    return-wide v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 643
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getUpc()Ljava/lang/String;
    .locals 1

    .prologue
    .line 499
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->upc:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 847
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getVendor()Ljava/lang/String;
    .locals 1

    .prologue
    .line 414
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->vendor:Ljava/lang/String;

    return-object v0
.end method

.method public getVideoLanguages()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 947
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->videoLanguages:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getWarrantyLabor()Ljava/lang/String;
    .locals 1

    .prologue
    .line 843
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->warrantyLabor:Ljava/lang/String;

    return-object v0
.end method

.method public getWarrantyParts()Ljava/lang/String;
    .locals 1

    .prologue
    .line 839
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->warrantyParts:Ljava/lang/String;

    return-object v0
.end method

.method public getWeight()Ljava/lang/String;
    .locals 1

    .prologue
    .line 739
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->weight:Ljava/lang/String;

    return-object v0
.end method

.method public getWidth()Ljava/lang/String;
    .locals 1

    .prologue
    .line 735
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->width:Ljava/lang/String;

    return-object v0
.end method

.method public getmAccessoriesList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product;",
            ">;"
        }
    .end annotation

    .prologue
    .line 399
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->mAccessoriesList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getmSoftwareORGameDetails()Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;
    .locals 1

    .prologue
    .line 395
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->mSoftwareORGameDetails:Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;

    return-object v0
.end method

.method public isActive()Z
    .locals 1

    .prologue
    .line 695
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->active:Z

    return v0
.end method

.method public isActiveSku()Z
    .locals 1

    .prologue
    .line 379
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->isActiveSku:Z

    return v0
.end method

.method public isClearance()Z
    .locals 1

    .prologue
    .line 462
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->clearance:Z

    return v0
.end method

.method public isContractProduct()Z
    .locals 1

    .prologue
    .line 426
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->isContractProduct:Z

    return v0
.end method

.method public isDigital()Z
    .locals 1

    .prologue
    .line 691
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->digital:Z

    return v0
.end method

.method public isEnergyStarCompatible()Z
    .locals 1

    .prologue
    .line 999
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->energyStarCompatible:Z

    return v0
.end method

.method public isFreeShipping()Z
    .locals 1

    .prologue
    .line 450
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->freeShipping:Z

    return v0
.end method

.method public isFriendsAndFamilyPickup()Z
    .locals 1

    .prologue
    .line 759
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->friendsAndFamilyPickup:Z

    return v0
.end method

.method public isGeekSquadCertified()Z
    .locals 1

    .prologue
    .line 470
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->geekSquadCertified:Z

    return v0
.end method

.method public isHomeDelivery()Z
    .locals 1

    .prologue
    .line 755
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->homeDelivery:Z

    return v0
.end method

.method public isInStoreAvailability()Z
    .locals 1

    .prologue
    .line 743
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->inStoreAvailability:Z

    return v0
.end method

.method public isInStorePickup()Z
    .locals 1

    .prologue
    .line 751
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->inStorePickup:Z

    return v0
.end method

.method public isLowPriceGuarantee()Z
    .locals 1

    .prologue
    .line 446
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->lowPriceGuarantee:Z

    return v0
.end method

.method public isLowPriceGuaranteedProduct()Z
    .locals 1

    .prologue
    .line 1003
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->lowPriceGuaranteedProduct:Z

    return v0
.end method

.method public isMarketPlace()Z
    .locals 1

    .prologue
    .line 438
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->marketPlace:Z

    return v0
.end method

.method public isNewProduct()Z
    .locals 1

    .prologue
    .line 683
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->newProduct:Z

    return v0
.end method

.method public isOnlineAvailability()Z
    .locals 1

    .prologue
    .line 747
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->onlineAvailability:Z

    return v0
.end method

.method public isOnlineOnly()Z
    .locals 1

    .prologue
    .line 458
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->onlineOnly:Z

    return v0
.end method

.method public isOnlinePlay()Z
    .locals 1

    .prologue
    .line 955
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->onlinePlay:Z

    return v0
.end method

.method public isOutletCenter()Z
    .locals 1

    .prologue
    .line 442
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->outletCenter:Z

    return v0
.end method

.method public isParentalAdvisory()Z
    .locals 1

    .prologue
    .line 895
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->parentalAdvisory:Z

    return v0
.end method

.method public isPreowned()Z
    .locals 1

    .prologue
    .line 687
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->preowned:Z

    return v0
.end method

.method public isRefurbished()Z
    .locals 1

    .prologue
    .line 434
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->refurbished:Z

    return v0
.end method

.method public isSecondaryMarket()Z
    .locals 1

    .prologue
    .line 819
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->secondaryMarket:Z

    return v0
.end method

.method public isSmartCapable()Z
    .locals 1

    .prologue
    .line 1007
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->smartCapable:Z

    return v0
.end method

.method public isSpecialOrder()Z
    .locals 1

    .prologue
    .line 763
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->specialOrder:Z

    return v0
.end method

.method public isWallMountable()Z
    .locals 1

    .prologue
    .line 1011
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->wallMountable:Z

    return v0
.end method

.method public setAccessoriesList(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1107
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->mAccessoriesList:Ljava/util/ArrayList;

    .line 1108
    return-void
.end method

.method public setActiveSku(Z)V
    .locals 0

    .prologue
    .line 375
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->isActiveSku:Z

    .line 376
    return-void
.end method

.method public setAvailableStoreId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 355
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->availableStoreId:Ljava/lang/String;

    .line 356
    return-void
.end method

.method public setBbyProduct(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V
    .locals 0

    .prologue
    .line 347
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->bbyProduct:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 348
    return-void
.end method

.method public setBreadcrumb(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$BreadCrumb;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 339
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->breadcrumb:Ljava/util/ArrayList;

    .line 340
    return-void
.end method

.method public setBundleItemCount(I)V
    .locals 0

    .prologue
    .line 371
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->bundleItemCount:I

    .line 372
    return-void
.end method

.method public setCategoryID(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 491
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->categoryID:Ljava/lang/String;

    .line 492
    return-void
.end method

.method public setEpValue(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 383
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->epValue:Ljava/lang/String;

    .line 384
    return-void
.end method

.method public setFormatOptions(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1071
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->formatOptions:Ljava/util/ArrayList;

    .line 1072
    return-void
.end method

.method public setMovieCastCrewList(Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;)V
    .locals 0

    .prologue
    .line 1091
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->movieCastCrewList:Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;

    .line 1092
    return-void
.end method

.method public setMovieDetailsList(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Details;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1083
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->movieDetailsList:Ljava/util/ArrayList;

    .line 1084
    return-void
.end method

.method public setMusicDetailsList(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Details;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1099
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->musicDetailsList:Ljava/util/ArrayList;

    .line 1100
    return-void
.end method

.method public setPriceBlock(Lcom/bestbuy/android/api/lib/models/product/PriceBlock;)V
    .locals 0

    .prologue
    .line 519
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->priceBlock:Lcom/bestbuy/android/api/lib/models/product/PriceBlock;

    .line 520
    return-void
.end method

.method public setProdBlock(Lcom/bestbuy/android/api/lib/models/product/ProductBlock;)V
    .locals 0

    .prologue
    .line 1119
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->prodBlock:Lcom/bestbuy/android/api/lib/models/product/ProductBlock;

    .line 1120
    return-void
.end method

.method public setProtectionPlans(Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;)V
    .locals 0

    .prologue
    .line 595
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product;->protectionPlans:Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;

    .line 596
    return-void
.end method
