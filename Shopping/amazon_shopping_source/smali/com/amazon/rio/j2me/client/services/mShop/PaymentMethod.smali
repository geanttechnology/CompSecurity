.class public Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
.super Ljava/lang/Object;
.source "PaymentMethod.java"


# instance fields
.field private brand:Ljava/lang/String;

.field private cardId:Ljava/lang/String;

.field private gcAmount:Ljava/lang/String;

.field private gcCurrency:Ljava/lang/String;

.field private gcDisplay:Ljava/lang/String;

.field private issuer:Ljava/lang/String;

.field private method:Ljava/lang/String;

.field private month:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private number:Ljava/lang/String;

.field private year:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCardId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->cardId:Ljava/lang/String;

    return-object v0
.end method

.method public getIssuer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->issuer:Ljava/lang/String;

    return-object v0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->method:Ljava/lang/String;

    return-object v0
.end method

.method public getMonth()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->month:Ljava/lang/String;

    return-object v0
.end method

.method public getNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->number:Ljava/lang/String;

    return-object v0
.end method

.method public getYear()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->year:Ljava/lang/String;

    return-object v0
.end method

.method public setBrand(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->brand:Ljava/lang/String;

    .line 36
    return-void
.end method

.method public setCardId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->cardId:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setGcAmount(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 139
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->gcAmount:Ljava/lang/String;

    .line 140
    return-void
.end method

.method public setGcCurrency(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 152
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->gcCurrency:Ljava/lang/String;

    .line 153
    return-void
.end method

.method public setGcDisplay(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 165
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->gcDisplay:Ljava/lang/String;

    .line 166
    return-void
.end method

.method public setIssuer(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->issuer:Ljava/lang/String;

    .line 62
    return-void
.end method

.method public setMethod(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->method:Ljava/lang/String;

    .line 75
    return-void
.end method

.method public setMonth(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 87
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->month:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->name:Ljava/lang/String;

    .line 101
    return-void
.end method

.method public setNumber(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 113
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->number:Ljava/lang/String;

    .line 114
    return-void
.end method

.method public setYear(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 126
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->year:Ljava/lang/String;

    .line 127
    return-void
.end method
