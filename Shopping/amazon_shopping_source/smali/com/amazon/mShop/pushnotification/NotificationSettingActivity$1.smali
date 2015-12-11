.class Lcom/amazon/mShop/pushnotification/NotificationSettingActivity$1;
.super Lcom/amazon/mShop/util/MShopPushNotificationUtils$PushNotificationMessageReceiver;
.source "NotificationSettingActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;)V
    .locals 0

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity$1;->this$0:Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;

    invoke-direct {p0}, Lcom/amazon/mShop/util/MShopPushNotificationUtils$PushNotificationMessageReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 48
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    const-string/jumbo v3, "registration"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 49
    .local v1, "registrationId":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity$1;->this$0:Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 50
    .local v0, "currentView":Landroid/view/View;
    instance-of v2, v0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    if-eqz v2, :cond_0

    .line 51
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity$1;->this$0:Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->isErrorBoxShowing()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 52
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity$1;->this$0:Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->dismissErrorBox()V

    .line 53
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 54
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity$1;->this$0:Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;

    new-instance v3, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    iget-object v4, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity$1;->this$0:Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;

    iget-object v5, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity$1;->this$0:Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;

    invoke-virtual {v5}, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->getIntent()Landroid/content/Intent;

    move-result-object v5

    const-string/jumbo v6, "DefaultExpandedGroupId"

    invoke-virtual {v5, v6}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;-><init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V

    # setter for: Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->mNotificationsSettingView:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;
    invoke-static {v2, v3}, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->access$002(Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    .line 55
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity$1;->this$0:Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;

    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity$1;->this$0:Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;

    # getter for: Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->mNotificationsSettingView:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;
    invoke-static {v3}, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->access$000(Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;)Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->setRootView(Landroid/view/View;)V

    .line 61
    :cond_0
    return-void
.end method
