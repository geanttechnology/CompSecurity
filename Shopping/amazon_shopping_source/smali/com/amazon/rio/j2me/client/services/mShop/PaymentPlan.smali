.class public Lcom/amazon/rio/j2me/client/services/mShop/PaymentPlan;
.super Ljava/lang/Object;
.source "PaymentPlan.java"


# instance fields
.field private creditCardId:Ljava/lang/String;

.field private desc:Ljava/lang/String;

.field private desc2:Ljava/lang/String;

.field private giftCardAmount:Ljava/lang/String;

.field private paymentMethodId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setCreditCardId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentPlan;->creditCardId:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public setDesc(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentPlan;->desc:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public setDesc2(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentPlan;->desc2:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setGiftCardAmount(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentPlan;->giftCardAmount:Ljava/lang/String;

    .line 82
    return-void
.end method

.method public setPaymentMethodId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 29
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentPlan;->paymentMethodId:Ljava/lang/String;

    .line 30
    return-void
.end method
