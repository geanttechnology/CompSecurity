.class public Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethodInfo;
.super Ljava/lang/Object;
.source "PaymentMethodInfo.java"


# instance fields
.field private header:Ljava/lang/String;

.field private headerDetails:Ljava/lang/String;

.field private instructions:Ljava/lang/String;

.field private name:Ljava/lang/String;

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
.method public setHeader(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethodInfo;->header:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public setHeaderDetails(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethodInfo;->headerDetails:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setInstructions(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethodInfo;->instructions:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethodInfo;->name:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setPaymentMethodId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethodInfo;->paymentMethodId:Ljava/lang/String;

    .line 27
    return-void
.end method
