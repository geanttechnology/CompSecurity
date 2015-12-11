.class public Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
.super Ljava/lang/Object;
.source "VariationProductInfo.java"


# instance fields
.field private asin:Ljava/lang/String;

.field private basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

.field private imagesCount:I

.field private listPrice:Ljava/lang/String;

.field private offersSummary:Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

.field private variationAttributes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    return-object v0
.end method

.method public getImagesCount()I
    .locals 1

    .prologue
    .line 68
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->imagesCount:I

    return v0
.end method

.method public getListPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->listPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getOffersSummary()Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->offersSummary:Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    return-object v0
.end method

.method public getVariationAttributes()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->variationAttributes:Ljava/util/List;

    return-object v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->asin:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    .line 86
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .line 87
    return-void
.end method

.method public setImagesCount(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 73
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->imagesCount:I

    .line 74
    return-void
.end method

.method public setListPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->listPrice:Ljava/lang/String;

    .line 64
    return-void
.end method

.method public setOffersSummary(Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->offersSummary:Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    .line 51
    return-void
.end method

.method public setVariationAttributes(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 37
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->variationAttributes:Ljava/util/List;

    .line 38
    return-void
.end method
