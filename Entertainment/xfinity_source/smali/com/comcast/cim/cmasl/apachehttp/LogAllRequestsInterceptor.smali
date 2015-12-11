.class public Lcom/comcast/cim/cmasl/apachehttp/LogAllRequestsInterceptor;
.super Ljava/lang/Object;
.source "LogAllRequestsInterceptor.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/comcast/cim/cmasl/apachehttp/LogAllRequestsInterceptor;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/apachehttp/LogAllRequestsInterceptor;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 7
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 22
    :try_start_0
    const-string v4, "http.target_host"

    invoke-interface {p2, v4}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 23
    .local v3, "targetHost":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->toURI()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 29
    .end local v3    # "targetHost":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .local v1, "hostName":Ljava/lang/String;
    :goto_0
    sget-object v4, Lcom/comcast/cim/cmasl/apachehttp/LogAllRequestsInterceptor;->LOG:Lorg/slf4j/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 30
    return-void

    .line 24
    .end local v1    # "hostName":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 25
    .local v2, "safelyIgnored":Ljava/lang/Exception;
    const-string v4, "Host"

    invoke-interface {p1, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .line 26
    .local v0, "host":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v0, :cond_0

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "]"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .restart local v1    # "hostName":Ljava/lang/String;
    :goto_1
    goto :goto_0

    .end local v1    # "hostName":Ljava/lang/String;
    :cond_0
    const-string v1, ""

    goto :goto_1
.end method
