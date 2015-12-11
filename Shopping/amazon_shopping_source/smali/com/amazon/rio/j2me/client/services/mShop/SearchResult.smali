.class public Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
.super Ljava/lang/Object;
.source "SearchResult.java"


# instance fields
.field private basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

.field private basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    return-object v0
.end method

.method public getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    return-object v0
.end method

.method public setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .line 37
    return-void
.end method

.method public setBasicProduct(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    .line 24
    return-void
.end method
