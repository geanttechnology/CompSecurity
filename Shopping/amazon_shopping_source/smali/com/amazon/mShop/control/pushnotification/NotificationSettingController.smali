.class public Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
.super Lcom/amazon/mShop/control/BaseController;
.source "NotificationSettingController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponseListener;
.implements Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsResponseListener;
.implements Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponseListener;
.implements Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetResponseListener;


# instance fields
.field private mSubscriber:Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;)V
    .locals 0
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 41
    iput-object p1, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->mSubscriber:Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;

    .line 42
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 27
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;)Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->mSubscriber:Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    .prologue
    .line 27
    invoke-virtual {p0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 27
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    .prologue
    .line 27
    invoke-virtual {p0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 27
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$600(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    .prologue
    .line 27
    invoke-virtual {p0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$700(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 27
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$800(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    .prologue
    .line 27
    invoke-virtual {p0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->serviceCallCompleted()V

    return-void
.end method

.method public static constructNotificationTarget(Ljava/lang/String;ILjava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    .locals 1
    .param p0, "applicationId"    # Ljava/lang/String;
    .param p1, "notificationTargetType"    # I
    .param p2, "deviceToken"    # Ljava/lang/String;

    .prologue
    .line 107
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;-><init>()V

    .line 109
    .local v0, "target":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    invoke-virtual {v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->setApplicationId(Ljava/lang/String;)V

    .line 110
    invoke-virtual {v0, p2}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->setDestination(Ljava/lang/String;)V

    .line 111
    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->setType(I)V

    .line 112
    return-object v0
.end method


# virtual methods
.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 118
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$1;-><init>(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 129
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 134
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$2;

    invoke-direct {v1, p0, p2}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$2;-><init>(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 145
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 166
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$4;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$4;-><init>(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 177
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 150
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$3;

    invoke-direct {v1, p0, p2}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController$3;-><init>(Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 161
    return-void
.end method

.method public getNotificationSubscriptions(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 2
    .param p1, "notificationTarget"    # Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    .param p2, "taskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 47
    invoke-virtual {p0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->cancel()V

    .line 48
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsRequest;-><init>()V

    .line 49
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsRequest;
    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsRequest;->setNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V

    .line 53
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->getNotificationSubscriptions(Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    invoke-virtual {p0, v1, p2}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 54
    return-void
.end method

.method protected bridge synthetic getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 27
    invoke-virtual {p0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->getSubscriber()Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;

    move-result-object v0

    return-object v0
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->mSubscriber:Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;

    return-object v0
.end method

.method public toggleMarketPlace(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;ZLcom/amazon/mShop/control/TaskCallback;)V
    .locals 2
    .param p1, "notificationTarget"    # Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    .param p2, "enableNotifications"    # Z
    .param p3, "taskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 95
    invoke-virtual {p0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->cancel()V

    .line 99
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;-><init>()V

    .line 100
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;
    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;->setNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V

    .line 101
    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;->setEnableNotifications(Ljava/lang/Boolean;)V

    .line 103
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->toggleMarketplaceNotifications(Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    invoke-virtual {p0, v1, p3}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 104
    return-void
.end method

.method public updateDeviceToken(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "applicationId"    # Ljava/lang/String;
    .param p2, "notificationTargetType"    # I
    .param p3, "oldDeviceToken"    # Ljava/lang/String;
    .param p4, "newDeviceToken"    # Ljava/lang/String;

    .prologue
    .line 79
    invoke-virtual {p0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->cancel()V

    .line 80
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;-><init>()V

    .line 81
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;
    invoke-static {p1, p2, p4}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->constructNotificationTarget(Ljava/lang/String;ILjava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;->setNewNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V

    .line 82
    invoke-static {p1, p2, p3}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->constructNotificationTarget(Ljava/lang/String;ILjava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;->setOldNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V

    .line 84
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->updateNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 86
    return-void
.end method

.method public updateNotificationSubscriptions(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 3
    .param p1, "notificationTarget"    # Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    .param p2, "subscription"    # Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    .param p3, "taskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 62
    invoke-virtual {p0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->cancel()V

    .line 63
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsRequest;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsRequest;-><init>()V

    .line 64
    .local v1, "request":Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsRequest;
    new-instance v0, Ljava/util/ArrayList;

    const/4 v2, 0x1

    invoke-direct {v0, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 65
    .local v0, "params":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;>;"
    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 66
    new-instance v2, Ljava/util/Vector;

    invoke-direct {v2, v0}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsRequest;->setSubscriptions(Ljava/util/List;)V

    .line 67
    invoke-virtual {v1, p1}, Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsRequest;->setNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V

    .line 71
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v2

    invoke-interface {v2, v1, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->setNotificationSubscriptions(Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsRequest;Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v2

    invoke-virtual {p0, v2, p3}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 73
    return-void
.end method
