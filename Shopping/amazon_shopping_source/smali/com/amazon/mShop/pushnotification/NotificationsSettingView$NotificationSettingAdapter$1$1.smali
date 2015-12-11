.class Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1$1;
.super Ljava/lang/Object;
.source "NotificationsSettingView.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;

.field final synthetic val$request:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)V
    .locals 0

    .prologue
    .line 237
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1$1;->this$2:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;

    iput-object p2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1$1;->val$request:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public userCancelledSignIn()V
    .locals 2

    .prologue
    .line 240
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1$1;->this$2:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;

    iget-object v0, v0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;->this$1:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    iget-object v0, v0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    const/4 v1, 0x0

    # invokes: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->refreshUI(Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$600(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;)V

    .line 241
    return-void
.end method

.method public userSuccessfullySignedIn()V
    .locals 6

    .prologue
    .line 244
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    .line 245
    .local v0, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    iget-object v1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1$1;->this$2:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;

    iget-object v1, v1, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;->this$1:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    iget-object v1, v1, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    # getter for: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mNotificationSettingController:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
    invoke-static {v1}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$700(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1$1;->val$request:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    new-instance v4, Lcom/amazon/mShop/TaskCallbackFactory;

    iget-object v5, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1$1;->this$2:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;

    iget-object v5, v5, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;->this$1:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    iget-object v5, v5, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    # getter for: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v5}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$100(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    iget-object v5, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1$1;->this$2:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;

    iget-object v5, v5, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;->this$1:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    iget-object v5, v5, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/TaskCallbackFactory;->getTaskCallback(Lcom/amazon/mShop/control/Cancellable;)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->updateNotificationSubscriptions(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 250
    iget-object v1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1$1;->this$2:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;

    iget-object v1, v1, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;->this$1:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    iget-object v1, v1, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    const/4 v2, 0x1

    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1$1;->this$2:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;

    iget-object v3, v3, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;->val$subscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    # invokes: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->logRefMarker(ZLcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)V
    invoke-static {v1, v2, v3}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$800(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;ZLcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)V

    .line 251
    return-void
.end method
