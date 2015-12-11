.class Lcom/amazon/mShop/pushnotification/NotificationsSettingView$3;
.super Ljava/lang/Object;
.source "NotificationsSettingView.java"

# interfaces
.implements Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)V
    .locals 0

    .prologue
    .line 397
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$3;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionButtonClick(I)V
    .locals 6
    .param p1, "errorId"    # I

    .prologue
    .line 400
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    .line 401
    .local v0, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$3;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    # getter for: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mPendingSubscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    invoke-static {v2}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$400(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 402
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$3;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$3;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    # getter for: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mPendingSubscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    invoke-static {v3}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$400(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    move-result-object v3

    invoke-virtual {v0}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getCurrentMShopDeviceToken()Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->subscribe(Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Ljava/lang/String;)V
    invoke-static {v2, v3, v4}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$900(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Ljava/lang/String;)V

    .line 408
    :goto_0
    return-void

    .line 404
    :cond_0
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v1

    .line 405
    .local v1, "notificationTarget":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$3;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    # getter for: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mNotificationSettingController:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
    invoke-static {v2}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$700(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    move-result-object v2

    new-instance v3, Lcom/amazon/mShop/TaskCallbackFactory;

    iget-object v4, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$3;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    # getter for: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v4}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$100(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    iget-object v4, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$3;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->loading:I

    invoke-virtual {v3, v4, v5}, Lcom/amazon/mShop/TaskCallbackFactory;->getTaskCallback(Lcom/amazon/mShop/control/Cancellable;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v3

    invoke-virtual {v2, v1, v3}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->getNotificationSubscriptions(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;Lcom/amazon/mShop/control/TaskCallback;)V

    goto :goto_0
.end method
