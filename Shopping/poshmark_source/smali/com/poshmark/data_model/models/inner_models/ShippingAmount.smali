.class public Lcom/poshmark/data_model/models/inner_models/ShippingAmount;
.super Ljava/lang/Object;
.source "ShippingAmount.java"


# instance fields
.field amount:Ljava/math/BigDecimal;

.field list_amount:Ljava/math/BigDecimal;

.field seller_id:Ljava/lang/String;

.field shipping_amount:Lcom/poshmark/data_model/models/inner_models/Price;

.field shipping_list_amount:Lcom/poshmark/data_model/models/inner_models/Price;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public copy(Lcom/poshmark/data_model/models/inner_models/ShippingAmount;)V
    .locals 2
    .param p1, "shippingAmount"    # Lcom/poshmark/data_model/models/inner_models/ShippingAmount;

    .prologue
    .line 14
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->amount:Ljava/math/BigDecimal;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->amount:Ljava/math/BigDecimal;

    .line 15
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->list_amount:Ljava/math/BigDecimal;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->list_amount:Ljava/math/BigDecimal;

    .line 16
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->seller_id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->seller_id:Ljava/lang/String;

    .line 17
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->shipping_list_amount:Lcom/poshmark/data_model/models/inner_models/Price;

    iget-object v1, p1, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->shipping_list_amount:Lcom/poshmark/data_model/models/inner_models/Price;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Price;->copy(Lcom/poshmark/data_model/models/inner_models/Price;)V

    .line 18
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->shipping_amount:Lcom/poshmark/data_model/models/inner_models/Price;

    iget-object v1, p1, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->shipping_amount:Lcom/poshmark/data_model/models/inner_models/Price;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Price;->copy(Lcom/poshmark/data_model/models/inner_models/Price;)V

    .line 19
    return-void
.end method

.method public getAmount()Ljava/math/BigDecimal;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->amount:Ljava/math/BigDecimal;

    return-object v0
.end method

.method public getListAmount()Ljava/math/BigDecimal;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->list_amount:Ljava/math/BigDecimal;

    return-object v0
.end method

.method public getSellerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->seller_id:Ljava/lang/String;

    return-object v0
.end method
