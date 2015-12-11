.class final Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil$1;
.super Ljava/lang/Object;
.source "ApacheSearchUtil.java"

# interfaces
.implements Lorg/apache/http/HttpRequestInterceptor;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil;->configureClient(Lorg/apache/http/impl/client/AbstractHttpClient;ZILcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$enableGzip:Z

.field final synthetic val$requestHeaders:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;


# direct methods
.method constructor <init>(ZLcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 0

    .prologue
    .line 155
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil$1;->val$enableGzip:Z

    iput-object p2, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil$1;->val$requestHeaders:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public process(Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)V
    .locals 6
    .param p1, "request"    # Lorg/apache/http/HttpRequest;
    .param p2, "context"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/apache/http/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 162
    iget-boolean v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil$1;->val$enableGzip:Z

    if-eqz v4, :cond_0

    const-string/jumbo v4, "Accept-Encoding"

    invoke-interface {p1, v4}, Lorg/apache/http/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 163
    const-string/jumbo v4, "Accept-Encoding"

    const-string/jumbo v5, "gzip"

    invoke-interface {p1, v4, v5}, Lorg/apache/http/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    :cond_0
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil$1;->val$requestHeaders:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    if-eqz v4, :cond_2

    .line 167
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil$1;->val$requestHeaders:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 168
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 169
    .local v3, "val":Ljava/lang/String;
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {p1, v4, v3}, Lorg/apache/http/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 173
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "val":Ljava/lang/String;
    :cond_2
    return-void
.end method
