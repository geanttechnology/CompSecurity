.class public Ltv/freewheel/utils/http/SimpleHttpClient;
.super Ljava/lang/Object;
.source "SimpleHttpClient.java"

# interfaces
.implements Ltv/freewheel/utils/http/ISimpleHttpClient;


# static fields
.field private static final sThreadBlocked:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private static final sThreadCheckInterceptor:Lorg/apache/http/HttpRequestInterceptor;


# instance fields
.field private final delegate:Lorg/apache/http/client/HttpClient;

.field private logger:Ltv/freewheel/utils/Logger;

.field private mLeakedException:Ljava/lang/RuntimeException;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 50
    new-instance v0, Ljava/lang/ThreadLocal;

    invoke-direct {v0}, Ljava/lang/ThreadLocal;-><init>()V

    sput-object v0, Ltv/freewheel/utils/http/SimpleHttpClient;->sThreadBlocked:Ljava/lang/ThreadLocal;

    .line 54
    new-instance v0, Ltv/freewheel/utils/http/SimpleHttpClient$1;

    invoke-direct {v0}, Ltv/freewheel/utils/http/SimpleHttpClient$1;-><init>()V

    sput-object v0, Ltv/freewheel/utils/http/SimpleHttpClient;->sThreadCheckInterceptor:Lorg/apache/http/HttpRequestInterceptor;

    return-void
.end method

.method public constructor <init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    .locals 3
    .param p1, "ccm"    # Lorg/apache/http/conn/ClientConnectionManager;
    .param p2, "params"    # Lorg/apache/http/params/HttpParams;

    .prologue
    .line 110
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "SimpleHttpClient created and never closed"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->mLeakedException:Ljava/lang/RuntimeException;

    .line 111
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v1

    iput-object v1, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->logger:Ltv/freewheel/utils/Logger;

    .line 112
    new-instance v0, Ltv/freewheel/utils/http/SimpleHttpClient$2;

    invoke-direct {v0, p0, p1, p2}, Ltv/freewheel/utils/http/SimpleHttpClient$2;-><init>(Ltv/freewheel/utils/http/SimpleHttpClient;Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V

    .line 134
    .local v0, "defaultHttpClient":Lorg/apache/http/impl/client/DefaultHttpClient;
    new-instance v1, Ltv/freewheel/utils/http/SimpleHttpClient$3;

    invoke-direct {v1, p0}, Ltv/freewheel/utils/http/SimpleHttpClient$3;-><init>(Ltv/freewheel/utils/http/SimpleHttpClient;)V

    invoke-virtual {v0, v1}, Lorg/apache/http/impl/client/DefaultHttpClient;->setRedirectHandler(Lorg/apache/http/client/RedirectHandler;)V

    .line 158
    iput-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->delegate:Lorg/apache/http/client/HttpClient;

    .line 159
    return-void
.end method

.method static synthetic access$000()Ljava/lang/ThreadLocal;
    .locals 1

    .prologue
    .line 42
    sget-object v0, Ltv/freewheel/utils/http/SimpleHttpClient;->sThreadBlocked:Ljava/lang/ThreadLocal;

    return-object v0
.end method

.method static synthetic access$100()Lorg/apache/http/HttpRequestInterceptor;
    .locals 1

    .prologue
    .line 42
    sget-object v0, Ltv/freewheel/utils/http/SimpleHttpClient;->sThreadCheckInterceptor:Lorg/apache/http/HttpRequestInterceptor;

    return-object v0
.end method

.method static synthetic access$200(Ltv/freewheel/utils/http/SimpleHttpClient;)Ltv/freewheel/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/utils/http/SimpleHttpClient;

    .prologue
    .line 42
    iget-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->logger:Ltv/freewheel/utils/Logger;

    return-object v0
.end method

.method public static newInstance(Ljava/lang/String;)Ltv/freewheel/utils/http/ISimpleHttpClient;
    .locals 7
    .param p0, "userAgent"    # Ljava/lang/String;

    .prologue
    const/16 v5, 0x4e20

    .line 70
    new-instance v1, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v1}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 73
    .local v1, "params":Lorg/apache/http/params/HttpParams;
    const-string v3, "http.protocol.content-charset"

    const-string v4, "UTF-8"

    invoke-interface {v1, v3, v4}, Lorg/apache/http/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/http/params/HttpParams;

    .line 77
    const/4 v3, 0x0

    invoke-static {v1, v3}, Lorg/apache/http/params/HttpConnectionParams;->setStaleCheckingEnabled(Lorg/apache/http/params/HttpParams;Z)V

    .line 80
    invoke-static {v1, v5}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 82
    invoke-static {v1, v5}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 84
    const/16 v3, 0x2000

    invoke-static {v1, v3}, Lorg/apache/http/params/HttpConnectionParams;->setSocketBufferSize(Lorg/apache/http/params/HttpParams;I)V

    .line 86
    const-string v3, "http.protocol.cookie-policy"

    const-string v4, "compatibility"

    invoke-interface {v1, v3, v4}, Lorg/apache/http/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/http/params/HttpParams;

    .line 89
    const/4 v3, 0x1

    invoke-static {v1, v3}, Lorg/apache/http/client/params/HttpClientParams;->setRedirecting(Lorg/apache/http/params/HttpParams;Z)V

    .line 95
    invoke-static {v1, p0}, Lorg/apache/http/params/HttpProtocolParams;->setUserAgent(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V

    .line 96
    new-instance v2, Lorg/apache/http/conn/scheme/SchemeRegistry;

    invoke-direct {v2}, Lorg/apache/http/conn/scheme/SchemeRegistry;-><init>()V

    .line 97
    .local v2, "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    new-instance v3, Lorg/apache/http/conn/scheme/Scheme;

    const-string v4, "http"

    invoke-static {}, Lorg/apache/http/conn/scheme/PlainSocketFactory;->getSocketFactory()Lorg/apache/http/conn/scheme/PlainSocketFactory;

    move-result-object v5

    const/16 v6, 0x50

    invoke-direct {v3, v4, v5, v6}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v2, v3}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 99
    new-instance v3, Lorg/apache/http/conn/scheme/Scheme;

    const-string v4, "https"

    invoke-static {}, Lorg/apache/http/conn/ssl/SSLSocketFactory;->getSocketFactory()Lorg/apache/http/conn/ssl/SSLSocketFactory;

    move-result-object v5

    const/16 v6, 0x1bb

    invoke-direct {v3, v4, v5, v6}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v2, v3}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 102
    new-instance v0, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;

    invoke-direct {v0, v1, v2}, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;-><init>(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V

    .line 107
    .local v0, "manager":Lorg/apache/http/conn/ClientConnectionManager;
    new-instance v3, Ltv/freewheel/utils/http/SimpleHttpClient;

    invoke-direct {v3, v0, v1}, Ltv/freewheel/utils/http/SimpleHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V

    return-object v3
.end method


# virtual methods
.method public close()V
    .locals 1

    .prologue
    .line 229
    iget-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->mLeakedException:Ljava/lang/RuntimeException;

    if-eqz v0, :cond_0

    .line 230
    invoke-virtual {p0}, Ltv/freewheel/utils/http/SimpleHttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/conn/ClientConnectionManager;->shutdown()V

    .line 231
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->mLeakedException:Ljava/lang/RuntimeException;

    .line 233
    :cond_0
    return-void
.end method

.method public execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;
    .locals 1
    .param p1, "target"    # Lorg/apache/http/HttpHost;
    .param p2, "request"    # Lorg/apache/http/HttpRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/HttpHost;",
            "Lorg/apache/http/HttpRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 206
    .local p3, "responseHandler":Lorg/apache/http/client/ResponseHandler;, "Lorg/apache/http/client/ResponseHandler<+TT;>;"
    iget-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->delegate:Lorg/apache/http/client/HttpClient;

    invoke-interface {v0, p1, p2, p3}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;
    .locals 1
    .param p1, "target"    # Lorg/apache/http/HttpHost;
    .param p2, "request"    # Lorg/apache/http/HttpRequest;
    .param p4, "context"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/HttpHost;",
            "Lorg/apache/http/HttpRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;",
            "Lorg/apache/http/protocol/HttpContext;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 212
    .local p3, "responseHandler":Lorg/apache/http/client/ResponseHandler;, "Lorg/apache/http/client/ResponseHandler<+TT;>;"
    iget-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->delegate:Lorg/apache/http/client/HttpClient;

    invoke-interface {v0, p1, p2, p3, p4}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;
    .locals 1
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/client/methods/HttpUriRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 195
    .local p2, "responseHandler":Lorg/apache/http/client/ResponseHandler;, "Lorg/apache/http/client/ResponseHandler<+TT;>;"
    iget-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->delegate:Lorg/apache/http/client/HttpClient;

    invoke-interface {v0, p1, p2}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;
    .locals 1
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .param p3, "context"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/client/methods/HttpUriRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;",
            "Lorg/apache/http/protocol/HttpContext;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 201
    .local p2, "responseHandler":Lorg/apache/http/client/ResponseHandler;, "Lorg/apache/http/client/ResponseHandler<+TT;>;"
    iget-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->delegate:Lorg/apache/http/client/HttpClient;

    invoke-interface {v0, p1, p2, p3}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    .locals 1
    .param p1, "target"    # Lorg/apache/http/HttpHost;
    .param p2, "request"    # Lorg/apache/http/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 184
    iget-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->delegate:Lorg/apache/http/client/HttpClient;

    invoke-interface {v0, p1, p2}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    .locals 1
    .param p1, "target"    # Lorg/apache/http/HttpHost;
    .param p2, "request"    # Lorg/apache/http/HttpRequest;
    .param p3, "context"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 189
    iget-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->delegate:Lorg/apache/http/client/HttpClient;

    invoke-interface {v0, p1, p2, p3}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    .locals 1
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 174
    iget-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->delegate:Lorg/apache/http/client/HttpClient;

    invoke-interface {v0, p1}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    .locals 1
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .param p2, "context"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 179
    iget-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->delegate:Lorg/apache/http/client/HttpClient;

    invoke-interface {v0, p1, p2}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method protected finalize()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 217
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 218
    iget-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->mLeakedException:Ljava/lang/RuntimeException;

    if-eqz v0, :cond_0

    .line 219
    iget-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Leak found: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->mLeakedException:Ljava/lang/RuntimeException;

    invoke-virtual {v2}, Ljava/lang/RuntimeException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    .line 220
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->mLeakedException:Ljava/lang/RuntimeException;

    .line 222
    :cond_0
    return-void
.end method

.method public getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->delegate:Lorg/apache/http/client/HttpClient;

    invoke-interface {v0}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v0

    return-object v0
.end method

.method public getParams()Lorg/apache/http/params/HttpParams;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->delegate:Lorg/apache/http/client/HttpClient;

    invoke-interface {v0}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v0

    return-object v0
.end method

.method public removeRequestInterceptorByClass(Ljava/lang/Class;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<",
            "Lorg/apache/http/client/protocol/RequestAddCookies;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 236
    .local p1, "class1":Ljava/lang/Class;, "Ljava/lang/Class<Lorg/apache/http/client/protocol/RequestAddCookies;>;"
    iget-object v0, p0, Ltv/freewheel/utils/http/SimpleHttpClient;->delegate:Lorg/apache/http/client/HttpClient;

    check-cast v0, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v0, p1}, Lorg/apache/http/impl/client/DefaultHttpClient;->removeRequestInterceptorByClass(Ljava/lang/Class;)V

    .line 237
    return-void
.end method
