.class Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;
.super Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
.source "LocaleSwitchNotificationProcessor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor;->doProcess(Ljava/lang/String;Landroid/content/Context;Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor;

.field final synthetic val$triggerSwitchLocaleInCA:Z


# direct methods
.method constructor <init>(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor;Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;Z)V
    .locals 0
    .param p2, "x0"    # Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->this$0:Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor;

    iput-boolean p3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->val$triggerSwitchLocaleInCA:Z

    invoke-direct {p0, p2}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;-><init>(Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;)V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 30
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;)Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;

    .prologue
    .line 30
    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->getSubscriber()Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;

    .prologue
    .line 30
    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;)Lcom/amazon/mShop/control/TaskCallback;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;

    .prologue
    .line 30
    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->getTaskCallback()Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;)Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;

    .prologue
    .line 30
    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->getSubscriber()Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 36
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;-><init>(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 60
    return-void
.end method

.method protected handleServiceCallError()V
    .locals 3

    .prologue
    .line 68
    iget-boolean v2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->val$triggerSwitchLocaleInCA:Z

    if-nez v2, :cond_0

    .line 70
    invoke-super {p0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->handleServiceCallError()V

    .line 79
    :goto_0
    return-void

    .line 74
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->getTaskCallback()Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;

    .line 75
    .local v0, "localeSwitchTaskCallback":Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;->getProgressDialog()Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v1

    .line 77
    .local v1, "progDiag":Lcom/amazon/mShop/AmazonProgressDialog;
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->getSubscriber()Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;

    invoke-virtual {v2, v1}, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;->setProgDiag(Lcom/amazon/mShop/AmazonProgressDialog;)V

    .line 78
    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->serviceCallCompletedReuseProgDiag()V

    goto :goto_0

    .line 75
    .end local v1    # "progDiag":Lcom/amazon/mShop/AmazonProgressDialog;
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method protected serviceCallCompletedReuseProgDiag()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 85
    invoke-super {p0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->getTaskCallback()Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 86
    invoke-super {p0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->getTaskCallback()Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;

    .line 87
    .local v0, "localeSwitchTaskCallback":Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;
    invoke-virtual {v0}, Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;->endTaskWithoutDismissProgDiag()V

    .line 88
    invoke-super {p0, v2}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->setTaskCallback(Lcom/amazon/mShop/control/TaskCallback;)V

    .line 90
    .end local v0    # "localeSwitchTaskCallback":Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;
    :cond_0
    invoke-super {p0, v2}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->setServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 91
    return-void
.end method
