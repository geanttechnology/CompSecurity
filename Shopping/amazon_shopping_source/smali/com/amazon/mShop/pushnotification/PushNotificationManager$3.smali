.class Lcom/amazon/mShop/pushnotification/PushNotificationManager$3;
.super Lcom/amazon/mShop/control/pushnotification/MShopNotificationSubScriber;
.source "PushNotificationManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/pushnotification/PushNotificationManager;->updateDeviceToken(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/pushnotification/PushNotificationManager;

.field final synthetic val$registrationId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/pushnotification/PushNotificationManager;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 169
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager$3;->this$0:Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    iput-object p2, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager$3;->val$registrationId:Ljava/lang/String;

    invoke-direct {p0}, Lcom/amazon/mShop/control/pushnotification/MShopNotificationSubScriber;-><init>()V

    return-void
.end method


# virtual methods
.method public onDeviceTokenUpdated()V
    .locals 3

    .prologue
    .line 185
    iget-object v1, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager$3;->this$0:Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager$3;->val$registrationId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->updateDataStore(Ljava/lang/String;)V

    .line 187
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 188
    .local v0, "context":Landroid/content/Context;
    invoke-static {}, Lcom/amazon/mShop/kiang/KiangController;->getInstance()Lcom/amazon/mShop/kiang/KiangController;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/kiang/KiangController;->kiangUpdate(Landroid/content/Context;)V

    .line 189
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 175
    # getter for: Lcom/amazon/mShop/pushnotification/PushNotificationManager;->DEBUG:Z
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->access$000()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 177
    sget-object v0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->TAG:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 179
    :cond_0
    return-void
.end method
