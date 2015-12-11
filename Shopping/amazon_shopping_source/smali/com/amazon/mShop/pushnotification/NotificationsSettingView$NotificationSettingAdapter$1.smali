.class Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;
.super Ljava/lang/Object;
.source "NotificationsSettingView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

.field final synthetic val$subscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)V
    .locals 0

    .prologue
    .line 226
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;->this$1:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    iput-object p2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;->val$subscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x1

    .line 229
    iget-object v1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;->this$1:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    iget-object v1, v1, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;->val$subscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    # setter for: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mPendingSubscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    invoke-static {v1, v2}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$402(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    .line 230
    iget-object v1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;->this$1:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    iget-object v1, v1, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    # setter for: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mPendingSubscribed:Z
    invoke-static {v1, v3}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$502(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Z)Z

    .line 232
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;-><init>()V

    .line 233
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    iget-object v1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;->val$subscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getGroupId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->setGroupId(Ljava/lang/String;)V

    .line 234
    iget-object v1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;->val$subscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getSubscriptionId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->setSubscriptionId(Ljava/lang/String;)V

    .line 235
    invoke-virtual {v0, v3}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->setSubscribed(Z)V

    .line 237
    iget-object v1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;->this$1:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    iget-object v1, v1, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    # getter for: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$100(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1$1;

    invoke-direct {v2, p0, v0}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1$1;-><init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)V

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/AmazonActivity;->authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V

    .line 254
    return-void
.end method
