.class public Lcom/bestbuy/android/api/lib/models/pdpoffers/OffersResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private financingOffers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpoffers/FinancingOffers;",
            ">;"
        }
    .end annotation
.end field

.field private names:Lcom/bestbuy/android/api/lib/models/pdpoffers/OfferNames;

.field private productId:I

.field private productType:Ljava/lang/String;

.field private skuId:Ljava/lang/String;

.field private specialOffers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpoffers/SpecialOffers;",
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
.method public getFinancingOffers()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpoffers/FinancingOffers;",
            ">;"
        }
    .end annotation

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpoffers/OffersResponse;->financingOffers:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getNames()Lcom/bestbuy/android/api/lib/models/pdpoffers/OfferNames;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpoffers/OffersResponse;->names:Lcom/bestbuy/android/api/lib/models/pdpoffers/OfferNames;

    return-object v0
.end method

.method public getProductId()I
    .locals 1

    .prologue
    .line 55
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdpoffers/OffersResponse;->productId:I

    return v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpoffers/OffersResponse;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpoffers/OffersResponse;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getSpecialOffers()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpoffers/SpecialOffers;",
            ">;"
        }
    .end annotation

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpoffers/OffersResponse;->specialOffers:Ljava/util/ArrayList;

    return-object v0
.end method

.method public setFinancingOffers(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpoffers/FinancingOffers;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 35
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpoffers/OffersResponse;->financingOffers:Ljava/util/ArrayList;

    .line 36
    return-void
.end method

.method public setNames(Lcom/bestbuy/android/api/lib/models/pdpoffers/OfferNames;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpoffers/OffersResponse;->names:Lcom/bestbuy/android/api/lib/models/pdpoffers/OfferNames;

    .line 52
    return-void
.end method

.method public setProductId(I)V
    .locals 0

    .prologue
    .line 59
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdpoffers/OffersResponse;->productId:I

    .line 60
    return-void
.end method

.method public setProductType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpoffers/OffersResponse;->productType:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpoffers/OffersResponse;->skuId:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setSpecialOffers(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpoffers/SpecialOffers;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpoffers/OffersResponse;->specialOffers:Ljava/util/ArrayList;

    .line 28
    return-void
.end method
