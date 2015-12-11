.class public Lcom/amazon/mShop/control/account/SignInController;
.super Lcom/amazon/mShop/control/BaseController;
.source "SignInController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/LoginResponseListener;


# instance fields
.field private final loginRequest:Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;

.field private final mNeedCallUserSignedIn:Z

.field private final subscriber:Lcom/amazon/mShop/control/account/SignInSubscriber;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/control/account/SignInSubscriber;Z)V
    .locals 1
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/account/SignInSubscriber;
    .param p2, "needCallUserSignedIn"    # Z

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/control/account/SignInController;->subscriber:Lcom/amazon/mShop/control/account/SignInSubscriber;

    .line 35
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/account/SignInController;->loginRequest:Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;

    .line 36
    iput-boolean p2, p0, Lcom/amazon/mShop/control/account/SignInController;->mNeedCallUserSignedIn:Z

    .line 37
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/account/SignInController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/SignInController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 25
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/account/SignInController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/account/SignInController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/SignInController;

    .prologue
    .line 25
    invoke-virtual {p0}, Lcom/amazon/mShop/control/account/SignInController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/account/SignInController;)Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/SignInController;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/mShop/control/account/SignInController;->loginRequest:Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/control/account/SignInController;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/SignInController;

    .prologue
    .line 25
    iget-boolean v0, p0, Lcom/amazon/mShop/control/account/SignInController;->mNeedCallUserSignedIn:Z

    return v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/control/account/SignInController;)Lcom/amazon/mShop/control/account/SignInSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/SignInController;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/mShop/control/account/SignInController;->subscriber:Lcom/amazon/mShop/control/account/SignInSubscriber;

    return-object v0
.end method


# virtual methods
.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 84
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/account/SignInController$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/account/SignInController$1;-><init>(Lcom/amazon/mShop/control/account/SignInController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 122
    return-void
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/control/account/SignInController;->subscriber:Lcom/amazon/mShop/control/account/SignInSubscriber;

    return-object v0
.end method

.method public signIn(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;ZLcom/amazon/mShop/control/TaskCallback;)V
    .locals 3
    .param p1, "email"    # Ljava/lang/String;
    .param p2, "password"    # Ljava/lang/String;
    .param p3, "notificationTarget"    # Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    .param p4, "fromHomeScreen"    # Z
    .param p5, "taskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 50
    iget-object v1, p0, Lcom/amazon/mShop/control/account/SignInController;->loginRequest:Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;

    invoke-virtual {v1, p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->setEmail(Ljava/lang/String;)V

    .line 51
    iget-object v1, p0, Lcom/amazon/mShop/control/account/SignInController;->loginRequest:Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;

    invoke-virtual {v1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->setPassword(Ljava/lang/String;)V

    .line 53
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->getDestination()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 54
    iget-object v1, p0, Lcom/amazon/mShop/control/account/SignInController;->loginRequest:Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;

    invoke-virtual {v1, p3}, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->setNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V

    .line 57
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    .line 59
    .local v0, "platform":Lcom/amazon/mShop/platform/Platform;
    if-eqz p4, :cond_1

    invoke-static {}, Lcom/amazon/mShop/control/account/OneClickController;->shouldAttempAutoActivationOnSignIn()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 60
    iget-object v1, p0, Lcom/amazon/mShop/control/account/SignInController;->loginRequest:Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDeviceName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->setOneClickDeviceName(Ljava/lang/String;)V

    .line 65
    :goto_0
    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/control/account/SignInController;->loginRequest:Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;

    invoke-interface {v1, v2, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->login(Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    invoke-virtual {p0, v1, p5}, Lcom/amazon/mShop/control/account/SignInController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 67
    return-void

    .line 62
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/control/account/SignInController;->loginRequest:Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->setOneClickDeviceName(Ljava/lang/String;)V

    goto :goto_0
.end method
