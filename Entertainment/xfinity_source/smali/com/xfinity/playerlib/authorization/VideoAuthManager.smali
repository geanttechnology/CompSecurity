.class public Lcom/xfinity/playerlib/authorization/VideoAuthManager;
.super Ljava/lang/Object;
.source "VideoAuthManager.java"

# interfaces
.implements Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private amsVideoAuth:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

.field private authKeys:Lcom/comcast/cim/model/user/AuthKeys;

.field final httpRequestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field final httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private liveStreamChannel:Ljava/lang/String;

.field private liveStreamScm:Ljava/lang/String;

.field final objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

.field final requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private smil:Lcom/xfinity/playerlib/authorization/SMILResource;

.field final trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

.field final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

.field private vcClient:Lcom/xfinity/playerlib/authorization/VideoContinueClient;

.field private videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

.field private videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

.field final videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation
.end field

.field final xipRequestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 34
    const-class v0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;)V
    .locals 0
    .param p1, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .param p2, "objectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;
    .param p5, "trackingService"    # Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/user/PlayNowUserManager;",
            "Lcom/fasterxml/jackson/databind/ObjectMapper;",
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;",
            "Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner",
            "<TT;>;>;)V"
        }
    .end annotation

    .prologue
    .line 64
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager<TT;>;"
    .local p3, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p4, "videoEntitlementCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    .local p6, "httpRequestProviderFactory":Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;, "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p7, "xipRequestProviderFactory":Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;, "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p8, "requestSignerFactory":Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory<Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 66
    iput-object p2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 67
    iput-object p3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 68
    iput-object p4, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 69
    iput-object p5, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    .line 70
    iput-object p6, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->httpRequestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    .line 71
    iput-object p7, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->xipRequestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    .line 72
    iput-object p8, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    .line 73
    return-void
.end method

.method private callThePlatform(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 5
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 198
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager<TT;>;"
    :try_start_0
    sget-object v2, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    const-string v3, "\n####thePlatform SMIL service call####"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 199
    sget-object v2, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "\n####smilUrl is:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getReleaseURL()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 200
    new-instance v1, Lcom/xfinity/playerlib/authorization/ThePlatformClient;

    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    iget-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->httpRequestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    invoke-direct {v1, v2, v3}, Lcom/xfinity/playerlib/authorization/ThePlatformClient;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;)V

    .line 201
    .local v1, "tpClient":Lcom/xfinity/playerlib/authorization/ThePlatformClient;
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getReleaseURL()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/authorization/ThePlatformClient;->getSMILResource(Ljava/lang/String;)Lcom/xfinity/playerlib/authorization/SMILResource;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->smil:Lcom/xfinity/playerlib/authorization/SMILResource;

    .line 202
    sget-object v2, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "*Signed Manifest Url: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->smil:Lcom/xfinity/playerlib/authorization/SMILResource;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/authorization/SMILResource;->getSignedManifestUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 203
    sget-object v2, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "*AdsType: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->smil:Lcom/xfinity/playerlib/authorization/SMILResource;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/authorization/SMILResource;->getAdsType()Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 208
    return-void

    .line 204
    .end local v1    # "tpClient":Lcom/xfinity/playerlib/authorization/ThePlatformClient;
    :catch_0
    move-exception v0

    .line 205
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    const-string v3, "thePlatform call encountered exception:"

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 206
    throw v0
.end method

.method private reset()V
    .locals 3

    .prologue
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager<TT;>;"
    const/4 v2, 0x0

    .line 76
    sget-object v0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    const-string v1, "AuthManager reset..."

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 77
    iput-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->authKeys:Lcom/comcast/cim/model/user/AuthKeys;

    .line 78
    iput-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 79
    iput-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->amsVideoAuth:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    .line 80
    iput-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->smil:Lcom/xfinity/playerlib/authorization/SMILResource;

    .line 81
    iput-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->vcClient:Lcom/xfinity/playerlib/authorization/VideoContinueClient;

    .line 82
    iput-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->liveStreamChannel:Ljava/lang/String;

    .line 83
    iput-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->liveStreamScm:Ljava/lang/String;

    .line 84
    return-void
.end method

.method private setupAuth()V
    .locals 4

    .prologue
    .line 107
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager<TT;>;"
    invoke-direct {p0}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->reset()V

    .line 109
    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    .line 110
    .local v0, "user":Lcom/xfinity/playerlib/model/user/PlayNowUser;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getAuthKeys()Lcom/comcast/cim/model/user/AuthKeys;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->authKeys:Lcom/comcast/cim/model/user/AuthKeys;

    .line 111
    sget-object v1, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "####Auth Key:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->authKeys:Lcom/comcast/cim/model/user/AuthKeys;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 113
    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    iput-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 114
    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    if-eqz v1, :cond_0

    .line 115
    sget-object v1, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "*edata: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->getEdata()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 116
    sget-object v1, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "*xedata: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->getXedata()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 118
    :cond_0
    return-void
.end method


# virtual methods
.method public getDrmToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 229
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager<TT;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->amsVideoAuth:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->amsVideoAuth:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->getDevicePlaybackToken()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSmil()Lcom/xfinity/playerlib/authorization/SMILResource;
    .locals 1

    .prologue
    .line 221
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager<TT;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->smil:Lcom/xfinity/playerlib/authorization/SMILResource;

    return-object v0
.end method

.method public getVideoAuthToken()Lcom/xfinity/playerlib/authorization/VideoAuthToken;
    .locals 1

    .prologue
    .line 225
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager<TT;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    return-object v0
.end method

.method public onTokenExpired(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "channel"    # Ljava/lang/String;
    .param p2, "scm"    # Ljava/lang/String;

    .prologue
    .line 239
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager<TT;>;"
    :try_start_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->performTVEAuth()V

    .line 240
    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->getRawData()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 245
    :goto_0
    return-object v1

    .line 241
    :catch_0
    move-exception v0

    .line 242
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 245
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public performAMSAuth(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 11
    .param p1, "secureMetadataValue"    # Ljava/lang/String;
    .param p2, "pin"    # Ljava/lang/String;
    .param p3, "isLiveStream"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 123
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager<TT;>;"
    :try_start_0
    sget-object v1, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    const-string v2, "\n####AMS Access service call####"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 125
    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v9

    check-cast v9, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .line 126
    .local v9, "userSettings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    invoke-virtual {v9}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getDeviceAuthToken()Ljava/lang/String;

    move-result-object v4

    .line 127
    .local v4, "deviceAuthToken":Ljava/lang/String;
    invoke-virtual {v9}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getPreviousSessionId()Ljava/lang/String;

    move-result-object v5

    .line 128
    .local v5, "previousSessionId":Ljava/lang/String;
    new-instance v10, Lcom/comcast/cim/cmasl/http/service/RetryingHttpService;

    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v2, Lcom/xfinity/playerlib/authorization/VideoAuthManager$1;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/authorization/VideoAuthManager$1;-><init>(Lcom/xfinity/playerlib/authorization/VideoAuthManager;)V

    invoke-direct {v10, v1, v2}, Lcom/comcast/cim/cmasl/http/service/RetryingHttpService;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/http/service/RetryingHttpService$RetryPredicate;)V

    .line 137
    .local v10, "videoAuthorizationHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    new-instance v0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;

    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->xipRequestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    iget-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    invoke-direct {v0, v10, v1, v2, v3}, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;)V

    .line 139
    .local v0, "client":Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;
    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->authKeys:Lcom/comcast/cim/model/user/AuthKeys;

    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    move-object v3, p1

    move-object v6, p2

    move v7, p3

    invoke-virtual/range {v0 .. v7}, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;->authorize(Lcom/comcast/cim/model/user/AuthKeys;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->amsVideoAuth:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    .line 142
    sget-object v1, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "*Playback token: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->amsVideoAuth:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->getDevicePlaybackToken()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 143
    sget-object v1, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "*Device auth token: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->amsVideoAuth:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->getDeviceAuthorizationToken()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 144
    sget-object v1, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "*Session id: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->amsVideoAuth:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->getSessionToken()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 147
    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->amsVideoAuth:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->getSessionToken()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 148
    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->amsVideoAuth:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->getDeviceAuthorizationToken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v9, v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setDeviceAuthToken(Ljava/lang/String;)V

    .line 149
    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->amsVideoAuth:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->getSessionToken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v9, v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setPreviousSessionId(Ljava/lang/String;)V

    .line 151
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->saveUserAsync()V
    :try_end_0
    .catch Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 162
    return-void

    .line 153
    .end local v0    # "client":Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;
    .end local v4    # "deviceAuthToken":Ljava/lang/String;
    .end local v5    # "previousSessionId":Ljava/lang/String;
    .end local v9    # "userSettings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    .end local v10    # "videoAuthorizationHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    :catch_0
    move-exception v8

    .line 154
    .local v8, "e":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    sget-object v1, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    const-string v2, "AMS call encountered exception:"

    invoke-interface {v1, v2, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 155
    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    invoke-virtual {v8}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getDetailedStatus()Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackAMSRelatedVideoError(Ljava/lang/String;)V

    .line 156
    throw v8

    .line 157
    .end local v8    # "e":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    :catch_1
    move-exception v8

    .line 158
    .local v8, "e":Ljava/lang/Exception;
    sget-object v1, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    const-string v2, "AMS call encountered exception:"

    invoke-interface {v1, v2, v8}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 159
    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    invoke-virtual {v8}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackAMSRelatedVideoError(Ljava/lang/String;)V

    .line 160
    throw v8
.end method

.method public performLiveStreamAuthorization(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Ljava/lang/String;)V
    .locals 2
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .param p2, "pin"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 93
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager<TT;>;"
    invoke-direct {p0}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->setupAuth()V

    .line 94
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getPlaybackLink()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 95
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->isEspn()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->isDisney()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 96
    :cond_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getSchemeSpecificPart()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->liveStreamChannel:Ljava/lang/String;

    .line 97
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getScm()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->liveStreamScm:Ljava/lang/String;

    .line 98
    invoke-virtual {p0}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->performTVEAuth()V

    .line 104
    :goto_0
    return-void

    .line 103
    :cond_1
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getScm()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {p0, v0, p2, v1}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->performAMSAuth(Ljava/lang/String;Ljava/lang/String;Z)V

    goto :goto_0
.end method

.method public performTVEAuth()V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 166
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager<TT;>;"
    :try_start_0
    sget-object v3, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    const-string v4, "\n####TVE Token Request call####"

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 168
    new-instance v2, Lcom/comcast/cim/cmasl/http/service/RetryingHttpService;

    iget-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v4, Lcom/xfinity/playerlib/authorization/VideoAuthManager$2;

    invoke-direct {v4, p0}, Lcom/xfinity/playerlib/authorization/VideoAuthManager$2;-><init>(Lcom/xfinity/playerlib/authorization/VideoAuthManager;)V

    invoke-direct {v2, v3, v4}, Lcom/comcast/cim/cmasl/http/service/RetryingHttpService;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/http/service/RetryingHttpService$RetryPredicate;)V

    .line 176
    .local v2, "videoAuthTokenHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    new-instance v0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;

    iget-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->xipRequestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    iget-object v4, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    invoke-direct {v0, v2, v3, v4}, Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;)V

    .line 178
    .local v0, "client":Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;
    iget-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->authKeys:Lcom/comcast/cim/model/user/AuthKeys;

    iget-object v4, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    iget-object v5, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->liveStreamChannel:Ljava/lang/String;

    iget-object v6, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->liveStreamScm:Ljava/lang/String;

    invoke-virtual {v0, v3, v4, v5, v6}, Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;->authorize(Lcom/comcast/cim/model/user/AuthKeys;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Ljava/lang/String;)Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    .line 180
    sget-object v3, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "*Auth token title id: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->getTitleID()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 181
    sget-object v3, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "*Auth token resource id: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->getResourceID()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 182
    sget-object v3, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "*Auth token keyName: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->getKeyName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 183
    sget-object v3, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "*Auth token value: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->getValue()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 194
    return-void

    .line 185
    .end local v0    # "client":Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;
    .end local v2    # "videoAuthTokenHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    :catch_0
    move-exception v1

    .line 186
    .local v1, "e":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    sget-object v3, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    const-string v4, "AMS call encountered exception:"

    invoke-interface {v3, v4, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 187
    iget-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getDetailedStatus()Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackAMSRelatedVideoError(Ljava/lang/String;)V

    .line 188
    throw v1

    .line 189
    .end local v1    # "e":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    :catch_1
    move-exception v1

    .line 190
    .local v1, "e":Ljava/lang/Exception;
    sget-object v3, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    const-string v4, "AMS call encountered exception:"

    invoke-interface {v3, v4, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 191
    iget-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackAMSRelatedVideoError(Ljava/lang/String;)V

    .line 192
    throw v1
.end method

.method public performVideoAuthorization(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Ljava/lang/String;)V
    .locals 2
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "pin"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 87
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager<TT;>;"
    invoke-direct {p0}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->setupAuth()V

    .line 88
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getSecureMetadata()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p2, v1}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->performAMSAuth(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 89
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->callThePlatform(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    .line 90
    return-void
.end method

.method public sendVideoContinueHeartbeat()V
    .locals 6

    .prologue
    .line 211
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager<TT;>;"
    sget-object v1, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    const-string v2, "\n####AMS Continue service call####"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 212
    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->vcClient:Lcom/xfinity/playerlib/authorization/VideoContinueClient;

    if-nez v1, :cond_0

    .line 213
    new-instance v1, Lcom/xfinity/playerlib/authorization/VideoContinueClient;

    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    iget-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v4, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->xipRequestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    iget-object v5, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/xfinity/playerlib/authorization/VideoContinueClient;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;)V

    iput-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->vcClient:Lcom/xfinity/playerlib/authorization/VideoContinueClient;

    .line 216
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->vcClient:Lcom/xfinity/playerlib/authorization/VideoContinueClient;

    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->authKeys:Lcom/comcast/cim/model/user/AuthKeys;

    iget-object v3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->amsVideoAuth:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    invoke-virtual {v1, v2, v3}, Lcom/xfinity/playerlib/authorization/VideoContinueClient;->sendHeartbeat(Lcom/comcast/cim/model/user/AuthKeys;Lcom/xfinity/playerlib/authorization/VideoAuthorization;)Lcom/xfinity/playerlib/authorization/VideoSession;

    move-result-object v0

    .line 217
    .local v0, "videoSession":Lcom/xfinity/playerlib/authorization/VideoSession;
    sget-object v1, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->LOG:Lorg/slf4j/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "*Status code: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-interface {v0}, Lcom/xfinity/playerlib/authorization/VideoSession;->getStatusCode()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 218
    return-void
.end method

.method public shouldMakeContinueCall()Z
    .locals 1

    .prologue
    .line 233
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager<TT;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->amsVideoAuth:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->amsVideoAuth:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->getSessionToken()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
