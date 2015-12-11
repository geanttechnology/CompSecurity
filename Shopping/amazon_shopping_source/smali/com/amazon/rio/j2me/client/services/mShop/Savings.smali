.class public Lcom/amazon/rio/j2me/client/services/mShop/Savings;
.super Ljava/lang/Object;
.source "Savings.java"


# instance fields
.field private availabilityMessage:Ljava/lang/String;

.field private discountLabel:Ljava/lang/String;

.field private listPrice:Ljava/lang/String;

.field private listPriceLabel:Ljava/lang/String;

.field private percentOff:Ljava/lang/Integer;

.field private prePromoPrice:Ljava/lang/String;

.field private prePromoPriceLabel:Ljava/lang/String;

.field private promoDiscount:Ljava/lang/String;

.field private promoPrice:Ljava/lang/String;

.field private promoPriceLabel:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getPrePromoPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->prePromoPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getPromoPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->promoPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getPromoPriceLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->promoPriceLabel:Ljava/lang/String;

    return-object v0
.end method

.method public setAvailabilityMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 151
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->availabilityMessage:Ljava/lang/String;

    .line 152
    return-void
.end method

.method public setDiscountLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 112
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->discountLabel:Ljava/lang/String;

    .line 113
    return-void
.end method

.method public setListPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->listPrice:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public setListPriceLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->listPriceLabel:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setPercentOff(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 138
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->percentOff:Ljava/lang/Integer;

    .line 139
    return-void
.end method

.method public setPrePromoPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->prePromoPrice:Ljava/lang/String;

    .line 74
    return-void
.end method

.method public setPrePromoPriceLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->prePromoPriceLabel:Ljava/lang/String;

    .line 61
    return-void
.end method

.method public setPromoDiscount(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 125
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->promoDiscount:Ljava/lang/String;

    .line 126
    return-void
.end method

.method public setPromoPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 99
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->promoPrice:Ljava/lang/String;

    .line 100
    return-void
.end method

.method public setPromoPriceLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 86
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->promoPriceLabel:Ljava/lang/String;

    .line 87
    return-void
.end method
