.class public abstract Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;
.super Ljava/lang/Object;
.source "ServiceCall.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<TResult:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<TTResult;>;"
    }
.end annotation


# instance fields
.field private volatile buildDone:Z

.field private final client:Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;

.field private volatile closed:Z

.field private content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

.field private cookies:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final defaultMethod:Ljava/lang/String;

.field private final defaultPath:Ljava/lang/String;

.field private headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private host:Ljava/lang/String;

.field private final listener:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener",
            "<TTResult;>;"
        }
    .end annotation
.end field

.field private method:Ljava/lang/String;

.field private parameters:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private path:Ljava/lang/String;

.field private port:I

.field private requestUrl:Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

.field private final resultClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TTResult;>;"
        }
    .end annotation
.end field

.field private scheme:Ljava/lang/String;

.field private userAgent:Ljava/lang/String;

.field private userInfo:Ljava/lang/String;

.field private volatile webRequest:Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;


# direct methods
.method protected constructor <init>(Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V
    .locals 1
    .param p1, "client"    # Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;
    .param p3, "defaultMethod"    # Ljava/lang/String;
    .param p4, "defaultPath"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;",
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener",
            "<TTResult;>;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<TTResult;>;)V"
        }
    .end annotation

    .prologue
    .line 92
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    .local p2, "listener":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener<TTResult;>;"
    .local p5, "resultClass":Ljava/lang/Class;, "Ljava/lang/Class<TTResult;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->port:I

    .line 56
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-direct {v0}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->parameters:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    .line 62
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-direct {v0}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->cookies:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    .line 65
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-direct {v0}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    .line 93
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->client:Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;

    .line 94
    iput-object p2, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->listener:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;

    .line 95
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->defaultMethod:Ljava/lang/String;

    .line 96
    iput-object p4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->defaultPath:Ljava/lang/String;

    .line 97
    iput-object p5, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->resultClass:Ljava/lang/Class;

    .line 98
    return-void
.end method

.method private applyUrl(Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;)V
    .locals 2
    .param p1, "url"    # Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    .prologue
    .line 588
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->scheme:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 589
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->getScheme()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->scheme:Ljava/lang/String;

    .line 592
    :cond_0
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->userInfo:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 593
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->getUserInfo()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->userInfo:Ljava/lang/String;

    .line 596
    :cond_1
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->host:Ljava/lang/String;

    if-nez v0, :cond_2

    .line 597
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->getHost()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->host:Ljava/lang/String;

    .line 600
    :cond_2
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->port:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_3

    .line 601
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->getPort()I

    move-result v0

    iput v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->port:I

    .line 604
    :cond_3
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->path:Ljava/lang/String;

    if-nez v0, :cond_4

    .line 605
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->getPath()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->path:Ljava/lang/String;

    .line 608
    :cond_4
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->parameters:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->getQuery()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->setDefault(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 609
    return-void
.end method

.method private applyUrl(Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 576
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    :try_start_0
    new-instance v1, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    invoke-direct {v1, p1}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->applyUrl(Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 580
    return-void

    .line 577
    :catch_0
    move-exception v0

    .line 578
    .local v0, "e":Ljava/net/URISyntaxException;
    new-instance v1, Ljava/io/IOException;

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method


# virtual methods
.method public final build()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 388
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    monitor-enter p0

    .line 389
    :try_start_0
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildDone:Z

    if-nez v0, :cond_0

    .line 390
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildServiceCall()V

    .line 391
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildDone:Z

    .line 393
    :cond_0
    monitor-exit p0

    .line 394
    return-void

    .line 393
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method protected buildBaseUrl()Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 478
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->client:Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->getBaseUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected buildContent()Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;
    .locals 1

    .prologue
    .line 565
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method protected buildCookies(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 549
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    .local p1, "cookies":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    return-void
.end method

.method protected buildHeaders(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 557
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    .local p1, "headers":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    return-void
.end method

.method protected buildHost()Ljava/lang/String;
    .locals 1

    .prologue
    .line 505
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method protected buildMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 469
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method protected buildParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 532
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    .local p1, "parameters":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    return-void
.end method

.method protected buildPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 523
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method protected buildPort()I
    .locals 1

    .prologue
    .line 514
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    const/4 v0, -0x1

    return v0
.end method

.method public buildRequestUrl()Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;
    .locals 2

    .prologue
    .line 617
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    invoke-direct {v0}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;-><init>()V

    .line 618
    .local v0, "url":Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->scheme:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->setScheme(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    .line 619
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->userInfo:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->setUserInfo(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    .line 620
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->host:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->setHost(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    .line 621
    iget v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->port:I

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->setPort(I)Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    .line 622
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->path:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->setPath(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    .line 623
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->parameters:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->setQuery(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    .line 624
    return-object v0
.end method

.method protected buildScheme()Ljava/lang/String;
    .locals 1

    .prologue
    .line 487
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method protected buildServiceCall()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 402
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->method:Ljava/lang/String;

    if-nez v4, :cond_0

    .line 403
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildMethod()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->method:Ljava/lang/String;

    .line 405
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->method:Ljava/lang/String;

    if-nez v4, :cond_0

    .line 406
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->defaultMethod:Ljava/lang/String;

    iput-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->method:Ljava/lang/String;

    .line 410
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildBaseUrl()Ljava/lang/String;

    move-result-object v0

    .line 412
    .local v0, "baseUrl":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 413
    invoke-direct {p0, v0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->applyUrl(Ljava/lang/String;)V

    .line 416
    :cond_1
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->scheme:Ljava/lang/String;

    if-nez v4, :cond_2

    .line 417
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildScheme()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->scheme:Ljava/lang/String;

    .line 420
    :cond_2
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->userInfo:Ljava/lang/String;

    if-nez v4, :cond_3

    .line 421
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildUserInfo()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->userInfo:Ljava/lang/String;

    .line 424
    :cond_3
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->host:Ljava/lang/String;

    if-nez v4, :cond_4

    .line 425
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildHost()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->host:Ljava/lang/String;

    .line 428
    :cond_4
    iget v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->port:I

    const/4 v5, -0x1

    if-ne v4, v5, :cond_5

    .line 429
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildPort()I

    move-result v4

    iput v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->port:I

    .line 432
    :cond_5
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->path:Ljava/lang/String;

    if-nez v4, :cond_6

    .line 433
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildPath()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->path:Ljava/lang/String;

    .line 435
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->path:Ljava/lang/String;

    if-nez v4, :cond_6

    .line 436
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->defaultPath:Ljava/lang/String;

    iput-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->path:Ljava/lang/String;

    .line 440
    :cond_6
    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;-><init>()V

    .line 441
    .local v3, "requestParameters":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0, v3}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 442
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->client:Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;

    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->getParameters()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->parameters:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-static {v4, v3, v5}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->merge(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->parameters:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    .line 444
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->userAgent:Ljava/lang/String;

    if-nez v4, :cond_7

    .line 445
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildUserAgent()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->userAgent:Ljava/lang/String;

    .line 447
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->userAgent:Ljava/lang/String;

    if-nez v4, :cond_7

    .line 448
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->getClient()Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->getUserAgent()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->userAgent:Ljava/lang/String;

    .line 452
    :cond_7
    new-instance v1, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-direct {v1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;-><init>()V

    .line 453
    .local v1, "requestCookies":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildCookies(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 454
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->client:Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;

    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->getCookies()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->cookies:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-static {v4, v1, v5}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->merge(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->cookies:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    .line 456
    new-instance v2, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-direct {v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;-><init>()V

    .line 457
    .local v2, "requestHeaders":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0, v2}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildHeaders(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 458
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->client:Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;

    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->getHeaders()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-static {v4, v2, v5}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->merge(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    .line 460
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildContent()Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    .line 461
    return-void
.end method

.method protected buildUserAgent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 540
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method protected buildUserInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 496
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method protected buildWebRequest()Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 634
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;

    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->client:Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->getWebClient()Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;-><init>(Lcom/amazon/searchapp/retailsearch/client/web/WebClient;)V

    .line 635
    .local v0, "request":Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->method:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->setMethod(Ljava/lang/String;)V

    .line 637
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildRequestUrl()Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->requestUrl:Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    .line 638
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->requestUrl:Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->build()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->setUrl(Ljava/lang/String;)V

    .line 640
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->userAgent:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;->USER_AGENT:Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 641
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;->USER_AGENT:Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->userAgent:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 644
    :cond_0
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->cookies:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;->COOKIE:Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 645
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;->COOKIE:Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->cookies:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-static {v3}, Lcom/amazon/searchapp/retailsearch/client/web/CookieUtil;->createRequestHeader(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 648
    :cond_1
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->setHeaders(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 649
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->content:Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->setContent(Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;)V

    .line 651
    return-object v0
.end method

.method public call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TTResult;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 379
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->execute()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final execute()Ljava/lang/Object;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TTResult;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    const/4 v8, 0x1

    .line 322
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->onBeginRequest()V

    .line 324
    monitor-enter p0
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 325
    :try_start_1
    iget-boolean v6, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->closed:Z

    if-nez v6, :cond_1

    .line 326
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->build()V

    .line 328
    iget-object v6, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->client:Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;

    invoke-virtual {v6}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->getServiceCallInterceptor()Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

    move-result-object v6

    if-eqz v6, :cond_0

    .line 329
    iget-object v6, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->client:Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;

    invoke-virtual {v6}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->getServiceCallInterceptor()Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

    move-result-object v6

    invoke-interface {v6, p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;->process(Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;)V

    .line 332
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->buildWebRequest()Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;

    move-result-object v6

    iput-object v6, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->webRequest:Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;

    .line 334
    :cond_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 336
    const/4 v3, 0x0

    .line 338
    .local v3, "result":Ljava/lang/Object;, "TTResult;"
    :try_start_2
    iget-boolean v6, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->closed:Z

    if-nez v6, :cond_2

    iget-object v6, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->webRequest:Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;

    if-eqz v6, :cond_2

    .line 339
    iget-object v6, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->webRequest:Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;

    invoke-virtual {v6}, Lcom/amazon/searchapp/retailsearch/client/web/WebRequest;->getResponse()Lcom/amazon/searchapp/retailsearch/client/web/WebResponse;

    move-result-object v5

    .line 340
    .local v5, "webResponse":Lcom/amazon/searchapp/retailsearch/client/web/WebResponse;
    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/client/web/WebResponse;->getContent()Ljava/io/InputStream;
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v2

    .line 343
    .local v2, "responseContent":Ljava/io/InputStream;
    :try_start_3
    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/client/web/WebResponse;->getStatusCode()I

    move-result v6

    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/client/web/WebResponse;->getStatusLine()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p0, v6, v7, v2}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->readResponse(ILjava/lang/String;Ljava/io/InputStream;)Ljava/lang/Object;

    move-result-object v3

    .line 346
    invoke-virtual {p0, v3}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->onResult(Ljava/lang/Object;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 348
    if-eqz v2, :cond_2

    .line 349
    :try_start_4
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 367
    .end local v2    # "responseContent":Ljava/io/InputStream;
    .end local v3    # "result":Ljava/lang/Object;, "TTResult;"
    .end local v5    # "webResponse":Lcom/amazon/searchapp/retailsearch/client/web/WebResponse;
    :cond_2
    iput-boolean v8, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->closed:Z

    .line 368
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->onEndRequest()V

    return-object v3

    .line 334
    :catchall_0
    move-exception v6

    :try_start_5
    monitor-exit p0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    :try_start_6
    throw v6
    :try_end_6
    .catch Ljava/lang/Throwable; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 355
    :catch_0
    move-exception v4

    .line 358
    .local v4, "throwable":Ljava/lang/Throwable;
    :try_start_7
    instance-of v6, v4, Ljava/io/IOException;

    if-eqz v6, :cond_4

    .line 359
    move-object v0, v4

    check-cast v0, Ljava/io/IOException;

    move-object v1, v0

    .line 364
    .local v1, "error":Ljava/io/IOException;
    :goto_0
    invoke-virtual {p0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->onRequestError(Ljava/lang/Exception;)V

    .line 365
    throw v1
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 367
    .end local v1    # "error":Ljava/io/IOException;
    .end local v4    # "throwable":Ljava/lang/Throwable;
    :catchall_1
    move-exception v6

    iput-boolean v8, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->closed:Z

    .line 368
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->onEndRequest()V

    throw v6

    .line 348
    .restart local v2    # "responseContent":Ljava/io/InputStream;
    .restart local v5    # "webResponse":Lcom/amazon/searchapp/retailsearch/client/web/WebResponse;
    :catchall_2
    move-exception v6

    if-eqz v2, :cond_3

    .line 349
    :try_start_8
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    :cond_3
    throw v6
    :try_end_8
    .catch Ljava/lang/Throwable; {:try_start_8 .. :try_end_8} :catch_0
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    .line 361
    .end local v2    # "responseContent":Ljava/io/InputStream;
    .end local v5    # "webResponse":Lcom/amazon/searchapp/retailsearch/client/web/WebResponse;
    .restart local v4    # "throwable":Ljava/lang/Throwable;
    :cond_4
    :try_start_9
    new-instance v1, Ljava/io/IOException;

    invoke-direct {v1, v4}, Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    .restart local v1    # "error":Ljava/io/IOException;
    goto :goto_0
.end method

.method protected getClient()Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;
    .locals 1

    .prologue
    .line 106
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->client:Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;

    return-object v0
.end method

.method public final getCookies()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 277
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->cookies:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    return-object v0
.end method

.method protected getDefaultPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 133
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->defaultPath:Ljava/lang/String;

    return-object v0
.end method

.method public final getHeaders()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 293
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    return-object v0
.end method

.method public getHost()Ljava/lang/String;
    .locals 1

    .prologue
    .line 227
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->host:Ljava/lang/String;

    return-object v0
.end method

.method protected getListener()Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener",
            "<TTResult;>;"
        }
    .end annotation

    .prologue
    .line 115
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->listener:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;

    return-object v0
.end method

.method public final getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->method:Ljava/lang/String;

    return-object v0
.end method

.method public final getParameters()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 243
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->parameters:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    return-object v0
.end method

.method public final getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 169
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->path:Ljava/lang/String;

    return-object v0
.end method

.method public getPort()I
    .locals 1

    .prologue
    .line 213
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->port:I

    return v0
.end method

.method public final getRequestUrl()Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;
    .locals 1

    .prologue
    .line 311
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->requestUrl:Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    return-object v0
.end method

.method public getScheme()Ljava/lang/String;
    .locals 1

    .prologue
    .line 185
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->scheme:Ljava/lang/String;

    return-object v0
.end method

.method public getUserInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 199
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->userInfo:Ljava/lang/String;

    return-object v0
.end method

.method protected onBeginRequest()V
    .locals 1

    .prologue
    .line 699
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->listener:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;

    if-eqz v0, :cond_0

    .line 700
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->listener:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;->startRequest()V

    .line 702
    :cond_0
    return-void
.end method

.method protected onEndRequest()V
    .locals 1

    .prologue
    .line 730
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->listener:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;

    if-eqz v0, :cond_0

    .line 731
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->listener:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;->endRequest()V

    .line 733
    :cond_0
    return-void
.end method

.method protected onRequestError(Ljava/lang/Exception;)V
    .locals 1
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 721
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->listener:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;

    if-eqz v0, :cond_0

    .line 722
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->listener:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;

    invoke-interface {v0, p1}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;->error(Ljava/lang/Exception;)V

    .line 724
    :cond_0
    return-void
.end method

.method protected onResult(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TTResult;)V"
        }
    .end annotation

    .prologue
    .line 710
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    .local p1, "result":Ljava/lang/Object;, "TTResult;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->listener:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;

    if-eqz v0, :cond_0

    .line 711
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->listener:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;

    invoke-interface {v0, p1}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;->result(Ljava/lang/Object;)V

    .line 713
    :cond_0
    return-void
.end method

.method protected readResponse(ILjava/lang/String;Ljava/io/InputStream;)Ljava/lang/Object;
    .locals 2
    .param p1, "statusCode"    # I
    .param p2, "statusLine"    # Ljava/lang/String;
    .param p3, "content"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            "Ljava/io/InputStream;",
            ")TTResult;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 665
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<TTResult;>;"
    if-eqz p3, :cond_0

    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->client:Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->getObjectParser()Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->resultClass:Ljava/lang/Class;

    invoke-interface {v0, p3, v1}, Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;->parse(Ljava/io/InputStream;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
