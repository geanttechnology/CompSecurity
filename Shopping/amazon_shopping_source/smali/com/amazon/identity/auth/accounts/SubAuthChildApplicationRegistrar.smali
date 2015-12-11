.class public Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;
.super Ljava/lang/Object;
.source "SubAuthChildApplicationRegistrar.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrar;


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAuthenticator:Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V
    .locals 0
    .param p1, "authenticator"    # Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;->mAuthenticator:Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;

    .line 28
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;JLjava/util/Map;[B)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .locals 5
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;
    .param p1, "x1"    # J
    .param p3, "x2"    # Ljava/util/Map;
    .param p4, "x3"    # [B

    .prologue
    .line 19
    new-instance v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;

    invoke-direct {v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;-><init>()V

    new-instance v3, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    invoke-direct {v3}, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;-><init>()V

    invoke-virtual {v3, p1, p2}, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->setStatusCode(J)V

    invoke-interface {p3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v3, v1, v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    invoke-virtual {v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->beginParse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->shouldParseBody()Z

    move-result v0

    if-eqz v0, :cond_1

    array-length v0, p4

    int-to-long v0, v0

    invoke-virtual {v2, p4, v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->parseBodyChunk([BJ)Lcom/amazon/identity/kcpsdk/common/ParseError;

    :cond_1
    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->endParse()Lcom/amazon/identity/kcpsdk/common/ParseError;

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->getParsedResponse()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public registerChild(Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "exchangeTokenRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p3, "callback"    # Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;
    .param p4, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 38
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;->mAuthenticator:Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;

    invoke-virtual {p2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {p2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getVerbAsString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getNumHeaders()I

    move-result v5

    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3, v5}, Ljava/util/HashMap;-><init>(I)V

    const/4 v4, 0x0

    :goto_0
    if-ge v4, v5, :cond_0

    invoke-virtual {p2, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getHeaderName(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p2, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getHeaderValue(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v6, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    :cond_0
    invoke-virtual {p2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getBodyBytes()[B

    move-result-object v4

    new-instance v5, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar$1;

    invoke-direct {v5, p0, p3}, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar$1;-><init>(Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;)V

    invoke-interface/range {v0 .. v5}, Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;->callGetCredentialsWebservice(Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[BLcom/amazon/dcp/sso/IWebserviceCallback;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 91
    :goto_1
    return-void

    .line 89
    :catch_0
    move-exception v0

    sget-object v0, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "RemoteException calling AmazonAccountAuthenticator.callGetCredentialsWebservice"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method
