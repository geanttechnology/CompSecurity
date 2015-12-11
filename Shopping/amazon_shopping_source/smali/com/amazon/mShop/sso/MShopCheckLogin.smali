.class public final Lcom/amazon/mShop/sso/MShopCheckLogin;
.super Ljava/lang/Object;
.source "MShopCheckLogin.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginResponseListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;
    }
.end annotation


# static fields
.field private static sPendingNotification:Lcom/amazon/rio/j2me/client/services/mShop/Notification;


# instance fields
.field private final TAG:Ljava/lang/String;

.field private final mApplicationContext:Landroid/content/Context;

.field private final mAttemptOneClickActivation:Z

.field private final mCallPhoneHomeOnCompleted:Z

.field private final mSubscriber:Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 187
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/sso/MShopCheckLogin;->sPendingNotification:Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;ZLcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;)V
    .locals 1
    .param p1, "applicationContext"    # Landroid/content/Context;
    .param p2, "attemptOneClickActivation"    # Z
    .param p3, "subscriber"    # Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;

    .prologue
    .line 62
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/mShop/sso/MShopCheckLogin;-><init>(Landroid/content/Context;ZLcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;Z)V

    .line 63
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;ZLcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;Z)V
    .locals 1
    .param p1, "applicationContext"    # Landroid/content/Context;
    .param p2, "attemptOneClickActivation"    # Z
    .param p3, "subscriber"    # Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;
    .param p4, "callPhoneHomeOnCompleted"    # Z

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    const-class v0, Lcom/amazon/mShop/sso/MShopCheckLogin;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->TAG:Ljava/lang/String;

    .line 66
    iput-boolean p2, p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->mAttemptOneClickActivation:Z

    .line 67
    iput-object p1, p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->mApplicationContext:Landroid/content/Context;

    .line 68
    iput-object p3, p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->mSubscriber:Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;

    .line 69
    iput-boolean p4, p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->mCallPhoneHomeOnCompleted:Z

    .line 70
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/sso/MShopCheckLogin;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/MShopCheckLogin;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    .prologue
    .line 43
    invoke-direct {p0, p1}, Lcom/amazon/mShop/sso/MShopCheckLogin;->handleLoginResponse(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/sso/MShopCheckLogin;)Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/sso/MShopCheckLogin;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->mSubscriber:Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;

    return-object v0
.end method

.method private handleLoginResponse(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V
    .locals 1
    .param p1, "loginResponse"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    .prologue
    .line 171
    if-nez p1, :cond_1

    .line 173
    invoke-direct {p0}, Lcom/amazon/mShop/sso/MShopCheckLogin;->simulateSignIn()V

    .line 185
    :cond_0
    :goto_0
    return-void

    .line 178
    :cond_1
    invoke-direct {p0, p1}, Lcom/amazon/mShop/sso/MShopCheckLogin;->updateUserData(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V

    .line 181
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;->getNotification()Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 182
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;->getNotification()Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/sso/MShopCheckLogin;->savePendingNotification(Lcom/amazon/rio/j2me/client/services/mShop/Notification;)V

    goto :goto_0
.end method

.method public static savePendingNotification(Lcom/amazon/rio/j2me/client/services/mShop/Notification;)V
    .locals 0
    .param p0, "mShopResponseNotification"    # Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    .prologue
    .line 189
    sput-object p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->sPendingNotification:Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    .line 190
    return-void
.end method

.method private simulateSignIn()V
    .locals 11

    .prologue
    const/4 v7, 0x0

    const/4 v9, 0x0

    .line 250
    iget-object v1, p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->mApplicationContext:Landroid/content/Context;

    const-string/jumbo v3, "com.amazon.dcp.sso.property.username"

    invoke-static {v1, v3}, Lcom/amazon/mShop/sso/SSOUtil;->peekCustomerAttribute(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 252
    .local v2, "fullName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v10

    .line 253
    .local v10, "user":Lcom/amazon/mShop/model/auth/User;
    new-instance v0, Lcom/amazon/mShop/model/auth/User;

    const-string/jumbo v1, ""

    if-eqz v10, :cond_2

    invoke-virtual {v10}, Lcom/amazon/mShop/model/auth/User;->isPrime()Z

    move-result v3

    :goto_0
    if-eqz v10, :cond_3

    invoke-virtual {v10}, Lcom/amazon/mShop/model/auth/User;->isOneClick()Z

    move-result v4

    :goto_1
    if-eqz v10, :cond_4

    invoke-virtual {v10}, Lcom/amazon/mShop/model/auth/User;->getDob()Lcom/amazon/rio/j2me/client/services/mShop/Date;

    move-result-object v5

    :goto_2
    if-eqz v10, :cond_5

    invoke-virtual {v10}, Lcom/amazon/mShop/model/auth/User;->isPrimeEligible()Z

    move-result v6

    :goto_3
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    if-eqz v10, :cond_0

    invoke-virtual {v10}, Lcom/amazon/mShop/model/auth/User;->getPrimeFunnelUrl()Ljava/lang/String;

    move-result-object v7

    :cond_0
    if-eqz v10, :cond_6

    invoke-virtual {v10}, Lcom/amazon/mShop/model/auth/User;->getCharity()Ljava/lang/String;

    move-result-object v8

    :goto_4
    if-eqz v10, :cond_1

    invoke-virtual {v10}, Lcom/amazon/mShop/model/auth/User;->isSmile()Z

    move-result v9

    :cond_1
    invoke-direct/range {v0 .. v9}, Lcom/amazon/mShop/model/auth/User;-><init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 263
    .end local v10    # "user":Lcom/amazon/mShop/model/auth/User;
    .local v0, "user":Lcom/amazon/mShop/model/auth/User;
    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->userSignedIn(Lcom/amazon/mShop/model/auth/User;)V

    .line 264
    return-void

    .end local v0    # "user":Lcom/amazon/mShop/model/auth/User;
    .restart local v10    # "user":Lcom/amazon/mShop/model/auth/User;
    :cond_2
    move v3, v9

    .line 253
    goto :goto_0

    :cond_3
    move v4, v9

    goto :goto_1

    :cond_4
    move-object v5, v7

    goto :goto_2

    :cond_5
    move v6, v9

    goto :goto_3

    :cond_6
    const-string/jumbo v8, ""

    goto :goto_4
.end method

.method private updateUserData(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V
    .locals 8
    .param p1, "loginResponse"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    .prologue
    .line 194
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;->getLoginData()Lcom/amazon/rio/j2me/client/services/mShop/LoginData;

    move-result-object v2

    .line 196
    .local v2, "loginData":Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
    if-nez v2, :cond_1

    .line 200
    sget-boolean v5, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v5, :cond_0

    .line 201
    iget-object v5, p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "SIGNED OUT: CheckLogin completed successfully with an empty LoginData field"

    invoke-static {v5, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 202
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->userSignedOut()V

    .line 235
    :goto_0
    return-void

    .line 207
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;->getNotification()Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    move-result-object v3

    .line 208
    .local v3, "notification":Lcom/amazon/rio/j2me/client/services/mShop/Notification;
    if-eqz v3, :cond_2

    .line 210
    invoke-static {v3}, Lcom/amazon/mShop/control/account/OneClickController;->isOneClickNotification(Lcom/amazon/rio/j2me/client/services/mShop/Notification;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 213
    const/4 v5, 0x1

    invoke-static {v5}, Lcom/amazon/mShop/control/account/OneClickController;->setDidAttemptAutoActivationOnFirstSignIn(Z)V

    .line 217
    :cond_2
    sget-boolean v5, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v5, :cond_4

    .line 218
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getPrimeOneClickStatus()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    move-result-object v4

    .line 219
    .local v4, "primeOneClick":Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;
    const/4 v1, 0x0

    .line 220
    .local v1, "isPrime":Z
    const/4 v0, 0x0

    .line 221
    .local v0, "isOneClick":Z
    if-eqz v4, :cond_3

    .line 222
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->getIsPrime()Z

    move-result v1

    .line 223
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->getIsOneClickEnabled()Z

    move-result v0

    .line 226
    :cond_3
    iget-object v5, p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "LoginResponse "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getFullName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " prime: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " 1-click: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " primeEligible:"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getIsPrimeFunnelEligible()Ljava/lang/Boolean;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 229
    .end local v0    # "isOneClick":Z
    .end local v1    # "isPrime":Z
    .end local v4    # "primeOneClick":Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;
    :cond_4
    iget-boolean v5, p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->mCallPhoneHomeOnCompleted:Z

    if-eqz v5, :cond_5

    .line 230
    const-string/jumbo v5, ""

    invoke-static {v5, v2}, Lcom/amazon/mShop/model/auth/User;->userSignedIn(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/LoginData;)V

    goto :goto_0

    .line 232
    :cond_5
    const-string/jumbo v5, ""

    invoke-static {v5, v2}, Lcom/amazon/mShop/model/auth/User;->saveUser(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/LoginData;)V

    goto :goto_0
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 132
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 133
    iget-object v0, p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p1}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->getMethod()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " cancelled"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 135
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/sso/MShopCheckLogin$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/sso/MShopCheckLogin$2;-><init>(Lcom/amazon/mShop/sso/MShopCheckLogin;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->invokeLater(Ljava/lang/Runnable;)V

    .line 143
    return-void
.end method

.method public checkLogin()V
    .locals 7

    .prologue
    const/4 v5, 0x0

    .line 73
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;-><init>()V

    .line 75
    .local v0, "loginRequest":Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v3

    .line 78
    .local v3, "platform":Lcom/amazon/mShop/platform/AndroidPlatform;
    iget-boolean v4, p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->mAttemptOneClickActivation:Z

    if-eqz v4, :cond_2

    invoke-static {}, Lcom/amazon/mShop/control/account/OneClickController;->shouldAttempAutoActivationOnSignIn()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 79
    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDeviceName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;->setOneClickDeviceName(Ljava/lang/String;)V

    .line 84
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 85
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v1

    .line 86
    .local v1, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    invoke-virtual {v1, v5}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v2

    .line 87
    .local v2, "notificationTarget":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->getDestination()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 88
    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;->setNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V

    .line 92
    .end local v1    # "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    .end local v2    # "notificationTarget":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    :cond_0
    sget-boolean v4, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v4, :cond_1

    .line 93
    iget-object v4, p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "checkLogin OneClickDeviceName: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;->getOneClickDeviceName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 95
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->hasAmazonAccount()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 96
    new-instance v4, Lcom/amazon/mShop/sso/SignedMShopService;

    invoke-direct {v4}, Lcom/amazon/mShop/sso/SignedMShopService;-><init>()V

    invoke-virtual {v4, v0, p0}, Lcom/amazon/mShop/sso/SignedMShopService;->checkLogin(Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 105
    :goto_1
    return-void

    .line 81
    :cond_2
    invoke-virtual {v0, v5}, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;->setOneClickDeviceName(Ljava/lang/String;)V

    goto :goto_0

    .line 103
    :cond_3
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/platform/AndroidPlatform;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v4

    invoke-interface {v4, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->checkLogin(Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    goto :goto_1
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "loginResponse"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 150
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 151
    iget-object v0, p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p2}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->getMethod()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " completed "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 153
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/sso/MShopCheckLogin$3;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/sso/MShopCheckLogin$3;-><init>(Lcom/amazon/mShop/sso/MShopCheckLogin;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->invokeLater(Ljava/lang/Runnable;)V

    .line 167
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 113
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 114
    iget-object v0, p0, Lcom/amazon/mShop/sso/MShopCheckLogin;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "CheckLogin failed with error: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p2}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->getMethod()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 117
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/sso/MShopCheckLogin$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/sso/MShopCheckLogin$1;-><init>(Lcom/amazon/mShop/sso/MShopCheckLogin;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->invokeLater(Ljava/lang/Runnable;)V

    .line 125
    return-void
.end method
