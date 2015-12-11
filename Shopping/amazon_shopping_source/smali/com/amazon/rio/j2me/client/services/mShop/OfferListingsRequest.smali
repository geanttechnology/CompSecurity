.class public Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;
.super Ljava/lang/Object;
.source "OfferListingsRequest.java"


# instance fields
.field private asin:Ljava/lang/String;

.field private conditionType:Ljava/lang/String;

.field private page:I

.field private productGroupId:Ljava/lang/String;

.field private size:I

.field private sort:Ljava/lang/String;


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
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getConditionType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;->conditionType:Ljava/lang/String;

    return-object v0
.end method

.method public getPage()I
    .locals 1

    .prologue
    .line 32
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;->page:I

    return v0
.end method

.method public getProductGroupId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;->productGroupId:Ljava/lang/String;

    return-object v0
.end method

.method public getSize()I
    .locals 1

    .prologue
    .line 42
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;->size:I

    return v0
.end method

.method public getSort()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;->sort:Ljava/lang/String;

    return-object v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;->asin:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setConditionType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;->conditionType:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setPage(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 37
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;->page:I

    .line 38
    return-void
.end method

.method public setSize(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 47
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;->size:I

    .line 48
    return-void
.end method
