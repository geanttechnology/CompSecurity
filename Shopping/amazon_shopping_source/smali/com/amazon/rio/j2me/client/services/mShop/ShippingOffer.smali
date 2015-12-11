.class public Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
.super Ljava/lang/Object;
.source "ShippingOffer.java"


# instance fields
.field private deliveryDate:Lcom/amazon/rio/j2me/client/services/mShop/Date;

.field private getItText:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private price:Ljava/lang/String;

.field private remainingMinutes:Ljava/lang/Integer;

.field private shipOption:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDeliveryDate()Lcom/amazon/rio/j2me/client/services/mShop/Date;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->deliveryDate:Lcom/amazon/rio/j2me/client/services/mShop/Date;

    return-object v0
.end method

.method public getGetItText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->getItText:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getRemainingMinutes()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->remainingMinutes:Ljava/lang/Integer;

    return-object v0
.end method

.method public getShipOption()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->shipOption:Ljava/lang/String;

    return-object v0
.end method

.method public setDeliveryDate(Lcom/amazon/rio/j2me/client/services/mShop/Date;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/Date;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->deliveryDate:Lcom/amazon/rio/j2me/client/services/mShop/Date;

    .line 64
    return-void
.end method

.method public setGetItText(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->getItText:Ljava/lang/String;

    .line 77
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->name:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->price:Ljava/lang/String;

    .line 51
    return-void
.end method

.method public setRemainingMinutes(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->remainingMinutes:Ljava/lang/Integer;

    .line 90
    return-void
.end method

.method public setShipOption(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->shipOption:Ljava/lang/String;

    .line 38
    return-void
.end method
