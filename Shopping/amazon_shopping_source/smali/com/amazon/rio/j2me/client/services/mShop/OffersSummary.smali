.class public Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
.super Ljava/lang/Object;
.source "OffersSummary.java"


# instance fields
.field private count:I

.field private highestPrice:Ljava/lang/String;

.field private lowestPrice:Ljava/lang/String;

.field private someViolateMap:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 20
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;->count:I

    return v0
.end method

.method public getLowestPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;->lowestPrice:Ljava/lang/String;

    return-object v0
.end method

.method public setCount(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 25
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;->count:I

    .line 26
    return-void
.end method

.method public setHighestPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;->highestPrice:Ljava/lang/String;

    .line 52
    return-void
.end method

.method public setLowestPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;->lowestPrice:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public setSomeViolateMap(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;->someViolateMap:Ljava/lang/Boolean;

    .line 65
    return-void
.end method
