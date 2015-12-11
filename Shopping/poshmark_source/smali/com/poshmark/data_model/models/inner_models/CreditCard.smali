.class public Lcom/poshmark/data_model/models/inner_models/CreditCard;
.super Ljava/lang/Object;
.source "CreditCard.java"


# instance fields
.field private billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

.field private expirationMonth:Ljava/lang/String;

.field private expirationYear:Ljava/lang/String;

.field private number:Ljava/lang/String;

.field private securityCode:Ljava/lang/String;

.field private useShippingAddress:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 4
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public copy(Lcom/poshmark/data_model/models/inner_models/CreditCard;)V
    .locals 2
    .param p1, "cc"    # Lcom/poshmark/data_model/models/inner_models/CreditCard;

    .prologue
    .line 13
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/CreditCard;->number:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->number:Ljava/lang/String;

    .line 14
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/CreditCard;->expirationMonth:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->expirationMonth:Ljava/lang/String;

    .line 15
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/CreditCard;->expirationYear:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->expirationYear:Ljava/lang/String;

    .line 16
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/CreditCard;->securityCode:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->securityCode:Ljava/lang/String;

    .line 17
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    if-nez v0, :cond_0

    .line 18
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/inner_models/Address;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    .line 19
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p1, Lcom/poshmark/data_model/models/inner_models/CreditCard;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->copy(Lcom/poshmark/data_model/models/inner_models/Address;)V

    .line 20
    iget-boolean v0, p1, Lcom/poshmark/data_model/models/inner_models/CreditCard;->useShippingAddress:Z

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->useShippingAddress:Z

    .line 21
    return-void
.end method

.method public getBillingAddress()Lcom/poshmark/data_model/models/inner_models/Address;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    return-object v0
.end method

.method public getExpirationMonth()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->expirationMonth:Ljava/lang/String;

    return-object v0
.end method

.method public getExpirationYear()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->expirationYear:Ljava/lang/String;

    return-object v0
.end method

.method public getNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->number:Ljava/lang/String;

    return-object v0
.end method

.method public getSecurityCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->securityCode:Ljava/lang/String;

    return-object v0
.end method

.method public setBillingAddress(Lcom/poshmark/data_model/models/inner_models/Address;)V
    .locals 0
    .param p1, "bAddress"    # Lcom/poshmark/data_model/models/inner_models/Address;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    .line 65
    return-void
.end method

.method public setExpirationMonth(Ljava/lang/String;)V
    .locals 0
    .param p1, "expMonth"    # Ljava/lang/String;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->expirationMonth:Ljava/lang/String;

    .line 53
    return-void
.end method

.method public setExpirationYear(Ljava/lang/String;)V
    .locals 0
    .param p1, "expYear"    # Ljava/lang/String;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->expirationYear:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public setNumber(Ljava/lang/String;)V
    .locals 0
    .param p1, "num"    # Ljava/lang/String;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->number:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setSecurityCode(Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->securityCode:Ljava/lang/String;

    .line 61
    return-void
.end method

.method public setUseShippingAddress(Z)V
    .locals 0
    .param p1, "s"    # Z

    .prologue
    .line 68
    iput-boolean p1, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->useShippingAddress:Z

    .line 69
    return-void
.end method

.method public shouldUseShippingAddress()Z
    .locals 1

    .prologue
    .line 44
    iget-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/CreditCard;->useShippingAddress:Z

    return v0
.end method
