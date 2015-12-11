.class public Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;
.super Ljava/lang/Object;
.source "ClientSessionRequest.java"


# static fields
.field public static ACCOUNT_WORKFLOW:Ljava/lang/String;

.field public static DEPROVISION_WORKFLOW:Ljava/lang/String;

.field public static PROVISION_WORKFLOW:Ljava/lang/String;

.field public static SESSION_WORKFLOW:Ljava/lang/String;

.field public static final logger:Lorg/slf4j/Logger;


# instance fields
.field protected final adobeDrmEventListener:Lcom/adobe/mediacore/DRMService$DRMEventListener;

.field protected final adobeDrmLicenseAcquiredCallback:Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;

.field protected final adobeDrmOperationCallback:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

.field protected final adobeDrmOperationCompleteCallback:Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

.field private clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

.field private drmManager:Lcom/adobe/ave/drm/DRMManager;

.field private drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

.field private drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

.field protected final licenseReturnCompleteCallback:Lcom/adobe/ave/drm/DRMLicenseReturnCompleteCallback;

.field private messageId:Ljava/lang/String;

.field private metadataRequest:Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;

.field private final onMetadataResponse:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

.field private productName:Ljava/lang/String;

.field private requestString:Ljava/lang/String;

.field private workflow:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 39
    const-string v0, "Session"

    sput-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->SESSION_WORKFLOW:Ljava/lang/String;

    .line 40
    const-string v0, "Provision"

    sput-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->PROVISION_WORKFLOW:Ljava/lang/String;

    .line 41
    const-string v0, "Deprovision"

    sput-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->DEPROVISION_WORKFLOW:Ljava/lang/String;

    .line 42
    const-string v0, "Account"

    sput-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->ACCOUNT_WORKFLOW:Ljava/lang/String;

    .line 43
    const-class v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;Landroid/content/Context;)V
    .locals 7
    .param p1, "appclientState"    # Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    .param p2, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p3, "adobeDrmEventListener"    # Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    .param p4, "context"    # Landroid/content/Context;

    .prologue
    .line 205
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    new-instance v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$1;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$1;-><init>(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->adobeDrmEventListener:Lcom/adobe/mediacore/DRMService$DRMEventListener;

    .line 68
    new-instance v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$2;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$2;-><init>(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->onMetadataResponse:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    .line 105
    new-instance v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$3;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$3;-><init>(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->adobeDrmOperationCallback:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    .line 136
    new-instance v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$4;-><init>(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->adobeDrmLicenseAcquiredCallback:Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;

    .line 179
    new-instance v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$5;-><init>(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->adobeDrmOperationCompleteCallback:Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

    .line 197
    new-instance v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$6;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$6;-><init>(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->licenseReturnCompleteCallback:Lcom/adobe/ave/drm/DRMLicenseReturnCompleteCallback;

    .line 206
    sget-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ClientSessionRequest created. ThreadTest:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 209
    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    move-result-object v6

    new-instance v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;

    move-object v1, p0

    move-object v2, p4

    move-object v3, p1

    move-object v4, p3

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$7;-><init>(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Landroid/content/Context;Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    invoke-virtual {v6, v0}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 219
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->acquireLicense()V

    return-void
.end method

.method static synthetic access$100(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->onMetadataResponse:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    return-object v0
.end method

.method static synthetic access$102(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;
    .param p1, "x1"    # Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    return-object p1
.end method

.method static synthetic access$1102(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->requestString:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$200(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    return-object v0
.end method

.method static synthetic access$202(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;)Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;
    .param p1, "x1"    # Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    return-object p1
.end method

.method static synthetic access$300(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->expireMetadataToken()V

    return-void
.end method

.method static synthetic access$400(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->messageId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$402(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->messageId:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$500(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->workflow:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/adobe/ave/drm/DRMMetadata;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    return-object v0
.end method

.method static synthetic access$700(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/adobe/ave/drm/DRMManager;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmManager:Lcom/adobe/ave/drm/DRMManager;

    return-object v0
.end method

.method static synthetic access$702(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Lcom/adobe/ave/drm/DRMManager;)Lcom/adobe/ave/drm/DRMManager;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;
    .param p1, "x1"    # Lcom/adobe/ave/drm/DRMManager;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmManager:Lcom/adobe/ave/drm/DRMManager;

    return-object p1
.end method

.method static synthetic access$800(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->productName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$802(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->productName:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$902(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;)Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;
    .param p1, "x1"    # Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->metadataRequest:Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;

    return-object p1
.end method

.method private acquireLicense()V
    .locals 7

    .prologue
    const/4 v3, 0x0

    .line 281
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    sget-object v1, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->META:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    invoke-interface {v0, v1}, Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;->retrieveSecurityToken(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;)Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->getToken()Ljava/lang/String;

    move-result-object v6

    .line 282
    .local v6, "token":Ljava/lang/String;
    sget-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Current Metadata token"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {v6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 283
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmManager:Lcom/adobe/ave/drm/DRMManager;

    invoke-static {v6, v3}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->adobeDrmOperationCallback:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/ave/drm/DRMManager;->createMetadataFromBytes([BLcom/adobe/ave/drm/DRMOperationErrorCallback;)Lcom/adobe/ave/drm/DRMMetadata;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    .line 284
    sget-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    const-string v1, "DrmMetadata created. Start SetAuth."

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 285
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmManager:Lcom/adobe/ave/drm/DRMManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    invoke-virtual {v2}, Lcom/adobe/ave/drm/DRMMetadata;->getPolicies()[Lcom/adobe/ave/drm/DRMPolicy;

    move-result-object v2

    aget-object v2, v2, v3

    invoke-virtual {v2}, Lcom/adobe/ave/drm/DRMPolicy;->getAuthenticationDomain()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->requestString:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->adobeDrmOperationCallback:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    iget-object v5, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->adobeDrmOperationCompleteCallback:Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

    invoke-virtual/range {v0 .. v5}, Lcom/adobe/ave/drm/DRMManager;->setAuthenticationToken(Lcom/adobe/ave/drm/DRMMetadata;Ljava/lang/String;[BLcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V

    .line 290
    return-void
.end method

.method private expireMetadataToken()V
    .locals 4

    .prologue
    .line 128
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    sget-object v3, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->META:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    invoke-interface {v2, v3}, Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;->retrieveSecurityToken(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;)Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 129
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v2, "yyyy-MM-dd\'T\'HH:mm:ss\'Z\'"

    invoke-direct {v0, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 130
    .local v0, "df":Ljava/text/DateFormat;
    const-string v2, "Zulu"

    invoke-static {v2}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/text/DateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 131
    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0, v2}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    .line 132
    .local v1, "onOrAfter":Ljava/lang/String;
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    sget-object v3, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->META:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    invoke-interface {v2, v3}, Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;->retrieveSecurityToken(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;)Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->setNotOnOrAfter(Ljava/lang/String;)V

    .line 134
    .end local v0    # "df":Ljava/text/DateFormat;
    .end local v1    # "onOrAfter":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private sendTokenRequest(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 7
    .param p1, "type"    # Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;
    .param p2, "messageType"    # Ljava/lang/String;
    .param p3, "accountToken"    # Ljava/lang/String;
    .param p4, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 248
    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    move-result-object v6

    new-instance v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;

    move-object v1, p0

    move-object v2, p4

    move-object v3, p2

    move-object v4, p3

    move-object v5, p1

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$8;-><init>(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;Lcom/comcast/playerplatform/util/android/MoneyTrace;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;)V

    invoke-virtual {v6, v0}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 277
    return-void
.end method


# virtual methods
.method public create(Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 3
    .param p1, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 223
    sget-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "SessionCreate.  ThreadTest:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 224
    sget-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->SESSION_WORKFLOW:Ljava/lang/String;

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->workflow:Ljava/lang/String;

    .line 225
    sget-object v0, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->XSCT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    const-string v1, "clientSession"

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2, p1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->sendTokenRequest(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 226
    return-void
.end method

.method public getXactToken(Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 3
    .param p1, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 229
    sget-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "GetXACT.  ThreadTest:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 230
    sget-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->ACCOUNT_WORKFLOW:Ljava/lang/String;

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->workflow:Ljava/lang/String;

    .line 231
    sget-object v0, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->XACT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    const-string v1, "clientAuthentication"

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2, p1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->sendTokenRequest(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 232
    return-void
.end method

.method public submitMetadataRequest()V
    .locals 1

    .prologue
    .line 314
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->metadataRequest:Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;->submitRequest()V

    .line 315
    return-void
.end method

.method public submitRequest()V
    .locals 3

    .prologue
    .line 299
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    sget-object v2, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->META:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    invoke-interface {v1, v2}, Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;->retrieveSecurityToken(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;)Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    move-result-object v0

    .line 300
    .local v0, "metadataToken":Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->isValid()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 302
    sget-object v1, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    const-string v2, "MetaData is valid. Submitting DRM Request."

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 303
    invoke-direct {p0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->acquireLicense()V

    .line 310
    :goto_0
    return-void

    .line 307
    :cond_0
    sget-object v1, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    const-string v2, "MetaData is invalid, refreshing data."

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 308
    invoke-virtual {p0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->submitMetadataRequest()V

    goto :goto_0
.end method
