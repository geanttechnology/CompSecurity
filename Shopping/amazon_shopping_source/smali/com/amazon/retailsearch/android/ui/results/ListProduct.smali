.class public Lcom/amazon/retailsearch/android/ui/results/ListProduct;
.super Lcom/amazon/retailsearch/android/ui/results/ProductView;
.source "ListProduct.java"


# instance fields
.field private ageRange:Landroid/widget/TextView;

.field private availability:Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;

.field private byLine:Landroid/widget/TextView;

.field private esrbRating:Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRating;

.field private fastTrack:Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrack;

.field private forcedPrime:Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;

.field protected newerEditionAvailable:Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;

.field private superSaverShipping:Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;

.field private tradeIn:Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeIn;

.field private variations:Lcom/amazon/retailsearch/android/ui/results/views/messaging/Variations;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 80
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/ProductView;-><init>(Landroid/content/Context;)V

    .line 81
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 74
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/ProductView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 75
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->ListView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 76
    return-void
.end method


# virtual methods
.method protected buildView()V
    .locals 13

    .prologue
    const/16 v12, 0x8

    const/4 v11, 0x0

    .line 121
    invoke-super {p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->buildView()V

    .line 123
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v8}, Lcom/amazon/searchapp/retailsearch/model/Product;->getByLine()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 125
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->byLine:Landroid/widget/TextView;

    invoke-virtual {v8, v12}, Landroid/widget/TextView;->setVisibility(I)V

    .line 134
    :goto_0
    new-instance v8, Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel$Builder;

    invoke-direct {v8}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel$Builder;-><init>()V

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->availabilityInfo:Lcom/amazon/searchapp/retailsearch/model/Availability;

    invoke-virtual {v8, v9}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/Availability;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel;

    move-result-object v2

    .line 135
    .local v2, "fastTrackModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel;
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->fastTrack:Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrack;

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v8, v2, v9}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrack;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 138
    new-instance v8, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel$Builder;

    invoke-direct {v8}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel$Builder;-><init>()V

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->shippingInfo:Lcom/amazon/searchapp/retailsearch/model/Shipping;

    invoke-virtual {v8, v9}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/Shipping;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;

    move-result-object v5

    .line 139
    .local v5, "superSaverShippingModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->superSaverShipping:Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v8, v5, v9}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 142
    new-instance v8, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel$Builder;

    invoke-direct {v8}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel$Builder;-><init>()V

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->availabilityInfo:Lcom/amazon/searchapp/retailsearch/model/Availability;

    invoke-virtual {v8, v9}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/Availability;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;

    move-result-object v0

    .line 143
    .local v0, "availabilityModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->availability:Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v8, v0, v9}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 146
    new-instance v8, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel$Builder;

    invoke-direct {v8}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel$Builder;-><init>()V

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v9}, Lcom/amazon/searchapp/retailsearch/model/Product;->getNonPrimeOffer()Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;

    move-result-object v9

    iget-object v10, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v10}, Lcom/amazon/searchapp/retailsearch/model/Product;->getGroup()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v9, v10}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;Ljava/lang/String;)Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;

    move-result-object v3

    .line 147
    .local v3, "forcedPrimeModel":Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->forcedPrime:Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v8, v3, v9}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 150
    new-instance v8, Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel$Builder;

    invoke-direct {v8}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel$Builder;-><init>()V

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v9}, Lcom/amazon/searchapp/retailsearch/model/Product;->getTradeIn()Lcom/amazon/searchapp/retailsearch/model/TradeIn;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/TradeIn;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;

    move-result-object v6

    .line 151
    .local v6, "tradeInModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->tradeIn:Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeIn;

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v8, v6, v9}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeIn;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 154
    new-instance v8, Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel$Builder;

    invoke-direct {v8}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel$Builder;-><init>()V

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v9}, Lcom/amazon/searchapp/retailsearch/model/Product;->getVariations()Ljava/util/List;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel$Builder;->build(Ljava/util/List;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;

    move-result-object v7

    .line 155
    .local v7, "variationsModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->variations:Lcom/amazon/retailsearch/android/ui/results/views/messaging/Variations;

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v8, v7, v9}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Variations;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 158
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v8}, Lcom/amazon/searchapp/retailsearch/model/Product;->getAgeRange()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 160
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->ageRange:Landroid/widget/TextView;

    invoke-virtual {v8, v12}, Landroid/widget/TextView;->setVisibility(I)V

    .line 169
    :goto_1
    new-instance v8, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRatingModel$Builder;

    invoke-direct {v8}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRatingModel$Builder;-><init>()V

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v9}, Lcom/amazon/searchapp/retailsearch/model/Product;->getAudienceRating()Lcom/amazon/searchapp/retailsearch/model/AudienceRating;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRatingModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/AudienceRating;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRatingModel;

    move-result-object v1

    .line 170
    .local v1, "esrbRatingModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRatingModel;
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->esrbRating:Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRating;

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v8, v1, v9}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRating;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRatingModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 173
    new-instance v8, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel$Builder;

    invoke-direct {v8}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel$Builder;-><init>()V

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v9}, Lcom/amazon/searchapp/retailsearch/model/Product;->getNewerVersion()Lcom/amazon/searchapp/retailsearch/model/NewerVersion;

    move-result-object v9

    iget-object v10, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v10}, Lcom/amazon/searchapp/retailsearch/model/Product;->getGroup()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v9, v10}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/NewerVersion;Ljava/lang/String;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;

    move-result-object v4

    .line 175
    .local v4, "newerEditionAvailableModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->newerEditionAvailable:Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v8, v4, v9}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 176
    return-void

    .line 129
    .end local v0    # "availabilityModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;
    .end local v1    # "esrbRatingModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRatingModel;
    .end local v2    # "fastTrackModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel;
    .end local v3    # "forcedPrimeModel":Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;
    .end local v4    # "newerEditionAvailableModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;
    .end local v5    # "superSaverShippingModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;
    .end local v6    # "tradeInModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;
    .end local v7    # "variationsModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;
    :cond_0
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->byLine:Landroid/widget/TextView;

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v9}, Lcom/amazon/searchapp/retailsearch/model/Product;->getByLine()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 130
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->byLine:Landroid/widget/TextView;

    invoke-virtual {v8, v11}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_0

    .line 164
    .restart local v0    # "availabilityModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;
    .restart local v2    # "fastTrackModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel;
    .restart local v3    # "forcedPrimeModel":Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;
    .restart local v5    # "superSaverShippingModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;
    .restart local v6    # "tradeInModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;
    .restart local v7    # "variationsModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;
    :cond_1
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->ageRange:Landroid/widget/TextView;

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v9}, Lcom/amazon/searchapp/retailsearch/model/Product;->getAgeRange()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 165
    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->ageRange:Landroid/widget/TextView;

    invoke-virtual {v8, v11}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method

.method protected init(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 86
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->init(Landroid/content/Context;)V

    .line 87
    sget v0, Lcom/amazon/retailsearch/R$layout;->list_product_items:I

    invoke-static {p1, v0, p0}, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 88
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->initProductElements()V

    .line 90
    return-void
.end method

.method protected initProductElements()V
    .locals 2

    .prologue
    .line 95
    invoke-super {p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->initProductElements()V

    .line 97
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_item_byline:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->byLine:Landroid/widget/TextView;

    .line 99
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_fast_track:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrack;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->fastTrack:Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrack;

    .line 100
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_super_saver_shipping:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->superSaverShipping:Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;

    .line 102
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_availability:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->availability:Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;

    .line 103
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_forced_prime:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->forcedPrime:Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;

    .line 104
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->gestureListener:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->forcedPrime:Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->addTapTarget(Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;)V

    .line 106
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_trade_in:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeIn;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->tradeIn:Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeIn;

    .line 107
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_variations:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Variations;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->variations:Lcom/amazon/retailsearch/android/ui/results/views/messaging/Variations;

    .line 108
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_item_age_range:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->ageRange:Landroid/widget/TextView;

    .line 109
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_esrb_rating:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRating;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->esrbRating:Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRating;

    .line 110
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_newer_edition_available:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->newerEditionAvailable:Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;

    .line 111
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->gestureListener:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->newerEditionAvailable:Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->addTapTarget(Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;)V

    .line 112
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->gestureListener:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/ListProduct;->twister:Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->addTapTarget(Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;)V

    .line 113
    return-void
.end method
