.class public Lcom/amazon/mShop/mash/OfferListingView;
.super Landroid/widget/LinearLayout;
.source "OfferListingView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;


# instance fields
.field private mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field private final mLoadingSpinner:Landroid/view/View;

.field private mMarketPlaceView:Lcom/amazon/mShop/details/MarketPlaceView;

.field private final mProductController:Lcom/amazon/mShop/control/item/ProductController;

.field private final mProductSubscriber:Lcom/amazon/mShop/control/item/ProductSubscriber;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 3
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "productController"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    const/4 v2, -0x1

    .line 43
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 44
    iput-object p1, p0, Lcom/amazon/mShop/mash/OfferListingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 45
    sget v0, Lcom/amazon/mShop/android/lib/R$layout;->progress_bar:I

    const/4 v1, 0x0

    invoke-static {p1, v0, v1}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/mash/OfferListingView;->mLoadingSpinner:Landroid/view/View;

    .line 46
    iput-object p2, p0, Lcom/amazon/mShop/mash/OfferListingView;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    .line 47
    invoke-direct {p0}, Lcom/amazon/mShop/mash/OfferListingView;->getProductSubscriber()Lcom/amazon/mShop/control/item/ProductSubscriber;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/mash/OfferListingView;->mProductSubscriber:Lcom/amazon/mShop/control/item/ProductSubscriber;

    .line 49
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v0, v2, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/OfferListingView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 50
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/OfferListingView;->setOrientation(I)V

    .line 51
    iget-object v0, p0, Lcom/amazon/mShop/mash/OfferListingView;->mLoadingSpinner:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/OfferListingView;->addView(Landroid/view/View;)V

    .line 52
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/mash/OfferListingView;)Lcom/amazon/mShop/control/item/ProductController;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mash/OfferListingView;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/mShop/mash/OfferListingView;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/mash/OfferListingView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/OfferListingView;

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/amazon/mShop/mash/OfferListingView;->update()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/mash/OfferListingView;Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mash/OfferListingView;
    .param p1, "x1"    # Ljava/lang/Exception;
    .param p2, "x2"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 28
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/mash/OfferListingView;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    return-void
.end method

.method private error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 103
    new-instance v0, Lcom/amazon/mShop/mash/OfferListingView$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/mash/OfferListingView$1;-><init>(Lcom/amazon/mShop/mash/OfferListingView;)V

    .line 114
    .local v0, "errorHandler":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    iget-object v1, p0, Lcom/amazon/mShop/mash/OfferListingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v1, v0, p0, p1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;)V

    .line 115
    return-void
.end method

.method private getProductSubscriber()Lcom/amazon/mShop/control/item/ProductSubscriber;
    .locals 1

    .prologue
    .line 118
    new-instance v0, Lcom/amazon/mShop/mash/OfferListingView$2;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/mash/OfferListingView$2;-><init>(Lcom/amazon/mShop/mash/OfferListingView;)V

    return-object v0
.end method

.method public static show(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p0, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "listId"    # Ljava/lang/String;
    .param p3, "listItemId"    # Ljava/lang/String;

    .prologue
    .line 138
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v0

    .line 140
    .local v0, "clickStreamOrigin":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 141
    sget-object v1, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_DEFAULT:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 145
    .local v1, "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    :goto_0
    new-instance v3, Lcom/amazon/mShop/control/item/ProductController;

    invoke-direct {v3, p1, v1}, Lcom/amazon/mShop/control/item/ProductController;-><init>(Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    .line 152
    .local v3, "productController":Lcom/amazon/mShop/control/item/ProductController;
    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/control/item/ProductController;->setIsSelectedChild(Z)V

    .line 153
    invoke-static {p2}, Lcom/amazon/mShop/util/WebUtils;->isDefined(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 154
    invoke-virtual {v3, p2}, Lcom/amazon/mShop/control/item/ProductController;->setListId(Ljava/lang/String;)V

    .line 156
    :cond_0
    invoke-static {p3}, Lcom/amazon/mShop/util/WebUtils;->isDefined(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 157
    invoke-virtual {v3, p3}, Lcom/amazon/mShop/control/item/ProductController;->setListItemId(Ljava/lang/String;)V

    .line 159
    :cond_1
    new-instance v2, Lcom/amazon/mShop/mash/OfferListingView;

    invoke-direct {v2, p0, v3}, Lcom/amazon/mShop/mash/OfferListingView;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;)V

    .line 160
    .local v2, "offerListingView":Lcom/amazon/mShop/mash/OfferListingView;
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 161
    return-void

    .line 143
    .end local v1    # "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    .end local v2    # "offerListingView":Lcom/amazon/mShop/mash/OfferListingView;
    .end local v3    # "productController":Lcom/amazon/mShop/control/item/ProductController;
    :cond_2
    new-instance v1, Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-direct {v1, v0}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    .restart local v1    # "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    goto :goto_0
.end method

.method private update()V
    .locals 5

    .prologue
    const/4 v4, -0x1

    .line 83
    iget-object v1, p0, Lcom/amazon/mShop/mash/OfferListingView;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/ProductController;->getConditionalOffersSummaryList()[Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;

    move-result-object v0

    .line 84
    .local v0, "summaries":[Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    if-eqz v0, :cond_0

    array-length v1, v0

    if-lez v1, :cond_0

    .line 85
    new-instance v1, Lcom/amazon/mShop/details/MarketPlaceView;

    iget-object v2, p0, Lcom/amazon/mShop/mash/OfferListingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v3, p0, Lcom/amazon/mShop/mash/OfferListingView;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-direct {v1, v2, v3}, Lcom/amazon/mShop/details/MarketPlaceView;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;)V

    iput-object v1, p0, Lcom/amazon/mShop/mash/OfferListingView;->mMarketPlaceView:Lcom/amazon/mShop/details/MarketPlaceView;

    .line 87
    iget-object v1, p0, Lcom/amazon/mShop/mash/OfferListingView;->mMarketPlaceView:Lcom/amazon/mShop/details/MarketPlaceView;

    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v2, v4, v4}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/mash/OfferListingView;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 89
    iget-object v1, p0, Lcom/amazon/mShop/mash/OfferListingView;->mLoadingSpinner:Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 90
    iget-object v1, p0, Lcom/amazon/mShop/mash/OfferListingView;->mLoadingSpinner:Landroid/view/View;

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/mash/OfferListingView;->removeView(Landroid/view/View;)V

    .line 91
    iget-object v1, p0, Lcom/amazon/mShop/mash/OfferListingView;->mMarketPlaceView:Lcom/amazon/mShop/details/MarketPlaceView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/details/MarketPlaceView;->setVisibility(I)V

    .line 94
    iget-object v1, p0, Lcom/amazon/mShop/mash/OfferListingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1, p0}, Lcom/amazon/mShop/AmazonActivity;->updateTitle(Landroid/view/View;)V

    .line 96
    iget-object v1, p0, Lcom/amazon/mShop/mash/OfferListingView;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v2, p0, Lcom/amazon/mShop/mash/OfferListingView;->mProductSubscriber:Lcom/amazon/mShop/control/item/ProductSubscriber;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/control/item/ProductController;->removeSubscriber(Lcom/amazon/mShop/control/item/ProductSubscriber;)V

    .line 98
    :cond_0
    return-void
.end method


# virtual methods
.method public getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/mShop/mash/OfferListingView;->mMarketPlaceView:Lcom/amazon/mShop/details/MarketPlaceView;

    if-eqz v0, :cond_0

    .line 57
    iget-object v0, p0, Lcom/amazon/mShop/mash/OfferListingView;->mMarketPlaceView:Lcom/amazon/mShop/details/MarketPlaceView;

    invoke-virtual {v0}, Lcom/amazon/mShop/details/MarketPlaceView;->getTitle()Ljava/lang/String;

    move-result-object v0

    .line 59
    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, ""

    goto :goto_0
.end method

.method protected onAttachedToWindow()V
    .locals 2

    .prologue
    .line 65
    invoke-super {p0}, Landroid/widget/LinearLayout;->onAttachedToWindow()V

    .line 66
    iget-object v0, p0, Lcom/amazon/mShop/mash/OfferListingView;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v1, p0, Lcom/amazon/mShop/mash/OfferListingView;->mProductSubscriber:Lcom/amazon/mShop/control/item/ProductSubscriber;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->addSubscriber(Lcom/amazon/mShop/control/item/ProductSubscriber;)V

    .line 69
    iget-object v0, p0, Lcom/amazon/mShop/mash/OfferListingView;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ProductController;->tryStartRequest()V

    .line 70
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 2

    .prologue
    .line 74
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 76
    iget-object v0, p0, Lcom/amazon/mShop/mash/OfferListingView;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v1, p0, Lcom/amazon/mShop/mash/OfferListingView;->mProductSubscriber:Lcom/amazon/mShop/control/item/ProductSubscriber;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->removeSubscriber(Lcom/amazon/mShop/control/item/ProductSubscriber;)V

    .line 77
    return-void
.end method
