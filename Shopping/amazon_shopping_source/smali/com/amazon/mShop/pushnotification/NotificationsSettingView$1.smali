.class Lcom/amazon/mShop/pushnotification/NotificationsSettingView$1;
.super Ljava/lang/Object;
.source "NotificationsSettingView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/pushnotification/NotificationsSettingView;-><init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V
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
    .line 100
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$1;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 103
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v1

    .line 104
    .local v1, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    invoke-virtual {v1}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getCurrentPushNotificationErrorId()Ljava/lang/String;

    move-result-object v0

    .line 105
    .local v0, "errorId":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$1;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    invoke-virtual {v2, v0}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->showErrorDialog(Ljava/lang/String;)V

    .line 106
    return-void
.end method
