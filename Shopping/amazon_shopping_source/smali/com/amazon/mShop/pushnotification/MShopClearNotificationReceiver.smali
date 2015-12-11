.class public Lcom/amazon/mShop/pushnotification/MShopClearNotificationReceiver;
.super Landroid/content/BroadcastReceiver;
.source "MShopClearNotificationReceiver.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 19
    const-string/jumbo v1, "NotificationType"

    invoke-virtual {p2, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 20
    .local v0, "notificationType":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 21
    invoke-static {v0}, Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;->removeStackedNotifications(Ljava/lang/String;)V

    .line 23
    :cond_0
    return-void
.end method
