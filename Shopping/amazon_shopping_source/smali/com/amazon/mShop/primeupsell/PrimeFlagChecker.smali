.class public Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;
.super Ljava/lang/Object;
.source "PrimeFlagChecker.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginResponseListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;
    }
.end annotation


# instance fields
.field private mSubscriber:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;)V
    .locals 0
    .param p1, "suscriber"    # Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->mSubscriber:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;

    .line 27
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;)Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    .prologue
    .line 15
    iget-object v0, p0, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->mSubscriber:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    .prologue
    .line 15
    invoke-direct {p0, p1}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->handleLoginResponse(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V

    return-void
.end method

.method private handleLoginResponse(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V
    .locals 1
    .param p1, "loginResponse"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    .prologue
    .line 101
    if-eqz p1, :cond_0

    .line 102
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;->getLoginData()Lcom/amazon/rio/j2me/client/services/mShop/LoginData;

    move-result-object v0

    .line 104
    .local v0, "loginData":Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
    if-eqz v0, :cond_0

    .line 105
    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->userUpdated(Lcom/amazon/rio/j2me/client/services/mShop/LoginData;)V

    .line 108
    .end local v0    # "loginData":Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
    :cond_0
    return-void
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 70
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$2;-><init>(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 79
    return-void
.end method

.method public checkFlag()V
    .locals 3

    .prologue
    .line 35
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;-><init>()V

    .line 37
    .local v0, "loginRequest":Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;
    invoke-static {}, Lcom/amazon/mShop/control/account/OneClickController;->shouldAttempAutoActivationOnSignIn()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 38
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    .line 39
    .local v1, "platform":Lcom/amazon/mShop/platform/AndroidPlatform;
    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDeviceName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;->setOneClickDeviceName(Ljava/lang/String;)V

    .line 43
    .end local v1    # "platform":Lcom/amazon/mShop/platform/AndroidPlatform;
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->hasAmazonAccount()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 44
    new-instance v2, Lcom/amazon/mShop/sso/SignedMShopService;

    invoke-direct {v2}, Lcom/amazon/mShop/sso/SignedMShopService;-><init>()V

    invoke-virtual {v2, v0, p0}, Lcom/amazon/mShop/sso/SignedMShopService;->checkLogin(Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 53
    :goto_1
    return-void

    .line 41
    :cond_0
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;->setOneClickDeviceName(Ljava/lang/String;)V

    goto :goto_0

    .line 51
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v2

    invoke-interface {v2, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->checkLogin(Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    goto :goto_1
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "loginResponse"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 83
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$3;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$3;-><init>(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 98
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 57
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$1;-><init>(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 66
    return-void
.end method

.method public setSubscriber(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;)V
    .locals 0
    .param p1, "suscriber"    # Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->mSubscriber:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;

    .line 31
    return-void
.end method
