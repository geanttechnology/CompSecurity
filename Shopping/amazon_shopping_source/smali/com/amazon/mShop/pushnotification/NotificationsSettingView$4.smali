.class Lcom/amazon/mShop/pushnotification/NotificationsSettingView$4;
.super Ljava/lang/Object;
.source "NotificationsSettingView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->showHeader(Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

.field final synthetic val$helpText:Ljava/lang/String;

.field final synthetic val$url:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 435
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$4;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    iput-object p2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$4;->val$url:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$4;->val$helpText:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 438
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$4;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    # getter for: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$100(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/AmazonBrandedWebView;

    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$4;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    # getter for: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v2}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$100(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$4;->val$url:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$4;->val$helpText:Ljava/lang/String;

    invoke-direct {v1, v2, v3, v4}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 439
    return-void
.end method
