.class public Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;
.super Ljava/lang/Object;
.source "KiangRegisterResponse.java"


# instance fields
.field private applicationInstallId:Ljava/lang/String;

.field private secret:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getApplicationInstallId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;->applicationInstallId:Ljava/lang/String;

    return-object v0
.end method

.method public getSecret()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;->secret:Ljava/lang/String;

    return-object v0
.end method

.method public setApplicationInstallId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;->applicationInstallId:Ljava/lang/String;

    .line 24
    return-void
.end method

.method public setSecret(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;->secret:Ljava/lang/String;

    .line 37
    return-void
.end method
