.class Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;
.super Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
.source "CentralDcpAuthenticationMethod.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/ADPCorpusSigningAuthenticationMethod;


# static fields
.field private static final METRICS_COMPONENT_NAME:Ljava/lang/String;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    const-class v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->TAG:Ljava/lang/String;

    .line 40
    const-class v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/AuthenticationType;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "authType"    # Lcom/amazon/identity/auth/device/api/AuthenticationType;

    .prologue
    .line 50
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/AuthenticationType;)V

    .line 52
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->mContext:Landroid/content/Context;

    .line 53
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "authType"    # Ljava/lang/String;

    .prologue
    .line 59
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->mContext:Landroid/content/Context;

    .line 62
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;Lcom/amazon/dcp/sso/ReturnValueOrError;Lcom/amazon/identity/auth/device/callback/CallbackFuture;[BLandroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 4
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;
    .param p1, "x1"    # Lcom/amazon/dcp/sso/ReturnValueOrError;
    .param p2, "x2"    # Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    .param p3, "x3"    # [B
    .param p4, "x4"    # Landroid/os/Bundle;
    .param p5, "x5"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    const/4 v2, 0x1

    .line 35
    if-nez p1, :cond_0

    const-string/jumbo v0, "Connection to SSO timedout."

    sget-object v1, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->TAG:Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {p2, v2, v0}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    invoke-virtual {p1}, Lcom/amazon/dcp/sso/ReturnValueOrError;->isError()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p1}, Lcom/amazon/dcp/sso/ReturnValueOrError;->getResponse()Landroid/os/Bundle;

    move-result-object v0

    const-string/jumbo v1, "token"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "digest"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    const-string/jumbo v3, "adp_token"

    invoke-virtual {v2, v3, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v1, "adp_signature"

    invoke-virtual {v2, v1, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p2, v2}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onSuccess(Landroid/os/Bundle;)V

    goto :goto_0

    :cond_1
    invoke-virtual {p1}, Lcom/amazon/dcp/sso/ReturnValueOrError;->getResponseMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/amazon/dcp/sso/ReturnValueOrError;->getResponseCode()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    :pswitch_0
    const/4 v1, 0x5

    invoke-static {p2, v1, v0}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    goto :goto_0

    :pswitch_1
    if-eqz p4, :cond_2

    const-string/jumbo v1, "UseFallBackCredentials"

    const/4 v2, 0x0

    invoke-virtual {p4, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccount()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-instance v2, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$3;

    invoke-direct {v2, p0, p2}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$3;-><init>(Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V

    invoke-direct {p0, p3, v0, v1, v2}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->signCorpusWithDirectedId([BLjava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    goto :goto_0

    :cond_2
    const/4 v1, 0x2

    invoke-static {p2, v1, v0}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    goto :goto_0

    :pswitch_2
    invoke-static {p2, v2, v0}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    goto :goto_0

    :pswitch_3
    const/4 v1, 0x3

    invoke-static {p2, v1, v0}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_1
        :pswitch_3
        :pswitch_3
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method private signCorpusWithDirectedId([BLjava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 14
    .param p1, "corpus"    # [B
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "signCorpusOption"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([B",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 278
    const-string/jumbo v1, "You cannot authenticate this corpus on the main thread!"

    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->throwIfOnMainThread(Ljava/lang/String;)V

    .line 280
    new-instance v8, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    move-object/from16 v0, p4

    invoke-direct {v8, v0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 281
    .local v8, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    if-nez p1, :cond_1

    .line 283
    sget-object v1, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->TAG:Ljava/lang/String;

    invoke-static {v8, v1}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->nullCorpusCallbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;Ljava/lang/String;)V

    .line 299
    :cond_0
    :goto_0
    return-object v8

    .line 286
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->getAuthenticationType()Ljava/lang/String;

    move-result-object v12

    .line 287
    .local v12, "authType":Ljava/lang/String;
    sget-object v1, Lcom/amazon/identity/auth/device/api/AuthenticationType;->ADPAuthenticator:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 289
    const-string/jumbo v1, "Only supprot authentication type: %s. Cannot sign the corpus with invalid authentication type: %s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    sget-object v4, Lcom/amazon/identity/auth/device/api/AuthenticationType;->ADPAuthenticator:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->getValue()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object v12, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v13

    .line 293
    .local v13, "errorMessage":Ljava/lang/String;
    sget-object v1, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->TAG:Ljava/lang/String;

    invoke-static {v1, v13}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 294
    const/4 v1, 0x3

    invoke-static {v8, v1, v13}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    goto :goto_0

    .line 299
    .end local v13    # "errorMessage":Ljava/lang/String;
    :cond_2
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/AuthenticatedRequestServiceIntentFactory;->findAuthRequestService(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/AuthenticatedRequestServiceIntentFactory;

    move-result-object v2

    if-nez v2, :cond_3

    const-string/jumbo v1, "A Central device credential location cannot be found."

    sget-object v2, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->TAG:Ljava/lang/String;

    invoke-static {v2, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v2, 0x1

    invoke-static {v8, v2, v1}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    goto :goto_0

    :cond_3
    sget-object v1, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v3, "bind"

    invoke-static {v1, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v6

    new-instance v1, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/accounts/AuthenticatedRequestServiceIntentFactory;->buildIntentForService()Landroid/content/Intent;

    move-result-object v4

    const/4 v5, 0x1

    move-object v2, p0

    move-object v7, p1

    move-object/from16 v9, p3

    move-object/from16 v10, p4

    move-object/from16 v11, p2

    invoke-direct/range {v1 .. v11}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;-><init>(Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;Landroid/content/Context;Landroid/content/Intent;ILcom/amazon/identity/platform/metric/PlatformMetricsTimer;[BLcom/amazon/identity/auth/device/callback/CallbackFuture;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->call()Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "Failed to bind to AuthenticatedRequestService."

    sget-object v2, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->TAG:Ljava/lang/String;

    invoke-static {v2, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v2, 0x1

    invoke-static {v8, v2, v1}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    goto :goto_0
.end method

.method private throwIfOnMainThread(Ljava/lang/String;)V
    .locals 4
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 258
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-virtual {v2}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->getId()J

    move-result-wide v0

    .line 259
    .local v0, "mainThreadId":J
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->getId()J

    move-result-wide v2

    cmp-long v2, v2, v0

    if-nez v2, :cond_0

    .line 261
    new-instance v2, Ljava/lang/IllegalStateException;

    invoke-direct {v2, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 263
    :cond_0
    return-void
.end method


# virtual methods
.method protected getAuthenticationBundle(Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[BLcom/amazon/identity/auth/device/callback/CallbackFuture;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 14
    .param p1, "serviceUri"    # Landroid/net/Uri;
    .param p2, "verb"    # Ljava/lang/String;
    .param p3, "headers"    # Ljava/util/Map;
    .param p4, "body"    # [B
    .param p5, "callbackFuture"    # Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            "Ljava/lang/String;",
            "Ljava/util/Map;",
            "[B",
            "Lcom/amazon/identity/auth/device/callback/CallbackFuture;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 71
    const-string/jumbo v1, "You cannot authenticate this request on the main thread!"

    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->throwIfOnMainThread(Ljava/lang/String;)V

    .line 73
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/AuthenticatedRequestServiceIntentFactory;->findAuthRequestService(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/AuthenticatedRequestServiceIntentFactory;

    move-result-object v12

    .line 75
    .local v12, "findAuthServiceIntentFactory":Lcom/amazon/identity/auth/accounts/AuthenticatedRequestServiceIntentFactory;
    if-nez v12, :cond_0

    .line 78
    const/4 v1, 0x1

    const-string/jumbo v2, "A Central device credential location cannot be found"

    move-object/from16 v0, p5

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 81
    new-instance v1, Ljava/io/IOException;

    const-string/jumbo v2, "A Central device credential location cannot be found"

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 84
    :cond_0
    new-instance v11, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {v11}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    .line 85
    .local v11, "requestAuthVal":Ljava/util/concurrent/atomic/AtomicReference;, "Ljava/util/concurrent/atomic/AtomicReference<Lcom/amazon/dcp/sso/ReturnValueOrError;>;"
    sget-object v1, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v2, "bind"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v6

    .line 87
    .local v6, "bindTimer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    new-instance v1, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->mContext:Landroid/content/Context;

    invoke-virtual {v12}, Lcom/amazon/identity/auth/accounts/AuthenticatedRequestServiceIntentFactory;->buildIntentForService()Landroid/content/Intent;

    move-result-object v4

    const/4 v5, 0x1

    move-object v2, p0

    move-object v7, p1

    move-object/from16 v8, p2

    move-object/from16 v9, p3

    move-object/from16 v10, p4

    invoke-direct/range {v1 .. v11}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;-><init>(Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;Landroid/content/Context;Landroid/content/Intent;ILcom/amazon/identity/platform/metric/PlatformMetricsTimer;Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[BLjava/util/concurrent/atomic/AtomicReference;)V

    .line 179
    sget-wide v2, Lcom/amazon/identity/auth/request/AuthenticatedRequestHelpers;->DEFAULT_CONNECT_TO_SSO_TIMEOUT:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    const-string/jumbo v4, "GetAuthenticationParameters"

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;->run(Ljava/lang/Long;Ljava/util/concurrent/TimeUnit;Ljava/lang/String;)V

    .line 183
    invoke-virtual {v11}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/dcp/sso/ReturnValueOrError;

    if-nez v1, :cond_1

    const/4 v1, 0x1

    const-string/jumbo v2, "Connection to SSO timeout"

    move-object/from16 v0, p5

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    new-instance v1, Ljava/io/IOException;

    const-string/jumbo v2, "Connection to SSO timeout"

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_1
    invoke-virtual {v1}, Lcom/amazon/dcp/sso/ReturnValueOrError;->isError()Z

    move-result v2

    if-nez v2, :cond_3

    invoke-virtual {v1}, Lcom/amazon/dcp/sso/ReturnValueOrError;->getResponse()Landroid/os/Bundle;

    move-result-object v13

    .line 184
    .local v13, "response":Landroid/os/Bundle;
    if-eqz p5, :cond_2

    if-eqz v13, :cond_2

    .line 186
    move-object/from16 v0, p5

    invoke-virtual {v0, v13}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onSuccess(Landroid/os/Bundle;)V

    .line 188
    :cond_2
    return-object p5

    .line 183
    .end local v13    # "response":Landroid/os/Bundle;
    :cond_3
    invoke-virtual {v1}, Lcom/amazon/dcp/sso/ReturnValueOrError;->getResponseMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/dcp/sso/ReturnValueOrError;->getResponseCode()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    :pswitch_0
    const/4 v1, 0x6

    move-object/from16 v0, p5

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    :pswitch_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->mContext:Landroid/content/Context;

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->recordDMSCredentialErrorAndCallDeregisterIfNecessary(Landroid/content/Context;Ljava/lang/String;)V

    const/4 v1, 0x2

    move-object/from16 v0, p5

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    new-instance v1, Lcom/amazon/identity/auth/request/NoCredentialsException;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/request/NoCredentialsException;-><init>(Ljava/lang/String;)V

    throw v1

    :pswitch_2
    const/4 v1, 0x1

    move-object/from16 v0, p5

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    new-instance v1, Ljava/io/IOException;

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    :pswitch_3
    const/4 v1, 0x6

    move-object/from16 v0, p5

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    :pswitch_4
    const/4 v1, 0x4

    move-object/from16 v0, p5

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_1
        :pswitch_4
        :pswitch_0
        :pswitch_3
        :pswitch_2
    .end packed-switch
.end method

.method public signCorpus([BLandroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 2
    .param p1, "corpus"    # [B
    .param p2, "signCorpusOption"    # Landroid/os/Bundle;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([B",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 269
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->getAccount()Ljava/lang/String;

    move-result-object v0

    .line 270
    .local v0, "directedId":Ljava/lang/String;
    invoke-direct {p0, p1, v0, p2, p3}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->signCorpusWithDirectedId([BLjava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v1

    return-object v1
.end method
