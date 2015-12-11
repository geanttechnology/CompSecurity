.class public Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisRequest;
.super Ljava/lang/Object;
.source "IdentifyUserWithSisRequest.java"


# instance fields
.field private deviceInfo:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;"
        }
    .end annotation
.end field

.field private deviceNativeData:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDeviceInfo()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;"
        }
    .end annotation

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisRequest;->deviceInfo:Ljava/util/List;

    return-object v0
.end method

.method public getDeviceNativeData()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;"
        }
    .end annotation

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisRequest;->deviceNativeData:Ljava/util/List;

    return-object v0
.end method

.method public setDeviceInfo(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 23
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisRequest;->deviceInfo:Ljava/util/List;

    .line 24
    return-void
.end method

.method public setDeviceNativeData(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 36
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisRequest;->deviceNativeData:Ljava/util/List;

    .line 37
    return-void
.end method
