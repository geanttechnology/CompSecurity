.class public Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;
.super Ljava/lang/Object;
.source "OneClickConfigResponse.java"


# instance fields
.field private address:Lcom/amazon/rio/j2me/client/services/mShop/Address;

.field private deviceName:Ljava/lang/String;

.field private oneClickStatus:Z

.field private paymentMethod:Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

.field private shippingSpeed:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAddress()Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->address:Lcom/amazon/rio/j2me/client/services/mShop/Address;

    return-object v0
.end method

.method public getDeviceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->deviceName:Ljava/lang/String;

    return-object v0
.end method

.method public getOneClickStatus()Z
    .locals 1

    .prologue
    .line 21
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->oneClickStatus:Z

    return v0
.end method

.method public getPaymentMethod()Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->paymentMethod:Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    return-object v0
.end method

.method public setAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/Address;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->address:Lcom/amazon/rio/j2me/client/services/mShop/Address;

    .line 53
    return-void
.end method

.method public setDeviceName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->deviceName:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setOneClickStatus(Z)V
    .locals 0
    .param p1, "value_"    # Z

    .prologue
    .line 26
    iput-boolean p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->oneClickStatus:Z

    .line 27
    return-void
.end method

.method public setPaymentMethod(Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->paymentMethod:Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    .line 66
    return-void
.end method

.method public setShippingSpeed(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->shippingSpeed:Ljava/lang/String;

    .line 79
    return-void
.end method
