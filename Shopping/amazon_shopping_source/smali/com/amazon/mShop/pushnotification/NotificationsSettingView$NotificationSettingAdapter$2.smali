.class Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$2;
.super Ljava/lang/Object;
.source "NotificationsSettingView.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


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

.field final synthetic val$registrationId:Ljava/lang/String;

.field final synthetic val$subscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 272
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$2;->this$1:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    iput-object p2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$2;->val$subscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    iput-object p3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$2;->val$registrationId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 3
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    .line 277
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$2;->this$1:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    iget-object v0, v0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    iget-object v1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$2;->val$subscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$2;->val$registrationId:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->subscribe(Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$900(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Ljava/lang/String;)V

    .line 278
    return-void
.end method
