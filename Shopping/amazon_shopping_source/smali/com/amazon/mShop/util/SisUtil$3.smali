.class final Lcom/amazon/mShop/util/SisUtil$3;
.super Ljava/lang/Object;
.source "SisUtil.java"

# interfaces
.implements Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/util/SisUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 150
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onRegistrationInfoReady(Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;)V
    .locals 1
    .param p1, "info"    # Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;

    .prologue
    .line 153
    if-eqz p1, :cond_0

    .line 154
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;->getDeviceInfoParams(Z)Ljava/util/Map;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/SisUtil;->identifyUserSession(Ljava/util/Map;)V

    .line 156
    :cond_0
    return-void
.end method
