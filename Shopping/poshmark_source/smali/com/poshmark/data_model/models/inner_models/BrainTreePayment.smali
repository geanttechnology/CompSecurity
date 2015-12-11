.class public Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;
.super Ljava/lang/Object;
.source "BrainTreePayment.java"


# instance fields
.field cardholder_name:Ljava/lang/String;

.field cc_bin:Ljava/lang/String;

.field cc_token:Ljava/lang/String;

.field cc_type:Ljava/lang/String;

.field expiration_month:I

.field expiration_year:I

.field expiry_date:Ljava/lang/String;

.field last_4:Ljava/lang/String;

.field processor_authorization_code:Ljava/lang/String;

.field processor_response_text:Ljava/lang/String;

.field transaction_id:Ljava/lang/String;

.field transaction_type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCCToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;->cc_token:Ljava/lang/String;

    return-object v0
.end method

.method public getCCType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;->cc_type:Ljava/lang/String;

    return-object v0
.end method

.method public getExpirationMonth()I
    .locals 1

    .prologue
    .line 25
    iget v0, p0, Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;->expiration_month:I

    return v0
.end method

.method public getExpirationYear()I
    .locals 1

    .prologue
    .line 29
    iget v0, p0, Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;->expiration_year:I

    return v0
.end method

.method public getExpiryDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;->expiry_date:Ljava/lang/String;

    return-object v0
.end method

.method public getLast4Digits()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;->last_4:Ljava/lang/String;

    return-object v0
.end method

.method public getProcessorResponseText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/BrainTreePayment;->processor_response_text:Ljava/lang/String;

    return-object v0
.end method
