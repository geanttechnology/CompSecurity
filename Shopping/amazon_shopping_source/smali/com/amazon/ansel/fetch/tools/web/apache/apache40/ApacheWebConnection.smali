.class public Lcom/amazon/ansel/fetch/tools/web/apache/apache40/ApacheWebConnection;
.super Ljava/lang/Object;
.source "ApacheWebConnection.java"

# interfaces
.implements Lcom/amazon/ansel/fetch/tools/web/WebConnection;


# instance fields
.field private final client:Lorg/apache/http/client/HttpClient;

.field private final request:Lorg/apache/http/client/methods/HttpRequestBase;


# direct methods
.method public constructor <init>(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpRequestBase;)V
    .locals 0
    .param p1, "client"    # Lorg/apache/http/client/HttpClient;
    .param p2, "request"    # Lorg/apache/http/client/methods/HttpRequestBase;

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/ApacheWebConnection;->client:Lorg/apache/http/client/HttpClient;

    .line 31
    iput-object p2, p0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/ApacheWebConnection;->request:Lorg/apache/http/client/methods/HttpRequestBase;

    .line 32
    return-void
.end method


# virtual methods
.method public abort()V
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/ApacheWebConnection;->request:Lorg/apache/http/client/methods/HttpRequestBase;

    invoke-virtual {v0}, Lorg/apache/http/client/methods/HttpRequestBase;->abort()V

    .line 58
    return-void
.end method

.method public getResponse()Lcom/amazon/ansel/fetch/tools/web/WebResponse;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 41
    new-instance v0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/ApacheWebResponse;

    iget-object v1, p0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/ApacheWebConnection;->client:Lorg/apache/http/client/HttpClient;

    iget-object v2, p0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/ApacheWebConnection;->request:Lorg/apache/http/client/methods/HttpRequestBase;

    invoke-interface {v1, v2}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/ApacheWebResponse;-><init>(Lorg/apache/http/HttpResponse;)V

    return-object v0
.end method
