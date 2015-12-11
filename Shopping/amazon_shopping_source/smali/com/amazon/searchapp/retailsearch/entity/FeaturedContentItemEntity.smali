.class public Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentItemEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "FeaturedContentItemEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/FeaturedContentItem;


# instance fields
.field private appUrl:Ljava/lang/String;

.field private label:Ljava/lang/String;

.field private product:Lcom/amazon/searchapp/retailsearch/model/Product;

.field private promotion:Lcom/amazon/searchapp/retailsearch/model/FeaturedPromotion;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentItemEntity;->appUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentItemEntity;->label:Ljava/lang/String;

    return-object v0
.end method

.method public getProduct()Lcom/amazon/searchapp/retailsearch/model/Product;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentItemEntity;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    return-object v0
.end method

.method public getPromotion()Lcom/amazon/searchapp/retailsearch/model/FeaturedPromotion;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentItemEntity;->promotion:Lcom/amazon/searchapp/retailsearch/model/FeaturedPromotion;

    return-object v0
.end method

.method public setAppUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "appUrl"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentItemEntity;->appUrl:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public setLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentItemEntity;->label:Ljava/lang/String;

    .line 103
    return-void
.end method

.method public setProduct(Lcom/amazon/searchapp/retailsearch/model/Product;)V
    .locals 0
    .param p1, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;

    .prologue
    .line 82
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentItemEntity;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    .line 83
    return-void
.end method

.method public setPromotion(Lcom/amazon/searchapp/retailsearch/model/FeaturedPromotion;)V
    .locals 0
    .param p1, "promotion"    # Lcom/amazon/searchapp/retailsearch/model/FeaturedPromotion;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentItemEntity;->promotion:Lcom/amazon/searchapp/retailsearch/model/FeaturedPromotion;

    .line 43
    return-void
.end method
