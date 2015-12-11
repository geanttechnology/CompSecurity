.class public Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;
.super Ljava/lang/Object;
.source "CartAddition.java"


# instance fields
.field private asin:Ljava/lang/String;

.field private dealId:Ljava/lang/String;

.field private isSavedItem:Z

.field private listId:Ljava/lang/String;

.field private listItemId:Ljava/lang/String;

.field private offerId:Ljava/lang/String;

.field private quantity:I


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
    .line 33
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getDealId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->dealId:Ljava/lang/String;

    return-object v0
.end method

.method public getIsSavedItem()Z
    .locals 1

    .prologue
    .line 92
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->isSavedItem:Z

    return v0
.end method

.method public getListId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->listId:Ljava/lang/String;

    return-object v0
.end method

.method public getListItemId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->listItemId:Ljava/lang/String;

    return-object v0
.end method

.method public getOfferId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->offerId:Ljava/lang/String;

    return-object v0
.end method

.method public getQuantity()I
    .locals 1

    .prologue
    .line 82
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->quantity:I

    return v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->asin:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public setDealId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->dealId:Ljava/lang/String;

    .line 78
    return-void
.end method

.method public setListId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->listId:Ljava/lang/String;

    .line 52
    return-void
.end method

.method public setListItemId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->listItemId:Ljava/lang/String;

    .line 65
    return-void
.end method

.method public setOfferId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->offerId:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setQuantity(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 87
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;->quantity:I

    .line 88
    return-void
.end method
