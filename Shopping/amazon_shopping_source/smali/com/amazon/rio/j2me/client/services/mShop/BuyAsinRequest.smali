.class public Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;
.super Ljava/lang/Object;
.source "BuyAsinRequest.java"


# instance fields
.field private asin:Ljava/lang/String;

.field private clickStreamOrigin:Ljava/lang/String;

.field private dealId:Ljava/lang/String;

.field private listId:Ljava/lang/String;

.field private listItemId:Ljava/lang/String;

.field private offerId:Ljava/lang/String;

.field private oneClickShippingSpeed:Ljava/lang/String;


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
    .line 23
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getClickStreamOrigin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;->clickStreamOrigin:Ljava/lang/String;

    return-object v0
.end method

.method public getDealId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;->dealId:Ljava/lang/String;

    return-object v0
.end method

.method public getListId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;->listId:Ljava/lang/String;

    return-object v0
.end method

.method public getListItemId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;->listItemId:Ljava/lang/String;

    return-object v0
.end method

.method public getOfferId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;->offerId:Ljava/lang/String;

    return-object v0
.end method

.method public getOneClickShippingSpeed()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;->oneClickShippingSpeed:Ljava/lang/String;

    return-object v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;->asin:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setClickStreamOrigin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;->clickStreamOrigin:Ljava/lang/String;

    .line 101
    return-void
.end method

.method public setOfferId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;->offerId:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public setOneClickShippingSpeed(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 90
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;->oneClickShippingSpeed:Ljava/lang/String;

    .line 91
    return-void
.end method
