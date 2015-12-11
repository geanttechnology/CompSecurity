.class public Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;
.super Ljava/lang/Object;
.source "AmazonWebserviceCaller.java"

# interfaces
.implements Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

.field private final mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "tokenAuthProvider"    # Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    .line 23
    if-eqz p2, :cond_0

    .line 25
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    invoke-direct {v0, p2}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;-><init>(Lcom/amazon/identity/kcpsdk/auth/ITokenAuthProvider;)V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    .line 27
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mContext:Landroid/content/Context;

    .line 28
    iput-object p3, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    .line 29
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "requestSigner"    # Lcom/amazon/identity/kcpsdk/auth/RequestSigner;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    .line 33
    iput-object p2, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    .line 34
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mContext:Landroid/content/Context;

    .line 35
    iput-object p3, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    .line 36
    return-void
.end method


# virtual methods
.method public call(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Ljava/lang/Object;
    .locals 3
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
    .line 81
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-static {v0, p1, p2, v1, v2}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->run(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;
    .locals 6
    .param p1, "webRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p2, "callback"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;

    .prologue
    .line 51
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mContext:Landroid/content/Context;

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    move-object v2, p1

    move-object v3, p2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;-><init>(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 52
    return-object v0
.end method

.method public createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;
    .locals 6
    .param p1, "webRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p2, "responseParser"    # Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;
    .param p3, "listener"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

    .prologue
    .line 68
    new-instance v3, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getAuthenticationRequired()Z

    move-result v0

    invoke-direct {v3, p2, p3, v0}, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;-><init>(Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Z)V

    .line 71
    .local v3, "callback":Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mContext:Landroid/content/Context;

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    move-object v2, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;-><init>(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 73
    return-object v0
.end method

.method public createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;
    .locals 1
    .param p1, "webRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p2, "responseParser"    # Lcom/amazon/identity/kcpsdk/common/WebResponseParser;
    .param p3, "listener"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

    .prologue
    .line 60
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;

    invoke-direct {v0, p2}, Lcom/amazon/identity/kcpsdk/auth/WebResponseParserAdapter;-><init>(Lcom/amazon/identity/kcpsdk/common/WebResponseParser;)V

    invoke-virtual {p0, p1, v0, p3}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;

    move-result-object v0

    return-object v0
.end method

.method public getUsingLegacyAuthentication()Z
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->getUseLegacyAuthentication()Z

    move-result v0

    return v0
.end method

.method public setUsingLegacyAuthentication(Z)V
    .locals 1
    .param p1, "useLegacyAuthentication"    # Z

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCaller;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->setUseLegacyAuthentication(Z)V

    .line 41
    return-void
.end method
