.class Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$4;
.super Ljava/lang/Object;
.source "NotificationSettingController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;)V
    .locals 0

    .prologue
    .line 166
    iput-object p1, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$4;->this$0:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    iput-object p2, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$4;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$4;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 171
    iget-object v0, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$4;->this$0:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    iget-object v1, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$4;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->access$700(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 172
    iget-object v0, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$4;->this$0:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    # getter for: Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->mSubscriber:Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->access$100(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;)Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$4;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;->getMarketplaceId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$4;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;->getMarketplaceSupportsNotifications()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;->onMarketplaceToggled(Ljava/lang/String;Z)V

    .line 173
    iget-object v0, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$4;->this$0:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    # invokes: Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->access$800(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;)V

    .line 175
    :cond_0
    return-void
.end method
