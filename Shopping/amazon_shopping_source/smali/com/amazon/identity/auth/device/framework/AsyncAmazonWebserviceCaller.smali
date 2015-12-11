.class public Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;
.super Ljava/lang/Object;
.source "AsyncAmazonWebserviceCaller.java"

# interfaces
.implements Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;


# instance fields
.field private mContext:Landroid/content/Context;

.field private mCredentials:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

.field private mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

.field private final mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/credentials/AccountCredentials;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "credentials"    # Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v0, 0x0

    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mContext:Landroid/content/Context;

    .line 25
    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    .line 26
    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mCredentials:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    .line 41
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mContext:Landroid/content/Context;

    .line 42
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mCredentials:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    .line 43
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mCredentials:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    invoke-direct {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;-><init>(Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    .line 44
    iput-object p3, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    .line 45
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 31
    invoke-static {p1}, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    move-result-object v0

    invoke-direct {p0, p1, v0, p2}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/credentials/AccountCredentials;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 32
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 36
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->getCredentialsForAccount(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    move-result-object v0

    invoke-direct {p0, p1, v0, p3}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/credentials/AccountCredentials;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 37
    return-void
.end method

.method private tryToRefreshRequestSigner()V
    .locals 3

    .prologue
    .line 80
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mCredentials:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mCredentials:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mContext:Landroid/content/Context;

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/credentials/AccountCredentials;->isStale(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 90
    :cond_0
    :goto_0
    return-void

    .line 85
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mCredentials:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    .line 87
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->getUseLegacyAuthentication()Z

    move-result v0

    .line 88
    .local v0, "usingLegacyAuth":Z
    new-instance v1, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mCredentials:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    invoke-direct {v1, v2}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;-><init>(Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    .line 89
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    invoke-virtual {v1, v0}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->setUseLegacyAuthentication(Z)V

    goto :goto_0
.end method


# virtual methods
.method public call(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Ljava/lang/Object;
    .locals 2
    .param p1, "webRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p2, "responseParser"    # Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;
    .param p3, "listener"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;
        }
    .end annotation

    .prologue
    .line 97
    new-instance v0, Ljava/lang/RuntimeException;

    const-string/jumbo v1, "This should not be called!"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;)Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;
    .locals 6
    .param p1, "webRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p2, "callback"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->tryToRefreshRequestSigner()V

    .line 51
    new-instance v0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mContext:Landroid/content/Context;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    move-object v2, p1

    move-object v3, p2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;-><init>(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    return-object v0
.end method

.method public createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;
    .locals 6
    .param p1, "webRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p2, "responseParser"    # Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;
    .param p3, "listener"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->tryToRefreshRequestSigner()V

    .line 60
    new-instance v3, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getAuthenticationRequired()Z

    move-result v0

    invoke-direct {v3, p2, p3, v0}, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;-><init>(Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Z)V

    .line 62
    .local v3, "callback":Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;
    new-instance v0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mContext:Landroid/content/Context;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    move-object v2, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;-><init>(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    return-object v0
.end method

.method public createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;
    .locals 1
    .param p1, "webRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p2, "responseParser"    # Lcom/amazon/identity/kcpsdk/common/WebResponseParser;
    .param p3, "listener"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

    .prologue
    .line 70
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;

    invoke-direct {v0, p2}, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;-><init>(Lcom/amazon/identity/kcpsdk/common/WebResponseParser;)V

    invoke-virtual {p0, p1, v0, p3}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;
    .locals 1
    .param p1, "x0"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p2, "x1"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;

    .prologue
    .line 22
    invoke-virtual {p0, p1, p2}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;)Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;
    .locals 1
    .param p1, "x0"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p2, "x1"    # Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;
    .param p3, "x2"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

    .prologue
    .line 22
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;
    .locals 1
    .param p1, "x0"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p2, "x1"    # Lcom/amazon/identity/kcpsdk/common/WebResponseParser;
    .param p3, "x2"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

    .prologue
    .line 22
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    move-result-object v0

    return-object v0
.end method

.method public setUseLegacyAuthentication(Z)V
    .locals 1
    .param p1, "useLegacyAuthentication"    # Z

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->setUseLegacyAuthentication(Z)V

    .line 76
    return-void
.end method
