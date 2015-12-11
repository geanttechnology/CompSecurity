.class public Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebClient;
.super Ljava/lang/Object;
.source "ApacheWebClient.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/web/WebClient;


# static fields
.field private static defaultConnectionManager:Lcom/amazon/searchapp/retailsearch/client/web/apache40/ConnectionManager;


# instance fields
.field private final client:Lorg/apache/http/client/HttpClient;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 44
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebClient;->getDefaultConnectionManager()Lcom/amazon/searchapp/retailsearch/client/web/apache40/ConnectionManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ConnectionManager;->createHttpClient()Lorg/apache/http/client/HttpClient;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebClient;-><init>(Lorg/apache/http/client/HttpClient;)V

    .line 45
    return-void
.end method

.method public constructor <init>(Lorg/apache/http/client/HttpClient;)V
    .locals 0
    .param p1, "client"    # Lorg/apache/http/client/HttpClient;

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebClient;->client:Lorg/apache/http/client/HttpClient;

    .line 54
    return-void
.end method

.method public static declared-synchronized getDefaultConnectionManager()Lcom/amazon/searchapp/retailsearch/client/web/apache40/ConnectionManager;
    .locals 3

    .prologue
    .line 106
    const-class v1, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebClient;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebClient;->defaultConnectionManager:Lcom/amazon/searchapp/retailsearch/client/web/apache40/ConnectionManager;

    if-nez v0, :cond_0

    .line 107
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ConnectionManager;

    const/16 v2, 0xa

    invoke-direct {v0, v2}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ConnectionManager;-><init>(I)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebClient;->defaultConnectionManager:Lcom/amazon/searchapp/retailsearch/client/web/apache40/ConnectionManager;

    .line 110
    :cond_0
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebClient;->defaultConnectionManager:Lcom/amazon/searchapp/retailsearch/client/web/apache40/ConnectionManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 106
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public createConnection(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;)Lcom/amazon/searchapp/retailsearch/client/web/WebConnection;
    .locals 8
    .param p1, "method"    # Ljava/lang/String;
    .param p2, "url"    # Ljava/lang/String;
    .param p4, "content"    # Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;",
            ")",
            "Lcom/amazon/searchapp/retailsearch/client/web/WebConnection;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 62
    .local p3, "headers":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v4, 0x0

    .line 64
    .local v4, "request":Lorg/apache/http/client/methods/HttpRequestBase;
    sget-object v6, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->DELETE:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v6}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 65
    new-instance v4, Lorg/apache/http/client/methods/HttpDelete;

    .end local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    invoke-direct {v4, p2}, Lorg/apache/http/client/methods/HttpDelete;-><init>(Ljava/lang/String;)V

    .line 82
    .restart local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    :goto_0
    invoke-virtual {p3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_8

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 83
    .local v1, "header":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v4, v6}, Lorg/apache/http/client/methods/HttpRequestBase;->removeHeaders(Ljava/lang/String;)V

    .line 85
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 86
    .local v5, "val":Ljava/lang/String;
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v4, v6, v5}, Lorg/apache/http/client/methods/HttpRequestBase;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 66
    .end local v1    # "header":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v5    # "val":Ljava/lang/String;
    :cond_1
    sget-object v6, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->GET:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v6}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 67
    new-instance v4, Lorg/apache/http/client/methods/HttpGet;

    .end local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    invoke-direct {v4, p2}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .restart local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    goto :goto_0

    .line 68
    :cond_2
    sget-object v6, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->HEAD:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v6}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 69
    new-instance v4, Lorg/apache/http/client/methods/HttpHead;

    .end local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    invoke-direct {v4, p2}, Lorg/apache/http/client/methods/HttpHead;-><init>(Ljava/lang/String;)V

    .restart local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    goto :goto_0

    .line 70
    :cond_3
    sget-object v6, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->OPTIONS:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v6}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 71
    new-instance v4, Lorg/apache/http/client/methods/HttpOptions;

    .end local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    invoke-direct {v4, p2}, Lorg/apache/http/client/methods/HttpOptions;-><init>(Ljava/lang/String;)V

    .restart local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    goto :goto_0

    .line 72
    :cond_4
    sget-object v6, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->POST:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v6}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 73
    new-instance v4, Lorg/apache/http/client/methods/HttpPost;

    .end local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    invoke-direct {v4, p2}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .restart local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    goto/16 :goto_0

    .line 74
    :cond_5
    sget-object v6, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->PUT:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v6}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 75
    new-instance v4, Lorg/apache/http/client/methods/HttpPut;

    .end local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    invoke-direct {v4, p2}, Lorg/apache/http/client/methods/HttpPut;-><init>(Ljava/lang/String;)V

    .restart local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    goto/16 :goto_0

    .line 76
    :cond_6
    sget-object v6, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->TRACE:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v6}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_7

    .line 77
    new-instance v4, Lorg/apache/http/client/methods/HttpTrace;

    .end local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    invoke-direct {v4, p2}, Lorg/apache/http/client/methods/HttpTrace;-><init>(Ljava/lang/String;)V

    .restart local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    goto/16 :goto_0

    .line 79
    :cond_7
    new-instance v4, Lcom/amazon/searchapp/retailsearch/client/web/apache40/CustomHttpMethod;

    .end local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    invoke-direct {v4, p1, p2}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/CustomHttpMethod;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .restart local v4    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    goto/16 :goto_0

    .line 90
    :cond_8
    if-eqz p4, :cond_a

    .line 91
    instance-of v6, v4, Lorg/apache/http/HttpEntityEnclosingRequest;

    if-nez v6, :cond_9

    .line 92
    new-instance v6, Ljava/io/IOException;

    const-string/jumbo v7, "Content not supported by request method"

    invoke-direct {v6, v7}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 95
    :cond_9
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/StreamableEntity;

    invoke-direct {v0, p4}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/StreamableEntity;-><init>(Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;)V

    .local v0, "entity":Lcom/amazon/searchapp/retailsearch/client/web/apache40/StreamableEntity;
    move-object v6, v4

    .line 96
    check-cast v6, Lorg/apache/http/HttpEntityEnclosingRequest;

    invoke-interface {v6, v0}, Lorg/apache/http/HttpEntityEnclosingRequest;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 99
    .end local v0    # "entity":Lcom/amazon/searchapp/retailsearch/client/web/apache40/StreamableEntity;
    :cond_a
    new-instance v6, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebConnection;

    iget-object v7, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebClient;->client:Lorg/apache/http/client/HttpClient;

    invoke-direct {v6, v7, v4}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebConnection;-><init>(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpRequestBase;)V

    return-object v6
.end method
