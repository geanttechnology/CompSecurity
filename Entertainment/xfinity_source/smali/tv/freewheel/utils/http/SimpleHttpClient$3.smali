.class Ltv/freewheel/utils/http/SimpleHttpClient$3;
.super Lorg/apache/http/impl/client/DefaultRedirectHandler;
.source "SimpleHttpClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/utils/http/SimpleHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/utils/http/SimpleHttpClient;


# direct methods
.method constructor <init>(Ltv/freewheel/utils/http/SimpleHttpClient;)V
    .locals 0

    .prologue
    .line 134
    iput-object p1, p0, Ltv/freewheel/utils/http/SimpleHttpClient$3;->this$0:Ltv/freewheel/utils/http/SimpleHttpClient;

    invoke-direct {p0}, Lorg/apache/http/impl/client/DefaultRedirectHandler;-><init>()V

    return-void
.end method


# virtual methods
.method public getLocationURI(Lorg/apache/http/HttpResponse;Lorg/apache/http/protocol/HttpContext;)Ljava/net/URI;
    .locals 6
    .param p1, "response"    # Lorg/apache/http/HttpResponse;
    .param p2, "context"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/apache/http/ProtocolException;
        }
    .end annotation

    .prologue
    .line 138
    :try_start_0
    invoke-super {p0, p1, p2}, Lorg/apache/http/impl/client/DefaultRedirectHandler;->getLocationURI(Lorg/apache/http/HttpResponse;Lorg/apache/http/protocol/HttpContext;)Ljava/net/URI;
    :try_end_0
    .catch Lorg/apache/http/ProtocolException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 154
    :goto_0
    return-object v3

    .line 139
    :catch_0
    move-exception v2

    .line 140
    .local v2, "pex":Lorg/apache/http/ProtocolException;
    invoke-virtual {v2}, Lorg/apache/http/ProtocolException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    .line 141
    .local v0, "cause":Ljava/lang/Throwable;
    instance-of v3, v0, Ljava/net/URISyntaxException;

    if-nez v3, :cond_0

    .line 143
    throw v2

    .line 146
    :cond_0
    check-cast v0, Ljava/net/URISyntaxException;

    .end local v0    # "cause":Ljava/lang/Throwable;
    invoke-virtual {v0}, Ljava/net/URISyntaxException;->getInput()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ltv/freewheel/utils/URIUtil;->getFixedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 147
    .local v1, "fixedLocation":Ljava/lang/String;
    if-nez v1, :cond_1

    .line 149
    throw v2

    .line 152
    :cond_1
    iget-object v3, p0, Ltv/freewheel/utils/http/SimpleHttpClient$3;->this$0:Ltv/freewheel/utils/http/SimpleHttpClient;

    # getter for: Ltv/freewheel/utils/http/SimpleHttpClient;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v3}, Ltv/freewheel/utils/http/SimpleHttpClient;->access$200(Ltv/freewheel/utils/http/SimpleHttpClient;)Ltv/freewheel/utils/Logger;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Try fixed redirect location "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 153
    const-string v3, "location"

    invoke-interface {p1, v3, v1}, Lorg/apache/http/HttpResponse;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 154
    invoke-super {p0, p1, p2}, Lorg/apache/http/impl/client/DefaultRedirectHandler;->getLocationURI(Lorg/apache/http/HttpResponse;Lorg/apache/http/protocol/HttpContext;)Ljava/net/URI;

    move-result-object v3

    goto :goto_0
.end method
