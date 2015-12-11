.class public abstract Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;
.super Ljava/lang/Object;
.source "AbstractDRMWorkflow.java"


# static fields
.field private static final TAG_REGEX:Ljava/util/regex/Pattern;

.field private static final logger:Lorg/slf4j/Logger;


# instance fields
.field protected authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

.field protected clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

.field protected context:Landroid/content/Context;

.field protected drmEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

.field protected final drmLicenseAcquiredCallback:Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;

.field protected drmLicenseFuture:Lcom/google/common/util/concurrent/SettableFuture;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/util/concurrent/SettableFuture",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field protected drmManager:Lcom/adobe/ave/drm/DRMManager;

.field protected drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

.field protected final drmOperationCompleteCallback:Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

.field protected final drmOperationErrorCallback:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

.field protected hasRenewedSession:Ljava/lang/Boolean;

.field protected httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field protected licenseFutureLock:Ljava/lang/Object;

.field protected licenseSettings:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

.field protected listeners:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;",
            ">;"
        }
    .end annotation
.end field

.field protected manifestUri:Ljava/lang/String;

.field protected messageId:Ljava/lang/String;

.field protected requestLicenseAnonymously:Ljava/lang/Boolean;

.field private responseEventListener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

.field protected sessionService:Lcom/comcast/playerplatform/drm/java/service/SessionService;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 45
    const-string v0, "EXT-X-FAXS-CM:(.+?)(#|\n)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->TAG_REGEX:Ljava/util/regex/Pattern;

    .line 46
    const-class v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->logger:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 1
    .param p1, "clientState"    # Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    .param p2, "authenticationDelegate"    # Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;
    .param p3, "context"    # Landroid/content/Context;
    .param p4, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p5, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 111
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/DrmUtil;->generateId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->messageId:Ljava/lang/String;

    .line 61
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->licenseFutureLock:Ljava/lang/Object;

    .line 64
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$1;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$1;-><init>(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    .line 252
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$4;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$4;-><init>(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmOperationErrorCallback:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    .line 263
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$5;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$5;-><init>(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmLicenseAcquiredCallback:Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;

    .line 281
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;-><init>(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmOperationCompleteCallback:Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

    .line 320
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$7;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$7;-><init>(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->responseEventListener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    .line 112
    invoke-direct/range {p0 .. p5}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->initializeInternals(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 113
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 44
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->getMetadata(Ljava/lang/String;)V

    return-void
.end method

.method private attachAssetWithMetadata(Lcom/adobe/ave/drm/DRMMetadata;)V
    .locals 1
    .param p1, "metadata"    # Lcom/adobe/ave/drm/DRMMetadata;

    .prologue
    .line 153
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->requestLicenseAnonymously:Ljava/lang/Boolean;

    .line 155
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->context:Landroid/content/Context;

    invoke-static {v0}, Lcom/adobe/ave/drm/DRMManager;->getSharedManager(Landroid/content/Context;)Lcom/adobe/ave/drm/DRMManager;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmManager:Lcom/adobe/ave/drm/DRMManager;

    .line 156
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    .line 157
    invoke-virtual {p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->validate()V

    .line 158
    return-void
.end method

.method private attachAssetWithoutMetadata()V
    .locals 3

    .prologue
    .line 161
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->manifestUri:Ljava/lang/String;

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->responseEventListener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-static {v0, v1, v2}, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil;->attachMetadata(Ljava/lang/String;Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 162
    return-void
.end method

.method private getMetadata(Ljava/lang/String;)V
    .locals 6
    .param p1, "manifest"    # Ljava/lang/String;

    .prologue
    .line 239
    :try_start_0
    sget-object v3, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->TAG_REGEX:Ljava/util/regex/Pattern;

    invoke-virtual {v3, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    .line 241
    .local v1, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->find()Z

    .line 243
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v3, v4}, Landroid/util/Base64;->decode([BI)[B

    move-result-object v2

    .line 245
    .local v2, "rawData":[B
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmManager:Lcom/adobe/ave/drm/DRMManager;

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmOperationErrorCallback:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    invoke-virtual {v3, v2, v4}, Lcom/adobe/ave/drm/DRMManager;->createMetadataFromBytes([BLcom/adobe/ave/drm/DRMOperationErrorCallback;)Lcom/adobe/ave/drm/DRMMetadata;

    move-result-object v3

    iput-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 250
    .end local v1    # "matcher":Ljava/util/regex/Matcher;
    .end local v2    # "rawData":[B
    :goto_0
    return-void

    .line 247
    :catch_0
    move-exception v0

    .line 248
    .local v0, "ex":Ljava/lang/IllegalStateException;
    const-string v3, "7005.1"

    const-string v4, "Failed to get metadata"

    iget-object v5, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->messageId:Ljava/lang/String;

    invoke-virtual {p0, v3, v4, v5}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->sendDrmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private initializeInternals(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 3
    .param p1, "clientState"    # Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    .param p2, "authDelegate"    # Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;
    .param p3, "context"    # Landroid/content/Context;
    .param p4, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p5, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    const/4 v2, 0x0

    .line 116
    iput-object p3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->context:Landroid/content/Context;

    .line 117
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    .line 118
    iput-object p2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    .line 119
    iput-object p4, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 120
    if-nez p2, :cond_0

    .line 121
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/SessionService;

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    invoke-direct {v0, v1, p3, p4}, Lcom/comcast/playerplatform/drm/java/service/SessionService;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->sessionService:Lcom/comcast/playerplatform/drm/java/service/SessionService;

    .line 122
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->sessionService:Lcom/comcast/playerplatform/drm/java/service/SessionService;

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/drm/java/service/SessionService;->addEventListeners(Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;)V

    .line 124
    :cond_0
    sget-object v0, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->FORCE_REFRESH:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->licenseSettings:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    .line 125
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->hasRenewedSession:Ljava/lang/Boolean;

    .line 126
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->listeners:Ljava/util/Vector;

    .line 127
    invoke-static {p3}, Lcom/adobe/ave/drm/DRMManager;->getSharedManager(Landroid/content/Context;)Lcom/adobe/ave/drm/DRMManager;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmManager:Lcom/adobe/ave/drm/DRMManager;

    .line 128
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->requestLicenseAnonymously:Ljava/lang/Boolean;

    .line 129
    if-eqz p5, :cond_1

    .line 130
    invoke-virtual {p5}, Lcom/comcast/playerplatform/util/android/MoneyTrace;->generateHttpHeaderValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->messageId:Ljava/lang/String;

    .line 132
    :cond_1
    sget-object v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Current DRM MessageId:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->messageId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 133
    return-void
.end method

.method private loadVoucherWithToken(Ljava/lang/String;)V
    .locals 3
    .param p1, "drmKey"    # Ljava/lang/String;

    .prologue
    .line 183
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->licenseFutureLock:Ljava/lang/Object;

    monitor-enter v2

    .line 184
    :try_start_0
    invoke-static {}, Lcom/google/common/util/concurrent/SettableFuture;->create()Lcom/google/common/util/concurrent/SettableFuture;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmLicenseFuture:Lcom/google/common/util/concurrent/SettableFuture;

    .line 186
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$2;

    invoke-direct {v0, p0, p1}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$2;-><init>(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;Ljava/lang/String;)V

    .line 206
    .local v0, "licenseRunnable":Ljava/lang/Runnable;
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    invoke-interface {v1}, Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;->getSharedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 207
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    invoke-interface {v1}, Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;->getSharedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 211
    :goto_0
    monitor-exit v2

    .line 212
    return-void

    .line 209
    :cond_0
    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->executeRunnable(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 211
    .end local v0    # "licenseRunnable":Ljava/lang/Runnable;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method


# virtual methods
.method protected acquireVoucher(Ljava/lang/String;)V
    .locals 1
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 168
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmManager:Lcom/adobe/ave/drm/DRMManager;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    if-eqz v0, :cond_0

    .line 170
    if-eqz p1, :cond_1

    .line 172
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->loadVoucherWithToken(Ljava/lang/String;)V

    .line 179
    :cond_0
    :goto_0
    return-void

    .line 176
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->loadVoucherNoToken()V

    goto :goto_0
.end method

.method public addEventListener(Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;)V
    .locals 1
    .param p1, "eventListener"    # Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    .prologue
    .line 313
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->listeners:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 314
    return-void
.end method

.method public attachAsset(Ljava/lang/String;)V
    .locals 1
    .param p1, "asset"    # Ljava/lang/String;

    .prologue
    .line 140
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->attachAsset(Ljava/lang/String;Lcom/adobe/ave/drm/DRMMetadata;)V

    .line 141
    return-void
.end method

.method public attachAsset(Ljava/lang/String;Lcom/adobe/ave/drm/DRMMetadata;)V
    .locals 0
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "metadata"    # Lcom/adobe/ave/drm/DRMMetadata;

    .prologue
    .line 144
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->manifestUri:Ljava/lang/String;

    .line 145
    if-eqz p2, :cond_0

    .line 146
    invoke-direct {p0, p2}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->attachAssetWithMetadata(Lcom/adobe/ave/drm/DRMMetadata;)V

    .line 150
    :goto_0
    return-void

    .line 148
    :cond_0
    invoke-direct {p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->attachAssetWithoutMetadata()V

    goto :goto_0
.end method

.method protected getMetadataToken()Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    .locals 2

    .prologue
    .line 337
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    if-eqz v0, :cond_0

    .line 338
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    invoke-interface {v0}, Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;->getMetadataToken()Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    move-result-object v0

    .line 340
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    sget-object v1, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->META:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    invoke-interface {v0, v1}, Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;->retrieveSecurityToken(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;)Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    move-result-object v0

    goto :goto_0
.end method

.method protected getXsctToken()Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    .locals 2

    .prologue
    .line 329
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    if-eqz v0, :cond_0

    .line 330
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    invoke-interface {v0}, Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;->getAccessToken()Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    move-result-object v0

    .line 332
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    sget-object v1, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->XSCT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    invoke-interface {v0, v1}, Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;->retrieveSecurityToken(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;)Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    move-result-object v0

    goto :goto_0
.end method

.method protected loadVoucherNoToken()V
    .locals 4

    .prologue
    .line 215
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->listeners:Ljava/util/Vector;

    monitor-enter v3

    .line 217
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->listeners:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    .line 218
    .local v1, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    if-eqz v1, :cond_0

    .line 220
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->manifestUri:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;->acquiringLicense(Ljava/lang/String;)V

    goto :goto_0

    .line 223
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_1
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 225
    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    move-result-object v2

    new-instance v3, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$3;

    invoke-direct {v3, p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$3;-><init>(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;)V

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 234
    return-void
.end method

.method protected renewXsctToken()V
    .locals 6

    .prologue
    .line 346
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->hasRenewedSession:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    if-nez v2, :cond_0

    .line 348
    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->hasRenewedSession:Ljava/lang/Boolean;

    .line 349
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->sessionService:Lcom/comcast/playerplatform/drm/java/service/SessionService;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/drm/java/service/SessionService;->create()V

    .line 362
    :goto_0
    return-void

    .line 353
    :cond_0
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->listeners:Ljava/util/Vector;

    monitor-enter v3

    .line 354
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->listeners:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    .line 355
    .local v1, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    if-eqz v1, :cond_1

    .line 357
    const-string v2, "7005.10"

    const-string v4, "XSCT Token is invalid even after it was renewed"

    const-string v5, ""

    invoke-virtual {p0, v2, v4, v5}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->sendDrmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 360
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_2
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public abstract sendDrmComplete(Lcom/adobe/ave/drm/DRMLicense;)V
.end method

.method public abstract sendDrmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract validate()V
.end method
