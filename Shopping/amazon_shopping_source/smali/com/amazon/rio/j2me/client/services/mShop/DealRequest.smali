.class public Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;
.super Ljava/lang/Object;
.source "DealRequest.java"


# instance fields
.field private asin:Ljava/lang/String;

.field private dealId:Ljava/lang/String;

.field private maxImageDimension:Ljava/lang/Integer;

.field private maxSwatchDimension:Ljava/lang/Integer;

.field private noPrefetchChildren:Ljava/lang/Boolean;

.field private showVariations:Ljava/lang/Boolean;


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
    .line 38
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getDealId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;->dealId:Ljava/lang/String;

    return-object v0
.end method

.method public getMaxImageDimension()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;->maxImageDimension:Ljava/lang/Integer;

    return-object v0
.end method

.method public getMaxSwatchDimension()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;->maxSwatchDimension:Ljava/lang/Integer;

    return-object v0
.end method

.method public getNoPrefetchChildren()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;->noPrefetchChildren:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getShowVariations()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;->showVariations:Ljava/lang/Boolean;

    return-object v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;->asin:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setDealId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;->dealId:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public setShowVariations(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;->showVariations:Ljava/lang/Boolean;

    .line 57
    return-void
.end method
