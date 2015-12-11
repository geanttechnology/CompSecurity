.class public Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;
.super Ljava/lang/Object;
.source "UserManagerWrapper.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private final mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

.field private final mRefHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

.field private final mUserManager:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V
    .locals 2
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    new-instance v0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->mRefHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    .line 32
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 34
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v1, "user"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->mUserManager:Ljava/lang/Object;

    .line 36
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v1, "sso_platform"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 37
    return-void
.end method

.method private checkIsUserManagerSupportedOnThisPlatform()V
    .locals 2

    .prologue
    .line 107
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->isSupportedOnThisPlatform()Z

    move-result v0

    if-nez v0, :cond_0

    .line 109
    sget-object v0, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "checkIsUserManagerSupportedOnThisPlatform failed. IMP is going to crash. This issue is tracked in SSO-150 and FWK-10172"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 111
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "This platform does not support UserManager"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 113
    :cond_0
    return-void
.end method

.method private getMyUserId()Ljava/lang/Integer;
    .locals 6

    .prologue
    .line 81
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->mRefHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    const-string/jumbo v2, "myUserId"

    const-string/jumbo v3, "android.os.UserHandle"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invokeStatic(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException; {:try_start_0 .. :try_end_0} :catch_0

    .line 88
    :goto_0
    return-object v1

    .line 83
    :catch_0
    move-exception v0

    .line 85
    .local v0, "e":Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot get my user id"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 88
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getAndroidUserFromUserId(I)Lcom/amazon/identity/auth/device/framework/AndroidUser;
    .locals 8
    .param p1, "userId"    # I

    .prologue
    .line 65
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->mRefHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    const-string/jumbo v2, "getUserInfo"

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->mUserManager:Ljava/lang/Object;

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    sget-object v6, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invoke(Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 67
    invoke-static {v1}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->convertFromUserInfo(Ljava/lang/Object;)Lcom/amazon/identity/auth/device/framework/AndroidUser;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 74
    :goto_0
    return-object v1

    .line 69
    :catch_0
    move-exception v0

    .line 71
    .local v0, "e":Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot get user info for my user id"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 74
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getCurrentUser()Lcom/amazon/identity/auth/device/framework/AndroidUser;
    .locals 1

    .prologue
    .line 100
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->checkIsUserManagerSupportedOnThisPlatform()V

    .line 102
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getCurrentUserId()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->getAndroidUserFromUserId(I)Lcom/amazon/identity/auth/device/framework/AndroidUser;

    move-result-object v0

    return-object v0
.end method

.method public getMainUser()Lcom/amazon/identity/auth/device/framework/AndroidUser;
    .locals 1

    .prologue
    .line 93
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->checkIsUserManagerSupportedOnThisPlatform()V

    .line 95
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getOwnerId()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->getAndroidUserFromUserId(I)Lcom/amazon/identity/auth/device/framework/AndroidUser;

    move-result-object v0

    return-object v0
.end method

.method public getMyUser()Lcom/amazon/identity/auth/device/framework/AndroidUser;
    .locals 3

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->checkIsUserManagerSupportedOnThisPlatform()V

    .line 51
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->getMyUserId()Ljava/lang/Integer;

    move-result-object v0

    .line 52
    .local v0, "userId":Ljava/lang/Integer;
    if-nez v0, :cond_0

    .line 54
    sget-object v1, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "No Current user"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    const/4 v1, 0x0

    .line 58
    :goto_0
    return-object v1

    :cond_0
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->getAndroidUserFromUserId(I)Lcom/amazon/identity/auth/device/framework/AndroidUser;

    move-result-object v1

    goto :goto_0
.end method

.method public isSupportedOnThisPlatform()Z
    .locals 3

    .prologue
    .line 41
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->doesPlatformSupportsMultipleProfiles()Z

    move-result v0

    .line 42
    .local v0, "doesPlatformSupportsMultipleProfiles":Z
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->isRunningInCentralAPK(Landroid/content/Context;)Z

    move-result v1

    .line 44
    .local v1, "isRunningInCentralAPK":Z
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    const/4 v2, 0x1

    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method
