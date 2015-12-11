.class Lcom/amazon/mShop/sso/IdentityType$1$1;
.super Ljava/lang/Object;
.source "IdentityType.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/IdentityType$1;->handleBackgroundService(Lcom/amazon/mShop/sso/SSOBackgroundAccountService;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/IdentityType$1;

.field final synthetic val$applicationContext:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/IdentityType$1;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 117
    iput-object p1, p0, Lcom/amazon/mShop/sso/IdentityType$1$1;->this$0:Lcom/amazon/mShop/sso/IdentityType$1;

    iput-object p2, p0, Lcom/amazon/mShop/sso/IdentityType$1$1;->val$applicationContext:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 121
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->userSignedOut()V

    .line 122
    iget-object v1, p0, Lcom/amazon/mShop/sso/IdentityType$1$1;->val$applicationContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/mShop/ActivityTerminationReceiver;->sendTerminationBroadcast(Landroid/content/Context;)V

    .line 124
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 125
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    .line 126
    .local v0, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    invoke-virtual {v0}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->enbleNotificationForAnonymousCustomer()V

    .line 128
    .end local v0    # "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    :cond_0
    return-void
.end method
