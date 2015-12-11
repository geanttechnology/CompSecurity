.class Lcom/amazon/mShop/pushnotification/PushNotificationManager$1;
.super Ljava/lang/Object;
.source "PushNotificationManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/pushnotification/PushNotificationManager;->initializePushNotification(Landroid/content/Context;Lcom/amazon/mShop/pushnotification/NotificationProvider;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/pushnotification/PushNotificationManager;

.field final synthetic val$notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/pushnotification/PushNotificationManager;Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager$1;->this$0:Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    iput-object p2, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager$1;->val$notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 95
    # getter for: Lcom/amazon/mShop/pushnotification/PushNotificationManager;->DEBUG:Z
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->access$000()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 96
    sget-object v0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "curent registration id::"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager$1;->val$notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->getDestination()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 98
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager$1;->this$0:Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    iget-object v1, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager$1;->val$notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->getDestination()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->updateDeviceToken(Ljava/lang/String;)V

    .line 99
    return-void
.end method
