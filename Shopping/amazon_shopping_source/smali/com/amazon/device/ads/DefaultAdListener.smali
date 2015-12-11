.class public Lcom/amazon/device/ads/DefaultAdListener;
.super Ljava/lang/Object;
.source "DefaultAdListener.java"

# interfaces
.implements Lcom/amazon/device/ads/AdListener;


# instance fields
.field final LOG_TAG:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/device/ads/DefaultAdListener;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/device/ads/DefaultAdListener;-><init>(Ljava/lang/String;)V

    .line 23
    return-void
.end method

.method constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "logTag"    # Ljava/lang/String;

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/amazon/device/ads/DefaultAdListener;->LOG_TAG:Ljava/lang/String;

    .line 28
    return-void
.end method


# virtual methods
.method public onAdCollapsed(Lcom/amazon/device/ads/Ad;)V
    .locals 2
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/amazon/device/ads/DefaultAdListener;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "Default ad listener called - Ad Collapsed."

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    return-void
.end method

.method public onAdDismissed(Lcom/amazon/device/ads/Ad;)V
    .locals 2
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/device/ads/DefaultAdListener;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "Default ad listener called - Ad Dismissed."

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    return-void
.end method

.method public onAdExpanded(Lcom/amazon/device/ads/Ad;)V
    .locals 2
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/device/ads/DefaultAdListener;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "Default ad listener called - Ad Will Expand."

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    return-void
.end method

.method public onAdFailedToLoad(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdError;)V
    .locals 5
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;
    .param p2, "error"    # Lcom/amazon/device/ads/AdError;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/device/ads/DefaultAdListener;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "Default ad listener called - Ad Failed to Load. Error code: %s, Error Message: %s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p2}, Lcom/amazon/device/ads/AdError;->getCode()Lcom/amazon/device/ads/AdError$ErrorCode;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-virtual {p2}, Lcom/amazon/device/ads/AdError;->getMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 46
    return-void
.end method

.method public onAdLoaded(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdProperties;)V
    .locals 2
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;
    .param p2, "adProperties"    # Lcom/amazon/device/ads/AdProperties;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/device/ads/DefaultAdListener;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "Default ad listener called - AdLoaded."

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 37
    return-void
.end method
