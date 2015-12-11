.class public Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;
.super Ljava/lang/Object;
.source "SetOneClickConfigRequest.java"


# instance fields
.field private addressId:Ljava/lang/String;

.field private deviceName:Ljava/lang/String;

.field private oneClickStatus:Ljava/lang/Boolean;

.field private paymentId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAddressId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->addressId:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->deviceName:Ljava/lang/String;

    return-object v0
.end method

.method public getOneClickStatus()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->oneClickStatus:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getPaymentId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->paymentId:Ljava/lang/String;

    return-object v0
.end method

.method public setAddressId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->addressId:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setDeviceName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->deviceName:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setOneClickStatus(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->oneClickStatus:Ljava/lang/Boolean;

    .line 68
    return-void
.end method

.method public setPaymentId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->paymentId:Ljava/lang/String;

    .line 55
    return-void
.end method
