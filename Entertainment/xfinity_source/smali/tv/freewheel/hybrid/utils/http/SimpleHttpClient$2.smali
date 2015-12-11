.class Ltv/freewheel/hybrid/utils/http/SimpleHttpClient$2;
.super Lorg/apache/http/impl/client/DefaultHttpClient;
.source "SimpleHttpClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/utils/http/SimpleHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/utils/http/SimpleHttpClient;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/utils/http/SimpleHttpClient;Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    .locals 0
    .param p2, "x0"    # Lorg/apache/http/conn/ClientConnectionManager;
    .param p3, "x1"    # Lorg/apache/http/params/HttpParams;

    .prologue
    .line 112
    iput-object p1, p0, Ltv/freewheel/hybrid/utils/http/SimpleHttpClient$2;->this$0:Ltv/freewheel/hybrid/utils/http/SimpleHttpClient;

    invoke-direct {p0, p2, p3}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V

    return-void
.end method


# virtual methods
.method protected createHttpContext()Lorg/apache/http/protocol/HttpContext;
    .locals 3

    .prologue
    .line 126
    new-instance v0, Lorg/apache/http/protocol/BasicHttpContext;

    invoke-direct {v0}, Lorg/apache/http/protocol/BasicHttpContext;-><init>()V

    .line 127
    .local v0, "context":Lorg/apache/http/protocol/HttpContext;
    const-string v1, "http.authscheme-registry"

    invoke-virtual {p0}, Ltv/freewheel/hybrid/utils/http/SimpleHttpClient$2;->getAuthSchemes()Lorg/apache/http/auth/AuthSchemeRegistry;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lorg/apache/http/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 128
    const-string v1, "http.cookiespec-registry"

    invoke-virtual {p0}, Ltv/freewheel/hybrid/utils/http/SimpleHttpClient$2;->getCookieSpecs()Lorg/apache/http/cookie/CookieSpecRegistry;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lorg/apache/http/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 129
    const-string v1, "http.auth.credentials-provider"

    invoke-virtual {p0}, Ltv/freewheel/hybrid/utils/http/SimpleHttpClient$2;->getCredentialsProvider()Lorg/apache/http/client/CredentialsProvider;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lorg/apache/http/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 130
    return-object v0
.end method

.method protected createHttpProcessor()Lorg/apache/http/protocol/BasicHttpProcessor;
    .locals 2

    .prologue
    .line 116
    invoke-super {p0}, Lorg/apache/http/impl/client/DefaultHttpClient;->createHttpProcessor()Lorg/apache/http/protocol/BasicHttpProcessor;

    move-result-object v0

    .line 117
    .local v0, "processor":Lorg/apache/http/protocol/BasicHttpProcessor;
    # getter for: Ltv/freewheel/hybrid/utils/http/SimpleHttpClient;->sThreadCheckInterceptor:Lorg/apache/http/HttpRequestInterceptor;
    invoke-static {}, Ltv/freewheel/hybrid/utils/http/SimpleHttpClient;->access$100()Lorg/apache/http/HttpRequestInterceptor;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/apache/http/protocol/BasicHttpProcessor;->addRequestInterceptor(Lorg/apache/http/HttpRequestInterceptor;)V

    .line 119
    return-object v0
.end method
