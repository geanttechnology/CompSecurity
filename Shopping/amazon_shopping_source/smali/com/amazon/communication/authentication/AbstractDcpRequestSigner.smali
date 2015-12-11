.class public abstract Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/amazon/communication/authentication/RequestSigner;


# static fields
.field protected static final EMPTY_BODY:[B

.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field protected final mAuthService:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference",
            "<",
            "Landroid/os/IBinder;",
            ">;"
        }
    .end annotation
.end field

.field protected final mAuthServiceConnection:Landroid/content/ServiceConnection;

.field protected mBindCount:I

.field protected final mBindCounterLock:Ljava/util/concurrent/locks/Lock;

.field protected final mContext:Landroid/content/Context;

.field protected final mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

.field protected final mServiceConnectedCondition:Ljava/util/concurrent/locks/Condition;

.field protected final mServiceConnectedLock:Ljava/util/concurrent/locks/Lock;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "TComm.AbstractDcpRequestSigner"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const/4 v0, 0x0

    new-array v0, v0, [B

    sput-object v0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->EMPTY_BODY:[B

    return-void
.end method

.method private bindService()V
    .locals 7

    const/4 v3, 0x0

    sget-object v0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "bindService"

    const-string/jumbo v2, "attempt to bind service"

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mBindCounterLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_0
    iget v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mBindCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mBindCount:I

    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mContext:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    const-string/jumbo v2, "com.amazon.dcp.sso.action.GET_DEVICE_CREDENTIALS"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mAuthServiceConnection:Landroid/content/ServiceConnection;

    const/4 v3, 0x5

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result v0

    sget-object v1, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "bindService"

    const-string/jumbo v3, "bound service"

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string/jumbo v6, "bindResult"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    aput-object v0, v4, v5

    const/4 v0, 0x2

    const-string/jumbo v5, "bindCount"

    aput-object v5, v4, v0

    const/4 v0, 0x3

    iget v5, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mBindCount:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v0

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mBindCounterLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-void

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mBindCounterLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method private unbindService(Z)V
    .locals 7

    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mBindCounterLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    if-nez p1, :cond_0

    :try_start_0
    iget v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mBindCount:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mBindCount:I

    iget v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mBindCount:I

    if-lez v0, :cond_1

    sget-object v0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "unbindService"

    const-string/jumbo v2, "requests are waiting for sign, should not unbind"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string/jumbo v5, "bind count"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    iget v5, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mBindCount:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mBindCounterLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    :goto_0
    return-void

    :cond_0
    const/4 v0, 0x0

    :try_start_1
    iput v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mBindCount:I

    :cond_1
    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mServiceConnectedLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    sget-object v0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "unbindService"

    const-string/jumbo v2, "unbinding service"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string/jumbo v5, "force unbind"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mAuthService:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mAuthServiceConnection:Landroid/content/ServiceConnection;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V
    :try_end_2
    .catch Ljava/lang/IllegalArgumentException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    :try_start_3
    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mServiceConnectedLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :goto_1
    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mBindCounterLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_0

    :catch_0
    move-exception v0

    :try_start_4
    sget-object v1, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "unbindService"

    const-string/jumbo v3, "caught IllegalArgumentException unbinding, ignoring"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string/jumbo v6, "message"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    :try_start_5
    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mServiceConnectedLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mBindCounterLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0

    :catchall_1
    move-exception v0

    :try_start_6
    iget-object v1, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mServiceConnectedLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0
.end method


# virtual methods
.method protected callAuthenticationService(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/String;Landroid/net/Uri;[BLamazon/communication/authentication/RequestContext;)V
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/authentication/SigningException;,
            Lamazon/communication/MissingCredentialsException;
        }
    .end annotation

    const/4 v0, 0x0

    if-eqz p5, :cond_1

    instance-of v0, p5, Lamazon/communication/authentication/AccountRequestContext;

    if-eqz v0, :cond_0

    check-cast p5, Lamazon/communication/authentication/AccountRequestContext;

    :goto_0
    invoke-virtual {p0, p5}, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->getAmazonAccount(Lamazon/communication/authentication/AccountRequestContext;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->getRequestAuthMethod()Lcom/amazon/dcp/sso/IRequestAuthenticationMethod;

    move-result-object v0

    invoke-virtual {p1}, Lorg/apache/http/client/methods/HttpRequestBase;->getMethod()Ljava/lang/String;

    move-result-object v4

    invoke-static {p3}, Lcom/amazon/communication/authentication/DcpUriSanitizer;->sanitizeUriForDcp(Landroid/net/Uri;)Landroid/net/Uri;

    move-result-object v3

    sget-object v1, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v5, "signRequest"

    const-string/jumbo v6, "Signing request"

    const/16 v7, 0x8

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    const-string/jumbo v9, "authType"

    aput-object v9, v7, v8

    const/4 v8, 0x1

    aput-object p2, v7, v8

    const/4 v8, 0x2

    const-string/jumbo v9, "method"

    aput-object v9, v7, v8

    const/4 v8, 0x3

    aput-object v4, v7, v8

    const/4 v8, 0x4

    const-string/jumbo v9, "uri"

    aput-object v9, v7, v8

    const/4 v8, 0x5

    aput-object v3, v7, v8

    const/4 v8, 0x6

    const-string/jumbo v9, "body.length"

    aput-object v9, v7, v8

    const/4 v8, 0x7

    array-length v9, p4

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-virtual {v1, v5, v6, v7}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    :try_start_0
    sget-object v1, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v5, "callAuthenticationService"

    const-string/jumbo v6, "signing with directedId"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    const-string/jumbo v9, "directedId"

    aput-object v9, v7, v8

    const/4 v8, 0x1

    aput-object v2, v7, v8

    invoke-virtual {v1, v5, v6, v7}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v5

    move-object v1, p2

    move-object v6, p4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod;->getAuthenticationParametersForRequestByDirectedId(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[B)Lcom/amazon/dcp/sso/ReturnValueOrError;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->checkResultForErrors(Lcom/amazon/dcp/sso/ReturnValueOrError;)V

    invoke-virtual {p0, v0, p1}, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->transferAuthHeadersToRequest(Lcom/amazon/dcp/sso/ReturnValueOrError;Lorg/apache/http/client/methods/HttpRequestBase;)V

    return-void

    :cond_0
    new-instance v0, Lamazon/communication/authentication/SigningException;

    const-string/jumbo v1, "The RequestContext must be an AccountRequestContext"

    invoke-direct {v0, v1}, Lamazon/communication/authentication/SigningException;-><init>(Ljava/lang/String;)V

    throw v0

    :catch_0
    move-exception v0

    new-instance v1, Lamazon/communication/authentication/SigningException;

    const-string/jumbo v2, "remote exception"

    invoke-direct {v1, v2, v0}, Lamazon/communication/authentication/SigningException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    :cond_1
    move-object p5, v0

    goto/16 :goto_0
.end method

.method protected checkAndCallAuthenticationService(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/String;Landroid/net/Uri;[BLamazon/communication/authentication/RequestContext;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/authentication/SigningException;,
            Lamazon/communication/MissingCredentialsException;
        }
    .end annotation

    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mAuthService:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "AuthenticationService connection is null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-virtual/range {p0 .. p5}, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->callAuthenticationService(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/String;Landroid/net/Uri;[BLamazon/communication/authentication/RequestContext;)V

    return-void
.end method

.method protected checkResultForErrors(Lcom/amazon/dcp/sso/ReturnValueOrError;)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/authentication/SigningException;
        }
    .end annotation

    invoke-virtual {p1}, Lcom/amazon/dcp/sso/ReturnValueOrError;->isError()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "signRequest"

    const-string/jumbo v2, "error calling signing service"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string/jumbo v5, "response message"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {p1}, Lcom/amazon/dcp/sso/ReturnValueOrError;->getResponseMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    new-instance v0, Lamazon/communication/authentication/SigningException;

    const-string/jumbo v1, "Error calling signing service"

    invoke-direct {v0, v1}, Lamazon/communication/authentication/SigningException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    return-void
.end method

.method protected getAmazonAccount(Lamazon/communication/authentication/AccountRequestContext;)Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/MissingCredentialsException;
        }
    .end annotation

    if-eqz p1, :cond_1

    invoke-virtual {p1}, Lamazon/communication/authentication/AccountRequestContext;->getDirectedId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lamazon/communication/authentication/AccountRequestContext;->getDirectedId()Ljava/lang/String;

    move-result-object v0

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    if-eqz p1, :cond_2

    sget-object v0, Lamazon/communication/authentication/AccountRequestContext;->EMPTY_ACCOUNT:Lamazon/communication/authentication/AccountRequestContext;

    invoke-virtual {v0, p1}, Lamazon/communication/authentication/AccountRequestContext;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getPrimaryAccount()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getPrimaryAccount()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v0, Lamazon/communication/MissingCredentialsException;

    const-string/jumbo v1, "No amazon account found"

    invoke-direct {v0, v1}, Lamazon/communication/MissingCredentialsException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected getRequestAuthMethod()Lcom/amazon/dcp/sso/IRequestAuthenticationMethod;
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mAuthService:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/IBinder;

    invoke-static {v0}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/dcp/sso/IRequestAuthenticationMethod;

    move-result-object v0

    return-object v0
.end method

.method protected signRequest(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/String;Landroid/net/Uri;[BLamazon/communication/authentication/RequestContext;)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/authentication/SigningException;,
            Lamazon/communication/MissingCredentialsException;
        }
    .end annotation

    const/4 v5, 0x0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "This method cannot be called on the main thread"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    sget-object v0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "signRequest"

    const-string/jumbo v2, "authservice"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mAuthService:Ljava/util/concurrent/atomic/AtomicReference;

    aput-object v4, v3, v5

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    invoke-direct {p0}, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->bindService()V

    invoke-virtual {p0}, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->waitForService()V

    :try_start_0
    invoke-virtual/range {p0 .. p5}, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->checkAndCallAuthenticationService(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/String;Landroid/net/Uri;[BLamazon/communication/authentication/RequestContext;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    invoke-direct {p0, v5}, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->unbindService(Z)V

    return-void

    :catchall_0
    move-exception v0

    invoke-direct {p0, v5}, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->unbindService(Z)V

    throw v0
.end method

.method protected transferAuthHeadersToRequest(Lcom/amazon/dcp/sso/ReturnValueOrError;Lorg/apache/http/client/methods/HttpRequestBase;)V
    .locals 4

    if-nez p2, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-virtual {p1}, Lcom/amazon/dcp/sso/ReturnValueOrError;->getResponse()Landroid/os/Bundle;

    move-result-object v0

    const-string/jumbo v1, "auth.headers"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    if-nez v1, :cond_2

    sget-object v0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "transferAuthHeadersToRequest"

    const-string/jumbo v2, "no headers returned in auth bundle"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    :cond_2
    invoke-virtual {v1}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2, v0, v3}, Lorg/apache/http/client/methods/HttpRequestBase;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method protected validateRequest(Lorg/apache/http/client/methods/HttpRequestBase;)V
    .locals 2

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Request cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    return-void
.end method

.method protected waitForService()V
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/authentication/SigningException;
        }
    .end annotation

    const/4 v9, 0x0

    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mAuthService:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sget-object v2, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v3, "waitForService"

    const-string/jumbo v4, "waiting for service to bind"

    new-array v5, v9, [Ljava/lang/Object;

    invoke-virtual {v2, v3, v4, v5}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v2, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mServiceConnectedLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_0
    iget-object v2, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mAuthService:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    if-eqz v2, :cond_1

    iget-object v0, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mServiceConnectedLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_0

    :cond_1
    :try_start_1
    iget-object v2, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mServiceConnectedCondition:Ljava/util/concurrent/locks/Condition;

    const-wide/16 v3, 0x7d0

    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v2, v3, v4, v5}, Ljava/util/concurrent/locks/Condition;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v2

    if-nez v2, :cond_2

    sget-object v0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "waitForService"

    const-string/jumbo v2, "Timed out waiting for service binder"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    new-instance v0, Lamazon/communication/authentication/SigningException;

    const-string/jumbo v1, "Timed out waiting for service binder"

    invoke-direct {v0, v1}, Lamazon/communication/authentication/SigningException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :catch_0
    move-exception v0

    :try_start_2
    sget-object v0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "waitForService"

    const-string/jumbo v2, "Interrupted waiting for service binder"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    new-instance v0, Lamazon/communication/authentication/SigningException;

    const-string/jumbo v1, "Interrupted waiting for service binder"

    invoke-direct {v0, v1}, Lamazon/communication/authentication/SigningException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mServiceConnectedLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0

    :cond_2
    iget-object v2, p0, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->mServiceConnectedLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    sget-object v4, Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v5, "waitForService"

    const-string/jumbo v6, "finished waiting for service to bind"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const-string/jumbo v8, "elapsedMs"

    aput-object v8, v7, v9

    const/4 v8, 0x1

    sub-long v0, v2, v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    aput-object v0, v7, v8

    invoke-virtual {v4, v5, v6, v7}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0
.end method
