.class public Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;
.super Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;
.source "ThePlatformResponseHandler.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private smil:Lcom/xfinity/playerlib/authorization/SMILResource;

.field private final smilParser:Lcom/xfinity/playerlib/authorization/SMILParser;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 26
    new-instance v0, Lcom/xfinity/playerlib/authorization/SMILParser;

    invoke-direct {v0}, Lcom/xfinity/playerlib/authorization/SMILParser;-><init>()V

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;-><init>(Lcom/xfinity/playerlib/authorization/SMILParser;)V

    .line 27
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/authorization/SMILParser;)V
    .locals 1
    .param p1, "smilParser"    # Lcom/xfinity/playerlib/authorization/SMILParser;

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;->smilParser:Lcom/xfinity/playerlib/authorization/SMILParser;

    .line 21
    invoke-virtual {p0}, Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;->addDefaultHeaderHandlers()V

    .line 22
    new-instance v0, Lcom/comcast/cim/cmasl/http/response/StrictHttpStatusCodeHandler;

    invoke-direct {v0}, Lcom/comcast/cim/cmasl/http/response/StrictHttpStatusCodeHandler;-><init>()V

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;->addDelegateHeadersHandler(Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;)V

    .line 23
    return-void
.end method


# virtual methods
.method public getSMILResource()Lcom/xfinity/playerlib/authorization/SMILResource;
    .locals 3

    .prologue
    .line 45
    :try_start_0
    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;->smil:Lcom/xfinity/playerlib/authorization/SMILResource;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 48
    :goto_0
    return-object v1

    .line 46
    :catch_0
    move-exception v0

    .line 47
    .local v0, "e":Ljava/lang/Exception;
    sget-object v1, Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Unable to get platform token from platform response"

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 48
    new-instance v1, Lcom/xfinity/playerlib/authorization/SMILResource;

    const-string v2, "Got Invalid Platform Response - No Token Available"

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/authorization/SMILResource;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 4
    .param p1, "bodyStream"    # Ljava/io/InputStream;

    .prologue
    .line 33
    :try_start_0
    const-string v2, "UTF-8"

    invoke-static {p1, v2}, Lorg/apache/commons/io/IOUtils;->toString(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 34
    .local v1, "responseBody":Ljava/lang/String;
    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;->smilParser:Lcom/xfinity/playerlib/authorization/SMILParser;

    invoke-virtual {v2, v1}, Lcom/xfinity/playerlib/authorization/SMILParser;->parse(Ljava/lang/String;)Lcom/xfinity/playerlib/authorization/SMILResource;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;->smil:Lcom/xfinity/playerlib/authorization/SMILResource;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 39
    invoke-static {p1}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 41
    .end local v1    # "responseBody":Ljava/lang/String;
    :goto_0
    return-void

    .line 35
    :catch_0
    move-exception v0

    .line 36
    .local v0, "exception":Ljava/lang/Exception;
    :try_start_1
    sget-object v2, Lcom/xfinity/playerlib/authorization/ThePlatformResponseHandler;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Unable to read response from thePlatform."

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 39
    invoke-static {p1}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    goto :goto_0

    .end local v0    # "exception":Ljava/lang/Exception;
    :catchall_0
    move-exception v2

    invoke-static {p1}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    throw v2
.end method
