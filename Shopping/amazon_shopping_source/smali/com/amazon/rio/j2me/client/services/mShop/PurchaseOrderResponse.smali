.class public Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;
.super Ljava/lang/Object;
.source "PurchaseOrderResponse.java"


# instance fields
.field private acknowledgement:Ljava/lang/String;

.field private address:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Address;",
            ">;"
        }
    .end annotation
.end field

.field private billingAddress:Lcom/amazon/rio/j2me/client/services/mShop/Address;

.field private buyNowSessionId:Ljava/lang/String;

.field private confirmedOrderId:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private creditCardType:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/CreditCardType;",
            ">;"
        }
    .end annotation
.end field

.field private error:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private giftOptionSummary:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionSummary;",
            ">;"
        }
    .end annotation
.end field

.field private info:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private invoiceCategories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/InvoiceCategory;",
            ">;"
        }
    .end annotation
.end field

.field private msToCheckout:Ljava/lang/Integer;

.field private order:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Order;",
            ">;"
        }
    .end annotation
.end field

.field private orderSummary:Lcom/amazon/rio/j2me/client/services/mShop/OrderSummary;

.field private paymentMethod:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;",
            ">;"
        }
    .end annotation
.end field

.field private paymentMethodInfo:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethodInfo;",
            ">;"
        }
    .end annotation
.end field

.field private paymentPlan:Lcom/amazon/rio/j2me/client/services/mShop/PaymentPlan;

.field private paymentType:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PaymentType;",
            ">;"
        }
    .end annotation
.end field

.field private purchaseMessages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;",
            ">;"
        }
    .end annotation
.end field

.field private purchaseStatus:Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;

.field private recipientName:Ljava/lang/String;

.field private shippingAddress:Lcom/amazon/rio/j2me/client/services/mShop/Address;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getConfirmedOrderId()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 274
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->confirmedOrderId:Ljava/util/List;

    return-object v0
.end method

.method public getPurchaseStatus()Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->purchaseStatus:Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;

    return-object v0
.end method

.method public setAcknowledgement(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 149
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->acknowledgement:Ljava/lang/String;

    .line 150
    return-void
.end method

.method public setAddress(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Address;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 266
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Address;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->address:Ljava/util/List;

    .line 267
    return-void
.end method

.method public setBillingAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/Address;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->billingAddress:Lcom/amazon/rio/j2me/client/services/mShop/Address;

    .line 98
    return-void
.end method

.method public setBuyNowSessionId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 188
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->buyNowSessionId:Ljava/lang/String;

    .line 189
    return-void
.end method

.method public setConfirmedOrderId(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 279
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->confirmedOrderId:Ljava/util/List;

    .line 280
    return-void
.end method

.method public setCreditCardType(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/CreditCardType;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 214
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CreditCardType;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->creditCardType:Ljava/util/List;

    .line 215
    return-void
.end method

.method public setError(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 45
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->error:Ljava/util/List;

    .line 46
    return-void
.end method

.method public setGiftOptionSummary(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionSummary;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 175
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionSummary;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->giftOptionSummary:Ljava/util/List;

    .line 176
    return-void
.end method

.method public setInfo(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 58
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->info:Ljava/util/List;

    .line 59
    return-void
.end method

.method public setInvoiceCategories(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/InvoiceCategory;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 201
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/InvoiceCategory;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->invoiceCategories:Ljava/util/List;

    .line 202
    return-void
.end method

.method public setMsToCheckout(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 305
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->msToCheckout:Ljava/lang/Integer;

    .line 306
    return-void
.end method

.method public setOrder(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Order;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 123
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Order;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->order:Ljava/util/List;

    .line 124
    return-void
.end method

.method public setOrderSummary(Lcom/amazon/rio/j2me/client/services/mShop/OrderSummary;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/OrderSummary;

    .prologue
    .line 136
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->orderSummary:Lcom/amazon/rio/j2me/client/services/mShop/OrderSummary;

    .line 137
    return-void
.end method

.method public setPaymentMethod(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 240
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->paymentMethod:Ljava/util/List;

    .line 241
    return-void
.end method

.method public setPaymentMethodInfo(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethodInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 253
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethodInfo;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->paymentMethodInfo:Ljava/util/List;

    .line 254
    return-void
.end method

.method public setPaymentPlan(Lcom/amazon/rio/j2me/client/services/mShop/PaymentPlan;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/PaymentPlan;

    .prologue
    .line 162
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->paymentPlan:Lcom/amazon/rio/j2me/client/services/mShop/PaymentPlan;

    .line 163
    return-void
.end method

.method public setPaymentType(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PaymentType;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 227
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentType;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->paymentType:Ljava/util/List;

    .line 228
    return-void
.end method

.method public setPurchaseMessages(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 71
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->purchaseMessages:Ljava/util/List;

    .line 72
    return-void
.end method

.method public setPurchaseStatus(Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;

    .prologue
    .line 84
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->purchaseStatus:Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;

    .line 85
    return-void
.end method

.method public setRecipientName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 292
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->recipientName:Ljava/lang/String;

    .line 293
    return-void
.end method

.method public setShippingAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/Address;

    .prologue
    .line 110
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->shippingAddress:Lcom/amazon/rio/j2me/client/services/mShop/Address;

    .line 111
    return-void
.end method
