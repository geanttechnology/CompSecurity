.class Lcom/amazon/device/ads/SISRegistration;
.super Ljava/lang/Object;
.source "SISRegistration.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/SISRegistration$RegisterEventsSISRequestorCallback;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field protected static final SIS_CHECKIN_INTERVAL:J = 0x5265c00L

.field private static final SIS_LAST_CHECKIN_PREF_NAME:Ljava/lang/String; = "amzn-ad-sis-last-checkin"

.field private static final executorService:Ljava/util/concurrent/ExecutorService;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/device/ads/SISRegistration;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/SISRegistration;->LOG_TAG:Ljava/lang/String;

    .line 25
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/SISRegistration;->executorService:Ljava/util/concurrent/ExecutorService;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 196
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    sget-object v0, Lcom/amazon/device/ads/SISRegistration;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method private putLastSISCheckin(J)V
    .locals 2
    .param p1, "currentTime"    # J

    .prologue
    .line 168
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    const-string/jumbo v1, "amzn-ad-sis-last-checkin"

    invoke-virtual {v0, v1, p1, p2}, Lcom/amazon/device/ads/Settings;->putLong(Ljava/lang/String;J)V

    .line 169
    return-void
.end method


# virtual methods
.method protected canRegister(J)Z
    .locals 3
    .param p1, "currentTime"    # J

    .prologue
    const/4 v1, 0x0

    .line 35
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v0

    .line 36
    .local v0, "registrationInfo":Lcom/amazon/device/ads/RegistrationInfo;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/device/ads/SISRegistration;->exceededCheckinInterval(J)Z

    move-result v2

    if-nez v2, :cond_0

    invoke-virtual {v0}, Lcom/amazon/device/ads/RegistrationInfo;->shouldGetNewSISDeviceIdentifer()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-virtual {v0}, Lcom/amazon/device/ads/RegistrationInfo;->shouldGetNewSISRegistration()Z

    move-result v2

    if-nez v2, :cond_0

    const-string/jumbo v2, "debug.shouldRegisterSIS"

    invoke-static {v2, v1}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsBoolean(Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_1

    :cond_0
    const/4 v1, 0x1

    :cond_1
    return v1
.end method

.method protected createAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .locals 2

    .prologue
    .line 29
    new-instance v0, Lcom/amazon/device/ads/AdvertisingIdentifier;

    invoke-direct {v0}, Lcom/amazon/device/ads/AdvertisingIdentifier;-><init>()V

    .line 30
    .local v0, "advertisingIdentifier":Lcom/amazon/device/ads/AdvertisingIdentifier;
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v1

    return-object v1
.end method

.method protected exceededCheckinInterval(J)Z
    .locals 4
    .param p1, "now"    # J

    .prologue
    .line 142
    invoke-virtual {p0}, Lcom/amazon/device/ads/SISRegistration;->getLastSISCheckin()J

    move-result-wide v0

    sub-long v0, p1, v0

    const-wide/32 v2, 0x5265c00

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected getLastSISCheckin()J
    .locals 4

    .prologue
    .line 164
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    const-string/jumbo v1, "amzn-ad-sis-last-checkin"

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/device/ads/Settings;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method protected register(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;)V
    .locals 5
    .param p1, "advertisingIdentifierInfo"    # Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    .prologue
    .line 147
    new-instance v3, Lcom/amazon/device/ads/SISGenerateDIDRequest;

    invoke-direct {v3}, Lcom/amazon/device/ads/SISGenerateDIDRequest;-><init>()V

    invoke-virtual {v3, p1}, Lcom/amazon/device/ads/SISGenerateDIDRequest;->setAdvertisingIdentifierInfo(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;)Lcom/amazon/device/ads/SISDeviceRequest;

    move-result-object v0

    .line 149
    .local v0, "generateDIDRequest":Lcom/amazon/device/ads/SISRequest;
    new-instance v2, Lcom/amazon/device/ads/SISRegistration$RegisterEventsSISRequestorCallback;

    invoke-direct {v2, p0}, Lcom/amazon/device/ads/SISRegistration$RegisterEventsSISRequestorCallback;-><init>(Lcom/amazon/device/ads/SISRegistration;)V

    .line 150
    .local v2, "sisRequestorCallback":Lcom/amazon/device/ads/SISRequestorCallback;
    new-instance v1, Lcom/amazon/device/ads/SISRequestor;

    const/4 v3, 0x1

    new-array v3, v3, [Lcom/amazon/device/ads/SISRequest;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-direct {v1, v2, v3}, Lcom/amazon/device/ads/SISRequestor;-><init>(Lcom/amazon/device/ads/SISRequestorCallback;[Lcom/amazon/device/ads/SISRequest;)V

    .line 151
    .local v1, "sisRequestor":Lcom/amazon/device/ads/SISRequestor;
    invoke-virtual {v1}, Lcom/amazon/device/ads/SISRequestor;->startCallSIS()V

    .line 152
    return-void
.end method

.method public registerApp()V
    .locals 2

    .prologue
    .line 54
    new-instance v0, Lcom/amazon/device/ads/SISRegistration$1;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/SISRegistration$1;-><init>(Lcom/amazon/device/ads/SISRegistration;)V

    .line 64
    .local v0, "proc":Ljava/lang/Runnable;
    sget-object v1, Lcom/amazon/device/ads/SISRegistration;->executorService:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v1, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    .line 65
    return-void
.end method

.method registerAppWorker()V
    .locals 4

    .prologue
    .line 110
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    .line 111
    .local v1, "currentTime":J
    invoke-virtual {p0}, Lcom/amazon/device/ads/SISRegistration;->createAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v0

    .line 113
    .local v0, "advertisingIdentifierInfo":Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->canDo()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-virtual {p0, v1, v2}, Lcom/amazon/device/ads/SISRegistration;->canRegister(J)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 122
    invoke-direct {p0, v1, v2}, Lcom/amazon/device/ads/SISRegistration;->putLastSISCheckin(J)V

    .line 124
    invoke-virtual {p0}, Lcom/amazon/device/ads/SISRegistration;->shouldUpdateDeviceInfo()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 126
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/SISRegistration;->updateDeviceInfo(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;)V

    .line 133
    :cond_0
    :goto_0
    return-void

    .line 130
    :cond_1
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/SISRegistration;->register(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;)V

    goto :goto_0
.end method

.method protected registerEvents()V
    .locals 7

    .prologue
    .line 173
    invoke-static {}, Lcom/amazon/device/ads/ThreadUtils;->isOnMainThread()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 175
    sget-object v5, Lcom/amazon/device/ads/SISRegistration;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v6, "Registering events must be done on a background thread."

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 194
    :cond_0
    :goto_0
    return-void

    .line 179
    :cond_1
    new-instance v0, Lcom/amazon/device/ads/AdvertisingIdentifier;

    invoke-direct {v0}, Lcom/amazon/device/ads/AdvertisingIdentifier;-><init>()V

    .line 180
    .local v0, "advertisingIdentifier":Lcom/amazon/device/ads/AdvertisingIdentifier;
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v1

    .line 181
    .local v1, "advertisingIdentifierInfo":Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    invoke-virtual {v1}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->hasSISDeviceIdentifier()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 183
    invoke-static {}, Lcom/amazon/device/ads/AppEventRegistrationHandler;->getInstance()Lcom/amazon/device/ads/AppEventRegistrationHandler;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/AppEventRegistrationHandler;->getAppEventsJSONArray()Lorg/json/JSONArray;

    move-result-object v2

    .line 185
    .local v2, "appEvents":Lorg/json/JSONArray;
    if-eqz v2, :cond_0

    .line 187
    new-instance v3, Lcom/amazon/device/ads/SISRegisterEventRequest;

    invoke-direct {v3, v1, v2}, Lcom/amazon/device/ads/SISRegisterEventRequest;-><init>(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;Lorg/json/JSONArray;)V

    .line 190
    .local v3, "registerEventRequest":Lcom/amazon/device/ads/SISRegisterEventRequest;
    new-instance v4, Lcom/amazon/device/ads/SISRequestor;

    const/4 v5, 0x1

    new-array v5, v5, [Lcom/amazon/device/ads/SISRequest;

    const/4 v6, 0x0

    aput-object v3, v5, v6

    invoke-direct {v4, v5}, Lcom/amazon/device/ads/SISRequestor;-><init>([Lcom/amazon/device/ads/SISRequest;)V

    .line 191
    .local v4, "sisRequestor":Lcom/amazon/device/ads/SISRequestor;
    invoke-virtual {v4}, Lcom/amazon/device/ads/SISRequestor;->startCallSIS()V

    goto :goto_0
.end method

.method protected shouldUpdateDeviceInfo()Z
    .locals 1

    .prologue
    .line 44
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/RegistrationInfo;->isRegisteredWithSIS()Z

    move-result v0

    return v0
.end method

.method protected updateDeviceInfo(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;)V
    .locals 5
    .param p1, "advertisingIdentifierInfo"    # Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    .prologue
    .line 155
    new-instance v3, Lcom/amazon/device/ads/SISUpdateDeviceInfoRequest;

    invoke-direct {v3}, Lcom/amazon/device/ads/SISUpdateDeviceInfoRequest;-><init>()V

    invoke-virtual {v3, p1}, Lcom/amazon/device/ads/SISUpdateDeviceInfoRequest;->setAdvertisingIdentifierInfo(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;)Lcom/amazon/device/ads/SISDeviceRequest;

    move-result-object v2

    .line 157
    .local v2, "updateDeviceInfoRequest":Lcom/amazon/device/ads/SISRequest;
    new-instance v1, Lcom/amazon/device/ads/SISRegistration$RegisterEventsSISRequestorCallback;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/SISRegistration$RegisterEventsSISRequestorCallback;-><init>(Lcom/amazon/device/ads/SISRegistration;)V

    .line 158
    .local v1, "sisRequestorCallback":Lcom/amazon/device/ads/SISRequestorCallback;
    new-instance v0, Lcom/amazon/device/ads/SISRequestor;

    const/4 v3, 0x1

    new-array v3, v3, [Lcom/amazon/device/ads/SISRequest;

    const/4 v4, 0x0

    aput-object v2, v3, v4

    invoke-direct {v0, v1, v3}, Lcom/amazon/device/ads/SISRequestor;-><init>(Lcom/amazon/device/ads/SISRequestorCallback;[Lcom/amazon/device/ads/SISRequest;)V

    .line 159
    .local v0, "sisRequestor":Lcom/amazon/device/ads/SISRequestor;
    invoke-virtual {v0}, Lcom/amazon/device/ads/SISRequestor;->startCallSIS()V

    .line 160
    return-void
.end method

.method waitForConfigurationThenBeginRegistration()V
    .locals 4

    .prologue
    .line 69
    new-instance v1, Ljava/util/concurrent/CountDownLatch;

    const/4 v2, 0x1

    invoke-direct {v1, v2}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 70
    .local v1, "latch":Ljava/util/concurrent/CountDownLatch;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v2, 0x0

    invoke-direct {v0, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    .line 71
    .local v0, "canRegister":Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-static {}, Lcom/amazon/device/ads/Configuration;->getInstance()Lcom/amazon/device/ads/Configuration;

    move-result-object v2

    new-instance v3, Lcom/amazon/device/ads/SISRegistration$2;

    invoke-direct {v3, p0, v0, v1}, Lcom/amazon/device/ads/SISRegistration$2;-><init>(Lcom/amazon/device/ads/SISRegistration;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/CountDownLatch;)V

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/Configuration;->queueConfigurationListener(Lcom/amazon/device/ads/Configuration$ConfigurationListener;)V

    .line 90
    :try_start_0
    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->await()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 94
    :goto_0
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 96
    invoke-virtual {p0}, Lcom/amazon/device/ads/SISRegistration;->registerAppWorker()V

    .line 98
    :cond_0
    return-void

    .line 92
    :catch_0
    move-exception v2

    goto :goto_0
.end method
