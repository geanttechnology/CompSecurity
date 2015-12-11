.class public Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x39d8d511c8dae947L


# instance fields
.field private ep:Ljava/lang/String;

.field private priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

.field private relatedSkus:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RelatedSkus;",
            ">;"
        }
    .end annotation
.end field

.field private relatedUrl:Ljava/lang/String;

.field private skuId:Ljava/lang/String;

.field private summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getEp()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->ep:Ljava/lang/String;

    return-object v0
.end method

.method public getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    return-object v0
.end method

.method public getRelatedSkus()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RelatedSkus;",
            ">;"
        }
    .end annotation

    .prologue
    .line 67
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->relatedSkus:Ljava/util/List;

    return-object v0
.end method

.method public getRelatedUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->relatedUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    return-object v0
.end method

.method public setEp(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 49
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->ep:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    .line 80
    return-void
.end method

.method public setRelatedSkus(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RelatedSkus;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 85
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->relatedSkus:Ljava/util/List;

    .line 86
    return-void
.end method

.method public setRelatedUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->relatedUrl:Ljava/lang/String;

    .line 98
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->skuId:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setSummary(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;)V
    .locals 0

    .prologue
    .line 73
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    .line 74
    return-void
.end method
