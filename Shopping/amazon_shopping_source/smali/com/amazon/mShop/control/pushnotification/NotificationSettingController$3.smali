.class Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$3;
.super Ljava/lang/Object;
.source "NotificationSettingController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0

    .prologue
    .line 150
    iput-object p1, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$3;->this$0:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    iput-object p2, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$3;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 155
    iget-object v0, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$3;->this$0:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    iget-object v1, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$3;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->access$500(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 156
    iget-object v0, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$3;->this$0:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    # getter for: Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->mSubscriber:Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->access$100(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;)Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;->onDeviceTokenUpdated()V

    .line 157
    iget-object v0, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$3;->this$0:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    # invokes: Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->access$600(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;)V

    .line 159
    :cond_0
    return-void
.end method
