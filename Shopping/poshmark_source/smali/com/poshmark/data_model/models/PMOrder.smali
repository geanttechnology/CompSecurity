.class public Lcom/poshmark/data_model/models/PMOrder;
.super Ljava/lang/Object;
.source "PMOrder.java"


# static fields
.field public static PMORDER_CHECKOUT_TYPE_BUY_BUNDLE:Ljava/lang/String;

.field public static PMORDER_CHECKOUT_TYPE_BUY_NOW:Ljava/lang/String;


# instance fields
.field balance_to_apply:Ljava/math/BigDecimal;

.field public billing_address:Lcom/poshmark/data_model/models/inner_models/Address;

.field checkout_type:Ljava/lang/String;

.field credits_to_apply:Ljava/math/BigDecimal;

.field discounts:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMDiscount;",
            ">;"
        }
    .end annotation
.end field

.field id:Ljava/lang/String;

.field inventory_units:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public last_payment_info:Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

.field line_items:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/LineItem;",
            ">;"
        }
    .end annotation
.end field

.field net_balance:Ljava/math/BigDecimal;

.field offer:Lcom/poshmark/data_model/models/inner_models/Offer;

.field picture_url:Ljava/lang/String;

.field pm_fee:Ljava/math/BigDecimal;

.field redeemable_to_apply:Ljava/math/BigDecimal;

.field seller_earning:Ljava/math/BigDecimal;

.field seller_id:Ljava/lang/String;

.field seller_name:Ljava/lang/String;

.field seller_username:Ljava/lang/String;

.field public shipping_address:Lcom/poshmark/data_model/models/inner_models/Address;

.field shipping_amounts:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/ShippingAmount;",
            ">;"
        }
    .end annotation
.end field

.field shipping_discount_title:Ljava/lang/String;

.field state:Ljava/lang/String;

.field status:Ljava/lang/String;

.field title:Ljava/lang/String;

.field total:Ljava/math/BigDecimal;

.field total_amount:Lcom/poshmark/data_model/models/inner_models/Price;

.field total_discount:Ljava/math/BigDecimal;

.field total_discount_title:Ljava/lang/String;

.field total_original_price:Ljava/math/BigDecimal;

.field total_price:Ljava/math/BigDecimal;

.field total_price_discount:Ljava/math/BigDecimal;

.field total_shipping:Ljava/math/BigDecimal;

.field total_shipping_discount:Ljava/math/BigDecimal;

.field total_tax:Ljava/math/BigDecimal;

.field user_id:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 54
    const-string v0, "bnow"

    sput-object v0, Lcom/poshmark/data_model/models/PMOrder;->PMORDER_CHECKOUT_TYPE_BUY_NOW:Ljava/lang/String;

    .line 55
    const-string v0, "bbdl"

    sput-object v0, Lcom/poshmark/data_model/models/PMOrder;->PMORDER_CHECKOUT_TYPE_BUY_BUNDLE:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->inventory_units:Ljava/util/List;

    .line 25
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->line_items:Ljava/util/List;

    .line 29
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_amounts:Ljava/util/List;

    return-void
.end method

.method private copyLineItems(Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/LineItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 90
    .local p1, "lineItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/LineItem;>;"
    if-nez p1, :cond_1

    .line 91
    iget-object v4, p0, Lcom/poshmark/data_model/models/PMOrder;->line_items:Ljava/util/List;

    if-eqz v4, :cond_0

    .line 92
    iget-object v4, p0, Lcom/poshmark/data_model/models/PMOrder;->line_items:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->clear()V

    .line 108
    :cond_0
    return-void

    .line 95
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    .line 96
    .local v2, "lineItemsCount":I
    if-lez v2, :cond_0

    .line 97
    iget-object v4, p0, Lcom/poshmark/data_model/models/PMOrder;->line_items:Ljava/util/List;

    if-nez v4, :cond_2

    .line 98
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, p0, Lcom/poshmark/data_model/models/PMOrder;->line_items:Ljava/util/List;

    .line 100
    :cond_2
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v2, :cond_0

    .line 101
    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/inner_models/LineItem;

    .line 102
    .local v3, "newLineItem":Lcom/poshmark/data_model/models/inner_models/LineItem;
    new-instance v1, Lcom/poshmark/data_model/models/inner_models/LineItem;

    invoke-direct {v1}, Lcom/poshmark/data_model/models/inner_models/LineItem;-><init>()V

    .line 103
    .local v1, "item":Lcom/poshmark/data_model/models/inner_models/LineItem;
    invoke-virtual {v1, v3}, Lcom/poshmark/data_model/models/inner_models/LineItem;->copy(Lcom/poshmark/data_model/models/inner_models/LineItem;)V

    .line 104
    iget-object v4, p0, Lcom/poshmark/data_model/models/PMOrder;->line_items:Ljava/util/List;

    invoke-interface {v4, v0, v1}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 100
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method private copyShippingAmounts(Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/ShippingAmount;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 111
    .local p1, "shippingAmounts":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/ShippingAmount;>;"
    if-nez p1, :cond_1

    .line 112
    iget-object v4, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_amounts:Ljava/util/List;

    if-eqz v4, :cond_0

    .line 113
    iget-object v4, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_amounts:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->clear()V

    .line 129
    :cond_0
    return-void

    .line 116
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    .line 117
    .local v0, "count":I
    if-lez v0, :cond_0

    .line 118
    iget-object v4, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_amounts:Ljava/util/List;

    if-nez v4, :cond_2

    .line 119
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_amounts:Ljava/util/List;

    .line 121
    :cond_2
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 122
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;

    .line 123
    .local v3, "newItem":Lcom/poshmark/data_model/models/inner_models/ShippingAmount;
    new-instance v2, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;

    invoke-direct {v2}, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;-><init>()V

    .line 124
    .local v2, "item":Lcom/poshmark/data_model/models/inner_models/ShippingAmount;
    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->copy(Lcom/poshmark/data_model/models/inner_models/ShippingAmount;)V

    .line 125
    iget-object v4, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_amounts:Ljava/util/List;

    invoke-interface {v4, v1, v2}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 121
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method


# virtual methods
.method public copy(Lcom/poshmark/data_model/models/PMOrder;)V
    .locals 2
    .param p1, "order"    # Lcom/poshmark/data_model/models/PMOrder;

    .prologue
    .line 58
    iget-object v0, p1, Lcom/poshmark/data_model/models/PMOrder;->id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->id:Ljava/lang/String;

    .line 59
    iget-object v0, p1, Lcom/poshmark/data_model/models/PMOrder;->user_id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->user_id:Ljava/lang/String;

    .line 60
    iget-object v0, p1, Lcom/poshmark/data_model/models/PMOrder;->status:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->status:Ljava/lang/String;

    .line 61
    iget-object v0, p1, Lcom/poshmark/data_model/models/PMOrder;->inventory_units:Ljava/util/List;

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->inventory_units:Ljava/util/List;

    .line 62
    iget-object v0, p1, Lcom/poshmark/data_model/models/PMOrder;->line_items:Ljava/util/List;

    invoke-direct {p0, v0}, Lcom/poshmark/data_model/models/PMOrder;->copyLineItems(Ljava/util/List;)V

    .line 63
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_address:Lcom/poshmark/data_model/models/inner_models/Address;

    if-nez v0, :cond_0

    .line 64
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/inner_models/Address;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_address:Lcom/poshmark/data_model/models/inner_models/Address;

    .line 65
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_address:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p1, Lcom/poshmark/data_model/models/PMOrder;->shipping_address:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->copy(Lcom/poshmark/data_model/models/inner_models/Address;)V

    .line 67
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->billing_address:Lcom/poshmark/data_model/models/inner_models/Address;

    if-nez v0, :cond_1

    .line 68
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/inner_models/Address;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->billing_address:Lcom/poshmark/data_model/models/inner_models/Address;

    .line 69
    :cond_1
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->billing_address:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p1, Lcom/poshmark/data_model/models/PMOrder;->billing_address:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->copy(Lcom/poshmark/data_model/models/inner_models/Address;)V

    .line 71
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->last_payment_info:Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    if-nez v0, :cond_2

    .line 72
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->last_payment_info:Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    .line 73
    :cond_2
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->last_payment_info:Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    iget-object v1, p1, Lcom/poshmark/data_model/models/PMOrder;->last_payment_info:Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->copy(Lcom/poshmark/data_model/models/inner_models/PaymentInfo;)V

    .line 75
    iget-object v0, p1, Lcom/poshmark/data_model/models/PMOrder;->shipping_amounts:Ljava/util/List;

    invoke-direct {p0, v0}, Lcom/poshmark/data_model/models/PMOrder;->copyShippingAmounts(Ljava/util/List;)V

    .line 76
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->offer:Lcom/poshmark/data_model/models/inner_models/Offer;

    if-nez v0, :cond_3

    .line 77
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/Offer;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/inner_models/Offer;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->offer:Lcom/poshmark/data_model/models/inner_models/Offer;

    .line 78
    :cond_3
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->offer:Lcom/poshmark/data_model/models/inner_models/Offer;

    iget-object v1, p1, Lcom/poshmark/data_model/models/PMOrder;->offer:Lcom/poshmark/data_model/models/inner_models/Offer;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Offer;->copy(Lcom/poshmark/data_model/models/inner_models/Offer;)V

    .line 80
    iget-object v0, p1, Lcom/poshmark/data_model/models/PMOrder;->total_tax:Ljava/math/BigDecimal;

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->total_tax:Ljava/math/BigDecimal;

    .line 81
    iget-object v0, p1, Lcom/poshmark/data_model/models/PMOrder;->total:Ljava/math/BigDecimal;

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->total:Ljava/math/BigDecimal;

    .line 82
    iget-object v0, p1, Lcom/poshmark/data_model/models/PMOrder;->balance_to_apply:Ljava/math/BigDecimal;

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->balance_to_apply:Ljava/math/BigDecimal;

    .line 83
    iget-object v0, p1, Lcom/poshmark/data_model/models/PMOrder;->credits_to_apply:Ljava/math/BigDecimal;

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->credits_to_apply:Ljava/math/BigDecimal;

    .line 84
    iget-object v0, p1, Lcom/poshmark/data_model/models/PMOrder;->redeemable_to_apply:Ljava/math/BigDecimal;

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->redeemable_to_apply:Ljava/math/BigDecimal;

    .line 85
    iget-object v0, p1, Lcom/poshmark/data_model/models/PMOrder;->net_balance:Ljava/math/BigDecimal;

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->net_balance:Ljava/math/BigDecimal;

    .line 86
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->total_amount:Lcom/poshmark/data_model/models/inner_models/Price;

    iget-object v1, p1, Lcom/poshmark/data_model/models/PMOrder;->total_amount:Lcom/poshmark/data_model/models/inner_models/Price;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Price;->copy(Lcom/poshmark/data_model/models/inner_models/Price;)V

    .line 87
    return-void
.end method

.method public getBalanceToApply()Ljava/math/BigDecimal;
    .locals 1

    .prologue
    .line 227
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->balance_to_apply:Ljava/math/BigDecimal;

    return-object v0
.end method

.method public getBalanceToApplyString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 231
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMOrder;->balance_to_apply:Ljava/math/BigDecimal;

    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getBasePrice()Ljava/math/BigDecimal;
    .locals 3

    .prologue
    .line 205
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PMOrder;->getLineItems()Ljava/util/List;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/LineItem;

    .line 206
    .local v0, "lineItem":Lcom/poshmark/data_model/models/inner_models/LineItem;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getPrice()Ljava/math/BigDecimal;

    move-result-object v1

    return-object v1
.end method

.method public getBillingAddress()Lcom/poshmark/data_model/models/inner_models/Address;
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->billing_address:Lcom/poshmark/data_model/models/inner_models/Address;

    return-object v0
.end method

.method public getBrainTreeToken()Ljava/lang/String;
    .locals 2

    .prologue
    .line 181
    const/4 v0, 0x0

    .line 182
    .local v0, "token":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/data_model/models/PMOrder;->last_payment_info:Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    if-eqz v1, :cond_0

    .line 183
    iget-object v1, p0, Lcom/poshmark/data_model/models/PMOrder;->last_payment_info:Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->getBrainTreeToken()Ljava/lang/String;

    move-result-object v0

    .line 185
    :cond_0
    return-object v0
.end method

.method public getCheckoutType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 267
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->checkout_type:Ljava/lang/String;

    return-object v0
.end method

.method public getCreditsToApply()Ljava/math/BigDecimal;
    .locals 1

    .prologue
    .line 219
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->credits_to_apply:Ljava/math/BigDecimal;

    return-object v0
.end method

.method public getCreditsToApplyString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 223
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMOrder;->credits_to_apply:Ljava/math/BigDecimal;

    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDiscounts()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMDiscount;",
            ">;"
        }
    .end annotation

    .prologue
    .line 312
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->discounts:Ljava/util/List;

    return-object v0
.end method

.method public getInventoryUnitIds()Ljava/lang/String;
    .locals 5

    .prologue
    .line 166
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    .line 167
    .local v0, "id":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/data_model/models/PMOrder;->line_items:Ljava/util/List;

    if-eqz v3, :cond_1

    .line 168
    iget-object v3, p0, Lcom/poshmark/data_model/models/PMOrder;->line_items:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 169
    .local v2, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/LineItem;>;"
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 170
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/LineItem;

    .line 171
    .local v1, "item":Lcom/poshmark/data_model/models/inner_models/LineItem;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getInventoryUnitId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 172
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 173
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 177
    .end local v1    # "item":Lcom/poshmark/data_model/models/inner_models/LineItem;
    .end local v2    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/LineItem;>;"
    :cond_1
    return-object v0
.end method

.method public getLastPaymentInfo()Lcom/poshmark/data_model/models/inner_models/PaymentInfo;
    .locals 1

    .prologue
    .line 259
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->last_payment_info:Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    return-object v0
.end method

.method public getLineItems()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/LineItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 132
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->line_items:Ljava/util/List;

    return-object v0
.end method

.method public getNetBalance()Ljava/math/BigDecimal;
    .locals 1

    .prologue
    .line 243
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->net_balance:Ljava/math/BigDecimal;

    return-object v0
.end method

.method public getNetBalanceString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 247
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMOrder;->net_balance:Ljava/math/BigDecimal;

    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getOrderId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getOrderListingId()Ljava/lang/String;
    .locals 4

    .prologue
    .line 155
    const/4 v0, 0x0

    .line 156
    .local v0, "id":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/data_model/models/PMOrder;->line_items:Ljava/util/List;

    if-eqz v2, :cond_0

    .line 157
    iget-object v2, p0, Lcom/poshmark/data_model/models/PMOrder;->line_items:Ljava/util/List;

    const/4 v3, 0x0

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/LineItem;

    .line 158
    .local v1, "item":Lcom/poshmark/data_model/models/inner_models/LineItem;
    if-eqz v1, :cond_0

    .line 159
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getProductId()Ljava/lang/String;

    move-result-object v0

    .line 162
    .end local v1    # "item":Lcom/poshmark/data_model/models/inner_models/LineItem;
    :cond_0
    return-object v0
.end method

.method public getPictureUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 283
    iget-object v1, p0, Lcom/poshmark/data_model/models/PMOrder;->picture_url:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 284
    iget-object v1, p0, Lcom/poshmark/data_model/models/PMOrder;->picture_url:Ljava/lang/String;

    .line 292
    :goto_0
    return-object v1

    .line 287
    :cond_0
    iget-object v1, p0, Lcom/poshmark/data_model/models/PMOrder;->line_items:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_1

    .line 288
    iget-object v1, p0, Lcom/poshmark/data_model/models/PMOrder;->line_items:Ljava/util/List;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/LineItem;

    .line 289
    .local v0, "item":Lcom/poshmark/data_model/models/inner_models/LineItem;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getPictureURL()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 292
    .end local v0    # "item":Lcom/poshmark/data_model/models/inner_models/LineItem;
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getRedeemableToApply()Ljava/math/BigDecimal;
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->redeemable_to_apply:Ljava/math/BigDecimal;

    return-object v0
.end method

.method public getRedeemableToApplyString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 239
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMOrder;->redeemable_to_apply:Ljava/math/BigDecimal;

    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSellerName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 300
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->seller_name:Ljava/lang/String;

    return-object v0
.end method

.method public getShippingAddress()Lcom/poshmark/data_model/models/inner_models/Address;
    .locals 1

    .prologue
    .line 251
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_address:Lcom/poshmark/data_model/models/inner_models/Address;

    return-object v0
.end method

.method public getShippingAmount()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/ShippingAmount;",
            ">;"
        }
    .end annotation

    .prologue
    .line 136
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_amounts:Ljava/util/List;

    return-object v0
.end method

.method public getShippingDiscountTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 324
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_discount_title:Ljava/lang/String;

    return-object v0
.end method

.method public getStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 263
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->state:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getTotal()Ljava/math/BigDecimal;
    .locals 1

    .prologue
    .line 197
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->total:Ljava/math/BigDecimal;

    return-object v0
.end method

.method public getTotalDiscountTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 327
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->total_discount_title:Ljava/lang/String;

    return-object v0
.end method

.method public getTotalOriginalPrice()Ljava/math/BigDecimal;
    .locals 1

    .prologue
    .line 304
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->total_original_price:Ljava/math/BigDecimal;

    return-object v0
.end method

.method public getTotalOriginalPriceString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 308
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMOrder;->total_original_price:Ljava/math/BigDecimal;

    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTotalPriceString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 296
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMOrder;->total_price:Ljava/math/BigDecimal;

    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTotalShipping()Ljava/math/BigDecimal;
    .locals 1

    .prologue
    .line 316
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->total_shipping:Ljava/math/BigDecimal;

    return-object v0
.end method

.method public getTotalShippingAmount()Ljava/math/BigDecimal;
    .locals 3

    .prologue
    .line 210
    new-instance v1, Ljava/math/BigDecimal;

    const-string v2, "0"

    invoke-direct {v1, v2}, Ljava/math/BigDecimal;-><init>(Ljava/lang/String;)V

    .line 211
    .local v1, "shippingAmount":Ljava/math/BigDecimal;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_amounts:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 212
    iget-object v2, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_amounts:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->getAmount()Ljava/math/BigDecimal;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/math/BigDecimal;->add(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    .line 211
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 215
    :cond_0
    return-object v1
.end method

.method public getTotalShippingString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 320
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMOrder;->total_shipping:Ljava/math/BigDecimal;

    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTotalString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 201
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMOrder;->total:Ljava/math/BigDecimal;

    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTotalTax()Ljava/math/BigDecimal;
    .locals 1

    .prologue
    .line 189
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->total_tax:Ljava/math/BigDecimal;

    return-object v0
.end method

.method public getTotalTaxString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 193
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMOrder;->total_tax:Ljava/math/BigDecimal;

    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isCreditCardInfoValid()Z
    .locals 5

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 140
    iget-object v4, p0, Lcom/poshmark/data_model/models/PMOrder;->last_payment_info:Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/poshmark/data_model/models/PMOrder;->last_payment_info:Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->isDataAvailable()Z

    move-result v4

    if-eqz v4, :cond_0

    move v0, v2

    .line 141
    .local v0, "creditCardInfoAvailable":Z
    :goto_0
    iget-object v4, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_address:Lcom/poshmark/data_model/models/inner_models/Address;

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/poshmark/data_model/models/PMOrder;->shipping_address:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/Address;->isDataAvailable()Z

    move-result v4

    if-eqz v4, :cond_1

    move v1, v2

    .line 143
    .local v1, "shippingAddressAvailable":Z
    :goto_1
    if-eqz v0, :cond_2

    if-eqz v1, :cond_2

    .line 146
    :goto_2
    return v2

    .end local v0    # "creditCardInfoAvailable":Z
    .end local v1    # "shippingAddressAvailable":Z
    :cond_0
    move v0, v3

    .line 140
    goto :goto_0

    .restart local v0    # "creditCardInfoAvailable":Z
    :cond_1
    move v1, v3

    .line 141
    goto :goto_1

    .restart local v1    # "shippingAddressAvailable":Z
    :cond_2
    move v2, v3

    .line 146
    goto :goto_2
.end method

.method public isOrderCheckoutTypeBundle()Z
    .locals 2

    .prologue
    .line 271
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->checkout_type:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 272
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMOrder;->checkout_type:Ljava/lang/String;

    sget-object v1, Lcom/poshmark/data_model/models/PMOrder;->PMORDER_CHECKOUT_TYPE_BUY_BUNDLE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    .line 275
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
