.class Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3$1;
.super Ljava/lang/Object;
.source "CentralSSOLogoutActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;->onSuccess(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;)V
    .locals 0

    .prologue
    .line 124
    iput-object p1, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3$1;->this$1:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 127
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->userSignedOut()V

    .line 129
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3$1;->this$1:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;

    iget-object v1, v1, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->setResult(I)V

    .line 130
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->restartApp()V

    .line 133
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 134
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    .line 135
    .local v0, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    invoke-virtual {v0}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->enbleNotificationForAnonymousCustomer()V

    .line 138
    .end local v0    # "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    :cond_0
    return-void
.end method
