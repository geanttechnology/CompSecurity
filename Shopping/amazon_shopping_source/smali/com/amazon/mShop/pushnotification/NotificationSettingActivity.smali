.class public Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "NotificationSettingActivity.java"


# instance fields
.field private mNotificationsSettingView:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

.field private mPushNotificationMessageReceiver:Lcom/amazon/mShop/util/MShopPushNotificationUtils$PushNotificationMessageReceiver;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;)Lcom/amazon/mShop/pushnotification/NotificationsSettingView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;

    .prologue
    .line 15
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->mNotificationsSettingView:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    return-object v0
.end method

.method static synthetic access$002(Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/mShop/pushnotification/NotificationsSettingView;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;
    .param p1, "x1"    # Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    .prologue
    .line 15
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->mNotificationsSettingView:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    return-object p1
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 101
    if-nez p1, :cond_0

    .line 102
    invoke-virtual {p0}, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string/jumbo v1, "onResumeNeedRefresh"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 104
    :cond_0
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mShop/AmazonActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 105
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 36
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 37
    new-instance v0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity$1;-><init>(Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;)V

    iput-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->mPushNotificationMessageReceiver:Lcom/amazon/mShop/util/MShopPushNotificationUtils$PushNotificationMessageReceiver;

    .line 63
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->mPushNotificationMessageReceiver:Lcom/amazon/mShop/util/MShopPushNotificationUtils$PushNotificationMessageReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string/jumbo v2, "com.amazon.mShop.android.PUSH_NOTIFICATION_RESPONSE"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 64
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->mPushNotificationMessageReceiver:Lcom/amazon/mShop/util/MShopPushNotificationUtils$PushNotificationMessageReceiver;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 90
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->mPushNotificationMessageReceiver:Lcom/amazon/mShop/util/MShopPushNotificationUtils$PushNotificationMessageReceiver;

    .line 91
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onDestroy()V

    .line 92
    return-void
.end method

.method public onStart()V
    .locals 4

    .prologue
    .line 75
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStart()V

    .line 77
    invoke-virtual {p0}, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string/jumbo v2, "onResumeNeedRefresh"

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 78
    invoke-virtual {p0}, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string/jumbo v2, "DefaultExpandedGroupId"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 79
    .local v0, "expandedGroup":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    invoke-direct {v1, p0, v0}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;-><init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->mNotificationsSettingView:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    .line 80
    iget-object v1, p0, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->mNotificationsSettingView:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->setRootView(Landroid/view/View;)V

    .line 83
    .end local v0    # "expandedGroup":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/pushnotification/NotificationSettingActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string/jumbo v2, "onResumeNeedRefresh"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->removeExtra(Ljava/lang/String;)V

    .line 85
    return-void
.end method
