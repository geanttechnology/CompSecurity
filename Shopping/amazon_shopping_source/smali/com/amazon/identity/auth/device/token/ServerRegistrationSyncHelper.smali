.class public Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;
.super Ljava/lang/Object;
.source "ServerRegistrationSyncHelper.java"


# static fields
.field private static final DURATION_TO_CHECK_REGISTRATION:J

.field static final KEY_LAST_REGISTRATION_CHECK_TIME:Ljava/lang/String; = "3PLastRegistrationCheckTimeKey"


# instance fields
.field private final mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

.field private final mPlatformWrapper:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 22
    const-wide/16 v0, 0x1

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->fromHoursTo(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;->DURATION_TO_CHECK_REGISTRATION:J

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "localAppDataAwareDataStorage"    # Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    .line 30
    .local v0, "localContext":Landroid/content/Context;
    const-string/jumbo v1, "sso_platform"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;->mPlatformWrapper:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 31
    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    .line 32
    return-void
.end method


# virtual methods
.method public getRegistrationCheckTime(Ljava/lang/String;)Ljava/lang/Long;
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 70
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    const-string/jumbo v2, "3PLastRegistrationCheckTimeKey"

    invoke-virtual {v1, p1, v2}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 71
    .local v0, "lastCheck":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 73
    const/4 v1, 0x0

    .line 75
    :goto_0
    return-object v1

    :cond_0
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v1

    goto :goto_0
.end method

.method public recordRegistrationCheckTime(Ljava/lang/String;)V
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    const-string/jumbo v1, "3PLastRegistrationCheckTimeKey"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v1, v2}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    return-void
.end method

.method public declared-synchronized shouldDoRegistrationCheck(Ljava/lang/String;)Z
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 44
    monitor-enter p0

    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;->mPlatformWrapper:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isAmazonDevice()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v3

    if-eqz v3, :cond_1

    .line 58
    :cond_0
    :goto_0
    monitor-exit p0

    return v1

    .line 51
    :cond_1
    :try_start_1
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;->getRegistrationCheckTime(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    .line 53
    .local v0, "lastCheckTime":Ljava/lang/Long;
    if-nez v0, :cond_2

    move v1, v2

    .line 55
    goto :goto_0

    .line 58
    :cond_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    sub-long/2addr v3, v5

    sget-wide v5, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;->DURATION_TO_CHECK_REGISTRATION:J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    cmp-long v3, v3, v5

    if-ltz v3, :cond_0

    move v1, v2

    goto :goto_0

    .line 44
    .end local v0    # "lastCheckTime":Ljava/lang/Long;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method
