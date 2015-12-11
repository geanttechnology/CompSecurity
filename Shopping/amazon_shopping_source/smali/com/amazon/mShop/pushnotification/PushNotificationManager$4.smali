.class Lcom/amazon/mShop/pushnotification/PushNotificationManager$4;
.super Lcom/amazon/mShop/control/pushnotification/MShopNotificationSubScriber;
.source "PushNotificationManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/pushnotification/PushNotificationManager;->enableNotificationsForNewMarketplace(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/pushnotification/PushNotificationManager;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/pushnotification/PushNotificationManager;)V
    .locals 0

    .prologue
    .line 218
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager$4;->this$0:Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    invoke-direct {p0}, Lcom/amazon/mShop/control/pushnotification/MShopNotificationSubScriber;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 224
    # getter for: Lcom/amazon/mShop/pushnotification/PushNotificationManager;->DEBUG:Z
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->access$000()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 225
    sget-object v0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->TAG:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 227
    :cond_0
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->setLastMarketPlace(Ljava/lang/String;)V

    .line 228
    return-void
.end method

.method public onMarketplaceToggled(Ljava/lang/String;Z)V
    .locals 2
    .param p1, "marketPlaceId"    # Ljava/lang/String;
    .param p2, "isMarketplaceSupportsNotifications"    # Z

    .prologue
    .line 233
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v0

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/platform/AppLocale;->getMarketPlaceIdByLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 239
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "isSupportNotifications"

    invoke-interface {v0, v1, p2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 240
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->setLastMarketPlace(Ljava/lang/String;)V

    .line 241
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->updateVisibleItems()V

    .line 243
    :cond_0
    return-void
.end method
