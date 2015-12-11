.class public Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;
.super Ljava/lang/Object;
.source "KiangRegisterRequest.java"


# instance fields
.field private applicationInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;

.field private applicationInstanceInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;

.field private pushInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getApplicationInformation()Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;->applicationInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;

    return-object v0
.end method

.method public getApplicationInstanceInformation()Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;->applicationInstanceInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;

    return-object v0
.end method

.method public getPushInformation()Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;->pushInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;

    return-object v0
.end method

.method public setApplicationInformation(Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;->applicationInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;

    .line 25
    return-void
.end method

.method public setApplicationInstanceInformation(Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;->applicationInstanceInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;

    .line 35
    return-void
.end method

.method public setPushInformation(Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;->pushInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;

    .line 48
    return-void
.end method
