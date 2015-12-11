.class public final Lcom/amazon/device/ads/AdRegistration;
.super Ljava/lang/Object;
.source "AdRegistration.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String; = "AdRegistration"


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final enableLogging(Z)V
    .locals 1
    .param p0, "enable"    # Z

    .prologue
    .line 50
    const-string/jumbo v0, "AdRegistration"

    invoke-static {v0, p0}, Lcom/amazon/device/ads/Log;->enableLoggingWithSetterNotification(Ljava/lang/String;Z)V

    .line 51
    return-void
.end method

.method public static final enableTesting(Z)V
    .locals 3
    .param p0, "enable"    # Z

    .prologue
    .line 62
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    const-string/jumbo v1, "testingEnabled"

    invoke-virtual {v0, v1, p0}, Lcom/amazon/device/ads/Settings;->putTransientBoolean(Ljava/lang/String;Z)V

    .line 63
    const-string/jumbo v0, "AdRegistration"

    const-string/jumbo v1, "Test mode"

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/Log;->logSetterNotification(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 64
    return-void
.end method

.method public static final getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    invoke-static {}, Lcom/amazon/device/ads/Version;->getSDKVersion()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static final registerApp(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 100
    invoke-static {}, Lcom/amazon/device/ads/PermissionChecker;->getInstance()Lcom/amazon/device/ads/PermissionChecker;

    move-result-object v0

    const-string/jumbo v1, "AdRegistration"

    invoke-virtual {v0, p0, v1}, Lcom/amazon/device/ads/PermissionChecker;->passesInternetPermissionCheck(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 108
    :goto_0
    return-void

    .line 105
    :cond_0
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v0

    invoke-interface {v0, p0}, Lcom/amazon/device/ads/IInternalAdRegistration;->contextReceived(Landroid/content/Context;)V

    .line 107
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/device/ads/IInternalAdRegistration;->register()V

    goto :goto_0
.end method

.method public static final setAppKey(Ljava/lang/String;)V
    .locals 1
    .param p0, "appKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 40
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/device/ads/RegistrationInfo;->putAppKey(Ljava/lang/String;)V

    .line 41
    return-void
.end method
