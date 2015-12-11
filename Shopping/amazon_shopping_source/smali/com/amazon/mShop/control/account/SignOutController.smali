.class public Lcom/amazon/mShop/control/account/SignOutController;
.super Lcom/amazon/mShop/control/BaseController;
.source "SignOutController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponseListener;


# instance fields
.field private final subscriber:Lcom/amazon/mShop/control/account/SignOutSubscriber;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/control/account/SignOutSubscriber;)V
    .locals 0
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/account/SignOutSubscriber;

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/amazon/mShop/control/account/SignOutController;->subscriber:Lcom/amazon/mShop/control/account/SignOutSubscriber;

    .line 30
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/account/SignOutController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/SignOutController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 22
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/account/SignOutController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/account/SignOutController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/SignOutController;

    .prologue
    .line 22
    invoke-virtual {p0}, Lcom/amazon/mShop/control/account/SignOutController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/account/SignOutController;)Lcom/amazon/mShop/control/account/SignOutSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/SignOutController;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/mShop/control/account/SignOutController;->subscriber:Lcom/amazon/mShop/control/account/SignOutSubscriber;

    return-object v0
.end method


# virtual methods
.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 65
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/account/SignOutController$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/account/SignOutController$1;-><init>(Lcom/amazon/mShop/control/account/SignOutController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 80
    return-void
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/mShop/control/account/SignOutController;->subscriber:Lcom/amazon/mShop/control/account/SignOutSubscriber;

    return-object v0
.end method

.method public signOut(Lcom/amazon/mShop/control/TaskCallback;Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V
    .locals 2
    .param p1, "taskCallback"    # Lcom/amazon/mShop/control/TaskCallback;
    .param p2, "notificationTarget"    # Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .prologue
    .line 38
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/LogoutRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/LogoutRequest;-><init>()V

    .line 40
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/LogoutRequest;
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->getDestination()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 41
    invoke-virtual {v0, p2}, Lcom/amazon/rio/j2me/client/services/mShop/LogoutRequest;->setNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V

    .line 44
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->logout(Lcom/amazon/rio/j2me/client/services/mShop/LogoutRequest;Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    invoke-virtual {p0, v1, p1}, Lcom/amazon/mShop/control/account/SignOutController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 48
    return-void
.end method
