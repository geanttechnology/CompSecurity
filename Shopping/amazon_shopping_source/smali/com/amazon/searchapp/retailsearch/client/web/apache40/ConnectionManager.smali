.class public Lcom/amazon/searchapp/retailsearch/client/web/apache40/ConnectionManager;
.super Ljava/lang/Object;
.source "ConnectionManager.java"


# instance fields
.field private final connectionManager:Lorg/apache/http/conn/ClientConnectionManager;

.field private final httpParams:Lorg/apache/http/params/HttpParams;


# direct methods
.method public constructor <init>(I)V
    .locals 1
    .param p1, "maxConnections"    # I

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil;->createHttpParams(I)Lorg/apache/http/params/HttpParams;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ConnectionManager;->httpParams:Lorg/apache/http/params/HttpParams;

    .line 27
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ConnectionManager;->httpParams:Lorg/apache/http/params/HttpParams;

    invoke-static {v0}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil;->createConnectionManager(Lorg/apache/http/params/HttpParams;)Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ConnectionManager;->connectionManager:Lorg/apache/http/conn/ClientConnectionManager;

    .line 28
    return-void
.end method


# virtual methods
.method public createHttpClient()Lorg/apache/http/client/HttpClient;
    .locals 2

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ConnectionManager;->httpParams:Lorg/apache/http/params/HttpParams;

    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ConnectionManager;->connectionManager:Lorg/apache/http/conn/ClientConnectionManager;

    invoke-static {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil;->createHttpClient(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/ClientConnectionManager;)Lorg/apache/http/client/HttpClient;

    move-result-object v0

    return-object v0
.end method
