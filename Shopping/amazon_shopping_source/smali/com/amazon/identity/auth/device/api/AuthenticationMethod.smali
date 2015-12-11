.class public abstract Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
.super Ljava/lang/Object;
.source "AuthenticationMethod.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/api/AuthenticationMethod$GetAuthenticationHeadersForRequestError;
    }
.end annotation


# static fields
.field public static final KEY_AUTH_HEADERS:Ljava/lang/String; = "auth.headers"

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAuthTypeString:Ljava/lang/String;

.field private final mContext:Landroid/content/Context;

.field private final mDirectedId:Ljava/lang/String;

.field private final mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSetCache;

.field final mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 91
    const-class v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/AuthenticationType;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "authType"    # Lcom/amazon/identity/auth/device/api/AuthenticationType;

    .prologue
    .line 103
    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "authType"    # Ljava/lang/String;

    .prologue
    .line 107
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 108
    if-nez p3, :cond_0

    .line 110
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Must Specify an Authentication Type"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 113
    :cond_0
    invoke-static {p1}, Lcom/amazon/identity/auth/device/api/MAPInit;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPInit;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->initialize()V

    .line 114
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mDirectedId:Ljava/lang/String;

    .line 115
    iput-object p3, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mAuthTypeString:Ljava/lang/String;

    .line 116
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mContext:Landroid/content/Context;

    .line 117
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .line 118
    new-instance v0, Lcom/amazon/identity/auth/device/features/FeatureSetCache;

    new-instance v1, Lcom/amazon/identity/auth/device/features/FeatureSetProvider;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/features/FeatureSetProvider;-><init>(Landroid/content/Context;)V

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/features/FeatureSetCache;-><init>(Lcom/amazon/identity/auth/device/features/FeatureSet;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSetCache;

    .line 119
    return-void
.end method

.method static callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V
    .locals 2
    .param p0, "callbackFuture"    # Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    .param p1, "errorCode"    # I
    .param p2, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 295
    if-nez p0, :cond_0

    .line 301
    :goto_0
    return-void

    .line 299
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->TAG:Ljava/lang/String;

    invoke-static {v0, p2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 300
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string/jumbo v1, "error_code_key"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string/jumbo v1, "error_message_key"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onError(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method private checkParameters$1f04e977(Landroid/net/Uri;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)Z
    .locals 4
    .param p1, "serviceUri"    # Landroid/net/Uri;
    .param p2, "verb"    # Ljava/lang/String;
    .param p3, "callbackFuture"    # Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    .prologue
    const/4 v3, 0x3

    const/4 v1, 0x0

    .line 244
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->throwIfInvalidAccount()V
    :try_end_0
    .catch Lcom/amazon/identity/auth/request/NoCredentialsException; {:try_start_0 .. :try_end_0} :catch_0

    .line 255
    if-nez p1, :cond_0

    .line 257
    const-string/jumbo v2, "The serviceUri cannot be null, please check your parameters!"

    invoke-static {p3, v3, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 288
    :goto_0
    return v1

    .line 248
    :catch_0
    move-exception v2

    const/4 v2, 0x2

    const-string/jumbo v3, "The given directedId does not exist!"

    invoke-static {p3, v2, v3}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    goto :goto_0

    .line 263
    :cond_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 265
    const-string/jumbo v2, "The verb of the request cannot be null, please check your parameters!"

    invoke-static {p3, v3, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    goto :goto_0

    .line 272
    :cond_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mAuthTypeString:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 274
    const-string/jumbo v2, "Please specify an authentication type!"

    invoke-static {p3, v3, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    goto :goto_0

    .line 279
    :cond_2
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mAuthTypeString:Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->parse(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/AuthenticationType;

    move-result-object v0

    .line 281
    .local v0, "authType":Lcom/amazon/identity/auth/device/api/AuthenticationType;
    sget-object v2, Lcom/amazon/identity/auth/device/api/AuthenticationType;->ADPAuthenticator:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    invoke-virtual {v2, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    sget-object v2, Lcom/amazon/identity/auth/device/api/AuthenticationType;->OAuth:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    invoke-virtual {v2, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 283
    const/4 v2, 0x5

    const-string/jumbo v3, "Currently MAP just support ADP and OAuh authentication type for this API. Please check your authentication type."

    invoke-static {p3, v2, v3}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    goto :goto_0

    .line 288
    :cond_3
    const/4 v1, 0x1

    goto :goto_0
.end method

.method private doHeaderAuthentication(Landroid/os/Bundle;Lcom/amazon/identity/auth/request/IRequestAdapter;)V
    .locals 7
    .param p1, "response"    # Landroid/os/Bundle;
    .param p2, "request"    # Lcom/amazon/identity/auth/request/IRequestAdapter;

    .prologue
    .line 315
    invoke-static {p1}, Lcom/amazon/identity/auth/request/AuthenticatedRequestHelpers;->getHeadersInBundle(Landroid/os/Bundle;)Ljava/util/Map;

    move-result-object v1

    .line 316
    .local v1, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v1, :cond_0

    invoke-interface {v1}, Ljava/util/Map;->size()I

    move-result v3

    if-nez v3, :cond_2

    .line 318
    :cond_0
    sget-object v3, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->TAG:Ljava/lang/String;

    .line 331
    :cond_1
    return-void

    .line 322
    :cond_2
    invoke-interface {v1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 324
    .local v0, "header":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {p2, v3}, Lcom/amazon/identity/auth/request/IRequestAdapter;->getHeader(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_3

    .line 326
    sget-object v3, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Overridding header %s because it is needed for authentication"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 329
    :cond_3
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {p2, v3, v4}, Lcom/amazon/identity/auth/request/IRequestAdapter;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private throwIfInvalidAccount()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/request/NoCredentialsException;
        }
    .end annotation

    .prologue
    .line 409
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mDirectedId:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 411
    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;->OAuth:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->getValue()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mAuthTypeString:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 413
    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "OAuth does not support anonymous credentials"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 415
    new-instance v0, Lcom/amazon/identity/auth/request/NoCredentialsException;

    const-string/jumbo v1, "OAuth does not support anonymous credentials"

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/request/NoCredentialsException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 420
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mDirectedId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->isAccountRegistered(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 422
    :cond_1
    return-void

    .line 425
    :cond_2
    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "The account that this AuthenticationMethod with is no longer registered"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 427
    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->TAG:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mDirectedId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccounts()Ljava/util/Set;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->accountNotRegisteredError(Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;)V

    .line 428
    new-instance v0, Lcom/amazon/identity/auth/request/NoCredentialsException;

    const-string/jumbo v1, "The account that this AuthenticationMethod with is no longer registered"

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/request/NoCredentialsException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method authenticateConnection(Lcom/amazon/identity/auth/request/IRequestAdapter;)V
    .locals 4
    .param p1, "request"    # Lcom/amazon/identity/auth/request/IRequestAdapter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 144
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->throwIfInvalidAccount()V

    .line 146
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "getAuthenticationBundle"

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v1

    .line 148
    .local v1, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->getAuthenticationBundle(Lcom/amazon/identity/auth/request/IRequestAdapter;)Landroid/os/Bundle;

    move-result-object v0

    .line 149
    .local v0, "response":Landroid/os/Bundle;
    invoke-virtual {v1}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 150
    if-nez v0, :cond_0

    .line 153
    new-instance v2, Ljava/io/IOException;

    const-string/jumbo v3, "Cannot authenticate because we received no token, the getToken call failed"

    invoke-direct {v2, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 156
    :cond_0
    invoke-direct {p0, v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->doHeaderAuthentication(Landroid/os/Bundle;Lcom/amazon/identity/auth/request/IRequestAdapter;)V

    .line 158
    invoke-virtual {p0, v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->customAuthentication(Landroid/os/Bundle;Lcom/amazon/identity/auth/request/IRequestAdapter;)V

    .line 159
    return-void
.end method

.method customAuthentication(Landroid/os/Bundle;Lcom/amazon/identity/auth/request/IRequestAdapter;)V
    .locals 0
    .param p1, "response"    # Landroid/os/Bundle;
    .param p2, "request"    # Lcom/amazon/identity/auth/request/IRequestAdapter;

    .prologue
    .line 340
    return-void
.end method

.method getAccount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mDirectedId:Ljava/lang/String;

    return-object v0
.end method

.method getAuthenticationBundle(Lcom/amazon/identity/auth/request/IRequestAdapter;)Landroid/os/Bundle;
    .locals 9
    .param p1, "request"    # Lcom/amazon/identity/auth/request/IRequestAdapter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 348
    if-nez p1, :cond_0

    .line 350
    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v5, "The requeset cannot be null!"

    invoke-direct {v0, v5}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 353
    :cond_0
    invoke-interface {p1}, Lcom/amazon/identity/auth/request/IRequestAdapter;->getUri()Landroid/net/Uri;

    move-result-object v1

    .line 354
    .local v1, "serviceUri":Landroid/net/Uri;
    invoke-interface {p1}, Lcom/amazon/identity/auth/request/IRequestAdapter;->getHttpVerb()Ljava/lang/String;

    move-result-object v2

    .line 357
    .local v2, "verb":Ljava/lang/String;
    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;->OAuth:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->getValue()Ljava/lang/String;

    move-result-object v0

    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mAuthTypeString:Ljava/lang/String;

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 359
    invoke-interface {p1}, Lcom/amazon/identity/auth/request/IRequestAdapter;->getHeaders()Ljava/util/Map;

    move-result-object v3

    .line 360
    .local v3, "httpHeaders":Ljava/util/Map;
    invoke-interface {p1}, Lcom/amazon/identity/auth/request/IRequestAdapter;->getBody()[B

    move-result-object v4

    .line 370
    .local v4, "body":[B
    :goto_0
    :try_start_0
    new-instance v5, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    const/4 v0, 0x0

    invoke-direct {v5, v0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->getAuthenticationBundle(Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[BLcom/amazon/identity/auth/device/callback/CallbackFuture;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v7

    .line 372
    .local v7, "futureResult":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    if-nez v7, :cond_2

    .line 374
    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v5, "The future result is null!"

    invoke-direct {v0, v5}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_2

    .line 381
    .end local v7    # "futureResult":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    :catch_0
    move-exception v6

    .line 383
    .local v6, "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v8, "Error happened when try to get authentication bundle, the error message is: "

    invoke-direct {v5, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getErrorBundle()Landroid/os/Bundle;

    move-result-object v8

    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->toString(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v0, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 386
    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v5, "Error happened when try to get authentication bundle"

    invoke-direct {v0, v5}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 364
    .end local v3    # "httpHeaders":Ljava/util/Map;
    .end local v4    # "body":[B
    .end local v6    # "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    :cond_1
    sget-object v3, Ljava/util/Collections;->EMPTY_MAP:Ljava/util/Map;

    .line 365
    .restart local v3    # "httpHeaders":Ljava/util/Map;
    const/4 v0, 0x0

    new-array v4, v0, [B

    .restart local v4    # "body":[B
    goto :goto_0

    .line 378
    .restart local v7    # "futureResult":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    :cond_2
    :try_start_1
    invoke-interface {v7}, Lcom/amazon/identity/auth/device/api/MAPFuture;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Bundle;
    :try_end_1
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_1 .. :try_end_1} :catch_2

    return-object v0

    .line 390
    .end local v7    # "futureResult":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    :catch_1
    move-exception v0

    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "InterruptedException happend when try to get authentication bundle result"

    invoke-static {v0, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 391
    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v5, "Error happened when try to get authentication bundle"

    invoke-direct {v0, v5}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 395
    :catch_2
    move-exception v0

    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "ExecutionException happend when try to get authentication bundle result"

    invoke-static {v0, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 396
    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v5, "Error happened when try to get authentication bundle"

    invoke-direct {v0, v5}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method abstract getAuthenticationBundle(Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[BLcom/amazon/identity/auth/device/callback/CallbackFuture;)Lcom/amazon/identity/auth/device/api/MAPFuture;
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
.end method

.method public getAuthenticationHeadersForRequest(Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[BLcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 7
    .param p1, "serviceUri"    # Landroid/net/Uri;
    .param p2, "verb"    # Ljava/lang/String;
    .param p3, "headers"    # Ljava/util/Map;
    .param p4, "body"    # [B
    .param p5, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            "Ljava/lang/String;",
            "Ljava/util/Map;",
            "[B",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 203
    new-instance v5, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v5, p5}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 206
    .local v5, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    invoke-direct {p0, p1, p2, v5}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->checkParameters$1f04e977(Landroid/net/Uri;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)Z

    move-result v0

    .line 207
    if-nez v0, :cond_0

    .line 227
    :goto_0
    return-object v5

    .line 212
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "getAuthenticationBundle"

    invoke-static {v0, v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v6

    .local v6, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    .line 217
    :try_start_0
    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->getAuthenticationBundle(Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[BLcom/amazon/identity/auth/device/callback/CallbackFuture;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 225
    invoke-virtual {v6}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    goto :goto_0

    .line 221
    :catch_0
    move-exception v0

    :try_start_1
    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Error happened when trying to sign the request components and get the http headers back!"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 225
    invoke-virtual {v6}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-virtual {v6}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v0
.end method

.method getAuthenticationType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mAuthTypeString:Ljava/lang/String;

    return-object v0
.end method

.method getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method getFeatureSet()Lcom/amazon/identity/auth/device/features/FeatureSetCache;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSetCache;

    return-object v0
.end method
