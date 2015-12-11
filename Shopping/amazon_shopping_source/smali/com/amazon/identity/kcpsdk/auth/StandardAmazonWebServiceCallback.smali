.class public Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;
.super Ljava/lang/Object;
.source "StandardAmazonWebServiceCallback.java"

# interfaces
.implements Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mAuthRespHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;

.field private mListener:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

.field private mResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

.field private mResponseString:Ljava/lang/StringBuilder;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Z)V
    .locals 2
    .param p1, "parser"    # Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;
    .param p2, "listener"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    .param p3, "authenticationRequired"    # Z

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    if-eqz p2, :cond_1

    .line 28
    iput-object p2, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mListener:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

    .line 35
    :goto_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    .line 36
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseString:Ljava/lang/StringBuilder;

    .line 38
    if-eqz p3, :cond_0

    .line 40
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-direct {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;-><init>(Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;)V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mAuthRespHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;

    .line 41
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mAuthRespHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    .line 43
    :cond_0
    return-void

    .line 32
    :cond_1
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;

    invoke-direct {v0}, Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mListener:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

    goto :goto_0
.end method

.method private responseHasError(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "response"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 107
    if-nez p1, :cond_1

    .line 139
    :cond_0
    :goto_0
    return v0

    .line 116
    :cond_1
    :try_start_0
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    const-string/jumbo v3, "getError"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Class;

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    .line 117
    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v2, p1, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_4

    move-result-object v2

    .line 119
    if-nez v2, :cond_0

    move v0, v1

    goto :goto_0

    .line 123
    :catch_0
    move-exception v0

    move v0, v1

    goto :goto_0

    .line 127
    :catch_1
    move-exception v0

    move v0, v1

    goto :goto_0

    .line 131
    :catch_2
    move-exception v0

    move v0, v1

    goto :goto_0

    .line 135
    :catch_3
    move-exception v0

    move v0, v1

    goto :goto_0

    .line 139
    :catch_4
    move-exception v0

    move v0, v1

    goto :goto_0
.end method


# virtual methods
.method public onBodyChunkReceived([BI)V
    .locals 4
    .param p1, "data"    # [B
    .param p2, "len"    # I

    .prologue
    const/16 v1, 0x400

    .line 54
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-interface {v0}, Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;->shouldParseBody()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 56
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseString:Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    if-ge v0, v1, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseString:Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    add-int/2addr v0, p2

    if-le v0, v1, :cond_2

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseString:Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    rsub-int v0, v0, 0x400

    :goto_0
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseString:Ljava/lang/StringBuilder;

    new-instance v2, Ljava/lang/String;

    const/4 v3, 0x0

    invoke-direct {v2, p1, v3, v0}, Ljava/lang/String;-><init>([BII)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 57
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-interface {v0, p1, p2}, Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;->parseBodyChunk([BI)Lcom/amazon/identity/kcpsdk/common/ParseError;

    .line 59
    :cond_1
    return-void

    :cond_2
    move v0, p2

    goto :goto_0
.end method

.method public onHeadersReceived(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V
    .locals 1
    .param p1, "response"    # Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-interface {v0, p1}, Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;->beginParse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V

    .line 49
    return-void
.end method

.method public onNetworkError()V
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mListener:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

    invoke-interface {v0}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;->onNetworkFailure()V

    .line 147
    return-void
.end method

.method public onRequestComplete()V
    .locals 4

    .prologue
    .line 80
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-interface {v2}, Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;->endParse()Lcom/amazon/identity/kcpsdk/common/ParseError;

    .line 82
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-interface {v2}, Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v2

    sget-object v3, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorNoError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    if-eq v2, v3, :cond_0

    .line 84
    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->TAG:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseString:Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 86
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-interface {v2}, Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;->getParseError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v0

    .line 87
    .local v0, "parseError":Lcom/amazon/identity/kcpsdk/common/ParseError;
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mListener:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

    invoke-interface {v2, v0}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;->onParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)V

    .line 103
    .end local v0    # "parseError":Lcom/amazon/identity/kcpsdk/common/ParseError;
    :goto_0
    return-void

    .line 89
    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mAuthRespHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mAuthRespHandler:Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/auth/AuthenticatedResponseHandlerAdapter;->authenticationSucceeded()Z

    move-result v2

    if-nez v2, :cond_1

    .line 91
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mListener:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

    invoke-interface {v2}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;->onAuthenticationFailed()V

    goto :goto_0

    .line 95
    :cond_1
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseParser:Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;

    invoke-interface {v2}, Lcom/amazon/identity/kcpsdk/common/IWebResponseParser;->getParsedResponse()Ljava/lang/Object;

    move-result-object v1

    .line 96
    .local v1, "response":Ljava/lang/Object;
    invoke-direct {p0, v1}, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->responseHasError(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 98
    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->TAG:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mResponseString:Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 101
    :cond_2
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/StandardAmazonWebServiceCallback;->mListener:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

    invoke-interface {v2, v1}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;->onResponseComplete(Ljava/lang/Object;)V

    goto :goto_0
.end method
