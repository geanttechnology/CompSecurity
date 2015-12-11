.class Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeSettingsListener;
.super Ljava/lang/Object;
.source "AmazonOOHybridAdBridge.java"

# interfaces
.implements Lcom/amazon/device/ads/Settings$SettingsListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AmazonOOHybridAdBridge;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AmazonOOHybridAdBridgeSettingsListener"
.end annotation


# instance fields
.field private final listener:Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeListener;


# direct methods
.method public constructor <init>(Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeListener;

    .prologue
    .line 141
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 142
    iput-object p1, p0, Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeSettingsListener;->listener:Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeListener;

    .line 143
    return-void
.end method


# virtual methods
.method public settingsLoaded()V
    .locals 2

    .prologue
    .line 148
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeSettingsListener;->listener:Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeListener;

    invoke-static {}, Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeInfo;->getAmazonOOHybridAdBridgeInfo()Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeInfo;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeListener;->onHybridAdBridgeInfoReceived(Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeInfo;)V

    .line 149
    return-void
.end method
