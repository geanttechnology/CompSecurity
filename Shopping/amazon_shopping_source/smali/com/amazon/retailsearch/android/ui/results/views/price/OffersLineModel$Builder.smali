.class public Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel$Builder;
.super Ljava/lang/Object;
.source "OffersLineModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/Prices;ZZ)Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;
    .locals 4
    .param p1, "prices"    # Lcom/amazon/searchapp/retailsearch/model/Prices;
    .param p2, "isPriceVisible"    # Z
    .param p3, "isPriceBackup"    # Z

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 53
    if-ne p3, v3, :cond_0

    if-ne p2, v3, :cond_0

    move-object v0, v2

    .line 87
    :goto_0
    return-object v0

    .line 59
    :cond_0
    if-nez p1, :cond_1

    move-object v0, v2

    .line 61
    goto :goto_0

    .line 64
    :cond_1
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;-><init>()V

    .line 66
    .local v0, "model":Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;
    const/4 v1, 0x0

    .line 67
    .local v1, "offers":Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getUsedAndNewOffers()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v3

    if-eqz v3, :cond_4

    .line 69
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getUsedAndNewOffers()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v1

    .line 80
    :cond_2
    :goto_1
    if-eqz v1, :cond_3

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getMarketplaceLabel()Ljava/util/List;

    move-result-object v3

    if-eqz v3, :cond_3

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getMarketplaceLabel()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_6

    :cond_3
    move-object v0, v2

    .line 82
    goto :goto_0

    .line 71
    :cond_4
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getUsedOffers()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v3

    if-eqz v3, :cond_5

    .line 73
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getUsedOffers()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v1

    goto :goto_1

    .line 75
    :cond_5
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getNewOffers()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 77
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getNewOffers()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    move-result-object v1

    goto :goto_1

    .line 85
    :cond_6
    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getMarketplaceLabel()Ljava/util/List;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;->setStyledText(Ljava/util/List;)V

    goto :goto_0
.end method
