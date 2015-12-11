.class public final Lcom/amazon/mShop/util/MShopPushNotificationUtils;
.super Ljava/lang/Object;
.source "MShopPushNotificationUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/util/MShopPushNotificationUtils$PushNotificationMessageReceiver;
    }
.end annotation


# static fields
.field private static sLastMarketPlace:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 48
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->sLastMarketPlace:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    return-void
.end method

.method public static getLastMarketPlace()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    sget-object v0, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->sLastMarketPlace:Ljava/lang/String;

    return-object v0
.end method

.method public static isMarketplaceSupportsNotification()Z
    .locals 3

    .prologue
    .line 45
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "isSupportNotifications"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public static isPushNotificationAvailable()Z
    .locals 1

    .prologue
    .line 59
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static setLastMarketPlace(Ljava/lang/String;)V
    .locals 0
    .param p0, "lastMarketPlace"    # Ljava/lang/String;

    .prologue
    .line 55
    sput-object p0, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->sLastMarketPlace:Ljava/lang/String;

    .line 56
    return-void
.end method
