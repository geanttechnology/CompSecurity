.class public Lcom/amazon/device/ads/AmazonOOHybridAdBridge;
.super Ljava/lang/Object;
.source "AmazonOOHybridAdBridge.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeListener;,
        Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeSettingsListener;,
        Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeInfo;
    }
.end annotation


# static fields
.field public static final APP_INFO_ADVERTISING_IDENTIFIER_KEY:Ljava/lang/String; = "advertisingIdentifier"

.field public static final APP_INFO_ADVERTISING_IDENTIFIER_MD5_KEY:Ljava/lang/String; = "advertisingIdentifierMD5"

.field public static final APP_INFO_ADVERTISING_IDENTIFIER_SHA1_KEY:Ljava/lang/String; = "advertisingIdentifierSHA1"

.field public static final APP_INFO_ADVERTISING_TRACKING_ENABLED_KEY:Ljava/lang/String; = "advertisingTrackingEnabled"

.field public static final APP_INFO_STABLE_IDENTITY_SERVICE_ID_KEY:Ljava/lang/String; = "stableIdentityServiceId"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 155
    return-void
.end method

.method public static final listenForHybridAdBridgeInfo(Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeListener;)V
    .locals 2
    .param p0, "listener"    # Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeListener;

    .prologue
    .line 30
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    new-instance v1, Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeSettingsListener;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeSettingsListener;-><init>(Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeListener;)V

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/Settings;->listenForSettings(Lcom/amazon/device/ads/Settings$SettingsListener;)V

    .line 31
    return-void
.end method

.method public static final prepareHybridAdBridgeInfo(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 40
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v0

    invoke-interface {v0, p0}, Lcom/amazon/device/ads/IInternalAdRegistration;->contextReceived(Landroid/content/Context;)V

    .line 41
    return-void
.end method

.method public static final prepareHybridAdBridgeInfo(Landroid/content/Context;Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeListener;)V
    .locals 0
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "listener"    # Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeListener;

    .prologue
    .line 51
    invoke-static {p0}, Lcom/amazon/device/ads/AmazonOOHybridAdBridge;->prepareHybridAdBridgeInfo(Landroid/content/Context;)V

    .line 52
    invoke-static {p1}, Lcom/amazon/device/ads/AmazonOOHybridAdBridge;->listenForHybridAdBridgeInfo(Lcom/amazon/device/ads/AmazonOOHybridAdBridge$AmazonOOHybridAdBridgeListener;)V

    .line 53
    return-void
.end method
