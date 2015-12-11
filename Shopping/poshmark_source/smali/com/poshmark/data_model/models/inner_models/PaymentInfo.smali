.class public Lcom/poshmark/data_model/models/inner_models/PaymentInfo;
.super Ljava/lang/Object;
.source "PaymentInfo.java"


# instance fields
.field private amount:Ljava/math/BigDecimal;

.field private braintree_payment:Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;

.field private cc_info:Lcom/poshmark/data_model/models/inner_models/CCInfo;

.field private cc_token:Ljava/lang/String;

.field private pay_amount:Lcom/poshmark/data_model/models/inner_models/PayAmount;

.field private type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public copy(Lcom/poshmark/data_model/models/inner_models/PaymentInfo;)V
    .locals 0
    .param p1, "paymentInfo"    # Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    .prologue
    .line 15
    return-void
.end method

.method public getBrainTreeToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->braintree_payment:Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;

    if-eqz v0, :cond_0

    .line 63
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->braintree_payment:Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;->cc_token:Ljava/lang/String;

    .line 67
    :goto_0
    return-object v0

    .line 64
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->cc_info:Lcom/poshmark/data_model/models/inner_models/CCInfo;

    if-eqz v0, :cond_1

    .line 65
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->cc_info:Lcom/poshmark/data_model/models/inner_models/CCInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CCInfo;->cc_token:Ljava/lang/String;

    goto :goto_0

    .line 67
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCreditCardLast4Digits()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->braintree_payment:Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;

    if-eqz v0, :cond_0

    .line 33
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->braintree_payment:Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;->getLast4Digits()Ljava/lang/String;

    move-result-object v0

    .line 37
    :goto_0
    return-object v0

    .line 34
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->cc_info:Lcom/poshmark/data_model/models/inner_models/CCInfo;

    if-eqz v0, :cond_1

    .line 35
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->cc_info:Lcom/poshmark/data_model/models/inner_models/CCInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CCInfo;->last_4:Ljava/lang/String;

    goto :goto_0

    .line 37
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCreditCardType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->braintree_payment:Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;

    if-eqz v0, :cond_0

    .line 23
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->braintree_payment:Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;->getCCType()Ljava/lang/String;

    move-result-object v0

    .line 27
    :goto_0
    return-object v0

    .line 24
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->cc_info:Lcom/poshmark/data_model/models/inner_models/CCInfo;

    if-eqz v0, :cond_1

    .line 25
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->cc_info:Lcom/poshmark/data_model/models/inner_models/CCInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CCInfo;->cc_type:Ljava/lang/String;

    goto :goto_0

    .line 27
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getExpirationMonth()I
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->braintree_payment:Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;

    if-eqz v0, :cond_0

    .line 43
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->braintree_payment:Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;->getExpirationMonth()I

    move-result v0

    .line 47
    :goto_0
    return v0

    .line 44
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->cc_info:Lcom/poshmark/data_model/models/inner_models/CCInfo;

    if-eqz v0, :cond_1

    .line 45
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->cc_info:Lcom/poshmark/data_model/models/inner_models/CCInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CCInfo;->expiration_month:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    .line 47
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getExpirationYear()I
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->braintree_payment:Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;

    if-eqz v0, :cond_0

    .line 53
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->braintree_payment:Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;->getExpirationYear()I

    move-result v0

    .line 57
    :goto_0
    return v0

    .line 54
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->cc_info:Lcom/poshmark/data_model/models/inner_models/CCInfo;

    if-eqz v0, :cond_1

    .line 55
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->cc_info:Lcom/poshmark/data_model/models/inner_models/CCInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CCInfo;->expiration_year:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    .line 57
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getExpiryDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    const/4 v0, 0x0

    return-object v0
.end method

.method public getPaymentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->type:Ljava/lang/String;

    return-object v0
.end method

.method public isDataAvailable()Z
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->braintree_payment:Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->cc_info:Lcom/poshmark/data_model/models/inner_models/CCInfo;

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
