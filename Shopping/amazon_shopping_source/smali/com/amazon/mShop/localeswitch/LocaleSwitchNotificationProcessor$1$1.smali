.class Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;
.super Ljava/lang/Object;
.source "LocaleSwitchNotificationProcessor.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->completed(Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;->this$1:Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;

    iput-object p2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 41
    iget-object v2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;->this$1:Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;

    iget-object v3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v2, v3}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->access$000(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 42
    iget-object v2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;->this$1:Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;

    iget-boolean v2, v2, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->val$triggerSwitchLocaleInCA:Z

    if-nez v2, :cond_1

    .line 44
    iget-object v2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;->this$1:Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;

    # invokes: Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->getSubscriber()Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;
    invoke-static {v2}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->access$100(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;)Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;

    iget-object v3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;->getMarketplaceId()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;->getMarketplaceSupportsNotifications()Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    invoke-virtual {v2, v3, v4}, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;->onMarketplaceToggled(Ljava/lang/String;Z)V

    .line 47
    iget-object v2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;->this$1:Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;

    # invokes: Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->serviceCallCompleted()V
    invoke-static {v2}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->access$200(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;)V

    .line 58
    :cond_0
    :goto_0
    return-void

    .line 50
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;->this$1:Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;

    # invokes: Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->getTaskCallback()Lcom/amazon/mShop/control/TaskCallback;
    invoke-static {v2}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->access$300(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;

    .line 51
    .local v0, "localeSwitchTaskCallback":Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;->getProgressDialog()Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v1

    .line 53
    .local v1, "progDiag":Lcom/amazon/mShop/AmazonProgressDialog;
    :goto_1
    iget-object v2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;->this$1:Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;

    # invokes: Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->getSubscriber()Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;
    invoke-static {v2}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->access$400(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;)Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;

    iget-object v3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;->getMarketplaceId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, v1}, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;->onMarketplaceToggledReuseProgress(Ljava/lang/String;Lcom/amazon/mShop/AmazonProgressDialog;)V

    .line 55
    iget-object v2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1$1;->this$1:Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;

    invoke-virtual {v2}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;->serviceCallCompletedReuseProgDiag()V

    goto :goto_0

    .line 51
    .end local v1    # "progDiag":Lcom/amazon/mShop/AmazonProgressDialog;
    :cond_2
    const/4 v1, 0x0

    goto :goto_1
.end method
