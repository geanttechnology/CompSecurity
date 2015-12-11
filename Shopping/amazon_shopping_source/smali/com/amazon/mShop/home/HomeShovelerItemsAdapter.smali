.class public Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;
.super Lcom/amazon/mShop/ui/HorizontalListView$HorizontalListViewAdapter;
.source "HomeShovelerItemsAdapter.java"

# interfaces
.implements Lcom/amazon/mShop/control/home/BasicProductsSubscriber;
.implements Lcom/amazon/mShop/net/HttpFetcher$Subscriber;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;,
        Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/ui/HorizontalListView$HorizontalListViewAdapter;",
        "Lcom/amazon/mShop/control/home/BasicProductsSubscriber;",
        "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private mBasicProductsController:Lcom/amazon/mShop/control/home/BasicProductsController;

.field private mContext:Landroid/content/Context;

.field private mDisplayType:Ljava/lang/Integer;

.field private mFetchingBasicProduct:Z

.field private mFetchingFullInfoItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;",
            ">;"
        }
    .end annotation
.end field

.field private mFetchingOOBImageItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;",
            ">;"
        }
    .end annotation
.end field

.field private mFullItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;",
            ">;"
        }
    .end annotation
.end field

.field private mHomeShovelerItemsShownSubscriber:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;

.field private mPageMetricsAlreadyFinished:Z

.field private mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mRawItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;",
            ">;"
        }
    .end annotation
.end field

.field private mRefMarkerArg:Ljava/lang/String;

.field private mRequestId:Ljava/lang/String;

.field private mShovelerClickStreamOrigin:Ljava/lang/String;

.field private mShovelerSlotToken:Ljava/lang/String;

.field private mShownItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;",
            ">;"
        }
    .end annotation
.end field

.field private mStubItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/net/PageMetricsObserver;Lcom/amazon/mShop/net/PageMetricsObserver;Lcom/amazon/mShop/net/PageMetricsObserver;Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 3
    .param p1, "ctx"    # Landroid/content/Context;
    .param p2, "slotToken"    # Ljava/lang/String;
    .param p3, "clickStreamOrigin"    # Ljava/lang/String;
    .param p4, "refMarkerArg"    # Ljava/lang/String;
    .param p5, "pageMetricsObserver"    # Lcom/amazon/mShop/net/PageMetricsObserver;
    .param p6, "pageMetricsCriticalFeatureObserver"    # Lcom/amazon/mShop/net/PageMetricsObserver;
    .param p7, "pageMetricsRefreshCriticalFeatureObserver"    # Lcom/amazon/mShop/net/PageMetricsObserver;
    .param p8, "homeShovelerItemsShownSubscriber"    # Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;
    .param p9, "requestId"    # Ljava/lang/String;
    .param p10, "displayType"    # Ljava/lang/Integer;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 105
    invoke-direct {p0}, Lcom/amazon/mShop/ui/HorizontalListView$HorizontalListViewAdapter;-><init>()V

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFullItems:Ljava/util/List;

    .line 57
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mStubItems:Ljava/util/List;

    .line 60
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShownItems:Ljava/util/List;

    .line 63
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingOOBImageItems:Ljava/util/List;

    .line 66
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingFullInfoItems:Ljava/util/List;

    .line 70
    iput-boolean v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingBasicProduct:Z

    .line 72
    iput-object v1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShovelerSlotToken:Ljava/lang/String;

    .line 74
    iput-object v1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShovelerClickStreamOrigin:Ljava/lang/String;

    .line 76
    iput-object v1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mRefMarkerArg:Ljava/lang/String;

    .line 78
    iput-object v1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mRequestId:Ljava/lang/String;

    .line 80
    new-instance v0, Lcom/amazon/mShop/control/home/BasicProductsController;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/control/home/BasicProductsController;-><init>(Lcom/amazon/mShop/control/home/BasicProductsSubscriber;)V

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mBasicProductsController:Lcom/amazon/mShop/control/home/BasicProductsController;

    .line 85
    iput-object v1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mDisplayType:Ljava/lang/Integer;

    .line 90
    iput-boolean v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mPageMetricsAlreadyFinished:Z

    .line 106
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mContext:Landroid/content/Context;

    .line 107
    iput-object p2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShovelerSlotToken:Ljava/lang/String;

    .line 108
    iput-object p3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShovelerClickStreamOrigin:Ljava/lang/String;

    .line 109
    iput-object p4, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mRefMarkerArg:Ljava/lang/String;

    .line 110
    iput-object p5, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 111
    iput-object p6, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 112
    iput-object p7, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 113
    iput-object p8, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mHomeShovelerItemsShownSubscriber:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;

    .line 114
    iput-object p9, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mRequestId:Ljava/lang/String;

    .line 115
    iput-object p10, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mDisplayType:Ljava/lang/Integer;

    .line 116
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShovelerClickStreamOrigin:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShovelerSlotToken:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mRefMarkerArg:Ljava/lang/String;

    return-object v0
.end method

.method private cancelMetrics(Lcom/amazon/mShop/net/PageMetricsObserver;)V
    .locals 1
    .param p1, "metricsObserver"    # Lcom/amazon/mShop/net/PageMetricsObserver;

    .prologue
    .line 98
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 99
    invoke-virtual {p1}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 101
    :cond_0
    return-void
.end method

.method private fetchBasicProducts()V
    .locals 5

    .prologue
    .line 254
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mStubItems:Ljava/util/List;

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 269
    :goto_0
    return-void

    .line 258
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 260
    .local v0, "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mStubItems:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v2

    .line 261
    .local v2, "size":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    if-ge v1, v2, :cond_1

    const/4 v3, 0x6

    if-ge v1, v3, :cond_1

    .line 262
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mStubItems:Ljava/util/List;

    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;

    invoke-virtual {v3}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->getHomeShoveler()Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getAsin()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 263
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingFullInfoItems:Ljava/util/List;

    iget-object v4, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mStubItems:Ljava/util/List;

    invoke-interface {v4, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 261
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 265
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mStubItems:Ljava/util/List;

    iget-object v4, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingFullInfoItems:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    .line 267
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mBasicProductsController:Lcom/amazon/mShop/control/home/BasicProductsController;

    iget-object v4, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mRequestId:Ljava/lang/String;

    invoke-virtual {v3, v0, v4}, Lcom/amazon/mShop/control/home/BasicProductsController;->requestBasicProducts(Ljava/util/List;Ljava/lang/String;)V

    .line 268
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingBasicProduct:Z

    goto :goto_0
.end method

.method private getShovelerItemView(ILcom/amazon/mShop/home/ShovelerItemView;)Landroid/view/View;
    .locals 17
    .param p1, "position"    # I
    .param p2, "convertView"    # Lcom/amazon/mShop/home/ShovelerItemView;

    .prologue
    .line 378
    const/4 v4, 0x0

    .line 380
    .local v4, "imageUrl":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShownItems:Ljava/util/List;

    move/from16 v0, p1

    invoke-interface {v15, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    .line 381
    .local v6, "item":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v3

    .line 382
    .local v3, "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v2

    .line 384
    .local v2, "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    if-eqz v3, :cond_0

    .line 385
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v4

    .line 388
    :cond_0
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mContext:Landroid/content/Context;

    invoke-static {v15}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v7

    .line 389
    .local v7, "layoutInflater":Landroid/view/LayoutInflater;
    if-nez p2, :cond_1

    sget v15, Lcom/amazon/mShop/android/lib/R$layout;->home_shoveler_item_view:I

    const/16 v16, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v7, v15, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v15

    check-cast v15, Lcom/amazon/mShop/home/ShovelerItemView;

    move-object v12, v15

    .line 392
    .local v12, "shovelerItemView":Lcom/amazon/mShop/home/ShovelerItemView;
    :goto_0
    invoke-virtual {v12, v4}, Lcom/amazon/mShop/home/ShovelerItemView;->update(Ljava/lang/String;)V

    .line 394
    sget v15, Lcom/amazon/mShop/android/lib/R$id;->home_shoveler_item_title:I

    invoke-virtual {v12, v15}, Lcom/amazon/mShop/home/ShovelerItemView;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    .line 395
    .local v14, "titleView":Landroid/widget/TextView;
    sget v15, Lcom/amazon/mShop/android/lib/R$id;->home_shoveler_item_item_price:I

    invoke-virtual {v12, v15}, Lcom/amazon/mShop/home/ShovelerItemView;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Landroid/widget/TextView;

    .line 399
    .local v11, "priceView":Landroid/widget/TextView;
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mDisplayType:Ljava/lang/Integer;

    const/16 v16, 0x1

    invoke-static/range {v15 .. v16}, Lcom/amazon/mShop/util/DataUtil;->isEqual(Ljava/lang/Integer;I)Z

    move-result v15

    if-eqz v15, :cond_2

    .line 400
    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 401
    const/16 v15, 0x8

    invoke-virtual {v11, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 443
    :goto_1
    invoke-virtual {v12, v6}, Lcom/amazon/mShop/home/ShovelerItemView;->setTag(Ljava/lang/Object;)V

    .line 444
    new-instance v15, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$1;

    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-direct {v15, v0, v12, v1}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$1;-><init>(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;Lcom/amazon/mShop/home/ShovelerItemView;I)V

    invoke-virtual {v12, v15}, Lcom/amazon/mShop/home/ShovelerItemView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 478
    new-instance v15, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$2;

    move-object/from16 v0, p0

    invoke-direct {v15, v0}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$2;-><init>(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;)V

    invoke-virtual {v12, v15}, Lcom/amazon/mShop/home/ShovelerItemView;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 487
    return-object v12

    .end local v11    # "priceView":Landroid/widget/TextView;
    .end local v12    # "shovelerItemView":Lcom/amazon/mShop/home/ShovelerItemView;
    .end local v14    # "titleView":Landroid/widget/TextView;
    :cond_1
    move-object/from16 v12, p2

    .line 389
    goto :goto_0

    .line 403
    .restart local v11    # "priceView":Landroid/widget/TextView;
    .restart local v12    # "shovelerItemView":Lcom/amazon/mShop/home/ShovelerItemView;
    .restart local v14    # "titleView":Landroid/widget/TextView;
    :cond_2
    if-nez v3, :cond_4

    const/4 v13, 0x0

    .line 404
    .local v13, "title":Ljava/lang/String;
    :goto_2
    invoke-static {v13}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v15

    if-nez v15, :cond_5

    .line 405
    invoke-virtual {v14, v13}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 406
    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 411
    :goto_3
    const/4 v10, 0x0

    .line 412
    .local v10, "price":Ljava/lang/String;
    if-nez v2, :cond_6

    .line 413
    if-eqz v3, :cond_3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getVariationPriceRange()Ljava/lang/String;

    move-result-object v15

    if-eqz v15, :cond_3

    .line 414
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getVariationPriceRange()Ljava/lang/String;

    move-result-object v10

    .line 430
    :cond_3
    :goto_4
    new-instance v9, Landroid/graphics/Paint;

    invoke-direct {v9}, Landroid/graphics/Paint;-><init>()V

    .line 431
    .local v9, "paint":Landroid/graphics/Paint;
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v15}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v15

    sget v16, Lcom/amazon/mShop/android/lib/R$dimen;->home_shoveler_item_text_size:I

    invoke-virtual/range {v15 .. v16}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v15

    invoke-virtual {v9, v15}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 432
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v15}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v15

    sget v16, Lcom/amazon/mShop/android/lib/R$dimen;->home_view_shoveler_view_thumbnail_max_dimension:I

    invoke-virtual/range {v15 .. v16}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v15

    float-to-int v8, v15

    .line 434
    .local v8, "maxTextWidth":I
    invoke-static {v10, v9, v8}, Lcom/amazon/mShop/util/TextUtils;->isTextExceedMaxWidth(Ljava/lang/String;Landroid/graphics/Paint;I)Z

    move-result v5

    .line 436
    .local v5, "isTextExceedMaxWidth":Z
    invoke-static {v10}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v15

    if-nez v15, :cond_8

    if-nez v5, :cond_8

    .line 437
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mContext:Landroid/content/Context;

    sget-object v16, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->RED:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    move-object/from16 v0, v16

    invoke-static {v15, v10, v0}, Lcom/amazon/mShop/util/UIUtils;->convertUnsupportedCharacter(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/mShop/util/UIUtils$CharacterColor;)Ljava/lang/CharSequence;

    move-result-object v15

    invoke-virtual {v11, v15}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 438
    const/4 v15, 0x0

    invoke-virtual {v11, v15}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 403
    .end local v5    # "isTextExceedMaxWidth":Z
    .end local v8    # "maxTextWidth":I
    .end local v9    # "paint":Landroid/graphics/Paint;
    .end local v10    # "price":Ljava/lang/String;
    .end local v13    # "title":Ljava/lang/String;
    :cond_4
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getTitle()Ljava/lang/String;

    move-result-object v13

    goto :goto_2

    .line 408
    .restart local v13    # "title":Ljava/lang/String;
    :cond_5
    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_3

    .line 416
    .restart local v10    # "price":Ljava/lang/String;
    :cond_6
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPriceViolatesMap()Z

    move-result v15

    if-nez v15, :cond_3

    .line 417
    if-eqz v3, :cond_7

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getVariationPriceRange()Ljava/lang/String;

    move-result-object v15

    if-eqz v15, :cond_7

    .line 418
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getVariationPriceRange()Ljava/lang/String;

    move-result-object v10

    goto :goto_4

    .line 419
    :cond_7
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPrice()Ljava/lang/String;

    move-result-object v15

    if-eqz v15, :cond_3

    .line 420
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPrice()Ljava/lang/String;

    move-result-object v10

    goto :goto_4

    .line 440
    .restart local v5    # "isTextExceedMaxWidth":Z
    .restart local v8    # "maxTextWidth":I
    .restart local v9    # "paint":Landroid/graphics/Paint;
    :cond_8
    const/16 v15, 0x8

    invoke-virtual {v11, v15}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_1
.end method

.method private initItems()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 170
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mRawItems:Ljava/util/List;

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 181
    :cond_0
    return-void

    .line 174
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mRawItems:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    .line 175
    .local v1, "item":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v2

    if-nez v2, :cond_2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    if-nez v2, :cond_2

    .line 176
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mStubItems:Ljava/util/List;

    new-instance v3, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;

    invoke-direct {v3, p0, v1, v4}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;-><init>(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;I)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 178
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFullItems:Ljava/util/List;

    new-instance v3, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;

    invoke-direct {v3, p0, v1, v4}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;-><init>(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;I)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private static removeItems(Ljava/util/List;Ljava/lang/String;)V
    .locals 3
    .param p1, "asin"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 360
    .local p0, "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;>;"
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 374
    :cond_0
    :goto_0
    return-void

    .line 364
    :cond_1
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 368
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;

    .line 369
    .local v1, "item":Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;
    invoke-virtual {v1}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->getHomeShoveler()Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getAsin()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 370
    invoke-interface {p0, v1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private startFetchOOB()V
    .locals 10

    .prologue
    const/4 v6, 0x6

    const/4 v5, 0x0

    .line 140
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFullItems:Ljava/util/List;

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 164
    :cond_0
    return-void

    .line 145
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFullItems:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-gt v2, v6, :cond_4

    .line 146
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingOOBImageItems:Ljava/util/List;

    iget-object v4, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFullItems:Ljava/util/List;

    invoke-interface {v2, v4}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 147
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFullItems:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 155
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingOOBImageItems:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :cond_3
    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;

    .line 156
    .local v3, "item":Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;
    invoke-virtual {v3}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->getHomeShoveler()Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    if-nez v2, :cond_5

    const/4 v1, 0x0

    .line 157
    .local v1, "url":Ljava/lang/String;
    :goto_1
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 158
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v4, Lcom/amazon/mShop/android/lib/R$dimen;->home_view_shoveler_view_thumbnail_max_dimension:I

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v7

    .line 159
    .local v7, "dimension":I
    new-instance v0, Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const/4 v5, 0x1

    sget-object v6, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_0:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    move-object v4, p0

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/net/BitmapFetcher;-><init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;ZLcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V

    .line 160
    .local v0, "bitmapFetcher":Lcom/amazon/mShop/net/BitmapFetcher;
    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->fetch()V

    goto :goto_0

    .line 149
    .end local v0    # "bitmapFetcher":Lcom/amazon/mShop/net/BitmapFetcher;
    .end local v1    # "url":Ljava/lang/String;
    .end local v3    # "item":Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;
    .end local v7    # "dimension":I
    .end local v9    # "i$":Ljava/util/Iterator;
    :cond_4
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_2
    if-ge v8, v6, :cond_2

    .line 150
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingOOBImageItems:Ljava/util/List;

    iget-object v4, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFullItems:Ljava/util/List;

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 151
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFullItems:Ljava/util/List;

    invoke-interface {v2, v5}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 149
    add-int/lit8 v8, v8, 0x1

    goto :goto_2

    .line 156
    .end local v8    # "i":I
    .restart local v3    # "item":Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;
    .restart local v9    # "i$":Ljava/util/Iterator;
    :cond_5
    invoke-virtual {v3}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->getHomeShoveler()Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 185
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShownItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getHomeShovelerItemsShownSubscriber()Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mHomeShovelerItemsShownSubscriber:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;

    return-object v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 195
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShownItems:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 200
    int-to-long v0, p1

    return-wide v0
.end method

.method public getTotalCount()I
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mRawItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 2
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 206
    add-int/lit8 v0, p1, 0x1

    const/4 v1, 0x3

    if-eq v0, v1, :cond_0

    add-int/lit8 v0, p1, 0x1

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mRawItems:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ne v0, v1, :cond_4

    :cond_0
    iget-boolean v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mPageMetricsAlreadyFinished:Z

    if-nez v0, :cond_4

    .line 207
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_1

    .line 208
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-class v1, Lcom/amazon/mShop/home/HomeShovelerView;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 210
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_2

    .line 211
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-class v1, Lcom/amazon/mShop/home/HomeShovelerView;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 213
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_3

    .line 214
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-class v1, Lcom/amazon/mShop/home/HomeShovelerView;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 216
    :cond_3
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mPageMetricsAlreadyFinished:Z

    .line 219
    :cond_4
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShownItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x6

    if-le p1, v0, :cond_5

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFullItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x6

    if-ge v0, v1, :cond_5

    iget-boolean v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingBasicProduct:Z

    if-nez v0, :cond_5

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mStubItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_5

    .line 228
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->fetchBasicProducts()V

    .line 231
    :cond_5
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShownItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x6

    if-le p1, v0, :cond_6

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFullItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_6

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingOOBImageItems:Ljava/util/List;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 238
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->startFetchOOB()V

    .line 241
    :cond_6
    instance-of v0, p2, Lcom/amazon/mShop/home/ShovelerItemView;

    if-eqz v0, :cond_7

    .line 242
    check-cast p2, Lcom/amazon/mShop/home/ShovelerItemView;

    .end local p2    # "convertView":Landroid/view/View;
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->getShovelerItemView(ILcom/amazon/mShop/home/ShovelerItemView;)Landroid/view/View;

    move-result-object v0

    .line 244
    :goto_0
    return-object v0

    .restart local p2    # "convertView":Landroid/view/View;
    :cond_7
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->getShovelerItemView(ILcom/amazon/mShop/home/ShovelerItemView;)Landroid/view/View;

    move-result-object v0

    goto :goto_0
.end method

.method public onBasicProductsReceived(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;)V
    .locals 7
    .param p1, "response"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;

    .prologue
    const/4 v6, 0x0

    .line 329
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;->getProducts()Ljava/util/List;

    move-result-object v3

    .line 330
    .local v3, "results":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 331
    .local v2, "result":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;-><init>()V

    .line 332
    .local v1, "item":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->setAsin(Ljava/lang/String;)V

    .line 333
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V

    .line 334
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->setBasicProduct(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    .line 335
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->setImageUrl(Ljava/lang/String;)V

    .line 336
    iget-object v4, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFullItems:Ljava/util/List;

    new-instance v5, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;

    invoke-direct {v5, p0, v1, v6}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;-><init>(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;I)V

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 337
    iget-object v4, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingFullInfoItems:Ljava/util/List;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->removeItems(Ljava/util/List;Ljava/lang/String;)V

    goto :goto_0

    .line 340
    .end local v1    # "item":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    .end local v2    # "result":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingFullInfoItems:Ljava/util/List;

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 341
    iget-object v4, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mStubItems:Ljava/util/List;

    iget-object v5, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingFullInfoItems:Ljava/util/List;

    invoke-interface {v4, v5}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 342
    iget-object v4, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingFullInfoItems:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->clear()V

    .line 345
    :cond_1
    iput-boolean v6, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingBasicProduct:Z

    .line 347
    iget-object v4, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShownItems:Ljava/util/List;

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v4

    if-eqz v4, :cond_2

    iget-object v4, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingOOBImageItems:Ljava/util/List;

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 350
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->startFetchOOB()V

    .line 354
    :goto_1
    return-void

    .line 352
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->notifyDataSetChanged()V

    goto :goto_1
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 4
    .param p1, "arg0"    # Ljava/lang/Exception;
    .param p2, "arg1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 310
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingBasicProduct:Z

    .line 314
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-direct {p0, v3}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->cancelMetrics(Lcom/amazon/mShop/net/PageMetricsObserver;)V

    .line 316
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingFullInfoItems:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;

    .line 317
    .local v1, "item":Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;
    invoke-virtual {v1}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->getRetryCounts()I

    move-result v2

    .line 318
    .local v2, "retryCounts":I
    const/4 v3, 0x1

    if-ge v2, v3, :cond_0

    .line 319
    add-int/lit8 v2, v2, 0x1

    .line 320
    invoke-virtual {v1, v2}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->setRetryCounts(I)V

    .line 321
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mStubItems:Ljava/util/List;

    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 324
    .end local v1    # "item":Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;
    .end local v2    # "retryCounts":I
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingFullInfoItems:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->clear()V

    .line 325
    return-void
.end method

.method public onHttpRequestFailed(Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 286
    .local p1, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    invoke-virtual {p1}, Lcom/amazon/mShop/net/HttpFetcher$Params;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;

    .line 287
    .local v0, "item":Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingOOBImageItems:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 288
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingOOBImageItems:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 290
    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->getRetryCounts()I

    move-result v1

    .line 291
    .local v1, "retryCounts":I
    const/4 v2, 0x1

    if-ge v1, v2, :cond_0

    .line 292
    add-int/lit8 v1, v1, 0x1

    .line 293
    invoke-virtual {v0, v1}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->setRetryCounts(I)V

    .line 294
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFullItems:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 298
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-direct {p0, v2}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->cancelMetrics(Lcom/amazon/mShop/net/PageMetricsObserver;)V

    .line 302
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingOOBImageItems:Ljava/util/List;

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 303
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->notifyDataSetChanged()V

    .line 306
    .end local v1    # "retryCounts":I
    :cond_1
    return-void
.end method

.method public onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 3
    .param p1, "response"    # Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/Bitmap;",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 273
    .local p2, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    invoke-virtual {p2}, Lcom/amazon/mShop/net/HttpFetcher$Params;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;

    .line 274
    .local v0, "item":Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingOOBImageItems:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 275
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingOOBImageItems:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 276
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShownItems:Ljava/util/List;

    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->getHomeShoveler()Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 277
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShownItems:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mHomeShovelerItemsShownSubscriber:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;

    if-eqz v1, :cond_0

    .line 278
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mHomeShovelerItemsShownSubscriber:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;

    invoke-interface {v1}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;->onHomeShovelerItemsShown()V

    .line 280
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->notifyDataSetChanged()V

    .line 282
    :cond_1
    return-void
.end method

.method public bridge synthetic onHttpResponseReceived(Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/mShop/net/HttpFetcher$Params;

    .prologue
    .line 40
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    return-void
.end method

.method public reset()V
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mRawItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 131
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFullItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 132
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mStubItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 133
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingFullInfoItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 134
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShownItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 135
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFetchingOOBImageItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 136
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->notifyDataSetChanged()V

    .line 137
    return-void
.end method

.method public setRawItems(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 119
    .local p1, "rawItems":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;>;"
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mRawItems:Ljava/util/List;

    .line 120
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->initItems()V

    .line 121
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->startFetchOOB()V

    .line 124
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mFullItems:Ljava/util/List;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mStubItems:Ljava/util/List;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 125
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->fetchBasicProducts()V

    .line 127
    :cond_0
    return-void
.end method
