.class Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3$1;
.super Ljava/lang/Object;
.source "DistributedSSOLogoutActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->onSuccess(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;)V
    .locals 0

    .prologue
    .line 182
    iput-object p1, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3$1;->this$1:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 185
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->userSignedOut()V

    .line 187
    iget-object v1, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3$1;->this$1:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;

    iget-object v1, v1, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->setResult(I)V

    .line 188
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->restartApp()V

    .line 190
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 191
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    .line 192
    .local v0, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    invoke-virtual {v0}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->enbleNotificationForAnonymousCustomer()V

    .line 194
    .end local v0    # "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    :cond_0
    return-void
.end method
