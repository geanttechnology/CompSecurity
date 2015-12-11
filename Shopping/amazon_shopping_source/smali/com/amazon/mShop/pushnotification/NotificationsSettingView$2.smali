.class Lcom/amazon/mShop/pushnotification/NotificationsSettingView$2;
.super Ljava/lang/Object;
.source "NotificationsSettingView.java"

# interfaces
.implements Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->showErrorDialog(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

.field final synthetic val$errorId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 120
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$2;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    iput-object p2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$2;->val$errorId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionButtonClick(I)V
    .locals 3
    .param p1, "error"    # I

    .prologue
    .line 123
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$2;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    # getter for: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$100(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$2;->val$errorId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->handleClickActionOnErrorButton(Landroid/app/Activity;Ljava/lang/String;)V

    .line 124
    return-void
.end method
