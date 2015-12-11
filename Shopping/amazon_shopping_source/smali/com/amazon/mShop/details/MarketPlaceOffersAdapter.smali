.class public Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;
.super Lcom/amazon/mShop/PagedListingAdapter;
.source "MarketPlaceOffersAdapter.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/PagedListingAdapter",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;",
        ">;",
        "Landroid/widget/AdapterView$OnItemClickListener;"
    }
.end annotation


# instance fields
.field private final footer:Landroid/view/ViewGroup;

.field private final productController:Lcom/amazon/mShop/control/item/ProductController;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;Landroid/widget/ListView;Ljava/lang/String;I)V
    .locals 6
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "productController"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p3, "listView"    # Landroid/widget/ListView;
    .param p4, "conditionType"    # Ljava/lang/String;
    .param p5, "offersCount"    # I

    .prologue
    const/4 v5, 0x0

    .line 78
    invoke-direct {p0, p1}, Lcom/amazon/mShop/PagedListingAdapter;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    .line 79
    iput-object p2, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->productController:Lcom/amazon/mShop/control/item/ProductController;

    .line 80
    new-instance v0, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;

    const/16 v1, 0x8

    const/4 v2, 0x6

    invoke-virtual {p2}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2}, Lcom/amazon/mShop/control/item/ProductController;->getRequestId()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;-><init>(IILjava/lang/String;Ljava/lang/String;)V

    .line 81
    .local v0, "offerListingBrowser":Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;
    invoke-virtual {v0, p4}, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;->setConditionType(Ljava/lang/String;)V

    .line 82
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->setBrowser(Lcom/amazon/mShop/control/PagedListingBrowser;)V

    .line 83
    invoke-virtual {v0, p5, v5}, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;->startFirstPageRequest(ILjava/util/List;)Z

    .line 85
    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->loading_progress_footer:I

    invoke-static {p1, v1, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    iput-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->footer:Landroid/view/ViewGroup;

    .line 86
    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->footer:Landroid/view/ViewGroup;

    const/4 v2, 0x0

    invoke-virtual {p3, v1, v5, v2}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 87
    invoke-virtual {p3, p0}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 88
    invoke-virtual {p3, p0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 89
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;I)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;
    .param p1, "x1"    # I

    .prologue
    .line 34
    invoke-direct {p0, p1}, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->setFooterVisibility(I)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;)Lcom/amazon/mShop/control/PagedListingBrowser;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    return-object v0
.end method

.method public static getMarketPlaceOffersView(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/String;)Landroid/view/View;
    .locals 13
    .param p0, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "productController"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p2, "condition"    # Ljava/lang/String;

    .prologue
    .line 48
    invoke-virtual {p1, p2}, Lcom/amazon/mShop/control/item/ProductController;->getConditionalOffersSummary(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;

    move-result-object v11

    .line 49
    .local v11, "summary":Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;->getSummary()Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    move-result-object v9

    .line 50
    .local v9, "offersSummary":Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;->getConditionType()Ljava/lang/String;

    move-result-object v4

    .line 52
    .local v4, "conditonType":Ljava/lang/String;
    sget v0, Lcom/amazon/mShop/android/lib/R$layout;->marketplace_offers_list:I

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v8

    .line 57
    .local v8, "marketplaceOffersView":Landroid/view/View;
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->offers_before_price:I

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 58
    .local v7, "beforePrice":Landroid/widget/TextView;
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->mp_offers_from_before_price:I

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v9}, Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;->getCount()I

    move-result v12

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v2, v5

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 60
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->offers_price:I

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/TextView;

    .line 61
    .local v10, "price":Landroid/widget/TextView;
    invoke-virtual {v9}, Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;->getLowestPrice()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->RED:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    invoke-static {p0, v0, v1}, Lcom/amazon/mShop/util/UIUtils;->convertUnsupportedCharacter(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/mShop/util/UIUtils$CharacterColor;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v10, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 63
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->offers_after_price:I

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 64
    .local v6, "afterPrice":Landroid/widget/TextView;
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->mp_offers_from_after_price:I

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v9}, Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;->getCount()I

    move-result v12

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v2, v5

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 66
    const v0, 0x102000a

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ListView;

    .line 67
    .local v3, "listView":Landroid/widget/ListView;
    new-instance v0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;

    invoke-virtual {v9}, Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;->getCount()I

    move-result v5

    move-object v1, p0

    move-object v2, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;Landroid/widget/ListView;Ljava/lang/String;I)V

    .line 69
    return-object v8
.end method

.method private setFooterVisibility(I)V
    .locals 2
    .param p1, "visibility"    # I

    .prologue
    .line 92
    const/4 v0, 0x0

    .local v0, "footerViewIndex":I
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->footer:Landroid/view/ViewGroup;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 93
    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->footer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/view/View;->setVisibility(I)V

    .line 92
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 95
    :cond_0
    return-void
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 102
    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->setCurrentIndex(I)V

    .line 103
    instance-of v1, p2, Lcom/amazon/mShop/details/MarketPlaceOfferView;

    if-nez v1, :cond_0

    .line 104
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->marketplace_offer:I

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 106
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->getCurrentObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    .local v0, "offer":Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;
    move-object v1, p2

    .line 107
    check-cast v1, Lcom/amazon/mShop/details/MarketPlaceOfferView;

    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/mShop/details/MarketPlaceOfferView;->update(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;)V

    .line 108
    return-object p2
.end method

.method public onCancelled()V
    .locals 1

    .prologue
    .line 149
    invoke-super {p0}, Lcom/amazon/mShop/PagedListingAdapter;->onCancelled()V

    .line 150
    const/16 v0, 0x8

    invoke-direct {p0, v0}, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->setFooterVisibility(I)V

    .line 151
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 158
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/PagedListingAdapter;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 159
    const/16 v1, 0x8

    invoke-direct {p0, v1}, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->setFooterVisibility(I)V

    .line 162
    new-instance v0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter$1;-><init>(Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;)V

    .line 176
    .local v0, "errorHandler":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/AmazonActivity;

    check-cast v1, Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->getContext()Landroid/content/Context;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v2

    invoke-static {v1, v0, v2, p1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;)V

    .line 177
    return-void
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 116
    .local p1, "root":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    if-ltz p3, :cond_0

    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/PagedListingBrowser;->getReceivedCount()I

    move-result v2

    if-lt p3, v2, :cond_1

    .line 127
    :cond_0
    :goto_0
    return-void

    .line 119
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v2, p3}, Lcom/amazon/mShop/control/PagedListingBrowser;->setCurrentIndex(I)V

    .line 120
    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/PagedListingBrowser;->getCurrentObject()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    .line 121
    .local v1, "offerListing":Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 124
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    const-string/jumbo v2, "dp_olp_3p"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 125
    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-static {v0, v2, v1}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->getMarketPlaceOfferDetailView(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;)Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onPageComplete()V
    .locals 2

    .prologue
    .line 138
    invoke-super {p0}, Lcom/amazon/mShop/PagedListingAdapter;->onPageComplete()V

    .line 139
    iget-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->getAvailableCount()I

    move-result v0

    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->getReceivedCount()I

    move-result v1

    if-gt v0, v1, :cond_0

    .line 140
    const/16 v0, 0x8

    invoke-direct {p0, v0}, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->setFooterVisibility(I)V

    .line 142
    :cond_0
    return-void
.end method
