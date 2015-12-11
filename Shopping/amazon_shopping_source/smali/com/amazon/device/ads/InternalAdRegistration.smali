.class Lcom/amazon/device/ads/InternalAdRegistration;
.super Ljava/lang/Object;
.source "InternalAdRegistration.java"

# interfaces
.implements Lcom/amazon/device/ads/IInternalAdRegistration;


# static fields
.field public static final LOG_TAG:Ljava/lang/String;

.field private static instance:Lcom/amazon/device/ads/IInternalAdRegistration;


# instance fields
.field private appInfo:Lcom/amazon/device/ads/AppInfo;

.field protected applicationContext:Landroid/content/Context;

.field private contextReceived:Z

.field private deviceInfo:Lcom/amazon/device/ads/DeviceInfo;

.field private filesDirectory:Ljava/io/File;

.field private isAppDisabled:Z

.field private isRegistered:Z

.field private noRetryTtlExpiresMillis:J

.field private noRetryTtlMillis:I

.field private registrationInfo:Lcom/amazon/device/ads/RegistrationInfo;

.field private sisRegistration:Lcom/amazon/device/ads/SISRegistration;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/amazon/device/ads/InternalAdRegistration;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/InternalAdRegistration;->LOG_TAG:Ljava/lang/String;

    .line 57
    new-instance v0, Lcom/amazon/device/ads/InternalAdRegistration;

    invoke-direct {v0}, Lcom/amazon/device/ads/InternalAdRegistration;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/InternalAdRegistration;->instance:Lcom/amazon/device/ads/IInternalAdRegistration;

    return-void
.end method

.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->isAppDisabled:Z

    .line 61
    invoke-static {}, Lcom/amazon/device/ads/DebugProperties;->readDebugProperties()V

    .line 63
    invoke-static {}, Lcom/amazon/device/ads/Version;->getSDKVersion()Ljava/lang/String;

    .line 65
    new-instance v0, Lcom/amazon/device/ads/RegistrationInfo;

    invoke-direct {v0}, Lcom/amazon/device/ads/RegistrationInfo;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->registrationInfo:Lcom/amazon/device/ads/RegistrationInfo;

    .line 66
    return-void
.end method

.method public static getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;
    .locals 1

    .prologue
    .line 70
    sget-object v0, Lcom/amazon/device/ads/InternalAdRegistration;->instance:Lcom/amazon/device/ads/IInternalAdRegistration;

    return-object v0
.end method

.method protected static setInstance(Lcom/amazon/device/ads/IInternalAdRegistration;)V
    .locals 0
    .param p0, "newInstance"    # Lcom/amazon/device/ads/IInternalAdRegistration;

    .prologue
    .line 74
    sput-object p0, Lcom/amazon/device/ads/InternalAdRegistration;->instance:Lcom/amazon/device/ads/IInternalAdRegistration;

    .line 75
    return-void
.end method


# virtual methods
.method public declared-synchronized contextReceived(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 92
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->contextReceived:Z

    if-nez v0, :cond_0

    .line 94
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->contextReceived:Z

    .line 95
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/InternalAdRegistration;->setApplicationContextFromContext(Landroid/content/Context;)V

    .line 96
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/InternalAdRegistration;->setFilesDirectory(Landroid/content/Context;)V

    .line 97
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/device/ads/Settings;->contextReceived(Landroid/content/Context;)V

    .line 99
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/InternalAdRegistration;->createAppInfo(Landroid/content/Context;)V

    .line 100
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/InternalAdRegistration;->createDeviceInfo(Landroid/content/Context;)V

    .line 101
    invoke-virtual {p0}, Lcom/amazon/device/ads/InternalAdRegistration;->createSISRegistration()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 103
    :cond_0
    monitor-exit p0

    return-void

    .line 92
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected createAppInfo(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 121
    new-instance v0, Lcom/amazon/device/ads/AppInfo;

    invoke-direct {v0, p1}, Lcom/amazon/device/ads/AppInfo;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->appInfo:Lcom/amazon/device/ads/AppInfo;

    .line 122
    return-void
.end method

.method protected createDeviceInfo(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 130
    new-instance v0, Lcom/amazon/device/ads/DeviceInfo;

    invoke-direct {v0, p1}, Lcom/amazon/device/ads/DeviceInfo;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->deviceInfo:Lcom/amazon/device/ads/DeviceInfo;

    .line 131
    return-void
.end method

.method protected createSISRegistration()V
    .locals 1

    .prologue
    .line 141
    new-instance v0, Lcom/amazon/device/ads/SISRegistration;

    invoke-direct {v0}, Lcom/amazon/device/ads/SISRegistration;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->sisRegistration:Lcom/amazon/device/ads/SISRegistration;

    .line 142
    return-void
.end method

.method public getAppInfo()Lcom/amazon/device/ads/AppInfo;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->appInfo:Lcom/amazon/device/ads/AppInfo;

    return-object v0
.end method

.method public getApplicationContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->applicationContext:Landroid/content/Context;

    return-object v0
.end method

.method public getDeviceInfo()Lcom/amazon/device/ads/DeviceInfo;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->deviceInfo:Lcom/amazon/device/ads/DeviceInfo;

    return-object v0
.end method

.method public getFilesDir()Ljava/io/File;
    .locals 1

    .prologue
    .line 210
    iget-object v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->filesDirectory:Ljava/io/File;

    return-object v0
.end method

.method public getIsAppDisabled()Z
    .locals 1

    .prologue
    .line 195
    iget-boolean v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->isAppDisabled:Z

    return v0
.end method

.method public getNoRetryTtlRemainingMillis()I
    .locals 9

    .prologue
    const-wide/16 v7, 0x0

    const/4 v4, 0x0

    .line 156
    iget v5, p0, Lcom/amazon/device/ads/InternalAdRegistration;->noRetryTtlMillis:I

    if-eqz v5, :cond_0

    iget-wide v5, p0, Lcom/amazon/device/ads/InternalAdRegistration;->noRetryTtlExpiresMillis:J

    cmp-long v5, v5, v7

    if-nez v5, :cond_1

    .line 168
    :cond_0
    :goto_0
    return v4

    .line 159
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 160
    .local v0, "currentTime":J
    iget-wide v5, p0, Lcom/amazon/device/ads/InternalAdRegistration;->noRetryTtlExpiresMillis:J

    cmp-long v5, v0, v5

    if-ltz v5, :cond_2

    .line 162
    iput v4, p0, Lcom/amazon/device/ads/InternalAdRegistration;->noRetryTtlMillis:I

    .line 163
    iput-wide v7, p0, Lcom/amazon/device/ads/InternalAdRegistration;->noRetryTtlExpiresMillis:J

    goto :goto_0

    .line 167
    :cond_2
    iget-wide v4, p0, Lcom/amazon/device/ads/InternalAdRegistration;->noRetryTtlExpiresMillis:J

    sub-long v2, v4, v0

    .line 168
    .local v2, "timeRemaining":J
    long-to-int v4, v2

    goto :goto_0
.end method

.method public getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->registrationInfo:Lcom/amazon/device/ads/RegistrationInfo;

    return-object v0
.end method

.method protected getSISRegistration()Lcom/amazon/device/ads/SISRegistration;
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->sisRegistration:Lcom/amazon/device/ads/SISRegistration;

    return-object v0
.end method

.method public isContextReceived()Z
    .locals 1

    .prologue
    .line 107
    iget-boolean v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->contextReceived:Z

    return v0
.end method

.method public isRegistered()Z
    .locals 1

    .prologue
    .line 151
    iget-boolean v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->isRegistered:Z

    return v0
.end method

.method public register()V
    .locals 1

    .prologue
    .line 135
    invoke-virtual {p0}, Lcom/amazon/device/ads/InternalAdRegistration;->getSISRegistration()Lcom/amazon/device/ads/SISRegistration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/SISRegistration;->registerApp()V

    .line 136
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->isRegistered:Z

    .line 137
    return-void
.end method

.method protected setApplicationContextFromContext(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 221
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->applicationContext:Landroid/content/Context;

    .line 222
    return-void
.end method

.method protected setFilesDirectory(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 112
    invoke-virtual {p1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/InternalAdRegistration;->filesDirectory:Ljava/io/File;

    .line 113
    return-void
.end method

.method public setIsAppDisabled(Z)V
    .locals 0
    .param p1, "isAppDisabled"    # Z

    .prologue
    .line 204
    iput-boolean p1, p0, Lcom/amazon/device/ads/InternalAdRegistration;->isAppDisabled:Z

    .line 205
    return-void
.end method

.method public setNoRetryTtl(I)V
    .locals 5
    .param p1, "noRetryTtlSeconds"    # I

    .prologue
    .line 172
    invoke-static {}, Lcom/amazon/device/ads/Configuration;->getMaxNoRetryTtl()I

    move-result v0

    .line 173
    .local v0, "maxNoRetryTtlSeconds":I
    if-ge v0, p1, :cond_0

    .line 174
    move p1, v0

    .line 176
    :cond_0
    if-nez p1, :cond_1

    .line 178
    const/4 v1, 0x0

    iput v1, p0, Lcom/amazon/device/ads/InternalAdRegistration;->noRetryTtlMillis:I

    .line 179
    const-wide/16 v1, 0x0

    iput-wide v1, p0, Lcom/amazon/device/ads/InternalAdRegistration;->noRetryTtlExpiresMillis:J

    .line 186
    :goto_0
    return-void

    .line 183
    :cond_1
    mul-int/lit16 v1, p1, 0x3e8

    iput v1, p0, Lcom/amazon/device/ads/InternalAdRegistration;->noRetryTtlMillis:I

    .line 184
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iget v3, p0, Lcom/amazon/device/ads/InternalAdRegistration;->noRetryTtlMillis:I

    int-to-long v3, v3

    add-long/2addr v1, v3

    iput-wide v1, p0, Lcom/amazon/device/ads/InternalAdRegistration;->noRetryTtlExpiresMillis:J

    goto :goto_0
.end method
