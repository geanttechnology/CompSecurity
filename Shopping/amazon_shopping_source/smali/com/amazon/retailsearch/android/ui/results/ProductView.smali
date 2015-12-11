.class public abstract Lcom/amazon/retailsearch/android/ui/results/ProductView;
.super Landroid/widget/FrameLayout;
.source "ProductView.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/listadapter/ModelView;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/ProductView$1;,
        Lcom/amazon/retailsearch/android/ui/results/ProductView$SwipeListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/FrameLayout;",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ModelView",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;",
        ">;"
    }
.end annotation


# static fields
.field private static final EDITIONS_TYPE_DIGITAL_VIDEO:Ljava/lang/String; = "digital_video"

.field protected static final LINE_SEPARATOR:Ljava/lang/String;

.field protected static final MAX_EDITIONS:I = 0x3


# instance fields
.field protected availabilityInfo:Lcom/amazon/searchapp/retailsearch/model/Availability;

.field private bestSeller:Lcom/amazon/retailsearch/android/ui/results/views/BestSeller;

.field private editionLine:Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLine;

.field private freeRentalLine:Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLine;

.field protected gestureDetector:Landroid/view/GestureDetector;

.field protected gestureListener:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;

.field private imageWrapper:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

.field protected isSponsoredPrice:Z

.field protected mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

.field private offersLine:Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;

.field private price:Lcom/amazon/retailsearch/android/ui/results/views/price/Price;

.field protected product:Lcom/amazon/searchapp/retailsearch/model/Product;

.field protected productImageFactory:Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

.field protected ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

.field private ratingsLine:Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;

.field protected resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

.field protected shippingInfo:Lcom/amazon/searchapp/retailsearch/model/Shipping;

.field private subscribeAndSave:Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;

.field protected subscribeAndSavePrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

.field protected swipeDetector:Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;

.field protected swiped:Z

.field protected thumbSwitcher:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

.field private title:Landroid/widget/TextView;

.field protected twister:Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;

.field protected useEditionsPricing:Z

.field userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field protected viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 74
    const-string/jumbo v0, "line.separator"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->LINE_SEPARATOR:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 104
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 105
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->init(Landroid/content/Context;)V

    .line 106
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 110
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 111
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->init(Landroid/content/Context;)V

    .line 112
    return-void
.end method

.method private getAvailabilityInfo()Lcom/amazon/searchapp/retailsearch/model/Availability;
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 389
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    if-nez v1, :cond_1

    .line 401
    :cond_0
    :goto_0
    return-object v0

    .line 393
    :cond_1
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Product;->getAvailability()Lcom/amazon/searchapp/retailsearch/model/Availability;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 395
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Product;->getAvailability()Lcom/amazon/searchapp/retailsearch/model/Availability;

    move-result-object v0

    goto :goto_0

    .line 397
    :cond_2
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    if-eqz v1, :cond_0

    .line 399
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getAvailability()Lcom/amazon/searchapp/retailsearch/model/Availability;

    move-result-object v0

    goto :goto_0
.end method

.method private getMainPrice()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 345
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    if-nez v2, :cond_1

    .line 381
    :cond_0
    :goto_0
    return-object v1

    .line 350
    :cond_1
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Product;->getPrices()Lcom/amazon/searchapp/retailsearch/model/Prices;

    move-result-object v0

    .line 351
    .local v0, "prices":Lcom/amazon/searchapp/retailsearch/model/Prices;
    if-eqz v0, :cond_0

    .line 356
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getBuy()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 358
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getBuy()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v1

    goto :goto_0

    .line 361
    :cond_2
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getEditions()Ljava/util/List;

    move-result-object v2

    if-eqz v2, :cond_3

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getEditions()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_3

    .line 363
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getEditions()Ljava/util/List;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;

    invoke-static {v1}, Lcom/amazon/retailsearch/data/EditionsPriceInfoUtil;->toPriceInfo(Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;)Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v1

    goto :goto_0

    .line 366
    :cond_3
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getDigital()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v2

    if-eqz v2, :cond_4

    .line 368
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getDigital()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v1

    goto :goto_0

    .line 371
    :cond_4
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getRental()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v2

    if-eqz v2, :cond_5

    .line 373
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getRental()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v1

    goto :goto_0

    .line 376
    :cond_5
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getSponsored()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 378
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getSponsored()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v1

    goto :goto_0
.end method

.method private isDigitalVideoEditionsType(Lcom/amazon/searchapp/retailsearch/model/Prices;)Z
    .locals 2
    .param p1, "prices"    # Lcom/amazon/searchapp/retailsearch/model/Prices;

    .prologue
    .line 409
    if-eqz p1, :cond_0

    const-string/jumbo v0, "digital_video"

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getEditionsType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public build(Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;)V
    .locals 10
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;

    .prologue
    const/4 v7, 0x0

    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 153
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;->getProduct()Lcom/amazon/searchapp/retailsearch/model/Product;

    move-result-object v4

    if-nez v4, :cond_2

    .line 155
    :cond_0
    const/16 v4, 0x8

    invoke-virtual {p0, v4}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->setVisibility(I)V

    .line 215
    :cond_1
    :goto_0
    return-void

    .line 159
    :cond_2
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;->getProduct()Lcom/amazon/searchapp/retailsearch/model/Product;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    .line 160
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;->getProductImageFactory()Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->productImageFactory:Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    .line 161
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;->getResourceProvider()Lcom/amazon/ansel/fetch/ResourceProvider;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    .line 163
    const/4 v3, 0x0

    .line 165
    .local v3, "url":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Product;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v4

    if-eqz v4, :cond_3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Product;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 167
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Product;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v3

    .line 170
    :cond_3
    new-instance v4, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem$Builder;

    invoke-direct {v4}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem$Builder;-><init>()V

    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v8}, Lcom/amazon/searchapp/retailsearch/model/Product;->getAsin()Ljava/lang/String;

    move-result-object v8

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v9}, Lcom/amazon/searchapp/retailsearch/model/Product;->getGroup()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v4, v8, v3, v9}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem$Builder;->build(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    move-result-object v1

    .line 173
    .local v1, "resultItem":Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->gestureListener:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;

    invoke-virtual {v4, v1}, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->setResultItem(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;)V

    .line 175
    iput-boolean v6, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->swiped:Z

    .line 177
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Product;->getShipping()Lcom/amazon/searchapp/retailsearch/model/Shipping;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->shippingInfo:Lcom/amazon/searchapp/retailsearch/model/Shipping;

    .line 181
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->getMainPrice()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 182
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Product;->getPrices()Lcom/amazon/searchapp/retailsearch/model/Prices;

    move-result-object v0

    .line 186
    .local v0, "prices":Lcom/amazon/searchapp/retailsearch/model/Prices;
    if-eqz v0, :cond_7

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getDigital()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v4

    if-nez v4, :cond_4

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->isDigitalVideoEditionsType(Lcom/amazon/searchapp/retailsearch/model/Prices;)Z

    move-result v4

    if-eqz v4, :cond_7

    :cond_4
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getEditions()Ljava/util/List;

    move-result-object v4

    if-eqz v4, :cond_7

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getEditions()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_7

    move v4, v5

    :goto_1
    iput-boolean v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->useEditionsPricing:Z

    .line 190
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->getAvailabilityInfo()Lcom/amazon/searchapp/retailsearch/model/Availability;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->availabilityInfo:Lcom/amazon/searchapp/retailsearch/model/Availability;

    .line 191
    if-eqz v0, :cond_8

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getSponsored()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v2

    .line 192
    .local v2, "sponsoredPrice":Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    :goto_2
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    if-eqz v4, :cond_9

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    if-ne v4, v2, :cond_9

    :goto_3
    iput-boolean v5, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->isSponsoredPrice:Z

    .line 193
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Product;->getRatings()Lcom/amazon/searchapp/retailsearch/model/Ratings;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

    .line 195
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

    if-nez v4, :cond_5

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    if-eqz v4, :cond_5

    .line 197
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getRatings()Lcom/amazon/searchapp/retailsearch/model/Ratings;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

    .line 202
    :cond_5
    iput-object v7, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->subscribeAndSavePrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 204
    if-eqz v0, :cond_6

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getSubscribeAndSave()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v4

    if-eqz v4, :cond_6

    .line 206
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getSubscribeAndSave()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->subscribeAndSavePrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 209
    :cond_6
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->buildView()V

    .line 211
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->imageWrapper:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    if-eqz v4, :cond_1

    .line 213
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->imageWrapper:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    invoke-virtual {v5}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->getImageView()Landroid/widget/ImageView;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v6}, Lcom/amazon/searchapp/retailsearch/model/Product;->getAsin()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, p0, v5, v6}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->resultItemBuilt(Landroid/view/ViewGroup;Landroid/widget/ImageView;Ljava/lang/String;)V

    goto/16 :goto_0

    .end local v2    # "sponsoredPrice":Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    :cond_7
    move v4, v6

    .line 186
    goto :goto_1

    :cond_8
    move-object v2, v7

    .line 191
    goto :goto_2

    .restart local v2    # "sponsoredPrice":Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    :cond_9
    move v5, v6

    .line 192
    goto :goto_3
.end method

.method public bridge synthetic build(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 61
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->build(Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;)V

    return-void
.end method

.method protected buildView()V
    .locals 19

    .prologue
    .line 219
    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;

    invoke-direct {v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;-><init>()V

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Product;->getAsin()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Product;->getTitle()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Product;->getImage()Lcom/amazon/searchapp/retailsearch/model/Image;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v8}, Lcom/amazon/searchapp/retailsearch/model/Product;->getAltImages()Ljava/util/List;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->imageWrapper:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    invoke-virtual {v8}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->hasThumbSwitcher()Z

    move-result v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->productImageFactory:Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    invoke-virtual/range {v1 .. v8}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->build(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/model/Image;Ljava/util/List;ZLcom/amazon/retailsearch/android/ui/ImageRequestFactory;Lcom/amazon/ansel/fetch/ResourceProvider;)Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;

    move-result-object v13

    .line 229
    .local v13, "imageWrapperModel":Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->imageWrapper:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v1, v13, v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 231
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Product;->getTitle()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_7

    .line 233
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->title:Landroid/widget/TextView;

    const-string/jumbo v3, ""

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 241
    :goto_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->editionLine:Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLine;

    if-eqz v1, :cond_0

    .line 243
    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel$Builder;

    invoke-direct {v1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel$Builder;-><init>()V

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-object/from16 v0, p0

    iget-boolean v4, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->useEditionsPricing:Z

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v8}, Lcom/amazon/searchapp/retailsearch/model/Product;->getTypeName()Ljava/lang/String;

    move-result-object v8

    move-object/from16 v0, p0

    iget-boolean v9, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->isSponsoredPrice:Z

    invoke-virtual {v1, v3, v4, v8, v9}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;ZLjava/lang/String;Z)Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;

    move-result-object v11

    .line 245
    .local v11, "editionLineModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->editionLine:Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLine;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v1, v11, v3}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLine;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 248
    .end local v11    # "editionLineModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;
    :cond_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Product;->getPrices()Lcom/amazon/searchapp/retailsearch/model/Prices;

    move-result-object v2

    .line 251
    .local v2, "prices":Lcom/amazon/searchapp/retailsearch/model/Prices;
    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;

    invoke-direct {v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;-><init>()V

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->shippingInfo:Lcom/amazon/searchapp/retailsearch/model/Shipping;

    move-object/from16 v0, p0

    iget-boolean v5, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->useEditionsPricing:Z

    move-object/from16 v0, p0

    iget-boolean v6, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->isSponsoredPrice:Z

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->price:Lcom/amazon/retailsearch/android/ui/results/views/price/Price;

    invoke-virtual {v8}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->getShowListPrice()Z

    move-result v7

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->price:Lcom/amazon/retailsearch/android/ui/results/views/price/Price;

    invoke-virtual {v8}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->getShowSomePrime()Z

    move-result v8

    invoke-virtual/range {v1 .. v8}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/Prices;Lcom/amazon/searchapp/retailsearch/model/PriceInfo;Lcom/amazon/searchapp/retailsearch/model/Shipping;ZZZZ)Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    move-result-object v15

    .line 253
    .local v15, "priceModel":Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->price:Lcom/amazon/retailsearch/android/ui/results/views/price/Price;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v1, v15, v3}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 256
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->offersLine:Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;

    if-eqz v1, :cond_1

    .line 258
    new-instance v3, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel$Builder;

    invoke-direct {v3}, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel$Builder;-><init>()V

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->price:Lcom/amazon/retailsearch/android/ui/results/views/price/Price;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->getVisibility()I

    move-result v1

    if-nez v1, :cond_8

    const/4 v1, 0x1

    :goto_1
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->offersLine:Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;->getIsPriceBackup()Z

    move-result v4

    invoke-virtual {v3, v2, v1, v4}, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/Prices;ZZ)Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;

    move-result-object v14

    .line 264
    .local v14, "offersLineModel":Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->offersLine:Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v1, v14, v3}, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 268
    .end local v14    # "offersLineModel":Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;
    :cond_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->twister:Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;

    if-eqz v1, :cond_2

    .line 270
    if-nez v2, :cond_9

    const/4 v5, 0x0

    .line 271
    .local v5, "editionsType":Ljava/lang/String;
    :goto_2
    if-nez v2, :cond_a

    const/4 v6, 0x0

    .line 272
    .local v6, "editionsMetadata":Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;
    :goto_3
    if-nez v2, :cond_b

    const/4 v7, 0x0

    .line 274
    .local v7, "editions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;>;"
    :goto_4
    new-instance v3, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Builder;

    invoke-direct {v3}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Builder;-><init>()V

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Product;->getTitle()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Product;->getGroup()Ljava/lang/String;

    move-result-object v8

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-virtual/range {v3 .. v9}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Builder;->build(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;Ljava/util/List;Ljava/lang/String;Landroid/content/Context;)Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;

    move-result-object v18

    .line 283
    .local v18, "twisterModel":Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->twister:Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-object/from16 v0, v18

    invoke-virtual {v1, v0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 287
    .end local v5    # "editionsType":Ljava/lang/String;
    .end local v6    # "editionsMetadata":Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;
    .end local v7    # "editions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;>;"
    .end local v18    # "twisterModel":Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;
    :cond_2
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->subscribeAndSave:Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;

    if-eqz v1, :cond_3

    .line 289
    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel$Builder;

    invoke-direct {v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel$Builder;-><init>()V

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->subscribeAndSavePrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->subscribeAndSave:Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;->getShowSaveMoreText()Z

    move-result v4

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    invoke-virtual {v1, v3, v4, v8, v9}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;ZLcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/res/Resources;)Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;

    move-result-object v17

    .line 291
    .local v17, "subscribeAndSaveModel":Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->subscribeAndSave:Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-object/from16 v0, v17

    invoke-virtual {v1, v0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 295
    .end local v17    # "subscribeAndSaveModel":Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;
    :cond_3
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->freeRentalLine:Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLine;

    if-eqz v1, :cond_4

    .line 297
    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel$Builder;

    invoke-direct {v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel$Builder;-><init>()V

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Product;->getPrices()Lcom/amazon/searchapp/retailsearch/model/Prices;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->shippingInfo:Lcom/amazon/searchapp/retailsearch/model/Shipping;

    invoke-virtual {v1, v3, v4}, Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/Prices;Lcom/amazon/searchapp/retailsearch/model/Shipping;)Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel;

    move-result-object v12

    .line 298
    .local v12, "freeRentalLineModel":Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->freeRentalLine:Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLine;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v1, v12, v3}, Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLine;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 302
    .end local v12    # "freeRentalLineModel":Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel;
    :cond_4
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->bestSeller:Lcom/amazon/retailsearch/android/ui/results/views/BestSeller;

    if-eqz v1, :cond_5

    .line 304
    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel$Builder;

    invoke-direct {v1}, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel$Builder;-><init>()V

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Product;->getBestSeller()Lcom/amazon/searchapp/retailsearch/model/BestSeller;

    move-result-object v3

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/BestSeller;Landroid/content/res/Resources;)Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;

    move-result-object v10

    .line 305
    .local v10, "bestSellerModel":Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->bestSeller:Lcom/amazon/retailsearch/android/ui/results/views/BestSeller;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v1, v10, v3}, Lcom/amazon/retailsearch/android/ui/results/views/BestSeller;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 309
    .end local v10    # "bestSellerModel":Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;
    :cond_5
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->ratingsLine:Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;

    if-eqz v1, :cond_6

    .line 311
    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel$Builder;

    invoke-direct {v1}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel$Builder;-><init>()V

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/Ratings;Landroid/content/res/Resources;)Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;

    move-result-object v16

    .line 312
    .local v16, "ratingsLineModel":Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->ratingsLine:Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-object/from16 v0, v16

    invoke-virtual {v1, v0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 315
    .end local v16    # "ratingsLineModel":Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;
    :cond_6
    const/4 v1, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->setVisibility(I)V

    .line 316
    return-void

    .line 237
    .end local v2    # "prices":Lcom/amazon/searchapp/retailsearch/model/Prices;
    .end local v15    # "priceModel":Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;
    :cond_7
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->title:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Product;->getTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 258
    .restart local v2    # "prices":Lcom/amazon/searchapp/retailsearch/model/Prices;
    .restart local v15    # "priceModel":Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;
    :cond_8
    const/4 v1, 0x0

    goto/16 :goto_1

    .line 270
    :cond_9
    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getEditionsType()Ljava/lang/String;

    move-result-object v5

    goto/16 :goto_2

    .line 271
    .restart local v5    # "editionsType":Ljava/lang/String;
    :cond_a
    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getEditionsMetadata()Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;

    move-result-object v6

    goto/16 :goto_3

    .line 272
    .restart local v6    # "editionsMetadata":Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;
    :cond_b
    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getEditions()Ljava/util/List;

    move-result-object v7

    goto/16 :goto_4
.end method

.method public getProduct()Lcom/amazon/searchapp/retailsearch/model/Product;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    return-object v0
.end method

.method protected init(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 116
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 117
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->getContext()Landroid/content/Context;

    move-result-object v1

    new-instance v2, Lcom/amazon/retailsearch/android/ui/results/ProductView$SwipeListener;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v3}, Lcom/amazon/retailsearch/android/ui/results/ProductView$SwipeListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/ProductView;Lcom/amazon/retailsearch/android/ui/results/ProductView$1;)V

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;-><init>(Landroid/content/Context;Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->swipeDetector:Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;

    .line 118
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;-><init>(Landroid/util/DisplayMetrics;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->gestureListener:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;

    .line 119
    new-instance v0, Landroid/view/GestureDetector;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->gestureListener:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;

    invoke-direct {v0, v1, v2}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->gestureDetector:Landroid/view/GestureDetector;

    .line 120
    return-void
.end method

.method protected initProductElements()V
    .locals 1

    .prologue
    .line 131
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_image_wrapper:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->imageWrapper:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    .line 132
    sget v0, Lcom/amazon/retailsearch/R$id;->item_title:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->title:Landroid/widget/TextView;

    .line 133
    sget v0, Lcom/amazon/retailsearch/R$id;->item_edition:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLine;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->editionLine:Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLine;

    .line 134
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_price:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->price:Lcom/amazon/retailsearch/android/ui/results/views/price/Price;

    .line 135
    sget v0, Lcom/amazon/retailsearch/R$id;->item_offers_line:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->offersLine:Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;

    .line 137
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_item_twister:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->twister:Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;

    .line 139
    sget v0, Lcom/amazon/retailsearch/R$id;->item_subscribe_and_save:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->subscribeAndSave:Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;

    .line 140
    sget v0, Lcom/amazon/retailsearch/R$id;->item_free_rental_line:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLine;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->freeRentalLine:Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLine;

    .line 141
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_best_seller:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/BestSeller;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->bestSeller:Lcom/amazon/retailsearch/android/ui/results/views/BestSeller;

    .line 142
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_ratings:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->ratingsLine:Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;

    .line 143
    return-void
.end method

.method protected onFinishInflate()V
    .locals 0

    .prologue
    .line 125
    invoke-super {p0}, Landroid/widget/FrameLayout;->onFinishInflate()V

    .line 126
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->initProductElements()V

    .line 127
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 321
    const/4 v0, 0x0

    .line 322
    .local v0, "res":Z
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->thumbSwitcher:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    if-nez v1, :cond_2

    .line 324
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->gestureDetector:Landroid/view/GestureDetector;

    invoke-virtual {v1, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 331
    :goto_0
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->swipeDetector:Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->isSwiping()Z

    move-result v1

    if-nez v1, :cond_0

    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->swiped:Z

    if-nez v1, :cond_0

    .line 333
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->gestureDetector:Landroid/view/GestureDetector;

    invoke-virtual {v1, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v1

    or-int/2addr v0, v1

    .line 335
    :cond_0
    if-nez v0, :cond_1

    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v1

    if-eqz v1, :cond_3

    :cond_1
    const/4 v1, 0x1

    :goto_1
    return v1

    .line 328
    :cond_2
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->swipeDetector:Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;

    invoke-virtual {v1, p1}, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0

    .line 335
    :cond_3
    const/4 v1, 0x0

    goto :goto_1
.end method
